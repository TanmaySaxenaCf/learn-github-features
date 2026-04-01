# Business Rules Catalog

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

This catalog documents all business rules identified during reverse engineering of the CL-ESB-FUS application. The application is an integration layer that proxies the OPTA Single Service (FUS) via REST and SOAP endpoints. Business rules primarily cover input validation, authorization, request transformation, error handling, and response mapping.

### Rule Classification

| **Category**       | **Description**                                                    |
|--------------------|--------------------------------------------------------------------|
| **Validation**     | Input validation, data format checks, required field enforcement    |
| **Computation**    | Calculations, formulas, derived values                              |
| **Decision**       | Conditional logic, branching, routing decisions                     |
| **Authorization**  | Access control, permission checks, role-based rules                 |
| **Workflow**       | Process flow, state transitions, sequencing rules                   |
| **Constraint**     | Data integrity constraints, business limits, thresholds             |
| **Derivation**     | Rules that derive or infer data from other data                     |
| **Notification**   | Trigger conditions for alerts, emails, or notifications             |

---

## 2. Business Rules Summary

| **Category**       | **Count** | **Critical** | **Major** | **Minor** |
|--------------------|-----------|--------------|-----------|-----------|
| Validation         | 4         | 0            | 4         | 0         |
| Computation        | 2         | 0            | 0         | 2         |
| Decision           | 3         | 1            | 2         | 0         |
| Authorization      | 3         | 1            | 2         | 0         |
| Workflow           | 2         | 0            | 2         | 0         |
| Constraint         | 1         | 0            | 1         | 0         |
| Derivation         | 1         | 0            | 0         | 1         |
| Notification       | 1         | 0            | 0         | 1         |
| **Total**          | **17**    | **2**        | **11**    | **4**     |

### 2.1 Rule Health Summary

| **Status**                            | **Count** | **Percentage** |
|---------------------------------------|-----------|----------------|
| ✅ Active & Validated by Client        | 0         | 0%             |
| 🟡 Active & Pending Client Validation | 15        | 88%            |
| ❌ Client Identified as Incorrect      | 0         | 0%             |
| ⚫ Dead Code Rule                      | 0         | 0%             |
| ⚪ Hardcoded / Bypassed Rule           | 2         | 12%            |

---

## 3. Business Rules Detail

### 3.1 BR-001: Street Address Required

| **Attribute**            | **Details**                                                         |
|--------------------------|---------------------------------------------------------------------|
| **Rule ID**              | BR-001                                                              |
| **Rule Name**            | Street Address Required                                             |
| **Category**             | Validation                                                          |
| **Severity**             | Major                                                               |
| **Business Domain**      | FUS Score Request Processing                                        |
| **Description**          | The street address field must not be null or blank in FUS score requests |
| **Source Location**      | FusRequestPreProcessor.java / FusFullResRequestPreProcessor.java    |
| **Source Line(s)**        | process() method                                                   |
| **Trigger/Condition**    | Incoming FUS score request (REST or SOAP)                           |
| **Input(s)**             | streetName field from FusRequest / FusProductRequest                |
| **Output(s)/Action**     | Throws ResponseError with code FS1001 if blank                     |
| **Exception Handling**   | ErrorProcessor catches ResponseError → returns HTTP 400 / SOAP Fault |
| **Client Validated**     | 🟡 Pending                                                         |
| **Client Comments**      | —                                                                   |
| **Dead Code Flag**       | No                                                                  |
| **Hardcoded Flag**       | No — error code FS1001 referenced from error_messages.json          |
| **Execution Priority**   | 1 (first validation in sequence)                                    |

#### Rule Logic (Pseudocode)

```
IF streetName IS NULL OR streetName IS BLANK THEN
    THROW ResponseError(code="FS1001", message="Street Address field is blank")
END IF
```

#### Rule Logic (Source Code Reference)

```java
// File: FusRequestPreProcessor.java
// Method: process(Exchange exchange)
if (fusReq.getStreetName() == null || fusReq.getStreetName().trim().isEmpty()) {
    throw new ResponseError("FS1001", DataCache.getInstance().getErrorLookup().get("FS1001").getErrorDesc());
}
```

#### Related Entities

| **Entity**                | **Relationship**                                           |
|---------------------------|------------------------------------------------------------|
| FusProductRequest         | Source of streetName field (REST)                           |
| DwellingFireProtectionRequest | Source of streetName field (SOAP)                      |
| error_messages.json       | Provides error description for FS1001                      |

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Component                 | COMP-004 (Request Processing Pipeline)        |

---

### 3.2 BR-002: Postal Code Required

