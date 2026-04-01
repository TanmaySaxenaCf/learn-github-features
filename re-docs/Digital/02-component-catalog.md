# Component Catalog

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

## 1. Overview

This component catalog enumerates all software components, modules, services, and libraries identified during reverse engineering of the CL-ESB-FUS application. The application is an Apache Camel / CXF-based ESB integration layer that exposes OPTA Single Service (FUS) via REST and SOAP endpoints. Components are organized by their architectural layer and function.

---

## 2. Component Summary

| **Total Components** | **Modules** | **Services** | **Libraries** | **Shared Utilities** |
|----------------------|-------------|--------------|---------------|----------------------|
| 15                   | 6           | 3            | 10            | 3                    |

### 2.1 Component Health Summary

| **Status**                       | **Count** | **Percentage** |
|----------------------------------|-----------|----------------|
| ✅ Active                         | 12        | 80%            |
| ⚠️ Partially Used                | 1         | 7%             |
| 🔴 Dead Code                     | 0         | 0%             |
| ⚪ Contains Hardcoded Values      | 5         | 33%            |

---

## 3. Component Inventory

### 3.1 Component: REST Service Endpoint

| **Attribute**            | **Details**                                                                       |
|--------------------------|-----------------------------------------------------------------------------------|
| **Component ID**         | COMP-001                                                                          |
| **Component Name**       | REST Service Endpoint (OssFusSvc)                                                 |
| **Type**                 | Service                                                                           |
| **Layer**                | Presentation                                                                      |
| **Package/Namespace**    | com.aviva.ca.esb.cl.opta.fus.service                                             |
| **Source Path**          | cl-esb-fus/src/main/java/com/aviva/ca/esb/cl/opta/fus/service/OssFusSvc.java     |
| **Language**             | Java 1.8                                                                          |
| **Framework**            | Apache CXF (JAX-RS)                                                               |
| **Framework Version**    | 3.0.2                                                                             |
| **Description**          | RESTful endpoint that accepts FUS score queries via HTTP GET with query parameters |
| **Business Capability**  | Exposes FUS scoring as a REST API for internal consumers                           |
| **Owner/Team**           | ESB / Integration Team                                                            |
| **Status**               | Active                                                                            |
| **Migration Risk**       | 🔴 High — JAX-RS annotations must be ported to Spring MVC                         |
| **Hardcoded Values**     | No                                                                                |
| **Dead Code Present**    | Yes — getFusScore() returns null (stub; CXF delegates to Camel route)             |

#### Dependencies

| **Depends On**              | **Dependency Type** | **Version** | **Support Status** | **Migration Risk** | **Notes**                    |
|-----------------------------|---------------------|-------------|--------------------|--------------------|------------------------------|
| Apache CXF (JAX-RS)         | Compile             | 3.0.2       | 🔴 EOL             | 🔴 High            | Replace with Spring MVC      |
| Swagger (swagger-jaxrs)     | Compile             | 1.5.16      | 🔴 EOL             | 🟢 Low             | Replace with SpringDoc        |
| FusProductRequest (COMP-005)| Compile             | —           | ✅ Internal         | 🟢 Low             | Request DTO                  |

#### Exposed Interfaces

| **Interface**                        | **Type** | **Auth Mechanism**           | **Rate Limit** | **Description**                              |
|--------------------------------------|----------|------------------------------|----------------|----------------------------------------------|
| GET /pl/api/oss/rest/product          | REST     | HTTP Basic Auth (LDAP/JAAS)  | No             | Returns FUS score as JSON for given address  |

#### Key Classes / Files

| **Class/File Name** | **Responsibility**                              | **LOC** |
|---------------------|--------------------------------------------------|---------|
| OssFusSvc.java      | JAX-RS resource class; defines REST endpoint     | ~40     |

---

### 3.2 Component: SOAP Service Endpoint

| **Attribute**            | **Details**                                                                   |
|--------------------------|-------------------------------------------------------------------------------|
| **Component ID**         | COMP-002                                                                      |
| **Component Name**       | SOAP Service Endpoint (FusSvc)                                                |
| **Type**                 | Service                                                                       |
| **Layer**                | Presentation                                                                  |
| **Package/Namespace**    | com.aviva.ca.esb.cl.opta.fus.service                                         |
| **Source Path**          | cl-esb-fus/src/main/java/com/aviva/ca/esb/cl/opta/fus/service/FusSvc.java    |
| **Language**             | Java 1.8                                                                      |
| **Framework**            | Apache CXF (JAX-WS)                                                          |
| **Framework Version**    | 3.0.2                                                                         |
| **Description**          | SOAP web service interface for FUS score retrieval                             |
| **Business Capability**  | Exposes FUS scoring as a SOAP API for internal consumers                      |
| **Owner/Team**           | ESB / Integration Team                                                        |
| **Status**               | Active                                                                        |
| **Migration Risk**       | 🔴 High — SOAP may be deprecated in favor of REST-only                        |
| **Hardcoded Values**     | No                                                                            |
| **Dead Code Present**    | No — interface-only; Camel route provides implementation                      |

