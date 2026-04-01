# Discovery Report

---

| **Field**            | **Details**                        |
|----------------------|------------------------------------|
| **Project Name**     | cl-esb-fus (RE_DigitalService)     |
| **Application Name** | OptaSingleService FUS ESB Gateway  |
| **Version**          | 3.25.09.01.2-SNAPSHOT              |
| **Date**             | 27-Jun-2025                        |
| **Prepared By**      | Copilot RE/FE Pipeline             |
| **Reviewed By**      | Pending Review                     |
| **Status**           | Draft                              |

---

## 1. Executive Summary

The cl-esb-fus application is an Apache Camel/CXF-based Enterprise Service Bus (ESB) gateway that exposes the OPTA Insurance OptaSingleService as both SOAP and REST endpoints. It provides dwelling fire protection (FUS) data used for insurance underwriting and rating. The service handles request validation, LDAP authentication, role-based authorization, province-based access control, OAuth 2.0 token management for upstream calls, response transformation, and Oracle-based transaction logging. The codebase also includes an unrelated TaskManager Spring Boot module used as a development reference.

> **Purpose:** To perform comprehensive reverse engineering of the cl-esb-fus service in preparation for forward engineering migration from JBoss Fuse / Apache Camel 2.x to a modern Spring Boot 3.x platform.
>
> **Scope:** All source code, configuration files, WSDL/XSD schemas, CI/CD pipelines, and deployment artifacts within the cl-esb-fus directory. The TaskManager Spring Boot module is documented but is out of scope for migration.
>
> **Key Findings:**
> - The core ESB framework (Apache Camel 2.17, CXF 3.0.2) and Java 1.8 runtime are at or nearing end-of-life, creating security and support risk.
> - Business logic is concentrated in ~45 Java files (~2,500 LOC), with ~383 auto-generated SOAP type classes comprising the majority of the codebase.
> - Test coverage is critically low (~5%), with tests only covering the TaskManager module and zero tests for the FUS service itself.
> - Multiple hardcoded values (including a typo "unprorected") and dead code paths exist and must be addressed during migration.
> - The service has 4 external integration points (OPTA SOAP, OAuth token endpoint, LDAP, Oracle DB) that require careful migration planning.
> - Province-based authorization and grade-mapping business rules are tightly coupled to processor classes and should be externalized.

---

## 2. Application Overview

### 2.1 Application Description

The cl-esb-fus application serves as an ESB mediation layer between internal consumers (insurance underwriting systems) and the external OPTA Insurance rating service. It receives requests for dwelling fire protection scores via SOAP or REST, authenticates and authorizes the caller, enriches the request with OAuth tokens, forwards it to the OPTA OptaSingleService SOAP endpoint, transforms the response, and logs the transaction to an Oracle database. End users are internal insurance applications and downstream services that need FUS (Fire Underwriters Survey) data for property risk assessment.

| **Attribute**           | **Details**                                                                 |
|-------------------------|-----------------------------------------------------------------------------|
| Application Type        | API / ESB Gateway (SOAP + REST)                                             |
| Primary Language        | Java 1.8                                                                    |
| Framework(s)            | Apache Camel 2.17.0.redhat-630187, Apache CXF 3.0.2, Spring (via Fuse BOM), OSGi Blueprint |
| Database(s)             | Oracle (production transaction logging), H2 in-memory (TaskManager module)  |
| Deployment Platform     | JBoss Fuse / Red Hat Fuse (OSGi / Karaf) — On-Premises                     |
| Authentication Method   | LDAP (JAAS), WS-Security (WSS4J UsernameToken), OAuth 2.0 (refresh_token)  |

### 2.2 Technology Stack

| **Layer**         | **Technology**        | **Version**                   | **Support Status**   | **Migration Risk**   | **Notes**                                                  |
|-------------------|-----------------------|-------------------------------|----------------------|----------------------|------------------------------------------------------------|
| Backend           | Java                  | 1.8                           | ⚠️ Nearing EOL      | 🔴 High              | Must upgrade to Java 17+ for Spring Boot 3.x               |
| ESB Framework     | Apache Camel          | 2.17.0.redhat-630187          | 🔴 EOL              | 🔴 High              | Major version jump required (2.x → 4.x or Spring Boot)     |
| Web Services      | Apache CXF            | 3.0.2                         | 🔴 EOL              | 🔴 High              | Replace with Spring Web/WebFlux or modern CXF               |
| Container         | JBoss Fuse / Karaf    | 6.3.0.redhat-187              | ⚠️ Nearing EOL      | 🔴 High              | Migrate from OSGi to Spring Boot embedded container         |
| Database          | Oracle                | —                             | ✅ Supported         | 🟢 Low               | Transaction logging; minimal schema                         |
| Database (Dev)    | H2                    | —                             | ✅ Supported         | 🟢 Low               | Used only by TaskManager demo module                        |
| Caching           | EHCache               | via Fuse BOM                  | ✅ Supported         | 🟡 Med               | Evaluate migration to Spring Cache abstraction              |
| Encryption        | Jasypt                | via Fuse BOM                  | ✅ Supported         | 🟡 Med               | Consider Spring Boot config encryption alternatives         |
| JSON              | Jackson               | 2.4.3 (via Fuse BOM)          | ✅ Supported         | 🟢 Low               | Upgrade to latest Jackson version with Spring Boot          |
| JSON Utility      | json-simple           | 1.1                           | 🔴 EOL              | 🟡 Med               | Replace with Jackson or Gson                                |
| Logging           | SLF4J + Log4j 1.x     | via Fuse BOM                  | 🔴 EOL              | 🟡 Med               | Migrate to Logback (Spring Boot default)                    |
| LDAP Client       | Spring LDAP           | via Fuse BOM                  | ✅ Supported         | 🟢 Low               | Spring LDAP works with Spring Boot                          |
| API Documentation | Swagger               | 1.5.16                        | ⚠️ Nearing EOL      | 🟡 Med               | Migrate to SpringDoc OpenAPI 3.x                            |
| Build             | Maven                 | 3.x                           | ✅ Supported         | 🟢 Low               | Retain Maven, update POM structure                          |
| CI/CD             | Jenkins               | —                             | ✅ Supported         | 🟢 Low               | Update Jenkinsfile for Spring Boot build                    |
| Vault             | vault-adapter          | 1.0.7-SNAPSHOT                | ✅ Supported         | 🟡 Med               | Internal Aviva library; verify Spring Boot compatibility    |
| MQ                | Fabric8 MQ            | 1.2.0.redhat-133              | 🔴 EOL              | 🟡 Med               | Evaluate if MQ is actively used; replace if needed          |

