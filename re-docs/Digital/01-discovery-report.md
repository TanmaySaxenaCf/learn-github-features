# Discovery Report

---

| **Field**            | **Details**                                    |
|----------------------|------------------------------------------------|
| **Project Name**     | CL-ESB-FUS (OPTA Commercial Liability ESB — FUS) |
| **Application Name** | Digital                                        |
| **Version**          | 3.25.09.01.2-SNAPSHOT                          |
| **Date**             | 01-Apr-2026                                    |
| **Prepared By**      | Copilot                                        |
| **Reviewed By**      | —                                              |
| **Status**           | Draft                                          |

---

## 1. Executive Summary

> **Purpose:** Reverse-engineer the CL-ESB-FUS service to produce architecture documentation, API specifications, class diagrams, and dependency maps in preparation for modernization.
>
> **Scope:** All source code, configuration, and deployment artifacts within the `cl-esb-fus/` folder, including 48 core business-logic Java classes, 384+ auto-generated WSDL classes, XML/properties/JSON configuration, and test resources. Excludes the embedded Spring Boot Task Manager sample code.
>
> **Key Findings:** The application is an Apache Camel / CXF-based Enterprise Service Bus integration layer that proxies OPTA Single Service (fire underwriting scores) as both RESTful and SOAP endpoints. It runs on JBoss Fuse 6.3 (Karaf) with Java 1.8 — both are well past end of life. Sensitive configuration values are encrypted via Jasypt with Vault. Authentication is LDAP-based (JAAS) with WS-Security (UsernameToken) for SOAP and HTTP Basic for REST. Province-level authorization is enforced via a JSON-file cache. The code contains several hardcoded values, stub implementations (OssFusSvc returns null), and no automated test suite.

---

## 2. Application Overview

### 2.1 Application Description

The CL-ESB-FUS application is an integration layer that exposes the third-party OPTA Single Service (OSS) — specifically the Fire Underwriting Score (FUS) product — as both REST and SOAP endpoints for internal Aviva Canada consumers. End users are internal systems and service consumers such as Catalyst, Search Customer Service, and RTG ESB.

| **Attribute**           | **Details**                                                  |
|-------------------------|--------------------------------------------------------------|
| Application Type        | API (ESB Integration Service)                                |
| Primary Language        | Java 1.8                                                     |
| Framework(s)            | Apache Camel 2.17.0, Apache CXF 3.0.2, OSGi Blueprint       |
| Database(s)             | JDBC (cl_fus_trans_log table for transaction logging)        |
| Deployment Platform     | On-Prem — Apache Karaf / JBoss Fuse 6.3                     |
| Authentication Method   | LDAP (JAAS), WS-Security (UsernameToken), HTTP Basic Auth    |

### 2.2 Technology Stack

| **Layer**         | **Technology**                     | **Version**               | **Support Status** | **Migration Risk** | **Notes**                                         |
|-------------------|------------------------------------|---------------------------|--------------------|---------------------|---------------------------------------------------|
| Backend           | Java                               | 1.8                       | 🔴 EOL             | 🔴 High             | Must upgrade to Java 17+                          |
| Backend           | Apache Camel                       | 2.17.0.redhat-630187      | 🔴 EOL             | 🔴 High             | Camel 2.x is EOL; migrate to Camel 4.x or Spring |
| Backend           | Apache CXF                         | 3.0.2                     | 🔴 EOL             | 🟡 Med              | Upgrade or replace with Spring MVC / WebFlux      |
| Middleware        | JBoss Fuse / Apache Karaf          | 6.3.0.redhat-187          | 🔴 EOL             | 🔴 High             | Container must be replaced entirely               |
| Middleware        | OSGi Blueprint                     | —                         | 🔴 EOL             | 🔴 High             | Replace with Spring Boot auto-configuration       |
| Caching           | EhCache (camel-cache)              | 2.17.0                    | ⚠️ Nearing EOL     | 🟡 Med              | Consider Spring Cache abstraction + Redis         |
| Backend           | Jasypt (camel-jasypt)              | 2.17.0                    | ⚠️ Nearing EOL     | 🟡 Med              | Replace with Spring Boot Vault / AWS Secrets Mgr  |
| Backend           | Jackson                            | 2.4.3                     | 🔴 EOL             | 🟢 Low              | Upgrade to current Jackson 2.x                    |
| Backend           | Swagger (swagger-jaxrs)            | 1.5.16                    | 🔴 EOL             | 🟢 Low              | Replace with OpenAPI 3.x / SpringDoc              |
| CI/CD             | Maven                              | 3.x                       | ✅ Supported        | 🟢 Low              | —                                                 |

