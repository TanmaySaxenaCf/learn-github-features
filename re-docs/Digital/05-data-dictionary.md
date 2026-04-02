# Data Dictionary

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

This data dictionary provides a comprehensive catalog of all data entities, attributes, data types, relationships, and constraints identified in the CL-ESB-FUS application's data layer during reverse engineering. It covers the single database table (cl_fus_trans_log), API request/response payloads, in-memory cache structures, and configuration data stores.

---

## 2. Data Sources

| **Data Source**            | **Type**   | **Technology**            | **Schema/Database** | **Notes**                                           |
|----------------------------|------------|---------------------------|---------------------|-----------------------------------------------------|
| Transaction Log DB         | RDBMS      | JDBC (via Spring JdbcTemplate) | Unknown          | Single table for audit logging                      |
| Error Messages             | File       | JSON (error_messages.json) | Filesystem          | Loaded into DataCache at startup                    |
| Authorization Config       | File       | JSON (authorization_config.json) | Filesystem     | Loaded into DataCache at startup                    |
| EhCache Response Cache     | Cache      | EhCache (camel-cache)      | In-Memory           | Caches OPTA responses keyed by address hash         |
| Application Config         | File       | Java Properties            | Filesystem          | Service endpoints, credentials, timeouts            |

---

## 3. Entity Summary

| **Entity ID** | **Entity Name**             | **Data Source**       | **Type**    | **Record Count** | **Description**                                       |
|----------------|-----------------------------|-----------------------|-------------|------------------|-------------------------------------------------------|
| ENT-001        | cl_fus_trans_log            | Transaction Log DB    | Table       | Unknown          | Transaction audit log for all FUS requests/responses  |
| ENT-002        | FusProductRequest           | API (REST)            | DTO         | N/A              | REST query parameter input                            |
| ENT-003        | FusRequest                  | API (SOAP)            | DTO         | N/A              | SOAP request envelope                                 |
| ENT-004        | FUSResponse                 | API (SOAP)            | DTO         | N/A              | SOAP FUS response                                     |
| ENT-005        | FusProductResponse          | API (SOAP)            | DTO         | N/A              | SOAP full product response                            |
| ENT-006        | ErrorMessageLookup          | Error Messages JSON   | Reference   | 6                | Error code to message mapping                         |
| ENT-007        | AuthorizationLookup         | Authorization JSON    | Reference   | 3 users          | User to allowed provinces mapping                     |
| ENT-008        | FusTransactionLog           | In-Memory (POJO)      | DTO         | N/A              | Java representation of cl_fus_trans_log record        |
| ENT-009        | OSSRequestType              | OPTA Integration      | DTO         | N/A              | Generated WSDL request type for OPTA service          |
| ENT-010        | ResultType                  | OPTA Integration      | DTO         | N/A              | Generated WSDL response type with FUS scores          |

---

## 4. Entity Details

### 4.1 ENT-001: cl_fus_trans_log

| **Attribute**         | **Details**                                                    |
|-----------------------|----------------------------------------------------------------|
| **Entity ID**         | ENT-001                                                        |
| **Entity Name**       | cl_fus_trans_log                                               |
| **Schema**            | Unknown (external database)                                    |
| **Type**              | Table                                                          |
| **Description**       | Audit log recording every FUS request/response transaction for compliance and debugging |
| **Primary Key**       | None explicitly defined (transaction_id may serve as logical PK) |
| **Estimated Rows**    | Unknown                                                        |
| **Source File/Class** | TransactionLogger.java, FusTransactionLog.java                 |

#### Attributes / Columns

