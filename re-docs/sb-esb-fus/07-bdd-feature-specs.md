# BDD Feature Specifications — sb-esb-fus

| Field | Value |
|-------|-------|
| **Project Name** | sb-esb-fus (OPTA FUS REST/SOAP Service) |
| **Document Version** | 1.0 |
| **Date** | 2026-03-31 |
| **Prepared By** | Copilot RE/FE Pipeline |
| **Status** | Complete |

**Cross-References:** Doc-01 Discovery Report, Doc-04 Business Rules, Doc-08 Test Cases, Doc-09 Gap Report

---

## 1. Feature Index

| ID | Feature | Scenarios | Priority | Tags |
|----|---------|-----------|----------|------|
| FEAT-001 | Province Authorization | 5 | Critical | @authorization, @security |
| FEAT-002 | Required Field Validation | 6 | Critical | @validation |
| FEAT-003 | OAuth Token Acquisition | 4 | Critical | @security, @integration |
| FEAT-004 | SOAP Request Construction | 4 | High | @transformation |
| FEAT-005 | Fire Protection Grade Mapping | 3 | High | @mapping |
| FEAT-006 | Transaction Logging | 5 | High | @logging |
| FEAT-007 | Error Handling | 6 | Critical | @error-handling |
| FEAT-008 | Request ID Generation | 3 | Medium | @traceability |
| FEAT-009 | Data Cache Loading | 4 | High | @cache |
| FEAT-010 | Response Marshalling | 4 | High | @transformation |
| FEAT-011 | Task Manager CRUD | 8 | High | @task-manager |
| FEAT-012 | Task Filtering & Queries | 4 | Medium | @task-manager |

---

## 2. Feature Specifications

### FEAT-001: Province Authorization (BR-001)

```gherkin
@authorization @security @critical
Feature: Province Authorization
  As an API consumer
  I want the system to verify my province access
  So that I can only query dwelling fire protection for authorized provinces

  Background:
    Given the authorization cache is loaded with user province mappings
    And the system is running

  @happy-path
  Scenario: Authorized province for SOAP request
    Given a SOAP request with username "testuser"
    And the user "testuser" is authorized for province "ON"
    And the request contains province "ON"
    When the FUS SOAP endpoint receives the request
    Then the request passes authorization
    And a transaction ID is generated with the configured prefix
    And the exchange property "CLIENT_ID" is set

  @happy-path
  Scenario: Authorized province for REST request
    Given a REST request with authenticated user "testuser"
    And the user "testuser" is authorized for province "AB"
    And the request body contains province "AB"
    When the FUS REST endpoint receives the request
    Then the request passes authorization

  @negative
  Scenario: Unauthorized province returns error
    Given a SOAP request with username "testuser"
    And the user "testuser" is authorized for provinces "ON,AB"
    And the request contains province "BC"
    When the FUS SOAP endpoint receives the request
    Then a SOAPServiceException is thrown with error code "300"
    And the error message contains "not authorized"

  @negative
  Scenario: Unknown user returns error
    Given a SOAP request with username "unknownuser"
    And no authorization entry exists for "unknownuser"
    When the FUS SOAP endpoint receives the request
    Then a SOAPServiceException is thrown with error code "300"

  @gap @GAP-001
  Scenario: Case-insensitive province matching
    Given a request with province "on" (lowercase)
    When authorization is checked
    Then the province should be matched case-insensitively
    # GAP: Current code converts to uppercase but inconsistently
```

### FEAT-002: Required Field Validation (BR-002)

