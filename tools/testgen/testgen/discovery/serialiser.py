"""Serialise / deserialise ProjectInfo to .testgen/project.json.

This intermediate format enables:
  - Cached discovery (run once, generate many)
  - Incremental checksums (skip unchanged files)
  - Human-readable inspection of discovery output
  - Decoupled commands (discover → junit → wiremock → postman)
"""

from __future__ import annotations

import json
import hashlib
from dataclasses import asdict
from pathlib import Path
from typing import Any

from ..models import (
    ClassInfo, ClassKind, EndpointInfo, EndpointMethodInfo,
    ExternalDependency, FieldInfo, MethodInfo, ParameterInfo,
    ProjectInfo,
)

TESTGEN_DIR = ".testgen"
PROJECT_JSON = "project.json"
CHECKSUMS_JSON = "checksums.json"


def save_project(info: ProjectInfo, project_path: str | Path) -> Path:
    """Serialise ProjectInfo to <project>/.testgen/project.json."""
    out_dir = Path(project_path) / TESTGEN_DIR
    out_dir.mkdir(parents=True, exist_ok=True)
    out_file = out_dir / PROJECT_JSON

    data = _serialise(info)
    out_file.write_text(json.dumps(data, indent=2, default=str), encoding="utf-8")
    return out_file


def load_project(project_path: str | Path) -> ProjectInfo:
    """Deserialise ProjectInfo from <project>/.testgen/project.json."""
    in_file = Path(project_path) / TESTGEN_DIR / PROJECT_JSON
    if not in_file.is_file():
        raise FileNotFoundError(
            f"No {PROJECT_JSON} found.  Run `testgen discover` first."
        )
    data = json.loads(in_file.read_text(encoding="utf-8"))
    return _deserialise(data)


def save_checksums(project_path: str | Path, checksums: dict[str, str]) -> Path:
    """Write file checksums for incremental mode."""
    out_dir = Path(project_path) / TESTGEN_DIR
    out_dir.mkdir(parents=True, exist_ok=True)
    out_file = out_dir / CHECKSUMS_JSON
    out_file.write_text(json.dumps(checksums, indent=2), encoding="utf-8")
    return out_file


def load_checksums(project_path: str | Path) -> dict[str, str]:
    """Load previous checksums (empty dict if none exist)."""
    in_file = Path(project_path) / TESTGEN_DIR / CHECKSUMS_JSON
    if not in_file.is_file():
        return {}
    return json.loads(in_file.read_text(encoding="utf-8"))


def compute_file_checksum(file_path: str | Path) -> str:
    return hashlib.sha256(Path(file_path).read_bytes()).hexdigest()


# ── Serialisation helpers ────────────────────────────────────

def _serialise(info: ProjectInfo) -> dict[str, Any]:
    """Convert ProjectInfo to a JSON-compatible dict."""
    return {
        "project_path": info.project_path,
        "group_id": info.group_id,
        "artifact_id": info.artifact_id,
        "version": info.version,
        "spring_boot_version": info.spring_boot_version,
        "java_version": info.java_version,
        "base_package": info.base_package,
        "fqcn_index": info.fqcn_index,
        "endpoints": [_ser_endpoint(ep) for ep in info.endpoints],
        "services": [_ser_class(c) for c in info.services],
        "processors": [_ser_class(c) for c in info.processors],
        "models": [_ser_class(c) for c in info.models],
        "clients": [_ser_class(c) for c in info.clients],
        "exceptions": [_ser_class(c) for c in info.exceptions],
        "exception_handlers": [_ser_class(c) for c in info.exception_handlers],
        "configurations": [_ser_class(c) for c in info.configurations],
        "external_deps": [_ser_ext_dep(d) for d in info.external_deps],
        "configs": info.configs,
        "schemas": info.schemas,
        "business_rules": info.business_rules,
        "has_wiremock": info.has_wiremock,
        "has_spring_test": info.has_spring_test,
    }


def _ser_class(ci: ClassInfo) -> dict:
    return {
        "name": ci.name,
        "package": ci.package,
        "file_path": ci.file_path,
        "kind": ci.kind.name,
        "fields": [_ser_field(f) for f in ci.fields],
        "methods": [_ser_method(m) for m in ci.methods],
        "annotations": list(ci.annotations),
        "imports": list(ci.imports),
        "superclass": ci.superclass,
        "interfaces": list(ci.interfaces),
        "class_type": ci.class_type,
    }


def _ser_field(f: FieldInfo) -> dict:
    return {"name": f.name, "type": f.type, "annotations": list(f.annotations),
            "access": f.access, "is_static": f.is_static, "is_final": f.is_final}


def _ser_method(m: MethodInfo) -> dict:
    return {
        "name": m.name, "return_type": m.return_type,
        "parameters": [{"name": p.name, "type": p.type,
                         "annotations": list(p.annotations)} for p in m.parameters],
        "annotations": list(m.annotations), "access": m.access,
        "is_static": m.is_static, "is_constructor": m.is_constructor,
    }


