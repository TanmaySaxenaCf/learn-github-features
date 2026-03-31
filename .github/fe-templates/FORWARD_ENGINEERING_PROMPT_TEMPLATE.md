# Forward Engineering Prompt Template
## JBoss Fuse 6.3 → Spring Boot 3.x Migration

> **Usage**: Copy the prompt below, replace the `{{PLACEHOLDERS}}` with your service-specific values, and paste into a new Copilot CLI session.

---

## THE PROMPT (copy everything below this line)

---

### TASK: Forward Engineering — JBoss Fuse to Spring Boot Migration

I need to perform **forward engineering** to migrate a legacy JBoss Fuse 6.3 service to Spring Boot 3.x.

**Legacy source code location:** `{{LEGACY_SOURCE_PATH}}`
**Reverse engineering documents location:** `{{RE_DOCUMENTS_PATH}}`
**Output location:** `{{OUTPUT_PATH}}`

---

### PHASE 1: ANALYSIS (Do NOT write code yet)

1. **Read ALL reverse engineering documents** in the RE documents path — these are the authoritative specifications. Typical RE documents include:
   - Discovery Report (service overview, endpoints, protocols)
   - Architecture Diagram / Component Map
   - Business Rules Catalog (BR-001, BR-002, etc.)
   - Error Codes & Fault Handling
   - Data Flow / Sequence Diagrams
   - Gap Analysis (known bugs, missing features, tech debt)
   - Security Assessment
   - Configuration & Environment
   - Integration Points / External Dependencies
   - Field-to-Field Mapping (request/response field mapping tables)

2. **Read ALL legacy source files** — every `.java`, `.xml` (Blueprint, CXF endpoints, Camel routes), `pom.xml`, `.properties`, `.cfg`, WSDL/XSD files. Understand:
   - How many Java classes exist and what each does
   - The Camel route flow (Blueprint XML → processors → endpoints)
   - All WSDL/XSD contracts (inbound and outbound)
   - All dependencies and their versions
   - Configuration properties and how they're injected (Blueprint, JNDI, property files)

3. **Create a structured migration plan** before writing any code:
   - Map each legacy component to its Spring Boot equivalent
   - List all business rules and which class implements each
   - Identify all bugs from the Gap Analysis to fix during migration
   - Identify what is intentionally NOT being migrated (Phase 2 items)
   - Track the plan using SQL todos with dependencies

---

### PHASE 2: IMPLEMENTATION (Spring Boot Project Creation)

Create a **complete, compilable Spring Boot 3.x project** following these specifications:

#### Technology Stack
| Component | Technology |
|-----------|-----------|
| Framework | Spring Boot 3.2+ with Java 17 |
| SOAP (inbound + outbound) | Apache CXF 4.0+ (JAX-WS with Jakarta EE) |
| JAXB Code Generation | `cxf-codegen-plugin` (generates from WSDL/XSD) |
| Resilience | Resilience4j (retry + circuit breaker on outbound calls) |
| Monitoring | Spring Boot Actuator (health, metrics, prometheus) |
| Logging | SLF4J + Logback (replaces Log4j 1.x) |
| Configuration | `application.yml` with environment variable overrides |
| Namespace | `jakarta.*` (NOT `javax.*`) |

#### Project Structure
```
{{SERVICE_NAME}}/
├── pom.xml
├── src/main/java/com/aviva/ca/{{SERVICE_PACKAGE}}/
│   ├── {{ServiceName}}Application.java          # @SpringBootApplication
│   ├── constants/{{ServiceName}}Constants.java   # All error codes, messages, business constants
│   ├── errorhandling/{{ServiceName}}ErrorHandler.java  # SOAP fault builder
│   ├── validation/                               # Request & response validators
│   ├── mapper/                                   # Request & response mappers
│   ├── client/                                   # Outbound service clients with resilience
│   ├── config/                                   # CXF endpoint config, bean config
│   └── service/                                  # Main service implementation (@WebService)
├── src/main/resources/
│   ├── application.yml                           # Externalized config
│   └── wsdl/                                     # WSDL/XSD copied verbatim from legacy
│       ├── Publisher/                             # Inbound (exposed) contract
│       └── Consumer/                             # Outbound (called) contract
└── src/test/java/com/aviva/ca/{{SERVICE_PACKAGE}}/
    └── (test classes)
```

#### Implementation Rules

1. **WSDL/XSD contracts MUST be copied verbatim** — do not modify them. Backward compatibility is mandatory.