| **#** | **Column Name**          | **Data Type** | **Length/Precision** | **Nullable** | **Default** | **Constraints** | **Usage Status** | **Default/Hardcoded Value**    | **Mapping Reference** | **Description**                             |
|-------|--------------------------|---------------|----------------------|--------------|-------------|-----------------|------------------|--------------------------------|-----------------------|---------------------------------------------|
| 1     | transaction_id           | VARCHAR       | 255                  | Yes          | —           | —               | Active           | Generated UUID                 | —                     | Unique transaction identifier               |
| 2     | application              | VARCHAR       | 255                  | Yes          | —           | —               | Active           | "SOAP" / "REST" / "PRODUCT"   | —                     | Source endpoint type                        |
| 3     | url                      | VARCHAR       | 255                  | Yes          | —           | —               | Active           | None                           | —                     | Request URL                                 |
| 4     | transaction_time         | TIMESTAMP     | —                    | Yes          | —           | —               | Active           | Current timestamp              | —                     | Time of transaction                         |
| 5     | client_id                | VARCHAR       | 255                  | Yes          | —           | —               | Active           | None                           | —                     | Authenticated client identifier             |
| 6     | client_name              | VARCHAR       | 255                  | Yes          | —           | —               | Active           | None                           | —                     | Authenticated client display name           |
| 7     | client_guid              | VARCHAR       | 255                  | Yes          | —           | —               | Active           | None                           | —                     | Client global unique identifier             |
| 8     | dwelling_fire_protection | VARCHAR       | 255                  | Yes          | —           | —               | Active           | None                           | —                     | Fire protection indicator from request      |
| 9     | street_name              | VARCHAR       | 255                  | Yes          | —           | —               | Active           | None                           | —                     | Requested street address                    |
| 10    | postal_code              | VARCHAR       | 255                  | Yes          | —           | —               | Active           | None                           | —                     | Requested postal code                       |
| 11    | municipality             | VARCHAR       | 255                  | Yes          | —           | —               | Active           | None                           | —                     | Requested municipality                      |
| 12    | province                 | VARCHAR       | 255                  | Yes          | —           | —               | Active           | None                           | —                     | Requested province code                     |
| 13    | req_payload              | TEXT          | —                    | Yes          | —           | —               | Active           | JAXB XML serialization         | —                     | Full request payload (XML format)           |
| 14    | res_payload              | TEXT          | —                    | Yes          | —           | —               | Active           | JAXB XML serialization         | —                     | Full response payload (XML format)          |
| 15    | status                   | VARCHAR       | 255                  | Yes          | —           | —               | Active           | "success" or "error"           | —                     | Transaction outcome status                  |
| 16    | error_code               | VARCHAR       | 255                  | Yes          | —           | —               | Active           | None (null on success)         | —                     | Error code if transaction failed            |
| 17    | error_message            | TEXT          | —                    | Yes          | —           | —               | Active           | None (null on success)         | —                     | Error description if transaction failed     |

#### Indexes

| **Index Name** | **Columns** | **Type** | **Unique** | **Notes**                                  |
|----------------|-------------|----------|------------|--------------------------------------------|
| —              | —           | —        | —          | No indexes defined in source code          |

#### Foreign Key Relationships

| **FK Name** | **Column(s)** | **References** | **On Delete** | **On Update** |
|-------------|---------------|----------------|---------------|---------------|
| —           | —             | —              | —             | —             |

_No foreign keys — standalone audit table._

#### Check Constraints

| **Constraint Name** | **Column(s)** | **Expression**                   |
|---------------------|---------------|----------------------------------|
| —                   | —             | No check constraints defined     |

#### Triggers

| **Trigger Name** | **Event** | **Timing** | **Description** |
|-------------------|-----------|------------|-----------------|
| —                 | —         | —          | No triggers     |

---

### 4.2 ENT-006: ErrorMessageLookup

| **Attribute**         | **Details**                                                    |
|-----------------------|----------------------------------------------------------------|
| **Entity ID**         | ENT-006                                                        |
| **Entity Name**       | ErrorMessageLookup                                             |
| **Schema**            | In-Memory (DataCache)                                          |
| **Type**              | Reference Data (JSON-loaded)                                   |
| **Description**       | Maps error codes to English and French error messages for consistent error responses |
| **Primary Key**       | errorCode                                                      |
| **Estimated Rows**    | 6                                                              |
| **Source File/Class** | ErrorMessageLookup.java, error_messages.json                   |

#### Attributes / Columns

