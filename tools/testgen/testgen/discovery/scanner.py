"""Project scanner — orchestrates discovery across a Spring Boot project.

Two-pass streaming design:
  Pass 1 (index):  fast scan of class declarations → FQCN index
  Pass 2 (full):   full parse + classify + endpoint extraction → ProjectInfo

Data is NOT accumulated in-memory between passes; each ClassInfo is yielded
to the caller (or serialised to project.json) as soon as it's ready.
"""

from __future__ import annotations

import logging
import os
import re
import xml.etree.ElementTree as ET
from pathlib import Path
from typing import Iterator

import yaml

from ..models import (
    ClassInfo, ClassKind, EndpointInfo, EndpointMethodInfo,
    ExternalDependency, ProjectInfo,
)
from .regex_parser import parse_java_file, iter_java_files
from .classifier import classify

logger = logging.getLogger(__name__)

# Regex for extracting REST/SOAP endpoint details
_RE_REQUEST_MAPPING = re.compile(
    r'@RequestMapping\s*\(\s*(?:value\s*=\s*)?["\']([^"\']*)["\']'
)
_RE_HTTP_MAPPING = re.compile(
    r"@(Get|Post|Put|Delete|Patch)Mapping\s*\("
    r"(?:\s*value\s*=\s*)?[\"']([^\"']*)[\"']"
)
_RE_WEB_METHOD = re.compile(r'@WebMethod\s*\(\s*operationName\s*=\s*["\'](\w+)["\']')
_RE_WEB_SERVICE = re.compile(r'@WebService\s*\(([^)]*)\)', re.DOTALL)
_RE_VALUE_ANNOTATION = re.compile(r'@Value\s*\(\s*["\']?\$\{([^}]+)\}["\']?\s*\)')
_RE_BUSINESS_RULE = re.compile(r"\b(BR-\d{3})\b")


