"""testgen CLI — command-per-concern entry point.

Commands:
  testgen discover <project>             Scan project -> .testgen/project.json
  testgen junit <project> [--only X]     Generate JUnit tests
  testgen wiremock <project>             Generate WireMock integration tests
  testgen postman <project>              Generate Postman collections
  testgen run <project>                  Execute Maven tests
  testgen validate <project>             Pre-flight environment checks
  testgen fix-pom <project>              Auto-fix POM for test execution
  testgen report <project>               Generate report from last run
  testgen all <project>                  Full pipeline
"""

from __future__ import annotations

import json
import logging
import os
import sys
import time
from pathlib import Path
from typing import Optional

import click

# ── Logging ──────────────────────────────────────────────────

def _setup_logging(verbose: bool) -> None:
    level = logging.DEBUG if verbose else logging.INFO
    logging.basicConfig(
        level=level,
        format="%(levelname)-5s %(message)s",
    )


# ── CLI Group ────────────────────────────────────────────────

@click.group()
@click.option("--verbose", "-v", is_flag=True, help="Enable debug logging.")
def main(verbose: bool) -> None:
    """testgen - Automated test generation for Spring Boot projects."""
    _setup_logging(verbose)


# ── discover ─────────────────────────────────────────────────

@main.command()
@click.argument("project", type=click.Path(exists=True))
@click.option("--config", "-c", type=click.Path(), default=None,
              help="Path to config.yaml")
def discover(project: str, config: Optional[str]) -> None:
    """Scan project and write .testgen/project.json."""
    import yaml
    from .discovery.scanner import ProjectScanner
    from .discovery.serialiser import save_project

    t0 = time.perf_counter()
    cfg = _load_config(config)
    scanner = ProjectScanner(project, cfg)
    info = scanner.scan()
    out = save_project(info, project)
    elapsed = time.perf_counter() - t0

    click.echo(f"Discovered {len(info.all_classes)} classes in {elapsed:.2f}s")
    click.echo(f"  REST endpoints:  {sum(1 for e in info.endpoints if e.endpoint_type == 'REST')}")
    click.echo(f"  SOAP endpoints:  {sum(1 for e in info.endpoints if e.endpoint_type == 'SOAP')}")
    click.echo(f"  Services:        {len(info.services)}")
    click.echo(f"  Processors:      {len(info.processors)}")
    click.echo(f"  Models/DTOs:     {len(info.models)}")
    click.echo(f"  Clients:         {len(info.clients)}")
    click.echo(f"Written to {out}")


# ── junit ────────────────────────────────────────────────────

@main.command()
@click.argument("project", type=click.Path(exists=True))
@click.option("--only", type=str, default=None,
              help="Only generate for: services, models, processors, clients, endpoints")
@click.option("--exclude", type=str, default=None,
              help="Comma-separated package prefixes to exclude (e.g., com.example.generated)")
