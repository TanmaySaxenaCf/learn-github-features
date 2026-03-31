# testgen — Testing Automation Framework v2.1

A **modular, plugin-based** test generation framework for Spring Boot services. Point it at any Spring Boot Maven project and it will auto-discover the architecture, generate comprehensive tests (unit, integration, and behavioral), execute them, and produce a detailed report. All templates are fully generic — no service-specific hardcoding.

## What It Does

| Capability | Description |
|------------|-------------|
| **Auto-Discovery** | Scans endpoints, services, processors, models, clients, exceptions, external dependencies, configs, schemas, and business rules |
| **JUnit 5 Generation** | Unit tests for every component — MockMvc for REST, Mockito for services, getter/setter for models |
| **WireMock Generation** | Integration tests with downstream API stubs (success, error, timeout scenarios) |
| **Behavioral Generation** | Business rule verification, field mapping validation, and error handling tests from RE documents + XSD schemas |
| **Postman Generation** | v2.1 collections + per-profile environment files (dev, sit, uat, prod) |
| **Environment Validation** | Pre-flight checks for JDK version, ByteBuddy compatibility, Maven surefire config |
| **POM Auto-Fix** | XML-based POM modifications — surefire argLine, WireMock dependency, integration test exclusion |
| **Test Execution** | Maven test runner with Surefire XML report parsing |
| **Markdown Report** | Discovery summary, endpoints table, test results, failure analysis, recommendations |

---

## What to Provide (Before Running)

Before starting the automation, ensure you have the following ready:

### Required Inputs

| # | Input | Description | Example |
|---|-------|-------------|---------|
| 1 | **Spring Boot project path** | Root directory of the target Maven project | `../sb-my-service` |
| 2 | **XSD schemas** | Must be in `src/main/resources/xsd/` inside the project | `MyService_schema.xsd` |
| 3 | **Application YAML configs** | Must be in `src/main/resources/` | `application.yml`, `application-dev.yml` |

### Required for Behavioral Tests (v2.1)

| # | Input | Description | Example |
|---|-------|-------------|---------|
| 4 | **RE documents directory** | Folder with reverse-engineering markdown files | `../reverse-engineering/` |
| 5 | **Business rules catalog** | RE doc with `BR-NNN` headers and business logic | `04-BUSINESS-RULES-CATALOG-*.md` |
| 6 | **Field mapping document** | RE doc with `MAP-NNN` headers and field tables | `10-FIELD-TO-FIELD-MAPPING-*.md` |
| 7 | **Test case inventory** | RE doc with `TC-*-NNN` headers and test scenarios | `08-TEST-CASE-INVENTORY-*.md` |

### Optional Inputs

| # | Input | Description | Example |
|---|-------|-------------|---------|
| 8 | **Legacy codebase path** | JBoss Fuse/Camel project for route correlation | `../legacy-my-service` |
| 9 | **Custom config file** | Override default `config.yaml` | `my-config.yaml` |

### Project Readiness Checklist

- [ ] Project compiles: `mvn compile` succeeds
- [ ] JAXB classes generated: `target/generated-sources/jaxb/` has `.java` files
- [ ] Tests can run: `mvn test` executes (even if some fail)
- [ ] RE docs use standard format: `## BR-NNN:`, `## MAP-NNN:`, `## TC-*-NNN:` headers
- [ ] Python 3.10+ installed with `pip`

---

## Prerequisites

| Tool | Version | Notes |
|------|---------|-------|
| Python | 3.10+ | Uses `match` expressions, `slots=True` dataclasses |
| Java | 11–21 | JDK 21 auto-detected; ByteBuddy fix applied automatically |
| Maven | 3.6+ | Used for test compilation and execution |

## Installation

```bash
# Install from project directory
cd testing-automation-framework
pip install -e .

# Or install dependencies directly
pip install PyYAML>=6.0 Jinja2>=3.1 click>=8.1

# Optional: AST-based parsing (Phase 2)
pip install tree-sitter>=0.22 tree-sitter-java>=0.23
```

## Quick Start

```bash
# Full pipeline — discover, validate, fix POM, generate, run, report
testgen all ../sb-my-service

# Or run individual phases
testgen discover ../sb-my-service
testgen validate ../sb-my-service
testgen fix-pom  ../sb-my-service
testgen junit    ../sb-my-service
testgen wiremock ../sb-my-service
testgen postman  ../sb-my-service
testgen run      ../sb-my-service
testgen report   ../sb-my-service

# Behavioral tests (v2.1) — requires RE docs
testgen behavioral ../sb-my-service \
    --re-docs ../reverse-engineering \
    --legacy-path ../legacy-my-service
```

