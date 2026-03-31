# Reverse Engineering → Forward Engineering → Testing Pipeline

## Architecture Design Report

**Date**: March 31, 2026
**Repository**: `learn-github-features`
**Scope**: Java/Spring Boot services — repeatable, automated, GitHub-native

---

## 1. Executive Summary

This document defines an end-to-end automated pipeline that transforms a **source folder path** (provided via a GitHub Issue) into a fully reverse-engineered, forward-engineered, and tested deliverable — all within GitHub using GitHub Copilot coding agent + the testgen testing framework.

**One-line flow:**
```
Issue (folder path) → Auto-assign Copilot → 10 RE Docs → FE Code → testgen Tests → Pull Request → Human Review
```

---

## 2. Architecture Overview

```
┌──────────────────────────────────────────────────────────────────────────────────┐
│                              GITHUB REPOSITORY                                   │
│                                                                                  │
│  ┌─────────────┐    ┌──────────────────┐    ┌──────────────────────────────────┐ │
│  │  ISSUE       │    │  GITHUB ACTION    │    │  COPILOT AGENT                   │ │
│  │  TEMPLATE    │───▶│  ORCHESTRATOR     │───▶│  (Coding Agent)                  │ │
│  │              │    │                   │    │                                   │ │
│  │ • folder path│    │ • Parse input     │    │ Phase 1: Reverse Engineering      │ │
│  │ • service    │    │ • Validate folder │    │   • 10 RE templates → 10 docs     │ │
│  │   name       │    │ • Post instruct.  │    │   • BR/GAP/TC numbering           │ │
│  │ • options    │    │ • Assign copilot  │    │   • Cross-referenced artifacts    │ │
│  └─────────────┘    └──────────────────┘    │                                   │ │
│                                              │ Phase 2: Forward Engineering       │ │
│                                              │   • FE template-guided migration   │ │
│                                              │   • Modernized Spring Boot 3.x     │ │
│                                              │   • Migration comparison report    │ │
│                                              │                                   │ │
│                                              │ Phase 3: Testing                   │ │
│                                              │   • testgen discover/junit/wiremock│ │
│                                              │   • testgen behavioral (from RE)   │ │
│                                              │   • Manual contract tests          │ │
│                                              │   • testgen postman collections    │ │
│                                              │   • testgen report                 │ │
│                                              │                                   │ │
│                                              │ → Opens Pull Request               │ │
│                                              └────────────┬─────────────────────┘ │
│                                                           │                       │
│                       ┌───────────────────────────────────▼────────────────────┐  │
│                       │  PULL REQUEST                                          │  │
│                       │                                                        │  │
│                       │  re-docs/{service}/                                    │  │
│                       │  ├── 01-discovery-report.md                            │  │
│                       │  ├── 02-component-catalog.md                           │  │
│                       │  ├── ...                                               │  │
│                       │  └── 10-field-to-field-mapping.md                      │  │
│                       │                                                        │  │
│                       │  forward-engineered/{service}/                         │  │
│                       │  ├── ...modernized code...                             │  │
│                       │  └── MIGRATION_COMPARISON_REPORT.md                    │  │
│                       │                                                        │  │
│                       │  src/test/java/                                        │  │
│                       │  ├── autotest/ (testgen JUnit)                         │  │
│                       │  ├── autotest/integration/ (WireMock)                  │  │
│                       │  ├── behavioral/ (from RE docs)                        │  │
│                       │  └── contract/ (manual contract tests)                 │  │
│                       │                                                        │  │
│                       │  postman/ (Postman collection + environments)          │  │
│                       │  reports/ (testgen test report)                        │  │
│                       │                                                        │  │
│                       │  ┌─────────────────────────────────┐                   │  │
│                       │  │ CI VALIDATION                    │                   │  │
│                       │  │ • 10/10 RE docs present?         │                   │  │
│                       │  │ • FE code + migration report?    │                   │  │
│                       │  │ • Build passes?                  │                   │  │
│                       │  │ • All tests pass?                │                   │  │
│                       │  │ • Posts validation summary on PR │                   │  │
│                       │  └─────────────────────────────────┘                   │  │
│                       │                                                        │  │
│                       │  → Human Review → Merge → Issue Auto-Closes            │  │
│                       └────────────────────────────────────────────────────────┘  │
└──────────────────────────────────────────────────────────────────────────────────┘
```

---

## 3. Design of Experiments (DoE)

Four architectural factors were evaluated. Each factor has 3 candidate approaches scored on **Repeatability**, **Quality**, **Complexity**, and **GitHub-native** fit (1–5, higher is better).

### Factor 1: Orchestration Model

| Approach | Description | Repeat. | Quality | Complex. | Native | **Total** |
|----------|-------------|---------|---------|----------|--------|-----------|
| **A1: Single Copilot run** | One issue → Copilot does RE+FE+Testing → one PR | 5 | 3 | 5 | 5 | **18** |
| A2: Chained multi-stage | 3 issues → 3 PRs → auto-linked | 4 | 5 | 2 | 4 | 15 |
| A3: Actions-embedded AI | GH Actions calls AI API at each stage | 3 | 4 | 2 | 3 | 12 |

**Winner: A1** — Simplest to maintain, fully GitHub-native.

### Factor 2: Reverse Engineering Document Generation

| Approach | Description | Repeat. | Quality | Complex. | Native | **Total** |
|----------|-------------|---------|---------|----------|--------|-----------|
| B1: Free-form generation | Copilot generates docs from scratch | 3 | 3 | 5 | 5 | 16 |
| **B2: 10-template guided** | Copilot fills pre-defined enterprise RE templates | 5 | 5 | 4 | 5 | **19** |
| B3: Tool + AI hybrid | jdeps/javadoc output → AI enhances | 4 | 4 | 2 | 2 | 12 |

