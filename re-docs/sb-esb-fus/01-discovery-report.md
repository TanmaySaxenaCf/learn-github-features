# Discovery Report

---

| **Field**            | **Details**                                    |
|----------------------|------------------------------------------------|
| **Project Name**     | sb-esb-fus                                     |
| **Application Name** | OPTA FUS REST / SOAP Service (cl-esb-fus)      |
| **Version**          | 3.25.09.01.2-SNAPSHOT                          |
| **Date**             | 27-Jun-2025                                    |
| **Prepared By**      | Copilot RE Pipeline                            |
| **Reviewed By**      | Pending                                        |
| **Status**           | Draft                                          |

---

## 1. Executive Summary

> **Purpose:** Reverse-engineer the cl-esb-fus OSGi service to produce comprehensive documentation enabling forward engineering to a modern Spring Boot 3.x architecture.
>
> **Scope:** All Java source files, OSGi Blueprint XML configuration, Camel routes, CXF endpoint definitions, JAXB-generated model classes, logging infrastructure, and security configuration within the `src/` directory. The co-located Task Manager Spring Boot sample app (`com.example.taskmanager`) is excluded from the primary analysis.
>
> **Key Findings:**
> - The service is built on **JBoss Fuse 6.3** (EOL), **Apache Camel 2.17** (EOL), and **Apache CXF 3.0.2** (EOL) — all components require migration.
> - 383 out of 431 Java files are **JAXB-generated** classes (`ca.optaintel` package) — most are unused dead code.
> - The REST endpoint (`OssFusSvc`) contains **incomplete method stubs** — dead code.
> - **Hardcoded defaults** for brokerage ("ABC Brokerage"), carrier ("Aviva"), and timeouts (30000ms) are injected via external properties but have fallback defaults.
> - Tests are **explicitly skipped** in the Maven build (`<skipTests>true</skipTests>`), indicating zero automated test coverage.
> - Security relies on **JAAS/LDAP** for REST, **WS-Security UsernameToken** for SOAP, and **Jasypt** for config encryption — all require modernization.
> - Transaction logging writes to an **Oracle DB** (`cl_fus_trans_log`) asynchronously via `TransactionLogger`.

---

## 2. Application Overview

### 2.1 Application Description

The cl-esb-fus application is an enterprise integration service that exposes the **OPTA Single Service** (Dwelling Fire Protection scoring) from OptaIntel as both SOAP and REST endpoints. It acts as a mediation layer within the Aviva Canada Catalyst ESB platform, handling authentication, authorization, request transformation, external service invocation, response mapping, and audit logging.

| **Attribute**           | **Details**                                                                 |
|-------------------------|-----------------------------------------------------------------------------|
| Application Type        | API (SOAP + REST mediation service)                                         |
| Primary Language        | Java 8                                                                      |
| Framework(s)            | JBoss Fuse 6.3, Apache Camel 2.17, Apache CXF 3.0.2, OSGi Blueprint       |
| Database(s)             | Oracle (transaction logging only — `cl_fus_trans_log` table)               |
| Deployment Platform     | On-Prem — Apache Karaf / JBoss Fuse (OSGi container)                       |
| Authentication Method   | JAAS/LDAP (REST), WS-Security UsernameToken (SOAP)                         |

### 2.2 Technology Stack

| **Layer**         | **Technology**                  | **Version**                | **Support Status** | **Migration Risk** | **Notes**                                      |
|-------------------|---------------------------------|----------------------------|--------------------|---------------------|-------------------------------------------------|
| Runtime           | Java                            | 1.8                        | ⚠️ Nearing EOL     | 🟡 Medium           | Migrate to Java 21                              |
| ESB Container     | JBoss Fuse                      | 6.3.0.redhat-187           | 🔴 EOL             | 🔴 High             | Replace with Spring Boot 3.x                    |
| Routing           | Apache Camel                    | 2.17.0.redhat-630187       | 🔴 EOL             | 🔴 High             | Upgrade to Camel 4.x or replace with Spring MVC |
| Web Services      | Apache CXF                      | 3.0.2                      | 🔴 EOL             | 🔴 High             | Replace with Spring Web/WebFlux                 |
| Serialization     | Jackson                         | 2.4.3                      | 🔴 EOL             | 🟡 Medium           | Upgrade to Jackson 2.17+                        |
| JAXB              | JAXB (Java EE)                  | 2.x                        | 🔴 EOL             | 🟡 Medium           | Migrate to Jakarta XML Binding                  |
| Caching           | Apache Camel Cache (Ehcache)    | 2.17                       | 🔴 EOL             | 🟡 Medium           | Replace with Spring Cache/Caffeine              |
| Encryption        | Jasypt                          | (Camel-managed)            | ⚠️ Nearing EOL     | 🟡 Medium           | Consider Spring Vault or Jasypt 3.x             |
| Logging           | SLF4J + Log4j 1.x              | 1.x                        | 🔴 EOL             | 🟢 Low              | Migrate to Logback or Log4j2                    |
| Database Driver   | Oracle OJDBC6                   | 1.0 (custom wrapped)       | 🔴 EOL             | 🟡 Medium           | Upgrade to ojdbc11                              |
| Build             | Maven                           | 3.x                        | ✅ Supported        | 🟢 Low              | —                                               |
| Packaging         | OSGi Bundle (maven-bundle-plugin)| 2.3.7                     | 🔴 EOL             | 🔴 High             | Replace with Spring Boot fat JAR                |
| API Docs          | Swagger (JAXRS)                 | 1.5.16                     | 🔴 EOL             | 🟡 Medium           | Migrate to SpringDoc/OpenAPI 3.x                |
| Vault             | vault-adapter                   | 1.0.7-SNAPSHOT             | ⚠️ Internal        | 🟡 Medium           | Evaluate Spring Vault integration               |

