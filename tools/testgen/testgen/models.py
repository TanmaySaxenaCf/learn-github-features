"""Lean, immutable data models used across all layers.

Design rules:
  - frozen=True   → immutable after creation, hashable, safe for sets/dicts
  - slots=True    → ~30% less memory per instance, faster attribute access
  - tuples > lists → immutable collections, cheaper to create
  - ClassKind enum → replaces 13 boolean classification flags from v1
"""

from __future__ import annotations

import hashlib
from dataclasses import dataclass, field
from enum import Enum, auto
from pathlib import Path
from typing import Optional


# ── Enumerations ─────────────────────────────────────────────

class ClassKind(Enum):
    """Single enum replaces 13 boolean flags from v1."""
    REST_CONTROLLER = auto()
    SOAP_ENDPOINT = auto()
    SERVICE = auto()
    PROCESSOR = auto()
    MODEL = auto()
    CLIENT = auto()
    EXCEPTION = auto()
    EXCEPTION_HANDLER = auto()
    CONFIGURATION = auto()
    CONSTANTS = auto()
    SPRING_APP = auto()
    UNKNOWN = auto()


class HttpMethod(Enum):
    GET = "GET"
    POST = "POST"
    PUT = "PUT"
    DELETE = "DELETE"
    PATCH = "PATCH"


# ── Field-level models ───────────────────────────────────────

@dataclass(frozen=True, slots=True)
class FieldInfo:
    name: str
    type: str
    annotations: tuple[str, ...] = ()
    access: str = "private"
    is_static: bool = False
    is_final: bool = False


@dataclass(frozen=True, slots=True)
class ParameterInfo:
    name: str
    type: str
    annotations: tuple[str, ...] = ()


@dataclass(frozen=True, slots=True)
class MethodInfo:
    name: str
    return_type: str
    parameters: tuple[ParameterInfo, ...] = ()
    annotations: tuple[str, ...] = ()
    access: str = "public"
    is_static: bool = False
    is_constructor: bool = False


# ── Class-level model ────────────────────────────────────────

@dataclass(frozen=True, slots=True)
class ClassInfo:
    name: str
    package: str
    file_path: str
    kind: ClassKind = ClassKind.UNKNOWN
    fields: tuple[FieldInfo, ...] = ()
    methods: tuple[MethodInfo, ...] = ()
    annotations: tuple[str, ...] = ()
    imports: tuple[str, ...] = ()
    superclass: Optional[str] = None
    interfaces: tuple[str, ...] = ()
    class_type: str = "class"   # "class" | "interface" | "enum" | "record"

    @property
    def fqcn(self) -> str:
        return f"{self.package}.{self.name}"

    @property
    def constructor_params(self) -> tuple[ParameterInfo, ...]:
        """Parameters from the first constructor (primary DI vector)."""
        for m in self.methods:
            if m.is_constructor:
                return m.parameters
        return ()

    @property
    def injected_dependencies(self) -> tuple[str, ...]:
        """Types injected via constructor or @Autowired fields."""
        deps: list[str] = []
        # Constructor injection (preferred in Spring)
        for p in self.constructor_params:
            deps.append(p.type)
        # Field injection fallback
        for f in self.fields:
            if any(a in ("Autowired", "Inject") for a in f.annotations):
                if f.type not in deps:
                    deps.append(f.type)
        return tuple(deps)

    @property
    def public_methods(self) -> tuple[MethodInfo, ...]:
        return tuple(
            m for m in self.methods
            if m.access == "public" and not m.is_constructor and not m.is_static
        )

    def file_hash(self) -> str:
        """SHA-256 of source file — used for incremental skip."""
        return hashlib.sha256(Path(self.file_path).read_bytes()).hexdigest()


# ── Endpoint models ──────────────────────────────────────────

@dataclass(frozen=True, slots=True)
class EndpointMethodInfo:
    method_name: str
    http_method: str            # "GET" | "POST" | ... | "SOAP"
    path: str = ""
    request_type: Optional[str] = None
    response_type: Optional[str] = None
    consumes: Optional[str] = None
    produces: Optional[str] = None
    soap_action: Optional[str] = None
    operation_name: Optional[str] = None


