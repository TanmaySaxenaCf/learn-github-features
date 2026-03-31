"""Maven test runner and Surefire XML report parser."""

from __future__ import annotations

import logging
import os
import subprocess
import xml.etree.ElementTree as ET
from dataclasses import dataclass, field
from pathlib import Path
from typing import List

logger = logging.getLogger(__name__)


@dataclass
class TestResult:
    class_name: str
    test_name: str
    status: str             # PASSED | FAILED | ERROR | SKIPPED
    duration_sec: float = 0.0
    failure_message: str = ""
    failure_type: str = ""


@dataclass
class TestSummary:
    total: int = 0
    passed: int = 0
    failed: int = 0
    errors: int = 0
    skipped: int = 0
    duration_sec: float = 0.0
    results: List[TestResult] = field(default_factory=list)
    build_output: str = ""
    build_success: bool = False


class MavenRunner:
    """Executes Maven tests and parses Surefire XML reports."""

    def __init__(self, project_path: str | Path, config: dict | None = None):
        self.project_path = Path(project_path)
        cfg = config or {}
        self.mvn_cmd = cfg.get("maven", {}).get("command", "mvn")
        self.extra_args = cfg.get("maven", {}).get("extra_args", "")
        self.exclude_integration = True

    def run(self) -> TestSummary:
        logger.info("Running Maven tests in %s", self.project_path)
        summary = TestSummary()

        cmd = [self.mvn_cmd, "clean", "test", "-fae",
               "-Dmaven.test.failure.ignore=true"]
        if self.extra_args:
            cmd.extend(self.extra_args.split())

        env = os.environ.copy()
        env["MAVEN_OPTS"] = env.get("MAVEN_OPTS", "") + " -Xmx1536m"

        try:
            result = subprocess.run(
                cmd, cwd=str(self.project_path),
                capture_output=True, text=True, timeout=600,
                shell=(os.name == "nt"), env=env,
            )
            summary.build_output = result.stdout + "\n" + result.stderr
            summary.build_success = result.returncode == 0
        except subprocess.TimeoutExpired:
            summary.build_output = "BUILD TIMED OUT (10 min limit)"
            return summary
        except FileNotFoundError:
            summary.build_output = f"Maven '{self.mvn_cmd}' not found."
            return summary

        # Parse surefire reports
        surefire_dir = self.project_path / "target" / "surefire-reports"
        if surefire_dir.is_dir():
            self._parse_surefire(surefire_dir, summary)

        logger.info(
            "Tests: %d total, %d passed, %d failed, %d errors, %d skipped",
            summary.total, summary.passed, summary.failed,
            summary.errors, summary.skipped,
        )
        return summary

    def _parse_surefire(self, surefire_dir: Path, summary: TestSummary) -> None:
        for xml_file in sorted(surefire_dir.glob("TEST-*.xml")):
            try:
                tree = ET.parse(xml_file)
                root = tree.getroot()
                suite_time = float(root.get("time", "0"))
                summary.duration_sec += suite_time
                suite_name = root.get("name", "")

                for tc in root.findall("testcase"):
                    name = tc.get("name", "")
                    time_s = float(tc.get("time", "0"))

                    failure = tc.find("failure")
                    error = tc.find("error")
                    skipped = tc.find("skipped")

                    if failure is not None:
                        status = "FAILED"
                        summary.failed += 1
                        msg = failure.get("message", "")
                        ftype = failure.get("type", "")
                    elif error is not None:
                        status = "ERROR"
                        summary.errors += 1
                        msg = error.get("message", "")
                        ftype = error.get("type", "")
                    elif skipped is not None:
                        status = "SKIPPED"
                        summary.skipped += 1
                        msg = ""
                        ftype = ""
                    else:
                        status = "PASSED"
                        summary.passed += 1
                        msg = ""
                        ftype = ""

                    summary.total += 1
                    summary.results.append(TestResult(
                        class_name=suite_name, test_name=name,
                        status=status, duration_sec=time_s,
                        failure_message=msg, failure_type=ftype,
                    ))
            except ET.ParseError:
                logger.warning("Cannot parse %s", xml_file)
