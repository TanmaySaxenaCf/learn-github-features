"""Plugin protocol and registry for test generators.

Each generator type (JUnit, WireMock, Postman) is a plugin that:
  1. Declares which ClassInfo it accepts
  2. Selects the appropriate template
  3. Builds a context dict for the template
  4. Optionally runs post-generation hooks (e.g., POM modification)

New generators can be added without modifying existing code.
"""

from __future__ import annotations

import re
import logging
from pathlib import Path
from typing import Protocol, runtime_checkable, Any

from ..models import (
    ClassInfo, ClassKind, EndpointInfo, GenerationContext,
    ProjectInfo, default_value_for_type, simple_type_name,
    SKIP_FQCN_TYPES,
)

logger = logging.getLogger(__name__)


# ── Plugin Protocol ──────────────────────────────────────────

@runtime_checkable
class GeneratorPlugin(Protocol):
    """Interface that every generator plugin must implement."""
    name: str

    def accepts(self, cls: ClassInfo, info: ProjectInfo) -> bool:
        """Return True if this plugin should generate output for *cls*."""
        ...

    def template_name(self, cls: ClassInfo) -> str:
        """Return the Jinja2 template filename to use."""
        ...

    def build_context(self, cls: ClassInfo, info: ProjectInfo,
                      ctx: GenerationContext) -> dict[str, Any]:
        """Build the template context dict."""
        ...


# ── Plugin Registry ──────────────────────────────────────────

class PluginRegistry:
    """Holds all registered generator plugins."""

    def __init__(self):
        self._plugins: list[GeneratorPlugin] = []

    def register(self, plugin: GeneratorPlugin) -> None:
        self._plugins.append(plugin)
        logger.debug("Registered plugin: %s", plugin.name)

    def plugins_for(self, cls: ClassInfo, info: ProjectInfo) -> list[GeneratorPlugin]:
        """Return all plugins that accept *cls*."""
        return [p for p in self._plugins if p.accepts(cls, info)]

    @property
    def all_plugins(self) -> list[GeneratorPlugin]:
        return list(self._plugins)


# ── Built-in JUnit Plugin ───────────────────────────────────

