# Phase 1: Reverse Engineering — Documents 1-5

## Overview

Generate the first 5 reverse engineering documents by analyzing all source code in the specified folder.

## Steps

1. **Read the source code**: Read ALL Java, XML, properties, and YAML files in the source folder specified in the issue.
2. **Read each template**: For each document below, read the corresponding template file from `.github/re-templates/`.
3. **Generate the output**: Replace ALL placeholder text in the template with actual analysis. Save under `re-docs/{service-name}/`.

## Documents to Generate

| # | Template to Read | Output to Create |
|---|-----------------|------------------|
| 1 | `.github/re-templates/01-DISCOVERY-REPORT-TEMPLATE.md` | `re-docs/{service}/01-discovery-report.md` |
| 2 | `.github/re-templates/02-COMPONENT-CATALOG-TEMPLATE.md` | `re-docs/{service}/02-component-catalog.md` |
| 3 | `.github/re-templates/03-SEQUENCE-DIAGRAMS-TEMPLATE.md` | `re-docs/{service}/03-sequence-diagrams.md` |
| 4 | `.github/re-templates/04-BUSINESS-RULES-CATALOG-TEMPLATE.md` | `re-docs/{service}/04-business-rules-catalog.md` |
| 5 | `.github/re-templates/05-DATA-DICTIONARY-TEMPLATE.md` | `re-docs/{service}/05-data-dictionary.md` |

Replace `{service}` with the service name from the issue body.

## What Each Document Covers

1. **Discovery Report**: Application overview, tech stack, code metrics, integration points, data landscape, security posture, dead code, hardcoded values.
2. **Component Catalog**: Every class/interface inventory with annotations, dependencies, layered architecture view, third-party libraries.
3. **Sequence Diagrams**: Runtime interaction flows using Mermaid diagrams, annotate gaps and hardcoded values in flows.
4. **Business Rules Catalog**: Every validation, computation, decision, workflow rule with BR-NNN IDs, pseudocode, source references.
5. **Data Dictionary**: All entity fields with types, constraints, validation rules, DB column mappings.

## Rules

1. Replace **ALL** placeholder text (`_[...]_`, `_[Project Name]_`, etc.) with actual analysis from source code.
2. Use **BR-NNN** numbering for business rules, **COMP-NNN** for components.
3. Use **Mermaid** syntax for all diagrams (class diagrams, sequence diagrams).
4. Flag dead code, hardcoded values, and missing validations explicitly with evidence.
5. Fill the metadata header table in each document (Project Name, Date, etc.).
6. Cross-reference: business rules should link to the components that implement them.

## Branch & PR

- **Branch**: `re-fe/{service}-phase1-{parent-issue}` (use values from the issue body)
- **PR Title**: `[RE/FE Phase 1] {service} — RE Docs 1-5 (#{parent-issue})`
- **PR Labels**: `re-fe-pipeline`, `re-fe-phase1`
- **PR Body**: Include `Closes #{this-issue-number}` to auto-close this issue when merged.
