# QUICKSTART — Running Any Spring Boot Service with testgen

Step-by-step guide to generate and execute tests for **any Spring Boot Maven project** using the testgen framework.

---

## Prerequisites

Before you begin, ensure you have:

| Requirement | Minimum Version | Check Command |
|-------------|-----------------|---------------|
| Python | 3.10+ | `python --version` |
| Java (JDK) | 11+ (21 supported) | `java -version` |
| Maven | 3.6+ | `mvn -version` |
| pip | Any | `pip --version` |

---

## Step 1: Install testgen

```bash
# Navigate to the framework directory
cd testing-automation-framework

# Option A: Install as editable package (recommended for development)
pip install -e .

# Option B: Install dependencies manually
pip install PyYAML>=6.0 Jinja2>=3.1 click>=8.1
```

After installation, the `testgen` command is available globally:

```bash
testgen --help
```

---

## Step 2: Validate the Environment

Before generating tests, verify that your environment is correctly set up:

```bash
testgen validate ../path/to/your-spring-boot-project
```

**Example output:**

```
  [!] JDK 21 detected. Mockito's ByteBuddy requires --add-opens for inline mock maker.
      -> Run `testgen fix-pom` to auto-configure surefire argLine.
  [i] No explicit surefire plugin config. Using Spring Boot defaults.
      -> Run `testgen fix-pom` to add surefire with proper argLine.
```

If issues are found, proceed to Step 3. If all checks pass, skip to Step 4.

---

## Step 3: Fix POM Configuration

Auto-apply all necessary POM changes for test execution:

```bash
testgen fix-pom ../path/to/your-spring-boot-project
```

**What this does:**
- Adds `maven-surefire-plugin` with `--add-opens` argLine (required for JDK 17+/21)
- Adds `**/*IntegrationAutoTest.java` exclusion so integration tests don't run with unit tests
- Adds WireMock dependency if missing

---

## Step 4: Discover the Project

Scan the project to build a snapshot of its architecture:

```bash
testgen discover ../path/to/your-spring-boot-project
```

**Example output:**

```
Discovered 23 classes in 0.12s
  REST endpoints:  1
  SOAP endpoints:  2
  Services:        1
  Processors:      4
  Models/DTOs:     10
  Clients:         2
Written to ..\sb-my-service\.testgen\project.json
```

The discovery snapshot is saved to `.testgen/project.json` in the target project. All subsequent commands use this snapshot.

---

## Step 5: Generate Tests

### Option A: Generate Everything at Once

```bash
# Generate JUnit + WireMock + Postman
testgen junit    ../path/to/your-spring-boot-project
testgen wiremock ../path/to/your-spring-boot-project
testgen postman  ../path/to/your-spring-boot-project
```

### Option B: Preview Before Generating (Dry Run)

```bash
testgen junit ../path/to/your-spring-boot-project --dry-run
```

**Example output:**

```
[dry-run] Would generate: MyRestEndpointAutoTest.java
[dry-run] Would generate: MySoapEndpointAutoTest.java
[dry-run] Would generate: MyServiceAutoTest.java
[dry-run] Would generate: MyModelAutoTest.java
  ...
JUnit: 0 generated, 0 unchanged, in 0.18s
```

### Option C: Generate Only Specific Component Types

```bash
# Only service tests
testgen junit ../path/to/your-spring-boot-project --only services

# Only model/DTO tests
testgen junit ../path/to/your-spring-boot-project --only models

# Only endpoint tests
testgen junit ../path/to/your-spring-boot-project --only endpoints
```

Available `--only` values: `services`, `models`, `processors`, `clients`, `endpoints`, `exceptions`

---

## Step 6: Run the Tests

Execute the generated tests via Maven:

```bash
testgen run ../path/to/your-spring-boot-project
```

**Example output:**

```
BUILD SUCCESS
  Total:   68
  Passed:  68 (100.0%)
  Failed:  0
  Errors:  0
  Skipped: 0
  Time:    12.34s
```

---

## Step 7: Generate a Report

Create a Markdown report with full analysis:

```bash
testgen report ../path/to/your-spring-boot-project
```

The report is written to `<project>/reports/test_report_<timestamp>.md` and includes:
- Discovery summary
- Endpoints table
- Generated file listings
- Test results with pass rate
- Failure details (if any)
- Business rules traceability
- Recommendations

---

## One-Command Full Pipeline

Instead of running each step individually, use the `all` command:

```bash
# Complete pipeline: discover → validate → fix-pom → generate → run → report
testgen all ../path/to/your-spring-boot-project
```

**Example output:**

