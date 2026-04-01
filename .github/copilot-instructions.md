# Copilot Agent Instructions

## Repository Context

This is a **Java 21 / Spring Boot 3.2** REST API with H2 in-memory database.
Maven build, layered architecture: Controller → Service → Repository → Entity.

## General Guidelines

- Follow Java conventions and Spring Boot best practices.
- Use Java 21 features where appropriate (records, pattern matching, text blocks).
- All REST controllers under `/api/` prefix.
- Tests use JUnit 5, Mockito, `@SpringBootTest` + `MockMvc`.

## RE/FE Pipeline — Phased Execution

When assigned to a phase issue (labeled `re-fe-phase1` through `re-fe-phase4`):

1. Read the **phase instruction file** referenced in the issue body (under `.github/copilot-phase-instructions/`).
2. Read the **source code** in the folder specified in the issue body.
3. Follow the phase instructions exactly — only do what the current phase asks.
4. Create a branch, commit your work, and open a PR that closes the issue.
5. Use the branch name, PR title, and labels specified in the issue body.

Phase instruction files are in `.github/copilot-phase-instructions/`:
- `phase1-re-docs-1-5.md` — Reverse Engineering documents 1-5
- `phase2-re-docs-6-10.md` — Reverse Engineering documents 6-10
- `phase3-forward-engineering.md` — Forward Engineering
- `phase4-testing.md` — Testing
