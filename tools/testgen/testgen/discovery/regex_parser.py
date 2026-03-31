"""Regex-based Java source parser.

Parses Java source files into ClassInfo objects using compiled regex patterns.
This is the default parser; an AST-based parser (tree-sitter) can replace it
as a drop-in alternative once installed.

Design notes vs v1:
  - No global file cache — caller decides caching strategy
  - Comment stripping done in-place (single copy)
  - _find_annotation_block uses sentinel scan (not arbitrary char lookback)
  - split_generics imported from models (shared)
"""

from __future__ import annotations

import re
import logging
from pathlib import Path
from typing import Iterator

from ..models import (
    ClassInfo, ClassKind, FieldInfo, MethodInfo, ParameterInfo,
    split_generics,
)

logger = logging.getLogger(__name__)

# ── Compiled regex patterns ──────────────────────────────────

_RE_PACKAGE = re.compile(r"^\s*package\s+([\w.]+)\s*;", re.MULTILINE)
_RE_IMPORT = re.compile(r"^\s*import\s+(?:static\s+)?([\w.*]+)\s*;", re.MULTILINE)

_RE_CLASS_DECL = re.compile(
    r"(?:public\s+|protected\s+|private\s+)?"
    r"(?:abstract\s+)?(?:final\s+)?"
    r"(class|interface|enum|record)\s+(\w+)"
    r"(?:\s+extends\s+([\w<>,.\s]+?))?"
    r"(?:\s+implements\s+([\w<>,.\s]+?))?"
    r"\s*[\{(]",
    re.MULTILINE,
)

_RE_FIELD = re.compile(
    r"(private|protected|public)[ \t]+"
    r"((?:static[ \t]+)?(?:final[ \t]+)?)"            # modifiers group
    r"([\w<>\[\]?,.\s]+?)[ \t]+(\w+)[ \t]*[;=]",
    re.MULTILINE,
)

_RE_METHOD_SIG = re.compile(
    r"(public|protected|private)[ \t]+"
    r"((?:static[ \t]+)?(?:final[ \t]+)?(?:synchronized[ \t]+)?)"
    r"([\w<>\[\]?,.\s]+?)[ \t]+(\w+)[ \t]*\(",
    re.MULTILINE,
)

_RE_CONSTRUCTOR_SIG = re.compile(
    r"(public|protected|private)\s+(\w+)\s*\(", re.MULTILINE
)

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
_RE_ANNOTATION_NAME = re.compile(r"@(\w+)")


# ── Public API ───────────────────────────────────────────────

def parse_java_file(file_path: str | Path) -> ClassInfo | None:
    """Parse a single Java source file into a ClassInfo.

    Returns None if the file cannot be parsed (not a class, or parse error).
    """
    path = Path(file_path)
    try:
        src = path.read_text(encoding="utf-8", errors="replace")
    except OSError:
        logger.warning("Cannot read %s", path)
        return None

    # Strip comments (single pass, in-place)
    clean = re.sub(r"/\*.*?\*/", "", src, flags=re.DOTALL)
    clean = re.sub(r"//[^\n]*", "", clean)

    # Package
    pkg_match = _RE_PACKAGE.search(clean)
    package = pkg_match.group(1) if pkg_match else ""

    # Imports
    imports = tuple(_RE_IMPORT.findall(clean))

    # Class declaration
    cls_match = _RE_CLASS_DECL.search(clean)
    if not cls_match:
        return None
    class_type = cls_match.group(1)         # class | interface | enum | record
    class_name = cls_match.group(2)
    superclass = cls_match.group(3)
    interfaces_raw = cls_match.group(4) or ""
    interfaces = tuple(i.strip() for i in interfaces_raw.split(",") if i.strip())

    # Annotations on the class (search region before class declaration)
    class_region = clean[: cls_match.start()]
    annotations = _extract_annotations(class_region)

    # Fields
    fields = _extract_fields(clean, cls_match.end())

    # Methods + constructors
    methods = _extract_methods(clean, cls_match.end(), class_name)

    return ClassInfo(
        name=class_name,
        package=package,
        file_path=str(path.resolve()),
        kind=ClassKind.UNKNOWN,      # classification happens separately
        fields=tuple(fields),
        methods=tuple(methods),
        annotations=tuple(annotations),
        imports=imports,
        superclass=superclass.strip() if superclass else None,
        interfaces=interfaces,
        class_type=class_type,
    )


def iter_java_files(source_root: str | Path) -> Iterator[Path]:
    """Yield all .java files under source_root."""
    root = Path(source_root)
    if not root.is_dir():
        return
    yield from sorted(root.rglob("*.java"))


# ── Internal helpers ─────────────────────────────────────────

def _extract_annotations(text: str) -> list[str]:
    """Extract annotation names from a text block (e.g., '@RestController')."""
    results: list[str] = []
    for m in _RE_ANNOTATION_NAME.finditer(text):
        ann = m.group(1)
        # Skip common non-annotation matches
        if ann in ("param", "return", "throws", "see", "link", "code",
                   "value", "author", "since", "Override"):
            continue
        results.append(ann)
    return results