### 2.3 Architecture Pattern

The application follows a **Service-Oriented Architecture (SOA) / ESB Mediation** pattern built on Apache Camel routes with CXF endpoints:

1. **Inbound Layer** — CXF SOAP and JAX-RS REST endpoints receive client requests.
2. **Security Layer** — JAAS/LDAP authentication, WSS4J WS-Security validation, and province-based authorization.
3. **Processing Layer** — Camel processor beans validate, transform, and enrich requests.
4. **Integration Layer** — Outbound CXF SOAP call to OPTA OptaSingleService with OAuth 2.0 token management.
5. **Response Layer** — Response transformation (XML → JSON for REST), grade mapping, error handling.
6. **Logging Layer** — Oracle JDBC transaction logging for audit trail.

The architecture is configured via OSGi Blueprint XML rather than annotations, with Camel routes orchestrating the request/response flow through a pipeline of processor beans.

---

## 3. Codebase Analysis

### 3.1 Repository Structure

```
cl-esb-fus/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── ca/optaintel/ws/optasingleservice/    # Generated SOAP types (~383 files)
│   │   │   │   ├── _2/                                # SOAP v2 types
│   │   │   │   └── _2_0/                              # SOAP v2.0 service interface
│   │   │   └── com/
│   │   │       ├── aviva/ca/esb/
│   │   │       │   ├── cl/opta/fus/
│   │   │       │   │   ├── processor/                 # 12 Camel processor classes
│   │   │       │   │   ├── service/                   # 3 service endpoint classes
│   │   │       │   │   ├── model/                     # Request/response DTOs
│   │   │       │   │   ├── logging/                   # Transaction logging
│   │   │       │   │   └── json/                      # JSON utilities
│   │   │       │   │       ├── cache/                 # Data caching (EHCache)
│   │   │       │   │       └── model/                 # JSON model classes
│   │   │       │   └── common/cxf/logger/             # CXF logging interceptors (password masking)
│   │   │       └── example/taskmanager/               # Spring Boot demo (out of scope)
│   │   │           ├── controller/
│   │   │           ├── model/
│   │   │           ├── repository/
│   │   │           └── service/
│   │   └── resources/
│   │       ├── OSGI-INF/blueprint/
│   │       │   ├── blueprint.xml                      # Main Camel/CXF configuration
│   │       │   └── fus-log.xml                        # Oracle JDBC logging config
│   │       ├── wsdl/                                  # WSDL + 15 XSD schema files
│   │       ├── table-schema/
│   │       │   └── fusLogs.sql                        # Oracle DDL for logging table
│   │       ├── features.xml                           # OSGi Karaf features descriptor
│   │       ├── fus_logging_queries.properties          # SQL queries for transaction logging
│   │       ├── log4j.properties                       # Log4j configuration
│   │       └── application.properties                 # Spring Boot config (TaskManager)
│   └── test/
│       ├── java/
│       │   └── com/example/taskmanager/
│       │       └── TaskControllerTest.java            # 14 JUnit 5 tests (TaskManager only)
│       └── resources/
│           ├── OptaSingleServiceBinding MockService.xml  # SoapUI mock service
│           ├── app_config.properties                     # Test app configuration
│           ├── authorization_config.json                 # Province-based authorization rules
│           ├── error_messages.json                       # Error code to message mapping
│           ├── ldap_config.xml                           # LDAP connection configuration
│           └── st1-optaintel-soapui-project*.xml         # SoapUI test projects
├── ci-cd/
│   ├── Jenkinsfile                                    # CI/CD pipeline (Build → Test → Deploy)
│   └── fabric.cmd                                     # Fuse Fabric deployment script
├── pom.xml                                            # Maven build descriptor (OSGi bundle)
├── fus.wadl                                           # REST WADL definition (~1014 lines)
├── api_guide.md                                       # REST API usage guide
├── ReadMe.txt                                         # Local development setup instructions
└── .gitignore
```

### 3.2 Code Metrics

| **Metric**                    | **Value**       |
|-------------------------------|-----------------|
| Total Lines of Code (LOC)     | ~25,000+        |
| Business Logic LOC            | ~2,500          |
| Generated SOAP Types LOC      | ~22,500         |
| Number of Source Files         | 431             |
| Business Logic Files           | 45              |
| Generated SOAP Type Files      | 383             |
| Spring Boot Demo Files         | 3               |
| Number of Modules/Packages    | 8 custom + generated |
| Number of Classes              | ~431            |
| Number of Test Files           | 1 (TaskControllerTest.java) |
| Test Coverage                  | ~5% (TaskManager only; 0% for FUS service) |
| Cyclomatic Complexity (Avg)    | Low-Medium (processors contain conditional logic for grade mapping and error handling) |

