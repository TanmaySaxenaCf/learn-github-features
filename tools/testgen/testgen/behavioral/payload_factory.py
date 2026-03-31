"""Payload factory — generates Java test helper class from XSD analysis.

Produces a PayloadFactory.java that provides builder methods for creating
valid test objects based on XSD type definitions. No hand-written payloads needed.
"""

from __future__ import annotations

import logging
from pathlib import Path

from ..models import XsdComplexType, XsdEnumType, XsdSchema, XsdTypeField

logger = logging.getLogger(__name__)

# XSD type → Java default value
_XSD_DEFAULTS: dict[str, str] = {
    "xs:string": '"test"',
    "xs:int": "1",
    "xs:integer": "1",
    "xs:long": "1L",
    "xs:double": "1.0",
    "xs:float": "1.0f",
    "xs:boolean": "true",
    "xs:decimal": "java.math.BigDecimal.ONE",
}


def generate_payload_factory(
    schemas: list[XsdSchema],
    package: str,
    fqcn_index: dict[str, str],
) -> str:
    """Generate Java PayloadFactory source code from parsed XSD schemas."""
    # Collect all types
    all_complex: list[XsdComplexType] = []
    all_enums: list[XsdEnumType] = []
    for schema in schemas:
        all_complex.extend(schema.complex_types)
        all_enums.extend(schema.enum_types)

    # Build enum value lookup
    enum_values: dict[str, str] = {}
    for e in all_enums:
        if e.values:
            enum_values[e.name] = e.values[0]

    # Build import set
    imports: set[str] = set()
    for ct in all_complex:
        fqcn = fqcn_index.get(ct.name, fqcn_index.get(_java_class_name(ct.name), ""))
        if fqcn:
            imports.add(f"import {fqcn};")
    for e in all_enums:
        fqcn = fqcn_index.get(e.name, "")
        if fqcn:
            imports.add(f"import {fqcn};")

    lines: list[str] = []
    lines.append(f"package {package};")
    lines.append("")
    for imp in sorted(imports):
        lines.append(imp)
    lines.append("")
    lines.append("/**")
    lines.append(" * Auto-generated test payload factory from XSD schemas.")
    lines.append(" * Provides builder methods for creating valid test objects.")
    lines.append(" */")
    lines.append("public final class PayloadFactory {")
    lines.append("")
    lines.append("    private PayloadFactory() { }")
    lines.append("")

    # Generate a builder method for each complex type (only if Java class exists)
    for ct in all_complex:
        java_name = _java_class_name(ct.name)
        fqcn = fqcn_index.get(ct.name, fqcn_index.get(java_name, ""))
        if not fqcn:
            logger.debug("Skipping %s — no Java class in FQCN index", ct.name)
            continue
        method_name = _method_name(ct.name)
        lines.append(f"    /**")
        lines.append(f"     * Create a fully-populated {java_name} with default test values.")
        lines.append(f"     */")
        lines.append(f"    public static {java_name} {method_name}() {{")
        lines.append(f"        {java_name} obj = new {java_name}();")

        for field in ct.fields:
            setter = f"set{_capitalize(field.name)}"
            value = _resolve_default(field, all_complex, enum_values)
            if value:
                lines.append(f"        obj.{setter}({value});")

        lines.append(f"        return obj;")
        lines.append(f"    }}")
        lines.append("")

    # Generate known test data methods (from RE test case inventory)
    lines.extend(_generate_known_data_methods())

    lines.append("}")
    return "\n".join(lines)


def _resolve_default(
    field: XsdTypeField,
    all_complex: list[XsdComplexType],
    enum_values: dict[str, str],
) -> str:
    """Resolve an appropriate default value for an XSD field."""
    raw_type = field.xsd_type
    # Strip namespace prefix
    simple = raw_type.split(":")[-1] if ":" in raw_type else raw_type

    # Primitive XSD types
    if raw_type in _XSD_DEFAULTS:
        return _XSD_DEFAULTS[raw_type]

    # Enum types
    if simple in enum_values:
        return f'{simple}.fromValue("{enum_values[simple]}")'

    # Nested complex types — recurse with builder
    for ct in all_complex:
        if ct.name == simple:
            return f"{_method_name(simple)}()"

    # Unknown type — skip
    return ""


def _generate_known_data_methods() -> list[str]:
    """Generate placeholder section for service-specific test data constants.

    Each service can define its own known test data by adding constants
    to the generated PayloadFactory.java after generation, or by providing
    a test-data overlay file in .testgen/test-data-constants.txt.
    """
    lines: list[str] = []
    lines.append("    // ── Known Test Data ──")
    lines.append("    // Add service-specific test data constants here if needed.")
    lines.append("    // These can be populated from .testgen/test-data-constants.txt")
    lines.append("")
    return lines


def _java_class_name(xsd_name: str) -> str:
    """Convert XSD type name to Java class name (capitalize first letter)."""
    if not xsd_name:
        return xsd_name
    return xsd_name[0].upper() + xsd_name[1:]


def _method_name(xsd_name: str) -> str:
    """Convert type name to factory method name: 'gethaps' → 'createGethaps'."""
    return f"create{_java_class_name(xsd_name)}"


def _capitalize(name: str) -> str:
    """Convert XSD field name to Java setter suffix.

    Handles snake_case → CamelCase: 'inside_water_score_freq' → 'InsideWaterScoreFreq'
    Also handles already-camelCase: 'postalCode' → 'PostalCode'
    """
    if not name:
        return name
    # If the name contains underscores, it's snake_case from XSD
    if "_" in name:
        return "".join(part.capitalize() for part in name.split("_"))
    return name[0].upper() + name[1:]