@click.option("--dry-run", is_flag=True, help="Preview without writing files.")
@click.option("--config", "-c", type=click.Path(), default=None)
def junit(project: str, only: Optional[str], exclude: Optional[str],
          dry_run: bool, config: Optional[str]) -> None:
    """Generate JUnit 5 unit tests."""
    from .discovery.serialiser import load_project
    from .generation.engine import TemplateEngine
    from .generation.plugins import JUnitPlugin
    from .generation.incremental import IncrementalChecker
    from .models import ClassKind

    t0 = time.perf_counter()
    cfg = _load_config(config)
    info = load_project(project)
    engine = TemplateEngine(project)
    plugin = JUnitPlugin()
    checker = IncrementalChecker(project)

    test_suffix = cfg.get("framework", {}).get("test_class_suffix", "AutoTest")
    test_package = f"{info.base_package}.autotest"
    ctx = _build_gen_context(info, cfg, test_package, test_suffix)

    # Build exclude prefixes from CLI + config
    exclude_prefixes: list[str] = []
    if exclude:
        exclude_prefixes.extend(e.strip() for e in exclude.split(",") if e.strip())
    cfg_excludes = cfg.get("junit", {}).get("exclude_packages", [])
    if cfg_excludes:
        exclude_prefixes.extend(cfg_excludes)

    # Collect classes to generate tests for
    classes = info.all_classes
    if only:
        kind_filter = _parse_kind_filter(only)
        classes = [c for c in classes if c.kind in kind_filter]
    if exclude_prefixes:
        classes = [c for c in classes
                   if not any(c.package.startswith(p) for p in exclude_prefixes)]

    created: list[str] = []
    skipped = 0
    for ci in classes:
        if not plugin.accepts(ci, info):
            continue
        if not checker.needs_regeneration(ci):
            skipped += 1
            continue

        template = plugin.template_name(ci)
        context = plugin.build_context(ci, info, ctx)

        if dry_run:
            click.echo(f"  [dry-run] Would generate: {context['test_class_name']}.java")
            continue

        rendered = engine.render(template, context)
        out_path = _write_java_file(project, test_package, context["test_class_name"], rendered)
        created.append(out_path)

    if not dry_run:
        checker.save()

    elapsed = time.perf_counter() - t0
    click.echo(f"JUnit: {len(created)} generated, {skipped} unchanged, in {elapsed:.2f}s")


# ── wiremock ─────────────────────────────────────────────────

@main.command()
@click.argument("project", type=click.Path(exists=True))
@click.option("--dry-run", is_flag=True)
@click.option("--config", "-c", type=click.Path(), default=None)
def wiremock(project: str, dry_run: bool, config: Optional[str]) -> None:
    """Generate WireMock integration tests."""
    from .discovery.serialiser import load_project
    from .generation.engine import TemplateEngine
    from .generation.plugins import WireMockPlugin

    t0 = time.perf_counter()
    cfg = _load_config(config)
    info = load_project(project)
    engine = TemplateEngine(project)
    plugin = WireMockPlugin()

    test_suffix = cfg.get("framework", {}).get("test_class_suffix", "AutoTest")
    test_package = f"{info.base_package}.autotest"
    ctx = _build_gen_context(info, cfg, test_package, test_suffix)

    created: list[str] = []
    for ep in info.endpoints:
        ci = ep.class_info
        if not plugin.accepts(ci, info):
            continue

        template = plugin.template_name(ci)
        context = plugin.build_context(ci, info, ctx)
        if not context:
            continue

        if dry_run:
            click.echo(f"  [dry-run] Would generate: {context['test_class_name']}.java")
            continue

        rendered = engine.render(template, context)
        int_package = f"{test_package}.integration"
        out_path = _write_java_file(project, int_package, context["test_class_name"], rendered)
        created.append(out_path)

    elapsed = time.perf_counter() - t0
    click.echo(f"WireMock: {len(created)} generated in {elapsed:.2f}s")


# ── postman ──────────────────────────────────────────────────

@main.command()
@click.argument("project", type=click.Path(exists=True))
@click.option("--dry-run", is_flag=True)
@click.option("--config", "-c", type=click.Path(), default=None)
def postman(project: str, dry_run: bool, config: Optional[str]) -> None:
    """Generate Postman collection and environment files."""
    from .discovery.serialiser import load_project
    from .generation.engine import TemplateEngine
    from .generation.plugins import PostmanPlugin

    t0 = time.perf_counter()
    cfg = _load_config(config)
    info = load_project(project)
    engine = TemplateEngine(project)
    plugin = PostmanPlugin()

    test_suffix = cfg.get("framework", {}).get("test_class_suffix", "AutoTest")
    test_package = f"{info.base_package}.autotest"
    ctx = _build_gen_context(info, cfg, test_package, test_suffix)

    created: list[str] = []
    postman_dir = Path(project) / "postman"
    postman_dir.mkdir(parents=True, exist_ok=True)

    # Collection
    coll_ctx = plugin.build_collection_context(info, ctx)
    if dry_run:
        click.echo(f"  [dry-run] Would generate: {info.artifact_id}_collection.json")
    else:
        rendered = engine.render("postman/collection.json.j2", coll_ctx)
        out = postman_dir / f"{info.artifact_id}_collection.json"
        out.write_text(rendered, encoding="utf-8")
        created.append(str(out))

    # Environments
    for profile, profile_cfg in info.configs.items():
        env_ctx = plugin.build_environment_context(info, profile, profile_cfg)
        fname = f"{info.artifact_id}_{profile.replace('application-', '')}_env.json"
        if dry_run:
            click.echo(f"  [dry-run] Would generate: {fname}")
        else:
            rendered = engine.render("postman/environment.json.j2", env_ctx)
            out = postman_dir / fname
            out.write_text(rendered, encoding="utf-8")
            created.append(str(out))

    elapsed = time.perf_counter() - t0
    click.echo(f"Postman: {len(created)} generated in {elapsed:.2f}s")