### 3.3 Dependency Analysis

| **Dependency**                          | **Version**                  | **Purpose**                                      | **Risk Level** |
|-----------------------------------------|------------------------------|--------------------------------------------------|----------------|
| jboss-fuse-parent (BOM)                 | 6.3.0.redhat-187             | JBoss Fuse managed dependency versions           | High           |
| camel-core                              | 2.17.0 (managed)             | Camel routing engine                             | High           |
| camel-blueprint                         | 2.17.0 (managed)             | OSGi Blueprint XML configuration                 | High           |
| camel-cxf                               | 2.17.0.redhat-630187         | Camel-CXF SOAP/REST integration                  | High           |
| camel-cache                             | 2.17.0.redhat-630187         | EHCache-based caching via Camel                  | Med            |
| camel-jasypt                            | 2.17.0.redhat-630187         | Password encryption for config properties        | Med            |
| camel-sql                               | 2.17.0.redhat-630187         | SQL/JDBC integration for transaction logging     | Med            |
| cxf-rt-frontend-jaxrs                   | 3.0.2 (managed)              | CXF JAX-RS REST frontend                         | High           |
| cxf-api                                 | 2.7.18.redhat-1              | CXF API classes                                  | High           |
| swagger-jaxrs                           | 1.5.16                       | Swagger API documentation                        | Med            |
| jackson-module-jsonSchema               | 2.4.3                        | JSON Schema generation                           | Med            |
| jackson-module-scala_2.10               | 2.4.3                        | Scala module for Jackson (likely unused)          | Med            |
| json-simple                             | 1.1                          | Simple JSON parsing utility                      | Med            |
| ehcache-jmsreplication                  | 0.5                          | EHCache JMS replication                          | Med            |
| vault-adapter                           | 1.0.7-SNAPSHOT               | Aviva internal vault integration                 | Med            |
| mq-fabric                               | 1.2.0.redhat-133             | Fabric8 MQ messaging integration                 | Med            |
| slf4j-api + slf4j-log4j12              | (managed)                    | Logging facade and Log4j bridge                  | Low            |
| log4j                                   | (managed)                    | Logging implementation                           | Med            |
| spring-boot-starter-web                 | 3.2.0                        | Spring Boot (TaskManager module only)            | Low            |
| spring-boot-starter-data-jpa            | 3.2.0                        | Spring Data JPA (TaskManager module only)        | Low            |

### 3.4 Dead Code & Hardcoded Values Summary

#### 3.4.1 Dead Code Inventory

| **#** | **File/Class**                          | **Method/Block**                  | **Lines**    | **Evidence**                                                                          | **Recommendation**                  |
|-------|-----------------------------------------|-----------------------------------|--------------|---------------------------------------------------------------------------------------|-------------------------------------|
| 1     | `com.aviva.ca.esb.cl.opta.fus.service.OssFusSvc.java` | `getFusScore()` return statement | Full class   | REST service method returns `null` — never produces a valid response; unused stub      | Remove — REST endpoint handled by Camel route via CXF-RS bean |
| 2     | `FusAuthServiceResponseProcessor.java`  | Commented-out code block          | L37-L44      | Commented-out response processing logic; suggests abandoned alternative implementation | Remove commented code; document original intent if needed |
| 3     | `FusRequestPreProcessor.java`           | FUS006 error code                 | L53          | Error code `FUS006` commented out; validation check disabled                           | Confirm with business if validation should be restored or permanently removed |

#### 3.4.2 Hardcoded Values Inventory

| **#** | **File/Class**                          | **Field/Variable**           | **Hardcoded Value**                              | **Lines** | **Expected Behavior**                                         | **Recommendation**                                              |
|-------|-----------------------------------------|------------------------------|--------------------------------------------------|-----------|---------------------------------------------------------------|-----------------------------------------------------------------|
| 1     | `FusAuthServiceResponseProcessor.java`  | Grade mapping string         | `"unprorected"` (typo)                           | —         | Should be `"unprotected"`; dynamic from config                 | Fix typo; externalize grade labels to configuration              |
| 2     | `FusAuthRequestProcessor.java`          | Default Address ID           | `"1"`                                            | —         | Should be configurable or derived from request context          | Externalize to `application.yml` or derive dynamically           |
| 3     | `FusAuthServiceResponseProcessor.java`  | Grade mapping values         | `"3B"`, `"3B(L)"`, `"3B(F)"`, etc.              | Multiple  | Grade codes should be externalized for maintainability          | Move to configuration file or database lookup table              |
| 4     | Various processor classes               | Error messages               | Inline error message strings                     | Multiple  | Error messages should come from `error_messages.json`           | Use `ErrorMessageLookup` consistently for all error messages     |
| 5     | `ldap_config.xml`                       | LDAP URL                     | `ldap://avantageldap.dev.avivaint.ca:389`        | —         | Should be environment-specific                                  | Externalize to environment variables or config properties        |
| 6     | Configuration files                     | Truststore path              | Hardcoded filesystem path                        | —         | Should be environment-specific                                  | Externalize to environment variables                             |

---

## 4. Integration Points

### 4.1 External Integrations