class JUnitPlugin:
    """Generates JUnit 5 + Mockito unit tests."""
    name = "junit"

    _TEMPLATE_MAP = {
        ClassKind.REST_CONTROLLER:  "junit/rest_controller.java.j2",
        ClassKind.SOAP_ENDPOINT:    "junit/soap_endpoint.java.j2",
        ClassKind.SERVICE:          "junit/service.java.j2",
        ClassKind.PROCESSOR:        "junit/processor.java.j2",
        ClassKind.MODEL:            "junit/model.java.j2",
        ClassKind.CLIENT:           "junit/client.java.j2",
        ClassKind.EXCEPTION:        "junit/exception.java.j2",
        ClassKind.EXCEPTION_HANDLER: "junit/exception_handler.java.j2",
        ClassKind.CONSTANTS:        "junit/model.java.j2",
    }

    def accepts(self, cls: ClassInfo, info: ProjectInfo) -> bool:
        return cls.kind in self._TEMPLATE_MAP

    def template_name(self, cls: ClassInfo) -> str:
        return self._TEMPLATE_MAP.get(cls.kind, "junit/model.java.j2")

    def build_context(self, cls: ClassInfo, info: ProjectInfo,
                      ctx: GenerationContext) -> dict[str, Any]:
        """Build comprehensive template context for any class kind."""
        instance_var = cls.name[0].lower() + cls.name[1:]
        deps = cls.injected_dependencies

        # Build dependency info list
        dep_infos = []
        for dep_type in deps:
            dep_infos.append({
                "type": dep_type,
                "var_name": dep_type[0].lower() + dep_type[1:],
                "fqcn": ctx.fqcn_index.get(dep_type, ""),
            })

        # Build method info with default values
        method_infos = []
        for method in cls.public_methods:
            params = []
            for i, p in enumerate(method.parameters):
                params.append({
                    "type": p.type,
                    "var": f"p{i}",
                    "default_value": default_value_for_type(p.type),
                    "simple_type": simple_type_name(p.type),
                })
            # Find mock target for exception test
            mock_target = self._find_mock_target(cls, method, deps, info)
            if mock_target:
                mock_target["any_args"] = self._any_args_for(mock_target, info)

            # Build mock setups — mock each dependency's first method
            mock_setups = self._build_mock_setups(cls, deps, info, ctx)

            # Build null-first variant of param_vars for null-input tests
            null_first_parts = []
            for i, p in enumerate(method.parameters):
                if i == 0:
                    null_first_parts.append("null")
                else:
                    null_first_parts.append(default_value_for_type(p.type))

            method_infos.append({
                "name": method.name,
                "return_type": method.return_type,
                "parameters": params,
                "param_vars": ", ".join(f"p{i}" for i in range(len(method.parameters))),
                "null_first_param_vars": ", ".join(null_first_parts),
                "mock_target": mock_target,
                "mock_setups": mock_setups,
                "annotations": list(method.annotations),
                "return_fields": self._resolve_return_fields(method.return_type, info),
            })

        # Build import list
        imports = self._build_imports(cls, deps, ctx)

        # Add imports for mock setup return types (from dependency methods)
        for mi in method_infos:
            for setup in mi.get("mock_setups", []):
                rv = setup.get("return_value", "")
                m = re.match(r'new\s+(\w+)\(', rv)
                if m:
                    self._add_type_import(imports, m.group(1), ctx)

        # Endpoint-specific context
        endpoint_ctx = {}
        if cls.kind in (ClassKind.REST_CONTROLLER, ClassKind.SOAP_ENDPOINT):
            endpoint_ctx = self._build_endpoint_context(cls, info, ctx)

        return {
            "test_package": ctx.test_package,
            "test_class_name": f"{cls.name}{ctx.test_suffix}",
            "class_name": cls.name,
            "class_fqcn": cls.fqcn,
            "instance_var": instance_var,
            "class_kind": cls.kind.name,
            "dependencies": dep_infos,
            "methods": method_infos,
            "imports": sorted(imports),
            "has_dependencies": bool(deps),
            **endpoint_ctx,
        }

    def _find_mock_target(self, cls, method, deps, info) -> dict | None:
        """Find a dependency method to mock for exception tests.

        Strategy: scan source code of the class under test to find which
        dependency method is actually called within the test method.
        """
        if not deps:
            return None

        # Build method lookup for each dependency
        dep_class_methods: dict[str, list] = {}
        for ci in info.all_classes:
            if ci.name in deps:
                dep_class_methods[ci.name] = [
                    m for m in ci.public_methods if not m.is_constructor
                ]

        # Try source scanning first
        try:
            src = Path(cls.file_path).read_text(encoding="utf-8", errors="replace")
        except OSError:
            src = ""

        for dep_type in deps:
            methods_on_dep = dep_class_methods.get(dep_type, [])
            if not methods_on_dep:
                continue
            dep_var = dep_type[0].lower() + dep_type[1:]
            public_names = {m.name for m in methods_on_dep}

            # Source scan: find serviceVar.someMethod( in the class source
            if src:
                pat = re.compile(rf'\b{re.escape(dep_var)}\.(\w+)\s*\(')
                for call_match in pat.finditer(src):
                    called = call_match.group(1)
                    if called in public_names:
                        return {"var": dep_var, "method": called, "type": dep_type}

            # Name-based fallback
            for m in methods_on_dep:
                if method.name.lower() in m.name.lower():
                    return {"var": dep_var, "method": m.name, "type": dep_type}

            # Last resort: first public method
            if methods_on_dep:
                return {"var": dep_var, "method": methods_on_dep[0].name, "type": dep_type}

        return None

    def _any_args_for(self, mock_target: dict, info: ProjectInfo) -> str:
        """Build the right number of any() args for a mock target method."""
        dep_type = mock_target.get("type", "")
        method_name = mock_target.get("method", "")
        for ci in info.all_classes:
            if ci.name == dep_type:
                for m in ci.public_methods:
                    if m.name == method_name:
                        count = len(m.parameters)
                        if count == 0:
                            return ""
                        return ", ".join(["any()"] * count)
        return "any()"

    @staticmethod
    def _resolve_return_fields(return_type: str, info: ProjectInfo) -> list[dict]:
        """Look up the return type's non-static fields and build getter info.

        Returns a list of dicts with keys: field_name, getter, type.
        This is generic — works for any service's model classes.
        """
        if not return_type or return_type == "void":
            return []
        # Strip generics: ResponseEntity<Map<String, Object>> → ResponseEntity
        simple = re.sub(r'<.*>', '', return_type).strip()
        # Skip primitives and JDK types
        if simple in ("String", "int", "long", "double", "float", "boolean",
                       "byte", "short", "char", "Object", "void"):
            return []
        for ci in info.all_classes:
            if ci.name == simple:
                fields = []
                for f in ci.fields:
                    if f.is_static or f.access == "private" and f.is_final and f.type in ("Logger",):
                        continue  # Skip logger etc.
                    if f.is_static:
                        continue
                    # Build JavaBean getter name
                    getter = f"get{f.name[0].upper()}{f.name[1:]}"
                    if f.type == "boolean":
                        getter = f"is{f.name[0].upper()}{f.name[1:]}"
                    fields.append({
                        "field_name": f.name,
                        "getter": getter,
                        "type": f.type,
                    })
                return fields
        return []

    def _build_mock_setups(self, cls: ClassInfo, deps: list[str],
                           info: ProjectInfo, ctx: GenerationContext) -> list[dict]:
        """Build mock setup stubs so service dependencies return non-null values."""
        setups = []
        for dep_type in deps:
            dep_var = dep_type[0].lower() + dep_type[1:]
            for ci in info.all_classes:
                if ci.name == dep_type:
                    for m in ci.public_methods:
                        if m.is_constructor:
                            continue
                        if m.return_type and m.return_type != "void":
                            return_val = default_value_for_type(m.return_type)
                            arg_count = len(m.parameters)
                            if arg_count == 0:
                                any_args = ""
                            else:
                                any_args = ", ".join(["any()"] * arg_count)
                            setups.append({
                                "var": dep_var,
                                "method": m.name,
                                "any_args": any_args,
                                "return_value": return_val,
                            })
                    break
        return setups

    def _build_imports(self, cls, deps, ctx) -> set[str]:
        """Build the full import set for a test class."""
        imports: set[str] = set()
        imports.add(f"import {cls.fqcn};")

        # Dependency imports
        for dep_type in deps:
            fqcn = ctx.fqcn_index.get(dep_type, "")
            if fqcn:
                imports.add(f"import {fqcn};")

        # Method parameter/return type imports
        for method in cls.public_methods:
            for p in method.parameters:
                self._add_type_import(imports, p.type, ctx)
            if method.return_type and method.return_type != "void":
                self._add_type_import(imports, method.return_type, ctx)

        # Standard test imports
        imports.add("import org.junit.jupiter.api.Test;")
        imports.add("import static org.junit.jupiter.api.Assertions.*;")

        if deps or cls.kind in (ClassKind.CLIENT, ClassKind.EXCEPTION_HANDLER,
                                 ClassKind.SERVICE, ClassKind.PROCESSOR,
                                 ClassKind.SOAP_ENDPOINT):
            imports.add("import org.junit.jupiter.api.extension.ExtendWith;")
            imports.add("import org.mockito.InjectMocks;")
            imports.add("import org.mockito.Mock;")
            imports.add("import org.mockito.junit.jupiter.MockitoExtension;")
            imports.add("import static org.mockito.Mockito.*;")
            imports.add("import static org.mockito.ArgumentMatchers.*;")

        if cls.kind == ClassKind.REST_CONTROLLER:
            imports.add("import org.springframework.beans.factory.annotation.Autowired;")
            imports.add("import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;")
            imports.add("import org.springframework.boot.test.mock.mockito.MockBean;")
            imports.add("import org.springframework.http.MediaType;")
            imports.add("import org.springframework.test.web.servlet.MockMvc;")
            imports.add("import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;")
            imports.add("import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;")

        return imports

    # Well-known JDK/Spring types not in the project's FQCN index
    _JDK_IMPORTS: dict[str, str] = {
        "XMLGregorianCalendar": "import javax.xml.datatype.XMLGregorianCalendar;",
        "DatatypeFactory": "import javax.xml.datatype.DatatypeFactory;",
        "BigDecimal": "import java.math.BigDecimal;",
        "BigInteger": "import java.math.BigInteger;",
        "LocalDate": "import java.time.LocalDate;",
        "LocalDateTime": "import java.time.LocalDateTime;",
        "Instant": "import java.time.Instant;",
        "Duration": "import java.time.Duration;",
        "Map": "import java.util.Map;",
        "List": "import java.util.List;",
        "Set": "import java.util.Set;",
        "ResponseEntity": "import org.springframework.http.ResponseEntity;",
        "HttpStatus": "import org.springframework.http.HttpStatus;",
    }

    def _add_type_import(self, imports: set[str], type_str: str, ctx: GenerationContext):
        """Resolve and add import for a Java type (handles generics)."""
        # Extract all type names from generics like Map<String, List<Foo>>
        tokens = re.findall(r'\b([A-Z]\w+)\b', type_str)
        for token in tokens:
            # Check JDK well-known types first (even if in SKIP_FQCN_TYPES)
            if token in self._JDK_IMPORTS:
                imports.add(self._JDK_IMPORTS[token])
                continue
            if token in SKIP_FQCN_TYPES:
                continue
            # Check project FQCN index first
            fqcn = ctx.fqcn_index.get(token, "")
            if fqcn:
                imports.add(f"import {fqcn};")

    def _build_endpoint_context(self, cls, info, ctx) -> dict:
        """Extra context for REST/SOAP endpoint tests."""
        for ep in info.endpoints:
            if ep.class_info.name == cls.name:
                ep_methods = []
                for em in ep.methods:
                    ep_methods.append({
                        "method_name": em.method_name,
                        "http_method": em.http_method.lower(),
                        "path": em.path or ep.base_path,
                        "request_type": em.request_type,
                        "response_type": em.response_type,
                        "consumes": em.consumes,
                        "produces": em.produces,
                        "is_xml": bool(em.consumes and "xml" in em.consumes.lower()),
                        "operation_name": em.operation_name,
                    })
                return {
                    "endpoint_type": ep.endpoint_type,
                    "base_path": ep.base_path,
                    "endpoint_methods": ep_methods,
                    "mock_bean_deps": [
                        {"type": d, "var_name": d[0].lower() + d[1:]}
                        for d in ep.service_dependencies
                    ],
                }
        return {}