| **#** | **Column Name**  | **Data Type** | **Length/Precision** | **Nullable** | **Default** | **Constraints** | **Usage Status** | **Default/Hardcoded Value** | **Mapping Reference** | **Description**               |
|-------|------------------|---------------|----------------------|--------------|-------------|-----------------|------------------|-----------------------------|----------------------|-------------------------------|
| 1     | errorCode        | String        | —                    | No           | —           | Unique          | Active           | None                        | —                    | Error identifier (FS1001-FS2001) |
| 2     | errorDesc        | String        | —                    | No           | —           | —               | Active           | None                        | —                    | English error message         |
| 3     | errorDesc_fr     | String        | —                    | Yes          | ""          | —               | Dead             | Always empty string         | —                    | French error message (unused) |

---

### 4.3 ENT-007: AuthorizationLookup

| **Attribute**         | **Details**                                                    |
|-----------------------|----------------------------------------------------------------|
| **Entity ID**         | ENT-007                                                        |
| **Entity Name**       | AuthorizationLookup                                            |
| **Schema**            | In-Memory (DataCache)                                          |
| **Type**              | Reference Data (JSON-loaded)                                   |
| **Description**       | Maps usernames to lists of provinces they are authorized to query |
| **Primary Key**       | userName                                                       |
| **Estimated Rows**    | 3                                                              |
| **Source File/Class** | AuthorizationLookup.java, authorization_config.json            |

#### Attributes / Columns

| **#** | **Column Name**    | **Data Type**   | **Length/Precision** | **Nullable** | **Default** | **Constraints** | **Usage Status** | **Default/Hardcoded Value** | **Mapping Reference** | **Description**                          |
|-------|--------------------|-----------------|----------------------|--------------|-------------|-----------------|------------------|-----------------------------|----------------------|------------------------------------------|
| 1     | userName           | String          | —                    | No           | —           | Unique          | Active           | None                        | —                    | LDAP username                            |
| 2     | allowedProvinces   | String[]        | —                    | No           | —           | —               | Active           | None                        | —                    | List of province codes (e.g., ON, BC)    |

---

## 5. Entity Relationship Summary

### 5.1 Relationship Matrix

| **Parent Entity**        | **Child Entity**       | **Relationship**                                   | **Cardinality** | **FK Column(s)** |
|--------------------------|------------------------|----------------------------------------------------|-----------------|------------------|
| FusProductRequest (ENT-002)| OSSRequestType (ENT-009)| Request fields mapped to OPTA request structure  | 1:1             | N/A (mapping)    |
| OSSRequestType (ENT-009)  | ResultType (ENT-010)    | OPTA request produces result response             | 1:N             | N/A (API)        |
| FusTransactionLog (ENT-008)| cl_fus_trans_log (ENT-001)| Java POJO maps to database table               | 1:1             | All columns      |
| ErrorMessageLookup (ENT-006)| ErrorProcessor         | Error codes referenced during error handling      | 1:N             | errorCode        |

### 5.2 ER Diagram (Text Representation)

```
┌──────────────────────┐        ┌──────────────────────┐
│  FusProductRequest   │──maps──▶│   OSSRequestType     │
│  (ENT-002)           │  1:1   │   (ENT-009)          │
│                      │        │                      │
│  streetName          │        │  requestHeader       │
│  postalCode          │        │  requestBody         │
│  municipality        │        │  products[]          │
│  province            │        │                      │
│  ibcCode             │        └──────────┬───────────┘
│  naicsCode           │                   │
│  sicCode             │                   │ 1:N
└──────────────────────┘                   ▼
                                ┌──────────────────────┐
                                │    ResultType        │
                                │    (ENT-010)         │
                                │                      │
                                │  Address             │
                                │  ProductResults      │
                                │    └─ FUSProduct     │
                                └──────────────────────┘

┌──────────────────────┐        ┌──────────────────────┐
│  FusTransactionLog   │──maps──▶│  cl_fus_trans_log    │
│  (ENT-008)           │  1:1   │  (ENT-001)           │
│                      │        │                      │
│  17 Java fields      │        │  17 DB columns       │
└──────────────────────┘        └──────────────────────┘

┌──────────────────────┐        ┌──────────────────────┐
│ ErrorMessageLookup   │◀─refs──│   ErrorProcessor     │
│ (ENT-006)            │  N:1   │   (COMP-004)         │
│                      │        │                      │
│  errorCode           │        │  lookup(errorCode)   │
│  errorDesc           │        │                      │
└──────────────────────┘        └──────────────────────┘
```