### 2.3 Architecture Pattern

The application follows a **Service-Oriented Architecture (SOA)** using the **Enterprise Service Bus (ESB)** pattern. Apache Camel routes define the processing pipeline: incoming requests are authenticated, validated, transformed, forwarded to the OPTA service, and the response is transformed back. The route pattern is a **Processor Chain** (Pipes and Filters).

---

## 3. Codebase Analysis

### 3.1 Repository Structure

```
cl-esb-fus/
├── pom.xml                         # Maven build (OSGi bundle packaging)
├── ReadMe.txt                      # Deployment instructions
├── api_guide.md                    # REST API documentation
├── fus.wadl                        # WADL REST API definition
├── ci-cd/                          # CI/CD configuration
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/aviva/ca/esb/
│   │   │       ├── cl/opta/fus/
│   │   │       │   ├── service/       # REST/SOAP endpoint interfaces (3 files)
│   │   │       │   ├── processor/     # Camel processors (11 files)
│   │   │       │   ├── model/         # Request/Response DTOs (8 files)
│   │   │       │   ├── logging/       # Transaction logging (3 files)
│   │   │       │   └── json/model/    # JSON cache models (5 files)
│   │   │       └── common/cxf/logger/ # CXF logging interceptors (3 files)
│   │   └── resources/
│   │       └── OSGI-INF/blueprint/
│   │           └── blueprint.xml       # OSGi Blueprint (Camel routes, beans, endpoints)
│   └── test/
│       └── resources/                  # Test configs, SOAP UI projects
└── (auto-generated WSDL classes under ca.optaintel.ws.optasingleservice)
```

### 3.2 Code Metrics

| **Metric**                    | **Value**   |
|-------------------------------|-------------|
| Total Lines of Code (LOC)     | ~55,000     |
| Number of Source Files         | ~472        |
| Number of Modules/Packages    | 7           |
| Number of Classes              | ~432        |
| Number of Test Files           | 0           |
| Test Coverage                  | 0%          |
| Cyclomatic Complexity (Avg)    | Low-Medium  |

### 3.3 Dependency Analysis

| **Dependency**                | **Version**               | **Purpose**                           | **Risk Level** |
|-------------------------------|---------------------------|---------------------------------------|----------------|
| camel-core                    | 2.17.0.redhat-630187      | Integration routing framework         | High           |
| camel-cxf                     | 2.17.0                    | SOAP/REST CXF transport               | High           |
| camel-cache                   | 2.17.0                    | EhCache-based response caching        | Med            |
| camel-jasypt                  | 2.17.0                    | Encrypted property placeholders       | Med            |
| camel-sql                     | 2.17.0                    | JDBC-based transaction logging        | Med            |
| cxf-rt-frontend-jaxrs         | 3.0.2                     | JAX-RS REST framework                 | High           |
| swagger-jaxrs                 | 1.5.16                    | Swagger API documentation             | Low            |
| jackson-module-jaxb-annotations | 2.4.3                   | JSON/XML serialization                | Low            |
| json-simple                   | 1.1                       | JSON parsing for config files         | Low            |
| vault-adapter                 | 1.0.7-SNAPSHOT            | Aviva Vault Service for encryption    | Med            |

### 3.4 Dead Code & Hardcoded Values Summary

#### 3.4.1 Dead Code Inventory