### 2.3 Architecture Pattern

The application follows a **Service-Oriented Architecture (SOA)** pattern implemented as an **OSGi bundle** deployed in a JBoss Fuse ESB container. Internally, it uses the **Pipes and Filters** pattern via Apache Camel routes:

1. **Inbound Adapters** — CXF SOAP/REST endpoints receive requests
2. **Processing Pipeline** — Camel processors handle authentication → validation → token acquisition → request building → external call → response mapping
3. **Outbound Adapter** — CXF client invokes external OPTA Single Service SOAP API
4. **Cross-Cutting** — Transaction logging (async to Oracle DB), error handling, CXF interceptor logging

---

## 3. Codebase Analysis

### 3.1 Repository Structure

```
project-root/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/aviva/ca/esb/
│   │   │   │   ├── cl/opta/fus/
│   │   │   │   │   ├── json/cache/         # DataCache, DataCacheLoader
│   │   │   │   │   ├── json/model/         # Error & auth lookup models
│   │   │   │   │   ├── logging/            # TransactionLogger, FusTransactionLog
│   │   │   │   │   ├── model/              # Request/response DTOs, exceptions
│   │   │   │   │   ├── processor/          # 12 Camel processors (business logic)
│   │   │   │   │   └── service/            # CXF service interfaces/classes
│   │   │   │   └── common/cxf/logger/      # CXF logging interceptors
│   │   │   ├── ca/optaintel/               # 383 JAXB-generated classes (OSS schema)
│   │   │   └── com/example/taskmanager/    # Sample Spring Boot app (out of scope)
│   │   └── resources/
│   │       ├── OSGI-INF/blueprint/
│   │       │   ├── blueprint.xml           # Main OSGi Blueprint (339 lines)
│   │       │   └── fus-log.xml             # Transaction logging config
│   │       ├── wsdl/                       # OSS.wsdl + 18 XSD schemas
│   │       ├── application.properties      # Spring Boot config (Task Manager)
│   │       ├── fus_logging_queries.properties  # SQL insert statement
│   │       ├── features.xml                # Karaf feature descriptor
│   │       └── log4j.properties            # Logging configuration
│   └── test/                               # Empty — no tests
├── pom.xml                                 # Maven POM (OSGi bundle packaging)
├── fus.wadl                                # WADL service description
└── README.md
```

### 3.2 Code Metrics

| **Metric**                       | **Value**     |
|----------------------------------|---------------|
| Total Lines of Code (LOC)        | ~27,000       |
| Non-JAXB LOC                     | ~2,414        |
| Number of Source Files            | 431           |
| Non-JAXB Source Files             | 48            |
| JAXB Generated Files             | 383           |
| Number of Modules/Packages       | 7 custom + 1 generated |
| Number of Custom Classes          | 48            |
| Number of Test Files              | 0             |
| Test Coverage                     | 0%            |
| Cyclomatic Complexity (Avg)       | Low-Medium    |

### 3.3 Dependency Analysis