**Winner: B2** — 10 specialized templates ensure comprehensive, consistent output across all services.

### Factor 3: Forward Engineering Strategy

| Approach | Description | Repeat. | Quality | Complex. | Native | **Total** |
|----------|-------------|---------|---------|----------|--------|-----------|
| **C1: FE template + separate output** | Template-guided migration to `forward-engineered/` | 5 | 5 | 4 | 5 | **19** |
| C2: In-place refactoring | Modify original code on branch | 4 | 4 | 3 | 5 | 16 |
| C3: Spec → codegen tool | Generate OpenAPI spec → use codegen | 3 | 3 | 2 | 2 | 10 |

**Winner: C1** — FE template provides detailed migration rules; separate folder keeps original safe.

### Factor 4: Test Generation

| Approach | Description | Repeat. | Quality | Complex. | Native | **Total** |
|----------|-------------|---------|---------|----------|--------|-----------|
| D1: Manual test writing | Copilot writes all tests from scratch | 4 | 3 | 4 | 5 | 16 |
| **D2: testgen framework + contract tests** | Automated discovery + generation + RE-based behavioral tests + manual contracts | 5 | 5 | 4 | 4 | **18** |
| D3: Record-and-replay | Capture old API responses → assert against new | 4 | 5 | 2 | 3 | 14 |

**Winner: D2** — testgen automates JUnit/WireMock/behavioral/Postman generation; contract tests verify equivalence.

---

## 4. End-to-End Process Flow

### Step 1: User Creates Issue
- Navigate to **Issues → New Issue → "RE/FE Pipeline"** template
- Fill in: Source Folder Path, Service Name, Service Type, Pipeline Stages, Additional Context

### Step 2: GitHub Action Triggers (Automatic)
- Workflow `re-fe-pipeline.yml` fires on issue open with label `re-fe-pipeline`
- **Parses** the issue body to extract folder path, service name, and selected stages
- **Validates** the folder exists and contains Java files
- **Posts** a structured comment with full Copilot instructions referencing all templates
- **Assigns** `copilot` to the issue (triggers Copilot coding agent)

### Step 3: Copilot Agent Executes (Automatic)

#### Phase 1 — Reverse Engineering (10 Documents)
Reads all source files and generates 10 comprehensive documents:
1. `01-discovery-report.md` — Application overview, tech stack, code metrics, integration points
2. `02-component-catalog.md` — Class inventory, dependency mapping, deprecated code
3. `03-sequence-diagrams.md` — Runtime interaction flows (Mermaid), gap annotations
4. `04-business-rules-catalog.md` — All BR-NNN rules with pseudocode and source references
5. `05-data-dictionary.md` — Entity fields, types, constraints, usage status
6. `06-data-flow-diagram.md` — DFD Level 0-2, data sensitivity, dead flows
7. `07-bdd-feature-specs.md` — Gherkin scenarios for every feature and gap
8. `08-test-case-inventory.md` — TC-NNN test cases covering all categories
9. `09-gap-report.md` — GAP-NNN items with severity, impact, resolution
10. `10-field-to-field-mapping.md` — Request/response field mapping with transformation rules

#### Phase 2 — Forward Engineering
- Reads RE docs (authoritative specs) + FE template
- Creates modernized Spring Boot 3.x code under `forward-engineered/{service}/`
- Preserves all business rules, fixes all gaps, externalizes hardcoded values
- Generates `MIGRATION_COMPARISON_REPORT.md`

#### Phase 3 — Testing (testgen Framework)
- Installs and runs `testgen` bundled at `tools/testgen/`
- Generates: JUnit 5 unit tests, WireMock integration tests, behavioral tests (from RE docs), Postman collections
- Creates manual contract tests validating old vs new behavior
- Generates test execution report

#### Opens Pull Request
- Branch: `re-fe/{service}-{issue-number}`
- PR references `Closes #{issue-number}`

### Step 4: CI Validates PR (Automatic)
- Workflow `re-fe-validation.yml` checks:
  - All 10 RE docs present and non-empty
  - Forward-engineered code exists + migration report
  - Project builds successfully
  - All tests pass (existing + contract + testgen-generated)
- Posts detailed validation summary as PR comment

### Step 5: Human Reviews & Merges (Manual)
- Reviewer examines RE doc quality, FE code correctness, test coverage
- Approves and merges → issue auto-closes

---

## 5. File Inventory

| File | Purpose |
|------|---------|
| `.github/ISSUE_TEMPLATE/re-fe-pipeline.yml` | Issue form — captures folder path, service name, stages |
| `.github/workflows/re-fe-pipeline.yml` | Orchestrator — parses issue, validates, posts instructions, assigns Copilot |
| `.github/workflows/re-fe-validation.yml` | PR CI — validates 10 RE docs, FE code, build, tests, posts report |
| `.github/copilot-instructions.md` | Copilot agent instructions — all 3 phases with detailed rules |
| `.github/re-templates/01-*.md` through `10-*.md` | 10 enterprise RE document templates |
| `.github/fe-templates/FORWARD_ENGINEERING_PROMPT_TEMPLATE.md` | FE migration template with tech stack, project structure, rules |
| `tools/testgen/` | testgen Python testing automation framework (bundled) |

---

## 6. Repeatable Usage

For any service folder in the repo:

1. **Create issue** → select "RE/FE Pipeline" template
2. **Enter folder path** → e.g., `src/main/java/com/example/taskmanager/service/`
3. **Select stages** → RE, FE, Testing (any combination)
4. **Submit** → pipeline runs automatically
5. **Review PR** → 10 RE docs + modernized code + tests + reports

No workflow changes needed. The pipeline adapts to whatever Java/Spring Boot code is in the specified folder.