---

## 6. Enumerated Values / Reference Data

| **Entity/Column**            | **Code**  | **Display Value**                                                 | **Description**                             | **Used in Source** | **Active** |
|------------------------------|-----------|-------------------------------------------------------------------|---------------------------------------------|--------------------|------------|
| ErrorMessageLookup.errorCode | FS1001    | Street Address field is blank                                     | Validation: missing street address          | ✅ Yes              | Yes        |
| ErrorMessageLookup.errorCode | FS1002    | Postal Code field is blank                                        | Validation: missing postal code             | ✅ Yes              | Yes        |
| ErrorMessageLookup.errorCode | FS1003    | Municipality field is blank                                       | Validation: missing municipality            | ✅ Yes              | Yes        |
| ErrorMessageLookup.errorCode | FS1004    | Province field is blank                                           | Validation: missing province                | ✅ Yes              | Yes        |
| ErrorMessageLookup.errorCode | FS1005    | Provided Province is not authorized to view operation.            | Authorization: province not in allowed list | ✅ Yes              | Yes        |
| ErrorMessageLookup.errorCode | FS2001    | Technical Error Occurred. Please contact Technical Team.          | Catch-all technical error                   | ✅ Yes              | Yes        |
| LoggerConstants.APPLICATION  | SOAP      | SOAP                                                              | Transaction log: SOAP endpoint              | ✅ Yes              | Yes        |
| LoggerConstants.APPLICATION  | REST      | REST                                                              | Transaction log: REST endpoint              | ✅ Yes              | Yes        |
| LoggerConstants.APPLICATION  | PRODUCT   | PRODUCT                                                           | Transaction log: Full product endpoint      | ✅ Yes              | Yes        |
| LoggerConstants.STATUS       | success   | success                                                           | Transaction log: successful request         | ✅ Yes              | Yes        |
| LoggerConstants.STATUS       | error     | error                                                             | Transaction log: failed request             | ✅ Yes              | Yes        |
| AuthorizationLookup.userName | catalyst_esb_user | catalyst_esb_user                                       | Authorized user for Catalyst service        | ✅ Yes              | Yes        |
| AuthorizationLookup.provinces| ON        | Ontario                                                           | Province authorization                      | ✅ Yes              | Yes        |
| AuthorizationLookup.provinces| BC        | British Columbia                                                  | Province authorization                      | ✅ Yes              | Yes        |

---

## 7. API Data Structures

### 7.1 FusProductRequest (REST Input)

| **Attribute**        | **Details**                                  |
|----------------------|----------------------------------------------|
| **Structure Name**   | FusProductRequest                            |
| **Used In**          | GET /pl/api/oss/rest/product                 |
| **Format**           | Query Parameters (URL-encoded)               |

| **Field Name**  | **Data Type** | **Required** | **Validation**               | **Usage Status** | **Default/Hardcoded Value** | **Mapping Reference** | **Description**                       |
|-----------------|---------------|--------------|------------------------------|------------------|-----------------------------|-----------------------|---------------------------------------|
| streetName      | String        | Yes          | Not null/blank (BR-001)      | Active           | None                        | —                     | Street address for property lookup    |
| postalCode      | String        | Yes          | Not null/blank (BR-002)      | Active           | None                        | —                     | Canadian postal code                  |
| municipality    | String        | Yes          | Not null/blank (BR-003)      | Active           | None                        | —                     | City/municipality name                |
| province        | String        | Yes          | Not null/blank (BR-004); must be authorized (BR-005) | Active | None              | —                     | Canadian province code (e.g., ON)     |
| ibcCode         | String        | No           | None                         | Active           | None                        | —                     | Insurance Bureau of Canada code       |
| naicsCode       | String        | No           | None                         | Active           | None                        | —                     | North American Industry Classification|
| sicCode         | String        | No           | None                         | Active           | None                        | —                     | Standard Industrial Classification    |

#### Sample Payload

```
GET /pl/api/oss/rest/product?streetName=3202+Tania+Cres&postalCode=L7M3M7&municipality=Burlington&province=ON
```