2. **Use `cxf-codegen-plugin`** in `pom.xml` to generate JAXB classes from both Publisher and Consumer WSDLs into `target/generated-sources/cxf`.

3. **Map each legacy component 1:1** to Spring Boot equivalent:
   | Legacy Pattern | Spring Boot Equivalent |
   |---------------|----------------------|
   | Camel `Processor` | `@Component` with typed method |
   | Blueprint XML property injection | `@Value("${...}")` from `application.yml` |
   | Blueprint XML bean wiring | `@Configuration` + `@Bean` |
   | Camel route orchestration | `@WebService` method with sequential calls |
   | CXF endpoint XML | `@Configuration` class with `EndpointImpl` |
   | OSGi service references | `@Autowired` Spring beans |
   | Exchange headers/properties | Method parameters / return values |
   | `javax.xml.ws.*` | `jakarta.xml.ws.*` |
   | `javax.xml.bind.*` | `jakarta.xml.bind.*` |
   | Log4j 1.x | SLF4J with `@Slf4j` or `LoggerFactory` |

4. **Preserve ALL business rules** (BR-001 through BR-NNN) exactly as specified in the RE documents. Each validation, mapping, and branching rule must produce identical behavior.

5. **Preserve ALL error codes** with identical error messages, fault structures, and HTTP fault codes.

6. **Fix ALL bugs identified in the Gap Analysis** (GAP-BUG-NNN). Document each fix with a comment in the code.

7. **Externalize ALL configuration** — no hardcoded URLs, credentials, or timeouts. Use environment variables:
   ```yaml
   service:
     outbound:
       url: ${OUTBOUND_SERVICE_URL:http://localhost:8080/default}
       account-id: ${OUTBOUND_ACCOUNT_ID:}
       account-password: ${OUTBOUND_ACCOUNT_PASSWORD:}
       timeout: ${OUTBOUND_TIMEOUT:30000}
   ```

8. **Add resilience patterns** on outbound service calls:
   - `@Retry` with configurable max attempts and wait duration
   - `@CircuitBreaker` with configurable failure rate threshold

9. **Preserve the SOAP endpoint path** exactly as legacy (e.g., `/wmb/api/{{service_path}}`).

10. **Use parameterized logging** — `log.info("{} {} {}", a, b, c)` not string concatenation.

---

### PHASE 3: FIELD-TO-FIELD MAPPING VERIFICATION

After creating all source files:

1. Create a SQL audit table `mapping_audit` with columns: `id, re_doc_field, legacy_field, spring_field, status (match/mismatch/schema_only/extra), notes`

2. For EVERY field in the RE Field-to-Field Mapping document:
   - Verify it exists in the legacy code
   - Verify it exists in the Spring Boot code
   - Confirm the mapping logic is identical
   - Mark status as `match`, `mismatch`, or `schema_only` (in schema but not mapped in legacy)

3. Report the mapping accuracy: `X/Y fields = Z%`

---

### PHASE 4: TEST SUITE CREATION (BDD + TDD)

Create comprehensive tests covering ALL migrated business logic:

#### TDD Test Categories
| Category | What to Test |
|----------|-------------|
| Request Validation | Every BR rule — null checks, empty checks, format checks, boundary conditions |
| Request Mapping | Field-by-field mapping, AQS/non-AQS branching, empty address handling |
| Response Mapping | All response fields, nested objects, collections, KVP mapping |
| Response Validation | Status code checks, error passthrough |
| Client Service | Successful call, timeout, null response, exception handling |
| Error Handler | Every error code produces correct SOAP fault |
| Service Orchestrator | End-to-end happy path, each failure scenario |

#### BDD Scenario Categories
| Category | Scenarios |
|----------|----------|
| Happy Path | Valid request → successful geocoded response |
| Validation Failures | Each invalid input → specific error code |
| Backend Failures | Outbound service timeout, error response, null response |
| Data Filtering | Any exclusion logic, empty record skip, etc. |
| Error Propagation | Each error code surfaces correctly in SOAP fault |

#### Test Requirements
- Use **JUnit 5** + **Mockito** for all unit tests
- Mock external dependencies (outbound service client)
- Create SQL tracking tables: `tdd_audit` and `bdd_audit`
- Track each test case with status: `covered`, `not_covered`, `not_applicable`
- Target: **100% of applicable test cases covered**

---

### PHASE 5: MIGRATION EVIDENCE REPORT