## CLI Commands

### `testgen all` — Full Pipeline

```bash
testgen all <project> [--config config.yaml] [--dry-run] [--skip-run]
```

Runs all 6 phases in sequence: discover → validate → fix-pom → generate → run → report.

| Option | Description |
|--------|-------------|
| `--dry-run` | Preview which files would be generated, without writing |
| `--skip-run` | Generate tests but skip Maven execution |
| `--config`, `-c` | Custom config file (default: `config.yaml`) |

### `testgen discover` — Project Scanning

```bash
testgen discover <project> [--config config.yaml]
```

Scans the project and writes `.testgen/project.json` — a serialised snapshot of all discovered classes, endpoints, configs, and dependencies. Subsequent commands read from this snapshot.

### `testgen junit` — JUnit Test Generation

```bash
testgen junit <project> [--only services|models|processors|clients|endpoints|exceptions] [--dry-run]
```

Generates JUnit 5 unit tests under `src/test/java/<base_package>/autotest/`.

| Option | Description |
|--------|-------------|
| `--only` | Filter by component type: `services`, `models`, `processors`, `clients`, `endpoints`, `exceptions` |
| `--dry-run` | Preview which test files would be generated |

### `testgen wiremock` — Integration Test Generation

```bash
testgen wiremock <project> [--dry-run]
```

Generates WireMock-based integration tests under `src/test/java/<base_package>/autotest/integration/`.

### `testgen postman` — Postman Collection Generation

```bash
testgen postman <project> [--dry-run]
```

Generates Postman v2.1 collection + per-profile environment files in the `postman/` directory.

### `testgen validate` — Pre-Flight Checks

```bash
testgen validate <project>
```

Validates the environment before test execution:
- Maven installed and accessible
- JDK version detection (warns for JDK 21 ByteBuddy issues)
- Surefire plugin `--add-opens` argLine configuration
- `spring-boot-starter-test` dependency presence

### `testgen fix-pom` — POM Auto-Configuration

```bash
testgen fix-pom <project>
```

Applies XML-based POM modifications:
- Adds/updates `maven-surefire-plugin` with `--add-opens` argLine for JDK 21
- Adds `**/*IntegrationAutoTest.java` exclusion pattern
- Adds WireMock dependency if missing

### `testgen run` — Test Execution

```bash
testgen run <project> [--config config.yaml]
```

Runs `mvn clean test` with fail-at-end mode and parses Surefire XML reports.

### `testgen report` — Report Generation

```bash
testgen report <project> [--config config.yaml]
```

Generates a Markdown test report from the last discovery snapshot and test results.

### `testgen behavioral` — Behavioral Test Generation (v2.1)

```bash
testgen behavioral <project> --re-docs <path> [--legacy-path <path>] [--dry-run] [--config config.yaml]
```

Generates behavioral tests from RE documents, XSD schemas, and (optionally) legacy codebase analysis.

| Option | Required | Description |
|--------|----------|-------------|
| `--re-docs` | **Yes** | Directory containing reverse-engineering markdown files |
| `--legacy-path` | No | Legacy JBoss Fuse/Camel project for route correlation |
| `--dry-run` | No | Preview what would be generated without writing files |
| `--config`, `-c` | No | Custom config file (default: `config.yaml`) |

**Pipeline:** XSD parse → RE doc parse → Legacy scan → PayloadFactory → Behavioral tests

**Generated tests:**
- `*BehavioralAutoTest.java` — Business rule verification (BR-NNN)
- `PayloadFactory.java` — XSD-driven test object factory with builder methods
- Field mapping completeness checks (MAP-NNN)
- Error handling/fallback tests (BR-014, BR-015, BR-017)

## Pipeline Architecture

```
┌──────────────────────────────────────────────────────────────────────────┐
│                           CLI Layer (Click)                              │
│  discover │ junit │ wiremock │ postman │ behavioral │ validate │ run     │
└─────┬─────┴───┬───┴────┬─────┴────┬────┴──────┬─────┴────┬────┴──┬──────┘
      │         │        │          │           │          │       │
┌─────▼─────┐ ┌─▼────────▼──────────▼──┐ ┌─────▼──────┐ ┌─▼───────▼──────┐
│ Discovery  │ │      Generation        │ │ Behavioral │ │   Execution    │
│            │ │                        │ │   (v2.1)   │ │                │
│ • Scanner  │ │ • TemplateEngine       │ │            │ │ • PreFlight    │
│ • Parser   │ │ • JUnitPlugin          │ │ • XSD      │ │ • PomManager   │
│ • Classify │ │ • WireMockPlugin       │ │   Analyzer │ │ • MavenRunner  │
│ • Serialise│ │ • PostmanPlugin        │ │ • RE Parser│ │                │
└────────────┘ │ • BehavioralPlugin     │ │ • Legacy   │ └────────────────┘
               │ • IncrementalChecker   │ │   Scanner  │
               └────────────────────────┘ │ • Payload  │
                         │                │   Factory  │
               ┌─────────▼──────────┐    └────────────┘
               │    15 Jinja2        │
               │    Templates        │
               │  (.java.j2/.json.j2)│
               └─────────────────────┘
```