def _extract_fields(src: str, class_body_start: int) -> list[FieldInfo]:
    """Extract field declarations from class body."""
    body = src[class_body_start:]
    fields: list[FieldInfo] = []
    for m in _RE_FIELD.finditer(body):
        access = m.group(1)
        modifiers = m.group(2).strip()
        ftype = m.group(3).strip()
        fname = m.group(4)
        is_static = "static" in modifiers
        is_final = "final" in modifiers

        # Find annotations preceding this field (walk backward to sentinel)
        field_start = class_body_start + m.start()
        ann_block = _find_annotation_block(src, field_start)
        anns = _extract_annotations(ann_block)

        fields.append(FieldInfo(
            name=fname,
            type=ftype,
            annotations=tuple(anns),
            access=access,
            is_static=is_static,
            is_final=is_final,
        ))
    return fields


def _extract_methods(src: str, class_body_start: int, class_name: str) -> list[MethodInfo]:
    """Extract method and constructor declarations from class body."""
    body = src[class_body_start:]
    methods: list[MethodInfo] = []
    seen: set[str] = set()

    # Regular methods
    for m in _RE_METHOD_SIG.finditer(body):
        access = m.group(1)
        modifiers = m.group(2).strip()
        ret_type = m.group(3).strip()
        mname = m.group(4)
        is_static = "static" in modifiers

        # Parse parameters
        abs_pos = class_body_start + m.end()
        raw_params = _extract_balanced(src, abs_pos - 1)  # -1 to include the '('
        params = _parse_params(raw_params)

        # Annotations
        method_start = class_body_start + m.start()
        ann_block = _find_annotation_block(src, method_start)
        anns = _extract_annotations(ann_block)

        key = f"{mname}({','.join(p.type for p in params)})"
        if key not in seen:
            seen.add(key)
            methods.append(MethodInfo(
                name=mname,
                return_type=ret_type,
                parameters=tuple(params),
                annotations=tuple(anns),
                access=access,
                is_static=is_static,
                is_constructor=False,
            ))

    # Constructors
    for m in _RE_CONSTRUCTOR_SIG.finditer(body):
        cname = m.group(2)
        if cname != class_name:
            continue
        access = m.group(1)
        abs_pos = class_body_start + m.end()
        raw_params = _extract_balanced(src, abs_pos - 1)
        params = _parse_params(raw_params)

        key = f"<init>({','.join(p.type for p in params)})"
        if key not in seen:
            seen.add(key)
            methods.append(MethodInfo(
                name=class_name,
                return_type="",
                parameters=tuple(params),
                annotations=(),
                access=access,
                is_static=False,
                is_constructor=True,
            ))

    return methods


def _find_annotation_block(src: str, pos: int) -> str:
    """Walk backward from *pos* to find the annotation block boundary.

    Stops at '}', '{', ';', or start-of-file — these are statement boundaries.
    Handles balanced `{}` inside annotation parameters (e.g., @PostMapping(consumes = {...})).
    """
    start = pos
    paren_depth = 0  # Track balanced () for annotation params
    while start > 0:
        ch = src[start - 1]
        # Track parentheses depth to know if we're inside annotation params
        if ch == ')':
            paren_depth += 1
        elif ch == '(':
            paren_depth -= 1
        elif ch in "}{"  and paren_depth > 0:
            # Inside annotation params — skip braces like consumes = {X, Y}
            start -= 1
            continue
        elif ch in "}{;" and paren_depth == 0:
            # Real statement boundary — not inside annotation params
            preceding = src[start:pos].strip()
            if preceding and preceding[0] == "@":
                break
            if ch == "\n":
                start -= 1
                continue
            break
        start -= 1
    return src[start:pos]


def _extract_balanced(src: str, start: int, open_ch: str = "(", close_ch: str = ")") -> str:
    """Extract content between balanced delimiters starting at position *start*."""
    if start >= len(src) or src[start] != open_ch:
        return ""
    depth = 0
    end = start
    limit = min(start + 3000, len(src))
    while end < limit:
        ch = src[end]
        if ch == open_ch:
            depth += 1
        elif ch == close_ch:
            depth -= 1
            if depth == 0:
                return src[start + 1: end]
        end += 1
    return src[start + 1: end]


def _parse_params(raw: str) -> list[ParameterInfo]:
    """Parse a raw parameter string into ParameterInfo objects."""
    raw = raw.strip()
    if not raw:
        return []

    parts = split_generics(raw)
    params: list[ParameterInfo] = []
    for part in parts:
        part = part.strip()
        if not part:
            continue
        # Strip annotations from parameter
        clean = re.sub(r"@\w+(?:\([^)]*\))?\s*", "", part).strip()
        tokens = clean.split()
        if len(tokens) >= 2:
            ptype = " ".join(tokens[:-1])
            pname = tokens[-1]
            # Extract annotations
            anns = _RE_ANNOTATION_NAME.findall(part[:len(part) - len(clean)])
            params.append(ParameterInfo(
                name=pname,
                type=ptype,
                annotations=tuple(anns),
            ))
    return params