---

### 7.2 FusRequest (SOAP Input)

| **Attribute**        | **Details**                               |
|----------------------|-------------------------------------------|
| **Structure Name**   | FusRequest                                |
| **Used In**          | POST /pl/api/oss/fus (SOAP)              |
| **Format**           | XML (JAXB)                                |

| **Field Name**                         | **Data Type**                    | **Required** | **Validation**              | **Usage Status** | **Default/Hardcoded Value** | **Mapping Reference** | **Description**              |
|----------------------------------------|----------------------------------|--------------|------------------------------|------------------|-----------------------------|-----------------------|------------------------------|
| baseRequest                            | BaseRequest (Object)             | Yes          | None                         | Active           | None                        | —                     | Contains client info         |
| baseRequest.clientInfo                 | ClientInfo (Object)              | Yes          | None                         | Active           | None                        | —                     | Client authentication data   |
| baseRequest.clientInfo.clientId        | String                           | Yes          | None                         | Active           | None                        | —                     | Client identifier            |
| baseRequest.clientInfo.clientName      | String                           | Yes          | None                         | Active           | None                        | —                     | Client display name          |
| baseRequest.clientInfo.clientGuid      | String                           | Yes          | None                         | Active           | None                        | —                     | Client GUID                  |
| dwellingFireProtectionRequest          | DwellingFireProtectionRequest    | Yes          | None                         | Active           | None                        | —                     | Address and industry codes   |
| dwellingFireProtectionRequest.streetName | String                         | Yes          | Not null/blank (BR-001)      | Active           | None                        | —                     | Street address               |
| dwellingFireProtectionRequest.postalCode | String                         | Yes          | Not null/blank (BR-002)      | Active           | None                        | —                     | Postal code                  |
| dwellingFireProtectionRequest.municipality | String                       | Yes          | Not null/blank (BR-003)      | Active           | None                        | —                     | Municipality                 |
| dwellingFireProtectionRequest.province | String                           | Yes          | Not null/blank (BR-004); authorized (BR-005) | Active | None                   | —                     | Province code                |

#### Sample Payload

```xml
<FusRequest xmlns="http://api.esb.ca.aviva.com/v1.0/">
  <baseRequest>
    <clientInfo>
      <clientId>catalyst_esb_user</clientId>
      <clientName>Catalyst</clientName>
      <clientGuid>abc-123-def</clientGuid>
    </clientInfo>
  </baseRequest>
  <DwellingFireProtectionRequest>
    <streetName>3202 Tania Cres</streetName>
    <postalCode>L7M3M7</postalCode>
    <municipality>Burlington</municipality>
    <province>ON</province>
  </DwellingFireProtectionRequest>
</FusRequest>
```

---

### 7.3 REST Response (ResultType)

| **Attribute**        | **Details**                               |
|----------------------|-------------------------------------------|
| **Structure Name**   | List\<ResultType\>                        |
| **Used In**          | GET /pl/api/oss/rest/product (response)   |
| **Format**           | JSON                                      |

