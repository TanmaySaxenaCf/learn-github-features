# Copilot Agent Instructions

## Repository Context

This is a **Java 21 / Spring Boot 3.2** REST API project with an H2 in-memory database.
The project uses Maven for builds and follows a standard layered architecture: Controller → Service → Repository → Entity.

## General Guidelines

- Follow standard Java conventions and Spring Boot best practices.
- Use Java 21 features where appropriate (records, pattern matching, text blocks, sealed interfaces).
- All REST controllers are under `/api/` prefix.
- Validation uses Jakarta Bean Validation (`@Valid`, `@NotBlank`, `@Size`).
- Tests use `@SpringBootTest` + `@AutoConfigureMockMvc` with `MockMvc` and JUnit 5 + Mockito.

---

## RE/FE Pipeline Instructions

When assigned to an issue labeled `re-fe-pipeline`, execute **all three phases in order**. The issue comment from the orchestrator workflow contains the specific source folder, service name, and file list.

---

### PHASE 1 — REVERSE ENGINEERING (10 Documents)

Use the **10 templates** in `.github/re-templates/` to generate comprehensive RE documentation.

**Input**: Read ALL Java/XML/properties files in the source folder specified in the issue.
**Output**: Create filled-out documents under `re-docs/{service-name}/`, one per template.

#### Documents to Generate

| # | Template File | Output File | What to Analyze |
|---|--------------|-------------|-----------------|
| 1 | `01-DISCOVERY-REPORT-TEMPLATE.md` | `re-docs/{service}/01-discovery-report.md` | Application overview, tech stack, code metrics, integration points, data landscape, security posture, dead code, hardcoded values |
| 2 | `02-COMPONENT-CATALOG-TEMPLATE.md` | `re-docs/{service}/02-component-catalog.md` | Every class/interface inventory with annotations, dependencies, layered architecture view, third-party libraries, deprecated code |
| 3 | `03-SEQUENCE-DIAGRAMS-TEMPLATE.md` | `re-docs/{service}/03-sequence-diagrams.md` | Runtime interaction flows using ASCII/Mermaid diagrams, annotate gaps and hardcoded values in flows, cross-cutting concerns |
| 4 | `04-BUSINESS-RULES-CATALOG-TEMPLATE.md` | `re-docs/{service}/04-business-rules-catalog.md` | Every validation, computation, decision, workflow, and constraint rule with BR-NNN IDs, pseudocode, source code references, severity |
| 5 | `05-DATA-DICTIONARY-TEMPLATE.md` | `re-docs/{service}/05-data-dictionary.md` | All entity fields with types, constraints, validation rules, field usage status (active/dead/hardcoded), DB column mappings |
| 6 | `06-DATA-FLOW-DIAGRAM-TEMPLATE.md` | `re-docs/{service}/06-data-flow-diagram.md` | DFD Level 0-2, data sensitivity annotations, dead flow identification, transaction logging detail |
| 7 | `07-BDD-FEATURE-SPECS-TEMPLATE.md` | `re-docs/{service}/07-bdd-feature-specs.md` | Gherkin scenarios for every feature — happy paths, validation failures, backend failures, gap-exposing scenarios for dead code and hardcoded values |
| 8 | `08-TEST-CASE-INVENTORY-TEMPLATE.md` | `re-docs/{service}/08-test-case-inventory.md` | Complete test case catalog with TC-NNN IDs covering unit, integration, boundary, migration-specific tests (field mappings, dead code removal) |
| 9 | `09-GAP-REPORT-TEMPLATE.md` | `re-docs/{service}/09-gap-report.md` | GAP-NNN items across functional, technical, data, security, dead code, and hardcoded value categories with severity, impact, resolution options |
| 10 | `10-FIELD-TO-FIELD-MAPPING-TEMPLATE.md` | `re-docs/{service}/10-field-to-field-mapping.md` | Field-by-field mapping for every endpoint's request/response with mapping type (🟢 Direct / 🟡 Transform / 🔴 No Mapping / ⚫ Deprecated / ⚪ Hardcoded), transformation logic |

#### RE Phase Rules

1. **Read every template file** in `.github/re-templates/` carefully before generating output.
2. Replace **ALL** placeholder text (`_[...]_`, `_[Project Name]_`, etc.) with actual analysis from the source code.
3. Use **BR-NNN** numbering for business rules, **GAP-NNN** for gaps, **TC-NNN** for test cases, **COMP-NNN** for components.
4. Cross-reference between documents: business rules should link to test cases, gap items, and field mappings.
5. Use **Mermaid** syntax for all diagrams (class diagrams, sequence diagrams, DFDs, state machines).
6. Flag dead code, hardcoded values, and missing validations explicitly with evidence.
7. Fill the metadata header table in each document (Project Name, Date, etc.).

---

### PHASE 2 — FORWARD ENGINEERING

Use the template in `.github/fe-templates/FORWARD_ENGINEERING_PROMPT_TEMPLATE.md` as the guiding specification.

**Input**: The 10 RE documents generated in Phase 1 + the original source code.
**Output**: A complete, compilable Spring Boot 3.x project under `forward-engineered/{service-name}/`.

#### FE Phase Steps