```
=== Phase 1: Discovery ===
  23 classes discovered in 0.12s

=== Phase 2: Validation ===
  [!] JDK 21 detected. Mockito's ByteBuddy requires --add-opens for inline mock maker.

=== Phase 3: POM Setup ===
  Added maven-surefire-plugin with --add-opens argLine
  Added WireMock dependency

=== Phase 4: Generation ===
  Generated: 22 JUnit, 3 WireMock, 6 Postman in 0.45s

=== Phase 5: Test Execution ===
  68 tests, 68 passed (100.0%)

=== Phase 6: Report ===
  Report: ..\sb-my-service\reports\test_report_2026-03-25_10-15-30.md

Total time: 18.72s
```

### Useful Flags for `all`

```bash
# Preview only — no files written, no tests run
testgen all ../path/to/your-spring-boot-project --dry-run

# Generate tests but skip execution
testgen all ../path/to/your-spring-boot-project --skip-run

# Use a custom config file
testgen all ../path/to/your-spring-boot-project --config my-config.yaml
```

---

## Working with a New Spring Boot Project

To use testgen on **any new Spring Boot Maven project**, just follow these steps:

### Minimum Requirements for the Target Project

| Requirement | Details |
|-------------|---------|
| Build tool | Maven (must have `pom.xml`) |
| Framework | Spring Boot |
| Source location | `src/main/java/` |
| Config location | `src/main/resources/application*.yml` |

No code changes or configuration are needed in the target project. The framework automatically adapts to whatever annotations, endpoints, and architecture the service uses.

---

## Step 8 (Optional): Generate Behavioral Tests (v2.1)

If you have reverse-engineering (RE) documents from a migration project, you can generate behavioral tests that verify business rules, field mappings, and error handling.

### What You Need

| Input | Required | Format |
|-------|----------|--------|
| RE docs directory | **Yes** | Folder with markdown files |
| Business rules doc | **Yes** | `## BR-NNN: Rule Name` headers with `- Business Logic:` bullets |
| Field mapping doc | **Yes** | `## MAP-NNN: Mapping Name` headers with field tables |
| Test case inventory | **Yes** | `## TC-*-NNN: Test Name` headers |
| Legacy codebase | No | JBoss Fuse/Camel project with `blueprint.xml` files |

### RE Document Format

The parser expects these header formats in your markdown files:

**Business Rules** (`04-BUSINESS-RULES-CATALOG-*.md`):
```markdown
## BR-001: Province Code Validation
- Category: validation
- Description: Must validate province code against allowed Canadian values
- Business Logic: IF province NOT IN valid_codes THEN reject
```

**Field Mappings** (`10-FIELD-TO-FIELD-MAPPING-*.md`):
```markdown
## MAP-001: Request Mapping
Source: MyReqType | Target: ExternalRequestType

| Source Field | Target Field | Type | Transformation |
|---|---|---|---|
| request.postalCode | target.postalCode | String | Direct copy |
```

**Test Cases** (`08-TEST-CASE-INVENTORY-*.md`):
```markdown
## TC-FUNC-001: Valid Province Test
- Category: functional
- Description: Verify all valid provinces are accepted
```

### Generate Behavioral Tests

```bash
# With RE docs only — generates business rule + field mapping tests
testgen behavioral ../sb-my-service \
    --re-docs ../reverse-engineering

# With legacy codebase — also attempts Camel route correlation
testgen behavioral ../sb-my-service \
    --re-docs ../reverse-engineering \
    --legacy-path ../legacy-project

# Preview first
testgen behavioral ../sb-my-service \
    --re-docs ../reverse-engineering \
    --dry-run
```

### What Gets Generated

| File | Description |
|------|-------------|
| `PayloadFactory.java` | XSD-driven test object factory (builder methods for all JAXB types) |
| `*BehavioralAutoTest.java` | Business rule tests per applicable component — **invokes actual methods and verifies return values** |
| Field mapping completeness tests | One test per field per mapping — **calls mapping methods with real inputs** |
| Error handling tests | Fallback (`mapResponse(null)`), error code, null response — **asserts non-null fallback results** |

> **Phase 2 (Strong Assertions):** All generated tests now use strong assertions. Business rule tests call `mapRequest()`, `mapResponse()`, factory methods etc. and verify non-null return values. Error handling tests pass null to mapping methods and assert fallback paths return valid results. Placeholder assertions like `assertNotNull(instance)` and `assertTrue(true)` have been eliminated.

### Example Output

```
  XSD: 15 types from 2 schemas
  RE docs: 19 rules, 9 mappings, 40 test cases
  Legacy: 0 routes, 0 beans
  Generated: PayloadFactory.java
Behavioral: 10 generated in 0.16s
```