## Auto-Discovery Engine

The framework scans any Spring Boot project and identifies:

| Component | Detection Method |
|-----------|-----------------|
| **REST endpoints** | `@RestController`, `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`, `@PatchMapping` |
| **SOAP endpoints** | `@WebService`, `@WebMethod` annotations |
| **Services** | `@Service` annotation |
| **Processors / Mappers** | `@Component` + name heuristic (Processor, Mapper, Transformer, Handler) |
| **Models / DTOs** | POJO classes — fields present, no Spring stereotypes |
| **Constants** | All `static final` fields, no instance methods |
| **Clients** | Name heuristic (Client, Connector, Adapter) + HTTP/CXF imports |
| **Exceptions** | Extends `Exception` or `RuntimeException` |
| **Exception handlers** | `@ControllerAdvice` annotation |
| **External dependencies** | `@Value("${...url}")` + `application.yml` URL properties |
| **XSD / WSDL schemas** | `.xsd`, `.wsdl` file scan in `src/main/resources` |
| **Business rules** | `BR-\d{3}` pattern in migration `.md` files |
| **Spring configs** | Parsed `application-*.yml` profiles |

## Generated Output

### JUnit Unit Tests
- One test class per source component
- Package: `<base_package>.autotest`
- REST controllers → `@WebMvcTest` + MockMvc
- SOAP endpoints → `@ExtendWith(MockitoExtension.class)` + `@InjectMocks`
- Services → `@InjectMocks` + `@Mock` dependencies, concrete default values
- Processors → Success + exception boundary tests
- Models → Instantiation + getter/setter validation
- Clients → Mockito-based with dependency mocking
- Exceptions → Message + cause constructor tests
- Exception handlers → `@ControllerAdvice` handler invocation tests

### WireMock Integration Tests
- `@SpringBootTest` with `RANDOM_PORT`
- WireMock stubs for all discovered downstream services
- Scenarios: success (200), error (500), timeout
- Auto-excludes from unit test runs via surefire `<excludes>`

### Behavioral Tests (v2.1)
- Business rule verification: `BR-NNN` → one test per applicable rule per component
- Field mapping validation: `MAP-NNN` → one test per field per mapping
- Error handling: BR-014 (fallback), BR-015 (error codes), BR-017 (null response)
- PayloadFactory: XSD-driven test object builders (camelCase setters, enum values)
- Package: `<base_package>.autotest.behavioral`

### Postman Collections
- Postman v2.1 collection JSON with REST + SOAP folders
- Test scripts: status code, response time, body assertions
- Environment files per Spring profile (dev, sit, uat, prod)
- Deterministic IDs (SHA-256 content hash, not random UUIDs)

### Markdown Report
- Discovery summary with component counts
- Endpoints table (class, type, path, methods)
- Generated file listings
- Test results with pass rate calculation
- Failure details (class, test, type, message — capped at 20)
- Business rules traceability
- Recommendations

## Incremental Mode

The framework uses SHA-256 checksums to skip regenerating tests for unchanged source files:

```bash
# First run: generates all tests
testgen junit ../my-service
# JUnit: 22 generated, 0 unchanged

# Second run: only regenerates changed files
testgen junit ../my-service
# JUnit: 2 generated, 20 unchanged
```

Checksums are stored in `.testgen/checksums.json`.

## Configuration

Edit `config.yaml` to customize behaviour:

```yaml
# Framework settings
framework:
  generated_package_suffix: "autotest"   # Sub-package for generated tests
  test_class_suffix: "AutoTest"          # Test class name suffix
  backup_before_regenerate: true         # Backup before overwrite

# JUnit settings
junit:
  enabled: true
  components:
    endpoints: true
    services: true
    processors: true
    models: true
    exceptions: true
    clients: true

# WireMock settings
wiremock:
  enabled: true
  port: 0                               # 0 = random port

# Postman settings
postman:
  enabled: true
  base_url_variable: "base_url"
  default_base_url: "http://localhost:8080"

# Reporting settings
reporting:
  format: "md"
  output_dir: "reports"

# Maven settings
maven:
  command: "mvn"                         # Maven executable
  extra_args: "-q"                       # Additional Maven arguments
  skip_run: false                        # true = generate only
```