| **Attribute**            | **Details**                                                         |
|--------------------------|---------------------------------------------------------------------|
| **Rule ID**              | BR-002                                                              |
| **Rule Name**            | Postal Code Required                                                |
| **Category**             | Validation                                                          |
| **Severity**             | Major                                                               |
| **Business Domain**      | FUS Score Request Processing                                        |
| **Description**          | The postal code field must not be null or blank in FUS score requests |
| **Source Location**      | FusRequestPreProcessor.java / FusFullResRequestPreProcessor.java    |
| **Source Line(s)**        | process() method                                                   |
| **Trigger/Condition**    | Incoming FUS score request                                          |
| **Input(s)**             | postalCode field from FusRequest / FusProductRequest                |
| **Output(s)/Action**     | Throws ResponseError with code FS1002 if blank                     |
| **Exception Handling**   | ErrorProcessor catches ResponseError → returns HTTP 400 / SOAP Fault |
| **Client Validated**     | 🟡 Pending                                                         |
| **Client Comments**      | —                                                                   |
| **Dead Code Flag**       | No                                                                  |
| **Hardcoded Flag**       | No                                                                  |
| **Execution Priority**   | 2 (after street address)                                            |

#### Rule Logic (Pseudocode)

```
IF postalCode IS NULL OR postalCode IS BLANK THEN
    THROW ResponseError(code="FS1002", message="Postal Code field is blank")
END IF
```

#### Related Entities

| **Entity**                | **Relationship**                                |
|---------------------------|-------------------------------------------------|
| FusProductRequest         | Source of postalCode field (REST)                |
| DwellingFireProtectionRequest | Source of postalCode field (SOAP)            |

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Component                 | COMP-004 (Request Processing Pipeline)        |

---

### 3.3 BR-003: Municipality Required

| **Attribute**            | **Details**                                                         |
|--------------------------|---------------------------------------------------------------------|
| **Rule ID**              | BR-003                                                              |
| **Rule Name**            | Municipality Required                                               |
| **Category**             | Validation                                                          |
| **Severity**             | Major                                                               |
| **Business Domain**      | FUS Score Request Processing                                        |
| **Description**          | The municipality field must not be null or blank in FUS score requests |
| **Source Location**      | FusRequestPreProcessor.java / FusFullResRequestPreProcessor.java    |
| **Source Line(s)**        | process() method                                                   |
| **Trigger/Condition**    | Incoming FUS score request                                          |
| **Input(s)**             | municipality field from FusRequest / FusProductRequest              |
| **Output(s)/Action**     | Throws ResponseError with code FS1003 if blank                     |
| **Exception Handling**   | ErrorProcessor catches ResponseError → returns HTTP 400 / SOAP Fault |
| **Client Validated**     | 🟡 Pending                                                         |
| **Client Comments**      | —                                                                   |
| **Dead Code Flag**       | No                                                                  |
| **Hardcoded Flag**       | No                                                                  |
| **Execution Priority**   | 3 (after postal code)                                               |

#### Rule Logic (Pseudocode)

```
IF municipality IS NULL OR municipality IS BLANK THEN
    THROW ResponseError(code="FS1003", message="Municipality field is blank")
END IF
```

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Component                 | COMP-004 (Request Processing Pipeline)        |

---

### 3.4 BR-004: Province Required

| **Attribute**            | **Details**                                                         |
|--------------------------|---------------------------------------------------------------------|
| **Rule ID**              | BR-004                                                              |
| **Rule Name**            | Province Required                                                   |
| **Category**             | Validation                                                          |
| **Severity**             | Major                                                               |
| **Business Domain**      | FUS Score Request Processing                                        |
| **Description**          | The province field must not be null or blank in FUS score requests   |
| **Source Location**      | FusAuthorizationProcessor.java / FusFullResAuthorizationProcessor.java |
| **Source Line(s)**        | process() method                                                   |
| **Trigger/Condition**    | Incoming FUS score request (checked before other validations)       |
| **Input(s)**             | province field from FusRequest / FusProductRequest                  |
| **Output(s)/Action**     | Throws ResponseError with code FS1004 if blank                     |
| **Exception Handling**   | ErrorProcessor catches ResponseError → returns HTTP 400 / SOAP Fault |
| **Client Validated**     | 🟡 Pending                                                         |
| **Client Comments**      | —                                                                   |
| **Dead Code Flag**       | No                                                                  |
| **Hardcoded Flag**       | Yes — error code FS1004 hardcoded in processor                      |
| **Execution Priority**   | 0 (first check in authorization processor, before BR-001-003)       |

#### Rule Logic (Pseudocode)

```
IF province IS NULL OR province IS BLANK THEN
    THROW ResponseError(code="FS1004", message="Province field is blank")
END IF
```

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Component                 | COMP-004 (Request Processing Pipeline)        |

---

### 3.5 BR-005: Province Authorization Check

| **Attribute**            | **Details**                                                                    |
|--------------------------|--------------------------------------------------------------------------------|
| **Rule ID**              | BR-005                                                                         |
| **Rule Name**            | Province Authorization Check                                                   |
| **Category**             | Authorization                                                                  |
| **Severity**             | Critical                                                                       |
| **Business Domain**      | FUS Score Access Control                                                       |
| **Description**          | The requested province must be in the list of provinces authorized for the calling user. The province is checked against a comma-separated list of supported provinces. |
| **Source Location**      | FusAuthorizationProcessor.java / FusFullResAuthorizationProcessor.java          |
| **Source Line(s)**        | process() method, isProvincePresent() method                                  |
| **Trigger/Condition**    | After province is confirmed non-blank (BR-004)                                |
| **Input(s)**             | province (from request), provinceIds (from config — SUPPORTED_PROVINCE_LIST)  |
| **Output(s)/Action**     | Throws ResponseError with code FS1005 if province not in authorized list      |
| **Exception Handling**   | ErrorProcessor maps FS1005 → HTTP 403 Forbidden                               |
| **Client Validated**     | 🟡 Pending                                                                    |
| **Client Comments**      | —                                                                              |
| **Dead Code Flag**       | No                                                                             |
| **Hardcoded Flag**       | Yes — error code FS1005 and message hardcoded in processor constants           |
| **Execution Priority**   | 1 (after BR-004 province blank check)                                          |

