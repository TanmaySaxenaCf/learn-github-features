# Business Rules Catalog

---

| **Field**            | **Details**                                   |
|----------------------|-----------------------------------------------|
| **Project Name**     | Catalyst ESB — OPTA FUS Service               |
| **Application Name** | sb-esb-fus                                    |
| **Version**          | 1.0.0                                         |
| **Date**             | 26-Jun-2025                                   |
| **Prepared By**      | Copilot RE Pipeline                           |
| **Reviewed By**      | Pending                                       |
| **Status**           | Draft                                         |

---

## 1. Overview

This catalog documents all business rules identified during reverse engineering of the **sb-esb-fus** application — a JBoss Fuse 6.3 / Apache Camel OSGi bundle that exposes OPTA Single Service (Dwelling Fire Protection scoring) as SOAP and REST endpoints. The service validates incoming requests, authorizes province access, acquires OAuth tokens, calls the external OPTA Single Service, maps the response, and logs every transaction to an Oracle database.

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
| Validation         | 5         | 0            | 4         | 1         |
| Computation        | 1         | 0            | 1         | 0         |
| Decision           | 4         | 1            | 2         | 1         |
| Authorization      | 2         | 2            | 0         | 0         |
| Workflow           | 3         | 1            | 2         | 0         |
| Constraint         | 1         | 0            | 0         | 1         |
| Derivation         | 2         | 0            | 2         | 0         |
| Notification       | 0         | 0            | 0         | 0         |
| **Total**          | **18**    | **4**        | **11**    | **3**     |

### 2.1 Rule Health Summary

| **Status**                            | **Count** | **Percentage** |
|---------------------------------------|-----------|----------------|
| ✅ Active & Validated by Client        | 0         | 0%             |
| 🟡 Active & Pending Client Validation | 14        | 78%            |
| ❌ Client Identified as Incorrect      | 0         | 0%             |
| ⚫ Dead Code Rule                      | 1         | 5.5%           |
| ⚪ Hardcoded / Bypassed Rule           | 3         | 16.5%          |

---

## 3. Business Rules Detail

### 3.1 BR-001: Province Authorization — SOAP Flow

| **Attribute**            | **Details**                                              |
|--------------------------|----------------------------------------------------------|
| **Rule ID**              | BR-001                                                   |
| **Rule Name**            | Province Authorization — SOAP Flow                       |
| **Category**             | Authorization                                            |
| **Severity**             | Critical                                                 |
| **Business Domain**      | Access Control / Insurance Scoring                       |
| **Description**          | Validates that the requesting user's province is in the configured list of supported provinces. If the province field is empty, error FS1004 is thrown. If the province is not in the allowed list, error FS1005 is thrown. The province check is case-insensitive. |
| **Source Location**      | `com.aviva.ca.esb.cl.opta.fus.processor.FusAuthorizationProcessor` |
| **Source Line(s)**       | L33–L55                                                  |
| **Trigger/Condition**    | Every incoming SOAP request to `/pl/api/oss/fus`         |
| **Input(s)**             | `FusRequest.dwellingFireProtectionRequest.province`, `SUPPORTED_PROVINCE_LIST` from config |
| **Output(s)/Action**     | Passes through if authorized; throws `ResponseError(FS1005)` if unauthorized, `ResponseError(FS1004)` if province blank |
| **Exception Handling**   | `ResponseError` exception is caught by `onException` in Camel route and converted to SOAP fault via `ErrorProcessor` |
| **Client Validated**     | 🟡 Pending                                               |
| **Client Comments**      | —                                                        |
| **Dead Code Flag**       | No                                                       |
| **Hardcoded Flag**       | Yes — Error code `FS1005` and message `"Provided Province is not authorized to view operation."` are hardcoded as instance variables |
| **Execution Priority**   | 1st processor in SOAP route (before validation)          |

#### Rule Logic (Pseudocode)

```
EXTRACT province FROM FusRequest.dwellingFireProtectionRequest
IF province IS EMPTY THEN
    SET LOG_ERRORCODE = "FS1004"
    THROW ResponseError("FS1004", "Province field is blank")
END IF
UPPERCASE province
IF SUPPORTED_PROVINCE_LIST IS EMPTY OR province NOT IN SUPPORTED_PROVINCE_LIST THEN
    SET LOG_ERRORCODE = "FS1005"
    THROW ResponseError("FS1005", "Provided Province is not authorized to view operation.")
END IF
```

#### Rule Logic (Source Code Reference)

```java
// File: FusAuthorizationProcessor.java
// Method: process()
// Lines: 33-55
String province = req.getDwellingFireProtectionRequest().getProvince();
if (StringUtils.isNotEmpty(province)) {
    province = province.toUpperCase(Locale.ROOT);
} else {
    throw new ResponseError("FS1004","Province field is blank");
}
if (provinceIds.isEmpty() || !isProvincePresent(provinceIds,province)) {
    throw new ResponseError(UNAUTHORISED, CONST_AUTH_ERROR);
}
```

#### Related Entities

| **Entity**                      | **Relationship**                                         |
|---------------------------------|----------------------------------------------------------|
| `FusRequest`                    | Source of province field to authorize                     |
| `DwellingFireProtectionRequest` | Contains the `province` field checked                    |
| `DataCache.userInfo`            | Not used directly here (province list comes from config) |
| `CL_FUS_TRANS_LOG`              | Error code/message logged on failure                     |

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Use Case                  | UC-001 — SOAP FUS Scoring Request             |
| BDD Scenario              | Feature: Province Authorization               |
| Test Case                 | TC-001, TC-002                                |
| Component                 | COMP-007 — FusAuthorizationProcessor          |
| Gap Report Item           | GAP-001 (province list not per-user)          |
| Field-to-Field Mapping    | F2F Section 3.1 — province field              |

---

### 3.2 BR-002: Required Field Validation — SOAP Request

| **Attribute**            | **Details**                                              |
|--------------------------|----------------------------------------------------------|
| **Rule ID**              | BR-002                                                   |
| **Rule Name**            | Required Field Validation — SOAP Request                 |
| **Category**             | Validation                                               |
| **Severity**             | Major                                                    |
| **Business Domain**      | Insurance Scoring / Data Quality                         |
| **Description**          | Validates that the four required address fields (`streetName`, `postalCode`, `municipality`, `province`) are not blank in a SOAP FUS request. Each missing field produces a distinct error code (FS1001–FS1004). Validation is sequential — only the first blank field triggers an error. |
| **Source Location**      | `com.aviva.ca.esb.cl.opta.fus.processor.FusRequestPreProcessor` |
| **Source Line(s)**       | L29–L54                                                  |
| **Trigger/Condition**    | Every SOAP request to `/pl/api/oss/fus` after authorization |
| **Input(s)**             | `FusRequest.dwellingFireProtectionRequest.{streetName, postalCode, municipality, province}` |
| **Output(s)/Action**     | Passes through if all fields present; throws `ResponseError` with specific error code per field |
| **Exception Handling**   | `ResponseError` caught by `onException`, converted to SOAP fault |
| **Client Validated**     | 🟡 Pending                                               |
| **Client Comments**      | —                                                        |
| **Dead Code Flag**       | No                                                       |
| **Hardcoded Flag**       | Yes — Error codes FS1001–FS1004 and messages are hardcoded strings |
| **Execution Priority**   | 2nd processor in SOAP route (after authorization)        |

#### Rule Logic (Pseudocode)

```
IF streetName IS BLANK THEN
    THROW ResponseError("FS1001", "Street Address field is blank")
IF postalCode IS BLANK THEN
    THROW ResponseError("FS1002", "Postal Code field is blank")
IF municipality IS BLANK THEN
    THROW ResponseError("FS1003", "Municipality field is blank")
IF province IS BLANK THEN
    THROW ResponseError("FS1004", "Province field is blank")
```