| **#** | **System/Service**        | **Protocol** | **Direction** | **Auth Mechanism**                                  | **Timeout / Retry Config**        | **Fallback Behavior**                                      | **Description**                                                     |
|-------|---------------------------|--------------|---------------|-----------------------------------------------------|-----------------------------------|------------------------------------------------------------|---------------------------------------------------------------------|
| 1     | OPTA OptaSingleService    | SOAP         | Outbound      | OAuth 2.0 (refresh_token) + WS-Security (WSS4J UsernameToken) | Configured via CXF client policy | SOAP Fault mapped to error response (FS2001, FS7001)       | Primary upstream service providing FUS dwelling fire protection data |
| 2     | OAuth Token Endpoint      | REST         | Outbound      | OAuth 2.0 refresh_token grant                        | Configured via CXF-RS client      | Token refresh failure returns authentication error          | Acquires/refreshes access tokens for OPTA service calls              |
| 3     | LDAP Server               | LDAP         | Outbound      | Bind credentials (JAAS)                              | Spring LDAP default timeouts       | Authentication failure returns 401 Unauthorized             | Authenticates inbound callers against Avantage LDAP directory        |
| 4     | Oracle Database           | JDBC         | Outbound      | Database credentials (encrypted via Jasypt)          | JDBC connection pool defaults      | Logging failure does not block main request flow            | Transaction logging for audit and monitoring                         |

### 4.2 Internal Integrations

| **#** | **Module/Service**         | **Communication**       | **Description**                                                         |
|-------|----------------------------|-------------------------|-------------------------------------------------------------------------|
| 1     | Camel Route Pipeline       | In-process (Camel DSL)  | Processors chained via Camel routes in blueprint.xml                    |
| 2     | EHCache (DataCache)        | In-process (Java API)   | Caches authorization config and error message lookups from JSON files   |
| 3     | CXF Logger Interceptors    | In-process (CXF chain)  | Custom logging interceptors with password masking for security          |
| 4     | Transaction Logger         | In-process → JDBC       | Logs request/response metadata to Oracle via Camel SQL component        |

### 4.3 API Documentation (Swagger / OpenAPI)

#### 4.3.1 Swagger Specification Overview

| **Attribute**                | **Details**                                                           |
|------------------------------|-----------------------------------------------------------------------|
| Swagger/OpenAPI Version      | Swagger 2.0 (via swagger-jaxrs 1.5.16)                               |
| Specification File Location  | `fus.wadl` (WADL format, not OpenAPI); Swagger annotations in code   |
| Specification Format         | WADL (XML) — no formal OpenAPI/Swagger YAML/JSON spec file found     |
| API Title                    | OptaSingleService FUS                                                 |
| API Version                  | 3.25.09.01.2-SNAPSHOT                                                |
| Base Path / Server URL       | `/cxf/cl/api/oss` (REST), `/pl/api/oss/fus` (SOAP)                  |
| Auto-Generated               | No — WADL manually maintained; Swagger annotations present but no generated spec |
| Last Updated                 | Unknown                                                               |
| Spec Completeness            | Partial — WADL covers REST; SOAP defined by WSDL; no unified OpenAPI spec |

#### 4.3.2 API Endpoints Inventory

| **#** | **HTTP Method** | **Endpoint Path**                      | **Operation ID**       | **Summary/Description**                              | **Request Body** | **Response Codes**        | **Auth Required** |
|-------|-----------------|----------------------------------------|-----------------------|------------------------------------------------------|------------------|---------------------------|-------------------|
| 1     | GET             | `/pl/api/oss/rest/product/fus/`        | getFusProduct          | Full FUS product response (REST)                     | No (query params) | 200, 400, 401, 403, 500  | Yes (Basic Auth)  |
| 2     | POST (SOAP)     | `/pl/api/oss/fus`                      | getFusScore            | Condensed FUS dwelling fire protection score (SOAP)  | Yes (SOAP XML)   | 200, SOAP Fault           | Yes (WS-Security) |
| 3     | POST (SOAP)     | `/pl/api/oss/product/fus`              | getProductFusScore     | Full product FUS score with all details (SOAP)       | Yes (SOAP XML)   | 200, SOAP Fault           | Yes (WS-Security) |

#### 4.3.3 API Models / Schemas

| **Schema Name**                     | **Type**   | **Properties Count** | **Used In Endpoints**          | **Notes**                                              |
|-------------------------------------|------------|----------------------|-------------------------------|--------------------------------------------------------|
| OSSRequestType                      | Object     | 5+                   | All endpoints (input)          | Address fields: street, postal code, municipality, province |
| OSSResponseType                     | Object     | 3+                   | All endpoints (output)         | Contains Result array with ActivityID, Address, ProductResults |
| FUSProductType                      | Object     | 10+                  | Endpoints 1, 3                | Dwelling/Commercial fire protection data               |
| DwellingFireProtectionRequest       | Object     | 5                    | SOAP endpoints (internal)      | Internal DTO for request processing                    |
| DwellingFireProtectionResponse      | Object     | 8+                   | SOAP endpoints (internal)      | Internal DTO for response processing                   |
| FusAuthRequest                      | Object     | 4                    | Internal (token service)       | OAuth token request model                              |
| FusAuthResponse                     | Object     | 3                    | Internal (token service)       | OAuth token response model                             |
| ResponseAddressType                 | Object     | 5                    | All endpoints (output)         | Parsed address: street, municipality, province, postal code |
| PerilScoreProductType               | Object     | 5+                   | Endpoint 1 (full response)     | Peril scoring data                                     |
| FloodScoreProductType               | Object     | 5+                   | Endpoint 1 (full response)     | Flood risk assessment data                             |

#### 4.3.4 API Security Definitions

