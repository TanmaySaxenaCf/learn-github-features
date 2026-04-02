# Sequence Diagrams

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

This document contains sequence diagrams capturing the runtime interaction patterns between components, services, and actors in the CL-ESB-FUS application. Each diagram represents a specific Camel route or workflow identified during reverse engineering. The application exposes OPTA Single Service (FUS) via REST and SOAP endpoints, processing requests through a chain of Camel processors.

### Diagram Notation

| **Symbol**   | **Meaning**                                           |
|--------------|-------------------------------------------------------|
| `──▶`        | Synchronous request                                   |
| `──▷`        | Asynchronous request                                  |
| `◀──`        | Synchronous response                                  |
| `◁──`        | Asynchronous response / callback                      |
| `──X`        | Message lost / failure                                |
| `[alt]`      | Alternative (conditional) flow                        |
| `[loop]`     | Repeated execution                                    |
| `[opt]`      | Optional execution                                    |

### Annotation Notation

| **Annotation**             | **Meaning**                                                       |
|----------------------------|-------------------------------------------------------------------|
| `⚠️ GAP`                   | Missing validation or functionality at this step                  |
| `⚪ HARDCODED`             | Step returns a hardcoded/static value instead of dynamic logic    |
| `⚫ DEAD CODE`             | Flow path exists in code but is never executed                    |
| `🔴 CRITICAL`              | Critical finding that must be addressed before migration          |
| `📝 NOTE`                  | General observation or clarification                              |

---

## 2. Sequence Diagram Index

| **Diagram ID** | **Title**                               | **Use Case / Workflow**                | **Actors/Components**                                         | **Priority** |
|-----------------|-----------------------------------------|----------------------------------------|---------------------------------------------------------------|--------------|
| SD-001          | REST FUS Score Request                  | REST endpoint full request flow        | Client, JAAS Auth, Camel Route, Processors, OPTA, DB          | High         |
| SD-002          | SOAP FUS Score Request                  | SOAP endpoint full request flow        | Client, WS-Security, Camel Route, Processors, OPTA, DB        | High         |
| SD-003          | OAuth Token Acquisition                 | Security token sub-route               | Camel Route, Auth Processor, OPTA Auth Endpoint               | High         |
| SD-004          | JSON Cache Loading                      | Startup data loading                   | Camel Route, File Endpoint, DataCacheLoader, DataCache         | Med          |
| SD-005          | Error Handling Flow                     | Exception processing                   | Any Processor, ErrorProcessor, TransactionLogger               | High         |
| SD-006          | SOAP Full Response FUS Request          | Full product response SOAP flow        | Client, WS-Security, Camel Route, Processors, OPTA, DB        | Med          |

---

## 3. Sequence Diagrams

### 3.1 SD-001: REST FUS Score Request

**Use Case:** Consumer retrieves FUS fire protection score via REST GET endpoint
**Description:** End-to-end flow for a REST request from client authentication through OPTA service call and response transformation
**Trigger:** HTTP GET request to `/pl/api/oss/rest/product` with query parameters
**Pre-conditions:** Client has valid LDAP credentials; OPTA service is available; DataCache is loaded
**Post-conditions:** JSON response with FUS score returned; transaction logged to database

#### Participants

| **Participant**                       | **Type**   | **Component ID** | **Description**                             |
|---------------------------------------|------------|-------------------|---------------------------------------------|
| Client                                | Actor      | —                 | Internal system consumer (e.g., Catalyst)   |
| JAASAuthenticationFilter              | Service    | COMP-010          | LDAP-based authentication filter            |
| SimpleAuthorizingInterceptor          | Service    | COMP-010          | Role-based authorization (eEsbPlApiOptaAccess) |
| FusFullResAuthorizationProcessor      | Service    | COMP-004          | Province-level authorization                |
| FusFullResRequestPreProcessor         | Service    | COMP-004          | Input validation (required fields)          |
| FusAuthServiceProcessor               | Service    | COMP-004          | OAuth token request builder                 |
| OPTA Auth Endpoint                    | Service    | External          | OAuth token service                         |
| FusFullResAuthRequestProcessor        | Service    | COMP-004          | Transforms request to OSSRequestType        |
| OPTA Single Service (OSS)             | Service    | External          | OPTA FUS scoring service (SOAP)             |
| FusFullResAuthServiceResponseProcessor| Service    | COMP-004          | Transforms OPTA response to JSON            |
| TransactionLogger                     | Service    | COMP-006          | Async database logging                      |
| Transaction DB                        | DB         | —                 | cl_fus_trans_log table                      |

#### Sequence Diagram (ASCII)