#### Rule Logic (Source Code Reference)

```java
// File: FusRequestPreProcessor.java
// Method: process()
// Lines: 29-54
if(validateField(req.getDwellingFireProtectionRequest().getStreetName())){
    throw new ResponseError("FS1001","Street Address field is blank");
}
if(validateField(req.getDwellingFireProtectionRequest().getPostalCode())){
    throw new ResponseError("FS1002","Postal Code field is blank");
}
// ... municipality (FS1003), province (FS1004)
```

#### Related Entities

| **Entity**                      | **Relationship**                              |
|---------------------------------|-----------------------------------------------|
| `FusRequest`                    | Request object being validated                |
| `DwellingFireProtectionRequest` | Contains validated fields                     |
| `ErrorMessageLookup`            | Error codes looked up in DataCache            |

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Use Case                  | UC-001 — SOAP FUS Scoring Request             |
| BDD Scenario              | Feature: Required Field Validation            |
| Test Case                 | TC-003, TC-004, TC-005, TC-006                |
| Component                 | COMP-008 — FusRequestPreProcessor             |
| Gap Report Item           | GAP-002 (no format validation on postalCode)  |
| Field-to-Field Mapping    | F2F Section 3.1                               |

---

### 3.3 BR-003: OAuth Token Acquisition

| **Attribute**            | **Details**                                              |
|--------------------------|----------------------------------------------------------|
| **Rule ID**              | BR-003                                                   |
| **Rule Name**            | OAuth Token Acquisition                                  |
| **Category**             | Workflow                                                 |
| **Severity**             | Critical                                                 |
| **Business Domain**      | Security / External Service Integration                  |
| **Description**          | Before calling the external OPTA Single Service, the system acquires an OAuth access token using the `refresh_token` grant type. The request includes `grant_type`, `client_secret`, `client_id`, and `refresh_token` — all injected from Blueprint configuration (Jasypt-encrypted). The token endpoint response is parsed to extract only the `access_token`. |
| **Source Location**      | `com.aviva.ca.esb.cl.opta.fus.processor.FusAuthServiceProcessor` + `FusAuthServiceResponse` |
| **Source Line(s)**       | `FusAuthServiceProcessor`: L54–L65; `FusAuthServiceResponse`: L17–L27 |
| **Trigger/Condition**    | Every scoring request, after validation passes           |
| **Input(s)**             | `FUS_AUTH_TOKEN`, `FUS_GRANT_TYPE`, `FUS_CLIENT_SECRET`, `FUS_CLIENT_ID` from config |
| **Output(s)/Action**     | Produces URL-encoded form body sent to auth endpoint; response parsed into `FusAuthResponse` with `access_token` |
| **Exception Handling**   | Exceptions caught by `onException` in `route_oss_security_token` route |
| **Client Validated**     | 🟡 Pending                                               |
| **Client Comments**      | —                                                        |
| **Dead Code Flag**       | No                                                       |
| **Hardcoded Flag**       | Yes — Content-Type `"application/x-www-form-urlencoded"` hardcoded in processor |
| **Execution Priority**   | 3rd step in all routes (after validation, before OPTA call) |

#### Rule Logic (Pseudocode)

```
CREATE FusAuthRequest WITH:
    grant_type = config.FUS_GRANT_TYPE
    client_secret = config.FUS_CLIENT_SECRET
    client_id = config.FUS_CLIENT_ID
    refresh_token = config.FUS_AUTH_TOKEN
BUILD query string: "grant_type=X&client_secret=X&client_id=X&refresh_token=X"
SET Content-Type = "application/x-www-form-urlencoded"
SEND to FUS_AUTH_ENDPOINT_URL
PARSE JSON response
EXTRACT access_token INTO FusAuthResponse
```

#### Rule Logic (Source Code Reference)

```java
// File: FusAuthServiceProcessor.java
// Method: process()
// Lines: 54-65
String query = "grant_type="+grantType+"&client_secret="+clientSecret
               +"&client_id="+clientId+"&refresh_token="+authToken;
exchange.getOut().setBody(query);
exchange.getOut().setHeader(Exchange.CONTENT_TYPE, "application/x-www-form-urlencoded");
```

#### Related Entities

| **Entity**           | **Relationship**                              |
|----------------------|-----------------------------------------------|
| `FusAuthRequest`     | Model for auth credentials (not sent as-is)   |
| `FusAuthResponse`    | Holds parsed access token                     |

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Use Case                  | UC-002 — OAuth Token Acquisition              |
| BDD Scenario              | Feature: External Authentication              |
| Test Case                 | TC-007, TC-008                                |
| Component                 | COMP-009 — FusAuthServiceProcessor            |
| Gap Report Item           | GAP-003 (no token caching/refresh logic)      |
| Field-to-Field Mapping    | F2F Section 4.1                               |

---

### 3.4 BR-004: SOAP Request Construction for OPTA Single Service

| **Attribute**            | **Details**                                              |
|--------------------------|----------------------------------------------------------|
| **Rule ID**              | BR-004                                                   |
| **Rule Name**            | SOAP Request Construction for OPTA Single Service        |
| **Category**             | Derivation                                               |
| **Severity**             | Major                                                    |
| **Business Domain**      | Insurance Scoring / External Integration                 |
| **Description**          | Maps incoming FUS request fields to the OPTA Single Service `OSSRequestType` SOAP request. Sets hardcoded/configured default values for brokerage, carrier, and username. Generates a UUID-based request ID with a configurable prefix. Adds current timestamp and Bearer auth token. Sets cache key from address + industry code hash. |
| **Source Location**      | `com.aviva.ca.esb.cl.opta.fus.processor.FusAuthRequestProcessor` |
| **Source Line(s)**       | L77–L131                                                 |
| **Trigger/Condition**    | After OAuth token is acquired                            |
| **Input(s)**             | `FusAuthResponse.accesToken`, `FusRequest` (from exchange property `INITIAL_REQUEST`), config: `FUS_REQUESTID_PREFIX`, `FUS_DEFAULT_BROKERAGE`, `FUS_DEFAULT_CARRIER`, `FUS_DEFAULT_USERNAME` |
| **Output(s)/Action**     | Produces `OSSRequestType` SOAP request with mapped address, industry codes, and RequestHeader |
| **Exception Handling**   | `ParseException` / `DatatypeConfigurationException` from timestamp generation |
| **Client Validated**     | 🟡 Pending                                               |
| **Client Comments**      | —                                                        |
| **Dead Code Flag**       | No                                                       |
| **Hardcoded Flag**       | Yes — `DEFAULT_ADDRESS_ID = "1"`, `CALL_METHOD_NAME = "call"`, `CALL_METHOD_NAME_SPACE = "http://www.optaintel.ca/ws/OptaSingleService/1.0"`, `ProductType.FUS` |
| **Execution Priority**   | 4th step in route (after token acquisition)              |

#### Rule Logic (Pseudocode)

```
GET FusAuthResponse (access_token) FROM exchange
GET FusRequest FROM exchange property "INITIAL_REQUEST"
CREATE OSSRequestType:
    Header:
        RequestID = config.reqid + UUID.randomUUID()
        RequestSentTimestamp = current time as XMLGregorianCalendar
        Requestor:
            Brokerage = config.broker  (⚪ default: "ABC Brokerage")
            Carrier = config.carrier   (⚪ default: "Aviva")
            Username = config.user
    Body:
        RequestedProducts = [FUS]
        Property:
            Address:
                AddressID = "1"  (⚪ HARDCODED)
                Municipality = request.municipality
                StreetName = request.streetName
                PostalCode = request.postalCode
                Province = request.province
            IndustryCodes:
                IBCCode = request.ibcCode
                SICCode = request.sicCode
                NAICSCode = request.naicsCode
SET Authorization header = "Bearer " + access_token
SET CamelCacheKey = hash(industryCodes + address)
```