def _ser_endpoint(ep: EndpointInfo) -> dict:
    return {
        "class_info": _ser_class(ep.class_info),
        "endpoint_type": ep.endpoint_type,
        "base_path": ep.base_path,
        "methods": [
            {"method_name": em.method_name, "http_method": em.http_method,
             "path": em.path, "request_type": em.request_type,
             "response_type": em.response_type, "consumes": em.consumes,
             "produces": em.produces, "soap_action": em.soap_action,
             "operation_name": em.operation_name}
            for em in ep.methods
        ],
        "service_dependencies": list(ep.service_dependencies),
    }


def _ser_ext_dep(d: ExternalDependency) -> dict:
    return {"class_name": d.class_name, "url_property": d.url_property,
            "url_value": d.url_value, "protocol": d.protocol}


# ── Deserialisation helpers ──────────────────────────────────

def _deserialise(data: dict) -> ProjectInfo:
    info = ProjectInfo(
        project_path=data.get("project_path", ""),
        group_id=data.get("group_id", ""),
        artifact_id=data.get("artifact_id", ""),
        version=data.get("version", ""),
        spring_boot_version=data.get("spring_boot_version", ""),
        java_version=data.get("java_version", ""),
        base_package=data.get("base_package", ""),
        fqcn_index=data.get("fqcn_index", {}),
    )
    info.endpoints = [_deser_endpoint(e) for e in data.get("endpoints", [])]
    info.services = [_deser_class(c) for c in data.get("services", [])]
    info.processors = [_deser_class(c) for c in data.get("processors", [])]
    info.models = [_deser_class(c) for c in data.get("models", [])]
    info.clients = [_deser_class(c) for c in data.get("clients", [])]
    info.exceptions = [_deser_class(c) for c in data.get("exceptions", [])]
    info.exception_handlers = [_deser_class(c) for c in data.get("exception_handlers", [])]
    info.configurations = [_deser_class(c) for c in data.get("configurations", [])]
    info.external_deps = [_deser_ext_dep(d) for d in data.get("external_deps", [])]
    info.configs = data.get("configs", {})
    info.schemas = data.get("schemas", [])
    info.business_rules = data.get("business_rules", [])
    info.has_wiremock = data.get("has_wiremock", False)
    info.has_spring_test = data.get("has_spring_test", False)
    return info


def _deser_class(d: dict) -> ClassInfo:
    return ClassInfo(
        name=d["name"], package=d["package"], file_path=d["file_path"],
        kind=ClassKind[d.get("kind", "UNKNOWN")],
        fields=tuple(_deser_field(f) for f in d.get("fields", [])),
        methods=tuple(_deser_method(m) for m in d.get("methods", [])),
        annotations=tuple(d.get("annotations", [])),
        imports=tuple(d.get("imports", [])),
        superclass=d.get("superclass"),
        interfaces=tuple(d.get("interfaces", [])),
        class_type=d.get("class_type", "class"),
    )


def _deser_field(d: dict) -> FieldInfo:
    return FieldInfo(name=d["name"], type=d["type"],
                     annotations=tuple(d.get("annotations", [])),
                     access=d.get("access", "private"),
                     is_static=d.get("is_static", False),
                     is_final=d.get("is_final", False))


def _deser_method(d: dict) -> MethodInfo:
    return MethodInfo(
        name=d["name"], return_type=d["return_type"],
        parameters=tuple(
            ParameterInfo(name=p["name"], type=p["type"],
                          annotations=tuple(p.get("annotations", [])))
            for p in d.get("parameters", [])
        ),
        annotations=tuple(d.get("annotations", [])),
        access=d.get("access", "public"),
        is_static=d.get("is_static", False),
        is_constructor=d.get("is_constructor", False),
    )


def _deser_endpoint(d: dict) -> EndpointInfo:
    return EndpointInfo(
        class_info=_deser_class(d["class_info"]),
        endpoint_type=d["endpoint_type"],
        base_path=d.get("base_path", ""),
        methods=tuple(
            EndpointMethodInfo(
                method_name=em["method_name"], http_method=em["http_method"],
                path=em.get("path", ""), request_type=em.get("request_type"),
                response_type=em.get("response_type"), consumes=em.get("consumes"),
                produces=em.get("produces"), soap_action=em.get("soap_action"),
                operation_name=em.get("operation_name"),
            )
            for em in d.get("methods", [])
        ),
        service_dependencies=tuple(d.get("service_dependencies", [])),
    )


def _deser_ext_dep(d: dict) -> ExternalDependency:
    return ExternalDependency(
        class_name=d["class_name"], url_property=d.get("url_property", ""),
        url_value=d.get("url_value", ""), protocol=d.get("protocol", "HTTP"),
    )