```
┌────────┐  ┌─────────┐  ┌──────────┐  ┌──────────┐  ┌──────────┐  ┌──────────┐  ┌──────────┐  ┌──────────┐  ┌──────────┐  ┌────────┐
│ Client │  │JAAS Auth│  │Auth Intcp│  │Province  │  │Validator │  │Token Svc │  │OPTA Auth │  │Req Xform │  │OPTA OSS  │  │Res Xform│
└───┬────┘  └────┬────┘  └────┬─────┘  └────┬─────┘  └────┬─────┘  └────┬─────┘  └────┬─────┘  └────┬─────┘  └────┬─────┘  └────┬────┘
    │            │            │             │             │             │             │             │             │             │
    │ GET /pl/api/oss/rest/product?streetName=...&postalCode=...       │             │             │             │             │
    │ Authorization: Basic <credentials>   │             │             │             │             │             │             │
    │───────────▶│            │             │             │             │             │             │             │             │
    │            │            │             │             │             │             │             │             │             │
    │            │ LDAP       │             │             │             │             │             │             │             │
    │            │ validate   │             │             │             │             │             │             │             │
    │            │───────────▶│             │             │             │             │             │             │             │
    │            │            │             │             │             │             │             │             │             │
    │            │  role check│             │             │             │             │             │             │             │
    │            │  (eEsbPlApiOptaAccess)   │             │             │             │             │             │             │
    │            │◀───────────│             │             │             │             │             │             │             │
    │            │            │             │             │             │             │             │             │             │
    │            │ pass to Camel route      │             │             │             │             │             │             │
    │            │─────────────────────────▶│             │             │             │             │             │             │
    │            │            │             │             │             │             │             │             │             │
    │            │            │             │ process()   │             │             │             │             │             │
    │            │            │             │ validate    │             │             │             │             │             │
    │            │            │             │ province    │             │             │             │             │             │
    │            │            │             │────────────▶│             │             │             │             │             │
    │            │            │             │             │             │             │             │             │             │
    │            │            │             │             │ validate    │             │             │             │             │
    │            │            │             │             │ streetName, │             │             │             │             │
    │            │            │             │             │ postalCode, │             │             │             │             │
    │            │            │             │             │ municipality│             │             │             │             │
    │            │            │             │◀────────────│             │             │             │             │             │
    │            │            │             │             │             │             │             │             │             │
    │            │            │             │ get OAuth token           │             │             │             │             │
    │            │            │             │────────────────────────────────────────▶│             │             │             │
    │            │            │             │             │             │             │             │             │             │
    │            │            │             │             │             │ POST token  │             │             │             │
    │            │            │             │             │             │────────────▶│             │             │             │
    │            │            │             │             │             │             │             │             │             │
    │            │            │             │             │             │ Bearer token│             │             │             │
    │            │            │             │             │             │◀────────────│             │             │             │
    │            │            │             │             │             │             │             │             │             │
    │            │            │             │◀────────────────────────────────────────│             │             │             │
    │            │            │             │             │             │             │             │             │             │
    │            │            │             │ build OSSRequest          │             │             │             │             │
    │            │            │             │──────────────────────────────────────────────────────▶│             │             │
    │            │            │             │             │             │             │             │             │             │
    │            │            │             │             │             │             │             │ SOAP call   │             │
    │            │            │             │             │             │             │             │────────────▶│             │
    │            │            │             │             │             │             │             │             │             │
    │            │            │             │             │             │             │             │ OSSResponse │             │
    │            │            │             │             │             │             │             │◀────────────│             │
    │            │            │             │             │             │             │             │             │             │
    │            │            │             │◀──────────────────────────────────────────────────────│             │             │
    │            │            │             │             │             │             │             │             │             │
    │            │            │             │ transform response to JSON│             │             │             │             │
    │            │            │             │─────────────────────────────────────────────────────────────────────────────────▶│
    │            │            │             │             │             │             │             │             │             │
    │            │            │             │             │             │             │   JSON result (List<ResultType>)       │
    │            │            │             │◀─────────────────────────────────────────────────────────────────────────────────│
    │            │            │             │             │             │             │             │             │             │
    │  HTTP 200 JSON         │             │             │             │             │             │             │             │
    │◀──────────────────────────────────────│             │             │             │             │             │             │
    │            │            │             │             │             │             │             │             │             │
    │            │            │             │ wireTap → TransactionLogger (async)     │             │             │             │
    │            │            │             │──▷ log transaction to DB                │             │             │             │
    │            │            │             │             │             │             │             │             │             │
┌───┴────┐  ┌────┴────┐  ┌────┴─────┐  ┌────┴─────┐  ┌────┴─────┐  ┌────┴─────┐  ┌────┴─────┐  ┌────┴─────┐  ┌────┴─────┐  ┌────┴────┐
│ Client │  │JAAS Auth│  │Auth Intcp│  │Province  │  │Validator │  │Token Svc │  │OPTA Auth │  │Req Xform │  │OPTA OSS  │  │Res Xform│
└────────┘  └─────────┘  └──────────┘  └──────────┘  └──────────┘  └──────────┘  └──────────┘  └──────────┘  └──────────┘  └─────────┘
```

#### Step-by-Step Description

| **Step** | **From**               | **To**                          | **Message/Action**                                            | **Type** | **Annotations**                | **Notes**                                           |
|----------|------------------------|---------------------------------|---------------------------------------------------------------|----------|--------------------------------|-----------------------------------------------------|
| 1        | Client                 | JAASAuthenticationFilter        | GET /pl/api/oss/rest/product with Basic Auth header           | Sync     | None                           | Query params: streetName, postalCode, municipality, province |
| 2        | JAASAuthenticationFilter| LDAP                           | Validate credentials against LDAP directory                   | Sync     | None                           | Uses JAAS LoginModule configured as `LDAPLogin`     |
| 3        | SimpleAuthorizingInterceptor | —                          | Check user has role `eEsbPlApiOptaAccess`                     | Sync     | None                           | Returns 403 if role missing                         |
| 4        | Camel Route            | FusFullResAuthorizationProcessor| process(Exchange) — validate province against authorized list | Sync     | ⚪ HARDCODED — error code FS1005 hardcoded | Province checked against DataCache user mappings   |
| 5        | Camel Route            | FusFullResRequestPreProcessor   | process(Exchange) — validate required fields                  | Sync     | ⚠️ GAP — no format validation   | Only checks null/blank; no pattern/length checks    |
| 6        | Camel Route            | route_oss_security_token        | Direct call to token sub-route                                | Sync     | None                           | See SD-003 for detail                               |
| 7        | FusAuthServiceProcessor| OPTA Auth Endpoint              | POST refresh_token grant to OAuth endpoint                    | Sync     | ⚪ HARDCODED — client secret in config | Returns Bearer token                             |
| 8        | Camel Route            | FusFullResAuthRequestProcessor  | Build OSSRequestType with address, products, Bearer token     | Sync     | ⚪ HARDCODED — DEFAULT_ADDRESS_ID = "1" | UUID-based RequestID generated                  |
| 9        | Camel Route            | OPTA Single Service (OSS)       | SOAP call to OptaSingleServicePort                            | Sync     | None                           | TLS with CN check disabled (🔴 CRITICAL)            |
| 10       | Camel Route            | FusFullResAuthServiceResponseProcessor | Transform OSSResponse to JSON ResultType list           | Sync     | None                           | Maps OPTA response to REST JSON format              |
| 11       | Camel Route            | Client                          | HTTP 200 with JSON body                                       | Response | None                           | Content-Type: application/json                      |
| 12       | Camel Route            | TransactionLogger               | wireTap — async log of request/response payloads              | Async    | 📝 NOTE — async, fire-and-forget | Inserts to cl_fus_trans_log                        |

#### Error / Alternative Flows