#### Rule Logic (Source Code Reference)

```java
// File: FusAuthRequestProcessor.java
// Method: process()
// Lines: 86-131
OSSRequestType reqType = new OSSRequestType();
RequestHeaderType header = new RequestHeaderType();
header.setRequestID(reqid + randomUUIDString);
requestorType.setBrokerage(broker);
requestorType.setCarrier(carrier);
addType.setAddressID(DEFAULT_ADDRESS_ID); // "1"
outMessage.setHeader("Authorization", "Bearer "+res.getAccesToken());
```

#### Related Entities

| **Entity**             | **Relationship**                              |
|------------------------|-----------------------------------------------|
| `FusRequest`           | Source of address/industry code data           |
| `OSSRequestType`       | Target OPTA SOAP request type                 |
| `FusAuthResponse`      | Provides Bearer token                         |

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Use Case                  | UC-003 — Build OPTA Request                   |
| BDD Scenario              | Feature: OPTA Request Construction            |
| Test Case                 | TC-009, TC-010                                |
| Component                 | COMP-010 — FusAuthRequestProcessor            |
| Gap Report Item           | GAP-004 (hardcoded brokerage/carrier defaults) |
| Field-to-Field Mapping    | F2F Section 5.1                               |

---

### 3.5 BR-005: Fire Protection Grade Mapping

| **Attribute**            | **Details**                                              |
|--------------------------|----------------------------------------------------------|
| **Rule ID**              | BR-005                                                   |
| **Rule Name**            | Fire Protection Grade Mapping                            |
| **Category**             | Decision                                                 |
| **Severity**             | Critical                                                 |
| **Business Domain**      | Insurance Scoring — Dwelling Fire Protection             |
| **Description**          | Maps the OPTA Single Service FUS response dwelling grades to simplified fire protection categories (`firehall`, `shuttletanker`, `unprorected`, `hydrant`). Uses three grade sources: FirehallProtectedGrade, AllOtherAreasGrade, and HydrantProtectedGrade. If multiple grades are resolved, throws error FS3001. Contains a typo: `"unprorected"` instead of `"unprotected"`. |
| **Source Location**      | `com.aviva.ca.esb.cl.opta.fus.processor.FusAuthServiceResponseProcessor` |
| **Source Line(s)**       | L102–L148                                                |
| **Trigger/Condition**    | After OPTA Single Service returns a successful FUS response |
| **Input(s)**             | `OSSResponseType` containing `DwellingGradesType` with grade lists |
| **Output(s)/Action**     | List of protection categories (ideally exactly 1); populates `DwellingFireProtectionResponse` |
| **Exception Handling**   | Throws `ResponseError("FS3001")` if multiple grades found; throws `ResponseError("FS7001")` if OPTA returns FAILED status |
| **Client Validated**     | 🟡 Pending                                               |
| **Client Comments**      | —                                                        |
| **Dead Code Flag**       | No                                                       |
| **Hardcoded Flag**       | Yes — All grade-to-category mappings are hardcoded string comparisons; protection category names are hardcoded strings |
| **Execution Priority**   | 5th step in SOAP route (after OPTA call)                 |

#### Rule Logic (Pseudocode)

```
FOR EACH FirehallProtectedGrade:
    IF grade IN ("3B", "3B(L)", "3B(F)", "3BL", "3BF") THEN
        ADD "firehall"
    ELSE IF grade IN ("3BS", "3B(S)") THEN
        ADD "shuttletanker"
    ELSE IF grade = "4" THEN
        ADD "unprorected"   ⚠️ TYPO: should be "unprotected"
    BREAK after first match

IF AllOtherAreasGrade.grade = "5" THEN
    ADD "unprorected"       ⚠️ TYPO

FOR EACH HydrantProtectedGrade:
    IF grade IN ("1", "2", "3A") THEN
        ADD "hydrant"
        BREAK

IF dwellingTypes.size == 1 THEN
    SET success = true, return grade
ELSE IF dwellingTypes.size > 1 THEN
    THROW ResponseError("FS3001", "unable to determine fire protection level...")
```

#### Rule Logic (Source Code Reference)

```java
// File: FusAuthServiceResponseProcessor.java
// Method: mapProtectionInfo()
// Lines: 102-148
if ("3B".equals(grade) || "3B(L)".equals(grade) || "3B(F)".equals(grade)
        || "3BL".equals(grade) || "3BF".equals(grade)) {
    dwellingTypes.add("firehall");
} else if ("3BS".equals(grade) || "3B(S)".equals(grade)) {
    dwellingTypes.add("shuttletanker");
} else if ("4".equals(grade)) {
    dwellingTypes.add("unprorected"); // typo
}
```

#### Related Entities

| **Entity**                        | **Relationship**                              |
|-----------------------------------|-----------------------------------------------|
| `OSSResponseType`                 | OPTA response containing grade data           |
| `DwellingGradesType`              | Contains firehall, hydrant, allOther grades   |
| `DwellingFireProtectionResponse`  | Target response with mapped categories        |
| `FUSResponse`                     | Wrapper for the final response                |

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Use Case                  | UC-004 — Map Fire Protection Grade            |
| BDD Scenario              | Feature: Grade Mapping                        |
| Test Case                 | TC-011 through TC-018                         |
| Component                 | COMP-011 — FusAuthServiceResponseProcessor    |
| Gap Report Item           | GAP-005 (typo "unprorected"), GAP-006 (hardcoded grade mappings) |
| Field-to-Field Mapping    | F2F Section 6.1                               |

---

### 3.6 BR-006: Transaction Logging

| **Attribute**            | **Details**                                              |
|--------------------------|----------------------------------------------------------|
| **Rule ID**              | BR-006                                                   |
| **Rule Name**            | Transaction Logging to Oracle Database                   |
| **Category**             | Workflow                                                 |
| **Severity**             | Major                                                    |
| **Business Domain**      | Audit / Compliance                                       |
| **Description**          | Every request/response cycle is logged to the Oracle `CL_FUS_TRANS_LOG` table. Logging occurs via a Camel `wireTap` pattern (fire-and-forget) at the end of each route and in exception handlers. The `TransactionLogger` collects exchange properties and inserts 17 columns into the database. Request/response payloads are serialized to XML via JAXB marshal. |
| **Source Location**      | `com.aviva.ca.esb.cl.opta.fus.logging.TransactionLogger` + `fus-log.xml` blueprint |
| **Source Line(s)**       | `TransactionLogger`: L81–L114; Blueprint `fus-log.xml`: L39–L42 |
| **Trigger/Condition**    | End of every route (success or error), via `wireTap uri="direct-vm:fusLogger"` |
| **Input(s)**             | Exchange properties: `TRANSACTION_ID`, `APPLICATION`, `URL`, `CLIENT_ID`, `CLIENT_NAME`, `CLIENT_GUID`, `DWELLING_FIRE_PROTECTION`, `STREET_NAME`, `POSTAL_CODE`, `MUNICIPALITY`, `PROVINCE`, `INITIAL_REQUEST`, `RES_PAYLOAD`, `STATUS`, `ERROR_CODE`, `ERROR_MESSAGE` |
| **Output(s)/Action**     | INSERT into `CL_FUS_TRANS_LOG` table with 17 columns    |
| **Exception Handling**   | Logging errors are caught silently — `LOGGER.info("Error Logging...")` — main flow is NOT affected |
| **Client Validated**     | 🟡 Pending                                               |
| **Client Comments**      | —                                                        |
| **Dead Code Flag**       | No                                                       |
| **Hardcoded Flag**       | Yes — Application name constants: `"OssFUSServiceSoap"`, `"OssFUSServiceRest"`, `"OssFUSProductSoap"` in `LoggerConstants` |
| **Execution Priority**   | Last step (asynchronous via wireTap)                     |