| **#** | **File/Class**                    | **Method/Block**    | **Lines**  | **Evidence**                                                                | **Recommendation**                |
|-------|-----------------------------------|---------------------|------------|-----------------------------------------------------------------------------|-----------------------------------|
| 1     | OssFusSvc.java                    | getFusScore()       | Full method | Returns `null` — actual processing delegated to Camel route; method body is stub | Confirm this is intentional CXF behavior |
| 2     | FusSvc.java                       | getFusScore()       | Full method | Interface-only; implementation is in Camel route processors                  | Document as expected pattern      |
| 3     | FusProductSvc.java                | getFusScore()       | Full method | Interface-only; implementation is in Camel route processors                  | Document as expected pattern      |

#### 3.4.2 Hardcoded Values Inventory

| **#** | **File/Class**                       | **Field/Variable**         | **Hardcoded Value**                                        | **Lines** | **Expected Behavior**                  | **Recommendation**                          |
|-------|--------------------------------------|----------------------------|------------------------------------------------------------|-----------|----------------------------------------|---------------------------------------------|
| 1     | FusAuthRequestProcessor.java         | DEFAULT_ADDRESS_ID         | `"1"`                                                       | —         | Should be dynamic per request          | Externalize to config                       |
| 2     | FusAuthRequestProcessor.java         | CALL_METHOD_NAME           | `"call"`                                                    | —         | Tightly coupled to OPTA service        | Externalize to config                       |
| 3     | FusAuthRequestProcessor.java         | CALL_METHOD_NAME_SPACE     | `"http://www.optaintel.ca/ws/OptaSingleService/1.0"`        | —         | Should be configurable                 | Externalize to config                       |
| 4     | FusAuthorizationProcessor.java       | UNAUTHORISED               | `"FS1005"`                                                  | —         | Error code constant                    | Move to error_messages.json                 |
| 5     | FusAuthorizationProcessor.java       | CONST_AUTH_ERROR            | `"Provided Province is not authorized to view operation."`  | —         | Error message constant                 | Move to error_messages.json lookup          |
| 6     | ErrorProcessor.java                  | UNKNOWN_ERR_CD             | `"FS2001"`                                                  | —         | Default error code                     | Load from error config                      |
| 7     | blueprint.xml                        | WS-Security validate.token | `"false"`                                                   | —         | Token validation disabled              | Review security posture                     |
| 8     | blueprint.xml                        | disableCNCheck             | `"true"`                                                    | —         | TLS CN check disabled                  | Enable in production                        |
| 9     | app_config.properties                | FUS_CONNECTION_TIMEOUT     | `30000`                                                     | —         | Static timeout                         | Consider dynamic tuning                     |
| 10    | app_config.properties                | FUS_CLIENT_SECRET          | `d23cf6e4-b621-41ec-ba02-008f1adcb200`                      | —         | OAuth client secret in plain text      | Move to Vault / secrets manager             |

---

## 4. Integration Points

### 4.1 External Integrations

| **#** | **System/Service**        | **Protocol** | **Direction** | **Auth Mechanism**         | **Timeout / Retry Config**       | **Fallback Behavior**        | **Description**                                    |
|-------|---------------------------|--------------|---------------|----------------------------|----------------------------------|------------------------------|----------------------------------------------------|
| 1     | OPTA Single Service (OSS) | SOAP         | Outbound      | OAuth 2.0 Bearer Token     | 30s connect / 30s receive        | None (error propagated)      | Core FUS scoring service — fire protection ratings |
| 2     | OPTA Auth (OAuth)         | REST         | Outbound      | Client ID + Secret (Refresh Token grant) | 30s connect / 30s receive | None (error propagated)    | Token endpoint for OPTA service authentication     |
| 3     | LDAP Directory            | LDAP         | Outbound      | JAAS Login Module          | Default                          | Auth failure → 401           | User authentication for REST/SOAP consumers        |
| 4     | Transaction Database      | JDBC         | Outbound      | Connection pool credentials| Default                          | Async logging, continues     | Logs request/response payloads to cl_fus_trans_log  |
| 5     | Aviva Vault Service       | Java API     | Outbound      | Internal                   | N/A                              | Startup failure              | Provides encryption keys for Jasypt                |

### 4.2 Internal Integrations