#### Dependencies

| **Depends On**              | **Dependency Type** | **Version** | **Support Status** | **Migration Risk** | **Notes**                 |
|-----------------------------|---------------------|-------------|--------------------|--------------------|---------------------------|
| Apache CXF (JAX-WS)         | Compile             | 3.0.2       | 🔴 EOL             | 🔴 High            | Replace with Spring WS    |
| FusRequest (COMP-005)        | Compile             | —           | ✅ Internal         | 🟢 Low             | Request DTO               |
| SOAPServiceException         | Compile             | —           | ✅ Internal         | 🟢 Low             | Custom SOAP fault         |

#### Exposed Interfaces

| **Interface**             | **Type** | **Auth Mechanism**                  | **Rate Limit** | **Description**                    |
|---------------------------|----------|-------------------------------------|----------------|------------------------------------|
| /pl/api/oss/fus           | SOAP     | WS-Security UsernameToken + LDAP    | No             | Returns FUS score as SOAP response |

#### Key Classes / Files

| **Class/File Name** | **Responsibility**                       | **LOC** |
|---------------------|-------------------------------------------|---------|
| FusSvc.java         | SOAP service interface definition        | ~25     |

---

### 3.3 Component: SOAP Full Response Service Endpoint

| **Attribute**            | **Details**                                                                          |
|--------------------------|--------------------------------------------------------------------------------------|
| **Component ID**         | COMP-003                                                                             |
| **Component Name**       | SOAP Full Response Service Endpoint (FusProductSvc)                                  |
| **Type**                 | Service                                                                              |
| **Layer**                | Presentation                                                                         |
| **Package/Namespace**    | com.aviva.ca.esb.cl.opta.fus.service                                                |
| **Source Path**          | cl-esb-fus/src/main/java/com/aviva/ca/esb/cl/opta/fus/service/FusProductSvc.java    |
| **Language**             | Java 1.8                                                                             |
| **Framework**            | Apache CXF (JAX-WS)                                                                 |
| **Framework Version**    | 3.0.2                                                                                |
| **Description**          | SOAP endpoint returning the complete OPTA product response (not just FUS subset)     |
| **Business Capability**  | Full product response for consumers needing all OPTA data                            |
| **Owner/Team**           | ESB / Integration Team                                                               |
| **Status**               | Active                                                                               |
| **Migration Risk**       | 🔴 High — SOAP may be deprecated; complex response mapping                           |
| **Hardcoded Values**     | No                                                                                   |
| **Dead Code Present**    | No                                                                                   |

#### Dependencies

| **Depends On**                | **Dependency Type** | **Version** | **Support Status** | **Migration Risk** | **Notes**             |
|-------------------------------|---------------------|-------------|--------------------|--------------------|------------------------|
| Apache CXF (JAX-WS)           | Compile             | 3.0.2       | 🔴 EOL             | 🔴 High            | Replace with Spring WS |
| FusProductRequest (COMP-005)   | Compile             | —           | ✅ Internal         | 🟢 Low             | Request DTO            |
| FusProductResponse (COMP-005)  | Compile             | —           | ✅ Internal         | 🟢 Low             | Full response DTO      |

#### Exposed Interfaces

| **Interface**                 | **Type** | **Auth Mechanism**               | **Rate Limit** | **Description**                          |
|-------------------------------|----------|----------------------------------|----------------|------------------------------------------|
| /pl/api/oss/product/fus       | SOAP     | WS-Security UsernameToken + LDAP | No             | Returns full OPTA product SOAP response  |

#### Key Classes / Files

| **Class/File Name**  | **Responsibility**                                | **LOC** |
|----------------------|---------------------------------------------------|---------|
| FusProductSvc.java   | SOAP service interface for full product response  | ~25     |

---

### 3.4 Component: Request Processing Pipeline

| **Attribute**            | **Details**                                                                        |
|--------------------------|------------------------------------------------------------------------------------|
| **Component ID**         | COMP-004                                                                           |
| **Component Name**       | Request Processing Pipeline (Camel Processors)                                     |
| **Type**                 | Module                                                                             |
| **Layer**                | Business                                                                           |
| **Package/Namespace**    | com.aviva.ca.esb.cl.opta.fus.processor                                            |
| **Source Path**          | cl-esb-fus/src/main/java/com/aviva/ca/esb/cl/opta/fus/processor/                  |
| **Language**             | Java 1.8                                                                           |
| **Framework**            | Apache Camel (Processor interface)                                                 |
| **Framework Version**    | 2.17.0                                                                             |
| **Description**          | Set of 11 Camel processors implementing the request/response processing pipeline   |
| **Business Capability**  | Request validation, authorization, OPTA request building, response transformation  |
| **Owner/Team**           | ESB / Integration Team                                                             |
| **Status**               | Active                                                                             |
| **Migration Risk**       | 🔴 High — Camel Exchange API replaced with Spring service methods                   |
| **Hardcoded Values**     | Yes — See Section 10                                                               |
| **Dead Code Present**    | No                                                                                 |