#### Rule Logic (Pseudocode)

```
IF province NOT IN provinceIds (SUPPORTED_PROVINCE_LIST) THEN
    THROW ResponseError(code="FS1005", message="Provided Province is not authorized to view operation.")
END IF
```

#### Rule Logic (Source Code Reference)

```java
// File: FusAuthorizationProcessor.java
// Method: process(Exchange exchange)
if (!isProvincePresent(provinceIds, province)) {
    throw new ResponseError(UNAUTHORISED, CONST_AUTH_ERROR);
}

// Method: isProvincePresent(String provinceList, String province)
// Splits provinceList by comma and checks if province exists in the list
```

#### Related Entities

| **Entity**                | **Relationship**                                           |
|---------------------------|------------------------------------------------------------|
| app_config.properties     | SUPPORTED_PROVINCE_LIST provides authorized provinces      |
| authorization_config.json | Per-user province authorization (loaded into DataCache)    |
| DataCache                 | Runtime lookup for user→province mappings                  |

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Component                 | COMP-004 (Request Processing Pipeline)        |

---

### 3.6 BR-006: Role-Based Access Control

| **Attribute**            | **Details**                                                                    |
|--------------------------|--------------------------------------------------------------------------------|
| **Rule ID**              | BR-006                                                                         |
| **Rule Name**            | Role-Based Access Control                                                      |
| **Category**             | Authorization                                                                  |
| **Severity**             | Major                                                                          |
| **Business Domain**      | FUS Score Access Control                                                       |
| **Description**          | Users must have the LDAP role `eEsbPlApiOptaAccess` to invoke the getFusScore operation |
| **Source Location**      | blueprint.xml (SimpleAuthorizingInterceptor configuration)                     |
| **Source Line(s)**        | authorizationInterceptor bean definition                                      |
| **Trigger/Condition**    | Every incoming REST or SOAP request (after LDAP authentication)               |
| **Input(s)**             | User principal's LDAP roles                                                    |
| **Output(s)/Action**     | HTTP 403 Forbidden if role not present                                         |
| **Exception Handling**   | CXF interceptor returns authorization error before Camel route is reached     |
| **Client Validated**     | 🟡 Pending                                                                    |
| **Client Comments**      | —                                                                              |
| **Dead Code Flag**       | No                                                                             |
| **Hardcoded Flag**       | Yes — role name hardcoded in blueprint.xml                                     |
| **Execution Priority**   | 0 (enforced at CXF interceptor level, before Camel route)                      |

#### Rule Logic (Pseudocode)

```
IF user DOES NOT HAVE role "eEsbPlApiOptaAccess" THEN
    RETURN HTTP 403 Forbidden
END IF
```

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Component                 | COMP-010 (OSGi Blueprint Configuration)       |

---

### 3.7 BR-007: LDAP Authentication

| **Attribute**            | **Details**                                                                    |
|--------------------------|--------------------------------------------------------------------------------|
| **Rule ID**              | BR-007                                                                         |
| **Rule Name**            | LDAP Authentication                                                            |
| **Category**             | Authorization                                                                  |
| **Severity**             | Major                                                                          |
| **Business Domain**      | FUS Score Access Control                                                       |
| **Description**          | All requests must be authenticated against LDAP. REST uses HTTP Basic Auth; SOAP uses WS-Security UsernameToken. |
| **Source Location**      | blueprint.xml (JAASAuthenticationFilter, JAASLoginInterceptor)                 |
| **Source Line(s)**        | authenticationFilter and soapAuthenticationInterceptor bean definitions        |
| **Trigger/Condition**    | Every incoming REST or SOAP request                                            |
| **Input(s)**             | Username + Password (Basic Auth header or WS-Security UsernameToken)           |
| **Output(s)/Action**     | HTTP 401 Unauthorized if credentials invalid                                   |
| **Exception Handling**   | CXF returns authentication error before Camel route is reached                 |
| **Client Validated**     | 🟡 Pending                                                                    |
| **Client Comments**      | —                                                                              |
| **Dead Code Flag**       | No                                                                             |
| **Hardcoded Flag**       | No — JAAS LoginModule name configured via LDAP_LOGIN property                  |
| **Execution Priority**   | 0 (first step in request processing)                                           |

#### Rule Logic (Pseudocode)

```
IF credentials NOT PROVIDED THEN
    RETURN HTTP 401 Unauthorized
END IF

Validate credentials against LDAP directory via JAAS LoginModule

IF authentication FAILS THEN
    RETURN HTTP 401 Unauthorized
END IF
```

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Component                 | COMP-010 (OSGi Blueprint Configuration)       |

---