| **Condition**                        | **Alternative Flow**                                                                |
|--------------------------------------|-------------------------------------------------------------------------------------|
| Invalid credentials                  | JAASAuthenticationFilter returns HTTP 401 Unauthorized                               |
| Missing role eEsbPlApiOptaAccess     | SimpleAuthorizingInterceptor returns HTTP 403 Forbidden                              |
| Province not authorized              | FusAuthorizationProcessor throws ResponseError (FS1005) → ErrorProcessor → HTTP 403 |
| Required field blank (streetName, postalCode, municipality, province) | FusRequestPreProcessor throws ResponseError (FS1001-FS1004) → ErrorProcessor → HTTP 400 |
| OPTA service unavailable             | Exception caught → ErrorProcessor → HTTP 500 (FS3001 or FS7001)                     |
| OAuth token failure                  | Exception caught → ErrorProcessor → HTTP 500 (FS2001)                               |
| Unknown exception                    | ErrorProcessor sets FS2001 → HTTP 400                                               |

#### Annotations Summary

| **Step** | **Annotation Type** | **Description**                                                          | **Linked Gap/Finding** |
|----------|---------------------|--------------------------------------------------------------------------|------------------------|
| 4        | ⚪ HARDCODED         | Error code FS1005 and message hardcoded in processor instead of config   | —                      |
| 5        | ⚠️ GAP              | No format validation on postalCode, province, or other fields            | —                      |
| 7        | ⚪ HARDCODED         | OAuth client secret stored in app_config.properties                      | —                      |
| 8        | ⚪ HARDCODED         | DEFAULT_ADDRESS_ID always set to "1"                                     | —                      |
| 9        | 🔴 CRITICAL          | TLS CN check disabled (disableCNCheck=true)                              | —                      |

---

### 3.2 SD-002: SOAP FUS Score Request

**Use Case:** Consumer retrieves FUS fire protection score via SOAP endpoint
**Description:** End-to-end flow for a SOAP request from WS-Security authentication through OPTA service call and SOAP response
**Trigger:** SOAP POST request to `/pl/api/oss/fus` with WS-Security UsernameToken header
**Pre-conditions:** Client has valid LDAP credentials and WS-Security token; OPTA service is available
**Post-conditions:** SOAP response with FUS score returned; transaction logged to database

#### Participants

| **Participant**                 | **Type**   | **Component ID** | **Description**                          |
|---------------------------------|------------|-------------------|------------------------------------------|
| Client                          | Actor      | —                 | SOAP consumer                            |
| JAASLoginInterceptor            | Service    | COMP-010          | SOAP LDAP authentication                 |
| WSS4JInInterceptor              | Service    | COMP-010          | WS-Security UsernameToken validation     |
| SimpleAuthorizingInterceptor    | Service    | COMP-010          | Role authorization                       |
| FusAuthorizationProcessor       | Service    | COMP-004          | Province authorization                   |
| FusRequestPreProcessor          | Service    | COMP-004          | Input validation                         |
| FusAuthServiceProcessor         | Service    | COMP-004          | OAuth token builder                      |
| OPTA Auth Endpoint              | Service    | External          | OAuth token service                      |
| FusAuthRequestProcessor         | Service    | COMP-004          | OPTA request builder                     |
| OPTA Single Service (OSS)       | Service    | External          | OPTA FUS scoring service                 |
| FusAuthServiceResponseProcessor | Service    | COMP-004          | OPTA to FUS response transformer         |
| TransactionLogger               | Service    | COMP-006          | Async DB logging                         |

#### Sequence Diagram (ASCII)

```
┌────────┐  ┌──────────┐  ┌──────────┐  ┌──────────┐  ┌──────────┐  ┌──────────┐  ┌──────────┐  ┌──────────┐  ┌──────────┐
│ Client │  │JAAS Login│  │WSS4J Auth│  │Province  │  │Validator │  │Token Svc │  │Req Xform │  │OPTA OSS  │  │Res Xform │
└───┬────┘  └────┬─────┘  └────┬─────┘  └────┬─────┘  └────┬─────┘  └────┬─────┘  └────┬─────┘  └────┬─────┘  └────┬─────┘
    │            │             │             │             │             │             │             │             │
    │ SOAP POST /pl/api/oss/fus               │             │             │             │             │             │
    │ WS-Security: UsernameToken              │             │             │             │             │             │
    │───────────▶│             │             │             │             │             │             │             │
    │            │             │             │             │             │             │             │             │
    │            │ LDAP auth   │             │             │             │             │             │             │
    │            │────────────▶│             │             │             │             │             │             │
    │            │             │             │             │             │             │             │             │
    │            │ WS-Security │             │             │             │             │             │             │
    │            │ validate    │             │             │             │             │             │             │
    │            │ UsernameToken             │             │             │             │             │             │
    │            │◀────────────│             │             │             │             │             │             │
    │            │             │             │             │             │             │             │             │
    │            │ pass to Camel route       │             │             │             │             │             │
    │            │────────────────────────▶ │             │             │             │             │             │
    │            │             │             │             │             │             │             │             │
    │            │             │             │ authorize province        │             │             │             │
    │            │             │             │────────────▶│             │             │             │             │
    │            │             │             │             │ validate    │             │             │             │
    │            │             │             │             │ request     │             │             │             │
    │            │             │             │◀────────────│             │             │             │             │
    │            │             │             │             │             │             │             │             │
    │            │             │             │ get OAuth token           │             │             │             │
    │            │             │             │────────────────────────▶ │             │             │             │
    │            │             │             │             │      token  │             │             │             │
    │            │             │             │◀────────────────────────  │             │             │             │
    │            │             │             │             │             │             │             │             │
    │            │             │             │ build & call OPTA         │             │             │             │
    │            │             │             │──────────────────────────────────────▶ │             │             │
    │            │             │             │             │             │             │ SOAP call   │             │
    │            │             │             │             │             │             │────────────▶│             │
    │            │             │             │             │             │             │ Response    │             │
    │            │             │             │             │             │             │◀────────────│             │
    │            │             │             │◀──────────────────────────────────────  │             │             │
    │            │             │             │             │             │             │             │             │
    │            │             │             │ transform to FUSResponse  │             │             │             │
    │            │             │             │──────────────────────────────────────────────────────────────────▶ │
    │            │             │             │             │             │  FUSResponse (DwellingFireProtection)  │
    │            │             │             │◀──────────────────────────────────────────────────────────────────  │
    │            │             │             │             │             │             │             │             │
    │  SOAP Response           │             │             │             │             │             │             │
    │◀───────────────────────────────────────│             │             │             │             │             │
    │            │             │             │             │             │             │             │             │
    │            │             │             │ wireTap → TransactionLogger (async)     │             │             │
    │            │             │             │──▷ log to DB              │             │             │             │
    │            │             │             │             │             │             │             │             │
┌───┴────┐  ┌────┴─────┐  ┌────┴─────┐  ┌────┴─────┐  ┌────┴─────┐  ┌────┴─────┐  ┌────┴─────┐  ┌────┴─────┐  ┌────┴─────┐
│ Client │  │JAAS Login│  │WSS4J Auth│  │Province  │  │Validator │  │Token Svc │  │Req Xform │  │OPTA OSS  │  │Res Xform │
└────────┘  └──────────┘  └──────────┘  └──────────┘  └──────────┘  └──────────┘  └──────────┘  └──────────┘  └──────────┘
```