| **#** | **Module/Service**             | **Communication** | **Description**                                          |
|-------|--------------------------------|--------------------|----------------------------------------------------------|
| 1     | Error Message Cache (DataCache)| In-memory singleton | JSON file loaded at startup → lookup by error code       |
| 2     | Authorization Cache (DataCache)| In-memory singleton | JSON file loaded at startup → user-to-province mapping   |
| 3     | EhCache (Response Cache)       | In-memory           | Caches OPTA responses keyed by address hash              |

### 4.3 API Documentation (Swagger / OpenAPI)

#### 4.3.1 Swagger Specification Overview

| **Attribute**                | **Details**                                                    |
|------------------------------|----------------------------------------------------------------|
| Swagger/OpenAPI Version      | Swagger 2.0                                                    |
| Specification File Location  | Auto-generated via swagger-jaxrs annotations in OssFusSvc.java |
| Specification Format         | Runtime-generated JSON                                         |
| API Title                    | OSS FUS Service                                                |
| API Version                  | 1.0                                                            |
| Base Path / Server URL       | /cxf/cl/api/oss/fus                                            |
| Auto-Generated               | Yes — swagger-jaxrs 1.5.16                                     |
| Last Updated                 | Unknown                                                        |
| Spec Completeness            | Partial — only REST endpoint annotated                         |

#### 4.3.2 API Endpoints Inventory

| **#** | **HTTP Method** | **Endpoint Path**              | **Operation ID** | **Summary/Description**                       | **Request Body** | **Response Codes**   | **Auth Required** |
|-------|-----------------|-------------------------------|-------------------|-----------------------------------------------|------------------|----------------------|-------------------|
| 1     | GET             | /pl/api/oss/rest/product       | getFusScore       | Returns FUS score for a property address       | No (Query params)| 200, 400, 403, 500  | Yes (Basic Auth)  |
| 2     | POST (SOAP)     | /pl/api/oss/fus                | getFusScore       | SOAP endpoint for FUS score                    | Yes (SOAP XML)   | 200, SOAP Fault      | Yes (WS-Security) |
| 3     | POST (SOAP)     | /pl/api/oss/product/fus        | getFusScore       | SOAP endpoint returning full product response  | Yes (SOAP XML)   | 200, SOAP Fault      | Yes (WS-Security) |

#### 4.3.3 API Models / Schemas

| **Schema Name**                  | **Type** | **Properties Count** | **Used In Endpoints**         | **Notes**                     |
|----------------------------------|----------|----------------------|-------------------------------|-------------------------------|
| FusProductRequest                | Object   | 7                    | REST GET                      | Query-param bound DTO         |
| FusRequest                       | Object   | 2 (nested)           | SOAP getFusScore              | JAXB XML-annotated            |
| FUSResponse                      | Object   | 1 (nested)           | SOAP getFusScore              | Fire protection response      |
| FusProductResponse               | Object   | Complex              | SOAP full response            | Maps complete OSS response    |
| ResultType (OPTA generated)      | Object   | 3 (Address, Products)| REST response                 | Auto-generated from WSDL      |

#### 4.3.4 API Security Definitions

| **Security Scheme**      | **Type** | **Details**                                                                      |
|--------------------------|----------|----------------------------------------------------------------------------------|
| HTTP Basic (REST)        | http     | JAASAuthenticationFilter with LDAP backend; Header: `Authorization: Basic ...`   |
| WS-Security (SOAP)       | SOAP     | UsernameToken with PasswordText; validated against LDAP via JAAS Login Module     |
| Role-based Authorization | RBAC     | Required role: `eEsbPlApiOptaAccess` enforced by SimpleAuthorizingInterceptor    |

#### 4.3.5 API Tags / Groupings

| **Tag Name** | **Description**                                  | **Endpoints Count** |
|--------------|--------------------------------------------------|---------------------|
| FUS          | Fire Underwriting Score operations               | 3                   |

#### 4.3.6 Swagger/OpenAPI Gaps & Observations