#### Dependencies

| **Depends On**                   | **Dependency Type** | **Version**               | **Support Status** | **Migration Risk** | **Notes**                        |
|----------------------------------|---------------------|---------------------------|--------------------|--------------------|---------------------------------|
| Apache Camel Core                | Compile             | 2.17.0.redhat-630187      | 🔴 EOL             | 🔴 High            | Exchange/Processor API           |
| OPTA Generated Classes (COMP-008)| Compile             | —                         | ✅ Internal         | 🟡 Med             | OSSRequestType, ResultType       |
| Model DTOs (COMP-005)           | Compile             | —                         | ✅ Internal         | 🟢 Low             | FusRequest, FusProductRequest    |
| DataCache (COMP-007)             | Runtime             | —                         | ✅ Internal         | 🟢 Low             | Error message lookup             |

#### Exposed Interfaces

| **Interface**          | **Type** | **Auth Mechanism** | **Rate Limit** | **Description**                    |
|------------------------|----------|--------------------|-----------------|------------------------------------|
| Camel Processor.process| Internal | N/A                | N/A             | Camel Exchange processing pipeline |

#### Key Classes / Files

| **Class/File Name**                        | **Responsibility**                                          | **LOC** |
|--------------------------------------------|--------------------------------------------------------------|---------|
| FusAuthorizationProcessor.java             | Province-level authorization validation                      | ~80     |
| FusAuthRequestProcessor.java               | Transforms REST/SOAP request to OPTA OSSRequestType          | ~120    |
| FusAuthServiceResponseProcessor.java       | Transforms OPTA response to FUS response                     | ~60     |
| FusAuthServiceProcessor.java               | Builds OAuth token request for OPTA auth endpoint            | ~50     |
| FusAuthServiceResponse.java                | Processes OAuth token response                               | ~30     |
| FusRequestPreProcessor.java                | Validates REST request fields (streetName, postalCode, etc.) | ~60     |
| FusFullResAuthRequestProcessor.java        | Request transformation for full response endpoint            | ~120    |
| FusFullResAuthServiceResponseProcessor.java| Response transformation for full response endpoint           | ~60     |
| FusFullResAuthorizationProcessor.java      | Authorization for full response endpoint                     | ~80     |
| FusFullResRequestPreProcessor.java         | Validation for full response endpoint                        | ~60     |
| ErrorProcessor.java                        | Centralized error handling and SOAP fault conversion         | ~100    |

---

### 3.5 Component: Model DTOs

| **Attribute**            | **Details**                                                                 |
|--------------------------|-----------------------------------------------------------------------------|
| **Component ID**         | COMP-005                                                                    |
| **Component Name**       | Model DTOs (Request/Response)                                               |
| **Type**                 | Library                                                                     |
| **Layer**                | Cross-Cutting                                                               |
| **Package/Namespace**    | com.aviva.ca.esb.cl.opta.fus.model                                        |
| **Source Path**          | cl-esb-fus/src/main/java/com/aviva/ca/esb/cl/opta/fus/model/               |
| **Language**             | Java 1.8                                                                    |
| **Framework**            | JAXB, JAX-RS (@QueryParam)                                                 |
| **Framework Version**    | Java EE 7                                                                   |
| **Description**          | Request and response data transfer objects with JAXB/JAX-RS annotations     |
| **Business Capability**  | Data transport between service layers                                       |
| **Owner/Team**           | ESB / Integration Team                                                      |
| **Status**               | Active                                                                      |
| **Migration Risk**       | 🟡 Medium — JAXB annotations may need replacement; records could simplify   |
| **Hardcoded Values**     | No                                                                          |
| **Dead Code Present**    | No                                                                          |

#### Key Classes / Files

| **Class/File Name**                    | **Responsibility**                                    | **LOC** |
|----------------------------------------|-------------------------------------------------------|---------|
| FusRequest.java                        | SOAP request wrapper with BaseRequest + DwellingFireProtectionRequest | ~40 |
| FusProductRequest.java                 | REST query parameters DTO (streetName, postalCode, municipality, province, ibcCode, naicsCode, sicCode) | ~60 |
| FUSResponse.java                       | SOAP response wrapper with DwellingFireProtectionResponse | ~30 |
| FusProductResponse.java                | Full product response mapping from OPTA                | ~30     |
| BaseRequest.java                       | Base request with ClientInfo                           | ~25     |
| BaseResponse.java                      | Base response                                          | ~20     |
| DwellingFireProtectionRequest.java     | Address and industry code fields for FUS query         | ~40     |
| DwellingFireProtectionResponse.java    | Fire protection details response                       | ~30     |
| ClientInfo.java                        | Client authentication data (ID, Name, GUID)            | ~30     |
| FusAuthResponse.java                   | OAuth token response DTO                               | ~25     |
| SOAPServiceException.java              | Custom SOAP fault exception                            | ~30     |

---

### 3.6 Component: Transaction Logging