1. **Read ALL 10 RE documents** generated in Phase 1 — these are the authoritative specifications.
2. **Read ALL source code** in the specified folder — understand every class, annotation, dependency, and config.
3. **Create a migration plan** before writing code:
   - Map each source component to its Spring Boot equivalent
   - List all business rules (BR-NNN) and which class implements each
   - Identify all gaps (GAP-NNN) to fix during forward engineering
4. **Generate the forward-engineered code** under `forward-engineered/{service-name}/` preserving package structure:

   | Source Pattern | Forward-Engineered Equivalent |
   |---------------|-------------------------------|
   | `@RestController` | Keep / modernize with records for request/response DTOs |
   | `@Service` | Keep / add proper error handling with `@ControllerAdvice` + `ProblemDetail` (RFC 7807) |
   | `@Repository` (JPA) | Keep / use Spring Data query methods |
   | `@Entity` | Keep / consider records for DTOs, keep entities mutable |
   | Bean Validation (`@Valid`) | Preserve all validation rules exactly |
   | Config properties | Externalize to `application.yml` with env variable overrides |
   | Hardcoded values | Externalize to configuration |
   | Dead code | Remove with comments explaining removal |

5. **Preserve ALL business rules** (BR-NNN) exactly as documented in the business rules catalog.
6. **Fix ALL gaps** identified in the gap report (GAP-NNN). Document each fix with a code comment.
7. **Verify field-to-field mappings** — every field in the mapping document must exist in the new code.
8. **Generate a MIGRATION_COMPARISON_REPORT.md** in the output folder with:
   - Component-by-component mapping (old → new)
   - Business rule preservation confirmation
   - Gap fixes applied
   - Field mapping accuracy percentage

---

### PHASE 3 — TESTING (testgen Framework)

Use the **testgen testing automation framework** bundled at `tools/testgen/` in this repository.

**Input**: The forward-engineered code from Phase 2 + RE documents from Phase 1.
**Output**: Comprehensive test suites under `src/test/java/`.

#### Testing Phase Steps

1. **Install testgen**: Run `pip install -e tools/testgen/` in the terminal.
2. **Run discovery**: Run `testgen discover .` to scan the project and build a snapshot.
3. **Run validation**: Run `testgen validate .` to check environment readiness.
4. **Fix POM if needed**: Run `testgen fix-pom .` to add surefire argLine and WireMock dependency.
5. **Generate JUnit tests**: Run `testgen junit .` to generate unit tests for all components.
6. **Generate WireMock integration tests**: Run `testgen wiremock .` if external service calls exist.
7. **Generate behavioral tests**: Run `testgen behavioral . --re-docs re-docs/{service-name}/` to generate tests from RE documents.
8. **Run all tests**: Run `testgen run .` to execute and collect results.
9. **Generate report**: Run `testgen report .` to produce a markdown test report.

#### Test Categories to Cover

| Category | Source | What It Tests |
|----------|--------|---------------|
| **Unit Tests** (JUnit 5 + Mockito) | testgen junit | Every controller, service, repository, model — MockMvc for REST, Mockito for services |
| **Integration Tests** (WireMock) | testgen wiremock | Downstream API stubs — success, error, timeout scenarios |
| **Behavioral Tests** (from RE docs) | testgen behavioral | Business rule verification (BR-NNN), field mapping validation (MAP-NNN), test case inventory (TC-NNN) |
| **Contract Tests** (manual) | Generated by Copilot | Old behavior vs new behavior — same inputs produce same outputs |

#### Manual Contract Test Requirements

In addition to testgen-generated tests, create contract tests under `src/test/java/.../contract/`:

1. Name: `{ServiceName}ContractTest.java`
2. For every API endpoint, test that the forward-engineered code produces:
   - Same HTTP status codes for identical inputs
   - Same response body structure and field values
   - Same validation error messages
3. Use `@SpringBootTest` + `MockMvc`
4. Cover: happy paths, 404s, 400s (validation), edge cases

#### Postman Collection

Run `testgen postman .` to generate a Postman v2.1 collection + environment files for manual API testing.

---

### OUTPUT CONVENTIONS

| Item | Convention |
|------|-----------|
| **Branch** | `re-fe/{service-name}-{issue-number}` |
| **PR Title** | `[RE/FE Pipeline] {service-name} — #{issue-number}` |
| **PR Labels** | `re-fe-pipeline` |
| **PR Close Clause** | `Closes #{issue-number}` |
| **PR Body** | Summary table of ALL generated files with purpose + phase |

### FILE LAYOUT

```
re-docs/{service-name}/
  01-discovery-report.md
  02-component-catalog.md
  03-sequence-diagrams.md
  04-business-rules-catalog.md
  05-data-dictionary.md
  06-data-flow-diagram.md
  07-bdd-feature-specs.md
  08-test-case-inventory.md
  09-gap-report.md
  10-field-to-field-mapping.md

forward-engineered/{service-name}/
  com/example/taskmanager/
    ...modernized source code...
  MIGRATION_COMPARISON_REPORT.md

src/test/java/com/example/taskmanager/
  autotest/              ← testgen-generated unit tests
  autotest/integration/  ← testgen-generated WireMock tests
  behavioral/            ← testgen-generated behavioral tests
  contract/              ← manually generated contract tests

postman/                 ← testgen-generated Postman collection
reports/                 ← testgen-generated test report
```
