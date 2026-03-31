"""Classification rules — maps ClassInfo annotations/heuristics to ClassKind.

Separated from the parser so the same rules work with both regex and AST parsers.
"""

from __future__ import annotations

from ..models import ClassInfo, ClassKind


# ── Annotation-based classification (highest priority) ───────

_KIND_BY_ANNOTATION: dict[str, ClassKind] = {
    "RestController":      ClassKind.REST_CONTROLLER,
    "Controller":          ClassKind.REST_CONTROLLER,
    "WebService":          ClassKind.SOAP_ENDPOINT,
    "Service":             ClassKind.SERVICE,
    "ControllerAdvice":    ClassKind.EXCEPTION_HANDLER,
    "RestControllerAdvice": ClassKind.EXCEPTION_HANDLER,
    "Configuration":       ClassKind.CONFIGURATION,
    "SpringBootApplication": ClassKind.SPRING_APP,
    "Repository":          ClassKind.SERVICE,
}

# ── Name-based heuristics (fallback) ────────────────────────

_CLIENT_MARKERS = ("client", "connector", "adapter", "gateway", "proxy")
_CLIENT_IMPORT_MARKERS = ("RestTemplate", "WebClient", "JaxWsProxyFactoryBean",
                          "CXFBus", "HttpURLConnection")
_PROCESSOR_MARKERS = ("processor", "mapper", "transformer", "converter", "handler")
_EXCEPTION_SUPERS = ("Exception", "RuntimeException", "Throwable",
                     "IllegalArgumentException", "IllegalStateException")


def classify(ci: ClassInfo) -> ClassKind:
    """Determine the ClassKind for a ClassInfo based on annotations and heuristics."""

    # 1. Annotation-based (most reliable)
    for ann in ci.annotations:
        kind = _KIND_BY_ANNOTATION.get(ann)
        if kind is not None:
            return kind

    # 2. @Component — could be client, processor, or generic component
    is_component = "Component" in ci.annotations

    # 3. Client heuristic
    name_lower = ci.name.lower()
    if is_component or any(m in name_lower for m in _CLIENT_MARKERS):
        if _looks_like_client(ci):
            return ClassKind.CLIENT

    # 4. Exception heuristic (before processor — some processors extend base classes)
    if ci.superclass and any(ci.superclass.endswith(s) for s in _EXCEPTION_SUPERS):
        return ClassKind.EXCEPTION
    if ci.name.endswith("Exception") or ci.name.endswith("Error"):
        return ClassKind.EXCEPTION

    # 5. Processor heuristic
    if is_component or any(m in name_lower for m in _PROCESSOR_MARKERS):
        return ClassKind.PROCESSOR

    # 6. Constants — interface/class with only static final fields, no methods
    if _looks_like_constants(ci):
        return ClassKind.CONSTANTS

    # 7. Default: model/DTO
    if ci.class_type in ("class", "record"):
        return ClassKind.MODEL

    return ClassKind.UNKNOWN


def _looks_like_client(ci: ClassInfo) -> bool:
    """Heuristic: name contains client marker OR imports HTTP/SOAP client libs."""
    name_lower = ci.name.lower()
    if any(m in name_lower for m in _CLIENT_MARKERS):
        return True
    imports_str = " ".join(ci.imports)
    return any(m in imports_str for m in _CLIENT_IMPORT_MARKERS)


def _looks_like_constants(ci: ClassInfo) -> bool:
    """Class/interface with only static final fields, no non-static methods."""
    if not ci.fields:
        return False
    all_static_final = all(f.is_static and f.is_final for f in ci.fields)
    has_instance_methods = any(
        not m.is_static and not m.is_constructor and m.access == "public"
        for m in ci.methods
    )
    return all_static_final and not has_instance_methods