| **Attribute**            | **Details**                                                                    |
|--------------------------|--------------------------------------------------------------------------------|
| **Component ID**         | COMP-006                                                                       |
| **Component Name**       | Transaction Logging                                                            |
| **Type**                 | Module                                                                         |
| **Layer**                | Cross-Cutting                                                                  |
| **Package/Namespace**    | com.aviva.ca.esb.cl.opta.fus.logging                                         |
| **Source Path**          | cl-esb-fus/src/main/java/com/aviva/ca/esb/cl/opta/fus/logging/               |
| **Language**             | Java 1.8                                                                       |
| **Framework**            | Spring JDBC, JAXB                                                             |
| **Framework Version**    | Spring 4.x (Fuse bundled)                                                      |
| **Description**          | Asynchronous transaction logging of request/response payloads to database      |
| **Business Capability**  | Audit trail and operational monitoring                                         |
| **Owner/Team**           | ESB / Integration Team                                                         |
| **Status**               | Active                                                                         |
| **Migration Risk**       | 🟡 Medium — JdbcTemplate portable; Camel Exchange coupling needs refactoring   |
| **Hardcoded Values**     | No                                                                             |
| **Dead Code Present**    | No                                                                             |

#### Dependencies

| **Depends On**          | **Dependency Type** | **Version** | **Support Status** | **Migration Risk** | **Notes**                   |
|-------------------------|---------------------|-------------|--------------------|--------------------|------------------------------|
| Spring JdbcTemplate     | Compile             | 4.x         | 🔴 EOL             | 🟢 Low             | API stable across versions   |
| JAXB                    | Compile             | 2.x         | ⚠️ Nearing EOL     | 🟡 Med             | Removed from Java 11+        |
| Apache Camel Exchange   | Runtime             | 2.17.0      | 🔴 EOL             | 🔴 High            | Coupled to Camel context     |

#### Key Classes / Files

| **Class/File Name**         | **Responsibility**                                          | **LOC** |
|-----------------------------|--------------------------------------------------------------|---------|
| TransactionLogger.java      | Async DB insert of transaction logs; JAXB XML serialization | ~80     |
| LoggerConstants.java         | 28 static String constants for logging field names          | ~50     |
| FusTransactionLog.java       | POJO with 17 fields for transaction log record              | ~120    |

---

### 3.7 Component: Data Cache & Error Handling

| **Attribute**            | **Details**                                                                    |
|--------------------------|--------------------------------------------------------------------------------|
| **Component ID**         | COMP-007                                                                       |
| **Component Name**       | Data Cache & Error Handling                                                    |
| **Type**                 | Module                                                                         |
| **Layer**                | Cross-Cutting                                                                  |
| **Package/Namespace**    | com.aviva.ca.esb.cl.opta.fus.json.model                                      |
| **Source Path**          | cl-esb-fus/src/main/java/com/aviva/ca/esb/cl/opta/fus/json/model/            |
| **Language**             | Java 1.8                                                                       |
| **Framework**            | Jackson, java.util.concurrent                                                  |
| **Framework Version**    | Jackson 2.4.3                                                                  |
| **Description**          | Singleton cache for error messages and user authorization mappings loaded from JSON files |
| **Business Capability**  | Error message resolution and user-province authorization lookup               |
| **Owner/Team**           | ESB / Integration Team                                                         |
| **Status**               | Active                                                                         |
| **Migration Risk**       | 🟡 Medium — Singleton pattern replaceable with Spring beans                    |
| **Hardcoded Values**     | No                                                                             |
| **Dead Code Present**    | No                                                                             |

#### Key Classes / Files

| **Class/File Name**          | **Responsibility**                                               | **LOC** |
|------------------------------|-------------------------------------------------------------------|---------|
| DataCache.java               | Thread-safe singleton cache (double-checked locking)              | ~50     |
| DataCacheLoader.java         | Populates cache from deserialized JSON lists                      | ~40     |
| ErrorMessageLookup.java      | Error code → English/French message mapping DTO                   | ~30     |
| AuthorizationLookup.java     | User → allowed provinces mapping DTO                              | ~35     |
| ResponseError.java           | Custom exception with code + message                              | ~25     |

---

### 3.8 Component: OPTA Generated Classes

| **Attribute**            | **Details**                                                                    |
|--------------------------|--------------------------------------------------------------------------------|
| **Component ID**         | COMP-008                                                                       |
| **Component Name**       | OPTA Generated WSDL Classes                                                   |
| **Type**                 | Library                                                                        |
| **Layer**                | Integration                                                                    |
| **Package/Namespace**    | ca.optaintel.ws.optasingleservice._2_0                                        |
| **Source Path**          | cl-esb-fus/src/main/java/ca/optaintel/ws/optasingleservice/                   |
| **Language**             | Java 1.8                                                                       |
| **Framework**            | JAXB (auto-generated from WSDL/XSD)                                           |
| **Framework Version**    | JAXB 2.x                                                                       |
| **Description**          | 384+ auto-generated classes from OPTA Single Service WSDL representing all product types, address structures, request/response envelopes |
| **Business Capability**  | Type-safe SOAP communication with OPTA service                                |
| **Owner/Team**           | Generated / OPTA                                                               |
| **Status**               | Active                                                                         |
| **Migration Risk**       | 🟡 Medium — Regenerate from WSDL or replace with dynamic client               |
| **Hardcoded Values**     | No                                                                             |
| **Dead Code Present**    | Yes — Many product types beyond FUS are included but unused                    |

