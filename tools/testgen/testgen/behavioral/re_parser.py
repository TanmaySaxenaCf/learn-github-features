"""RE document parser — extracts business rules, field mappings, and test cases.

Parses markdown files from reverse-engineering output to build structured
specifications for behavioral test generation.
"""

from __future__ import annotations

import logging
import re
from pathlib import Path

from ..models import (
    BehavioralContext, BusinessRuleSpec, FieldMappingEntry,
    FieldMappingSpec, TestCaseSpec,
)

logger = logging.getLogger(__name__)


def parse_re_docs(re_docs_path: str | Path) -> BehavioralContext:
    """Parse all RE documents in a directory and return a BehavioralContext."""
    docs_dir = Path(re_docs_path)
    ctx = BehavioralContext(re_docs_path=str(docs_dir))

    # Business rules catalog
    br_file = _find_file(docs_dir, "04-BUSINESS-RULES-CATALOG")
    if br_file:
        ctx.business_rules = _parse_business_rules(br_file)
        logger.info("Parsed %d business rules from %s", len(ctx.business_rules), br_file.name)

    # Field-to-field mappings
    map_file = _find_file(docs_dir, "10-FIELD-TO-FIELD-MAPPING")
    if map_file:
        ctx.field_mappings = _parse_field_mappings(map_file)
        logger.info("Parsed %d field mappings from %s", len(ctx.field_mappings), map_file.name)

    # Test case inventory
    tc_file = _find_file(docs_dir, "08-TEST-CASE-INVENTORY")
    if tc_file:
        ctx.test_cases = _parse_test_cases(tc_file)
        logger.info("Parsed %d test cases from %s", len(ctx.test_cases), tc_file.name)

    return ctx


# ── Business Rules Parser ────────────────────────────────────

_BR_HEADER = re.compile(r"^####?\s+BR-(\d{3}):\s*(.+)", re.MULTILINE)
_FIELD_VALUE = re.compile(r"\|\s*\*\*(\w[\w\s]*?)\*\*\s*\|\s*(.+?)\s*\|")


def _parse_business_rules(path: Path) -> list[BusinessRuleSpec]:
    text = path.read_text(encoding="utf-8", errors="replace")
    rules: list[BusinessRuleSpec] = []

    # Split by BR-### headers
    sections = re.split(r"(?=^####?\s+BR-\d{3})", text, flags=re.MULTILINE)

    for section in sections:
        m = _BR_HEADER.search(section)
        if not m:
            continue

        rule_id = f"BR-{m.group(1)}"
        name = m.group(2).strip()
        fields = dict(_FIELD_VALUE.findall(section))

        rules.append(BusinessRuleSpec(
            rule_id=rule_id,
            name=name,
            category=fields.get("Category", ""),
            priority=fields.get("Priority", ""),
            description=fields.get("Description", ""),
            business_logic=fields.get("Business Logic", ""),
            component_ids=tuple(
                c.strip() for c in fields.get("Component ID", "").split(",") if c.strip()
            ),
        ))

    return rules


# ── Field Mapping Parser ─────────────────────────────────────

_MAP_HEADER = re.compile(r"^###?\s+\d+\.\d+\s+MAP-(\d{3}):\s*(.+)", re.MULTILINE)
_MAP_ID_RE = re.compile(r"\*\*Mapping ID:\*\*\s*MAP-(\d{3})")
_MAP_TABLE_ROW = re.compile(
    r"\|\s*\d+\s*\|\s*(.+?)\s*\|\s*(.+?)\s*\|\s*(.+?)\s*\|"
)


def _parse_field_mappings(path: Path) -> list[FieldMappingSpec]:
    text = path.read_text(encoding="utf-8", errors="replace")
    mappings: list[FieldMappingSpec] = []

    # Parse the mapping index table to get source/target types
    index: dict[str, dict[str, str]] = {}
    index_section = re.search(
        r"## 2\. Mapping Index.*?\n(\|.+\|[\s\S]*?)(?=\n## |\Z)", text
    )
    if index_section:
        for row in re.finditer(
            r"\|\s*(MAP-\d{3})\s*\|\s*(.+?)\s*\|\s*(.+?)\s*\|\s*(.+?)\s*\|\s*(.+?)\s*\|",
            index_section.group(1),
        ):
            index[row.group(1)] = {
                "name": row.group(2).strip(),
                "source": row.group(3).strip(),
                "target": row.group(4).strip(),
                "component": row.group(5).strip(),
            }

    # Split by MAP sections and parse field tables
    sections = re.split(r"(?=^###?\s+\d+\.\d+\s+MAP-\d{3})", text, flags=re.MULTILINE)

    for section in sections:
        m = _MAP_HEADER.search(section)
        if not m:
            continue

        map_id = f"MAP-{m.group(1)}"
        idx_info = index.get(map_id, {})

        # Parse field mapping table rows
        fields: list[FieldMappingEntry] = []
        # Look for table rows with numbered fields
        for row in _MAP_TABLE_ROW.finditer(section):
            source = row.group(1).strip()
            target = row.group(2).strip()
            transform = row.group(3).strip()
            if source and target and not source.startswith("**"):
                fields.append(FieldMappingEntry(
                    source_field=source,
                    target_field=target,
                    transformation=transform,
                ))

        mappings.append(FieldMappingSpec(
            mapping_id=map_id,
            name=idx_info.get("name", m.group(2).strip()),
            source_type=idx_info.get("source", ""),
            target_type=idx_info.get("target", ""),
            component_id=idx_info.get("component", ""),
            fields=tuple(fields),
        ))

    return mappings