#### Step-by-Step Description

| **Step** | **From**                     | **To**                        | **Message/Action**                                         | **Type** | **Annotations**                      | **Notes**                              |
|----------|------------------------------|-------------------------------|-------------------------------------------------------------|----------|--------------------------------------|----------------------------------------|
| 1        | Client                       | JAASLoginInterceptor          | SOAP POST with WS-Security UsernameToken header             | Sync     | None                                 | PasswordText format                    |
| 2        | JAASLoginInterceptor         | LDAP                          | Validate credentials                                        | Sync     | None                                 | JAAS LoginModule: LDAPLogin            |
| 3        | WSS4JInInterceptor           | —                             | Validate WS-Security token                                  | Sync     | 🔴 CRITICAL — validate.token=false    | Token validation skipped               |
| 4        | SimpleAuthorizingInterceptor | —                             | Check role eEsbPlApiOptaAccess                              | Sync     | None                                 | —                                      |
| 5        | Camel Route                  | FusAuthorizationProcessor     | Validate province against authorized list                   | Sync     | ⚪ HARDCODED — FS1005 error code      | Checks DataCache user→provinces        |
| 6        | Camel Route                  | FusRequestPreProcessor        | Validate required fields from FusRequest                    | Sync     | ⚠️ GAP — no format validation         | Only null/blank checks                 |
| 7        | Camel Route                  | route_oss_security_token      | Obtain Bearer token (see SD-003)                            | Sync     | None                                 | —                                      |
| 8        | Camel Route                  | FusAuthRequestProcessor       | Build OSSRequestType from FusRequest                        | Sync     | ⚪ HARDCODED — ADDRESS_ID="1"         | —                                      |
| 9        | Camel Route                  | OPTA OSS                      | SOAP call to OptaSingleServicePort                          | Sync     | 🔴 CRITICAL — CN check disabled       | —                                      |
| 10       | Camel Route                  | FusAuthServiceResponseProcessor| Transform to FUSResponse                                   | Sync     | None                                 | Returns DwellingFireProtectionResponse |
| 11       | Camel Route                  | Client                        | SOAP response                                               | Response | None                                 | —                                      |
| 12       | Camel Route                  | TransactionLogger             | Async log via wireTap                                       | Async    | 📝 NOTE — fire-and-forget             | —                                      |

#### Error / Alternative Flows

| **Condition**                       | **Alternative Flow**                                                            |
|-------------------------------------|---------------------------------------------------------------------------------|
| Invalid LDAP credentials            | JAASLoginInterceptor returns SOAP Fault (authentication error)                  |
| Missing role                        | SimpleAuthorizingInterceptor returns SOAP Fault (authorization error)            |
| Province not authorized             | FusAuthorizationProcessor → ErrorProcessor → SOAPServiceException (FS1005)      |
| Required field blank                | FusRequestPreProcessor → ErrorProcessor → SOAPServiceException (FS1001-FS1004)  |
| OPTA service unavailable            | Exception → ErrorProcessor → SOAP Fault (FS3001/FS7001)                         |

#### Annotations Summary

| **Step** | **Annotation Type** | **Description**                                                | **Linked Gap/Finding** |
|----------|---------------------|----------------------------------------------------------------|------------------------|
| 3        | 🔴 CRITICAL          | WS-Security token validation disabled (validate.token=false)   | —                      |
| 5        | ⚪ HARDCODED         | Error code FS1005 hardcoded in processor                       | —                      |
| 6        | ⚠️ GAP              | No format/length validation on input fields                    | —                      |
| 8        | ⚪ HARDCODED         | Default address ID always "1"                                  | —                      |
| 9        | 🔴 CRITICAL          | TLS CN check disabled                                          | —                      |

---

### 3.3 SD-003: OAuth Token Acquisition

**Use Case:** Obtain Bearer token for OPTA service authentication
**Description:** Sub-route `route_oss_security_token` that acquires an OAuth 2.0 token using refresh_token grant
**Trigger:** Called by main FUS routes before OPTA service invocation
**Pre-conditions:** FUS_AUTH_TOKEN (refresh token), FUS_CLIENT_ID, FUS_CLIENT_SECRET configured
**Post-conditions:** Bearer token stored in Camel Exchange for subsequent OPTA call

#### Participants

| **Participant**            | **Type** | **Component ID** | **Description**                         |
|----------------------------|----------|-------------------|-----------------------------------------|
| Calling Route              | Service  | COMP-010          | Main FUS route (REST or SOAP)           |
| FusAuthServiceProcessor    | Service  | COMP-004          | Builds OAuth token request              |
| OPTA Auth Endpoint         | Service  | External          | OAuth token service (REST)              |
| authResponseProcessor      | Service  | COMP-004          | Processes token response                |

#### Sequence Diagram (ASCII)