#### Rule Logic (Pseudocode)

```
ON route completion (success OR error):
    WIRETAP to "direct-vm:fusLogger"
    COLLECT all exchange properties into FusTransactionLog
    SERIALIZE request/response to XML string (JAXB marshal)
    LOAD SQL query from fus_logging_queries.properties
    EXECUTE INSERT INTO CL_FUS_TRANS_LOG (17 columns)
    ON logging error: LOG and SWALLOW exception (main flow unaffected)
```

#### Rule Logic (Source Code Reference)

```java
// File: TransactionLogger.java
// Method: logTransaction()
// Lines: 81-114
FusTransactionLog transactionLog = new FusTransactionLog(transactionId,
    application, url, new Date(), clientId, clientName,
    clientGuid, dwellingFireProtection,
    streetName, postalCode, municipality, province,
    reqPayload, resPayload, status, errorCd, errorMess);
logPayLoad(transactionLog);
```

#### Related Entities

| **Entity**             | **Relationship**                              |
|------------------------|-----------------------------------------------|
| `CL_FUS_TRANS_LOG`     | Target Oracle table for audit logs            |
| `FusTransactionLog`    | Java model for log record                     |
| `LoggerConstants`      | Defines property keys and application names   |

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Use Case                  | UC-005 — Audit Logging                        |
| BDD Scenario              | Feature: Transaction Logging                  |
| Test Case                 | TC-019, TC-020                                |
| Component                 | COMP-012 — TransactionLogger                  |
| Gap Report Item           | GAP-007 (error logged at INFO, not ERROR)     |
| Field-to-Field Mapping    | F2F Section 7.1                               |

---

### 3.7 BR-007: Error Handling and Response Conversion

| **Attribute**            | **Details**                                              |
|--------------------------|----------------------------------------------------------|
| **Rule ID**              | BR-007                                                   |
| **Rule Name**            | Error Handling and Response Conversion                   |
| **Category**             | Decision                                                 |
| **Severity**             | Major                                                    |
| **Business Domain**      | Error Handling / API Contract                            |
| **Description**          | Converts exceptions into appropriate error responses based on the call type (SOAP vs REST). For SOAP: converts to `SOAPServiceException` with `DetailException`. For REST: converts to JAX-RS `Response` with JSON `ErrorDetails` and appropriate HTTP status codes (400, 403, 500). Error messages are looked up from `DataCache` error lookup unless the error code is FS3001/FS7001 (dynamic errors). |
| **Source Location**      | `com.aviva.ca.esb.cl.opta.fus.processor.ErrorProcessor` |
| **Source Line(s)**       | L28–L111                                                 |
| **Trigger/Condition**    | Any exception caught by `onException` in Camel routes    |
| **Input(s)**             | `Exchange.EXCEPTION_CAUGHT`, `exchange.property.CALL_TYPE` |
| **Output(s)/Action**     | SOAP fault (DetailException) or REST JSON response with HTTP status code |
| **Exception Handling**   | Handles `ResponseError` (known errors) and all other exceptions (mapped to FS2001) |
| **Client Validated**     | 🟡 Pending                                               |
| **Client Comments**      | —                                                        |
| **Dead Code Flag**       | No                                                       |
| **Hardcoded Flag**       | Yes — `UNKNOWN_ERR_CD = "FS2001"`; HTTP status code mapping (FS1005→403, FS3001/FS7001→500, else→400) |
| **Execution Priority**   | Triggered only on exception                              |

#### Rule Logic (Pseudocode)

```
GET exception FROM exchange
SET LOG_STATUS = "error"
IF exception IS ResponseError THEN
    IF errorCode IN ("FS3001", "FS7001") THEN
        USE dynamic error message from exception
    ELSE
        LOOKUP error message from DataCache by error code
IF CALL_TYPE == "SOAP" THEN
    CREATE DetailException(errorCode, errorMessage)
    THROW SOAPServiceException("Exception Occured", detailException)
ELSE (REST):
    IF errorCode == "FS1005" THEN statusCode = 403
    ELSE IF errorCode IN ("FS3001","FS7001") THEN statusCode = 500
    ELSE statusCode = 400
    CREATE JSON ErrorDetails response
    SET Response.status(statusCode)
```

#### Related Entities

| **Entity**            | **Relationship**                              |
|-----------------------|-----------------------------------------------|
| `ResponseError`       | Known error type with code + message          |
| `ErrorMessageLookup`  | Cache-stored error message definitions        |
| `SOAPServiceException`| SOAP fault wrapper                            |
| `DetailException`     | SOAP fault detail element                     |
| `ErrorDetails`        | REST JSON error response body                 |

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Use Case                  | UC-006 — Error Handling                       |
| BDD Scenario              | Feature: Error Response Handling              |
| Test Case                 | TC-021 through TC-025                         |
| Component                 | COMP-013 — ErrorProcessor                     |
| Gap Report Item           | GAP-008 (no error response for auth failure)  |
| Field-to-Field Mapping    | F2F Section 8.1                               |

---

### 3.8 BR-008: Request ID Generation

| **Attribute**            | **Details**                                              |
|--------------------------|----------------------------------------------------------|
| **Rule ID**              | BR-008                                                   |
| **Rule Name**            | Request ID Generation with Configurable Prefix           |
| **Category**             | Derivation                                               |
| **Severity**             | Major                                                    |
| **Business Domain**      | Traceability / Request Tracking                          |
| **Description**          | Generates a unique request ID for each OPTA Single Service call by concatenating a configurable prefix (`FUS_REQUESTID_PREFIX` from config) with a random UUID. This ID is set on the OPTA request header for correlation. A separate UUID is also generated for the transaction log. |
| **Source Location**      | `com.aviva.ca.esb.cl.opta.fus.processor.FusAuthRequestProcessor` (L89–L91) and `FusAuthorizationProcessor` (L81) |
| **Source Line(s)**       | `FusAuthRequestProcessor`: L89–L91; `FusAuthorizationProcessor`: L81 |
| **Trigger/Condition**    | Every request — OPTA request ID at request construction, transaction ID at authorization |
| **Input(s)**             | `FUS_REQUESTID_PREFIX` from config                       |
| **Output(s)/Action**     | `header.setRequestID(reqid + UUID)` for OPTA; `UUID.randomUUID()` for transaction log |
| **Exception Handling**   | None specific                                            |
| **Client Validated**     | 🟡 Pending                                               |
| **Client Comments**      | —                                                        |
| **Dead Code Flag**       | No                                                       |
| **Hardcoded Flag**       | No — prefix is configurable                              |
| **Execution Priority**   | At request construction time                             |

#### Rule Logic (Pseudocode)

```
// OPTA Request ID
requestID = config.FUS_REQUESTID_PREFIX + UUID.randomUUID().toString()

// Transaction Log ID
transactionId = UUID.randomUUID().toString()
```

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Test Case                 | TC-026                                        |
| Component                 | COMP-010 — FusAuthRequestProcessor            |
| Gap Report Item           | —                                             |

---

### 3.9 BR-009: Data Cache Loading from JSON Files