| **Security Scheme**     | **Type**                      | **Details**                                                                              |
|-------------------------|-------------------------------|------------------------------------------------------------------------------------------|
| Basic Auth (REST)       | http (Basic)                  | Header: `Authorization: Basic <base64>`, validated against LDAP via JAAS                 |
| WS-Security (SOAP)      | WS-Security (UsernameToken)   | SOAP header with UsernameToken/PasswordText, validated via WSS4J callback to LDAP        |
| OAuth 2.0 (Outbound)    | oauth2 (refresh_token)        | Used for outbound calls to OPTA; token cached and refreshed via dedicated Camel route     |
| Role-Based Access       | Custom                        | Requires `eEsbPlApiOptaAccess` LDAP role; province restrictions from `authorization_config.json` |

#### 4.3.5 API Tags / Groupings

| **Tag Name**          | **Description**                                                | **Endpoints Count** |
|-----------------------|----------------------------------------------------------------|---------------------|
| FUS                   | Fire Underwriters Survey — dwelling fire protection data       | 3                   |
| Product               | Full product response with all OPTA data types                 | 1                   |

#### 4.3.6 Swagger/OpenAPI Gaps & Observations

| **#** | **Observation**                                                              | **Severity** | **Recommendation**                                              |
|-------|------------------------------------------------------------------------------|--------------|-----------------------------------------------------------------|
| 1     | No formal OpenAPI/Swagger specification file exists (only WADL and annotations) | High         | Generate OpenAPI 3.0 spec during forward engineering             |
| 2     | WADL file (~1014 lines) is manually maintained and may not match implementation | Med          | Auto-generate API spec from code annotations in new service      |
| 3     | SOAP endpoints documented only via WSDL/XSD; no unified API documentation   | Med          | Create unified OpenAPI spec covering REST endpoints; document SOAP separately |
| 4     | Swagger-jaxrs 1.5.16 dependency present but no generated spec artifact found | Med          | Migrate to SpringDoc OpenAPI 3.x with auto-generation            |
| 5     | Error response schemas not formally documented in any API spec               | Med          | Define error response models (RFC 7807 ProblemDetail) in OpenAPI spec |

---

## 5. Data Landscape

### 5.1 Data Stores

| **Data Store**           | **Type**   | **Size**   | **Tables/Collections** | **Notes**                                                    |
|--------------------------|------------|------------|------------------------|--------------------------------------------------------------|
| Oracle (Production)      | RDBMS      | Variable   | 1 (fusLogs)            | Transaction logging table; DDL in `table-schema/fusLogs.sql` |
| H2 In-Memory (Dev)       | RDBMS      | N/A        | 1 (tasks)              | TaskManager demo module only; ephemeral                      |
| EHCache (In-Memory)      | Cache      | Small      | 2 caches               | Authorization config cache + error messages cache            |
| JSON Config Files        | File       | <10 KB     | 2 files                | `authorization_config.json`, `error_messages.json`           |

### 5.2 Data Flows Summary

1. **Inbound Request Flow:** Client → CXF Endpoint → JAAS Auth → Authorization Processor → Request Validator → Request Enrichment (OAuth token) → OPTA SOAP Call → Response Processor → Client Response
2. **Transaction Logging Flow:** Each request/response pair → TransactionLogger → Camel SQL → Oracle `fusLogs` table
3. **Configuration Loading Flow:** Application startup → DataCacheLoader → JSON files (`authorization_config.json`, `error_messages.json`) → EHCache
4. **OAuth Token Flow:** Token needed → Camel route `route_oss_security_token` → OAuth endpoint (refresh_token grant) → Token cached for reuse

Detailed Data Flow Diagrams are provided in Document 06 (Data Flow Diagram).

---

## 6. Security Assessment

| **Area**                  | **Current State**                                                                                              | **Risk**  |
|---------------------------|----------------------------------------------------------------------------------------------------------------|-----------|
| Authentication            | LDAP via JAAS for inbound; OAuth 2.0 refresh_token for outbound OPTA calls; WS-Security UsernameToken for SOAP | Med       |
| Authorization             | Role-based (`eEsbPlApiOptaAccess` LDAP group); province-based access control from JSON config                  | Med       |
| Data Encryption (At Rest) | Jasypt encryption for sensitive config properties; Oracle TDE unknown                                          | Med       |
| Data Encryption (Transit) | TLS/SSL with truststore for outbound OPTA calls; LDAP connection not using LDAPS (plain `ldap://`)            | High      |
| Input Validation          | Request pre-processors validate required fields (address, postal code, municipality, province); error codes FS1001-FS1004 | Med       |
| Password Masking          | Custom CXF logging interceptors mask passwords in SOAP message logs                                            | Low       |
| Known Vulnerabilities     | Apache Camel 2.17 and CXF 3.0.2 have multiple known CVEs; Log4j 1.x has critical CVEs (CVE-2021-44228 family); json-simple 1.1 has known vulnerabilities | High      |

---

## 7. Environment & Infrastructure

| **Environment**   | **URL/Endpoint**                                        | **Purpose**         | **Notes**                                                    |
|-------------------|---------------------------------------------------------|---------------------|--------------------------------------------------------------|
| Development       | `https://localhost:port/cxf/cl/api/oss`                 | Dev/Testing         | Local Karaf with SoapUI mock for OPTA; LDAP: `ldap://avantageldap.dev.avivaint.ca:389` |
| Staging           | Configured via environment properties                   | Pre-prod            | Uses real OPTA endpoint with test credentials                |
| Production        | Configured via `${FUS_WITHAUTH_ENDPOINT_URL}`           | Live                | JBoss Fuse Fabric deployment via Jenkins + fabric.cmd        |