class ProjectScanner:
    """Scans a Maven/Spring Boot project and produces a ProjectInfo."""

    def __init__(self, project_path: str | Path, config: dict | None = None):
        self.project_path = Path(project_path).resolve()
        self.cfg = config or {}
        self._pom_path: Path | None = None
        self._source_root: Path | None = None
        self._resource_root: Path | None = None

    # ── Public API ───────────────────────────────────────────

    def scan(self) -> ProjectInfo:
        """Full discovery pipeline — returns a populated ProjectInfo."""
        info = ProjectInfo(project_path=str(self.project_path))

        # Step 1: Locate pom.xml and parse project metadata
        self._pom_path = self._find_pom()
        if self._pom_path:
            self._parse_pom(info)

        # Step 2: Locate source roots
        self._source_root = self._find_dir("src/main/java")
        self._resource_root = self._find_dir("src/main/resources")
        self._generated_source_root = self._find_dir("target/generated-sources")

        if not self._source_root:
            logger.error("No src/main/java found in %s", self.project_path)
            return info

        # Step 3: Pass 1 — build FQCN index (fast: only class declarations)
        info.fqcn_index = self._build_fqcn_index()
        logger.info("FQCN index: %d classes", len(info.fqcn_index))

        # Step 4: Pass 2 — full parse + classify (streaming)
        all_classes: list[ClassInfo] = []
        for ci in self._stream_classes():
            kind = classify(ci)
            # Create new ClassInfo with kind set (frozen dataclass)
            ci = ClassInfo(
                name=ci.name, package=ci.package, file_path=ci.file_path,
                kind=kind, fields=ci.fields, methods=ci.methods,
                annotations=ci.annotations, imports=ci.imports,
                superclass=ci.superclass, interfaces=ci.interfaces,
                class_type=ci.class_type,
            )
            all_classes.append(ci)

        # Step 5: Categorise into buckets + build endpoints
        self._categorise(info, all_classes)

        # Step 6: Detect base package
        info.base_package = self._detect_base_package(all_classes)

        # Step 7: Read config files
        if self._resource_root:
            info.configs = self._read_configs()

        # Step 8: External dependencies
        info.external_deps = list(self._discover_external_deps(all_classes, info.configs))

        # Step 9: Schemas
        if self._resource_root:
            info.schemas = [str(p) for p in self._resource_root.rglob("*.xsd")]
            info.schemas += [str(p) for p in self._resource_root.rglob("*.wsdl")]
            info.schemas += [str(p) for p in self._resource_root.rglob("*.wadl")]

        # Step 10: Migration doc business rules
        info.business_rules = self._parse_business_rules()

        # Step 11: Test dependency detection
        if self._pom_path:
            self._check_test_deps(info)

        logger.info(
            "Discovery complete: %d endpoints, %d services, %d processors, "
            "%d models, %d clients",
            len(info.endpoints), len(info.services), len(info.processors),
            len(info.models), len(info.clients),
        )
        return info

    # ── Pass 1: FQCN index ───────────────────────────────────

    def _build_fqcn_index(self) -> dict[str, str]:
        """Fast scan — extract (simple_name -> fqcn) from class declarations."""
        assert self._source_root is not None
        idx: dict[str, str] = {}
        class_decl = re.compile(
            r"(?:class|interface|enum|record)\s+(\w+)", re.MULTILINE
        )
        pkg_re = re.compile(r"^\s*package\s+([\w.]+)\s*;", re.MULTILINE)
        roots = [self._source_root]
        if self._generated_source_root and self._generated_source_root.is_dir():
            roots.append(self._generated_source_root)
        for root in roots:
            for java_file in iter_java_files(root):
                try:
                    text = java_file.read_text(encoding="utf-8", errors="replace")
                except OSError:
                    continue
                pkg_m = pkg_re.search(text)
                pkg = pkg_m.group(1) if pkg_m else ""
                for cm in class_decl.finditer(text):
                    idx[cm.group(1)] = f"{pkg}.{cm.group(1)}"
        return idx

    # ── Pass 2: Full parse (streaming) ───────────────────────

    def _stream_classes(self) -> Iterator[ClassInfo]:
        """Yield fully-parsed ClassInfo objects one at a time."""
        assert self._source_root is not None
        for java_file in iter_java_files(self._source_root):
            ci = parse_java_file(java_file)
            if ci is not None:
                yield ci

    # ── Categorisation ───────────────────────────────────────

    def _categorise(self, info: ProjectInfo, classes: list[ClassInfo]) -> None:
        """Sort classified classes into ProjectInfo buckets + build endpoints."""
        seen_names: set[str] = set()
        for ci in classes:
            if ci.name in seen_names:
                continue
            seen_names.add(ci.name)

            if ci.kind == ClassKind.REST_CONTROLLER:
                ep = self._build_rest_endpoint(ci)
                info.endpoints.append(ep)
            elif ci.kind == ClassKind.SOAP_ENDPOINT:
                ep = self._build_soap_endpoint(ci)
                info.endpoints.append(ep)
            elif ci.kind == ClassKind.SERVICE:
                info.services.append(ci)
            elif ci.kind == ClassKind.PROCESSOR:
                info.processors.append(ci)
            elif ci.kind == ClassKind.CLIENT:
                info.clients.append(ci)
            elif ci.kind == ClassKind.EXCEPTION:
                info.exceptions.append(ci)
            elif ci.kind == ClassKind.EXCEPTION_HANDLER:
                info.exception_handlers.append(ci)
            elif ci.kind == ClassKind.CONFIGURATION:
                info.configurations.append(ci)
            elif ci.kind == ClassKind.MODEL:
                info.models.append(ci)
            # SPRING_APP, CONSTANTS, UNKNOWN → models bucket
            elif ci.kind in (ClassKind.CONSTANTS,):
                info.models.append(ci)

    # ── Endpoint builders ────────────────────────────────────

    def _build_rest_endpoint(self, ci: ClassInfo) -> EndpointInfo:
        src = Path(ci.file_path).read_text(encoding="utf-8", errors="replace")
        base_path = ""
        rm = _RE_REQUEST_MAPPING.search(src)
        if rm:
            base_path = rm.group(1)

        methods: list[EndpointMethodInfo] = []
        for method in ci.public_methods:
            em = self._extract_rest_method(src, method, base_path)
            if em:
                methods.append(em)

        return EndpointInfo(
            class_info=ci,
            endpoint_type="REST",
            base_path=base_path,
            methods=tuple(methods),
            service_dependencies=ci.injected_dependencies,
        )

    def _extract_rest_method(self, src, method, base_path) -> EndpointMethodInfo | None:
        """Extract HTTP mapping details for a single method."""
        # Find the annotation region for this method
        for ann in method.annotations:
            if ann in ("GetMapping", "PostMapping", "PutMapping",
                       "DeleteMapping", "PatchMapping"):
                http = ann.replace("Mapping", "").upper()
                # Try to extract path from source
                pattern = re.compile(
                    rf"@{ann}\s*\(\s*(?:value\s*=\s*)?[\"']([^\"']*)[\"']"
                )
                path_match = pattern.search(src)
                path = path_match.group(1) if path_match else ""
                full_path = base_path + path

                # Detect content types
                consumes = self._extract_attr(src, ann, "consumes")
                produces = self._extract_attr(src, ann, "produces")

                # Request/response types from method signature
                req_type = method.parameters[0].type if method.parameters else None
                res_type = method.return_type if method.return_type != "void" else None

                return EndpointMethodInfo(
                    method_name=method.name,
                    http_method=http,
                    path=full_path,
                    request_type=req_type,
                    response_type=res_type,
                    consumes=consumes,
                    produces=produces,
                )

        # Check for @RequestMapping on the method level
        if "RequestMapping" in method.annotations:
            return EndpointMethodInfo(
                method_name=method.name,
                http_method="POST",
                path=base_path,
                request_type=method.parameters[0].type if method.parameters else None,
                response_type=method.return_type if method.return_type != "void" else None,
            )

        # Source-based fallback: scan for @XxxMapping near the method name
        # This handles cases where the parser didn't detect annotations
        # (e.g., multi-line annotations with {} in params)
        method_region = re.compile(
            rf'@(Get|Post|Put|Delete|Patch)Mapping\s*\([^)]*\)\s*'
            rf'(?:\s*\w+\s+)*{re.escape(method.name)}\s*\(',
            re.DOTALL,
        )
        m = method_region.search(src)
        if m:
            http_verb = m.group(1).upper()
            # Extract path
            ann_name = m.group(1) + "Mapping"
            path_pat = re.compile(
                rf'@{ann_name}\s*\([^)]*(?:value\s*=\s*)?["\']([^"\']*)["\']',
                re.DOTALL,
            )
            pm = path_pat.search(src)
            path = pm.group(1) if pm else ""
            full_path = base_path + path

            consumes = self._extract_attr_dotall(src, ann_name, "consumes")
            produces = self._extract_attr_dotall(src, ann_name, "produces")

            req_type = method.parameters[0].type if method.parameters else None
            res_type = method.return_type if method.return_type != "void" else None

            return EndpointMethodInfo(
                method_name=method.name,
                http_method=http_verb,
                path=full_path,
                request_type=req_type,
                response_type=res_type,
                consumes=consumes,
                produces=produces,
            )
        return None

    def _build_soap_endpoint(self, ci: ClassInfo) -> EndpointInfo:
        src = Path(ci.file_path).read_text(encoding="utf-8", errors="replace")
        methods: list[EndpointMethodInfo] = []
        for method in ci.public_methods:
            op_name = method.name
            wm = _RE_WEB_METHOD.search(src)
            if wm:
                op_name = wm.group(1)
            methods.append(EndpointMethodInfo(
                method_name=method.name,
                http_method="SOAP",
                path="",
                request_type=method.parameters[0].type if method.parameters else None,
                response_type=method.return_type if method.return_type != "void" else None,
                operation_name=op_name,
            ))

        # Extract service name from @WebService
        ws_match = _RE_WEB_SERVICE.search(src)
        soap_path = ""
        if ws_match:
            sn = re.search(r'serviceName\s*=\s*["\'](\w+)["\']', ws_match.group(1))
            if sn:
                soap_path = f"/services/{sn.group(1)}"

        return EndpointInfo(
            class_info=ci,
            endpoint_type="SOAP",
            base_path=soap_path,
            methods=tuple(methods),
            service_dependencies=ci.injected_dependencies,
        )

    # ── POM parsing ──────────────────────────────────────────

    def _find_pom(self) -> Path | None:
        p = self.project_path / "pom.xml"
        if p.is_file():
            return p
        # One level down
        for child in self.project_path.iterdir():
            if child.is_dir():
                candidate = child / "pom.xml"
                if candidate.is_file():
                    return candidate
        return None

    def _parse_pom(self, info: ProjectInfo) -> None:
        assert self._pom_path is not None
        try:
            tree = ET.parse(self._pom_path)
        except ET.ParseError:
            logger.warning("Cannot parse pom.xml")
            return
        root = tree.getroot()
        ns = ""
        if root.tag.startswith("{"):
            ns = root.tag.split("}")[0] + "}"

        info.group_id = (root.findtext(f"{ns}groupId") or
                         root.findtext(f"{ns}parent/{ns}groupId") or "")
        info.artifact_id = root.findtext(f"{ns}artifactId") or ""
        info.version = (root.findtext(f"{ns}version") or
                        root.findtext(f"{ns}parent/{ns}version") or "")
        parent_art = root.findtext(f"{ns}parent/{ns}artifactId") or ""
        if "spring-boot" in parent_art:
            info.spring_boot_version = root.findtext(f"{ns}parent/{ns}version") or ""

        props = root.find(f"{ns}properties")
        if props is not None:
            jv = (props.findtext(f"{ns}java.version") or
                  props.findtext(f"{ns}maven.compiler.source") or "")
            info.java_version = jv

    def _check_test_deps(self, info: ProjectInfo) -> None:
        assert self._pom_path is not None
        try:
            text = self._pom_path.read_text(encoding="utf-8")
        except OSError:
            return
        info.has_wiremock = "wiremock" in text.lower()
        info.has_spring_test = "spring-boot-starter-test" in text

    # ── Config files ─────────────────────────────────────────

    def _read_configs(self) -> dict:
        assert self._resource_root is not None
        configs: dict = {}
        for yml in sorted(self._resource_root.glob("application*.yml")):
            try:
                data = yaml.safe_load(yml.read_text(encoding="utf-8")) or {}
                configs[yml.stem] = data
            except Exception:
                logger.warning("Cannot parse %s", yml)
        return configs

    # ── External dependencies ────────────────────────────────

    def _discover_external_deps(self, classes, configs) -> Iterator[ExternalDependency]:
        """Detect external service dependencies via @Value properties."""
        for ci in classes:
            if ci.kind != ClassKind.CLIENT:
                continue
            src = Path(ci.file_path).read_text(encoding="utf-8", errors="replace")
            for prop_match in _RE_VALUE_ANNOTATION.finditer(src):
                prop_key = prop_match.group(1).split(":")[0]
                if any(k in prop_key.lower() for k in ("url", "uri", "endpoint")):
                    url_val = self._resolve_property(prop_key, configs)
                    protocol = "SOAP" if "wsdl" in url_val.lower() or "soap" in ci.name.lower() else "HTTP"
                    yield ExternalDependency(
                        class_name=ci.name,
                        url_property=prop_key,
                        url_value=url_val,
                        protocol=protocol,
                    )

    def _resolve_property(self, key: str, configs: dict) -> str:
        """Resolve a dot-notation property from YAML configs."""
        for _profile, cfg in configs.items():
            if not isinstance(cfg, dict):
                continue
            val = cfg
            for part in key.split("."):
                if isinstance(val, dict):
                    val = val.get(part, val.get(part.replace("-", "_"), {}))
                else:
                    break
            if isinstance(val, str):
                return val
        return ""

    # ── Business rules ───────────────────────────────────────

    def _parse_business_rules(self) -> list[str]:
        """Extract BR-NNN identifiers from migration docs."""
        rules: set[str] = set()
        for md in self.project_path.parent.glob("*.md"):
            try:
                text = md.read_text(encoding="utf-8", errors="replace")
                for m in _RE_BUSINESS_RULE.finditer(text):
                    rules.add(m.group(1))
            except OSError:
                continue
        return sorted(rules)

    # ── Helpers ──────────────────────────────────────────────

    def _find_dir(self, relative: str) -> Path | None:
        d = self.project_path / relative
        return d if d.is_dir() else None

    def _detect_base_package(self, classes: list[ClassInfo]) -> str:
        for ci in classes:
            if ci.kind == ClassKind.SPRING_APP:
                return ci.package
        packages = [ci.package for ci in classes if ci.package]
        if not packages:
            return ""
        return os.path.commonprefix(packages).rstrip(".")

    @staticmethod
    def _extract_attr(src: str, annotation: str, attr: str) -> str | None:
        pat = re.compile(rf'@{annotation}\s*\([^)]*{attr}\s*=\s*([^,)]+)')
        m = pat.search(src)
        if m:
            val = m.group(1).strip().strip('"').strip("'")
            return val
        return None

    @staticmethod
    def _extract_attr_dotall(src: str, annotation: str, attr: str) -> str | None:
        """Like _extract_attr but handles multi-line annotations with {} array values."""
        pat = re.compile(
            rf'@{annotation}\s*\(.*?{attr}\s*=\s*\{{([^}}]+)\}}',
            re.DOTALL,
        )
        m = pat.search(src)
        if m:
            val = m.group(1).strip()
            return val
        return ProjectScanner._extract_attr(src, annotation, attr)