```gherkin
@validation @critical
Feature: Required Field Validation
  As the system
  I want to validate all required fields before processing
  So that downstream services receive complete requests

  @happy-path
  Scenario: All required fields present in SOAP request
    Given a FusRequest with:
      | field        | value       |
      | streetName   | 123 Main St |
      | postalCode   | M5V 2T6     |
      | municipality | Toronto     |
      | province     | ON          |
    When the request pre-processor validates the request
    Then validation passes successfully

  @negative
  Scenario Outline: Missing required field in SOAP request
    Given a FusRequest with <field> set to null
    When the request pre-processor validates the request
    Then a SOAPServiceException is thrown
    And the error message indicates "<field>" is required

    Examples:
      | field        |
      | streetName   |
      | postalCode   |
      | municipality |
      | province     |

  @negative
  Scenario: Empty string treated as missing field
    Given a FusRequest with streetName set to ""
    When the request pre-processor validates the request
    Then a SOAPServiceException is thrown

  @happy-path
  Scenario: All required fields present in REST request
    Given a FusProductRequest with:
      | field        | value       |
      | streetName   | 456 Oak Ave |
      | postalCode   | T2P 3G5     |
      | municipality | Calgary     |
      | province     | AB          |
    When the REST request pre-processor validates the request
    Then validation passes successfully

  @gap @GAP-002
  Scenario: Postal code format not validated
    Given a request with postalCode "INVALID"
    When validation is performed
    Then the request should be rejected for invalid format
    # GAP: No postal code format validation exists
```

### FEAT-003: OAuth Token Acquisition (BR-003)

```gherkin
@security @integration @critical
Feature: OAuth Token Acquisition
  As the system
  I want to acquire an OAuth access token from the auth endpoint
  So that I can authenticate with the OPTA Single Service

  @happy-path
  Scenario: Successful token acquisition
    Given the auth endpoint URL is configured
    And valid client credentials are configured
    When the auth service processor builds the token request
    Then the request contains grant_type "refresh_token"
    And the request contains the configured client_id
    And the request contains the configured client_secret
    And the Content-Type is "application/x-www-form-urlencoded"

  @happy-path
  Scenario: Auth response parsing
    Given the auth endpoint returns a valid JSON response with access_token
    When the auth response processor parses the response
    Then a FusAuthResponse object is created
    And the access_token is extracted
    And the token is stored in the exchange for downstream use

  @negative
  Scenario: Auth endpoint failure
    Given the auth endpoint is unreachable
    When the security token route is invoked
    Then an exception is thrown
    And the error processor handles the exception
    And a transaction log is created with error status

  @hardcoded @GAP-003
  Scenario: Hardcoded auth token in configuration
    Given the FUS_AUTH_TOKEN property contains a hardcoded JWT
    When the system starts
    Then the hardcoded token should be replaced with dynamic token rotation
    # HARDCODED: FUS_AUTH_TOKEN contains a static JWT in app_config.properties
```

### FEAT-004: SOAP Request Construction (BR-004)

```gherkin
@transformation @high
Feature: SOAP Request Construction
  As the system
  I want to construct OPTA Single Service SOAP requests
  So that dwelling fire protection scores can be retrieved

  @happy-path
  Scenario: SOAP request built from FusRequest
    Given a validated FusRequest with address details
    And a valid OAuth access_token is available
    When FusAuthRequestProcessor builds the OPTA request
    Then the request includes the streetName, postalCode, municipality, province
    And the Authorization header contains "Bearer {access_token}"
    And the requestId is generated with the configured prefix
    And the brokerage is set to the configured default

  @happy-path
  Scenario: REST request built from FusProductRequest
    Given a validated FusProductRequest with address and industry codes
    And a valid OAuth access_token is available
    When FusFullResAuthRequestProcessor builds the OPTA request
    Then the request includes all address fields
    And optional fields ibcCode, naicsCode, sicCode are included if present

  @hardcoded @GAP-004
  Scenario: Default brokerage is hardcoded
    Given the FUS_DEFAULT_BROKERAGE is set to "ABC Brokerage"
    When a request is constructed
    Then the brokerage value should be externalized and configurable
    # HARDCODED: Default brokerage "ABC Brokerage" in config

  @hardcoded @GAP-005
  Scenario: Default carrier is hardcoded
    Given the FUS_DEFAULT_CARRIER is set to "Aviva"
    When a request is constructed
    Then the carrier value should be externalized
    # HARDCODED: Default carrier "Aviva" in config
```

### FEAT-005: Fire Protection Grade Mapping (BR-005)