#### Key Classes / Files

| **Class/File Name**                    | **Responsibility**                                   | **LOC** |
|----------------------------------------|-------------------------------------------------------|---------|
| OptaSingleServicePort.java             | SOAP service port interface                           | ~20     |
| OSSRequestType.java                    | Root request type for OSS calls                       | ~80     |
| OSSResponseType.java                   | Root response type from OSS                           | ~60     |
| ResultType.java                        | Individual result with Address + ProductResults       | ~50     |
| FUSProductType.java                    | FUS product data (Dwelling, Commercial, Earthquake)   | ~40     |
| Various enums                          | Roof types, wall types, heating types, etc.           | ~10 each|

---

### 3.9 Component: CXF Logging Interceptors

| **Attribute**            | **Details**                                                           |
|--------------------------|-----------------------------------------------------------------------|
| **Component ID**         | COMP-009                                                              |
| **Component Name**       | CXF Logging Interceptors                                             |
| **Type**                 | Utility                                                               |
| **Layer**                | Cross-Cutting                                                         |
| **Package/Namespace**    | com.aviva.ca.esb.common.cxf.logger                                   |
| **Source Path**          | cl-esb-fus/src/main/java/com/aviva/ca/esb/common/cxf/logger/         |
| **Language**             | Java 1.8                                                              |
| **Framework**            | Apache CXF Interceptor API                                           |
| **Framework Version**    | 3.0.2                                                                 |
| **Description**          | Custom CXF interceptors for logging inbound and outbound SOAP/REST messages |
| **Business Capability**  | Operational logging and debugging                                     |
| **Owner/Team**           | ESB / Integration Team                                                |
| **Status**               | Active                                                                |
| **Migration Risk**       | 🟡 Medium — Replace with Spring interceptors or filters               |
| **Hardcoded Values**     | No                                                                    |
| **Dead Code Present**    | No                                                                    |

#### Key Classes / Files

| **Class/File Name**          | **Responsibility**                       | **LOC** |
|------------------------------|-------------------------------------------|---------|
| CXFLoggerFeature.java        | CXF Feature that registers interceptors  | ~20     |
| LoggingInInterceptor.java    | Logs incoming CXF messages               | ~30     |
| LoggingOutInterceptor.java   | Logs outgoing CXF messages               | ~30     |

---

### 3.10 Component: OSGi Blueprint Configuration

| **Attribute**            | **Details**                                                                     |
|--------------------------|---------------------------------------------------------------------------------|
| **Component ID**         | COMP-010                                                                        |
| **Component Name**       | OSGi Blueprint Configuration                                                   |
| **Type**                 | Module                                                                          |
| **Layer**                | Integration                                                                     |
| **Package/Namespace**    | OSGI-INF/blueprint                                                             |
| **Source Path**          | cl-esb-fus/src/main/resources/OSGI-INF/blueprint/blueprint.xml                  |
| **Language**             | XML (Blueprint DSL)                                                             |
| **Framework**            | OSGi Blueprint, Apache Camel Blueprint DSL                                     |
| **Framework Version**    | Camel 2.17.0 / Aries Blueprint                                                 |
| **Description**          | Master configuration file defining CXF endpoints, Camel routes, bean wiring, security interceptors, and external service connections |
| **Business Capability**  | Application wiring and route orchestration                                     |
| **Owner/Team**           | ESB / Integration Team                                                          |
| **Status**               | Active                                                                          |
| **Migration Risk**       | 🔴 High — Must be fully replaced with Spring Boot configuration                |
| **Hardcoded Values**     | Yes — See Section 10                                                            |
| **Dead Code Present**    | No                                                                              |

#### Key Classes / Files

| **Class/File Name** | **Responsibility**                                               | **LOC** |
|---------------------|------------------------------------------------------------------|---------|
| blueprint.xml       | Full application wiring: 3 CXF endpoints, 4 Camel routes, 11 processor beans, security config, SSL/TLS config | ~339 |

---

### 3.11 Component: Application Configuration

| **Attribute**            | **Details**                                                           |
|--------------------------|-----------------------------------------------------------------------|
| **Component ID**         | COMP-011                                                              |
| **Component Name**       | Application Configuration                                            |
| **Type**                 | Module                                                                |
| **Layer**                | Cross-Cutting                                                         |
| **Package/Namespace**    | resources                                                             |
| **Source Path**          | cl-esb-fus/src/main/resources/ and external /app/opdata/properties/   |
| **Language**             | Properties, JSON                                                      |
| **Framework**            | Jasypt, Camel Property Placeholder                                   |
| **Framework Version**    | Camel 2.17.0                                                          |
| **Description**          | Configuration files including app config, logging queries, error messages, and authorization mappings |
| **Business Capability**  | Runtime configuration and externalized settings                      |
| **Owner/Team**           | ESB / Integration Team                                                |
| **Status**               | Active                                                                |
| **Migration Risk**       | 🟡 Medium — Convert to Spring Boot application.yml                    |
| **Hardcoded Values**     | Yes — See Section 10                                                  |
| **Dead Code Present**    | No                                                                    |