### 3.8 BR-008: Error Code to HTTP Status Mapping

| **Attribute**            | **Details**                                                                    |
|--------------------------|--------------------------------------------------------------------------------|
| **Rule ID**              | BR-008                                                                         |
| **Rule Name**            | Error Code to HTTP Status Mapping                                              |
| **Category**             | Decision                                                                       |
| **Severity**             | Major                                                                          |
| **Business Domain**      | Error Response Handling                                                        |
| **Description**          | Error codes are mapped to specific HTTP status codes for REST responses. FS1005 maps to 403 (Forbidden), FS3001 and FS7001 map to 500 (Internal Server Error), all other codes map to 400 (Bad Request). |
| **Source Location**      | ErrorProcessor.java                                                            |
| **Source Line(s)**        | process() method                                                              |
| **Trigger/Condition**    | Any exception caught during request processing                                 |
| **Input(s)**             | Error code (from ResponseError or mapped from exception)                       |
| **Output(s)/Action**     | HTTP response with appropriate status code and error body                      |
| **Exception Handling**   | Unknown exceptions default to FS2001                                           |
| **Client Validated**     | 🟡 Pending                                                                    |
| **Client Comments**      | —                                                                              |
| **Dead Code Flag**       | No                                                                             |
| **Hardcoded Flag**       | Yes — status code mappings hardcoded in processor                              |
| **Execution Priority**   | N/A (triggered by exception)                                                   |

#### Rule Logic (Pseudocode)

```
SWITCH errorCode:
    CASE "FS1005":
        httpStatus = 403 (Forbidden)
    CASE "FS3001", "FS7001":
        httpStatus = 500 (Internal Server Error)
    DEFAULT:
        httpStatus = 400 (Bad Request)
END SWITCH
```

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Component                 | COMP-004 (Request Processing Pipeline)        |

---

### 3.9 BR-009: SOAP Fault Conversion

| **Attribute**            | **Details**                                                                    |
|--------------------------|--------------------------------------------------------------------------------|
| **Rule ID**              | BR-009                                                                         |
| **Rule Name**            | SOAP Fault Conversion                                                          |
| **Category**             | Decision                                                                       |
| **Severity**             | Major                                                                          |
| **Business Domain**      | Error Response Handling                                                        |
| **Description**          | For SOAP endpoints, errors are converted to SOAPServiceException with fault code and message |
| **Source Location**      | ErrorProcessor.java — convertToSoapFault(), returnSoapResponse() methods       |
| **Source Line(s)**        | convertToSoapFault() and returnSoapResponse() methods                         |
| **Trigger/Condition**    | Exception during SOAP route processing                                         |
| **Input(s)**             | ErrorDetails (code + message)                                                  |
| **Output(s)/Action**     | Throws SOAPServiceException with fault details                                 |
| **Exception Handling**   | SOAPServiceException is returned to client as SOAP Fault                       |
| **Client Validated**     | 🟡 Pending                                                                    |
| **Client Comments**      | —                                                                              |
| **Dead Code Flag**       | No                                                                             |
| **Hardcoded Flag**       | No                                                                             |
| **Execution Priority**   | N/A (triggered by exception in SOAP route)                                     |

#### Rule Logic (Pseudocode)

```
IF endpoint IS SOAP THEN
    Convert ErrorDetails to SOAPServiceException
    THROW SOAPServiceException(faultCode, faultMessage)
ELSE
    Return JSON ErrorDetails with HTTP status
END IF
```

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Component                 | COMP-004 (Request Processing Pipeline)        |

---

### 3.10 BR-010: Default Unknown Error Handling

| **Attribute**            | **Details**                                                                    |
|--------------------------|--------------------------------------------------------------------------------|
| **Rule ID**              | BR-010                                                                         |
| **Rule Name**            | Default Unknown Error Handling                                                 |
| **Category**             | Decision                                                                       |
| **Severity**             | Critical                                                                       |
| **Business Domain**      | Error Response Handling                                                        |
| **Description**          | Any unrecognized exception is mapped to error code FS2001 ("Technical Error Occurred. Please contact Technical Team.") |
| **Source Location**      | ErrorProcessor.java                                                            |
| **Source Line(s)**        | process() method — UNKNOWN_ERR_CD constant                                    |
| **Trigger/Condition**    | Any exception that is not a ResponseError with a known code                    |
| **Input(s)**             | Exception (any type)                                                           |
| **Output(s)/Action**     | Error response with code FS2001 and generic message                            |
| **Exception Handling**   | This IS the catch-all handler                                                  |
| **Client Validated**     | 🟡 Pending                                                                    |
| **Client Comments**      | —                                                                              |
| **Dead Code Flag**       | No                                                                             |
| **Hardcoded Flag**       | Yes — FS2001 hardcoded as UNKNOWN_ERR_CD constant                              |
| **Execution Priority**   | Last (fallback)                                                                |

#### Rule Logic (Pseudocode)

```
IF exception IS NOT ResponseError THEN
    errorCode = "FS2001"
    errorMessage = lookup("FS2001") from DataCache
    RETURN error response
END IF
```

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Component                 | COMP-004 (Request Processing Pipeline)        |

---