# ── validate ─────────────────────────────────────────────────

@main.command()
@click.argument("project", type=click.Path(exists=True))
def validate(project: str) -> None:
    """Pre-flight environment validation."""
    from .execution.preflight import PreFlightValidator

    validator = PreFlightValidator(project)
    issues = validator.validate()

    if not issues:
        click.echo("All checks passed.")
        return

    for issue in issues:
        icon = {"error": "X", "warning": "!", "info": "i"}[issue.severity]
        click.echo(f"  [{icon}] {issue.message}")
        if issue.fix_hint:
            click.echo(f"      -> {issue.fix_hint}")

    errors = [i for i in issues if i.severity == "error"]
    if errors:
        click.echo(f"\n{len(errors)} error(s) must be resolved before running tests.")


# ── fix-pom ──────────────────────────────────────────────────

@main.command("fix-pom")
@click.argument("project", type=click.Path(exists=True))
def fix_pom_cmd(project: str) -> None:
    """Auto-fix POM for test execution (surefire, WireMock, ByteBuddy)."""
    from .execution.pom_manager import fix_pom

    actions = fix_pom(project)
    for action in actions:
        click.echo(f"  {action}")
    click.echo("POM updated successfully.")


# ── run ──────────────────────────────────────────────────────

@main.command()
@click.argument("project", type=click.Path(exists=True))
@click.option("--config", "-c", type=click.Path(), default=None)
def run(project: str, config: Optional[str]) -> None:
    """Run Maven tests and display results."""
    from .execution.maven_runner import MavenRunner

    cfg = _load_config(config)
    runner = MavenRunner(project, cfg)
    summary = runner.run()

    if summary.total == 0:
        click.echo("No tests executed.")
        return

    pct = summary.passed / summary.total * 100
    click.echo(f"\n{'BUILD SUCCESS' if summary.build_success else 'BUILD FAILURE'}")
    click.echo(f"  Total:   {summary.total}")
    click.echo(f"  Passed:  {summary.passed} ({pct:.1f}%)")
    click.echo(f"  Failed:  {summary.failed}")
    click.echo(f"  Errors:  {summary.errors}")
    click.echo(f"  Skipped: {summary.skipped}")
    click.echo(f"  Time:    {summary.duration_sec:.2f}s")


# ── report ───────────────────────────────────────────────────

@main.command()
@click.argument("project", type=click.Path(exists=True))
@click.option("--config", "-c", type=click.Path(), default=None)
def report(project: str, config: Optional[str]) -> None:
    """Generate Markdown test report."""
    from .discovery.serialiser import load_project
    from .reporting import ReportGenerator

    cfg = _load_config(config)
    info = load_project(project)
    gen = ReportGenerator(info, cfg)
    path = gen.generate()
    click.echo(f"Report written to {path}")


# ── behavioral ───────────────────────────────────────────────

@main.command()
@click.argument("project", type=click.Path(exists=True))
@click.option("--re-docs", type=click.Path(exists=True), required=True,
              help="Path to reverse-engineering documents directory.")
@click.option("--legacy-path", type=click.Path(exists=True), default=None,
              help="Path to legacy JBoss Fuse project (optional, for correlation).")