| **Field Name**                                | **Data Type** | **Required** | **Validation** | **Usage Status** | **Default/Hardcoded Value** | **Mapping Reference** | **Description**                    |
|-----------------------------------------------|---------------|--------------|----------------|------------------|-----------------------------|-----------------------|------------------------------------|
| Result                                        | Array         | Yes          | —              | Active           | None                        | —                     | Array of result objects            |
| Result[].ActivityID                           | String        | No           | —              | Active           | null                        | —                     | Activity identifier                |
| Result[].Address                              | Object        | Yes          | —              | Active           | None                        | —                     | Resolved address details           |
| Result[].Address.AddressID                    | String        | Yes          | —              | Active           | "1" (hardcoded)             | —                     | Address identifier                 |
| Result[].Address.OptaAddressKey               | String        | Yes          | —              | Active           | None                        | —                     | OPTA address key                   |
| Result[].Address.StreetNumber                 | String        | Yes          | —              | Active           | None                        | —                     | Resolved street number             |
| Result[].Address.StreetName                   | String        | Yes          | —              | Active           | None                        | —                     | Resolved street name               |
| Result[].Address.StreetType                   | String        | Yes          | —              | Active           | None                        | —                     | Resolved street type               |
| Result[].Address.Municipality                 | String        | Yes          | —              | Active           | None                        | —                     | Resolved municipality              |
| Result[].Address.Province                     | String        | Yes          | —              | Active           | None                        | —                     | Resolved province                  |
| Result[].Address.PostalCode                   | String        | Yes          | —              | Active           | None                        | —                     | Resolved postal code               |
| Result[].ProductResults                       | Object        | Yes          | —              | Active           | None                        | —                     | Product result container           |
| Result[].ProductResults.FUSProduct            | Object        | Yes          | —              | Active           | None                        | —                     | FUS product details                |
| Result[].ProductResults.FUSProduct.Dwelling   | Object        | Yes          | —              | Active           | None                        | —                     | Dwelling fire protection details   |
| Result[].ProductResults.FUSProduct.Commercial | Object        | Yes          | —              | Active           | None                        | —                     | Commercial fire protection details |
| Result[].ProductResults.FUSProduct.EarthquakeCodes | Array   | No           | —              | Active           | None                        | —                     | Seismic zone codes                 |
| Result[].ProductResults.FUSProduct.HydrantCounts   | Array   | No           | —              | Active           | None                        | —                     | Nearby hydrant information         |

#### Sample Payload

```json
{
  "Result": [{
    "ActivityID": null,
    "Address": {
      "AddressID": "1",
      "OptaAddressKey": "00A-00A-00P",
      "StreetNumber": "3202",
      "StreetName": "Tania",
      "StreetType": "Crescent",
      "Municipality": "Burlington",
      "Province": "ON",
      "PostalCode": "L7M3M7"
    },
    "ProductResults": {
      "FUSProduct": {
        "Dwelling": {},
        "Commercial": {},
        "EarthquakeCodes": [],
        "HydrantCounts": []
      }
    }
  }]
}
```

---

### 7.4 Error Response

| **Attribute**        | **Details**                               |
|----------------------|-------------------------------------------|
| **Structure Name**   | ErrorDetails                              |
| **Used In**          | All endpoints (error cases)               |
| **Format**           | JSON (REST) / SOAP Fault (SOAP)           |

| **Field Name** | **Data Type** | **Required** | **Validation** | **Usage Status** | **Default/Hardcoded Value** | **Mapping Reference** | **Description**       |
|----------------|---------------|--------------|----------------|------------------|-----------------------------|-----------------------|-----------------------|
| code           | String        | Yes          | —              | Active           | None                        | —                     | Error code (FS1001…)  |
| message        | String        | Yes          | —              | Active           | None                        | —                     | Error description     |

#### Sample Payload

```json
{
  "code": "FS1001",
  "message": "Street Address field is blank"
}
```

---

### 7.5 FusAuthResponse (OAuth Token)

| **Attribute**        | **Details**                               |
|----------------------|-------------------------------------------|
| **Structure Name**   | FusAuthResponse                           |
| **Used In**          | Internal (OPTA Auth sub-route)            |
| **Format**           | JSON                                      |

| **Field Name**  | **Data Type** | **Required** | **Validation** | **Usage Status** | **Default/Hardcoded Value** | **Mapping Reference** | **Description**                |
|-----------------|---------------|--------------|----------------|------------------|-----------------------------|-----------------------|--------------------------------|
| access_token    | String        | Yes          | —              | Active           | None                        | —                     | OAuth Bearer token             |
| token_type      | String        | Yes          | —              | Active           | "Bearer"                    | —                     | Token type                     |
| expires_in      | Integer       | Yes          | —              | Active           | None                        | —                     | Token expiry in seconds        |
| refresh_token   | String        | No           | —              | Active           | None                        | —                     | New refresh token if rotated   |

---

## 8. Configuration Data