| **Attribute**            | **Details**                                              |
|--------------------------|----------------------------------------------------------|
| **Rule ID**              | BR-009                                                   |
| **Rule Name**            | Data Cache Loading from JSON Files                       |
| **Category**             | Workflow                                                 |
| **Severity**             | Major                                                    |
| **Business Domain**      | Configuration / System Initialization                    |
| **Description**          | On application startup, two Camel file routes load JSON data into the singleton `DataCache`: (1) Error message lookup from `ERROR_MSG_LOOKUP` path, (2) Authorization lookup from `AUTHORIZATION_LOOKUP` path. The JSON is deserialized into POJOs (`ErrorMessageLookup`, `AuthorizationLookup`) using Jackson and then loaded into in-memory `HashMap` caches by `DataCacheLoader`. |
| **Source Location**      | Blueprint routes `jsonToErrorMessageLookup` and `jsonToAuthenticationLookup` in `blueprint.xml` (L185–L204); `DataCacheLoader.loadJsonData()` |
| **Source Line(s)**       | `blueprint.xml`: L185–L204; `DataCacheLoader`: full class |
| **Trigger/Condition**    | Application startup (Camel file consumer)                |
| **Input(s)**             | JSON files at paths `ERROR_MSG_LOOKUP` and `AUTHORIZATION_LOOKUP` from config |
| **Output(s)/Action**     | `DataCache.errorLookup` populated with error code→ErrorMessageLookup map; `DataCache.userInfo` populated with userName→allowedProvinces map |
| **Exception Handling**   | No explicit error handling in cache loading routes        |
| **Client Validated**     | 🟡 Pending                                               |
| **Client Comments**      | —                                                        |
| **Dead Code Flag**       | No                                                       |
| **Hardcoded Flag**       | No                                                       |
| **Execution Priority**   | Startup-time initialization                              |

#### Rule Logic (Pseudocode)

```
ON STARTUP:
    // Route 1: Error Messages
    READ JSON file from ERROR_MSG_LOOKUP path
    UNMARSHAL to List<ErrorMessageLookup>
    FOR EACH entry: PUT errorCode -> ErrorMessageLookup INTO DataCache.errorLookup

    // Route 2: Authorization
    READ JSON file from AUTHORIZATION_LOOKUP path
    UNMARSHAL to List<AuthorizationLookup>
    FOR EACH AuthorizationLookup:
        FOR EACH UserInfo in optaOssACL:
            PUT userName -> allowedProvinces INTO DataCache.userInfo
```

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Test Case                 | TC-027, TC-028                                |
| Component                 | COMP-014 — DataCache, COMP-015 — DataCacheLoader |
| Gap Report Item           | GAP-009 (DataCache.userInfo loaded but not used in authorization processors) |

---

### 3.10 BR-010: Response Marshalling — SOAP vs REST

| **Attribute**            | **Details**                                              |
|--------------------------|----------------------------------------------------------|
| **Rule ID**              | BR-010                                                   |
| **Rule Name**            | Response Marshalling — SOAP Direct vs REST JSON          |
| **Category**             | Decision                                                 |
| **Severity**             | Minor                                                    |
| **Business Domain**      | API Contract / Response Formatting                       |
| **Description**          | SOAP responses are returned directly as JAXB-marshalled XML (CXF handles automatically). REST responses are explicitly marshalled to JSON via Jackson within the Camel route (`marshal` → `json` → `convertBodyTo String`). Product SOAP responses pass through the full `ResponseBodyType` from OPTA. |
| **Source Location**      | `blueprint.xml` routes: REST route (L219–L222), SOAP route (L284) |
| **Source Line(s)**       | `blueprint.xml`: L219–L222 (REST marshal), L284 (SOAP direct) |
| **Trigger/Condition**    | After OPTA response is processed                         |
| **Input(s)**             | Processed response object (`FUSResponse` or `FusProductResponse`) |
| **Output(s)/Action**     | SOAP: direct JAXB XML; REST: JSON string via Jackson     |
| **Exception Handling**   | —                                                        |
| **Client Validated**     | 🟡 Pending                                               |
| **Client Comments**      | —                                                        |
| **Dead Code Flag**       | No                                                       |
| **Hardcoded Flag**       | No                                                       |
| **Execution Priority**   | Last processing step before response                     |

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Test Case                 | TC-029, TC-030                                |
| Component                 | COMP-001 — FusSvc, COMP-002 — OssFusSvc      |

---

### 3.11 BR-011: Province Authorization — Product/REST Flow

| **Attribute**            | **Details**                                              |
|--------------------------|----------------------------------------------------------|
| **Rule ID**              | BR-011                                                   |
| **Rule Name**            | Province Authorization — Product/REST Flow               |
| **Category**             | Authorization                                            |
| **Severity**             | Critical                                                 |
| **Business Domain**      | Access Control / Insurance Scoring                       |
| **Description**          | Identical logic to BR-001 but for `FusProductRequest` (used by REST and Product SOAP endpoints). Also sets the `APPLICATION` logging property based on `CALL_TYPE` (SOAP→"OssFUSProductSoap", REST→"OssFUSServiceRest"). Extracts address fields for logging. |
| **Source Location**      | `com.aviva.ca.esb.cl.opta.fus.processor.FusFullResAuthorizationProcessor` |
| **Source Line(s)**       | L31–L50                                                  |
| **Trigger/Condition**    | Every REST request to `/pl/api/oss/rest/product/fus/` or SOAP to `/pl/api/oss/product/fus` |
| **Input(s)**             | `FusProductRequest.province`, `SUPPORTED_PROVINCE_LIST`  |
| **Output(s)/Action**     | Pass-through if authorized; throws `ResponseError(FS1005)` if not |
| **Exception Handling**   | Same as BR-001                                           |
| **Client Validated**     | 🟡 Pending                                               |
| **Client Comments**      | —                                                        |
| **Dead Code Flag**       | No                                                       |
| **Hardcoded Flag**       | Yes — Same hardcoded error codes/messages as BR-001      |
| **Execution Priority**   | 1st processor in REST/Product routes                     |

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Test Case                 | TC-031, TC-032                                |
| Component                 | COMP-016 — FusFullResAuthorizationProcessor   |
| Gap Report Item           | GAP-001 (duplicated authorization logic)      |

---

### 3.12 BR-012: Required Field Validation — Product/REST Request

| **Attribute**            | **Details**                                              |
|--------------------------|----------------------------------------------------------|
| **Rule ID**              | BR-012                                                   |
| **Rule Name**            | Required Field Validation — Product/REST Request         |
| **Category**             | Validation                                               |
| **Severity**             | Major                                                    |
| **Business Domain**      | Data Quality                                             |
| **Description**          | Same validation as BR-002 but operates on `FusProductRequest` instead of `FusRequest`. Validates `streetName`, `postalCode`, `municipality`, `province` with identical error codes FS1001–FS1004. |
| **Source Location**      | `com.aviva.ca.esb.cl.opta.fus.processor.FusFullResRequestPreProcessor` |
| **Source Line(s)**       | L29–L52                                                  |
| **Trigger/Condition**    | REST/Product SOAP requests after authorization           |
| **Input(s)**             | `FusProductRequest.{streetName, postalCode, municipality, province}` |
| **Output(s)/Action**     | Same as BR-002                                           |
| **Client Validated**     | 🟡 Pending                                               |
| **Dead Code Flag**       | No                                                       |
| **Hardcoded Flag**       | Yes — Same hardcoded error codes/messages as BR-002      |
| **Execution Priority**   | 2nd processor in REST/Product routes                     |

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Test Case                 | TC-033 through TC-036                         |
| Component                 | COMP-017 — FusFullResRequestPreProcessor      |
| Gap Report Item           | GAP-002 (duplicated validation logic)         |

---

### 3.13 BR-013: LDAP/JAAS Authentication