Generate a comprehensive **MIGRATION_COMPARISON_REPORT.md** in the output path that includes:

1. **Executive Summary** — overall migration verdict
2. **Overall Migration Score** — weighted breakdown by category
3. **Component-by-Component Comparison** — for EVERY class:
   - Legacy class → Spring Boot class mapping
   - Line-by-line behavior comparison
   - Business rule preservation confirmation
   - Verdict per component
4. **Field-to-Field Mapping Audit** — full table of all mapped fields
5. **Error Handling Parity** — all error codes compared
6. **Configuration Migration** — properties, endpoints, timeouts
7. **Bug Fixes Validated** — each GAP-BUG with before/after
8. **Intentional Exclusions** — what's deferred to Phase 2 and why
9. **Test Coverage Assessment** — TDD and BDD scores with test inventory
10. **Detailed Percentage Breakdown** — composite scoring:

| Dimension | Weight | Score |
|-----------|--------|-------|
| Field-to-Field Mapping | 30% | X% |
| Business Logic Parity | 25% | X% |
| WSDL/XSD Contract Preservation | 15% | X% |
| TDD Coverage (applicable) | 15% | X% |
| Error Handling Completeness | 10% | X% |
| BDD Coverage (applicable) | 5% | X% |
| **Composite** | **100%** | **X%** |

11. **Final Verdict** — overall migration accuracy percentage

---

### PHASE 6: ITERATE TO 100%

After generating the report:
1. Identify any gaps where score < 100%
2. Implement missing tests, fix any mapping mismatches
3. Re-score and update the report
4. Repeat until **all applicable dimensions are at 100%**

---

### QUALITY GATES (Must pass before declaring complete)

- [ ] All WSDL/XSD files copied verbatim (byte-identical)
- [ ] All business rules (BR-NNN) implemented with identical behavior
- [ ] All error codes produce identical SOAP faults
- [ ] All field mappings verified against RE document
- [ ] All identified bugs (GAP-BUG-NNN) fixed
- [ ] SOAP endpoint path preserved exactly
- [ ] `pom.xml` compiles with `mvn clean compile`
- [ ] All tests pass with `mvn test`
- [ ] Migration Evidence Report generated with composite score
- [ ] TDD applicable coverage = 100%
- [ ] BDD applicable coverage = 100%

---

### IMPORTANT NOTES

- **Do NOT ask for confirmation between phases** — execute all 6 phases end-to-end.
- **Do NOT skip the analysis phase** — read every file before writing any code.
- **Fix bugs during migration** — don't replicate known bugs from legacy.
- **Track everything in SQL** — todos, mapping audits, test audits.
- **The RE documents are the specification** — when legacy code conflicts with RE docs, follow the RE docs.
- **Phase 2 exclusions** (typically WS-Security/LDAP, Oracle DB logging, Jasypt encryption) should be noted but not implemented — replaced with modern alternatives (Spring Security placeholder, SLF4J, environment variables).

---

## PLACEHOLDERS TO REPLACE

| Placeholder | Description | Example |
|-------------|-------------|---------|
| `{{LEGACY_SOURCE_PATH}}` | Full path to legacy JBoss Fuse source code | `C:\Users\...\esb-api-geocoding` |
| `{{RE_DOCUMENTS_PATH}}` | Full path to reverse engineering documents | `C:\Users\...\RE{GeoCodingSrvice}` |
| `{{OUTPUT_PATH}}` | Full path for the new Spring Boot project | `C:\Users\...\ForwardEngineering` |
| `{{SERVICE_NAME}}` | Maven artifact / folder name (kebab-case) | `geocoding-service` |
| `{{SERVICE_PACKAGE}}` | Java package name segment | `geocoding` |
| `{{ServiceName}}` | PascalCase service name for class names | `Geocoding` |
| `{{service_path}}` | SOAP endpoint URL path | `geocoding` |

---

## EXAMPLE (filled in for a hypothetical "Policy Service")

```
Legacy source code location: C:\Users\Tanmay.Saxena\Desktop\Services\Policy Service\esb-api-policy
Reverse engineering documents location: C:\Users\Tanmay.Saxena\Desktop\Services\Policy Service\RE{PolicyService}
Output location: C:\Users\Tanmay.Saxena\Desktop\ForwardEngineering

SERVICE_NAME = policy-service
SERVICE_PACKAGE = policy
ServiceName = Policy
service_path = policy
```