| **Key/Property**                | **Data Type** | **Default Value**                                           | **Description**                                       | **Source File**           |
|---------------------------------|---------------|-------------------------------------------------------------|-------------------------------------------------------|---------------------------|
| AUTHORIZATION_LOOKUP            | String        | /app/opdata/properties/catalyst/fus/json/?fileName=...     | Path to authorization JSON file                       | app_config.properties     |
| ERROR_MSG_LOOKUP                | String        | /app/opdata/properties/catalyst/fus/json/?fileName=...     | Path to error messages JSON file                      | app_config.properties     |
| LDAP_LOGIN                      | String        | LDAPLogin                                                   | JAAS LoginModule name for LDAP auth                   | app_config.properties     |
| TRUST_STOREPATH                 | String        | /app/catalyst/keystore/truststore.jks                       | Path to TLS truststore                                | app_config.properties     |
| TRUST_PWD                       | String        | ENC(...)                                                    | Encrypted truststore password                         | app_config.properties     |
| FUS_REQUESTID_PREFIX            | String        | dev.aviva.ca-                                               | Prefix for OPTA request IDs                           | app_config.properties     |
| FUS_DEFAULT_BROKERAGE           | String        | ABC Brokerage                                               | Default brokerage for OPTA requests                   | app_config.properties     |
| FUS_DEFAULT_CARRIER             | String        | Aviva                                                       | Default carrier for OPTA requests                     | app_config.properties     |
| FUS_DEFAULT_USERNAME            | String        | ENC(...)                                                    | Encrypted default username for OPTA                   | app_config.properties     |
| FUS_CONNECTION_TIMEOUT          | Integer       | 30000                                                       | HTTP connection timeout (ms)                          | app_config.properties     |
| FUS_RECEIVE_TIMEOUT             | Integer       | 30000                                                       | HTTP receive timeout (ms)                             | app_config.properties     |
| FUS_AUTH_ENDPOINT_URL           | String        | https://qa.avivacanadaservices.com:9444/services/...        | OPTA OAuth token endpoint                             | app_config.properties     |
| FUS_AUTH_TOKEN                  | String        | eyJ... (JWT)                                                | OAuth refresh token                                   | app_config.properties     |
| FUS_GRANT_TYPE                  | String        | refresh_token                                               | OAuth grant type                                      | app_config.properties     |
| FUS_CLIENT_SECRET               | String        | d23cf6e4-...                                                | OAuth client secret (NOT encrypted)                   | app_config.properties     |
| FUS_CLIENT_ID                   | String        | opta_single_service                                         | OAuth client identifier                               | app_config.properties     |
| FUS_WITHAUTH_ENDPOINT_URL       | String        | https://qa.avivacanadaservices.com/services/OPTAPS_a        | OPTA service endpoint URL                             | app_config.properties     |
| SUPPORTED_PROVINCE_LIST         | String        | (comma-separated province codes)                            | Provinces authorized for FUS queries                  | app_config.properties     |
| spring.application.name         | String        | task-manager                                                | Spring Boot app name (TaskManager demo)               | application.properties    |
| spring.datasource.url           | String        | jdbc:h2:mem:taskdb                                          | H2 database URL (TaskManager demo)                    | application.properties    |
| server.port                     | Integer       | 8080                                                        | HTTP server port (TaskManager demo)                   | application.properties    |

---

## 9. Data Quality Observations

| **#** | **Entity**          | **Issue**                                                    | **Severity** | **Recommendation**                          |
|-------|---------------------|--------------------------------------------------------------|--------------|---------------------------------------------|
| 1     | cl_fus_trans_log    | No primary key defined — duplicate records possible          | High         | Add PK on transaction_id                    |
| 2     | cl_fus_trans_log    | No indexes — query performance concerns at scale             | Med          | Add index on transaction_id, transaction_time|
| 3     | cl_fus_trans_log    | All columns nullable — no NOT NULL constraints               | Med          | Add NOT NULL on key fields                  |
| 4     | cl_fus_trans_log    | No data retention/archival policy                            | Med          | Define TTL or archival strategy             |
| 5     | FusProductRequest   | No format validation on postalCode (expected A1A1A1 pattern) | High         | Add regex validation                        |
| 6     | FusProductRequest   | No length constraints on any field                           | Med          | Add @Size constraints                       |
| 7     | ErrorMessageLookup  | French error descriptions all empty                          | Low          | Populate or remove i18n support             |
| 8     | AuthorizationLookup | Only 3 users configured — may not reflect production         | Low          | Confirm production user list                |