```
┌──────────────┐          ┌────────────────────┐          ┌────────────────┐          ┌────────────────────┐
│ Calling Route│          │FusAuthServiceProc   │          │  OPTA Auth EP  │          │ authResponseProc   │
└──────┬───────┘          └─────────┬──────────┘          └───────┬────────┘          └─────────┬──────────┘
       │                           │                             │                             │
       │ direct:route_oss_security_token                         │                             │
       │──────────────────────────▶│                             │                             │
       │                           │                             │                             │
       │                           │ Build POST body:            │                             │
       │                           │ grant_type=refresh_token    │                             │
       │                           │ client_id=opta_single_svc   │                             │
       │                           │ client_secret=<secret>      │                             │
       │                           │ refresh_token=<JWT>         │                             │
       │                           │                             │                             │
       │                           │ POST /token                 │                             │
       │                           │────────────────────────────▶│                             │
       │                           │                             │                             │
       │                           │     FusAuthResponse         │                             │
       │                           │     (access_token, ...)     │                             │
       │                           │◀────────────────────────────│                             │
       │                           │                             │                             │
       │                           │ extract Bearer token        │                             │
       │                           │─────────────────────────────────────────────────────────▶ │
       │                           │                             │                             │
       │                           │     token stored in Exchange│                             │
       │                           │◀─────────────────────────────────────────────────────────  │
       │                           │                             │                             │
       │ Exchange with Bearer token│                             │                             │
       │◀──────────────────────────│                             │                             │
       │                           │                             │                             │
┌──────┴───────┐          ┌─────────┴──────────┐          ┌───────┴────────┐          ┌─────────┴──────────┐
│ Calling Route│          │FusAuthServiceProc   │          │  OPTA Auth EP  │          │ authResponseProc   │
└──────────────┘          └────────────────────┘          └────────────────┘          └────────────────────┘
```

#### Step-by-Step Description

| **Step** | **From**              | **To**                    | **Message/Action**                                           | **Type** | **Annotations**                  | **Notes**                           |
|----------|-----------------------|---------------------------|--------------------------------------------------------------|----------|----------------------------------|-------------------------------------|
| 1        | Calling Route         | FusAuthServiceProcessor   | direct:route_oss_security_token                              | Sync     | None                             | Internal Camel direct endpoint      |
| 2        | FusAuthServiceProcessor| OPTA Auth Endpoint       | POST with grant_type=refresh_token, client credentials       | Sync     | ⚪ HARDCODED — client_secret in config | QA endpoint: https://qa.avivacanadaservices.com:9444/... |
| 3        | OPTA Auth Endpoint    | FusAuthServiceProcessor   | FusAuthResponse with access_token                            | Response | None                             | —                                   |
| 4        | FusAuthServiceProcessor| authResponseProcessor    | Extract Bearer token, store in Exchange                      | Sync     | None                             | Token used for subsequent OPTA call |

#### Error / Alternative Flows

| **Condition**              | **Alternative Flow**                                              |
|----------------------------|-------------------------------------------------------------------|
| Auth endpoint unavailable  | Exception caught → ErrorProcessor → error response to caller      |
| Invalid credentials        | Auth returns error → ErrorProcessor → error response              |
| Token expired              | Refresh grant fails → ErrorProcessor → error response             |

#### Annotations Summary

| **Step** | **Annotation Type** | **Description**                                            | **Linked Gap/Finding** |
|----------|---------------------|------------------------------------------------------------|------------------------|
| 2        | ⚪ HARDCODED         | OAuth client_secret in app_config.properties (not vaulted) | —                      |

---

### 3.4 SD-004: JSON Cache Loading (Startup)

**Use Case:** Load error messages and authorization configuration at application startup
**Description:** Two Camel routes load JSON files from the filesystem into the DataCache singleton
**Trigger:** Application startup / OSGi bundle activation
**Pre-conditions:** JSON files exist at configured filesystem paths
**Post-conditions:** DataCache populated with error message and authorization mappings

#### Participants

| **Participant**     | **Type** | **Component ID** | **Description**                   |
|---------------------|----------|-------------------|-----------------------------------|
| File Endpoint       | Service  | COMP-010          | Camel file consumer               |
| Jackson Unmarshaller| Service  | COMP-010          | JSON to POJO conversion           |
| DataCacheLoader     | Service  | COMP-007          | Loads data into DataCache         |
| DataCache           | Service  | COMP-007          | Singleton in-memory cache         |

#### Sequence Diagram (ASCII)

```
┌───────────────┐          ┌───────────────────┐          ┌─────────────────┐          ┌───────────┐
│ File Endpoint │          │Jackson Unmarshaller│          │ DataCacheLoader │          │ DataCache │
└──────┬────────┘          └─────────┬─────────┘          └────────┬────────┘          └─────┬─────┘
       │                            │                              │                        │
       │ Read error_messages.json   │                              │                        │
       │───────────────────────────▶│                              │                        │
       │                            │                              │                        │
       │                            │ unmarshal to                 │                        │
       │                            │ List<ErrorMessageLookup>     │                        │
       │                            │─────────────────────────────▶│                        │
       │                            │                              │                        │
       │                            │                              │ loadJsonData(list)     │
       │                            │                              │───────────────────────▶│
       │                            │                              │                        │
       │                            │                              │ errorLookup populated  │
       │                            │                              │◀───────────────────────│
       │                            │                              │                        │
       │ Read authorization_config.json                            │                        │
       │───────────────────────────▶│                              │                        │
       │                            │                              │                        │
       │                            │ unmarshal to                 │                        │
       │                            │ List<AuthorizationLookup>    │                        │
       │                            │─────────────────────────────▶│                        │
       │                            │                              │                        │
       │                            │                              │ loadJsonData(list)     │
       │                            │                              │───────────────────────▶│
       │                            │                              │                        │
       │                            │                              │ userInfo populated     │
       │                            │                              │◀───────────────────────│
       │                            │                              │                        │
┌──────┴────────┐          ┌─────────┴─────────┐          ┌────────┴────────┐          ┌─────┴─────┐
│ File Endpoint │          │Jackson Unmarshaller│          │ DataCacheLoader │          │ DataCache │
└───────────────┘          └───────────────────┘          └─────────────────┘          └───────────┘
```

#### Step-by-Step Description