# ── Test Case Parser ─────────────────────────────────────────

_TC_HEADER = re.compile(r"^####?\s+(TC-\w+-\d{3}):\s*(.+)", re.MULTILINE)
_TC_TABLE_ROW = re.compile(r"\|\s*(\d+)\s*\|\s*(.+?)\s*\|\s*(.+?)\s*\|")


def _parse_test_cases(path: Path) -> list[TestCaseSpec]:
    text = path.read_text(encoding="utf-8", errors="replace")
    test_cases: list[TestCaseSpec] = []

    # Split by TC headers
    sections = re.split(r"(?=^####?\s+TC-\w+-\d{3})", text, flags=re.MULTILINE)

    for section in sections:
        m = _TC_HEADER.search(section)
        if not m:
            continue

        test_id = m.group(1)
        title = m.group(2).strip()
        fields = dict(_FIELD_VALUE.findall(section))

        # Parse test steps table
        steps: list[tuple[str, str]] = []
        steps_section = re.search(r"\*\*Test Steps:\*\*.*?\n(\|.+\|[\s\S]*?)(?=\n\*\*|\n---|\n####|\Z)", section)
        if steps_section:
            for row in _TC_TABLE_ROW.finditer(steps_section.group(1)):
                steps.append((row.group(2).strip(), row.group(3).strip()))

        # Parse test data table
        test_data: dict[str, str] = {}
        data_section = re.search(r"\*\*Test Data:\*\*.*?\n(\|.+\|[\s\S]*?)(?=\n\*\*|\n---|\n####|\Z)", section)
        if data_section:
            for row in re.finditer(r"\|\s*(\w+)\s*\|\s*(.+?)\s*\|", data_section.group(1)):
                key = row.group(1).strip()
                val = row.group(2).strip()
                if key.lower() not in ("field", "---", "**field**"):
                    test_data[key] = val

        component_str = fields.get("Component(s)", fields.get("Component", ""))
        br_str = fields.get("Business Rule(s)", "")

        test_cases.append(TestCaseSpec(
            test_id=test_id,
            title=title,
            category=fields.get("Category", ""),
            priority=fields.get("Priority", ""),
            component_ids=tuple(c.strip() for c in component_str.split(",") if c.strip()),
            business_rules=tuple(
                r.strip() for r in re.findall(r"BR-\d{3}", br_str)
            ),
            steps=tuple(steps),
            test_data=test_data,
        ))

    # Also parse summary tables for test cases listed without full detail
    summary_pattern = re.compile(
        r"\|\s*(TC-\w+-\d{3})\s*\|\s*(.+?)\s*\|\s*(.+?)\s*\|"
    )
    known_ids = {tc.test_id for tc in test_cases}
    for m in summary_pattern.finditer(text):
        tc_id = m.group(1)
        if tc_id not in known_ids:
            test_cases.append(TestCaseSpec(
                test_id=tc_id,
                title=m.group(2).strip(),
                category=_infer_category(tc_id),
                priority=m.group(3).strip(),
            ))
            known_ids.add(tc_id)

    return test_cases


# ── Helpers ──────────────────────────────────────────────────

def _find_file(docs_dir: Path, prefix: str) -> Path | None:
    for f in docs_dir.iterdir():
        if f.is_file() and f.stem.upper().startswith(prefix.upper()):
            return f
    return None


def _infer_category(test_id: str) -> str:
    if "FUNC" in test_id:
        return "Functional"
    if "INT" in test_id:
        return "Integration"
    if "SEC" in test_id:
        return "Security"
    if "ERR" in test_id:
        return "Error Handling"
    if "PERF" in test_id:
        return "Performance"
    return "Unknown"