### 3.11 BR-011: Request ID Generation

| **Attribute**            | **Details**                                                                    |
|--------------------------|--------------------------------------------------------------------------------|
| **Rule ID**              | BR-011                                                                         |
| **Rule Name**            | Request ID Generation                                                          |
| **Category**             | Computation                                                                    |
| **Severity**             | Minor                                                                          |
| **Business Domain**      | OPTA Service Integration                                                       |
| **Description**          | A unique request ID is generated for each OPTA service call using a configurable prefix + UUID |
| **Source Location**      | FusAuthRequestProcessor.java / FusFullResAuthRequestProcessor.java             |
| **Source Line(s)**        | process() method                                                              |
| **Trigger/Condition**    | Building OSSRequestType for OPTA call                                          |
| **Input(s)**             | FUS_REQUESTID_PREFIX (from config), UUID.randomUUID()                          |
| **Output(s)/Action**     | RequestID set in OSSRequestType header                                         |
| **Exception Handling**   | N/A                                                                            |
| **Client Validated**     | 🟡 Pending                                                                    |
| **Client Comments**      | —                                                                              |
| **Dead Code Flag**       | No                                                                             |
| **Hardcoded Flag**       | No — prefix configured via FUS_REQUESTID_PREFIX property                       |
| **Execution Priority**   | N/A                                                                            |

#### Rule Logic (Pseudocode)

```
requestId = FUS_REQUESTID_PREFIX + UUID.randomUUID().toString()
ossRequest.header.requestId = requestId
```

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Component                 | COMP-004 (Request Processing Pipeline)        |

---

### 3.12 BR-012: Cache Key Derivation

| **Attribute**            | **Details**                                                                    |
|--------------------------|--------------------------------------------------------------------------------|
| **Rule ID**              | BR-012                                                                         |
| **Rule Name**            | Cache Key Derivation                                                           |
| **Category**             | Computation                                                                    |
| **Severity**             | Minor                                                                          |
| **Business Domain**      | Response Caching                                                               |
| **Description**          | Cache key is derived as a hash of address fields + industry codes to enable response caching |
| **Source Location**      | FusAuthRequestProcessor.java / FusFullResAuthRequestProcessor.java             |
| **Source Line(s)**        | process() method                                                              |
| **Trigger/Condition**    | Building request for OPTA service                                              |
| **Input(s)**             | streetName, postalCode, municipality, province, ibcCode, naicsCode, sicCode    |
| **Output(s)/Action**     | Hash string set as EhCache key                                                 |
| **Exception Handling**   | N/A                                                                            |
| **Client Validated**     | 🟡 Pending                                                                    |
| **Client Comments**      | —                                                                              |
| **Dead Code Flag**       | No                                                                             |
| **Hardcoded Flag**       | No                                                                             |
| **Execution Priority**   | N/A                                                                            |

#### Rule Logic (Pseudocode)

```
cacheKey = hash(streetName + postalCode + municipality + province + ibcCode + naicsCode + sicCode)
exchange.setProperty("CacheKey", cacheKey)
```

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Component                 | COMP-004 (Request Processing Pipeline)        |

---

### 3.13 BR-013: OAuth Token Acquisition

| **Attribute**            | **Details**                                                                    |
|--------------------------|--------------------------------------------------------------------------------|
| **Rule ID**              | BR-013                                                                         |
| **Rule Name**            | OAuth Token Acquisition                                                        |
| **Category**             | Workflow                                                                       |
| **Severity**             | Major                                                                          |
| **Business Domain**      | OPTA Service Authentication                                                    |
| **Description**          | Before calling OPTA, a Bearer token must be obtained via OAuth2 refresh_token grant |
| **Source Location**      | FusAuthServiceProcessor.java, blueprint.xml (route_oss_security_token)         |
| **Source Line(s)**        | process() method; route definition                                            |
| **Trigger/Condition**    | Every OPTA service call (no token caching)                                     |
| **Input(s)**             | FUS_AUTH_TOKEN (refresh token), FUS_CLIENT_ID, FUS_CLIENT_SECRET, FUS_GRANT_TYPE |
| **Output(s)/Action**     | Bearer access_token stored in Camel Exchange                                   |
| **Exception Handling**   | Auth failure → ErrorProcessor → error response                                 |
| **Client Validated**     | 🟡 Pending                                                                    |
| **Client Comments**      | —                                                                              |
| **Dead Code Flag**       | No                                                                             |
| **Hardcoded Flag**       | Yes — client_secret in config (not fully vaulted)                              |
| **Execution Priority**   | Must complete before OPTA call                                                 |

#### Rule Logic (Pseudocode)

```
POST to FUS_AUTH_ENDPOINT_URL:
    grant_type = refresh_token
    client_id = FUS_CLIENT_ID
    client_secret = FUS_CLIENT_SECRET
    refresh_token = FUS_AUTH_TOKEN

bearerToken = response.access_token
exchange.setProperty("BearerToken", bearerToken)
```

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Component                 | COMP-004 (Request Processing Pipeline)        |

---

### 3.14 BR-014: Transaction Logging

