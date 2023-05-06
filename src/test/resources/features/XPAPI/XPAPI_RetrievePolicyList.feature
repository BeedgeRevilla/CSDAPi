Feature: EB XP API Retrieve Policy List
  Records retrieved will depend on the parameters set on the GET request.

  Scenario Outline: EB XP API Retrieve Policy List - Successful retrieve of records when <scenarioName>

    Given the following http headers are set for Retrieve Policy List
      | x-axahk-msgid   |
      | <x-axahk-msgid> |

    And the following GET input parameters are set for XP Retrieve Policy List
      | affiliateNo   | policyHolderNo   | pageNo   | recordsPerPage   | fromDate   | toDate   | orderBy   | sortKey   |
      | <affiliateNo> | <policyHolderNo> | <pageNo> | <recordsPerPage> | <fromDate> | <toDate> | <orderBy> | <sortKey> |

    When the XPAPI call has been made for Retrieve Policy List

    When the BAPI call has been made for Retrieve Policy List

    Then verify that XP API and BAPI responses matched for Retrieve Policy List

    Examples:
      | scenarioName                              | x-axahk-msgid | policyHolderNo | affiliateNo | pageNo | recordsPerPage | fromDate | toDate   | orderBy | sortKey       |
      | all parameters are populated              | RPL_01        | 049685         | 01          | 1      | 4              | 20160101 | 20180101 | DESC    | BILL_ISSUE_DT |
      | optional parameters are not populated     | RPL_02        | 049685         |             | 4      | 2              |          |          |         |               |
      | pageNo and recordsPerPage is not provided | RPL_03        | 049685         |             |        |                |          |          |         |               |


  Scenario Outline: EB XP API Retrieve Policy List - Unsuccessful retrieval of records when <scenarioName>

    Given the following http headers are set for Retrieve Policy List
      | x-axahk-msgid   |
      | <x-axahk-msgid> |

    And the following GET input parameters are set for XP Retrieve Policy List
      | affiliateNo   | policyHolderNo   | pageNo   | recordsPerPage   | fromDate   | toDate   | orderBy   | sortKey   |
      | <affiliateNo> | <policyHolderNo> | <pageNo> | <recordsPerPage> | <fromDate> | <toDate> | <orderBy> | <sortKey> |

    When the XPAPI call has been made for Retrieve Policy List

    Then an error must be encountered with the following reasons
      | ERROR_CODE   | ERROR_PHRASE   | ERROR_BODY   |
      | <ERROR_CODE> | <ERROR_PHRASE> | <ERROR_BODY> |

    Examples:
      | scenarioName                              | x-axahk-msgid | policyHolderNo | affiliateNo | pageNo | recordsPerPage | fromDate   | toDate     | orderBy | sortKey | ERROR_CODE | ERROR_PHRASE          | ERROR_BODY                                                                                                                       |
      | required query params are not provided    | RPL_04        |                |             |        |                |            |            |         |         | 400        | Bad Request           | {  "httpStatus": "400",  "responseCode": "400",  "reason": "Bad request: Required query parameter policyHolderNo not specified"} |
      | records are mismatched                    | RPL_05        | 043491         |             | 2      | 20             |            |            |         |         | 500        | Internal Server Error | {  "httpStatus": 500,  "responseCode": "457",  "reason": "There is no matching result for search parameters"}                    |
      | invalid date format is provided           | RPL_06        | 043491         |             |        |                | 2016/09/09 | 2018/09/09 |         |         | 400        | Bad Request           | {  "httpStatus": "400",  "responseCode": "400",  "reason": "Bad request: Invalid date format provided. Expected yyyymmdd"}       |
      | mandatory header x-axahk-msgId is missing | #####         | 049685         |             |        |                |            |            |         |         | 400        | Bad Request           | {  "httpStatus": "400",  "responseCode": "400",  "reason": "Bad request: Required header x-axahk-msgid not specified"}           |
      | mandatory header x-axahk-msgId is null    |               | 049685         |             |        |                |            |            |         |         | 400        | Bad Request           | {  "httpStatus": "400",  "responseCode": "400",  "reason": "Bad request: Invalid value '' for header x-axahk-msgid"}             |