| **Attribute**            | **Details**                                              |
|--------------------------|----------------------------------------------------------|
| **Rule ID**              | BR-013                                                   |
| **Rule Name**            | LDAP/JAAS Authentication                                 |
| **Category**             | Authorization                                            |
| **Severity**             | Critical                                                 |
| **Business Domain**      | Security / Identity                                      |
| **Description**          | All endpoints require JAAS-based LDAP authentication. REST uses `JAASAuthenticationFilter`; SOAP uses `JAASLoginInterceptor` + WSS4J `UsernameToken` with `PasswordText`. The role `eEsbPlApiOptaAccess` is required for the `getFusScore` method. |
| **Source Location**      | `blueprint.xml` — bean definitions and CXF endpoint configs |
| **Source Line(s)**       | `blueprint.xml`: L74–L146                                |
| **Trigger/Condition**    | Every incoming request (before Camel route)              |
| **Input(s)**             | HTTP Basic/WS-Security credentials, `LDAP_LOGIN` context |
| **Output(s)/Action**     | Authenticated principal with role; `AccessDeniedException` if unauthorized |
| **Client Validated**     | 🟡 Pending                                               |
| **Dead Code Flag**       | No                                                       |
| **Hardcoded Flag**       | Yes — Role name `"eEsbPlApiOptaAccess"` hardcoded in `authorizationInterceptor` |
| **Execution Priority**   | Before all Camel route processing (CXF interceptor level) |

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Test Case                 | TC-037, TC-038                                |
| Gap Report Item           | GAP-010 (WS-Security `validate.token=false`)  |

---

### 3.14 BR-014: Logging Helper — Exchange Property Population

| **Attribute**            | **Details**                                              |
|--------------------------|----------------------------------------------------------|
| **Rule ID**              | BR-014                                                   |
| **Rule Name**            | Logging Helper — Exchange Property Population            |
| **Category**             | Derivation                                               |
| **Severity**             | Minor                                                    |
| **Business Domain**      | Audit / Traceability                                     |
| **Description**          | The authorization processors also populate exchange properties with request metadata for downstream transaction logging: URL (from CXF message), transaction ID (UUID), application name, client info (ID, name, GUID), and address fields. |
| **Source Location**      | `FusAuthorizationProcessor.fusLoggingHelper()` (L69–L107), `FusFullResAuthorizationProcessor.fusLoggingHelper()` (L65–L89) |
| **Source Line(s)**       | L69–L107, L65–L89                                        |
| **Trigger/Condition**    | During authorization processing                          |
| **Input(s)**             | Request object, CXF message headers                     |
| **Output(s)/Action**     | Exchange properties set for downstream logging           |
| **Client Validated**     | 🟡 Pending                                               |
| **Dead Code Flag**       | No                                                       |
| **Hardcoded Flag**       | No                                                       |
| **Execution Priority**   | Within authorization processor                           |

---

### 3.15 BR-015: Full Response Pass-Through (Product Endpoint)

| **Attribute**            | **Details**                                              |
|--------------------------|----------------------------------------------------------|
| **Rule ID**              | BR-015                                                   |
| **Rule Name**            | Full OPTA Response Pass-Through                          |
| **Category**             | Decision                                                 |
| **Severity**             | Minor                                                    |
| **Business Domain**      | API Design                                               |
| **Description**          | The Product endpoint (`/pl/api/oss/product/fus`) returns the full OPTA `ResponseBodyType` without mapping to simplified fire protection grades. This is the "full response" variant used by consumers needing raw OPTA data. |
| **Source Location**      | `com.aviva.ca.esb.cl.opta.fus.processor.FusFullResAuthServiceResponseProcessor` |
| **Source Line(s)**       | L12–L17                                                  |
| **Trigger/Condition**    | Product SOAP/REST requests                               |
| **Input(s)**             | `OSSResponseType` from OPTA                              |
| **Output(s)/Action**     | `FusProductResponse` wrapping the full `ResponseBodyType` |
| **Client Validated**     | 🟡 Pending                                               |
| **Dead Code Flag**       | No                                                       |
| **Hardcoded Flag**       | No                                                       |

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Test Case                 | TC-039                                        |
| Component                 | COMP-018 — FusFullResAuthServiceResponseProcessor |

---

### 3.16 BR-016: TLS/SSL Configuration for External Calls

| **Attribute**            | **Details**                                              |
|--------------------------|----------------------------------------------------------|
| **Rule ID**              | BR-016                                                   |
| **Rule Name**            | TLS/SSL Configuration for External Service Calls         |
| **Category**             | Constraint                                               |
| **Severity**             | Minor                                                    |
| **Business Domain**      | Security / Network                                       |
| **Description**          | All outbound HTTP connections use TLS with a JKS trust/key store. CN check is disabled (`disableCNCheck="true"`). Connection and receive timeouts are configurable. Keep-Alive and auto-redirect are enabled. |
| **Source Location**      | `blueprint.xml` — conduit configuration                  |
| **Source Line(s)**       | `blueprint.xml`: L160–L174                               |
| **Trigger/Condition**    | Every outbound HTTP/HTTPS call                           |
| **Input(s)**             | `FUS_CONNECTION_TIMEOUT`, `FUS_RECEIVE_TIMEOUT`, `FUS_TRUST_PWD`, `FUS_TRUST_STOREPATH` from config |
| **Output(s)/Action**     | Configured CXF HTTP conduit                              |
| **Client Validated**     | 🟡 Pending                                               |
| **Dead Code Flag**       | No                                                       |
| **Hardcoded Flag**       | Yes — `disableCNCheck="true"`, `AutoRedirect="true"`, `Connection="Keep-Alive"`, keystore type `"JKS"` |

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Gap Report Item           | GAP-010 (CN check disabled)                   |

---

### 3.17 BR-017: REST Service Stub (Dead Code)

| **Attribute**            | **Details**                                              |
|--------------------------|----------------------------------------------------------|
| **Rule ID**              | BR-017                                                   |
| **Rule Name**            | REST Service Stub — OssFusSvc                            |
| **Category**             | Decision                                                 |
| **Severity**             | Minor                                                    |
| **Business Domain**      | API Design                                               |
| **Description**          | The `OssFusSvc` JAX-RS class defines a GET endpoint `/fus/` that always returns `null`. The actual REST processing is handled by the Camel CXF-RS route, which overrides this method. The class exists only to define the JAX-RS contract for the CXF-RS server bean. |
| **Source Location**      | `com.aviva.ca.esb.cl.opta.fus.service.OssFusSvc`        |
| **Source Line(s)**       | L29–L32                                                  |
| **Client Validated**     | 🟡 Pending                                               |
| **Dead Code Flag**       | Yes — The `return null` body is never executed; Camel route handles processing |
| **Hardcoded Flag**       | No                                                       |

#### Traceability

| **Linked To**             | **Reference**                                 |
|---------------------------|-----------------------------------------------|
| Component                 | COMP-002 — OssFusSvc                          |
| Gap Report Item           | GAP-011 (incomplete REST service implementation) |

---

### 3.18 BR-018: CXF Logging with Password Masking

| **Attribute**            | **Details**                                              |
|--------------------------|----------------------------------------------------------|
| **Rule ID**              | BR-018                                                   |
| **Rule Name**            | CXF Logging with Password Masking                        |
| **Category**             | Workflow                                                 |
| **Severity**             | Major                                                    |
| **Business Domain**      | Security / Observability                                 |
| **Description**          | Custom CXF logging interceptors mask sensitive data (passwords) in SOAP messages before logging. The `LoggingInInterceptor` replaces password content in incoming messages with asterisks. Both in/out interceptors are registered via `CXFLoggerFeature`. |
| **Source Location**      | `com.aviva.ca.esb.common.cxf.logger.LoggingInInterceptor`, `LoggingOutInterceptor`, `CXFLoggerFeature` |
| **Source Line(s)**       | Full classes                                              |
| **Trigger/Condition**    | Every SOAP message in/out                                |
| **Client Validated**     | 🟡 Pending                                               |
| **Dead Code Flag**       | No                                                       |
| **Hardcoded Flag**       | No                                                       |

---

## 4. Validation Rules