| **Attribute**            | **Details**                                                                    |
|--------------------------|--------------------------------------------------------------------------------|
| **Rule ID**              | BR-014                                                                         |
| **Rule Name**            | Transaction Logging                                                            |
| **Category**             | Workflow                                                                       |
| **Severity**             | Major                                                                          |
| **Business Domain**      | Audit & Compliance                                                             |
| **Description**          | Every FUS request/response must be logged asynchronously to the transaction database |
| **Source Location**      | TransactionLogger.java, blueprint.xml (wireTap)                                |
| **Source Line(s)**        | logTransaction(), logPayLoad() methods                                        |
| **Trigger/Condition**    | After response is sent to client (wireTap in Camel route)                      |
| **Input(s)**             | Camel Exchange properties (transactionId, application, url, clientInfo, address, req/res payloads, status) |
| **Output(s)/Action**     | INSERT into cl_fus_trans_log table (17 columns)                                |
| **Exception Handling**   | Async — failures are logged but do not affect response                         |
| **Client Validated**     | 🟡 Pending                                                                    |
| **Client Comments**      | —                                                                              |
| **Dead Code Flag**       | No                                                                             |
| **Hardcoded Flag**       | No                                                                             |
| **Execution Priority**   | Post-response (async)                                                          |

#### Rule Logic (Pseudocode)

```
ASYNC:
    Extract transaction details from Camel Exchange properties
    Convert request/response objects to XML via JAXB
    INSERT INTO cl_fus_trans_log VALUES (transactionId, application, url, ...)
```

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Component                 | COMP-006 (Transaction Logging)                |

---

### 3.15 BR-015: OPTA Request Default Values

| **Attribute**            | **Details**                                                                    |
|--------------------------|--------------------------------------------------------------------------------|
| **Rule ID**              | BR-015                                                                         |
| **Rule Name**            | OPTA Request Default Values                                                    |
| **Category**             | Derivation                                                                     |
| **Severity**             | Minor                                                                          |
| **Business Domain**      | OPTA Service Integration                                                       |
| **Description**          | OPTA requests are populated with default requestor values: brokerage, carrier, and username from configuration |
| **Source Location**      | FusAuthRequestProcessor.java / FusFullResAuthRequestProcessor.java             |
| **Source Line(s)**        | process() method                                                              |
| **Trigger/Condition**    | Building OSSRequestType for OPTA call                                          |
| **Input(s)**             | FUS_DEFAULT_BROKERAGE, FUS_DEFAULT_CARRIER, FUS_DEFAULT_USERNAME (from config) |
| **Output(s)/Action**     | Requestor fields set in OSSRequestType header                                  |
| **Exception Handling**   | N/A                                                                            |
| **Client Validated**     | 🟡 Pending                                                                    |
| **Client Comments**      | —                                                                              |
| **Dead Code Flag**       | No                                                                             |
| **Hardcoded Flag**       | No — values from config (though username is encrypted)                         |
| **Execution Priority**   | N/A                                                                            |

#### Rule Logic (Pseudocode)

```
ossRequest.header.requestor.brokerage = FUS_DEFAULT_BROKERAGE  // "ABC Brokerage"
ossRequest.header.requestor.carrier = FUS_DEFAULT_CARRIER      // "Aviva"
ossRequest.header.requestor.username = FUS_DEFAULT_USERNAME     // ENC(...)
```

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Component                 | COMP-004 (Request Processing Pipeline)        |

---

### 3.16 BR-016: Connection Timeout Constraint

| **Attribute**            | **Details**                                                                    |
|--------------------------|--------------------------------------------------------------------------------|
| **Rule ID**              | BR-016                                                                         |
| **Rule Name**            | Connection Timeout Constraint                                                  |
| **Category**             | Constraint                                                                     |
| **Severity**             | Major                                                                          |
| **Business Domain**      | OPTA Service Integration                                                       |
| **Description**          | OPTA service calls must complete within configured timeout limits (30 seconds for both connection and receive) |
| **Source Location**      | blueprint.xml (HTTP conduit configuration)                                     |
| **Source Line(s)**        | conduit configuration                                                         |
| **Trigger/Condition**    | Every outbound call to OPTA service                                            |
| **Input(s)**             | FUS_CONNECTION_TIMEOUT (30000ms), FUS_RECEIVE_TIMEOUT (30000ms)                |
| **Output(s)/Action**     | Connection times out after 30s; request fails with timeout exception           |
| **Exception Handling**   | Timeout exception → ErrorProcessor → error response                            |
| **Client Validated**     | 🟡 Pending                                                                    |
| **Client Comments**      | —                                                                              |
| **Dead Code Flag**       | No                                                                             |
| **Hardcoded Flag**       | No — values from config (though value is static 30000)                         |
| **Execution Priority**   | N/A                                                                            |

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Component                 | COMP-010 (OSGi Blueprint Configuration)       |

---

### 3.17 BR-017: Logging Helper Data Extraction

