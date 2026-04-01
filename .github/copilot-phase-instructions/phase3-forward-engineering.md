# Phase 3: Forward Engineering

## Overview

Generate modernized Spring Boot 3.x code based on the 10 RE documents and the original source code.

## Steps

1. **Read ALL 10 RE documents** in `re-docs/{service}/` — these are the authoritative specifications.
2. **Read ALL source code** in the original source folder (specified in the issue).
3. **Read the FE template** at `.github/fe-templates/FORWARD_ENGINEERING_PROMPT_TEMPLATE.md`.
4. **Create a migration plan**: Map each source component to its Spring Boot equivalent.
5. **Generate code** under `forward-engineered/{service}/` preserving package structure.
6. **Generate `MIGRATION_COMPARISON_REPORT.md`** in the output folder.

## Migration Rules

| Source Pattern | Target |
|----------------|--------|
| `@RestController` | Modernize, use records for request/response DTOs |
| `@Service` | Add `@ControllerAdvice` + `ProblemDetail` (RFC 7807) for error handling |
| `@Repository` (JPA) | Use Spring Data query methods |
| `@Entity` | Keep mutable, use records for DTOs only |
| Bean Validation (`@Valid`) | Preserve ALL validation rules exactly |
| Config properties | Externalize to `application.yml` with env variable overrides |
| Hardcoded values | Externalize to configuration |
| Dead code | Remove with comments explaining removal |

## Key Requirements

- **Preserve ALL business rules** (BR-NNN) from the business rules catalog (doc 4).
- **Fix ALL gaps** (GAP-NNN) from the gap report (doc 9). Document each fix with a code comment.
- **Verify field-to-field mappings** (doc 10) — every mapped field must exist in new code.
- Use **Java 21** features (records, pattern matching, text blocks, sealed interfaces).
- Use **Jakarta** namespace (not javax).
- Migration comparison report must include:
  - Component-by-component mapping (old → new)
  - Business rule preservation confirmation
  - Gap fixes applied
  - Field mapping accuracy percentage

## Output Structure

```
forward-engineered/{service}/
  src/main/java/com/example/...   ← modernized source code
  src/main/resources/              ← application.yml, etc.
  MIGRATION_COMPARISON_REPORT.md   ← migration evidence
```

## Branch & PR

- **Branch**: `re-fe/{service}-phase3-{parent-issue}` (use values from the issue body)
- **PR Title**: `[RE/FE Phase 3] {service} — Forward Engineering (#{parent-issue})`
- **PR Labels**: `re-fe-pipeline`, `re-fe-phase3`
- **PR Body**: Include `Closes #{this-issue-number}` to auto-close this issue when merged.
