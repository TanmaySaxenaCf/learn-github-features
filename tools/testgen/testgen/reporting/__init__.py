"""Markdown report generator."""

from __future__ import annotations

import logging
from datetime import datetime
from pathlib import Path

from ..models import ProjectInfo
from ..execution.maven_runner import TestSummary

logger = logging.getLogger(__name__)


class ReportGenerator:
    """Generates a Markdown test report."""

    def __init__(self, info: ProjectInfo, config: dict | None = None):
        self.info = info
        self.cfg = config or {}

    def generate(self, summary: TestSummary | None = None,
                 junit_files: list[str] | None = None,
                 wiremock_files: list[str] | None = None,
                 postman_files: list[str] | None = None) -> str:
        """Generate report and write to <project>/reports/. Returns file path."""
        sections = [
            self._header(),
            self._discovery_summary(),
            self._endpoints_table(),
        ]
        if junit_files:
            sections.append(self._generated_files("JUnit Test Files", junit_files))
        if wiremock_files:
            sections.append(self._generated_files("WireMock Integration Files", wiremock_files))
        if postman_files:
            sections.append(self._generated_files("Postman Files", postman_files))
        if summary:
            sections.append(self._test_results(summary))
        if self.info.business_rules:
            sections.append(self._business_rules())
        sections.append(self._recommendations(summary))

        content = "\n\n".join(sections)

        out_dir = Path(self.info.project_path) / self.cfg.get("reporting", {}).get("output_dir", "reports")
        out_dir.mkdir(parents=True, exist_ok=True)
        ts = datetime.now().strftime("%Y-%m-%d_%H-%M-%S")
        out_file = out_dir / f"test_report_{ts}.md"
        out_file.write_text(content, encoding="utf-8")
        logger.info("Report written to %s", out_file)
        return str(out_file)

    def _header(self) -> str:
        return (
            f"# Test Report — {self.info.artifact_id}\n\n"
            f"| Property | Value |\n|---|---|\n"
            f"| Project | {self.info.artifact_id} |\n"
            f"| Group | {self.info.group_id} |\n"
            f"| Version | {self.info.version} |\n"
            f"| Spring Boot | {self.info.spring_boot_version} |\n"
            f"| Java | {self.info.java_version} |\n"
            f"| Generated | {datetime.now().strftime('%Y-%m-%d %H:%M:%S')} |"
        )

    def _discovery_summary(self) -> str:
        i = self.info
        return (
            "## 1. Auto-Discovery Summary\n\n"
            "| Component | Count |\n|---|---:|\n"
            f"| REST Endpoints | {sum(1 for e in i.endpoints if e.endpoint_type == 'REST')} |\n"
            f"| SOAP Endpoints | {sum(1 for e in i.endpoints if e.endpoint_type == 'SOAP')} |\n"
            f"| Services | {len(i.services)} |\n"
            f"| Processors | {len(i.processors)} |\n"
            f"| Models/DTOs | {len(i.models)} |\n"
            f"| Clients | {len(i.clients)} |\n"
            f"| Exceptions | {len(i.exceptions)} |\n"
            f"| Exception Handlers | {len(i.exception_handlers)} |\n"
            f"| External Dependencies | {len(i.external_deps)} |"
        )

    def _endpoints_table(self) -> str:
        if not self.info.endpoints:
            return "## 2. Endpoints\n\nNo endpoints discovered."
        lines = ["## 2. Endpoints\n",
                  "| Class | Type | Path | Methods |", "|---|---|---|---|"]
        for ep in self.info.endpoints:
            methods = ", ".join(m.method_name for m in ep.methods)
            lines.append(f"| {ep.class_info.name} | {ep.endpoint_type} | {ep.base_path} | {methods} |")
        return "\n".join(lines)

    def _generated_files(self, title: str, files: list[str]) -> str:
        lines = [f"## {title}\n", f"Generated **{len(files)}** files:\n"]
        for f in files:
            lines.append(f"- `{Path(f).name}`")
        return "\n".join(lines)

    def _test_results(self, summary: TestSummary) -> str:
        pct = (summary.passed / summary.total * 100) if summary.total else 0
        lines = [
            "## Test Results\n",
            f"| Metric | Value |\n|---|---:|\n"
            f"| Total | {summary.total} |\n"
            f"| Passed | {summary.passed} |\n"
            f"| Failed | {summary.failed} |\n"
            f"| Errors | {summary.errors} |\n"
            f"| Skipped | {summary.skipped} |\n"
            f"| Pass Rate | {pct:.1f}% |\n"
            f"| Duration | {summary.duration_sec:.2f}s |",
        ]
        # Failure details
        failures = [r for r in summary.results if r.status in ("FAILED", "ERROR")]
        if failures:
            lines.append("\n### Failures\n")
            lines.append("| Class | Test | Type | Message |")
            lines.append("|---|---|---|---|")
            for r in failures[:20]:
                msg = r.failure_message[:80].replace("|", "\\|") if r.failure_message else ""
                lines.append(f"| {r.class_name} | {r.test_name} | {r.failure_type} | {msg} |")
        return "\n".join(lines)

    def _business_rules(self) -> str:
        lines = ["## Business Rules Traceability\n",
                  "| Rule ID |", "|---|"]
        for rule in sorted(set(self.info.business_rules)):
            lines.append(f"| {rule} |")
        return "\n".join(lines)

    def _recommendations(self, summary: TestSummary | None) -> str:
        recs: list[str] = []
        if summary and summary.failed + summary.errors > 0:
            recs.append("- Review failing tests and fix or suppress known issues.")
        if not self.info.has_wiremock:
            recs.append("- Add WireMock for integration testing of downstream services.")
        if self.info.schemas:
            recs.append("- Consider XSD-based request/response validation tests.")
        recs.append("- Consider PIT mutation testing for coverage quality.")
        if not recs:
            recs.append("- All checks passed.")
        return "## Recommendations\n\n" + "\n".join(recs)