| **Attribute**            | **Details**                                                                    |
|--------------------------|--------------------------------------------------------------------------------|
| **Rule ID**              | BR-017                                                                         |
| **Rule Name**            | Logging Helper Data Extraction                                                 |
| **Category**             | Notification                                                                   |
| **Severity**             | Minor                                                                          |
| **Business Domain**      | Audit & Compliance                                                             |
| **Description**          | Authorization processor extracts request details into Camel Exchange properties for downstream logging |
| **Source Location**      | FusAuthorizationProcessor.java — fusLoggingHelper() method                     |
| **Source Line(s)**        | fusLoggingHelper() method                                                     |
| **Trigger/Condition**    | During authorization processing                                                |
| **Input(s)**             | FusRequest (transactionId, URL, clientInfo, address fields)                    |
| **Output(s)/Action**     | Exchange properties set for TransactionLogger consumption                      |
| **Exception Handling**   | N/A                                                                            |
| **Client Validated**     | 🟡 Pending                                                                    |
| **Client Comments**      | —                                                                              |
| **Dead Code Flag**       | No                                                                             |
| **Hardcoded Flag**       | No                                                                             |
| **Execution Priority**   | During authorization step                                                      |

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Component                 | COMP-004 (Request Processing Pipeline)        |

---

## 4. Validation Rules

| **Rule ID** | **Rule Name**              | **Field/Entity**  | **Validation Logic**                  | **Validation Exists in Source** | **Error Message**                  |
|-------------|----------------------------|--------------------|---------------------------------------|--------------------------------|-------------------------------------|
| BR-001      | Street Address Required    | streetName         | Not null, not blank                   | ✅ Yes                          | Street Address field is blank       |
| BR-002      | Postal Code Required       | postalCode         | Not null, not blank                   | ✅ Yes                          | Postal Code field is blank          |
| BR-003      | Municipality Required      | municipality       | Not null, not blank                   | ✅ Yes                          | Municipality field is blank         |
| BR-004      | Province Required          | province           | Not null, not blank                   | ✅ Yes                          | Province field is blank             |

---

## 5. Computation Rules

| **Rule ID** | **Rule Name**             | **Formula/Logic**                                         | **Inputs**                | **Output**   | **Hardcoded Override**   |
|-------------|---------------------------|-----------------------------------------------------------|---------------------------|--------------|--------------------------|
| BR-011      | Request ID Generation     | FUS_REQUESTID_PREFIX + UUID.randomUUID()                  | prefix config             | requestId    | None                     |
| BR-012      | Cache Key Derivation      | hash(streetName + postalCode + municipality + ...)        | 7 address/industry fields | cacheKey     | None                     |

---

## 6. Decision Rules (Decision Tables)

### 6.1 Decision Table: Error Code to HTTP Status

**Rule ID:** BR-008
**Description:** Maps FUS error codes to HTTP response status codes

| **Error Code** | **Error Category**     | **HTTP Status**           |
|----------------|------------------------|---------------------------|
| FS1001         | Validation (Street)    | 400 (Bad Request)         |
| FS1002         | Validation (PostalCode)| 400 (Bad Request)         |
| FS1003         | Validation (Municipality)| 400 (Bad Request)       |
| FS1004         | Validation (Province)  | 400 (Bad Request)         |
| FS1005         | Authorization          | 403 (Forbidden)           |
| FS2001         | Technical Error        | 400 (Bad Request)         |
| FS3001         | OPTA Service Error     | 500 (Internal Server Error)|
| FS7001         | OPTA Service Error     | 500 (Internal Server Error)|

---

## 7. Workflow / State Transition Rules

### 7.1 State Machine: FUS Request Processing

**Related Rule IDs:** BR-007, BR-005, BR-006, BR-001-004, BR-013, BR-014

| **Current State**    | **Event/Trigger**                 | **Condition(s)**               | **Next State**         | **Action(s)**                         |
|----------------------|-----------------------------------|--------------------------------|------------------------|---------------------------------------|
| Received             | LDAP Authentication               | Credentials valid              | Authenticated          | Set user principal                    |
| Received             | LDAP Authentication               | Credentials invalid            | Rejected               | Return 401                            |
| Authenticated        | Role Check                        | Has eEsbPlApiOptaAccess        | Authorized             | Continue to route                     |
| Authenticated        | Role Check                        | Missing role                   | Rejected               | Return 403                            |
| Authorized           | Province Check                    | Province in allowed list       | Validated              | Extract logging properties            |
| Authorized           | Province Check                    | Province blank or unauthorized | Rejected               | Return 400/403 with error code        |
| Validated            | Input Validation                  | All required fields present    | Ready                  | Continue to OPTA call                 |
| Validated            | Input Validation                  | Missing required field         | Rejected               | Return 400 with error code            |
| Ready                | OAuth Token                       | Token obtained                 | Token Acquired         | Store Bearer token                    |
| Ready                | OAuth Token                       | Token failure                  | Error                  | Return 500                            |
| Token Acquired       | OPTA Call                         | Success                        | Response Received      | Process OPTA response                 |
| Token Acquired       | OPTA Call                         | Timeout / Error                | Error                  | Return 500                            |
| Response Received    | Response Transform                | Success                        | Complete               | Return response; async log            |

---

## 8. Authorization Rules

| **Rule ID** | **Resource/Action**     | **Required Role(s)**       | **Additional Conditions**              |
|-------------|-------------------------|----------------------------|----------------------------------------|
| BR-006      | getFusScore (any endpoint)| eEsbPlApiOptaAccess       | Must also pass province check (BR-005) |
| BR-005      | Province data access     | N/A                        | Province must be in SUPPORTED_PROVINCE_LIST |