## Project Structure

```
testing-automation-framework/
├── pyproject.toml                          # Python packaging & dependencies
├── config.yaml                             # Default configuration
├── README.md                               # This file
├── QUICKSTART.md                           # Step-by-step guide for any Spring Boot project
│
└── testgen/                                # Main package
    ├── __init__.py
    ├── cli.py                              # Click CLI — all commands
    ├── models.py                           # Immutable DTOs, ClassKind enum, helpers
    │
    ├── discovery/                          # Layer 1: Project scanning
    │   ├── __init__.py
    │   ├── regex_parser.py                 # Regex-based Java source parser
    │   ├── classifier.py                   # ClassKind classification rules
    │   ├── scanner.py                      # Two-pass streaming project scanner
    │   └── serialiser.py                   # JSON serialisation (.testgen/project.json)
    │
    ├── generation/                         # Layer 2: Test generation
    │   ├── __init__.py
    │   ├── engine.py                       # Jinja2 template engine (user override support)
    │   ├── plugins.py                      # Plugin protocol + JUnit/WireMock/Postman/Behavioral plugins
    │   └── incremental.py                  # SHA-256 checksum-based skip logic
    │
    ├── behavioral/                         # Layer 2b: Behavioral test generation (v2.1)
    │   ├── __init__.py
    │   ├── xsd_analyzer.py                 # XSD schema parser → XsdSchema models
    │   ├── re_parser.py                    # RE document parser → BusinessRuleSpec, FieldMappingSpec
    │   ├── legacy_scanner.py               # JBoss Fuse/Camel route scanner
    │   └── payload_factory.py              # Java PayloadFactory code generator
    │
    ├── execution/                          # Layer 3: Test execution
    │   ├── __init__.py
    │   ├── preflight.py                    # Pre-flight environment validator
    │   ├── pom_manager.py                  # XML-based POM modifications
    │   └── maven_runner.py                 # Maven subprocess + Surefire parser
    │
    ├── reporting/                          # Layer 4: Reports
    │   └── __init__.py                     # Markdown report generator
    │
    └── templates/                          # Jinja2 templates
        ├── junit/
        │   ├── rest_controller.java.j2     # @WebMvcTest + MockMvc
        │   ├── soap_endpoint.java.j2       # SOAP unit tests
        │   ├── service.java.j2             # Service with mock dependencies
        │   ├── processor.java.j2           # Processor boundary tests
        │   ├── model.java.j2               # Getter/setter validation
        │   ├── client.java.j2              # Client mock tests
        │   ├── exception.java.j2           # Exception constructor tests
        │   └── exception_handler.java.j2   # @ControllerAdvice tests
        ├── wiremock/
        │   ├── rest_integration.java.j2    # REST + WireMock stubs
        │   └── soap_integration.java.j2    # SOAP + WireMock stubs
        ├── behavioral/
        │   ├── business_rule.java.j2       # Business rule tests (BR-NNN)
        │   ├── field_mapping.java.j2       # Field mapping tests (MAP-NNN)
        │   └── error_handling.java.j2      # Error/fallback tests
        └── postman/
            ├── collection.json.j2          # Postman v2.1 collection
            └── environment.json.j2         # Per-profile environment
```

## Template Customisation

Override any built-in template by placing a file with the same relative path in your project's `.testgen/templates/` directory:

```
my-service/.testgen/templates/junit/service.java.j2   ← used instead of built-in
```

The engine checks user overrides first, then falls back to built-in templates.

## Key Design Decisions (v1 → v2 → v2.1)

| Aspect | v1 | v2 | v2.1 |
|--------|----|----|------|
| Architecture | Monolithic pipeline | Hybrid Layered | + Behavioral layer |
| CLI | Single script | Click commands | + `behavioral` command |
| Classification | 13 boolean flags | `ClassKind` enum | (unchanged) |
| Templates | Embedded f-strings | External Jinja2 `.java.j2` | + 3 behavioral templates |
| POM editing | String search/replace | `xml.etree.ElementTree` | + argLine merge fix |
| Test types | Unit only | Unit + Integration | + Behavioral (BR/MAP) |
| Schema support | None | XSD/WSDL detection | XSD → PayloadFactory |
| RE doc support | None | BR-NNN detection | Full parse → tests |
| Legacy correlation | None | None | Camel route scanning |