#### Key Classes / Files

| **Class/File Name**                | **Responsibility**                                    | **LOC** |
|------------------------------------|-------------------------------------------------------|---------|
| app_config.properties              | Service endpoints, timeouts, credentials, LDAP config | ~30     |
| log4j.properties                   | Logging configuration                                 | ~15     |
| fus_logging_queries.properties     | SQL insert query for transaction logging              | ~5      |
| error_messages.json                | Error code → message mapping (6 entries)              | ~30     |
| authorization_config.json          | User → allowed provinces mapping (3 users)            | ~20     |

---

## 4. Component Dependency Map

### 4.1 Dependency Matrix

| **Component ↓ / Depends On →** | COMP-001 | COMP-002 | COMP-003 | COMP-004 | COMP-005 | COMP-006 | COMP-007 | COMP-008 | COMP-009 | COMP-010 | COMP-011 |
|---------------------------------|----------|----------|----------|----------|----------|----------|----------|----------|----------|----------|----------|
| **COMP-001** REST Svc           | —        |          |          |          | ✓        |          |          |          |          |          |          |
| **COMP-002** SOAP Svc           |          | —        |          |          | ✓        |          |          |          |          |          |          |
| **COMP-003** SOAP Full Svc      |          |          | —        |          | ✓        |          |          |          |          |          |          |
| **COMP-004** Processors         |          |          |          | —        | ✓        | ✓        | ✓        | ✓        |          |          | ✓        |
| **COMP-005** Model DTOs         |          |          |          |          | —        |          |          |          |          |          |          |
| **COMP-006** Logging            |          |          |          |          | ✓        | —        |          |          |          |          | ✓        |
| **COMP-007** Cache/Error        |          |          |          |          |          |          | —        |          |          |          | ✓        |
| **COMP-008** OPTA Classes       |          |          |          |          |          |          |          | —        |          |          |          |
| **COMP-009** CXF Logger         |          |          |          |          |          |          |          |          | —        |          |          |
| **COMP-010** Blueprint          | ✓        | ✓        | ✓        | ✓        |          | ✓        | ✓        | ✓        | ✓        | —        | ✓        |
| **COMP-011** Config             |          |          |          |          |          |          |          |          |          |          | —        |

### 4.2 Dependency Diagram

```
┌─────────────────┐
│   COMP-010      │──────────────────────────────────────┐
│ Blueprint Config│──────┐─────────┐──────────┐          │
└────────┬────────┘      │         │          │          │
         │               │         │          │          │
         ▼               ▼         ▼          ▼          ▼
┌─────────────┐  ┌─────────────┐ ┌──────────┐ ┌──────────┐ ┌──────────┐
│  COMP-001   │  │  COMP-002   │ │ COMP-003 │ │ COMP-004 │ │ COMP-009 │
│  REST Svc   │  │  SOAP Svc   │ │ SOAP Full│ │Processors│ │CXF Logger│
└──────┬──────┘  └──────┬──────┘ └────┬─────┘ └──┬──┬────┘ └──────────┘
       │                │             │           │  │
       └────────┬───────┴─────────────┘           │  │
                ▼                                  │  │
         ┌─────────────┐                           │  │
         │  COMP-005   │◀──────────────────────────┘  │
         │ Model DTOs  │                              │
         └─────────────┘                              │
                                    ┌─────────────────┤
                                    ▼                 ▼
                             ┌─────────────┐  ┌─────────────┐
                             │  COMP-006   │  │  COMP-007   │
                             │  Logging    │  │ Cache/Error │
                             └──────┬──────┘  └──────┬──────┘
                                    │                 │
                                    ▼                 ▼
                             ┌─────────────┐  ┌─────────────┐
                             │  COMP-011   │  │  COMP-008   │
                             │   Config    │  │ OPTA Classes│
                             └─────────────┘  └─────────────┘
```

---

## 5. Layered Component View

### 5.1 Presentation Layer

| **Component ID** | **Component Name**              | **Technology**     | **Description**                               |
|------------------|---------------------------------|--------------------|-----------------------------------------------|
| COMP-001         | REST Service Endpoint           | CXF JAX-RS         | HTTP GET endpoint for FUS score queries        |
| COMP-002         | SOAP Service Endpoint           | CXF JAX-WS         | SOAP endpoint for FUS score                    |
| COMP-003         | SOAP Full Response Endpoint     | CXF JAX-WS         | SOAP endpoint for full product response        |

### 5.2 Business Logic Layer

| **Component ID** | **Component Name**              | **Technology**     | **Description**                                |
|------------------|---------------------------------|--------------------|------------------------------------------------|
| COMP-004         | Request Processing Pipeline     | Camel Processors   | Validation, authorization, transformation, error handling |