```gherkin
@mapping @high
Feature: Fire Protection Grade Mapping
  As the system
  I want to map OSS response to DwellingFireProtectionResponse
  So that clients receive fire protection grades

  @happy-path
  Scenario: Successful response mapping
    Given the OPTA Single Service returns a valid response
    When FusAuthServiceResponseProcessor processes the response
    Then a DwellingFireProtectionResponse is created
    And the baseResponse contains clientInfo
    And the success flag is set to true
    And dwellingFireProtection list is populated

  @negative
  Scenario: Empty response from OSS
    Given the OPTA Single Service returns an empty response
    When the response processor processes the response
    Then an appropriate error is returned

  @happy-path
  Scenario: Full response pass-through for REST
    Given the OPTA Single Service returns a full response
    When FusFullResAuthServiceResponseProcessor processes the response
    Then the full ResponseBodyType is returned without transformation
```

### FEAT-006: Transaction Logging (BR-006)

```gherkin
@logging @high
Feature: Transaction Logging
  As the system
  I want to log all transactions to the database
  So that there is an audit trail of all FUS requests

  @happy-path
  Scenario: Successful SOAP transaction logged
    Given a SOAP FUS request is successfully processed
    When the logging route receives the exchange
    Then a record is inserted into CL_FUS_TRANS_LOG
    And the application field is "SOAP"
    And the status field is "success"
    And reqPayload and resPayload are populated

  @happy-path
  Scenario: Successful REST transaction logged
    Given a REST FUS request is successfully processed
    When the logging route receives the exchange via wireTap
    Then a record is inserted into CL_FUS_TRANS_LOG
    And the application field is "REST"
    And the status field is "success"

  @negative
  Scenario: Failed transaction logged with error details
    Given a FUS request fails with an exception
    When the error processor handles the exception
    And the logging route receives the exchange
    Then a record is inserted with status "error"
    And errorCode and errorMessage are populated

  @happy-path
  Scenario: Transaction log contains all 17 fields
    Given a completed FUS transaction
    When the log record is created
    Then all 17 fields are populated:
      | transactionId | application | url | transactionTime |
      | clientId | clientName | clientGuid | dwellingFireProtection |
      | streetName | postalCode | municipality | province |
      | reqPayload | resPayload | status | errorCode | errorMessage |

  @gap @GAP-006
  Scenario: Logging failure should not affect main flow
    Given the Oracle database is unavailable
    When a transaction log write fails
    Then the main request/response flow should not be affected
    # GAP: wireTap pattern used but error handling for logging failures unclear
```

### FEAT-007: Error Handling (BR-007)

```gherkin
@error-handling @critical
Feature: Error Handling
  As the system
  I want to handle errors consistently
  So that clients receive meaningful error responses

  @happy-path
  Scenario: SOAP fault returned for SOAP request errors
    Given a SOAP request encounters an exception
    And the CALL_TYPE exchange property is "SOAP"
    When ErrorProcessor handles the exception
    Then a SOAPServiceException is created
    And returnSoapResponse converts it to a SOAP fault

  @happy-path
  Scenario: REST error response for REST request errors
    Given a REST request encounters an exception
    When ErrorProcessor handles the exception
    Then a FaultElement is created with errorCode and errorMessage
    And the HTTP status code is set appropriately

  @negative
  Scenario: Authorization error returns specific code
    Given a province authorization check fails
    When the exception is caught
    Then error code "300" is returned
    And the message indicates authorization failure

  @negative
  Scenario: Validation error returns specific code
    Given a required field is missing
    When the exception is caught
    Then the error response contains the field name
    And an appropriate error code is set

  @negative
  Scenario: Downstream service error handled
    Given the OPTA Single Service returns an error
    When the exception propagates through the route
    Then the error is caught by onException
    And transformed to the appropriate response format

  @gap @GAP-007
  Scenario: Duplicate onException IDs in blueprint
    Given the blueprint.xml contains multiple onException elements with id="_onException"
    When the application is deployed
    Then only the last onException may be effective
    # GAP: Duplicate XML IDs may cause undefined behavior
```

### FEAT-008: Request ID Generation (BR-008)