@click.option("--dry-run", is_flag=True)
@click.option("--config", "-c", type=click.Path(), default=None)
def behavioral(project: str, re_docs: str, legacy_path: Optional[str],
               dry_run: bool, config: Optional[str]) -> None:
    """Generate behavioral tests from RE docs + XSD schemas."""
    from .discovery.serialiser import load_project
    from .generation.engine import TemplateEngine
    from .generation.plugins import BehavioralPlugin
    from .behavioral.xsd_analyzer import parse_xsd_directory
    from .behavioral.re_parser import parse_re_docs
    from .behavioral.payload_factory import generate_payload_factory

    t0 = time.perf_counter()
    cfg = _load_config(config)
    info = load_project(project)
    engine = TemplateEngine(project)
    plugin = BehavioralPlugin()

    test_suffix = cfg.get("framework", {}).get("test_class_suffix", "AutoTest")
    test_package = f"{info.base_package}.autotest"
    ctx = _build_gen_context(info, cfg, test_package, test_suffix)

    # Phase 1: Parse XSD schemas
    xsd_dir = Path(project) / "src" / "main" / "resources" / "xsd"
    schemas = parse_xsd_directory(xsd_dir) if xsd_dir.is_dir() else []
    click.echo(f"  XSD: {sum(len(s.complex_types) for s in schemas)} types from {len(schemas)} schemas")

    # Phase 2: Parse RE documents
    behavioral_ctx = parse_re_docs(re_docs)
    click.echo(f"  RE docs: {len(behavioral_ctx.business_rules)} rules, "
               f"{len(behavioral_ctx.field_mappings)} mappings, "
               f"{len(behavioral_ctx.test_cases)} test cases")

    # Phase 3: Legacy correlation (optional)
    if legacy_path:
        from .behavioral.legacy_scanner import scan_legacy
        legacy_info = scan_legacy(legacy_path)
        click.echo(f"  Legacy: {len(legacy_info.routes)} routes, {len(legacy_info.beans)} beans")

    # Phase 4: Generate PayloadFactory.java
    if schemas and not dry_run:
        factory_code = generate_payload_factory(schemas, f"{test_package}.behavioral", info.fqcn_index)
        _write_java_file(project, f"{test_package}.behavioral", "PayloadFactory", factory_code)
        click.echo("  Generated: PayloadFactory.java")

    # Phase 5: Generate behavioral tests
    created: list[str] = []
    for ci in info.all_classes:
        if not plugin.accepts(ci, info):
            continue

        context = plugin.build_context(ci, info, ctx, behavioral_ctx)

        # Filter applicable rules for this class
        applicable_rule_ids = plugin.applicable_rules(ci)
        rules_for_class = [
            r for r in behavioral_ctx.business_rules
            if r.rule_id in applicable_rule_ids
        ]

        if rules_for_class:
            context["rules"] = [
                {"rule_id": r.rule_id, "name": r.name,
                 "description": r.description, "business_logic": r.business_logic}
                for r in rules_for_class
            ]
            if dry_run:
                click.echo(f"  [dry-run] Would generate: {ci.name}BehavioralAutoTest.java")
            else:
                rendered = engine.render(plugin.template_for_rules(), context)
                out = _write_java_file(project, f"{test_package}.behavioral",
                                       f"{ci.name}BehavioralAutoTest", rendered)
                created.append(out)

        # Field mapping tests for processors
        mappings_for_class = [
            m for m in behavioral_ctx.field_mappings
            if any(ci.name.lower() in m.component_id.lower()
                   or m.component_id in (ci.name,)
                   for _ in [None])
        ]
        for mapping in mappings_for_class:
            map_ctx = dict(context)
            map_ctx["mapping"] = {
                "mapping_id": mapping.mapping_id,
                "name": mapping.name,
                "source_type": mapping.source_type,
                "target_type": mapping.target_type,
                "fields": [
                    {"source_field": f.source_field, "target_field": f.target_field,
                     "transformation": f.transformation}
                    for f in mapping.fields
                ],
            }
            map_ctx["test_class_name"] = f"{ci.name}{mapping.mapping_id.replace('-', '')}MappingAutoTest"
            if dry_run:
                click.echo(f"  [dry-run] Would generate: {map_ctx['test_class_name']}.java")
            else:
                rendered = engine.render(plugin.template_for_mapping(), map_ctx)
                out = _write_java_file(project, f"{test_package}.behavioral",
                                       map_ctx["test_class_name"], rendered)
                created.append(out)

    elapsed = time.perf_counter() - t0
    click.echo(f"Behavioral: {len(created)} generated in {elapsed:.2f}s")