# ── Built-in WireMock Plugin ────────────────────────────────

class WireMockPlugin:
    """Generates WireMock-based integration tests."""
    name = "wiremock"

    def accepts(self, cls: ClassInfo, info: ProjectInfo) -> bool:
        return cls.kind in (ClassKind.REST_CONTROLLER, ClassKind.SOAP_ENDPOINT)

    def template_name(self, cls: ClassInfo) -> str:
        if cls.kind == ClassKind.REST_CONTROLLER:
            return "wiremock/rest_integration.java.j2"
        return "wiremock/soap_integration.java.j2"

    def build_context(self, cls: ClassInfo, info: ProjectInfo,
                      ctx: GenerationContext) -> dict[str, Any]:
        for ep in info.endpoints:
            if ep.class_info.name == cls.name:
                return {
                    "test_package": f"{ctx.test_package}.integration",
                    "test_class_name": f"{cls.name}IntegrationAutoTest",
                    "class_name": cls.name,
                    "class_fqcn": cls.fqcn,
                    "endpoint_type": ep.endpoint_type,
                    "base_path": ep.base_path,
                    "endpoint_methods": [
                        {"method_name": em.method_name, "http_method": em.http_method.lower(),
                         "path": em.path or ep.base_path, "request_type": em.request_type,
                         "is_xml": bool(em.consumes and "xml" in em.consumes.lower())}
                        for em in ep.methods
                    ],
                    "external_deps": [
                        {"class_name": d.class_name, "url_property": d.url_property,
                         "url_value": d.url_value, "protocol": d.protocol}
                        for d in info.external_deps
                    ],
                    "imports": sorted(self._build_imports(cls, info, ctx)),
                }
        return {}

    def _build_imports(self, cls, info, ctx) -> set[str]:
        imports = {
            f"import {cls.fqcn};",
            "import org.junit.jupiter.api.Test;",
            "import org.springframework.boot.test.context.SpringBootTest;",
            "import org.springframework.boot.test.web.client.TestRestTemplate;",
            "import org.springframework.beans.factory.annotation.Autowired;",
            "import org.springframework.test.context.DynamicPropertyRegistry;",
            "import org.springframework.test.context.DynamicPropertySource;",
            "import static com.github.tomakehurst.wiremock.client.WireMock.*;",
            "import static org.junit.jupiter.api.Assertions.*;",
        }
        # Resolve custom type imports from endpoint method signatures
        for ep in info.endpoints:
            if ep.class_info.name == cls.name:
                for em in ep.methods:
                    for type_name in (em.request_type, em.response_type):
                        if type_name:
                            fqcn = ctx.fqcn_index.get(type_name, "")
                            if fqcn:
                                imports.add(f"import {fqcn};")
        return imports


