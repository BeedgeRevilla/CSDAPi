Feature: EB XP API Retrieve Policy Information
  Records retrieved will depend on the parameters set on the GET request.

  Scenario Outline: EB XP API Retrieve Policy Information - Successful retrieval of records when <scenarioName>

    Given the following http headers are set for Retrieve Policy Information
      | x-axahk-msgid   |
      | <x-axahk-msgid> |

    And the following GET input parameters are set for Retrieve Policy Information
      | affiliateNo   | policyHolderNo   |
      | <affiliateNo> | <policyHolderNo> |

    When the XPAPI call has been made for Retrieve Policy Information

    When the BAPI call has been made for Retrieve Policy Information

    Then verify that XP API and BAPI responses matched for Retrieve Policy Information

    Examples:
      | scenarioName                          | x-axahk-msgid | affiliateNo | policyHolderNo |
      | all required parameters are populated | RPIL_01       | 01          | 04001201GL     |


  Scenario Outline: EB XP API Retrieve Policy Information - Unsuccessful retrieval of records when <scenarioName>

    Given the following http headers are set for Retrieve Policy Information
      | x-axahk-msgid   |
      | <x-axahk-msgid> |

    And the following GET input parameters are set for Retrieve Policy Information
      | affiliateNo   | policyHolderNo   |
      | <affiliateNo> | <policyHolderNo> |

    When the XPAPI call has been made for Retrieve Policy Information

    Then an error must be encountered with the following reasons
      | ERROR_CODE   | ERROR_PHRASE   | ERROR_BODY   |
      | <ERROR_CODE> | <ERROR_PHRASE> | <ERROR_BODY> |

    Examples:
      | scenarioName                              | x-axahk-msgid | affiliateNo | policyHolderNo | ERROR_CODE | ERROR_PHRASE          | ERROR_BODY                                                                                                             |
      | records are mismatched                    | RPIL_02       | 01Y         | 04001201GL     | 500        | Internal Server Error | {  "httpStatus": 500,  "responseCode": "457",  "reason": "There is no matching result for search parameters"}          |
      | mandatory header x-axahk-msgId is missing | #####         | 01          | 04001201GL     | 400        | Bad Request           | {  "httpStatus": "400",  "responseCode": "400",  "reason": "Bad request: Required header x-axahk-msgid not specified"} |
      | mandatory header x-axahk-msgId is null    |               | 01          | 04001201GL     | 400        | Bad Request           | {  "httpStatus": "400",  "responseCode": "400",  "reason": "Bad request: Invalid value '' for header x-axahk-msgid"}   |



