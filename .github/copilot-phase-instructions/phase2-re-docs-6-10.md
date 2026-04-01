# Phase 2: Reverse Engineering — Documents 6-10

## Overview

Generate the remaining 5 reverse engineering documents. Cross-reference with the Phase 1 documents already in `re-docs/{service}/`.

## Steps

1. **Read the source code**: Same source folder as Phase 1 (specified in the issue).
2. **Read Phase 1 docs**: Read `re-docs/{service}/01-*.md` through `05-*.md` for cross-referencing.
3. **Read each template**: For each document below, read the template from `.github/re-templates/`.
4. **Generate output**: Replace ALL placeholders with actual analysis. Save under `re-docs/{service}/`.

## Documents to Generate

| # | Template to Read | Output to Create |
|---|-----------------|------------------|
| 6 | `.github/re-templates/06-DATA-FLOW-DIAGRAM-TEMPLATE.md` | `re-docs/{service}/06-data-flow-diagram.md` |
| 7 | `.github/re-templates/07-BDD-FEATURE-SPECS-TEMPLATE.md` | `re-docs/{service}/07-bdd-feature-specs.md` |
| 8 | `.github/re-templates/08-TEST-CASE-INVENTORY-TEMPLATE.md` | `re-docs/{service}/08-test-case-inventory.md` |
| 9 | `.github/re-templates/09-GAP-REPORT-TEMPLATE.md` | `re-docs/{service}/09-gap-report.md` |
| 10 | `.github/re-templates/10-FIELD-TO-FIELD-MAPPING-TEMPLATE.md` | `re-docs/{service}/10-field-to-field-mapping.md` |

Replace `{service}` with the service name from the issue body.

## What Each Document Covers

6. **Data Flow Diagram**: DFD Level 0-2, data sensitivity annotations, dead flow identification.
7. **BDD Feature Specs**: Gherkin scenarios for every feature — happy paths, validation failures, gap-exposing scenarios.
8. **Test Case Inventory**: Complete test catalog with TC-NNN IDs covering unit, integration, boundary, migration-specific tests.
9. **Gap Report**: GAP-NNN items across functional, technical, data, security, dead code categories with severity and resolution options.
10. **Field-to-Field Mapping**: Field-by-field mapping for every endpoint's request/response with transformation logic.

## Rules

1. Replace **ALL** placeholder text with actual analysis from source code.
2. Use **TC-NNN** for test cases, **GAP-NNN** for gaps, **MAP-NNN** for field mappings.
3. Use **Mermaid** syntax for DFD diagrams.
4. Use **Gherkin** format (`Given/When/Then`) for BDD feature specs (doc 7).
5. Cross-reference **BR-NNN** from Phase 1 business rules catalog (doc 4).
6. Cross-reference **COMP-NNN** from Phase 1 component catalog (doc 2).
7. Gap report should reference specific components and business rules.
8. Field mapping should use emoji indicators: 🟢 Direct / 🟡 Transform / 🔴 No Mapping / ⚫ Deprecated / ⚪ Hardcoded.

## Branch & PR

- **Branch**: `re-fe/{service}-phase2-{parent-issue}` (use values from the issue body)
- **PR Title**: `[RE/FE Phase 2] {service} — RE Docs 6-10 (#{parent-issue})`
- **PR Labels**: `re-fe-pipeline`, `re-fe-phase2`
- **PR Body**: Include `Closes #{this-issue-number}` to auto-close this issue when merged.