# ── all ──────────────────────────────────────────────────────

@main.command("all")
@click.argument("project", type=click.Path(exists=True))
@click.option("--config", "-c", type=click.Path(), default=None)
@click.option("--dry-run", is_flag=True)
@click.option("--skip-run", is_flag=True, help="Skip test execution.")
def all_cmd(project: str, config: Optional[str], dry_run: bool,
            skip_run: bool) -> None:
    """Full pipeline: discover -> validate -> fix-pom -> junit -> wiremock -> postman -> run -> report."""
    import yaml
    from .discovery.scanner import ProjectScanner
    from .discovery.serialiser import save_project, load_project
    from .generation.engine import TemplateEngine
    from .generation.plugins import JUnitPlugin, WireMockPlugin, PostmanPlugin
    from .generation.incremental import IncrementalChecker
    from .execution.preflight import PreFlightValidator
    from .execution.pom_manager import fix_pom
    from .execution.maven_runner import MavenRunner
    from .reporting import ReportGenerator
    from .models import GenerationContext

    t_total = time.perf_counter()
    cfg = _load_config(config)

    # Phase 1: Discover
    click.echo("\n=== Phase 1: Discovery ===")
    t0 = time.perf_counter()
    scanner = ProjectScanner(project, cfg)
    info = scanner.scan()
    save_project(info, project)
    click.echo(f"  {len(info.all_classes)} classes discovered in {time.perf_counter() - t0:.2f}s")

    # Phase 2: Validate
    click.echo("\n=== Phase 2: Validation ===")
    validator = PreFlightValidator(project)
    issues = validator.validate()
    for issue in issues:
        icon = {"error": "X", "warning": "!", "info": "i"}[issue.severity]
        click.echo(f"  [{icon}] {issue.message}")

    # Phase 3: Fix POM
    if not dry_run:
        click.echo("\n=== Phase 3: POM Setup ===")
        actions = fix_pom(project)
        for a in actions:
            click.echo(f"  {a}")

    # Phase 4: Generate
    click.echo("\n=== Phase 4: Generation ===")
    t0 = time.perf_counter()
    engine = TemplateEngine(project)
    test_suffix = cfg.get("framework", {}).get("test_class_suffix", "AutoTest")
    test_package = f"{info.base_package}.autotest"
    ctx = _build_gen_context(info, cfg, test_package, test_suffix)

    junit_files = _gen_junit(info, engine, JUnitPlugin(), ctx, project, dry_run, cfg)
    wiremock_files = _gen_wiremock(info, engine, WireMockPlugin(), ctx, project, dry_run)
    postman_files = _gen_postman(info, engine, PostmanPlugin(), ctx, project, dry_run)
    click.echo(f"  Generated: {len(junit_files)} JUnit, {len(wiremock_files)} WireMock, {len(postman_files)} Postman in {time.perf_counter() - t0:.2f}s")

    # Phase 5: Run
    summary = None
    if not skip_run and not dry_run:
        click.echo("\n=== Phase 5: Test Execution ===")
        runner = MavenRunner(project, cfg)
        summary = runner.run()
        if summary.total:
            pct = summary.passed / summary.total * 100
            click.echo(f"  {summary.total} tests, {summary.passed} passed ({pct:.1f}%)")

    # Phase 6: Report
    if not dry_run:
        click.echo("\n=== Phase 6: Report ===")
        gen = ReportGenerator(info, cfg)
        rpt = gen.generate(summary, junit_files, wiremock_files, postman_files)
        click.echo(f"  Report: {rpt}")

    click.echo(f"\nTotal time: {time.perf_counter() - t_total:.2f}s")