---

## 8. Key Risks & Challenges

| **#** | **Risk/Challenge**                                                   | **Impact** | **Mitigation**                                                             |
|-------|----------------------------------------------------------------------|------------|----------------------------------------------------------------------------|
| 1     | Apache Camel 2.17 and CXF 3.0.2 are EOL with known CVEs             | High       | Migrate to Spring Boot 3.x with modern HTTP client; eliminate Camel/CXF dependency |
| 2     | Java 1.8 nearing EOL; not supported by Spring Boot 3.x              | High       | Upgrade to Java 21 as part of forward engineering                          |
| 3     | Log4j 1.x has critical vulnerabilities (log4shell family)           | High       | Migrate to Logback (Spring Boot default) or Log4j 2.x                     |
| 4     | Zero test coverage for FUS service business logic                    | High       | Generate comprehensive test suite during Phase 3 of RE/FE pipeline        |
| 5     | LDAP connection uses plain `ldap://` protocol (not LDAPS)            | High       | Upgrade to `ldaps://` with TLS in migrated service                        |
| 6     | Hardcoded values (grade mappings, LDAP URL, truststore path)         | Med        | Externalize all values to `application.yml` with environment overrides     |
| 7     | Dead code (OssFusSvc null stub, commented blocks) adds confusion     | Med        | Remove dead code during forward engineering; document removals             |
| 8     | OSGi Blueprint XML configuration not portable to Spring Boot         | High       | Convert all Blueprint XML to Spring Boot annotations and `@Configuration`  |
| 9     | ~383 generated SOAP type classes must be regenerated or replaced      | Med        | Regenerate from WSDL using modern tooling or create simplified DTOs        |
| 10    | Typo "unprorected" in grade mapping could cause data inconsistency   | Med        | Fix typo to "unprotected" in migrated code                                |

---

## 9. Recommendations

| **#** | **Recommendation**                                                           | **Priority** | **Rationale**                                                                                  |
|-------|------------------------------------------------------------------------------|--------------|-----------------------------------------------------------------------------------------------|
| 1     | Migrate to Spring Boot 3.x with Java 21                                     | High         | Current stack (Camel 2.x, CXF 3.0, Java 8, Fuse) is at EOL with security vulnerabilities     |
| 2     | Replace OSGi Blueprint with Spring Boot auto-configuration and annotations    | High         | Blueprint XML is not supported in Spring Boot; annotations provide better IDE support          |
| 3     | Implement comprehensive test suite before migration                           | High         | Zero FUS service test coverage makes regression detection impossible during migration          |
| 4     | Externalize all hardcoded values to `application.yml`                        | High         | Hardcoded LDAP URLs, grade mappings, and paths prevent environment portability                 |
| 5     | Generate OpenAPI 3.0 specification for REST endpoints                        | Med          | No formal API specification exists; needed for contract testing and documentation              |
| 6     | Remove all dead code and commented-out blocks                                | Med          | Dead code (OssFusSvc stub, commented blocks) creates maintenance confusion                    |
| 7     | Upgrade LDAP connection to LDAPS (TLS)                                       | High         | Plain LDAP transmits credentials in clear text                                                |
| 8     | Replace json-simple with Jackson for JSON parsing                            | Med          | json-simple 1.1 is unmaintained; Jackson is already a dependency                              |
| 9     | Implement RFC 7807 ProblemDetail for REST error responses                    | Med          | Current error responses use custom format; ProblemDetail is the Spring Boot 3.x standard      |
| 10    | Add circuit breaker pattern for OPTA outbound calls                          | Med          | No fallback mechanism exists if OPTA service is unavailable                                   |
| 11    | Migrate transaction logging to structured logging (JSON format)               | Low          | Current Oracle-based logging could be supplemented with structured application logging        |
| 12    | Evaluate necessity of Fabric8 MQ and EHCache JMS replication dependencies     | Low          | These may be unused; removing reduces migration complexity                                    |

---

## 10. Migration Readiness Assessment

### 10.1 Readiness Scorecard

| **Dimension**                  | **Score (1-5)** | **Assessment**                                                                              |
|--------------------------------|-----------------|---------------------------------------------------------------------------------------------|
| Technology Currency            | 1               | Core stack (Camel 2.x, CXF 3.0, Java 8, Log4j 1.x) is EOL with known CVEs                 |
| Code Quality & Maintainability | 3               | Business logic is well-structured in processors; but Blueprint XML config is complex         |
| Test Coverage                  | 1               | Zero test coverage for FUS service; only TaskManager demo has tests                         |
| Dependency Health              | 2               | Multiple EOL dependencies (Camel, CXF, Log4j, json-simple); Fuse BOM locks versions        |
| Integration Complexity         | 3               | 4 external integrations are well-defined but tightly coupled to Camel/CXF APIs              |
| Data Migration Complexity      | 4               | Minimal data schema (1 logging table); mostly stateless request/response processing         |
| Documentation Completeness     | 2               | Basic README and API guide exist; no architecture docs, no OpenAPI spec, no test docs        |
| Business Logic Clarity         | 3               | Business rules (validation, grade mapping, authorization) are identifiable but hardcoded     |
| **Overall Readiness Score**    | **2.4**         | **High risk — significant modernization effort required across all dimensions**              |

> **Scoring Guide:** 1 = Critical risk, not ready | 2 = High risk, major work needed | 3 = Moderate, manageable with effort | 4 = Good, minor adjustments needed | 5 = Excellent, ready for migration

### 10.2 Migration Approach Recommendation