```gherkin
@traceability @medium
Feature: Request ID Generation
  As the system
  I want to generate unique request IDs
  So that transactions can be traced

  @happy-path
  Scenario: UUID-based request ID with prefix
    Given the FUS_REQUESTID_PREFIX is configured as "dev.aviva.ca-"
    When FusAuthorizationProcessor generates a request ID
    Then the ID starts with "dev.aviva.ca-"
    And the remainder is a valid UUID

  @happy-path
  Scenario: Request ID set as exchange property
    When a request is processed
    Then the TRANSACTION_ID exchange property is set
    And the ID is carried through to the transaction log

  @gap @GAP-008
  Scenario: Request ID uniqueness under high concurrency
    Given multiple concurrent requests
    When request IDs are generated
    Then all IDs should be unique
    # Note: UUID.randomUUID() is used which should be unique
```

### FEAT-009: Data Cache Loading (BR-009)

```gherkin
@cache @high
Feature: Data Cache Loading
  As the system
  I want to load configuration data from JSON files at startup
  So that authorization and error lookups are available in memory

  @happy-path
  Scenario: Error message lookup loaded
    Given the error_messages.json file exists at the configured path
    When the jsonToErrorMessageLookup route processes the file
    Then the DataCache singleton contains the error message entries

  @happy-path
  Scenario: Authorization config loaded
    Given the authorization_config.json file exists at the configured path
    When the jsonToAuthenticationLookup route processes the file
    Then the DataCache singleton contains the OptaOssACL entries

  @negative
  Scenario: Missing JSON file
    Given the configured JSON file path does not exist
    When the cache loading route triggers
    Then an error is logged
    And the cache remains empty

  @gap @GAP-009
  Scenario: Cache refresh mechanism
    Given the authorization data changes
    When the system is running
    Then there is no mechanism to refresh the cache without restart
    # GAP: Singleton cache has no refresh/reload capability
```

### FEAT-010: Response Marshalling (BR-010)

```gherkin
@transformation @high
Feature: Response Marshalling
  As the system
  I want to marshal responses appropriately
  So that SOAP clients get XML and REST clients get JSON

  @happy-path
  Scenario: REST response marshalled as JSON
    Given the REST route processes a successful response
    When the response is marshalled
    Then the output is valid JSON
    And the Content-Type is application/json

  @happy-path
  Scenario: SOAP response returned as XML
    Given the SOAP route processes a successful response
    When the response is returned
    Then the output is valid SOAP XML

  @happy-path
  Scenario: Full response product endpoint
    Given the SOAP full response route processes a response
    When the response is returned
    Then the complete ResponseBodyType is included

  @dead-code @GAP-010
  Scenario: OssFusSvc REST service incomplete
    Given the OssFusSvc class is deployed
    When the getFusDetails method is invoked
    Then the implementation is incomplete
    # DEAD CODE: OssFusSvc has stub implementations
```

### FEAT-011: Task Manager CRUD (Spring Boot App)

```gherkin
@task-manager @high
Feature: Task Manager CRUD Operations
  As a user
  I want to manage tasks
  So that I can track my work items

  @happy-path
  Scenario: Create a new task
    Given a valid task with title "Test Task"
    When I POST to /api/tasks
    Then the response status is 201
    And the task is created with status "TODO"

  @happy-path
  Scenario: Get all tasks
    Given tasks exist in the database
    When I GET /api/tasks
    Then the response status is 200
    And all tasks are returned

  @happy-path
  Scenario: Get task by ID
    Given a task with ID 1 exists
    When I GET /api/tasks/1
    Then the response status is 200
    And the task details are returned

  @negative
  Scenario: Get non-existent task returns 404
    When I GET /api/tasks/999
    Then the response status is 404

  @happy-path
  Scenario: Update a task
    Given a task with ID 1 exists
    When I PUT /api/tasks/1 with updated title "Updated"
    Then the response status is 200
    And the task title is "Updated"

  @happy-path
  Scenario: Delete a task
    Given a task with ID 1 exists
    When I DELETE /api/tasks/1
    Then the response status is 204
    And the task no longer exists

  @negative
  Scenario: Reject blank title
    Given a task with title ""
    When I POST /api/tasks
    Then the response status is 400

  @happy-path
  Scenario: Create task with priority and due date
    Given a task with title "Priority Task" and priority "HIGH" and dueDate "2026-12-31"
    When I POST /api/tasks
    Then the response status is 201
    And the task priority is "HIGH"
```