| **Step** | **From**         | **To**               | **Message/Action**                                | **Type** | **Annotations** | **Notes**                                |
|----------|------------------|----------------------|---------------------------------------------------|----------|-----------------|------------------------------------------|
| 1        | File Endpoint    | Jackson Unmarshaller | Read error_messages.json from filesystem          | Sync     | None            | Path from AUTHORIZATION_LOOKUP config    |
| 2        | Jackson          | DataCacheLoader      | Deserialize to List\<ErrorMessageLookup\>          | Sync     | None            | 6 error codes (FS1001-FS2001)            |
| 3        | DataCacheLoader  | DataCache            | Populate errorLookup map                           | Sync     | None            | Thread-safe singleton                    |
| 4        | File Endpoint    | Jackson Unmarshaller | Read authorization_config.json from filesystem    | Sync     | None            | —                                        |
| 5        | Jackson          | DataCacheLoader      | Deserialize to List\<AuthorizationLookup\>         | Sync     | None            | 3 users with province lists              |
| 6        | DataCacheLoader  | DataCache            | Populate userInfo map                              | Sync     | None            | User → allowed provinces                 |

#### Error / Alternative Flows

| **Condition**         | **Alternative Flow**                                         |
|-----------------------|--------------------------------------------------------------|
| JSON file not found   | Camel route fails; cache remains empty; runtime auth errors  |
| Malformed JSON        | Jackson parse exception; cache remains empty                 |

#### Annotations Summary

| **Step** | **Annotation Type** | **Description** | **Linked Gap/Finding** |
|----------|---------------------|-----------------|------------------------|
| —        | None                | —               | —                      |

---

### 3.5 SD-005: Error Handling Flow

**Use Case:** Centralized exception handling across all routes
**Description:** When any processor throws a ResponseError or unexpected exception, ErrorProcessor converts it to the appropriate error response format (JSON for REST, SOAP Fault for SOAP)
**Trigger:** Exception thrown by any processor in the Camel route
**Pre-conditions:** ErrorProcessor bean configured in blueprint.xml
**Post-conditions:** Client receives error response with code and message; transaction logged

#### Participants

| **Participant**      | **Type** | **Component ID** | **Description**                       |
|----------------------|----------|-------------------|---------------------------------------|
| Failed Processor     | Service  | COMP-004          | Any processor that threw exception    |
| ErrorProcessor       | Service  | COMP-004          | Centralized error handler             |
| DataCache            | Service  | COMP-007          | Error message lookup                  |
| TransactionLogger    | Service  | COMP-006          | Async error logging                   |

#### Sequence Diagram (ASCII)

```
┌──────────────────┐          ┌────────────────┐          ┌───────────┐          ┌────────────────────┐
│ Failed Processor │          │ ErrorProcessor │          │ DataCache │          │ TransactionLogger  │
└────────┬─────────┘          └───────┬────────┘          └─────┬─────┘          └─────────┬──────────┘
         │                            │                         │                          │
         │ throw ResponseError(code, msg)                       │                          │
         │───────────────────────────▶│                         │                          │
         │                            │                         │                          │
         │                            │ lookup error message    │                          │
         │                            │────────────────────────▶│                          │
         │                            │                         │                          │
         │                            │ ErrorMessageLookup      │                          │
         │                            │◀────────────────────────│                          │
         │                            │                         │                          │
         │    ┌───────────────────────┴──────────────────────┐  │                          │
         │    │ [alt] REST endpoint                          │  │                          │
         │    │ Set HTTP status (400/403/500)                │  │                          │
         │    │ Build JSON ErrorDetails response             │  │                          │
         │    │                                              │  │                          │
         │    │ [alt] SOAP endpoint                          │  │                          │
         │    │ Convert to SOAPServiceException              │  │                          │
         │    │ Build SOAP Fault                             │  │                          │
         │    └───────────────────────┬──────────────────────┘  │                          │
         │                            │                         │                          │
         │                            │ set Exchange error properties                     │
         │                            │ (status, errorCode, errorMessage)                 │
         │                            │                         │                          │
         │                            │ wireTap → log error     │                          │
         │                            │───────────────────────────────────────────────────▶│
         │                            │                         │                          │
         │  Error response            │                         │                          │
         │◀───────────────────────────│                         │                          │
         │                            │                         │                          │
┌────────┴─────────┐          ┌───────┴────────┐          ┌─────┴─────┐          ┌─────────┴──────────┐
│ Failed Processor │          │ ErrorProcessor │          │ DataCache │          │ TransactionLogger  │
└──────────────────┘          └────────────────┘          └───────────┘          └────────────────────┘
```

#### Step-by-Step Description

| **Step** | **From**           | **To**             | **Message/Action**                                             | **Type** | **Annotations**                | **Notes**                            |
|----------|--------------------|--------------------|----------------------------------------------------------------|----------|--------------------------------|--------------------------------------|
| 1        | Failed Processor   | ErrorProcessor     | Exception caught by Camel onException handler                  | Sync     | None                           | ResponseError or generic Exception   |
| 2        | ErrorProcessor     | DataCache          | Lookup error message by error code                             | Sync     | None                           | Falls back to FS2001 for unknown     |
| 3        | ErrorProcessor     | —                  | Map error code to HTTP status (FS1005→403, FS3001/FS7001→500)  | Sync     | ⚪ HARDCODED — FS2001 default   | Other codes map to 400               |
| 4        | ErrorProcessor     | —                  | Build error response (JSON or SOAP Fault)                      | Sync     | None                           | Format depends on endpoint type      |
| 5        | ErrorProcessor     | TransactionLogger  | Async log of error details                                     | Async    | None                           | wireTap                              |

#### Error / Alternative Flows

| **Condition**                       | **Alternative Flow**                                   |
|-------------------------------------|--------------------------------------------------------|
| Error code not in DataCache         | Uses FS2001 ("Technical Error") as default             |
| ErrorProcessor itself fails         | Unhandled exception; container default error response  |

#### Annotations Summary

| **Step** | **Annotation Type** | **Description**                                    | **Linked Gap/Finding** |
|----------|---------------------|----------------------------------------------------|------------------------|
| 3        | ⚪ HARDCODED         | Default error code FS2001 hardcoded in processor   | —                      |

---

### 3.6 SD-006: SOAP Full Response FUS Request

**Use Case:** Consumer retrieves full OPTA product response via SOAP endpoint
**Description:** Similar to SD-002 but returns the complete FusProductResponse instead of just the FUS subset
**Trigger:** SOAP POST request to `/pl/api/oss/product/fus`
**Pre-conditions:** Same as SD-002
**Post-conditions:** Full OPTA product SOAP response returned; transaction logged