@dataclass(frozen=True, slots=True)
class EndpointInfo:
    class_info: ClassInfo
    endpoint_type: str          # "REST" | "SOAP"
    base_path: str = ""
    methods: tuple[EndpointMethodInfo, ...] = ()
    service_dependencies: tuple[str, ...] = ()


@dataclass(frozen=True, slots=True)
class ExternalDependency:
    class_name: str
    url_property: str = ""
    url_value: str = ""
    protocol: str = "HTTP"


# ── Project-wide context ─────────────────────────────────────

@dataclass(slots=True)
class ProjectInfo:
    """Serialisable project metadata — written to .testgen/project.json."""
    project_path: str = ""
    group_id: str = ""
    artifact_id: str = ""
    version: str = ""
    spring_boot_version: str = ""
    java_version: str = ""
    base_package: str = ""
    fqcn_index: dict[str, str] = field(default_factory=dict)

    # Component lists built by discovery
    endpoints: list[EndpointInfo] = field(default_factory=list)
    services: list[ClassInfo] = field(default_factory=list)
    processors: list[ClassInfo] = field(default_factory=list)
    models: list[ClassInfo] = field(default_factory=list)
    clients: list[ClassInfo] = field(default_factory=list)
    exceptions: list[ClassInfo] = field(default_factory=list)
    exception_handlers: list[ClassInfo] = field(default_factory=list)
    configurations: list[ClassInfo] = field(default_factory=list)
    external_deps: list[ExternalDependency] = field(default_factory=list)

    # Auxiliary data
    configs: dict = field(default_factory=dict)
    schemas: list[str] = field(default_factory=list)
    business_rules: list[str] = field(default_factory=list)
    has_wiremock: bool = False
    has_spring_test: bool = False

    @property
    def all_classes(self) -> list[ClassInfo]:
        """Flat list of every discovered class across all categories."""
        classes: list[ClassInfo] = []
        for ep in self.endpoints:
            classes.append(ep.class_info)
        classes.extend(self.services)
        classes.extend(self.processors)
        classes.extend(self.models)
        classes.extend(self.clients)
        classes.extend(self.exceptions)
        classes.extend(self.exception_handlers)
        classes.extend(self.configurations)
        return classes


@dataclass(frozen=True, slots=True)
class GenerationContext:
    """Lightweight read-only context passed to every generator/plugin."""
    fqcn_index: dict[str, str]
    config: dict
    project_path: str
    base_package: str
    test_package: str
    test_suffix: str


# ── Helpers ──────────────────────────────────────────────────

# Default test value map — 20 Java types → literal expression
_DEFAULT_VALUES: dict[str, str] = {
    "String":       '"test"',
    "int":          "1",
    "Integer":      "1",
    "long":         "1L",
    "Long":         "1L",
    "double":       "1.0",
    "Double":       "1.0",
    "float":        "1.0f",
    "Float":        "1.0f",
    "boolean":      "true",
    "Boolean":      "true",
    "byte":         "(byte) 1",
    "Byte":         "(byte) 1",
    "short":        "(short) 1",
    "Short":        "(short) 1",
    "char":         "'a'",
    "Character":    "'a'",
    "BigDecimal":   "java.math.BigDecimal.ONE",
    "BigInteger":   "java.math.BigInteger.ONE",
    "LocalDate":    "java.time.LocalDate.now()",
    "LocalDateTime": "java.time.LocalDateTime.now()",
    "UUID":         "java.util.UUID.randomUUID()",
    "XMLGregorianCalendar": "javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar()",
}

# Types that should NOT be FQCN-resolved (primitives + JDK core)
SKIP_FQCN_TYPES = frozenset({
    "void", "int", "long", "double", "float", "boolean", "byte", "short",
    "char", "Object", "String", "Exception", "RuntimeException", "Throwable",
    "Override", "List", "Map", "Set", "Optional", "Collection",
    "XMLGregorianCalendar",
})