| **Rule ID** | **Rule Name**                   | **Field/Entity**                        | **Validation Logic**          | **Validation Exists in Source** | **Error Message**                    |
|-------------|----------------------------------|-----------------------------------------|-------------------------------|---------------------------------|--------------------------------------|
| BR-002      | Street Name Required (SOAP)      | `DwellingFireProtectionRequest.streetName` | Required (not blank)         | ✅ Yes                           | `"Street Address field is blank"`    |
| BR-002      | Postal Code Required (SOAP)      | `DwellingFireProtectionRequest.postalCode` | Required (not blank)         | ✅ Yes                           | `"Postal Code field is blank"`       |
| BR-002      | Municipality Required (SOAP)     | `DwellingFireProtectionRequest.municipality` | Required (not blank)       | ✅ Yes                           | `"Municipality field is blank"`      |
| BR-002      | Province Required (SOAP)         | `DwellingFireProtectionRequest.province`  | Required (not blank)         | ✅ Yes                           | `"Province field is blank"`          |
| BR-012      | Street Name Required (Product)   | `FusProductRequest.streetName`            | Required (not blank)         | ✅ Yes                           | `"Street Address field is blank"`    |
| BR-012      | Postal Code Required (Product)   | `FusProductRequest.postalCode`            | Required (not blank)         | ✅ Yes                           | `"Postal Code field is blank"`       |
| BR-012      | Municipality Required (Product)  | `FusProductRequest.municipality`          | Required (not blank)         | ✅ Yes                           | `"Municipality field is blank"`      |
| BR-012      | Province Required (Product)      | `FusProductRequest.province`              | Required (not blank)         | ✅ Yes                           | `"Province field is blank"`          |
| BR-001      | Province Not Empty (Auth)        | `FusRequest.dwellingFireProtectionRequest.province` | Required (not empty) | ✅ Yes                           | `"Province field is blank"`          |

---

## 5. Computation Rules

| **Rule ID** | **Rule Name**              | **Formula/Logic**                                    | **Inputs**                | **Output**        | **Hardcoded Override**                          |
|-------------|----------------------------|------------------------------------------------------|---------------------------|-------------------|-------------------------------------------------|
| BR-008      | Request ID Generation       | `requestID = prefix + UUID.randomUUID().toString()`  | `FUS_REQUESTID_PREFIX`    | `requestID`       | None (prefix is configurable)                   |
| BR-008      | Transaction ID Generation   | `transactionId = UUID.randomUUID().toString()`       | —                         | `transactionId`   | None                                            |
| BR-004      | Cache Key Computation       | `cacheKey = String.valueOf(industryCode.hashCode() + address.hashCode())` | `RequestedIndustryCodeType`, `RequestAddressType` | `CamelCacheKey` | None |

---

## 6. Decision Rules (Decision Tables)

### 6.1 Decision Table: Fire Protection Grade Classification

**Rule ID:** BR-005
**Description:** Maps OPTA FUS dwelling grades to simplified fire protection categories.

| **Grade Source**          | **Grade Value(s)**                                | **Mapped Category** |
|---------------------------|---------------------------------------------------|---------------------|
| FirehallProtectedGrade    | 3B, 3B(L), 3B(F), 3BL, 3BF                      | `firehall`          |
| FirehallProtectedGrade    | 3BS, 3B(S)                                        | `shuttletanker`     |
| FirehallProtectedGrade    | 4                                                  | `unprorected` ⚠️    |
| AllOtherAreasGrade        | 5                                                  | `unprorected` ⚠️    |
| HydrantProtectedGrade     | 1, 2, 3A                                          | `hydrant`           |

> ⚠️ **Note:** `"unprorected"` is a typo in source code — should be `"unprotected"` (see GAP-005).

### 6.2 Decision Table: Error Response HTTP Status Code

**Rule ID:** BR-007
**Description:** Maps error codes to HTTP status codes for REST responses.

| **Error Code** | **HTTP Status** | **Meaning**                          |
|----------------|-----------------|--------------------------------------|
| FS1005         | 403 Forbidden   | Province not authorized              |
| FS3001         | 500 Internal    | Multiple grades returned             |
| FS7001         | 500 Internal    | OPTA service returned FAILED         |
| All others     | 400 Bad Request | Validation/input errors              |

### 6.3 Decision Table: Application Name Selection

**Rule ID:** BR-014
**Description:** Sets application name for logging based on call type and endpoint.

| **Endpoint**               | **CALL_TYPE property** | **Application Name**     |
|----------------------------|------------------------|--------------------------|
| `/pl/api/oss/fus`          | SOAP                   | `OssFUSServiceSoap`     |
| `/pl/api/oss/rest/product` | (not set)              | `OssFUSServiceRest`     |
| `/pl/api/oss/product/fus`  | SOAP                   | `OssFUSProductSoap`     |

---

## 7. Workflow / State Transition Rules

### 7.1 State Machine: FUS Request Processing Pipeline

**Related Rule IDs:** BR-001, BR-002, BR-003, BR-004, BR-005, BR-006, BR-007

| **Current State**    | **Event/Trigger**              | **Condition(s)**           | **Next State**       | **Action(s)**                    |
|-----------------------|--------------------------------|----------------------------|----------------------|----------------------------------|
| Received             | Request arrives                | —                          | Authorizing          | JAAS/LDAP auth (BR-013)         |
| Authorizing          | Auth success                   | Valid credentials + role   | Province Check       | Extract request, set log props   |
| Province Check       | Province authorized            | Province in allowed list   | Validating           | —                                |
| Province Check       | Province unauthorized          | Province missing or denied | Error                | Throw FS1004/FS1005 (BR-001)    |
| Validating           | All fields valid               | All required fields present| Acquiring Token      | —                                |
| Validating           | Field missing                  | Any field blank            | Error                | Throw FS1001–FS1004 (BR-002)    |
| Acquiring Token      | Token received                 | OAuth success              | Building OPTA Req    | Parse access_token (BR-003)      |
| Acquiring Token      | Token failure                  | Auth endpoint error        | Error                | Exception → ErrorProcessor       |
| Building OPTA Req    | Request built                  | —                          | Calling OPTA         | Map fields, set auth header (BR-004) |
| Calling OPTA         | Response received              | OPTA success               | Mapping Response     | —                                |
| Calling OPTA         | OPTA error                     | OPTA failure               | Error                | Throw FS7001                     |
| Mapping Response     | Grade mapped (single)          | Exactly 1 grade            | Logging              | Map grade category (BR-005)      |
| Mapping Response     | Multiple grades                | > 1 grade                  | Error                | Throw FS3001                     |
| Logging              | Log written                    | —                          | Complete             | wireTap to fusLogger (BR-006)    |
| Error                | Error processed                | —                          | Logging              | Convert to SOAP fault/REST error (BR-007) |

```
[Received] ──auth──▶ [Authorizing] ──ok──▶ [Province Check] ──ok──▶ [Validating]
                          │                      │                       │
                          ▼                      ▼                       ▼
                       [Error]               [Error]                  [Error]
                                                                        │
                                                          ◀─────────────┘
[Validating] ──ok──▶ [Acquiring Token] ──ok──▶ [Building OPTA Req] ──▶ [Calling OPTA]
                          │                                                │
                          ▼                                                ▼
                       [Error]                                     [Mapping Response]
                                                                        │
                                                              ┌─────────┴──────────┐
                                                              ▼                    ▼
                                                         [Logging]             [Error]
                                                              │                    │
                                                              ▼                    ▼
                                                         [Complete]           [Logging]
```

---

## 8. Authorization Rules

| **Rule ID** | **Resource/Action**              | **Required Role(s)**         | **Additional Conditions**                        |
|-------------|----------------------------------|------------------------------|--------------------------------------------------|
| BR-013      | `getFusScore` (all endpoints)    | `eEsbPlApiOptaAccess`        | LDAP authentication via JAAS context             |
| BR-001      | SOAP FUS Scoring                 | —                            | Province must be in `SUPPORTED_PROVINCE_LIST`    |
| BR-011      | REST/Product FUS Scoring         | —                            | Province must be in `SUPPORTED_PROVINCE_LIST`    |