# ── Built-in Postman Plugin ──────────────────────────────────

class PostmanPlugin:
    """Generates Postman collection + environment files (non-class-based)."""
    name = "postman"

    def accepts(self, cls: ClassInfo, info: ProjectInfo) -> bool:
        # Postman generates at project level, not per-class
        return False

    def template_name(self, cls: ClassInfo) -> str:
        return "postman/collection.json.j2"

    def build_context(self, cls: ClassInfo, info: ProjectInfo,
                      ctx: GenerationContext) -> dict[str, Any]:
        return {}

    def build_collection_context(self, info: ProjectInfo,
                                  ctx: GenerationContext) -> dict[str, Any]:
        """Build context for the full Postman collection (project-level)."""
        import hashlib
        # Deterministic ID based on artifact
        coll_id = hashlib.sha256(
            f"{info.group_id}:{info.artifact_id}".encode()
        ).hexdigest()[:24]

        rest_endpoints = []
        soap_endpoints = []
        for ep in info.endpoints:
            methods_ctx = []
            for em in ep.methods:
                methods_ctx.append({
                    "method_name": em.method_name,
                    "http_method": (em.http_method if em.http_method != "SOAP"
                                    else "POST"),
                    "path": em.path or ep.base_path,
                    "request_type": em.request_type,
                    "is_xml": bool(em.consumes and "xml" in em.consumes.lower()),
                    "operation_name": em.operation_name,
                })
            entry = {
                "class_name": ep.class_info.name,
                "base_path": ep.base_path,
                "methods": methods_ctx,
            }
            if ep.endpoint_type == "REST":
                rest_endpoints.append(entry)
            else:
                soap_endpoints.append(entry)

        return {
            "collection_id": coll_id,
            "collection_name": f"{info.artifact_id} API Tests",
            "rest_endpoints": rest_endpoints,
            "soap_endpoints": soap_endpoints,
            "base_url_variable": "base_url",
            "default_base_url": "http://localhost:8080",
        }

    def build_environment_context(self, info: ProjectInfo,
                                   profile: str, config: dict) -> dict[str, Any]:
        """Build context for a single Postman environment file."""
        import hashlib
        env_id = hashlib.sha256(
            f"{info.artifact_id}:{profile}".encode()
        ).hexdigest()[:24]

        base_url = self._extract_base_url(config)
        return {
            "env_id": env_id,
            "env_name": f"{info.artifact_id} ({profile})",
            "base_url": base_url,
        }

    def _extract_base_url(self, config: dict) -> str:
        """Try to derive base_url from Spring config."""
        if not isinstance(config, dict):
            return "http://localhost:8080"
        server = config.get("server", {})
        if not isinstance(server, dict):
            return "http://localhost:8080"
        port = server.get("port", 8080)
        ctx = server.get("servlet", {})
        if isinstance(ctx, dict):
            ctx_path = ctx.get("context-path", "")
        else:
            ctx_path = ""
        return f"http://localhost:{port}{ctx_path}"


