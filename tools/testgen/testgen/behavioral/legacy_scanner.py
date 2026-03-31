"""Legacy scanner — parses JBoss Fuse / Camel projects for route correlation.

Extracts Camel route definitions, blueprint bean configs, and processor
references to enable behavioral comparison with Spring Boot implementation.
"""

from __future__ import annotations

import logging
import re
import xml.etree.ElementTree as ET
from dataclasses import dataclass, field
from pathlib import Path

logger = logging.getLogger(__name__)

_CAMEL_NS = "http://camel.apache.org/schema/blueprint"
_BLUEPRINT_NS = "http://www.osgi.org/xmlns/blueprint/v1.0.0"


@dataclass(frozen=True, slots=True)
class CamelRoute:
    """A single Camel route extracted from XML."""
    route_id: str
    from_uri: str
    steps: tuple[str, ...] = ()       # e.g. ("bean:myServiceClient", "to:direct:...")
    processors: tuple[str, ...] = ()   # bean references
    error_handlers: tuple[str, ...] = ()


@dataclass(frozen=True, slots=True)
class BlueprintBean:
    """A bean declaration from blueprint XML."""
    bean_id: str
    class_name: str
    properties: dict[str, str] = field(default_factory=dict)


@dataclass(slots=True)
class LegacyProjectInfo:
    """Aggregated info from a legacy JBoss Fuse project."""
    project_path: str = ""
    routes: list[CamelRoute] = field(default_factory=list)
    beans: list[BlueprintBean] = field(default_factory=list)
    config_properties: dict[str, str] = field(default_factory=dict)
    pom_dependencies: dict[str, str] = field(default_factory=dict)


def scan_legacy(legacy_path: str | Path) -> LegacyProjectInfo:
    """Scan a legacy JBoss Fuse project and extract structure."""
    root = Path(legacy_path)
    info = LegacyProjectInfo(project_path=str(root))

    # Find the project root (may be nested)
    project_dir = _find_project_root(root)
    if not project_dir:
        logger.warning("No Maven project found in %s", root)
        return info

    # 1. Parse blueprint/Camel XML files
    resources = project_dir / "src" / "main" / "resources"
    if resources.is_dir():
        for xml_file in resources.rglob("*.xml"):
            try:
                _parse_xml_config(xml_file, info)
            except ET.ParseError as e:
                logger.debug("Skipping %s: %s", xml_file.name, e)

    # 2. Parse .cfg property files
    for cfg_file in resources.rglob("*.cfg") if resources.is_dir() else []:
        _parse_cfg(cfg_file, info)

    # 3. Parse POM for dependency versions
    pom = project_dir / "pom.xml"
    if pom.is_file():
        _parse_legacy_pom(pom, info)

    logger.info(
        "Legacy scan: %d routes, %d beans, %d config properties",
        len(info.routes), len(info.beans), len(info.config_properties),
    )
    return info


def _find_project_root(path: Path) -> Path | None:
    """Find the Maven project root (directory containing pom.xml)."""
    if (path / "pom.xml").is_file():
        return path
    for child in path.iterdir():
        if child.is_dir() and (child / "pom.xml").is_file():
            return child
    return None


def _parse_xml_config(xml_file: Path, info: LegacyProjectInfo) -> None:
    """Parse a blueprint/Camel XML file for routes and beans."""
    tree = ET.parse(str(xml_file))
    root = tree.getroot()

    ns = _detect_ns(root)

    # Parse Camel routes
    for route_elem in root.iter():
        if _local_tag(route_elem.tag) == "route":
            route = _parse_route(route_elem)
            if route:
                info.routes.append(route)

    # Parse bean declarations
    for bean_elem in root.iter():
        tag = _local_tag(bean_elem.tag)
        if tag == "bean":
            bean = _parse_bean(bean_elem)
            if bean:
                info.beans.append(bean)


def _parse_route(route_elem: ET.Element) -> CamelRoute | None:
    route_id = route_elem.get("id", "")

    from_uri = ""
    steps: list[str] = []
    processors: list[str] = []
    error_handlers: list[str] = []

    for child in route_elem.iter():
        tag = _local_tag(child.tag)

        if tag == "from":
            from_uri = child.get("uri", "")

        elif tag == "to":
            uri = child.get("uri", "")
            steps.append(f"to:{uri}")

        elif tag == "bean":
            ref = child.get("ref", child.get("beanType", ""))
            method = child.get("method", "")
            label = f"bean:{ref}"
            if method:
                label += f".{method}"
            steps.append(label)
            if ref:
                processors.append(ref)

        elif tag == "wireTap":
            uri = child.get("uri", "")
            steps.append(f"wireTap:{uri}")

        elif tag in ("doCatch", "onException"):
            error_handlers.append(tag)

        elif tag == "setProperty":
            prop_name = child.get("propertyName", "")
            for const in child.iter():
                if _local_tag(const.tag) == "constant":
                    steps.append(f"setProperty:{prop_name}={const.text or ''}")

    if not from_uri and not steps:
        return None

    return CamelRoute(
        route_id=route_id,
        from_uri=from_uri,
        steps=tuple(steps),
        processors=tuple(set(processors)),
        error_handlers=tuple(error_handlers),
    )


def _parse_bean(bean_elem: ET.Element) -> BlueprintBean | None:
    bean_id = bean_elem.get("id", "")
    class_name = bean_elem.get("class", "")
    if not bean_id and not class_name:
        return None

    props: dict[str, str] = {}
    for child in bean_elem:
        if _local_tag(child.tag) == "property":
            name = child.get("name", "")
            value = child.get("value", child.get("ref", ""))
            if name:
                props[name] = value

    return BlueprintBean(bean_id=bean_id, class_name=class_name, properties=props)


def _parse_cfg(cfg_file: Path, info: LegacyProjectInfo) -> None:
    """Parse a .cfg property file."""
    try:
        for line in cfg_file.read_text(encoding="utf-8", errors="replace").splitlines():
            line = line.strip()
            if not line or line.startswith("#"):
                continue
            if "=" in line:
                key, _, value = line.partition("=")
                info.config_properties[key.strip()] = value.strip()
    except OSError:
        pass


def _parse_legacy_pom(pom: Path, info: LegacyProjectInfo) -> None:
    """Extract key dependency versions from legacy POM."""
    try:
        tree = ET.parse(str(pom))
        root = tree.getroot()
        ns = _detect_ns(root)

        # Parse properties (version variables)
        props = root.find(f"{ns}properties")
        if props is not None:
            for child in props:
                tag = _local_tag(child.tag)
                if child.text:
                    info.pom_dependencies[tag] = child.text.strip()
    except ET.ParseError:
        pass


def _detect_ns(root: ET.Element) -> str:
    if root.tag.startswith("{"):
        return root.tag.split("}")[0] + "}"
    return ""


def _local_tag(tag: str) -> str:
    if "}" in tag:
        return tag.split("}", 1)[1]
    return tag