| **Approach**               | **Suitability** | **Rationale**                                                                                          |
|----------------------------|-----------------|--------------------------------------------------------------------------------------------------------|
| Lift & Shift               | ❌              | Not feasible — OSGi/Karaf runtime, Blueprint XML, and Camel 2.x APIs are not compatible with modern cloud platforms |
| Re-platform                | ⚠️              | Partially feasible — business logic can be preserved but framework layer (Camel routes, CXF endpoints, Blueprint) must be completely replaced |
| Re-architect / Re-write    | ✅              | **Recommended** — Rewrite as Spring Boot 3.x REST service; preserve business rules; modernize all layers; add comprehensive testing |
| Hybrid                     | ⚠️              | Possible — could keep SOAP-to-REST bridge temporarily while migrating to Spring Boot, but adds complexity without long-term benefit |

### 10.3 Critical Blockers for Migration

| **#** | **Blocker Description**                                                            | **Category**  | **Severity** | **Resolution Required Before Migration** |
|-------|------------------------------------------------------------------------------------|---------------|--------------|------------------------------------------|
| 1     | Java 1.8 not supported by Spring Boot 3.x; must upgrade to Java 17+               | Technical     | Critical     | Yes                                      |
| 2     | Apache Camel 2.x route DSL and Blueprint XML have no direct Spring Boot equivalent | Technical     | Critical     | Yes                                      |
| 3     | OSGi bundle packaging (maven-bundle-plugin) incompatible with Spring Boot JAR      | Technical     | Critical     | Yes                                      |
| 4     | Zero test coverage for FUS service — no regression safety net                       | Quality       | High         | Yes                                      |
| 5     | Hardcoded LDAP URL prevents environment portability                                 | Functional    | High         | Yes                                      |
| 6     | WS-Security (WSS4J) configuration must be re-implemented for outbound SOAP calls    | Security      | High         | Yes                                      |
| 7     | Log4j 1.x critical vulnerabilities must be remediated                               | Security      | Critical     | Yes                                      |

---

## 11. API Gateway Integration Considerations

### 11.1 Current API Routing

| **Attribute**                | **Details**                                                                        |
|------------------------------|------------------------------------------------------------------------------------|
| Current Routing Mechanism    | Fuse/Camel route-based with CXF endpoint beans defined in Blueprint XML            |
| Base URL Pattern             | `/pl/api/oss/*` (REST: `/pl/api/oss/rest/product/fus/`, SOAP: `/pl/api/oss/fus`)  |
| Endpoint Count               | 3 (1 REST + 2 SOAP)                                                               |
| Authentication at Entry      | JAAS authentication filter (LDAP) at CXF endpoint level; WS-Security for SOAP     |
| Rate Limiting                | None implemented                                                                    |
| Request/Response Logging     | Custom CXF interceptors (LoggingInInterceptor/LoggingOutInterceptor) with password masking; Oracle transaction logging |

### 11.2 Target API Gateway Requirements

| **Requirement**              | **Details**                                                              | **Status**    |
|------------------------------|--------------------------------------------------------------------------|---------------|
| Gateway Platform             | TBD — AWS API Gateway, Kong, or Apigee                                  | Pending       |
| Authentication Offloading    | Consider offloading LDAP/Basic auth to gateway; keep OAuth for outbound  | Pending       |
| Rate Limiting / Throttling   | Should implement rate limiting (not currently present)                   | Pending       |
| Request Transformation       | SOAP-to-REST transformation currently done by Camel; evaluate gateway vs app | Pending       |
| Response Transformation      | JSON marshalling currently in processors; keep in application            | Pending       |
| Versioning Strategy          | Currently no API versioning; recommend URI-based versioning (`/v1/`)     | Pending       |
| CORS Policy                  | Not currently configured; required if browser clients will call directly | Pending       |

### 11.3 Open Questions for API Gateway Discussion

| **#** | **Question**                                                                                          | **Directed To**        | **Status** | **Resolution** |
|-------|-------------------------------------------------------------------------------------------------------|------------------------|------------|----------------|
| 1     | Will the API Gateway handle LDAP/Basic authentication or will the Spring Boot service retain it?      | Architecture Team      | 🟡 Open   |                |
| 2     | Should SOAP endpoints be maintained in the migrated service or deprecated in favor of REST-only?       | Business/Architecture  | 🟡 Open   |                |
| 3     | What is the target URL pattern for migrated endpoints (`/api/v1/fus/` vs current `/pl/api/oss/...`)? | Architecture Team      | 🟡 Open   |                |
| 4     | Will province-based authorization remain in application code or move to API Gateway policy?            | Security Team          | 🟡 Open   |                |
| 5     | Is the Oracle transaction logging table schema changing, or will the new service log to the same table? | DBA / Operations       | 🟡 Open   |                |

---

## 12. Client Feedback & Additional Findings

### 12.1 Client-Raised Observations

| **#** | **Observation**                              | **Raised By**     | **Date Raised** | **Category**  | **Impact** | **Action Required**                         | **Status**  |
|-------|----------------------------------------------|-------------------|-----------------|---------------|------------|---------------------------------------------|-------------|
| 1     | Pending client review of discovery report     | —                 | —               | —             | —          | Schedule review session with stakeholders    | Open        |

### 12.2 Validated vs. Unvalidated Findings

