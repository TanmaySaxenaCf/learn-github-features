# Phase 4: Testing

## Overview

Generate comprehensive test suites using the testgen framework and manual contract tests.

## Steps

1. **Install testgen**: `pip install -e tools/testgen/`
2. **Run discovery**: `testgen discover .`
3. **Generate JUnit tests**: `testgen junit .`
4. **Generate WireMock tests**: `testgen wiremock .` (if external service calls exist)
5. **Generate behavioral tests**: `testgen behavioral . --re-docs re-docs/{service}/`
6. **Generate Postman collection**: `testgen postman .`
7. **Generate contract tests** manually (see below)
8. **Run all tests**: `testgen run .`
9. **Generate report**: `testgen report .`

## Test Categories

| Category | Generator | Scope |
|----------|-----------|-------|
| Unit Tests (JUnit 5 + Mockito) | `testgen junit` | Controllers, services, repositories, models |
| Integration Tests (WireMock) | `testgen wiremock` | External API stubs — success, error, timeout |
| Behavioral Tests | `testgen behavioral` | BR-NNN verification, MAP-NNN validation, TC-NNN coverage |
| Contract Tests | Manual (see below) | Old vs new behavior parity |
| Postman Collection | `testgen postman` | API manual testing (v2.1 format) |

## Manual Contract Tests

Create `src/test/java/.../contract/{Service}ContractTest.java`:

1. For every API endpoint, verify the forward-engineered code produces:
   - Same HTTP status codes for identical inputs
   - Same response body structure and field values
   - Same validation error messages
2. Use `@SpringBootTest` + `MockMvc`
3. Cover: happy paths, 404s, 400s (validation failures), edge cases

## Output Structure

```
src/test/java/.../
  autotest/              ← testgen-generated unit tests
  autotest/integration/  ← testgen-generated WireMock tests
  behavioral/            ← testgen-generated behavioral tests
  contract/              ← manual contract tests

postman/                 ← testgen-generated Postman collection
reports/                 ← testgen-generated test report
```

## Branch & PR

- **Branch**: `re-fe/{service}-phase4-{parent-issue}` (use values from the issue body)
- **PR Title**: `[RE/FE Phase 4] {service} — Testing (#{parent-issue})`
- **PR Labels**: `re-fe-pipeline`, `re-fe-phase4`
- **PR Body**: Include `Closes #{this-issue-number}` to auto-close this issue when merged.
