"""XML-based POM manager.

Uses xml.etree.ElementTree (not string replacement) for safe POM modifications.
This eliminates the v1 bug where string-based POM editing was fragile.
"""

from __future__ import annotations

import copy
import logging
import xml.etree.ElementTree as ET
from pathlib import Path

logger = logging.getLogger(__name__)

# Maven namespace
_NS = "http://maven.apache.org/POM/4.0.0"
_NS_MAP = {"": _NS}

# Surefire argLine for JDK 16+ (ByteBuddy fix)
_SUREFIRE_ARGLINE = (
    "--add-opens java.base/java.lang=ALL-UNNAMED "
    "--add-opens java.base/java.lang.reflect=ALL-UNNAMED "
    "-XX:+EnableDynamicAgentLoading "
    "-Xmx1024m"
)


def fix_pom(project_path: str | Path) -> list[str]:
    """Apply all necessary POM changes. Returns list of actions taken."""
    pom_path = Path(project_path) / "pom.xml"
    if not pom_path.is_file():
        return ["ERROR: pom.xml not found"]

    # Register namespace to preserve formatting
    ET.register_namespace("", _NS)

    tree = ET.parse(pom_path)
    root = tree.getroot()
    ns = _detect_namespace(root)
    actions: list[str] = []

    # 1. Ensure <build><plugins> exists
    build = root.find(f"{ns}build")
    if build is None:
        build = ET.SubElement(root, f"{ns}build")
    plugins = build.find(f"{ns}plugins")
    if plugins is None:
        plugins = ET.SubElement(build, f"{ns}plugins")

    # 2. Add or update maven-surefire-plugin
    surefire = _find_plugin(plugins, ns, "maven-surefire-plugin")
    if surefire is None:
        surefire = _create_surefire_plugin(plugins, ns)
        actions.append("Added maven-surefire-plugin with argLine and excludes")
    else:
        _update_surefire_config(surefire, ns)
        actions.append("Updated maven-surefire-plugin argLine and excludes")

    # 3. Ensure WireMock dependency
    deps = root.find(f"{ns}dependencies")
    if deps is None:
        deps = ET.SubElement(root, f"{ns}dependencies")
    if not _has_dependency(deps, ns, "wiremock"):
        _add_dependency(deps, ns, "org.wiremock", "wiremock-standalone", "3.3.1", "test")
        actions.append("Added WireMock dependency (3.3.1, test scope)")

    # 4. Write back
    _indent_xml(root)
    tree.write(str(pom_path), xml_declaration=True, encoding="UTF-8")
    return actions


def _detect_namespace(root: ET.Element) -> str:
    if root.tag.startswith("{"):
        return root.tag.split("}")[0] + "}"
    return ""


def _find_plugin(plugins: ET.Element, ns: str, artifact_id: str) -> ET.Element | None:
    for plugin in plugins.findall(f"{ns}plugin"):
        aid = plugin.findtext(f"{ns}artifactId")
        if aid == artifact_id:
            return plugin
    return None


def _create_surefire_plugin(plugins: ET.Element, ns: str) -> ET.Element:
    plugin = ET.SubElement(plugins, f"{ns}plugin")
    gid = ET.SubElement(plugin, f"{ns}groupId")
    gid.text = "org.apache.maven.plugins"
    aid = ET.SubElement(plugin, f"{ns}artifactId")
    aid.text = "maven-surefire-plugin"
    ver = ET.SubElement(plugin, f"{ns}version")
    ver.text = "3.2.5"

    config = ET.SubElement(plugin, f"{ns}configuration")
    argline = ET.SubElement(config, f"{ns}argLine")
    argline.text = _SUREFIRE_ARGLINE
    excludes = ET.SubElement(config, f"{ns}excludes")
    exclude = ET.SubElement(excludes, f"{ns}exclude")
    exclude.text = "**/*IntegrationAutoTest.java"
    return plugin


def _update_surefire_config(plugin: ET.Element, ns: str) -> None:
    config = plugin.find(f"{ns}configuration")
    if config is None:
        config = ET.SubElement(plugin, f"{ns}configuration")

    argline = config.find(f"{ns}argLine")
    if argline is None:
        argline = ET.SubElement(config, f"{ns}argLine")
    existing = (argline.text or "").strip()
    if not existing:
        argline.text = _SUREFIRE_ARGLINE
    else:
        # Merge required flags into existing argLine (preserve service-specific flags)
        if "--add-opens" not in existing:
            existing = existing + " --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.lang.reflect=ALL-UNNAMED"
        if "EnableDynamicAgentLoading" not in existing:
            existing = existing + " -XX:+EnableDynamicAgentLoading"
        argline.text = existing

    excludes = config.find(f"{ns}excludes")
    if excludes is None:
        excludes = ET.SubElement(config, f"{ns}excludes")
        exclude = ET.SubElement(excludes, f"{ns}exclude")
        exclude.text = "**/*IntegrationAutoTest.java"


def _has_dependency(deps: ET.Element, ns: str, keyword: str) -> bool:
    for dep in deps.findall(f"{ns}dependency"):
        aid = dep.findtext(f"{ns}artifactId") or ""
        if keyword.lower() in aid.lower():
            return True
    return False


def _add_dependency(deps: ET.Element, ns: str,
                    group_id: str, artifact_id: str,
                    version: str, scope: str) -> None:
    dep = ET.SubElement(deps, f"{ns}dependency")
    gid = ET.SubElement(dep, f"{ns}groupId")
    gid.text = group_id
    aid = ET.SubElement(dep, f"{ns}artifactId")
    aid.text = artifact_id
    ver = ET.SubElement(dep, f"{ns}version")
    ver.text = version
    sc = ET.SubElement(dep, f"{ns}scope")
    sc.text = scope


def _indent_xml(elem: ET.Element, level: int = 0) -> None:
    """Add pretty-print indentation to an XML tree."""
    indent = "\n" + "    " * level
    if len(elem):
        if not elem.text or not elem.text.strip():
            elem.text = indent + "    "
        if not elem.tail or not elem.tail.strip():
            elem.tail = indent
        for child in elem:
            _indent_xml(child, level + 1)
        if not child.tail or not child.tail.strip():
            child.tail = indent
    else:
        if level and (not elem.tail or not elem.tail.strip()):
            elem.tail = indent