def default_value_for_type(java_type: str) -> str:
    """Return a Java literal for creating a test default of *java_type*."""
    simple = simple_type_name(java_type)
    if simple in _DEFAULT_VALUES:
        return _DEFAULT_VALUES[simple]
    if java_type.startswith("List") or java_type.startswith("Collection"):
        return "java.util.Collections.emptyList()"
    if java_type.startswith("Set"):
        return "java.util.Collections.emptySet()"
    if java_type.startswith("Map"):
        return "java.util.Collections.emptyMap()"
    return f"new {simple}()"


def simple_type_name(full_type: str) -> str:
    """Extract simple name: 'List<Foo>' → 'Foo', 'com.pkg.Bar' → 'Bar'."""
    import re
    m = re.search(r"[\w.]*?(\w+)(?:<.*>)?$", full_type)
    return m.group(1) if m else full_type


def split_generics(raw: str) -> list[str]:
    """Split comma-separated params respecting generic angle brackets.

    'Map<String, List<Foo>>, int' → ['Map<String, List<Foo>>', 'int']
    """
    parts: list[str] = []
    depth = 0
    current: list[str] = []
    for ch in raw:
        if ch == "<":
            depth += 1
            current.append(ch)
        elif ch == ">":
            depth -= 1
            current.append(ch)
        elif ch == "," and depth == 0:
            parts.append("".join(current).strip())
            current = []
        else:
            current.append(ch)
    tail = "".join(current).strip()
    if tail:
        parts.append(tail)
    return parts


# ── Behavioral Testing Models ────────────────────────────────

@dataclass(frozen=True, slots=True)
class XsdTypeField:
    """A single field within an XSD complexType."""
    name: str
    xsd_type: str           # "xs:string", "xs:int", "tns:ProvinceType", etc.
    min_occurs: int = 1
    nillable: bool = False

    @property
    def is_optional(self) -> bool:
        return self.min_occurs == 0 or self.nillable


@dataclass(frozen=True, slots=True)
class XsdComplexType:
    """A parsed XSD complexType with its field sequence."""
    name: str
    namespace: str
    fields: tuple[XsdTypeField, ...] = ()


@dataclass(frozen=True, slots=True)
class XsdEnumType:
    """A parsed XSD simpleType restriction (enumeration)."""
    name: str
    namespace: str
    values: tuple[str, ...] = ()


@dataclass(frozen=True, slots=True)
class XsdSchema:
    """Complete parsed XSD schema — types, enums, root elements."""
    target_namespace: str
    complex_types: tuple[XsdComplexType, ...] = ()
    enum_types: tuple[XsdEnumType, ...] = ()
    root_elements: dict[str, str] = field(default_factory=dict)  # element name → type


@dataclass(frozen=True, slots=True)
class FieldMappingEntry:
    """A single field mapping from source to target."""
    source_field: str
    target_field: str
    transformation: str = "Direct copy"
    default_value: str = ""


@dataclass(frozen=True, slots=True)
class FieldMappingSpec:
    """A named field mapping specification (MAP-001, MAP-002, etc.)."""
    mapping_id: str
    name: str
    source_type: str
    target_type: str
    component_id: str
    fields: tuple[FieldMappingEntry, ...] = ()


@dataclass(frozen=True, slots=True)
class BusinessRuleSpec:
    """A parsed business rule from the RE docs."""
    rule_id: str
    name: str
    category: str
    priority: str
    description: str
    business_logic: str
    component_ids: tuple[str, ...] = ()
    test_scenarios: tuple[str, ...] = ()


@dataclass(frozen=True, slots=True)
class TestCaseSpec:
    """A test case from the RE test case inventory."""
    test_id: str
    title: str
    category: str
    priority: str
    component_ids: tuple[str, ...] = ()
    business_rules: tuple[str, ...] = ()
    steps: tuple[tuple[str, str], ...] = ()  # (action, expected)
    test_data: dict[str, str] = field(default_factory=dict)


@dataclass(slots=True)
class BehavioralContext:
    """Aggregated behavioral testing context — fed to templates."""
    xsd_schemas: list[XsdSchema] = field(default_factory=list)
    business_rules: list[BusinessRuleSpec] = field(default_factory=list)
    field_mappings: list[FieldMappingSpec] = field(default_factory=list)
    test_cases: list[TestCaseSpec] = field(default_factory=list)
    legacy_path: str = ""
    re_docs_path: str = ""