### FEAT-012: Task Filtering & Queries

```gherkin
@task-manager @medium
Feature: Task Filtering and Queries
  As a user
  I want to filter tasks by status, priority, and overdue
  So that I can focus on relevant work items

  @happy-path
  Scenario: Filter tasks by status
    Given tasks with statuses TODO and DONE exist
    When I GET /api/tasks/status/TODO
    Then only TODO tasks are returned

  @happy-path
  Scenario: Filter tasks by priority
    Given tasks with priorities HIGH and LOW exist
    When I GET /api/tasks/priority/HIGH
    Then only HIGH priority tasks are returned

  @happy-path
  Scenario: Get overdue tasks
    Given a task with dueDate yesterday and status TODO
    And a task with dueDate tomorrow and status TODO
    And a task with dueDate yesterday and status DONE
    When I GET /api/tasks/overdue
    Then only the first task is returned

  @happy-path
  Scenario: Update task with due date and priority
    Given a task exists
    When I PUT the task with dueDate "2026-06-15" and priority "CRITICAL"
    Then the task is updated with the new values
```

---

## 3. Gap-Exposing Scenarios Summary

| ID | Gap | Scenario | Severity |
|----|-----|----------|----------|
| GAP-001 | Case-insensitive province matching | Province "on" vs "ON" | Medium |
| GAP-002 | No postal code format validation | Invalid postal code accepted | High |
| GAP-003 | Hardcoded JWT auth token | Static token in config | Critical |
| GAP-004 | Hardcoded default brokerage | "ABC Brokerage" | Medium |
| GAP-005 | Hardcoded default carrier | "Aviva" | Low |
| GAP-006 | Logging failure impact | DB unavailable scenario | Medium |
| GAP-007 | Duplicate onException IDs | Blueprint XML issue | High |
| GAP-008 | Request ID uniqueness | Concurrent scenario | Low |
| GAP-009 | No cache refresh mechanism | Singleton without reload | Medium |
| GAP-010 | OssFusSvc incomplete implementation | Dead code | Medium |

---

## 4. Tag Reference

| Tag | Meaning |
|-----|---------|
| `@authorization` | Province authorization features |
| `@validation` | Input field validation |
| `@security` | Security-related (auth, tokens, encryption) |
| `@integration` | External service integration |
| `@transformation` | Data mapping/transformation |
| `@logging` | Transaction logging |
| `@error-handling` | Error/exception handling |
| `@traceability` | Request tracking |
| `@cache` | Data caching |
| `@task-manager` | Task Manager Spring Boot app |
| `@happy-path` | Normal success flow |
| `@negative` | Error/failure scenario |
| `@gap` | Gap-exposing scenario |
| `@hardcoded` | Hardcoded value scenario |
| `@dead-code` | Dead code scenario |
| `@critical` | Critical priority |
| `@high` | High priority |
| `@medium` | Medium priority |

---

## 5. Coverage Analysis

| Feature | Scenarios | Happy Path | Negative | Gap | Coverage |
|---------|-----------|------------|----------|-----|----------|
| Province Authorization | 5 | 2 | 2 | 1 | High |
| Field Validation | 6 | 2 | 2 | 2 | High |
| OAuth Token | 4 | 2 | 1 | 1 | Medium |
| SOAP Request Construction | 4 | 2 | 0 | 2 | Medium |
| Fire Protection Mapping | 3 | 2 | 1 | 0 | Medium |
| Transaction Logging | 5 | 3 | 1 | 1 | High |
| Error Handling | 6 | 2 | 3 | 1 | High |
| Request ID Generation | 3 | 2 | 0 | 1 | Medium |
| Data Cache Loading | 4 | 2 | 1 | 1 | Medium |
| Response Marshalling | 4 | 3 | 0 | 1 | Medium |
| Task Manager CRUD | 8 | 5 | 2 | 0 | High |
| Task Filtering | 4 | 4 | 0 | 0 | Medium |
| **Total** | **56** | **31** | **13** | **11** | |
