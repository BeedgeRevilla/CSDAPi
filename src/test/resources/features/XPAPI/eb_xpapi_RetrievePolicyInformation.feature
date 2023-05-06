Feature: EB XP API Retrieve Policy Information
  Records retrieved will depend on the parameters set on the GET request.

  Scenario: EB XP API Retrieve Policy Information - 01 - Successful retrieve of records when all paramters are populated

    Given the following http headers are set for Retrieve Policy Information
      | x-axahk-msgid |
      | RPIL_00       |

    And the following GET input parameters are set for Retrieve Policy Information
      | policyHolderNo |
      | 04001201GL     |

    When the XPAPI call has been made for Retrieve Policy Information

    When the BAPI call has been made for Retrieve Policy Information

    Then verify that XP API and BAPI responses matched for Retrieve Policy Information

  Scenario: EB XP API Retrieve Policy Information - 02 - Unsuccessful retrieval of records when records are mismatched

    Given the following http headers are set for Retrieve Policy Information
      | x-axahk-msgid |
      | RPIL_01       |

    And the following GET input parameters are set for Retrieve Policy Information
      | policyHolderNo |
      | 12345          |

    When the XPAPI call has been made for Retrieve Policy Information

    Then an error must be encountered with the following reasons
      | ERROR_CODE | ERROR_PHRASE          | ERROR_BODY                                                                                                    |
      | 500        | Internal Server Error | {  "httpStatus": 500,  "responseCode": "457",  "reason": "There is no matching result for search parameters"} |

  Scenario: EB XP API Retrieve Policy Information - 03 - Unsuccessful retrieval of records when mandatory header x-axahk-msgId is missing

    Given the following http headers are set for Retrieve Policy Information
      | x-axahk-msgid |
      | #####         |

    And the following GET input parameters are set for Retrieve Policy Information
      | policyHolderNo |
      | 04001201GL     |

    When the XPAPI call has been made for Retrieve Policy Information

    Then an error must be encountered with the following reasons
      | ERROR_CODE | ERROR_PHRASE | ERROR_BODY                                                                                        |
      | 400        | Bad Request  | {  "responseCode": "400",  "reason": "Bad request: Required header x-axahk-msgid not specified"}  |

  Scenario: EB XP API Retrieve Policy Information - 04 - Unsuccessful retrieval of records when mandatory header x-axahk-msgId is null

    Given the following http headers are set for Retrieve Policy Information
      | x-axahk-msgid |
      |               |

    And the following GET input parameters are set for Retrieve Policy Information
      | policyHolderNo |
      | 04001201GL     |

    When the XPAPI call has been made for Retrieve Policy Information

    Then an error must be encountered with the following reasons
      | ERROR_CODE | ERROR_PHRASE | ERROR_BODY                                                                                        |
      | 400        | Bad Request  | {  "responseCode": "400",  "reason": "Bad request: Invalid value '' for header x-axahk-msgid"}    |