# ── Shared helpers ───────────────────────────────────────────

def _load_config(config_path: Optional[str]) -> dict:
    if config_path and Path(config_path).is_file():
        import yaml
        with open(config_path, encoding="utf-8") as f:
            return yaml.safe_load(f) or {}
    # Try default location
    default = Path("config.yaml")
    if default.is_file():
        import yaml
        with open(default, encoding="utf-8") as f:
            return yaml.safe_load(f) or {}
    return {}


def _build_gen_context(info, cfg, test_package, test_suffix):
    from .models import GenerationContext
    return GenerationContext(
        fqcn_index=info.fqcn_index,
        config=cfg,
        project_path=info.project_path,
        base_package=info.base_package,
        test_package=test_package,
        test_suffix=test_suffix,
    )


def _parse_kind_filter(only: str) -> set:
    from .models import ClassKind
    mapping = {
        "services": {ClassKind.SERVICE},
        "models": {ClassKind.MODEL, ClassKind.CONSTANTS},
        "processors": {ClassKind.PROCESSOR},
        "clients": {ClassKind.CLIENT},
        "endpoints": {ClassKind.REST_CONTROLLER, ClassKind.SOAP_ENDPOINT},
        "exceptions": {ClassKind.EXCEPTION, ClassKind.EXCEPTION_HANDLER},
    }
    return mapping.get(only.lower(), set(ClassKind))


def _write_java_file(project: str, package: str, class_name: str,
                     content: str) -> str:
    """Write a Java source file under src/test/java/."""
    pkg_path = package.replace(".", os.sep)
    test_dir = Path(project) / "src" / "test" / "java" / pkg_path
    test_dir.mkdir(parents=True, exist_ok=True)
    out_file = test_dir / f"{class_name}.java"
    out_file.write_text(content, encoding="utf-8")
    return str(out_file)


def _gen_junit(info, engine, plugin, ctx, project, dry_run, cfg):
    from .generation.incremental import IncrementalChecker
    checker = IncrementalChecker(project)
    created = []
    for ci in info.all_classes:
        if not plugin.accepts(ci, info):
            continue
        if not dry_run and not checker.needs_regeneration(ci):
            continue
        template = plugin.template_name(ci)
        context = plugin.build_context(ci, info, ctx)
        if dry_run:
            continue
        rendered = engine.render(template, context)
        path = _write_java_file(project, ctx.test_package, context["test_class_name"], rendered)
        created.append(path)
    if not dry_run:
        checker.save()
    return created


def _gen_wiremock(info, engine, plugin, ctx, project, dry_run):
    created = []
    for ep in info.endpoints:
        ci = ep.class_info
        if not plugin.accepts(ci, info):
            continue
        template = plugin.template_name(ci)
        context = plugin.build_context(ci, info, ctx)
        if not context or dry_run:
            continue
        rendered = engine.render(template, context)
        int_pkg = f"{ctx.test_package}.integration"
        path = _write_java_file(project, int_pkg, context["test_class_name"], rendered)
        created.append(path)
    return created


def _gen_postman(info, engine, plugin, ctx, project, dry_run):
    created = []
    postman_dir = Path(project) / "postman"
    postman_dir.mkdir(parents=True, exist_ok=True)
    coll_ctx = plugin.build_collection_context(info, ctx)
    if not dry_run:
        rendered = engine.render("postman/collection.json.j2", coll_ctx)
        out = postman_dir / f"{info.artifact_id}_collection.json"
        out.write_text(rendered, encoding="utf-8")
        created.append(str(out))
    for profile, profile_cfg in info.configs.items():
        env_ctx = plugin.build_environment_context(info, profile, profile_cfg)
        fname = f"{info.artifact_id}_{profile.replace('application-', '')}_env.json"
        if not dry_run:
            rendered = engine.render("postman/environment.json.j2", env_ctx)
            out = postman_dir / fname
            out.write_text(rendered, encoding="utf-8")
            created.append(str(out))
    return created