### 5.3 Data Access Layer

| **Component ID** | **Component Name**              | **Technology**     | **Description**                                |
|------------------|---------------------------------|--------------------|------------------------------------------------|
| COMP-006         | Transaction Logging             | Spring JdbcTemplate| Async insert of transaction records to DB      |

### 5.4 Integration Layer

| **Component ID** | **Component Name**              | **Technology**     | **Description**                                |
|------------------|---------------------------------|--------------------|------------------------------------------------|
| COMP-008         | OPTA Generated Classes          | JAXB               | WSDL-generated types for OPTA service calls    |
| COMP-010         | OSGi Blueprint Configuration    | Blueprint XML      | Route definitions and service wiring           |

### 5.5 Cross-Cutting Concerns

| **Component ID** | **Component Name**         | **Concern Type**       | **Description**                                |
|------------------|----------------------------|------------------------|------------------------------------------------|
| COMP-005         | Model DTOs                 | Data Transport         | Request/response objects used across layers    |
| COMP-007         | Data Cache & Error Handling| Caching / Error Mgmt   | Singleton cache for error and auth lookups     |
| COMP-009         | CXF Logging Interceptors   | Logging                | Message-level logging for CXF                  |
| COMP-011         | Application Configuration  | Configuration          | Externalized properties and JSON configs       |

---

## 6. Third-Party Libraries & Frameworks

| **Library/Framework**         | **Version**               | **License**    | **Used By**        | **Support Status** | **Migration Risk** | **Purpose**                           |
|-------------------------------|---------------------------|----------------|--------------------|--------------------|---------------------|---------------------------------------|
| Apache Camel Core             | 2.17.0.redhat-630187      | Apache 2.0     | COMP-004, COMP-010 | 🔴 EOL             | 🔴 High             | Integration routing engine            |
| Apache CXF (JAX-RS/JAX-WS)   | 3.0.2                     | Apache 2.0     | COMP-001-003       | 🔴 EOL             | 🔴 High             | Web services framework                |
| Jackson                       | 2.4.3                     | Apache 2.0     | COMP-007           | 🔴 EOL             | 🟢 Low              | JSON serialization                    |
| Swagger (swagger-jaxrs)       | 1.5.16                    | Apache 2.0     | COMP-001           | 🔴 EOL             | 🟢 Low              | API documentation                     |
| JAXB                          | 2.x                       | CDDL/GPL       | COMP-005, COMP-008 | ⚠️ Nearing EOL     | 🟡 Med              | XML binding                           |
| Spring JDBC                   | 4.x (Fuse bundled)        | Apache 2.0     | COMP-006           | 🔴 EOL             | 🟢 Low              | Database access                       |
| Jasypt                        | 2.17.0 (Camel)            | Apache 2.0     | COMP-011           | ⚠️ Nearing EOL     | 🟡 Med              | Property encryption                   |
| EhCache                       | 2.x (Camel)               | Apache 2.0     | COMP-010           | ⚠️ Nearing EOL     | 🟡 Med              | Response caching                      |
| json-simple                   | 1.1                       | Apache 2.0     | COMP-007           | 🔴 EOL             | 🟢 Low              | Simple JSON parsing                   |
| Vault Adapter                 | 1.0.7-SNAPSHOT            | Proprietary    | COMP-011           | ✅ Internal         | 🟡 Med              | Encryption key management             |

---

## 7. Deprecated / Dead Code Components

| **Component ID** | **Component Name**        | **Reason**                                                          | **Evidence Type**                                      | **Lines Affected** | **Last Modified** | **Recommendation**          |
|------------------|---------------------------|---------------------------------------------------------------------|--------------------------------------------------------|--------------------|--------------------|------------------------------|
| COMP-001         | OssFusSvc.getFusScore()   | Method body returns null — CXF delegates processing to Camel route  | Stub implementation; never directly invoked by clients | Full method        | Unknown            | Confirm CXF pattern; document|
| COMP-008 (partial)| Unused OPTA product types | Only FUS product types are used; 300+ other product types present  | Never referenced in processor code                     | 300+ classes       | Generated          | Regenerate with FUS-only XSD |

---

## 8. Notes & Observations

| **#** | **Observation**                                                                 | **Severity** | **Recommendation**                             |
|-------|---------------------------------------------------------------------------------|--------------|------------------------------------------------|
| 1     | Processor logic is duplicated for REST vs SOAP vs Full Response endpoints       | Warning      | Consolidate shared logic into common service   |
| 2     | DataCache uses double-checked locking singleton — thread-safety concerns        | Warning      | Replace with Spring-managed singleton bean     |
| 3     | JAXB is removed from Java 11+; WSDL classes will need jakarta.xml.bind         | Critical     | Add JAXB runtime dependency or use alternatives|
| 4     | Error messages support French (errorDesc_fr) but all French values are empty   | Info         | Populate or remove i18n support                |

---

## 9. Appendices

### Appendix A: Component ID Reference

Naming convention: COMP-[NNN] where NNN is a sequential number.