| **#** | **Observation**                                                          | **Severity** | **Recommendation**                                |
|-------|--------------------------------------------------------------------------|--------------|---------------------------------------------------|
| 1     | Only REST endpoint has Swagger annotations; SOAP endpoints undocumented  | Med          | Generate OpenAPI 3.x spec covering all endpoints  |
| 2     | WADL file (40 KB) exists but is machine-generated and hard to consume    | Low          | Replace with OpenAPI spec                         |
| 3     | No security scheme definition in Swagger annotations                     | High         | Add security definitions in migrated OpenAPI spec |
| 4     | Error response models not documented in Swagger                          | Med          | Document ErrorDetails schema                      |

---

## 5. Data Landscape

### 5.1 Data Stores

| **Data Store**          | **Type** | **Size**  | **Tables/Collections** | **Notes**                                |
|-------------------------|----------|-----------|------------------------|------------------------------------------|
| Transaction Log DB      | RDBMS    | Unknown   | 1 (cl_fus_trans_log)   | Stores request/response audit trail      |
| Error Message JSON      | File     | ~1 KB     | 6 error codes          | Loaded into in-memory DataCache          |
| Authorization JSON      | File     | ~1 KB     | 3 users                | Loaded into in-memory DataCache          |
| EhCache Response Cache  | Memory   | Configurable | Key-value pairs     | Keyed by address hash                   |

### 5.2 Data Flows Summary

1. **Inbound Request** → LDAP Authentication → Province Authorization → Request Validation
2. **Request Transformation** → Build OSSRequestType → Obtain OAuth Token → Call OPTA Service
3. **Response Transformation** → Extract FUS scores → Build JSON/SOAP response → Cache response
4. **Transaction Logging** → Async write of request/response payloads to cl_fus_trans_log table

---

## 6. Security Assessment

| **Area**                  | **Current State**                                               | **Risk**   |
|---------------------------|-----------------------------------------------------------------|------------|
| Authentication            | LDAP via JAAS (REST Basic Auth, SOAP WS-Security UsernameToken) | Med        |
| Authorization             | Role-based (eEsbPlApiOptaAccess) + Province-level ACL           | Low        |
| Data Encryption (At Rest) | Jasypt + Vault for property encryption; DB data unencrypted     | Med        |
| Data Encryption (Transit) | TLS enabled but CN check disabled (`disableCNCheck=true`)       | High       |
| Input Validation          | Basic null/blank checks on 4 fields; no format validation       | High       |
| Known Vulnerabilities     | Java 1.8 EOL, Camel 2.17 EOL, CXF 3.0.2 EOL — multiple CVEs   | High       |

---

## 7. Environment & Infrastructure

| **Environment** | **URL/Endpoint**                                                          | **Purpose**  | **Notes**                             |
|-----------------|---------------------------------------------------------------------------|--------------|---------------------------------------|
| QA              | https://qa.avivacanadaservices.com:9444/services/OPTAAuth/…               | QA Testing   | OAuth endpoint configured             |
| QA              | https://qa.avivacanadaservices.com/services/OPTAPS_a                      | QA Testing   | OPTA service endpoint                 |
| Local           | mvn camel:run                                                              | Development  | Local Camel standalone                |
| Karaf           | osgi:install -s mvn:com.aviva.ca/cl-esb-fus/3.25.09.01.2-SNAPSHOT        | Deployment   | OSGi bundle install                   |

---

## 8. Key Risks & Challenges

| **#** | **Risk/Challenge**                                         | **Impact** | **Mitigation**                                             |
|-------|-------------------------------------------------------------|------------|-----------------------------------------------------------|
| 1     | Java 1.8 and JBoss Fuse 6.3 are EOL — no security patches  | High       | Migrate to Java 21 + Spring Boot 3.x                     |
| 2     | Apache Camel 2.x is EOL; route DSL has breaking changes     | High       | Rewrite routes using Spring Boot integration patterns     |
| 3     | TLS CN check disabled in production                          | High       | Enable CN check; update certificates if needed            |
| 4     | Zero automated tests — regression risk during migration     | High       | Write integration tests before migration                  |
| 5     | OAuth client secret in config file (not fully vaulted)       | Med        | Move all secrets to Vault / AWS Secrets Manager           |
| 6     | 384+ auto-generated WSDL classes tightly coupled to OPTA    | Med        | Generate fresh from WSDL or use dynamic SOAP client       |
| 7     | Hardcoded error codes and messages in processor classes      | Low        | Centralize in configuration or error catalog              |