| **Finding from Discovery**                                          | **Client Validation Status** | **Client Comments**           |
|---------------------------------------------------------------------|------------------------------|-------------------------------|
| "unprorected" typo in grade mapping                                 | 🟡 Pending Validation        | Awaiting client confirmation  |
| OssFusSvc.java is dead code (REST handled by Camel route)           | 🟡 Pending Validation        | Awaiting client confirmation  |
| FUS006 error code intentionally disabled                             | 🟡 Pending Validation        | Awaiting client confirmation  |
| Province-based authorization is active business requirement          | 🟡 Pending Validation        | Awaiting client confirmation  |
| Oracle transaction logging is required in migrated service           | 🟡 Pending Validation        | Awaiting client confirmation  |

---

## 13. Appendices

### Appendix A: Glossary

| **Term**        | **Definition**                                                                                        |
|-----------------|-------------------------------------------------------------------------------------------------------|
| FUS             | Fire Underwriters Survey — Canadian organization providing fire protection classification data         |
| ESB             | Enterprise Service Bus — middleware architecture for integrating disparate services                    |
| OPTA            | OPTA Information Intelligence — insurance data provider (now part of SCM Insurance Services)           |
| OSGi            | Open Services Gateway initiative — Java modular framework used by JBoss Fuse/Karaf                   |
| Blueprint       | OSGi Blueprint Container specification — XML-based dependency injection for OSGi bundles              |
| Camel           | Apache Camel — integration framework implementing Enterprise Integration Patterns                     |
| CXF             | Apache CXF — web services framework supporting SOAP and REST                                          |
| JAAS            | Java Authentication and Authorization Service — pluggable authentication framework                    |
| WSS4J           | Apache WSS4J — Java implementation of WS-Security (Web Services Security)                             |
| WADL            | Web Application Description Language — XML description of REST services (predecessor to OpenAPI)      |
| Jasypt          | Java Simplified Encryption — library for encrypting configuration properties                          |
| EHCache         | Ehcache — Java caching library for in-memory data caching                                             |
| Karaf           | Apache Karaf — OSGi runtime container used by JBoss Fuse                                              |
| Fabric          | JBoss Fuse Fabric — deployment and management layer for Fuse containers                               |
| DFP             | Dwelling Fire Protection — fire protection grade/class for residential properties                     |

### Appendix B: References

| **#** | **Document/Resource**                  | **Location/Link**                                               |
|-------|----------------------------------------|-----------------------------------------------------------------|
| 1     | API Usage Guide                        | `cl-esb-fus/api_guide.md`                                      |
| 2     | Local Development Setup                | `cl-esb-fus/ReadMe.txt`                                        |
| 3     | WADL Specification                     | `cl-esb-fus/fus.wadl`                                          |
| 4     | OSS WSDL                               | `cl-esb-fus/src/main/resources/wsdl/OSS.wsdl`                  |
| 5     | Blueprint Configuration                | `cl-esb-fus/src/main/resources/OSGI-INF/blueprint/blueprint.xml`|
| 6     | Logging Configuration                  | `cl-esb-fus/src/main/resources/OSGI-INF/blueprint/fus-log.xml` |
| 7     | Authorization Config                   | `cl-esb-fus/src/test/resources/authorization_config.json`       |
| 8     | Error Messages Config                  | `cl-esb-fus/src/test/resources/error_messages.json`             |
| 9     | LDAP Configuration                     | `cl-esb-fus/src/test/resources/ldap_config.xml`                 |
| 10    | Jenkins Pipeline                       | `cl-esb-fus/ci-cd/Jenkinsfile`                                  |
| 11    | Oracle DDL (Logging Table)             | `cl-esb-fus/src/main/resources/table-schema/fusLogs.sql`        |
| 12    | Maven POM                              | `cl-esb-fus/pom.xml`                                            |

### Appendix C: Cross-Reference to Other RE Artifacts

| **Artifact**                    | **Document #** | **Relationship to Discovery Report**                                  |
|---------------------------------|----------------|-----------------------------------------------------------------------|
| Component Catalog               | Doc-02         | Detailed breakdown of all 45 business logic classes summarized in Section 3 |
| Sequence Diagrams               | Doc-03         | Runtime flows for SOAP/REST/OAuth integration points in Section 4      |
| Business Rules Catalog          | Doc-04         | BR-NNN items for validation, grade mapping, authorization in Section 2 |
| Data Dictionary                 | Doc-05         | Detailed field definitions for Oracle logging table and DTOs in Section 5 |
| Data Flow Diagram               | Doc-06         | Visual DFD representation of data flows summarized in Section 5.2      |
| BDD Feature Specs               | Doc-07         | Behavioral specs validating all endpoints and error codes in Sections 2-5 |
| Test Case Inventory             | Doc-08         | Test coverage plan addressing the ~5% coverage gap in Section 3.2      |
| Gap Report                      | Doc-09         | GAP-NNN items derived from dead code, hardcoded values, CVEs in Sections 3-8 |
| Field-to-Field Mapping          | Doc-10         | Field mapping for OPTA SOAP ↔ REST response transformation in Section 5 |

---

> **Document Control:**
> | Version | Date | Author | Changes |
> |---------|------|--------|---------|
> | 0.1 | 27-Jun-2025 | Copilot RE/FE Pipeline | Initial draft — comprehensive discovery report based on full codebase analysis |
> | 0.2 | 27-Jun-2025 | Copilot RE/FE Pipeline | Added: Tech stack risk assessment (2.2), Dead code & hardcoded values inventory (3.4), Integration security details (4.1), Migration readiness assessment (10), API Gateway considerations (11), Client feedback section (12), Cross-reference appendix (C) |
> | 0.3 | 27-Jun-2025 | Copilot RE/FE Pipeline | Added: Swagger/OpenAPI documentation section (4.3) for reverse-engineered API specifications |