| **Range** | **Category**          |
|-----------|-----------------------|
| 001-003   | Service Endpoints     |
| 004       | Business Processors   |
| 005       | Data Models           |
| 006       | Logging               |
| 007       | Cache / Error         |
| 008       | Generated Classes     |
| 009       | CXF Utilities         |
| 010       | Configuration (XML)   |
| 011       | Configuration (Props) |

### Appendix B: Glossary

| **Term**     | **Definition**                                                        |
|--------------|-----------------------------------------------------------------------|
| FUS          | Fire Underwriting Score                                                |
| OSS          | OPTA Single Service                                                    |
| ESB          | Enterprise Service Bus                                                 |
| CXF          | Apache CXF web services framework                                     |
| Blueprint    | OSGi Blueprint dependency injection container                         |
| Processor    | Apache Camel Processor interface implementation                       |

---

## 10. Hardcoded Values per Component

| **Component ID** | **File/Class**                   | **Field/Variable**         | **Hardcoded Value**                                      | **Line(s)** | **Expected Behavior**                  | **Impact if Not Addressed**                      | **Recommendation**                          |
|------------------|----------------------------------|----------------------------|---------------------------------------------------------|-------------|----------------------------------------|--------------------------------------------------|---------------------------------------------|
| COMP-004         | FusAuthRequestProcessor.java     | DEFAULT_ADDRESS_ID         | `"1"`                                                    | —           | Should be per-request or configurable  | All addresses get same ID                        | Externalize to config                       |
| COMP-004         | FusAuthRequestProcessor.java     | CALL_METHOD_NAME           | `"call"`                                                 | —           | Should be configurable                 | Tight coupling to OPTA service                   | Externalize to config                       |
| COMP-004         | FusAuthRequestProcessor.java     | CALL_METHOD_NAME_SPACE     | `"http://www.optaintel.ca/ws/OptaSingleService/1.0"`     | —           | Should be configurable                 | Cannot change without code modification          | Externalize to config                       |
| COMP-004         | FusAuthorizationProcessor.java   | UNAUTHORISED               | `"FS1005"`                                               | —           | Should reference error catalog         | Inconsistent error code management               | Load from error config                      |
| COMP-004         | FusAuthorizationProcessor.java   | CONST_AUTH_ERROR            | `"Provided Province is not authorized..."`               | —           | Should reference error catalog         | Inconsistent error message management            | Load from error_messages.json               |
| COMP-004         | ErrorProcessor.java              | UNKNOWN_ERR_CD             | `"FS2001"`                                               | —           | Should reference error catalog         | Inconsistent error code management               | Load from error config                      |
| COMP-010         | blueprint.xml                    | ws-security.validate.token | `"false"`                                                | —           | Should validate WS-Security tokens     | Security vulnerability — tokens not validated    | Enable token validation                     |
| COMP-010         | blueprint.xml                    | disableCNCheck             | `"true"`                                                 | —           | Should verify TLS certificate CN       | Man-in-the-middle risk                           | Enable CN check                             |
| COMP-011         | app_config.properties            | FUS_CLIENT_SECRET          | `d23cf6e4-b621-41ec-ba02-008f1adcb200`                   | —           | Should be encrypted or vaulted         | OAuth credential exposure                        | Move to Vault / secrets manager             |

---

## 11. Component-to-Endpoint Mapping

| **Endpoint**                     | **HTTP Method** | **Route Component** | **Processor(s)**                                                | **Transformer(s)**                     | **Data Access** | **External Calls**        |
|----------------------------------|-----------------|---------------------|-----------------------------------------------------------------|----------------------------------------|-----------------|---------------------------|
| /pl/api/oss/rest/product          | GET             | COMP-010 (in_rest_fusRouter) | COMP-004 (FusFullResAuthorizationProcessor, FusFullResRequestPreProcessor) | COMP-004 (FusFullResAuthRequestProcessor, FusFullResAuthServiceResponseProcessor) | COMP-006 (TransactionLogger) | OPTA OSS (COMP-008), OPTA Auth |
| /pl/api/oss/fus                   | POST (SOAP)     | COMP-010 (in_soap_fusRouter) | COMP-004 (FusAuthorizationProcessor, FusRequestPreProcessor)    | COMP-004 (FusAuthRequestProcessor, FusAuthServiceResponseProcessor) | COMP-006 (TransactionLogger) | OPTA OSS (COMP-008), OPTA Auth |
| /pl/api/oss/product/fus           | POST (SOAP)     | COMP-010 (in_soap_fus_fullResponse_Router) | COMP-004 (FusFullResAuthorizationProcessor, FusFullResRequestPreProcessor) | COMP-004 (FusFullResAuthRequestProcessor, FusFullResAuthServiceResponseProcessor) | COMP-006 (TransactionLogger) | OPTA OSS (COMP-008), OPTA Auth |

---

> **Document Control:**
> | Version | Date | Author | Changes |
> |---------|------|--------|---------|
> | 0.1 | 01-Apr-2026 | Copilot | Initial draft |