---

## 9. Recommendations

| **#** | **Recommendation**                                                 | **Priority** | **Rationale**                                                   |
|-------|---------------------------------------------------------------------|--------------|----------------------------------------------------------------|
| 1     | Migrate to Spring Boot 3.x with Java 21                            | High         | Current runtime is EOL with known CVEs                          |
| 2     | Replace Camel routes with Spring MVC controllers + service layer    | High         | Simplifies architecture and eliminates Karaf dependency         |
| 3     | Implement comprehensive input validation (format, length, pattern)  | High         | Only null/blank checks exist today                              |
| 4     | Enable TLS CN verification in all environments                      | High         | Security best practice; currently disabled                      |
| 5     | Add automated integration and contract tests                        | High         | Zero test coverage creates high regression risk                 |
| 6     | Move all secrets to a centralized secrets manager                   | Med          | OAuth client secret partially exposed in config                 |
| 7     | Replace EhCache with Spring Cache + Redis for distributed caching   | Med          | Better scalability and observability                            |
| 8     | Generate OpenAPI 3.x specification for all endpoints                | Med          | Current Swagger 2.0 annotations only cover REST endpoint       |

---

## 10. Migration Readiness Assessment

### 10.1 Readiness Scorecard

| **Dimension**                  | **Score (1-5)** | **Assessment**                                                       |
|--------------------------------|-----------------|----------------------------------------------------------------------|
| Technology Currency            | 1               | Java 1.8, Camel 2.17, Fuse 6.3 — all well past EOL                   |
| Code Quality & Maintainability | 3               | Moderate complexity; clear processor chain pattern; some dead code     |
| Test Coverage                  | 1               | No automated tests at all                                             |
| Dependency Health              | 1               | Most libraries at EOL; internal Artifactory dependencies              |
| Integration Complexity         | 3               | Two external integrations (OPTA + LDAP); well-defined interfaces      |
| Data Migration Complexity      | 4               | Single logging table; minimal schema concerns                         |
| Documentation Completeness     | 3               | API guide and WADL exist; internal docs are minimal                   |
| Business Logic Clarity         | 3               | Clear request validation + auth flow; some hardcoded values           |
| **Overall Readiness Score**    | **2.4**         | **Major work needed — full re-platform recommended**                  |

> **Scoring Guide:** 1 = Critical risk, not ready | 2 = High risk, major work needed | 3 = Moderate, manageable with effort | 4 = Good, minor adjustments needed | 5 = Excellent, ready for migration

### 10.2 Migration Approach Recommendation

| **Approach**               | **Suitability** | **Rationale**                                                                   |
|----------------------------|-----------------|---------------------------------------------------------------------------------|
| Lift & Shift               | ❌              | OSGi/Karaf container has no direct cloud equivalent; not viable                 |
| Re-platform                | ⚠️              | Could work for basic port to Spring Boot, but Camel route DSL changes required  |
| Re-architect / Re-write    | ✅              | Best fit — clean Spring Boot 3.x service with modern patterns                   |
| Hybrid                     | ⚠️              | Could incrementally replace routes while keeping OPTA integration               |

### 10.3 Critical Blockers for Migration

| **#** | **Blocker Description**                                                   | **Category** | **Severity** | **Resolution Required Before Migration** |
|-------|---------------------------------------------------------------------------|--------------|--------------|------------------------------------------|
| 1     | JBoss Fuse 6.3 / Karaf runtime is EOL and has no Spring Boot equivalent   | Technical    | Critical     | Yes                                      |
| 2     | Zero test coverage — no safety net for behavioral regression              | Technical    | Critical     | Yes                                      |
| 3     | TLS CN check disabled — security vulnerability in transit encryption      | Security     | High         | Yes                                      |
| 4     | OAuth client secret partially exposed in config files                     | Security     | High         | Yes                                      |

---

## 11. API Gateway Integration Considerations

### 11.1 Current API Routing