---

## 9. Unresolved / Ambiguous Rules

| **Rule ID** | **Description**                                     | **Ambiguity**                                                   | **Recommended Action**             |
|-------------|-----------------------------------------------------|-----------------------------------------------------------------|------------------------------------|
| BR-005      | Grade mapping when no grades match any category      | What happens if OPTA returns grades not in the hardcoded list?  | SME review — confirm default behavior |
| BR-009      | DataCache.userInfo loaded but unused                 | Authorization uses `SUPPORTED_PROVINCE_LIST` config, not DataCache userInfo | Confirm if per-user province check was planned |
| BR-005      | `break` after first FirehallProtectedGrade           | Only the first firehall grade is evaluated — is this intentional? | SME review — confirm grade priority logic |
| BR-007      | Error handling for LDAP `AuthenticationException`    | Comment references LDAP error handling but code uses generic exception | Confirm error response for LDAP failures |

---

## 10. Notes & Observations

| **#** | **Observation**                                                                                       | **Related Rules** | **Impact**  |
|-------|-------------------------------------------------------------------------------------------------------|-------------------|-------------|
| 1     | Authorization and validation logic is duplicated across SOAP and Product/REST processors (BR-001/BR-011, BR-002/BR-012) | BR-001, BR-011, BR-002, BR-012 | Medium — maintenance risk |
| 2     | `DataCache.userInfo` is populated with per-user province mappings but never used for authorization; config-level `SUPPORTED_PROVINCE_LIST` is used instead | BR-009, BR-001 | Low — unused data loading |
| 3     | Fire protection grade category `"unprorected"` contains a typo — should be `"unprotected"` | BR-005 | High — API contract inconsistency |
| 4     | The `@Async` annotation on `TransactionLogger.logPayLoad()` may not work without Spring async configuration in OSGi | BR-006 | Medium — logging may be synchronous |
| 5     | `FusAuthResponseProcessor` extracts only `ResponseBody` from OPTA response but is only used in the security token route, not in the main response processing | BR-017 | Low — dead code |
| 6     | Error logging uses `LOGGER.info()` for error conditions instead of `LOGGER.error()` | BR-006 | Low — observability concern |
| 7     | `ws-security.validate.token` is set to `false`, meaning WS-Security tokens are not validated | BR-013 | High — security concern |

---

## 11. Potentially Missing Business Rules

| **#** | **Expected Rule Description**                           | **Business Domain**    | **Expected Category** | **Found in Code?** | **Evidence of Absence**                                                    | **Severity** | **Recommended Action**                    | **Linked Gap** |
|-------|---------------------------------------------------------|------------------------|----------------------|---------------------|----------------------------------------------------------------------------|--------------|-------------------------------------------|----------------|
| 1     | Postal code format validation (e.g., Canadian A1A 1A1)  | Data Quality           | Validation           | ❌ No               | `FusRequestPreProcessor` only checks blank, no format regex                | High         | Implement in target                       | GAP-002        |
| 2     | Province value validation (must be valid CA province)   | Data Quality           | Validation           | ❌ No               | Province is only checked against allowed list, not against valid values    | Medium       | Implement in target                       | GAP-012        |
| 3     | OAuth token caching and expiry management               | Performance            | Workflow             | ❌ No               | New token acquired for every request — no caching                          | High         | Implement token cache with TTL            | GAP-003        |
| 4     | Rate limiting / throttling                              | Security               | Constraint           | ❌ No               | No rate limiting found in any route or interceptor                         | Medium       | Implement in API Gateway or Camel route   | GAP-013        |
| 5     | Request payload size validation                         | Security               | Validation           | ❌ No               | No payload size checks found                                               | Medium       | Implement in target                       | GAP-014        |
| 6     | Input sanitization (XSS/injection prevention)           | Security               | Validation           | ❌ No               | String fields passed directly without sanitization                         | High         | Implement in target                       | GAP-015        |
| 7     | Response timeout handling for OPTA service              | Reliability            | Workflow             | ❌ No               | Timeout configured in conduit but no circuit breaker or retry logic        | Medium       | Implement circuit breaker pattern         | GAP-016        |
| 8     | Idempotency check for duplicate requests                | Data Integrity         | Constraint           | ❌ No               | No duplicate detection mechanism                                           | Low          | Confirm with business team                | GAP-017        |

---

## 12. Rule Execution Order & Conflicts

### 12.1 Rule Execution Chains

| **Trigger / Input Context**           | **Rule Execution Order**                                        | **Notes**                               |
|---------------------------------------|-----------------------------------------------------------------|-----------------------------------------|
| SOAP request to `/pl/api/oss/fus`     | BR-013 → BR-001 → BR-014 → BR-002 → BR-003 → BR-004 → BR-005 → BR-010 → BR-006 | Sequential, synchronous                 |
| REST request to `/pl/api/oss/rest/product/fus/` | BR-013 → BR-011 → BR-014 → BR-012 → BR-003 → BR-004 → BR-015 → BR-010 → BR-006 | Sequential, synchronous     |
| SOAP request to `/pl/api/oss/product/fus` | BR-013 → BR-011 → BR-014 → BR-012 → BR-003 → BR-004 → BR-015 → BR-010 → BR-006 | Sequential, synchronous          |
| Any error during processing           | BR-007 → BR-006                                                 | Error handler + async logging           |
| Application startup                   | BR-009                                                           | One-time, async file consumers          |

### 12.2 Rule Conflicts

| **Rule A** | **Rule B** | **Conflict Description**                                                     | **Resolution**                                                      | **Status**  |
|------------|------------|------------------------------------------------------------------------------|---------------------------------------------------------------------|-------------|
| BR-001     | BR-002     | Both check province: BR-001 checks empty+authorized, BR-002 checks blank    | BR-001 executes first; if province empty, BR-001 throws FS1004 before BR-002 runs | Resolved    |
| BR-001     | BR-009     | BR-001 uses config `SUPPORTED_PROVINCE_LIST`; BR-009 loads per-user provinces to DataCache | Config-level list takes precedence; DataCache user info is unused    | Open        |

---

## 13. Appendices

### Appendix A: Rule ID Naming Convention

_Format: BR-[NNN] where NNN is a sequential three-digit number._

### Appendix B: Glossary

| **Term**                   | **Definition**                                                          |
|----------------------------|-------------------------------------------------------------------------|
| FUS                        | Fire Underwriting Survey — OPTA product for dwelling fire protection    |
| OPTA Single Service (OSS)  | External third-party SOAP service providing insurance scoring data      |
| DwellingFireProtection     | Classification of property fire protection (hydrant, firehall, etc.)   |
| Province Authorization     | Check that the requested province is in the allowed list for scoring   |
| wireTap                    | Camel EIP pattern for asynchronous fire-and-forget message copying      |
| Jasypt                     | Java Simplified Encryption library for config property encryption       |
| DataCache                  | Thread-safe singleton cache for error messages and authorization data   |
| CXF                        | Apache CXF — web services framework for SOAP and REST                  |
| Blueprint                  | OSGi Blueprint — dependency injection container for OSGi bundles       |
| JAAS                       | Java Authentication and Authorization Service                          |

---

> **Document Control:**
> | Version | Date | Author | Changes |
> |---------|------|--------|---------|
> | 0.1 | 26-Jun-2025 | Copilot RE Pipeline | Initial draft — 18 business rules cataloged from source code analysis |
> | 0.2 | 26-Jun-2025 | Copilot RE Pipeline | Added: Rule health summary (2.1), Client validation/dead code/hardcoded flags (3.x), Source line refs (3.x), Execution priority (3.x), Validation existence check (4), Hardcoded override (5), Missing business rules (11), Rule execution order & conflicts (12) |
