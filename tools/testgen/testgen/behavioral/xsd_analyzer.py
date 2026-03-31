"""XSD schema analyzer — parses XSD files into typed models.

Extracts complexTypes, simpleType enumerations, and root elements
to enable automatic test payload generation.
"""

from __future__ import annotations

import logging
import xml.etree.ElementTree as ET
from pathlib import Path

from ..models import XsdComplexType, XsdEnumType, XsdSchema, XsdTypeField

logger = logging.getLogger(__name__)

_XS = "http://www.w3.org/2001/XMLSchema"


def parse_xsd(path: str | Path) -> XsdSchema:
    """Parse a single XSD file and return a structured XsdSchema."""
    path = Path(path)
    tree = ET.parse(str(path))
    root = tree.getroot()

    target_ns = root.get("targetNamespace", "")
    ns_map = _build_ns_map(root)

    complex_types: list[XsdComplexType] = []
    enum_types: list[XsdEnumType] = []
    root_elements: dict[str, str] = {}

    for elem in root:
        tag = _local_tag(elem.tag)

        if tag == "complexType":
            ct = _parse_complex_type(elem, target_ns, ns_map)
            if ct:
                complex_types.append(ct)

        elif tag == "simpleType":
            et = _parse_enum_type(elem, target_ns)
            if et:
                enum_types.append(et)

        elif tag == "element":
            name = elem.get("name", "")
            type_attr = elem.get("type", "")
            if name and type_attr:
                root_elements[name] = _strip_ns_prefix(type_attr)

    logger.info(
        "Parsed XSD %s: %d complex types, %d enums, %d root elements",
        path.name, len(complex_types), len(enum_types), len(root_elements),
    )
    return XsdSchema(
        target_namespace=target_ns,
        complex_types=tuple(complex_types),
        enum_types=tuple(enum_types),
        root_elements=root_elements,
    )


def parse_xsd_directory(xsd_dir: str | Path) -> list[XsdSchema]:
    """Parse all .xsd files in a directory."""
    xsd_dir = Path(xsd_dir)
    schemas: list[XsdSchema] = []
    for xsd_file in sorted(xsd_dir.glob("*.xsd")):
        try:
            schemas.append(parse_xsd(xsd_file))
        except ET.ParseError as e:
            logger.warning("Failed to parse %s: %s", xsd_file.name, e)
    return schemas


# ── Internal helpers ─────────────────────────────────────────

def _parse_complex_type(
    elem: ET.Element, namespace: str, ns_map: dict[str, str],
) -> XsdComplexType | None:
    name = elem.get("name")
    if not name:
        return None

    fields: list[XsdTypeField] = []
    seq = elem.find(f"{{{_XS}}}sequence")
    if seq is None:
        # Try xs: prefix form
        seq = elem.find("sequence")
    if seq is not None:
        for child in seq:
            if _local_tag(child.tag) == "element":
                field_name = child.get("name", "")
                field_type = child.get("type", "xs:string")
                min_occurs = int(child.get("minOccurs", "1"))
                nillable = child.get("nillable", "false").lower() == "true"
                fields.append(XsdTypeField(
                    name=field_name,
                    xsd_type=field_type,
                    min_occurs=min_occurs,
                    nillable=nillable,
                ))

    return XsdComplexType(name=name, namespace=namespace, fields=tuple(fields))


def _parse_enum_type(elem: ET.Element, namespace: str) -> XsdEnumType | None:
    name = elem.get("name")
    if not name:
        return None

    restriction = elem.find(f"{{{_XS}}}restriction")
    if restriction is None:
        return None

    values: list[str] = []
    for child in restriction:
        if _local_tag(child.tag) == "enumeration":
            val = child.get("value")
            if val:
                values.append(val)

    if not values:
        return None

    return XsdEnumType(name=name, namespace=namespace, values=tuple(values))


def _local_tag(tag: str) -> str:
    """Strip namespace from tag: '{http://...}element' → 'element'."""
    if "}" in tag:
        return tag.split("}", 1)[1]
    return tag


def _strip_ns_prefix(type_str: str) -> str:
    """Strip namespace prefix: 'tns:FooType' → 'FooType'."""
    if ":" in type_str:
        return type_str.split(":", 1)[1]
    return type_str


def _build_ns_map(root: ET.Element) -> dict[str, str]:
    """Build prefix→namespace mapping from root element attributes."""
    ns_map: dict[str, str] = {}
    for key, val in root.attrib.items():
        if key.startswith("xmlns:"):
            prefix = key.split(":", 1)[1]
            ns_map[prefix] = val
        elif key == "xmlns":
            ns_map[""] = val
    return ns_map