| **Dependency**                    | **Version**                 | **Purpose**                                | **Risk Level** |
|-----------------------------------|-----------------------------|--------------------------------------------|----------------|
| camel-core                        | 2.17.0.redhat-630187        | Routing engine                             | High           |
| camel-blueprint                   | 2.17.0.redhat-630187        | OSGi Blueprint integration                 | High           |
| camel-cxf                         | 2.17.0.redhat-630187        | CXF-Camel bridge                           | High           |
| camel-cache                       | 2.17.0.redhat-630187        | Ehcache-based caching                      | High           |
| camel-jasypt                      | 2.17.0.redhat-630187        | Property encryption                        | Medium         |
| camel-sql                         | 2.17.0.redhat-630187        | SQL component for logging                  | Medium         |
| cxf-rt-frontend-jaxrs             | (managed by Fuse BOM)       | JAX-RS REST support                        | High           |
| cxf-api                           | 2.7.18.redhat-1             | CXF core API                              | High           |
| jackson-module-jsonSchema         | 2.4.3                       | JSON schema support                        | Medium         |
| jackson-module-scala_2.10         | 2.4.3                       | Scala Jackson module                       | Medium         |
| swagger-jaxrs                     | 1.5.16                      | Swagger API documentation                  | Medium         |
| json-simple                       | 1.1                         | JSON parsing (cache loading)               | Low            |
| ehcache-jmsreplication            | 0.5                         | Ehcache JMS replication                    | Medium         |
| vault-adapter                     | 1.0.7-SNAPSHOT              | Aviva Vault integration for secrets        | Medium         |
| ojdbc6                            | 1.0 (wrapped)               | Oracle JDBC driver                         | High           |
| sqljdbc41                         | 1.0 (wrapped)               | SQL Server JDBC driver                     | Medium         |
| slf4j-api + slf4j-log4j12         | (managed)                   | Logging facade                             | Low            |
| log4j                             | (managed)                   | Logging implementation                     | Medium         |
| javassist                         | 3.18.1-GA                   | Bytecode manipulation (Swagger)            | Low            |

### 3.4 Dead Code & Hardcoded Values Summary

#### 3.4.1 Dead Code Inventory