---

## 10. Validation Rules Matrix

### 10.1 Existing Validations

| **Entity / DTO**     | **Field Name**  | **Validation Type** | **Validation Logic**        | **Source Location**                  | **Notes**                   |
|----------------------|-----------------|---------------------|-----------------------------|--------------------------------------|-----------------------------|
| FusProductRequest    | streetName      | Required            | Not null, not blank         | FusRequestPreProcessor.java          | Error: FS1001               |
| FusProductRequest    | postalCode      | Required            | Not null, not blank         | FusRequestPreProcessor.java          | Error: FS1002               |
| FusProductRequest    | municipality    | Required            | Not null, not blank         | FusRequestPreProcessor.java          | Error: FS1003               |
| FusProductRequest    | province        | Required            | Not null, not blank         | FusAuthorizationProcessor.java       | Error: FS1004               |
| FusProductRequest    | province        | Authorization       | Must be in allowed list     | FusAuthorizationProcessor.java       | Error: FS1005               |

### 10.2 Missing Validations (Gaps)

| **Entity / DTO**     | **Field Name**  | **Expected Validation**              | **Risk if Not Validated**                  | **Severity** | **Linked Gap** |
|----------------------|-----------------|--------------------------------------|--------------------------------------------|--------------|----------------|
| FusProductRequest    | postalCode      | Canadian postal code format (A1A1A1) | Invalid postal codes sent to OPTA          | High         | —              |
| FusProductRequest    | province        | Valid 2-letter province code         | Invalid province codes sent to OPTA        | Med          | —              |
| FusProductRequest    | streetName      | Max length check                     | Excessively long input could cause issues  | Med          | —              |
| FusProductRequest    | municipality    | Max length check                     | Excessively long input could cause issues  | Med          | —              |
| FusProductRequest    | ibcCode         | Numeric format check                 | Invalid industry codes sent to OPTA        | Low          | —              |
| FusProductRequest    | naicsCode       | Numeric format check                 | Invalid industry codes sent to OPTA        | Low          | —              |
| FusProductRequest    | sicCode         | Numeric format check                 | Invalid industry codes sent to OPTA        | Low          | —              |
| FusRequest           | clientInfo      | Not null check                       | NullPointerException in logging            | Med          | —              |

---

## 11. NoSQL / Document Store Field Catalog

_No NoSQL or document stores are used in this application. The DataCache singleton stores data in-memory using Java HashMap structures loaded from JSON files._

---

## 12. Appendices

### Appendix A: Data Type Mapping

| **Database Type**   | **Java Type**       | **API Type**      | **Notes**                            |
|---------------------|---------------------|-------------------|--------------------------------------|
| VARCHAR(n)          | String              | string            | Used for most fields                 |
| TEXT                | String              | string            | Used for payloads (req/res XML)      |
| TIMESTAMP           | Date / Timestamp    | string (ISO-8601) | Transaction time                     |
| —                   | String[]            | array             | Allowed provinces (in-memory only)   |

### Appendix B: Glossary

| **Term**     | **Definition**                                                        |
|--------------|-----------------------------------------------------------------------|
| FUS          | Fire Underwriting Score — fire risk rating for properties              |
| OPTA         | Property risk data provider (OptaIntel)                               |
| ESB          | Enterprise Service Bus                                                 |
| JAXB         | Java Architecture for XML Binding — XML serialization framework       |
| DataCache    | In-memory singleton storing error messages and authorization data      |
| wireTap      | Apache Camel pattern for async message duplication                     |

### Appendix C: Field Usage Status Definitions

| **Status**       | **Definition**                                                          |
|------------------|-------------------------------------------------------------------------|
| **Active**       | Field is actively used in processing, business logic, and/or response   |
| **Logging Only** | Field is only written to the log/transaction data store                 |
| **Dead**         | Field exists in the model/DTO/schema but is never populated or consumed |
| **Deprecated**   | Field is marked or planned for removal                                  |

---

> **Document Control:**
> | Version | Date | Author | Changes |
> |---------|------|--------|---------|
> | 0.1 | 01-Apr-2026 | Copilot | Initial draft |