### Example: Running on a New Service

```bash
# 1. Clone or navigate to the framework
cd testing-automation-framework

# 2. Point testgen at your project (relative or absolute path)
testgen all /path/to/my-new-spring-boot-service

# 3. Check results
#    Tests:  my-new-spring-boot-service/src/test/java/<package>/autotest/
#    Report: my-new-spring-boot-service/reports/test_report_<timestamp>.md
#    Postman: my-new-spring-boot-service/postman/
```

---

## Where Generated Files Go

After running testgen, the following files are created in the **target project** (not in the framework directory):

```
your-spring-boot-project/
├── .testgen/
│   ├── project.json              # Discovery snapshot
│   └── checksums.json            # Incremental build checksums
├── src/test/java/<package>/
│   └── autotest/
│       ├── *AutoTest.java        # JUnit unit tests
│       └── integration/
│           └── *IntegrationAutoTest.java  # WireMock tests
├── postman/
│   ├── <artifact>_collection.json
│   ├── <artifact>_dev_env.json
│   ├── <artifact>_sit_env.json
│   ├── <artifact>_uat_env.json
│   └── <artifact>_prod_env.json
└── reports/
    └── test_report_<timestamp>.md
```

---

## Incremental Builds

On subsequent runs, testgen only regenerates tests for source files that have changed:

```bash
# First run
testgen junit ../my-service
# JUnit: 22 generated, 0 unchanged

# After modifying 2 source files
testgen junit ../my-service
# JUnit: 2 generated, 20 unchanged
```

To force a full regeneration, delete the checksums file:

```bash
# Windows
del ..\my-service\.testgen\checksums.json

# Linux/macOS
rm ../my-service/.testgen/checksums.json
```

---

## Customising Templates

Override any built-in template by placing a file with the same relative path in the target project:

```
my-service/.testgen/templates/junit/service.java.j2
```

The engine loads user overrides first, then falls back to built-in templates. This lets you customise test structure without modifying the framework itself.

Available templates to override:

| Template | Purpose |
|----------|---------|
| `junit/rest_controller.java.j2` | REST @WebMvcTest + MockMvc |
| `junit/soap_endpoint.java.j2` | SOAP unit tests |
| `junit/service.java.j2` | Service with mock dependencies |
| `junit/processor.java.j2` | Processor boundary tests |
| `junit/model.java.j2` | Model getter/setter tests |
| `junit/client.java.j2` | Client mock tests |
| `junit/exception.java.j2` | Exception constructor tests |
| `junit/exception_handler.java.j2` | @ControllerAdvice handler tests |
| `wiremock/rest_integration.java.j2` | REST + WireMock stubs |
| `wiremock/soap_integration.java.j2` | SOAP + WireMock stubs |
| `postman/collection.json.j2` | Postman v2.1 collection |
| `postman/environment.json.j2` | Per-profile environment |

---

## Troubleshooting

### "No such option: -v"
The `--verbose` flag belongs to the top-level `testgen` group, not subcommands. Place it before the command name:
```bash
testgen -v discover ../my-service    # Correct
testgen discover ../my-service -v    # Error
```

### "All tests fail with ByteBuddy agent errors"
Run `testgen fix-pom` to add `--add-opens java.base/java.lang=ALL-UNNAMED` to surefire argLine. This is required for JDK 17+ with Mockito's inline mock maker.

### "No classes discovered"
Verify the project has:
- A `pom.xml` at the root
- Java sources under `src/main/java/`
- Standard Spring Boot annotations (`@RestController`, `@Service`, etc.)

### "Maven not found"
Ensure `mvn` is on your PATH, or set the path in `config.yaml`:
```yaml
maven:
  command: "C:/path/to/maven/bin/mvn"
```

### "Jinja2 / PyYAML / Click not found"
Install the framework dependencies:
```bash
pip install -e .
# or
pip install PyYAML>=6.0 Jinja2>=3.1 click>=8.1
```

---

## Quick Reference Card

```
testgen discover <project>                    # Scan project
testgen validate <project>                    # Check environment
testgen fix-pom  <project>                    # Fix POM config
testgen junit    <project> [--only X] [--dry-run]  # Generate unit tests
testgen wiremock <project> [--dry-run]        # Generate integration tests
testgen postman  <project> [--dry-run]        # Generate Postman files
testgen run      <project>                    # Execute Maven tests
testgen report   <project>                    # Generate report
testgen all      <project> [--dry-run] [--skip-run]  # Full pipeline
```