| **#** | **File/Class**                        | **Method/Block**              | **Lines**   | **Evidence**                                                                   | **Recommendation**                          |
|-------|---------------------------------------|-------------------------------|-------------|--------------------------------------------------------------------------------|---------------------------------------------|
| 1     | OssFusSvc.java                        | getFusScore()                 | Full class  | REST service class has method stubs only; actual REST flow uses Camel route with BeanParam deserialization — the method body is never invoked directly | Remove stubs or implement properly           |
| 2     | ca/optaintel/** (383 files)           | Multiple JAXB classes          | ~24,000     | Generated from 18 XSD schemas; only OSSRequestType, OSSResponseType, ResponseBodyType, and DwellingFireProtection-related types are used | Remove unused JAXB classes; regenerate only needed types |
| 3     | jackson-module-scala_2.10             | Entire dependency              | N/A         | Scala Jackson module declared as optional; no Scala code exists in project     | Remove dependency                            |
| 4     | sqljdbc41                             | Entire dependency              | N/A         | SQL Server driver bundled but no SQL Server connections configured              | Remove if not used in production             |

#### 3.4.2 Hardcoded Values Inventory

| **#** | **File/Class**                              | **Field/Variable**           | **Hardcoded Value**       | **Lines**  | **Expected Behavior**                              | **Recommendation**                               |
|-------|---------------------------------------------|------------------------------|---------------------------|------------|----------------------------------------------------|----------------------------------------------------|
| 1     | blueprint.xml (FusAuthRequestProcessor)     | broker                       | `${FUS_DEFAULT_BROKERAGE}` (defaults to "ABC Brokerage") | L90   | Should be dynamic per request or configurable       | Externalize; verify default is appropriate         |
| 2     | blueprint.xml (FusAuthRequestProcessor)     | carrier                      | `${FUS_DEFAULT_CARRIER}` (defaults to "Aviva")           | L91   | Should be dynamic per carrier                       | Externalize; verify default is appropriate         |
| 3     | blueprint.xml (conduit)                     | ConnectionTimeout            | `${FUS_CONNECTION_TIMEOUT}` (default 30000ms)            | L163  | Should be configurable per environment              | Already externalized — verify values               |
| 4     | blueprint.xml (conduit)                     | ReceiveTimeout               | `${FUS_RECEIVE_TIMEOUT}` (default 30000ms)               | L163  | Should be configurable per environment              | Already externalized — verify values               |
| 5     | blueprint.xml (conduit)                     | disableCNCheck               | `true`                    | L164       | CN check should be enabled in production            | 🔴 Security risk — enable CN check                 |
| 6     | blueprint.xml (WSS4J)                       | ws-security.validate.token   | `false`                   | L56        | Token should be validated                           | 🔴 Security risk — enable token validation          |
| 7     | pom.xml                                     | skipTests                    | `true`                    | L26, L369  | Tests should run in CI/CD                           | Enable tests after creating test suite              |

---

## 4. Integration Points

### 4.1 External Integrations

| **#** | **System/Service**              | **Protocol** | **Direction** | **Auth Mechanism**                 | **Timeout / Retry Config**       | **Fallback Behavior**                   | **Description**                                                    |
|-------|---------------------------------|--------------|---------------|------------------------------------|----------------------------------|-----------------------------------------|--------------------------------------------------------------------|
| 1     | OPTA Single Service (OptaIntel) | SOAP         | Outbound      | OAuth2 Bearer Token (header)       | 30s connection / 30s receive     | None — exception propagated to caller   | Primary external service for Dwelling Fire Protection scoring      |
| 2     | OPTA Auth Endpoint              | REST         | Outbound      | OAuth2 Client Credentials          | 30s connection / 30s receive     | None — exception propagated to caller   | OAuth2 token endpoint for OPTA service authentication              |
| 3     | Oracle Database                 | JDBC         | Outbound      | Username/Password (datasource)     | Default connection pool timeouts | Logging failure — silently handled      | Async transaction audit logging to `cl_fus_trans_log` table        |
| 4     | LDAP Server                     | LDAP/JAAS    | Outbound      | JAAS context (${LDAP_LOGIN})       | Default JAAS timeouts            | 401 Unauthorized returned               | Authentication for REST and SOAP endpoints                         |
| 5     | HashiCorp Vault                 | REST/API     | Outbound      | Vault token                        | Default                          | Startup failure                         | Retrieves encryption algorithm and master key via vault-adapter    |

### 4.2 Internal Integrations

| **#** | **Module/Service**              | **Communication**            | **Description**                                                      |
|-------|---------------------------------|------------------------------|----------------------------------------------------------------------|
| 1     | DataCache (Singleton)           | In-memory Java reference     | Stores error message lookups and authorization ACL data              |
| 2     | CXF Logger Interceptors         | CXF interceptor chain        | Logs inbound/outbound SOAP messages with password masking           |
| 3     | Camel WireTap                   | Async Camel message           | Sends transaction data to fusLogger route for async DB persistence  |

### 4.3 API Documentation (Swagger / OpenAPI)

#### 4.3.1 Swagger Specification Overview

| **Attribute**                | **Details**                                                    |
|------------------------------|----------------------------------------------------------------|
| Swagger/OpenAPI Version      | Swagger 2.0 (via swagger-jaxrs 1.5.16)                        |
| Specification File Location  | Auto-generated from JAX-RS annotations at runtime              |
| Specification Format         | JSON (auto-generated)                                          |
| API Title                    | OPTA Fus Rest                                                  |
| API Version                  | 3.25.09.01.2-SNAPSHOT                                          |
| Base Path / Server URL       | /pl/api/oss/rest/product                                       |
| Auto-Generated               | Yes — Swagger JAXRS annotations on OssFusSvc                   |
| Last Updated                 | Unknown                                                        |
| Spec Completeness            | Partial — annotations exist but service has method stubs only   |

#### 4.3.2 API Endpoints Inventory

| **#** | **HTTP Method** | **Endpoint Path**                  | **Operation ID**  | **Summary/Description**                           | **Request Body** | **Response Codes**   | **Auth Required** |
|-------|-----------------|------------------------------------|--------------------|---------------------------------------------------|------------------|----------------------|-------------------|
| 1     | GET             | /pl/api/oss/rest/product           | getFusScore        | Dwelling Fire Protection scoring (REST)           | No (query params)| 200, 400, 401, 500   | Yes (JAAS/LDAP)   |
| 2     | POST (SOAP)     | /pl/api/oss/fus                    | getFusScore        | Dwelling Fire Protection scoring (SOAP)           | Yes (SOAP body)  | 200, SOAP Fault      | Yes (WS-Security) |
| 3     | POST (SOAP)     | /pl/api/oss/product/fus            | getFusScore        | Full OSS response (SOAP)                          | Yes (SOAP body)  | 200, SOAP Fault      | Yes (WS-Security) |

#### 4.3.3 API Models / Schemas

| **Schema Name**                   | **Type**  | **Properties Count** | **Used In Endpoints**           | **Notes**                         |
|-----------------------------------|-----------|----------------------|---------------------------------|-----------------------------------|
| FusRequest                        | Object    | 3                    | SOAP /pl/api/oss/fus            | Wraps BaseRequest + DwellingFireProtectionRequest |
| FusProductRequest                 | Object    | 7                    | REST + SOAP full response       | @QueryParam annotated for REST    |
| DwellingFireProtectionRequest     | Object    | 7                    | Nested in FusRequest            | Core address fields               |
| FUSResponse                       | Object    | 2                    | SOAP /pl/api/oss/fus            | Wraps DwellingFireProtectionResponse |
| FusProductResponse                | Object    | 2                    | REST + SOAP full response       | Contains full ResponseBodyType    |
| DwellingFireProtectionResponse    | Object    | 3                    | Nested in FUSResponse           | Mapped fire protection types      |
| FaultElement                      | Object    | 1                    | SOAP faults                     | Contains ErrorDetails             |
| ErrorDetails                      | Object    | 2                    | REST errors + SOAP faults       | code + message                    |

#### 4.3.4 API Security Definitions

| **Security Scheme**       | **Type**                         | **Details**                                                 |
|---------------------------|----------------------------------|-------------------------------------------------------------|
| JAAS/LDAP (REST)          | HTTP Basic                       | JAASAuthenticationFilter with LDAP context                  |
| WS-Security (SOAP)        | UsernameToken                   | WSS4JInInterceptor with PasswordText; token validation disabled |
| Role Authorization         | Role-based                      | SimpleAuthorizingInterceptor; requires `eEsbPlApiOptaAccess` role |

#### 4.3.5 API Tags / Groupings

| **Tag Name**     | **Description**                             | **Endpoints Count** |
|------------------|---------------------------------------------|---------------------|
| FUS              | Dwelling Fire Protection scoring service    | 3                   |

#### 4.3.6 Swagger/OpenAPI Gaps & Observations

| **#** | **Observation**                                                        | **Severity** | **Recommendation**                          |
|-------|------------------------------------------------------------------------|--------------|---------------------------------------------|
| 1     | REST endpoint has incomplete implementation (method stubs only)        | High         | Implement or remove; clarify with business   |
| 2     | Swagger annotations exist but service body is empty                    | High         | Auto-generate from working Camel routes      |
| 3     | No OpenAPI 3.x specification — uses Swagger 2.0 (EOL)                 | Medium       | Migrate to SpringDoc OpenAPI 3.x             |
| 4     | SOAP endpoints have no Swagger equivalent documentation                | Medium       | Generate OpenAPI specs for all endpoints      |

---

## 5. Data Landscape

### 5.1 Data Stores

| **Data Store**        | **Type**  | **Size**   | **Tables/Collections** | **Notes**                                              |
|-----------------------|-----------|------------|------------------------|--------------------------------------------------------|
| Oracle DB (logging)   | RDBMS     | Unknown    | 1 (cl_fus_trans_log)   | Audit logging only; 17 columns; async insert via JdbcTemplate |
| DataCache (in-memory) | HashMap   | Small      | 2 maps                 | Error messages + authorization lookups loaded from JSON files |

### 5.2 Data Flows Summary

1. **Inbound** — SOAP/REST request with address data (streetName, postalCode, municipality, province) + optional IBC/NAICS/SIC codes
2. **Auth Token** — OAuth2 client credentials flow to OPTA auth endpoint → Bearer token
3. **Outbound** — OPTA Single Service SOAP call with address + auth token → fire protection scoring response
4. **Response** — Map OSS ResponseBodyType → DwellingFireProtectionResponse (firehall, hydrant, unprotected grades) or pass through full response
5. **Logging** — Async write of transaction record (request/response payloads, client info, status) to Oracle DB

See Document 06 (Data Flow Diagram) for detailed DFD Level 0-2.

---

## 6. Security Assessment

| **Area**                  | **Current State**                                                               | **Risk**  |
|---------------------------|---------------------------------------------------------------------------------|-----------|
| Authentication            | JAAS/LDAP for REST; WS-Security UsernameToken for SOAP                          | Medium    |
| Authorization             | Role-based (`eEsbPlApiOptaAccess`) + province-based ACL from JSON config        | Medium    |
| Data Encryption (At Rest) | Jasypt encryption for sensitive properties (client_secret, passwords) via Vault | Low       |
| Data Encryption (Transit) | TLS/SSL with JKS truststore; **CN check disabled** (`disableCNCheck="true"`)    | 🔴 High   |
| Input Validation          | Basic null/empty checks on 4 fields; no format validation (postal code, province code) | Medium |
| Known Vulnerabilities     | Log4j 1.x (CVE-2021-44228 risk if log4j-core used), Jackson 2.4.3 (multiple CVEs), CXF 3.0.2 (multiple CVEs) | 🔴 High |
| Token Validation          | WS-Security token validation **disabled** (`ws-security.validate.token=false`)  | 🔴 High   |
| Password Logging          | CXF LoggingInInterceptor masks WSSE passwords in logs                           | Low       |

---

## 7. Environment & Infrastructure

| **Environment** | **URL/Endpoint**                                               | **Purpose**     | **Notes**                                          |
|-----------------|----------------------------------------------------------------|-----------------|----------------------------------------------------|
| Development     | Configured via external app_config.properties                  | Dev/Testing     | Properties at /app/opdata/properties/catalyst/fus/  |
| Staging         | Configured via external app_config.properties                  | Pre-prod        | Same property file structure, different values      |
| Production      | Configured via external app_config.properties                  | Live            | Jasypt-encrypted sensitive values                   |
| Karaf Container | OSGi bundle deployed via Fabric8 profile `cl-esb-fus`          | Runtime         | Start level 90; requires Karaf features             |

---

## 8. Key Risks & Challenges

| **#** | **Risk/Challenge**                                              | **Impact** | **Mitigation**                                         |
|-------|-----------------------------------------------------------------|------------|--------------------------------------------------------|
| 1     | All core frameworks (Fuse 6.3, Camel 2.17, CXF 3.0.2) are EOL | High       | Full re-platform to Spring Boot 3.x                    |
| 2     | Zero test coverage — tests explicitly skipped                   | High       | Generate comprehensive test suite before migration     |
| 3     | TLS CN check disabled in production                             | High       | Enable CN check; verify certificates                   |
| 4     | WS-Security token validation disabled                           | High       | Enable token validation or migrate to modern auth      |
| 5     | 383 JAXB classes — massive dead code surface area               | Medium     | Regenerate only used types; remove unused              |
| 6     | Log4j 1.x with known CVEs                                      | High       | Migrate to Logback or Log4j2                           |
| 7     | Jackson 2.4.3 with known CVEs                                  | High       | Upgrade to Jackson 2.17+                               |
| 8     | External properties file dependency (/app/opdata/...)           | Medium     | Use Spring Boot config with profiles and env variables |
| 9     | Oracle DB dependency for audit logging                          | Medium     | Consider alternative logging (ELK, CloudWatch)         |
| 10    | Vault-adapter internal dependency (SNAPSHOT)                    | Medium     | Evaluate Spring Vault or externalize secret management |

---

## 9. Recommendations

| **#** | **Recommendation**                                                      | **Priority** | **Rationale**                                                     |
|-------|-------------------------------------------------------------------------|--------------|-------------------------------------------------------------------|
| 1     | Migrate to Spring Boot 3.2+ with Java 21                               | High         | All current frameworks are EOL; Spring Boot provides modern equivalent for every component |
| 2     | Replace Camel routes with Spring MVC controllers + service layer        | High         | Simplify architecture; Camel adds unnecessary complexity for a mediation service |
| 3     | Enable TLS CN check and WS-Security token validation                   | High         | Critical security gaps must be closed                             |
| 4     | Generate comprehensive test suite (unit + integration + contract)       | High         | Zero coverage is a critical migration risk                        |
| 5     | Remove unused JAXB classes; regenerate only required types              | Medium       | Reduce codebase by ~90%; improve maintainability                  |
| 6     | Externalize all hardcoded values to Spring Boot application.yml         | Medium       | Enable environment-specific configuration                        |
| 7     | Replace Log4j 1.x with Logback (Spring Boot default)                   | Medium       | Address known CVEs and modernize logging                          |
| 8     | Upgrade Jackson to 2.17+ (Spring Boot managed)                         | Medium       | Address known CVEs                                                |
| 9     | Replace JAAS/LDAP auth with Spring Security + OAuth2                   | Medium       | Modern, standard authentication mechanism                        |
| 10    | Consider OpenAPI 3.x specification for all endpoints                   | Low          | Improve API documentation and client generation                   |

---

## 10. Migration Readiness Assessment

### 10.1 Readiness Scorecard

| **Dimension**                  | **Score (1-5)** | **Assessment**                                                           |
|--------------------------------|-----------------|--------------------------------------------------------------------------|
| Technology Currency            | 1               | All core components (Fuse, Camel, CXF, Java 8) are EOL                   |
| Code Quality & Maintainability | 3               | Clean processor architecture; moderate complexity; significant dead code  |
| Test Coverage                  | 1               | Zero tests; explicitly disabled in build                                 |
| Dependency Health              | 1               | Multiple dependencies with known CVEs; EOL frameworks                    |
| Integration Complexity         | 3               | Clear external integration points; OAuth2 token flow well-structured     |
| Data Migration Complexity      | 4               | Minimal data — logging table only; no complex schema migration needed    |
| Documentation Completeness     | 2               | WADL exists; inline comments sparse; no architecture docs                |
| Business Logic Clarity         | 3               | Business rules extractable from processors; some hardcoded defaults      |
| **Overall Readiness Score**    | **2.3**         | **High risk — major re-platform effort required; all frameworks EOL**    |

> **Scoring Guide:** 1 = Critical risk, not ready | 2 = High risk, major work needed | 3 = Moderate, manageable with effort | 4 = Good, minor adjustments needed | 5 = Excellent, ready for migration

### 10.2 Migration Approach Recommendation

| **Approach**               | **Suitability** | **Rationale**                                                               |
|----------------------------|-----------------|-----------------------------------------------------------------------------|
| Lift & Shift               | ❌               | OSGi container dependency makes lift-and-shift impossible                   |
| Re-platform                | ⚠️               | Feasible if only replacing container; but Camel/CXF also need replacement   |
| Re-architect / Re-write    | ✅               | Best fit — business logic is clear and extractable; all frameworks need replacement |
| Hybrid                     | ⚠️               | Could keep Camel 4.x for routing if desired, but adds unnecessary complexity |

### 10.3 Critical Blockers for Migration

| **#** | **Blocker Description**                                                     | **Category** | **Severity** | **Resolution Required Before Migration** |
|-------|-----------------------------------------------------------------------------|--------------|--------------|------------------------------------------|
| 1     | JBoss Fuse 6.3 / OSGi container not available on target platform            | Technical    | Critical     | Yes                                      |
| 2     | WS-Security token validation disabled — security posture must be evaluated  | Security     | High         | Yes                                      |
| 3     | TLS CN check disabled — certificates must be verified                       | Security     | High         | Yes                                      |
| 4     | Zero test coverage — no regression safety net                               | Quality      | High         | Yes                                      |
| 5     | Hardcoded default values may mask business logic errors                     | Functional   | Medium       | Yes                                      |

---

## 11. API Gateway Integration Considerations

### 11.1 Current API Routing

| **Attribute**                | **Details**                                                                   |
|------------------------------|-------------------------------------------------------------------------------|
| Current Routing Mechanism    | Fuse/Camel route-based with CXF endpoint beans                               |
| Base URL Pattern             | /pl/api/oss/* (REST: /rest/product, SOAP: /fus, /product/fus)                |
| Endpoint Count               | 3 (1 REST + 2 SOAP)                                                         |
| Authentication at Entry      | JAAS filter (REST) and WSS4J interceptor (SOAP) at CXF endpoint level       |
| Rate Limiting                | None                                                                         |
| Request/Response Logging     | CXF interceptors (LoggingInInterceptor/LoggingOutInterceptor) + async DB log |

### 11.2 Target API Gateway Requirements

| **Requirement**              | **Details**                                             | **Status**  |
|------------------------------|---------------------------------------------------------|-------------|
| Gateway Platform             | TBD — AWS API Gateway, Kong, or Apigee                  | Pending     |
| Authentication Offloading    | Consider moving auth to gateway (OAuth2/OIDC)           | Pending     |
| Rate Limiting / Throttling   | Add rate limiting (not currently implemented)            | Pending     |
| Request Transformation       | May need SOAP-to-REST transformation at gateway         | Pending     |
| Response Transformation      | None expected — service handles transformation          | Pending     |
| Versioning Strategy          | URI-based (current: /pl/api/oss/...)                    | Pending     |
| CORS Policy                  | Not currently configured; needed for browser clients     | Pending     |

### 11.3 Open Questions for API Gateway Discussion

| **#** | **Question**                                                                        | **Directed To**    | **Status** | **Resolution** |
|-------|-------------------------------------------------------------------------------------|--------------------|------------|----------------|
| 1     | Will the API Gateway handle LDAP/JAAS authentication or will the service keep it?   | Architecture Team  | 🟡 Open    |                |
| 2     | Should SOAP endpoints be retired in favor of REST-only in the target architecture?  | Product Owner      | 🟡 Open    |                |
| 3     | What is the target URL pattern for migrated endpoints?                              | Architecture Team  | 🟡 Open    |                |
| 4     | Is the Oracle audit logging table migrating or being replaced with centralized logging? | Infrastructure  | 🟡 Open    |                |

---

## 12. Client Feedback & Additional Findings

### 12.1 Client-Raised Observations

| **#** | **Observation**             | **Raised By** | **Date Raised** | **Category** | **Impact** | **Action Required**        | **Status** |
|-------|------------------------------|---------------|-----------------|--------------|------------|----------------------------|------------|
|       | No client feedback received yet | —           | —               | —            | —          | Schedule review session    | Open       |

### 12.2 Validated vs. Unvalidated Findings

| **Finding from Discovery**                                    | **Client Validation Status** | **Client Comments** |
|---------------------------------------------------------------|------------------------------|---------------------|
| TLS CN check disabled in production                           | 🟡 Pending validation         |                     |
| WS-Security token validation disabled                         | 🟡 Pending validation         |                     |
| REST endpoint has incomplete method stubs                     | 🟡 Pending validation         |                     |
| 383 JAXB generated classes are mostly unused                  | 🟡 Pending validation         |                     |

---

## 13. Appendices

### Appendix A: Glossary

| **Term**     | **Definition**                                                                      |
|--------------|-------------------------------------------------------------------------------------|
| FUS          | Fire Underwriting Service — OPTA product for Dwelling Fire Protection scoring        |
| OSS          | OPTA Single Service — OptaIntel's unified web service API                            |
| OSGi         | Open Services Gateway initiative — modular Java framework                            |
| Blueprint    | OSGi dependency injection XML configuration format                                   |
| Camel Route  | Apache Camel integration pipeline defining message flow                               |
| CXF          | Apache CXF — web services framework for SOAP and REST                                 |
| Jasypt       | Java Simplified Encryption library for property encryption                            |
| JAAS         | Java Authentication and Authorization Service                                         |
| WSS4J        | Web Services Security for Java — WS-Security implementation                           |
| Karaf        | Apache Karaf — OSGi container and application server                                  |
| Fabric8      | JBoss Fuse management and deployment framework                                       |
| WADL         | Web Application Description Language — XML description of REST services               |

### Appendix B: References

| **#** | **Document/Resource**                   | **Location/Link**                                     |
|-------|-----------------------------------------|-------------------------------------------------------|
| 1     | POM Configuration                       | pom.xml                                               |
| 2     | OSGi Blueprint (Main)                   | src/main/resources/OSGI-INF/blueprint/blueprint.xml   |
| 3     | OSGi Blueprint (Logging)                | src/main/resources/OSGI-INF/blueprint/fus-log.xml     |
| 4     | WADL Service Description                | fus.wadl                                              |
| 5     | OSS WSDL                                | src/main/resources/wsdl/OSS.wsdl                      |
| 6     | Karaf Feature Descriptor                | src/main/resources/features.xml                       |
| 7     | Component Catalog                       | re-docs/sb-esb-fus/02-component-catalog.md            |
| 8     | Sequence Diagrams                       | re-docs/sb-esb-fus/03-sequence-diagrams.md            |

### Appendix C: Cross-Reference to Other RE Artifacts

| **Artifact**                    | **Document #** | **Relationship to Discovery Report**                     |
|---------------------------------|----------------|----------------------------------------------------------|
| Component Catalog               | Doc-02         | Detailed breakdown of components summarized in Section 3  |
| Sequence Diagrams               | Doc-03         | Runtime flows for integration points in Section 4         |
| Business Rules Catalog          | Doc-04         | Business logic for capabilities in Section 2              |
| Data Dictionary                 | Doc-05         | Detailed data definitions for Section 5                   |
| Data Flow Diagram               | Doc-06         | Visual representation of Section 5.2                      |
| BDD Feature Specs               | Doc-07         | Behavioral specs validating Sections 2-5                  |
| Test Case Inventory             | Doc-08         | Test coverage for all discovery findings                  |
| Gap Report                      | Doc-09         | Gaps derived from findings in Sections 3-8                |
| Field-to-Field Mapping          | Doc-10         | Field mapping for migration from Section 5                |

---

> **Document Control:**
> | Version | Date | Author | Changes |
> |---------|------|--------|---------|
> | 0.1 | 27-Jun-2025 | Copilot RE Pipeline | Initial draft |
> | 0.2 | 27-Jun-2025 | Copilot RE Pipeline | Added: Tech stack risk assessment (2.2), Dead code & hardcoded values inventory (3.4), Integration security details (4.1), Migration readiness assessment (10), API Gateway considerations (11), Client feedback section (12), Cross-reference appendix (C) |
> | 0.3 | 27-Jun-2025 | Copilot RE Pipeline | Added: Swagger/OpenAPI documentation section (4.3) for reverse-engineered API specifications |
