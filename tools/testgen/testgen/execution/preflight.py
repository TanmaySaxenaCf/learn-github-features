"""Pre-flight environment validator.

Checks the project environment BEFORE running tests to catch issues
that would cause runtime failures (like ByteBuddy agent on JDK 21).
All 36 test failures in v1 were caused by one of these issues.
"""

from __future__ import annotations

import logging
import os
import re
import shutil
import subprocess
import xml.etree.ElementTree as ET
from dataclasses import dataclass
from pathlib import Path

logger = logging.getLogger(__name__)


@dataclass(frozen=True)
class Issue:
    severity: str       # "error" | "warning" | "info"
    message: str
    fix_hint: str = ""


class PreFlightValidator:
    """Validates the project environment for test execution."""

    def __init__(self, project_path: str | Path):
        self.project_path = Path(project_path)

    def validate(self) -> list[Issue]:
        issues: list[Issue] = []
        issues.extend(self._check_maven())
        issues.extend(self._check_jdk())
        issues.extend(self._check_pom_surefire())
        issues.extend(self._check_generated_sources())
        issues.extend(self._check_test_deps())
        return issues

    def _check_maven(self) -> list[Issue]:
        if not shutil.which("mvn"):
            return [Issue("error", "Maven not found in PATH.",
                          "Install Maven 3.9+ and add to PATH.")]
        try:
            result = subprocess.run(
                ["mvn", "--version"], capture_output=True, text=True,
                timeout=15, shell=(os.name == "nt"),
            )
            m = re.search(r"Apache Maven (\d+\.\d+)", result.stdout)
            if m:
                version = float(m.group(1))
                if version < 3.8:
                    return [Issue("warning",
                                  f"Maven {m.group(1)} detected. 3.9+ recommended.",
                                  "Upgrade Maven for better Surefire support.")]
        except (subprocess.TimeoutExpired, FileNotFoundError):
            pass
        return []

    def _check_jdk(self) -> list[Issue]:
        issues: list[Issue] = []
        java = shutil.which("java")
        if not java:
            return [Issue("error", "Java not found in PATH.")]
        try:
            result = subprocess.run(
                ["java", "-version"], capture_output=True, text=True,
                timeout=10, shell=(os.name == "nt"),
            )
            output = result.stderr + result.stdout
            m = re.search(r'"(\d+)', output)
            if m:
                major = int(m.group(1))
                if major >= 16:
                    issues.append(Issue(
                        "warning",
                        f"JDK {major} detected. Mockito's ByteBuddy requires"
                        " --add-opens for inline mock maker.",
                        "Run `testgen fix-pom` to auto-configure surefire argLine.",
                    ))
        except (subprocess.TimeoutExpired, FileNotFoundError):
            pass
        return issues

    def _check_pom_surefire(self) -> list[Issue]:
        pom = self.project_path / "pom.xml"
        if not pom.is_file():
            return [Issue("error", "No pom.xml found.")]
        try:
            text = pom.read_text(encoding="utf-8")
        except OSError:
            return []
        # Check for surefire argLine with --add-opens
        if "maven-surefire-plugin" in text:
            issues = []
            if "--add-opens" not in text:
                issues.append(Issue(
                    "warning",
                    "Surefire plugin found but missing --add-opens in argLine.",
                    "Run `testgen fix-pom` to auto-fix.",
                ))
            if "EnableDynamicAgentLoading" not in text:
                issues.append(Issue(
                    "warning",
                    "Surefire argLine missing -XX:+EnableDynamicAgentLoading (required for JDK 21+).",
                    "Run `testgen fix-pom` to auto-fix.",
                ))
            return issues
        else:
            return [Issue(
                "info",
                "No explicit surefire plugin config. Using Spring Boot defaults.",
                "Run `testgen fix-pom` to add surefire with proper argLine.",
            )]

    def _check_generated_sources(self) -> list[Issue]:
        gen_src = self.project_path / "target" / "generated-sources"
        if not gen_src.is_dir():
            return [Issue("warning",
                          "No target/generated-sources/ found. "
                          "JAXB/protobuf classes may not be indexed.",
                          "Run `mvn clean compile` before `testgen discover`.")]
        java_files = list(gen_src.rglob("*.java"))
        if not java_files:
            return [Issue("warning",
                          "target/generated-sources/ exists but contains no .java files.",
                          "Check that POM has a JAXB/protobuf generation plugin.")]
        return []

    def _check_test_deps(self) -> list[Issue]:
        pom = self.project_path / "pom.xml"
        if not pom.is_file():
            return []
        try:
            text = pom.read_text(encoding="utf-8")
        except OSError:
            return []
        issues: list[Issue] = []
        if "spring-boot-starter-test" not in text:
            issues.append(Issue("error",
                                "spring-boot-starter-test not in POM dependencies.",
                                "Add spring-boot-starter-test with scope test."))
        return issues