---

## 9. Unresolved / Ambiguous Rules

| **Rule ID** | **Description**                                         | **Ambiguity**                                                  | **Recommended Action**            |
|-------------|----------------------------------------------------------|----------------------------------------------------------------|-----------------------------------|
| —           | WS-Security token validation disabled                    | Unclear if intentional for all environments or only QA/dev     | SME review — confirm if production also disables validation |
| —           | OAuth token obtained per-request (no caching)            | Unclear if this is by design or performance was not considered | SME review — confirm token caching requirements |
| —           | French error messages (errorDesc_fr) all empty           | Unclear if i18n is planned or abandoned                        | SME review — confirm i18n requirements |

---

## 10. Notes & Observations

| **#** | **Observation**                                                              | **Related Rules** | **Impact**    |
|-------|------------------------------------------------------------------------------|-------------------|---------------|
| 1     | No format validation (postal code pattern, province ISO code, etc.)          | BR-001 to BR-004  | Data quality  |
| 2     | Hardcoded error codes in processors duplicate error_messages.json            | BR-005, BR-010    | Maintainability |
| 3     | Processor logic duplicated between standard and FullRes variants             | All               | Maintenance   |
| 4     | Transaction logging is async with no retry — log records could be lost       | BR-014            | Compliance    |

---

## 11. Potentially Missing Business Rules

| **#** | **Expected Rule Description**           | **Business Domain** | **Expected Category** | **Found in Code?** | **Evidence of Absence**                                               | **Severity** | **Recommended Action**                    | **Linked Gap** |
|-------|------------------------------------------|---------------------|-----------------------|--------------------|-----------------------------------------------------------------------|--------------|-------------------------------------------|----------------|
| 1     | Postal code format validation (A1A1A1)   | Input Validation    | Validation            | ❌ No              | Only null/blank check; no regex pattern validation                    | High         | Implement format check in target          | —              |
| 2     | Province code validation (2-letter ISO)  | Input Validation    | Validation            | ❌ No              | Province checked against allowed list, but no format validation       | Medium       | Add valid province code enum              | —              |
| 3     | Input length limits                      | Input Validation    | Constraint            | ❌ No              | No @Size or length checks on any field                                | Medium       | Add max-length constraints                | —              |
| 4     | Rate limiting                            | Access Control      | Constraint            | ❌ No              | No rate limiting mechanism found                                      | High         | Implement at API gateway or service level | —              |
| 5     | OAuth token caching/reuse                | Performance         | Workflow              | ❌ No              | New token obtained for every request                                  | Medium       | Cache tokens with TTL                     | —              |
| 6     | Response caching invalidation            | Performance         | Workflow              | ❌ No              | EhCache configured but no invalidation/TTL policy visible             | Low          | Define cache eviction strategy            | —              |

---

## 12. Rule Execution Order & Conflicts

### 12.1 Rule Execution Chains

| **Trigger / Input Context**             | **Rule Execution Order**                                          | **Notes**                     |
|-----------------------------------------|-------------------------------------------------------------------|-------------------------------|
| REST FUS score request                  | BR-007 → BR-006 → BR-004 → BR-005 → BR-001 → BR-002 → BR-003 → BR-013 → BR-011 → BR-012 → BR-015 → BR-016 → BR-008/BR-009/BR-010 (on error) → BR-014 | Sequential                    |
| SOAP FUS score request                  | BR-007 → BR-006 → BR-004 → BR-005 → BR-001 → BR-002 → BR-003 → BR-013 → BR-011 → BR-012 → BR-015 → BR-016 → BR-009 (on error) → BR-014 | Sequential                    |

### 12.2 Rule Conflicts

| **Rule A** | **Rule B** | **Conflict Description**                                          | **Resolution**                                     | **Status**  |
|------------|------------|-------------------------------------------------------------------|----------------------------------------------------|-------------|
| —          | —          | No rule conflicts identified                                      | —                                                  | —           |

---

## 13. Appendices

### Appendix A: Rule ID Naming Convention

Format: BR-[NNN] where NNN is a sequential number.

| **Range** | **Category**        |
|-----------|---------------------|
| 001-004   | Input Validation    |
| 005-007   | Authorization       |
| 008-010   | Error Handling      |
| 011-012   | Computation         |
| 013-014   | Workflow            |
| 015       | Derivation          |
| 016       | Constraint          |
| 017       | Notification        |

### Appendix B: Glossary

| **Term**     | **Definition**                                                        |
|--------------|-----------------------------------------------------------------------|
| FUS          | Fire Underwriting Score                                                |
| OPTA         | Property risk data provider                                           |
| Province     | Canadian province code (e.g., ON, BC, AB)                             |
| ResponseError| Custom exception class with error code and message                    |
| wireTap      | Camel EIP for asynchronous message copying                            |

---

> **Document Control:**
> | Version | Date | Author | Changes |
> |---------|------|--------|---------|
> | 0.1 | 01-Apr-2026 | Copilot | Initial draft |