# ── Built-in Behavioral Plugin ───────────────────────────────

class BehavioralPlugin:
    """Generates behavioral tests from RE docs (business rules + field mappings)."""
    name = "behavioral"

    # Classes that have business rules applicable to them
    _BR_COMPONENT_MAP: dict[str, tuple[str, ...]] = {
        "PROCESSOR": ("BR-008", "BR-009", "BR-010", "BR-011", "BR-012", "BR-013",
                       "BR-014", "BR-015", "BR-016", "BR-017"),
        "CLIENT": ("BR-006", "BR-014"),
        "SERVICE": ("BR-008", "BR-009", "BR-014"),
        "SOAP_ENDPOINT": ("BR-001", "BR-003", "BR-004"),
        "REST_CONTROLLER": ("BR-001", "BR-003", "BR-007"),
    }

    # Rules that require specific methods to be present on the class.
    # Method names are matched generically — use common patterns.
    _BR_METHOD_REQUIREMENTS: dict[str, tuple[str, ...]] = {
        "BR-008": ("mapRequest",),                          # Request mapping
        "BR-009": ("mapResponse",),                         # Response mapping
        "BR-010": ("mapResponse",),                         # Default values on failure
        "BR-011": ("mapResponse",),                         # Default version on failure
        "BR-012": ("preProcess",),                          # Transaction ID extraction
        "BR-013": ("createCurrentTimestamp", "mapResponse"),# Timestamps
        "BR-014": ("mapResponse",),                         # External service fallback
        "BR-015": ("mapResponse",),                         # Error code on failure
        "BR-016": ("logRequest", "logResponse"),            # Transaction logging
        "BR-017": ("logRequest", "logResponse"),            # Log format
    }

    def accepts(self, cls: ClassInfo, info: ProjectInfo) -> bool:
        return cls.kind.name in self._BR_COMPONENT_MAP

    def template_for_mapping(self) -> str:
        return "behavioral/field_mapping.java.j2"

    def template_for_rules(self) -> str:
        return "behavioral/business_rule.java.j2"

    def template_for_errors(self) -> str:
        return "behavioral/error_handling.java.j2"

    def applicable_rules(self, cls: ClassInfo) -> tuple[str, ...]:
        base_rules = self._BR_COMPONENT_MAP.get(cls.kind.name, ())
        # Filter rules: only include rules whose required methods exist on this class
        method_names = {m.name for m in cls.public_methods if not m.is_constructor}
        filtered = []
        for rule_id in base_rules:
            required_methods = self._BR_METHOD_REQUIREMENTS.get(rule_id)
            if required_methods is None:
                # No method requirement — always include (e.g., BR-012, BR-001)
                filtered.append(rule_id)
            elif any(m in method_names for m in required_methods):
                # At least one required method is present
                filtered.append(rule_id)
            # else: skip — class can't implement this rule
        return tuple(filtered)

    def build_context(self, cls: ClassInfo, info: ProjectInfo,
                      ctx: GenerationContext, behavioral_ctx=None) -> dict[str, Any]:
        """Build template context for behavioral tests."""
        instance_var = cls.name[0].lower() + cls.name[1:]
        deps = cls.injected_dependencies

        dep_infos = []
        for dep_type in deps:
            dep_var = dep_type[0].lower() + dep_type[1:]
            # Find a suitable method to mock
            mock_method, mock_param_count = self._find_mock_method(dep_type, info)
            mock_args = ", ".join(["any()"] * max(mock_param_count, 1))
            dep_infos.append({
                "type": dep_type,
                "var_name": dep_var,
                "fqcn": ctx.fqcn_index.get(dep_type, ""),
                "mock_method": mock_method,
                "mock_args": mock_args,
            })

        method_infos = []
        for method in cls.public_methods:
            params = []
            for i, p in enumerate(method.parameters):
                params.append({
                    "type": p.type,
                    "var": f"p{i}",
                    "default_value": default_value_for_type(p.type),
                })
            method_infos.append({
                "name": method.name,
                "return_type": method.return_type,
                "parameters": params,
                "param_vars": ", ".join(
                    default_value_for_type(p.type) for p in method.parameters
                ),
            })

        # Find constants class dynamically (any class with kind=CONSTANTS)
        constants_class = None
        constants_fields = {}
        for ci in info.models:
            if ci.kind == ClassKind.CONSTANTS:
                constants_class = ci.name
                # Extract constant field names and their string default values
                for f in ci.fields:
                    if f.is_static and f.is_final and f.type == "String":
                        constants_fields[f.name] = f.name  # key = field name
                break

        # Build mock_setups for dependencies (so behavioral tests can invoke methods)
        mock_setups = []
        for dep_type in deps:
            dep_var = dep_type[0].lower() + dep_type[1:]
            for ci in info.all_classes:
                if ci.name == dep_type:
                    for m in ci.public_methods:
                        if m.is_constructor:
                            continue
                        if m.return_type and m.return_type != "void":
                            return_val = default_value_for_type(m.return_type)
                            arg_count = len(m.parameters)
                            if arg_count == 0:
                                any_args = ""
                            else:
                                any_args = ", ".join(["any()"] * arg_count)
                            mock_setups.append({
                                "var": dep_var,
                                "method": m.name,
                                "any_args": any_args,
                                "return_value": return_val,
                            })
                    break

        imports = self._build_imports(cls, deps, ctx, info)

        # Add imports for mock setup return types
        for setup in mock_setups:
            rv = setup.get("return_value", "")
            m = re.match(r'new\s+(\w+)\(', rv)
            if m:
                rt = m.group(1)
                fqcn = ctx.fqcn_index.get(rt, "")
                if fqcn:
                    imports.add(f"import {fqcn};")
        # Also need BeforeEach import if we have mock_setups
        if mock_setups:
            imports.add("import org.junit.jupiter.api.BeforeEach;")

        return {
            "test_package": f"{ctx.test_package}.behavioral",
            "test_class_name": f"{cls.name}BehavioralAutoTest",
            "class_name": cls.name,
            "class_fqcn": cls.fqcn,
            "instance_var": instance_var,
            "dependencies": dep_infos,
            "methods": method_infos,
            "mock_setups": mock_setups,
            "imports": sorted(imports),
            "constants_class": constants_class,
            "constants_fields": constants_fields,
        }

    def _find_mock_method(self, dep_type: str, info: ProjectInfo) -> tuple[str, int]:
        """Find a public method on a dependency to mock. Returns (name, param_count)."""
        for ci in info.all_classes:
            if ci.name == dep_type:
                for m in ci.public_methods:
                    if not m.is_constructor:
                        return m.name, len(m.parameters)
        return "process", 1

    def _build_imports(self, cls, deps, ctx, info=None) -> set[str]:
        imports: set[str] = set()
        imports.add(f"import {cls.fqcn};")
        for dep_type in deps:
            fqcn = ctx.fqcn_index.get(dep_type, "")
            if fqcn:
                imports.add(f"import {fqcn};")
        # Add imports for method parameter AND return types (used in template)
        for method in cls.public_methods:
            for param in method.parameters:
                base_type = param.type.replace("[]", "").replace("<>", "")
                if base_type.startswith("java.") or base_type in ("String", "int", "long",
                        "boolean", "double", "float", "byte", "short", "char", "void",
                        "Object"):
                    continue
                fqcn = ctx.fqcn_index.get(base_type, "")
                if fqcn:
                    imports.add(f"import {fqcn};")
            # Return type import (needed for templates that declare return type)
            if method.return_type and method.return_type != "void":
                rt = method.return_type.replace("[]", "").replace("<>", "")
                if not rt.startswith("java.") and rt not in ("String", "int", "long",
                        "boolean", "double", "float", "byte", "short", "char", "Object"):
                    fqcn = ctx.fqcn_index.get(rt, "")
                    if fqcn:
                        imports.add(f"import {fqcn};")
        # Add constants class import when applicable rules reference it
        if info:
            rules = self.applicable_rules(cls)
            needs_constants = any(r in rules for r in ("BR-010", "BR-011", "BR-015"))
            if needs_constants:
                for ci in info.all_classes:
                    if ci.kind == ClassKind.CONSTANTS:
                        imports.add(f"import {ci.fqcn};")
                        break
        imports.add("import org.junit.jupiter.api.Test;")
        imports.add("import org.junit.jupiter.api.extension.ExtendWith;")
        imports.add("import org.mockito.InjectMocks;")
        imports.add("import org.mockito.Mock;")
        imports.add("import org.mockito.junit.jupiter.MockitoExtension;")
        imports.add("import static org.junit.jupiter.api.Assertions.*;")
        imports.add("import static org.mockito.Mockito.*;")
        imports.add("import static org.mockito.ArgumentMatchers.*;")
        return imports