| **Attribute**                | **Details**                                                           |
|------------------------------|-----------------------------------------------------------------------|
| Current Routing Mechanism    | Apache Camel CXF routes within OSGi Blueprint                        |
| Base URL Pattern             | /cxf/cl/api/oss/* and /pl/api/oss/*                                  |
| Endpoint Count               | 3 (1 REST + 2 SOAP)                                                 |
| Authentication at Entry      | JAAS (LDAP) for REST; WS-Security + JAAS for SOAP                   |
| Rate Limiting                | None                                                                  |
| Request/Response Logging     | Async database logging via TransactionLogger; CXF message interceptors|

### 11.2 Target API Gateway Requirements

| **Requirement**              | **Details**                                                  | **Status**  |
|------------------------------|--------------------------------------------------------------|-------------|
| Gateway Platform             | TBD (e.g., AWS API Gateway, Kong, Apigee)                   | Pending     |
| Authentication Offloading    | TBD — currently done in-service via JAAS                     | Pending     |
| Rate Limiting / Throttling   | Not currently implemented; recommended for migration         | Pending     |
| Request Transformation       | Province validation could move to gateway policy             | Pending     |
| Response Transformation      | None anticipated — service handles transformation            | Pending     |
| Versioning Strategy          | Currently unversioned; recommend URI versioning (/v1/)       | Pending     |
| CORS Policy                  | Not applicable (server-to-server)                            | Pending     |

### 11.3 Open Questions for API Gateway Discussion

| **#** | **Question**                                                                          | **Directed To** | **Status** | **Resolution** |
|-------|---------------------------------------------------------------------------------------|-----------------|------------|----------------|
| 1     | Will the API Gateway handle LDAP authentication or will the service retain it?        | Architecture     | 🟡 Open   |                |
| 2     | Should SOAP endpoints be maintained or migrated to REST-only?                          | Business         | 🟡 Open   |                |
| 3     | What is the target URL pattern for migrated endpoints?                                 | Architecture     | 🟡 Open   |                |

---

## 12. Client Feedback & Additional Findings

### 12.1 Client-Raised Observations

| **#** | **Observation**             | **Raised By** | **Date Raised** | **Category** | **Impact** | **Action Required**           | **Status** |
|-------|-----------------------------|---------------|-----------------|--------------|------------|-------------------------------|------------|
|       | No client feedback yet      | —             | —               | —            | —          | Pending review session        | Open       |

### 12.2 Validated vs. Unvalidated Findings

| **Finding from Discovery**                              | **Client Validation Status** | **Client Comments** |
|---------------------------------------------------------|------------------------------|---------------------|
| OssFusSvc.getFusScore() returns null (stub)             | 🟡 Pending                   | —                   |
| TLS CN check disabled in blueprint.xml                   | 🟡 Pending                   | —                   |
| OAuth client secret partially in plain text              | 🟡 Pending                   | —                   |

---

## 13. Appendices

### Appendix A: Glossary

| **Term**     | **Definition**                                                        |
|--------------|-----------------------------------------------------------------------|
| FUS          | Fire Underwriting Score — fire risk rating for properties              |
| OSS          | OPTA Single Service — third-party property risk scoring API           |
| ESB          | Enterprise Service Bus — integration middleware pattern               |
| OPTA         | Formerly Opta Information Intelligence; property risk data provider   |
| JAAS         | Java Authentication and Authorization Service                         |
| Karaf        | Apache Karaf — OSGi-based runtime container                           |
| CXF          | Apache CXF — web services framework for JAX-RS/JAX-WS                |
| Jasypt       | Java Simplified Encryption library                                    |

### Appendix B: References

| **#** | **Document/Resource**              | **Location/Link**                                        |
|-------|------------------------------------|----------------------------------------------------------|
| 1     | API Guide                          | cl-esb-fus/api_guide.md                                  |
| 2     | WADL Definition                    | cl-esb-fus/fus.wadl                                      |
| 3     | ReadMe / Deployment Guide          | cl-esb-fus/ReadMe.txt                                    |
| 4     | Blueprint Configuration            | cl-esb-fus/src/main/resources/OSGI-INF/blueprint/blueprint.xml |

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
> | 0.1 | 01-Apr-2026 | Copilot | Initial draft |