#### Participants

Same as SD-002 but using FusFullRes* processor variants.

#### Step-by-Step Description

| **Step** | **From**              | **To**                              | **Message/Action**                                       | **Type** | **Annotations**          | **Notes**                                |
|----------|-----------------------|-------------------------------------|----------------------------------------------------------|----------|--------------------------|------------------------------------------|
| 1-4      | (Same as SD-002)      | (Same as SD-002)                    | Authentication and authorization                         | Sync     | Same as SD-002           | —                                        |
| 5        | Camel Route           | FusFullResAuthorizationProcessor    | Province authorization                                   | Sync     | ⚪ HARDCODED — FS1005     | —                                        |
| 6        | Camel Route           | FusFullResRequestPreProcessor       | Input validation                                         | Sync     | ⚠️ GAP — no format check  | —                                        |
| 7        | Camel Route           | route_oss_security_token            | Get Bearer token (SD-003)                                | Sync     | None                     | —                                        |
| 8        | Camel Route           | FusFullResAuthRequestProcessor      | Build OSSRequestType                                     | Sync     | ⚪ HARDCODED — ID="1"     | —                                        |
| 9        | Camel Route           | OPTA OSS                            | SOAP call                                                | Sync     | 🔴 CRITICAL — CN disabled | —                                        |
| 10       | Camel Route           | FusFullResAuthServiceResponseProcessor | Transform to FusProductResponse                        | Sync     | None                     | Returns complete product response        |
| 11       | Camel Route           | Client                              | SOAP response                                            | Response | None                     | —                                        |
| 12       | Camel Route           | TransactionLogger                   | Async log                                                | Async    | None                     | —                                        |

#### Error / Alternative Flows

Same as SD-002.

#### Annotations Summary

Same annotations as SD-002 steps (hardcoded values, missing validation, CN check disabled).

---

## 4. Cross-Cutting Sequence Patterns

### 4.1 Authentication Flow Pattern

```
┌────────┐          ┌─────────────────────┐          ┌──────────────┐          ┌────────────┐
│ Client │          │ Auth Filter/Intcp   │          │ LDAP (JAAS)  │          │ Auth Intcp │
└───┬────┘          └──────────┬──────────┘          └──────┬───────┘          └─────┬──────┘
    │                          │                            │                        │
    │ Request + credentials    │                            │                        │
    │─────────────────────────▶│                            │                        │
    │                          │                            │                        │
    │                          │ validate(credentials)      │                        │
    │                          │───────────────────────────▶│                        │
    │                          │                            │                        │
    │                          │    User principal           │                        │
    │                          │◀───────────────────────────│                        │
    │                          │                            │                        │
    │                          │ check role(eEsbPlApiOptaAccess)                    │
    │                          │────────────────────────────────────────────────────▶│
    │                          │                            │                        │
    │                          │ role granted / denied       │                        │
    │                          │◀────────────────────────────────────────────────────│
    │                          │                            │                        │
    │ Auth pass / 401 / 403    │                            │                        │
    │◀─────────────────────────│                            │                        │
    │                          │                            │                        │
┌───┴────┐          ┌──────────┴──────────┐          ┌──────┴───────┐          ┌─────┴──────┐
│ Client │          │ Auth Filter/Intcp   │          │ LDAP (JAAS)  │          │ Auth Intcp │
└────────┘          └─────────────────────┘          └──────────────┘          └────────────┘
```

### 4.2 Error Handling Pattern

```
┌────────┐          ┌─────────┐          ┌────────────────┐          ┌────────────────────┐
│ Caller │          │Processor│          │ ErrorProcessor │          │ TransactionLogger  │
└───┬────┘          └────┬────┘          └───────┬────────┘          └─────────┬──────────┘
    │                    │                       │                             │
    │ process(exchange)  │                       │                             │
    │───────────────────▶│                       │                             │
    │                    │                       │                             │
    │                    │ [processing fails]    │                             │
    │                    │                       │                             │
    │                    │ throw ResponseError   │                             │
    │                    │──────────────────────▶│                             │
    │                    │                       │                             │
    │                    │                       │ lookup error, set HTTP status│
    │                    │                       │                             │
    │                    │                       │ log(error)                  │
    │                    │                       │──▷──────────────────────────▶│
    │                    │                       │                             │
    │     Error Response (code, message)         │                             │
    │◀───────────────────────────────────────────│                             │
    │                    │                       │                             │
┌───┴────┐          ┌────┴────┐          ┌───────┴────────┐          ┌─────────┴──────────┐
│ Caller │          │Processor│          │ ErrorProcessor │          │ TransactionLogger  │
└────────┘          └─────────┘          └────────────────┘          └────────────────────┘
```

### 4.3 Transaction Logging Pattern

```
┌──────────────┐          ┌────────────────────┐          ┌────────────────┐
│ Camel Route  │          │ TransactionLogger  │          │ Transaction DB │
└──────┬───────┘          └─────────┬──────────┘          └───────┬────────┘
       │                            │                             │
       │ wireTap: logTransaction()  │                             │
       │──▷─────────────────────────▶│                             │
       │                            │                             │
       │                            │ Extract exchange properties │
       │                            │ (transactionId, app, url,   │
       │                            │  clientInfo, address,       │
       │                            │  req/res payloads, status)  │
       │                            │                             │
       │                            │ Convert req/res to XML      │
       │                            │ via JAXB marshalling        │
       │                            │                             │
       │                            │ INSERT INTO cl_fus_trans_log│
       │                            │────────────────────────────▶│
       │                            │                             │
       │                            │       acknowledgment        │
       │                            │◀────────────────────────────│
       │                            │                             │
┌──────┴───────┐          ┌─────────┴──────────┐          ┌───────┴────────┐
│ Camel Route  │          │ TransactionLogger  │          │ Transaction DB │
└──────────────┘          └────────────────────┘          └────────────────┘
```

---

## 5. Interaction Summary Matrix

| **Component ↓ / Calls →**          | REST Svc | SOAP Svc | Processors | DataCache | Logger | OPTA OSS | OPTA Auth | LDAP  |
|-------------------------------------|----------|----------|------------|-----------|--------|----------|-----------|-------|
| **Client**                          | ✓        | ✓        |            |           |        |          |           |       |
| **JAAS Auth Filter**                |          |          |            |           |        |          |           | ✓     |
| **Camel Route (Blueprint)**         |          |          | ✓          |           | ✓      | ✓        | ✓         |       |
| **Processors**                      |          |          |            | ✓         |        |          |           |       |
| **TransactionLogger**               |          |          |            |           |        |          |           |       |

---

## 6. Notes & Observations

| **#** | **Observation**                                                                      | **Diagram(s)** | **Impact**   |
|-------|--------------------------------------------------------------------------------------|----------------|--------------|
| 1     | OAuth token is acquired per-request; no token caching or reuse mechanism             | SD-003          | Performance  |
| 2     | REST and SOAP flows are nearly identical — processor logic is duplicated             | SD-001, SD-002  | Maintenance  |
| 3     | Transaction logging is fire-and-forget; no retry or failure notification             | SD-001-006      | Data Loss    |
| 4     | WS-Security token validation is disabled — any token is accepted                     | SD-002          | Security     |
| 5     | Response caching (EhCache) is configured in blueprint but not visible in route flow  | All             | Performance  |

---

## 7. Dead Code Flow Paths

| **Diagram ID** | **Step(s)** | **Flow Path Description**                                      | **Evidence**                                            | **Recommendation**                  |
|-----------------|-------------|----------------------------------------------------------------|---------------------------------------------------------|-------------------------------------|
| SD-001          | Step 1      | OssFusSvc.getFusScore() method body returns null               | Method is a CXF stub; Camel route handles actual flow   | Confirm pattern; document           |
| SD-002          | Step 1      | FusSvc.getFusScore() interface — implementation is in route    | Interface-only; Camel provides implementation           | Expected CXF/Camel pattern          |

---

## 8. Target State Sequence Diagrams (Proposed)

### 8.1 SD-001-TARGET: REST FUS Score Request (Target State)

**Corresponding Current State:** SD-001
**Key Changes from Current State:**

| **Change #** | **Description of Change**                                           | **Reason**                                   |
|--------------|---------------------------------------------------------------------|----------------------------------------------|
| 1            | Replace JAAS/LDAP auth with Spring Security + OAuth2/JWT            | Modern auth mechanism                        |
| 2            | Add comprehensive input validation (format, length, pattern checks) | Address GAP in step 5                        |
| 3            | Enable TLS CN check                                                 | Address CRITICAL in step 9                   |
| 4            | Externalize all hardcoded values to Spring Boot config              | Address HARDCODED annotations                |
| 5            | Add OAuth token caching with TTL                                    | Performance improvement                      |
| 6            | Consolidate REST/SOAP processor logic into shared service           | Reduce duplication                           |
| 7            | Replace Camel route with Spring MVC controller + service            | Modern architecture                          |

#### Target State Diagram (ASCII)

```
┌────────┐     ┌───────────────┐     ┌────────────┐     ┌───────────┐     ┌──────────┐     ┌──────────┐
│ Client │     │Spring Security│     │ Controller │     │FUS Service│     │OPTA Client│    │ Logger   │
└───┬────┘     └──────┬────────┘     └─────┬──────┘     └─────┬─────┘     └────┬──────┘     └────┬─────┘
    │                 │                     │                   │                │                 │
    │ GET /api/v1/fus/score                 │                   │                │                 │
    │ Authorization: Bearer <JWT>           │                   │                │                 │
    │────────────────▶│                     │                   │                │                 │
    │                 │                     │                   │                │                 │
    │                 │ validate JWT        │                   │                │                 │
    │                 │ check permissions   │                   │                │                 │
    │                 │                     │                   │                │                 │
    │                 │ dispatch            │                   │                │                 │
    │                 │────────────────────▶│                   │                │                 │
    │                 │                     │                   │                │                 │
    │                 │                     │ @Valid request     │                │                 │
    │                 │                     │ getFusScore(req)   │                │                 │
    │                 │                     │──────────────────▶│                │                 │
    │                 │                     │                   │                │                 │
    │                 │                     │                   │ callOpta(req)  │                 │
    │                 │                     │                   │───────────────▶│                 │
    │                 │                     │                   │                │                 │
    │                 │                     │                   │  FUS result    │                 │
    │                 │                     │                   │◀───────────────│                 │
    │                 │                     │                   │                │                 │
    │                 │                     │  FusScoreResponse │                │                 │
    │                 │                     │◀──────────────────│                │                 │
    │                 │                     │                   │                │                 │
    │ HTTP 200 JSON   │                     │                   │                │                 │
    │◀────────────────────────────────────── │                   │                │                 │
    │                 │                     │                   │                │                 │
    │                 │                     │                   │ async log      │                 │
    │                 │                     │                   │────────────────────────────────▶ │
    │                 │                     │                   │                │                 │
┌───┴────┐     ┌──────┴────────┐     ┌─────┴──────┐     ┌─────┴─────┐     ┌────┴──────┐     ┌────┴─────┐
│ Client │     │Spring Security│     │ Controller │     │FUS Service│     │OPTA Client│     │ Logger   │
└────────┘     └───────────────┘     └────────────┘     └───────────┘     └───────────┘     └──────────┘
```

---

## 9. Appendices

### Appendix A: ASCII Diagram Guidelines

| **Element**              | **ASCII Representation**                           |
|--------------------------|----------------------------------------------------|
| Participant box          | `┌──────┐` / `└──────┘`                            |
| Lifeline                 | `│` (vertical bar)                                 |
| Sync request (→)         | `───────────────────▶`                             |
| Sync response (←)        | `◀───────────────────`                             |
| Async request            | `──▷──────────────────`                            |
| Alt/Opt block            | `┌─────────────────┐` with `[alt]` or `[opt]` label|
| Self-call                | Arrow looping back to same lifeline                |

### Appendix B: Glossary

| **Term**     | **Definition**                                                        |
|--------------|-----------------------------------------------------------------------|
| wireTap      | Camel EIP that sends a copy of the message to another endpoint asynchronously |
| Exchange     | Camel message container with headers, body, and properties            |
| Direct       | Camel endpoint for synchronous in-process routing                      |

---

> **Document Control:**
> | Version | Date | Author | Changes |
> |---------|------|--------|---------|
> | 0.1 | 01-Apr-2026 | Copilot | Initial draft |
