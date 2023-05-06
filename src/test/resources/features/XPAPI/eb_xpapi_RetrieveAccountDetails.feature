Feature: EB XP API Retrieve Account Details
  Records retrieved will depend on the parameters set on the GET request.

  Scenario: EB XP API Retrieve Account Details - 01 - Retrieve records when all parameters are populated

    Given the following headers are set
      | x-axahk-msgid                        |
      | 155470ed-21ad-4c16-a58c-e2deabfa7b81 |

    And the following GET input parameters are set for RetrieveAccountDetails
      | affiliateNo | policyHolderNo |
      | 345         | 0523456789     |

    When a GET api call has been made to the RetrieveAccountDetails API

    Then the response body for the RetrieveAccountDetails API must contain the following
      | companyName | companyAddress            | companyPIC | companyTelephone | affiliateName   | affiliateAddress   |
      | "AXA"       | "How ming, Hong Kong"     | "Peter"    | "632-9876787"    | "AXA Life HK"   | "Hongkong"         |
      | "AXA"       | "How ming, Hong Kong"     | "Peter"    | "632-9876787"    | "AXA HEALTH MY" | "Kuala Lumpur, MY" |

  Scenario: EB XP API Retrieve Account Details - 02 - Unsuccessful retrieval of records when mandatory header x-axahk-msgId is missing
    Given the following headers are set
      | x-axahk-msgid |
      | #####         |

    And the following GET input parameters are set for Retrieve Account Details
      | affiliateNo | policyHolderNo |
      | 345         | 0523456789     |

    When a GET api call has been made to the RetrieveAccountDetails API

    Then an error must be encountered with the following reasons
      | ERROR_CODE | ERROR_PHRASE | ERROR_BODY                                                                                       |
      | 400        | Bad Request  | {  "responseCode": "400",  "reason": "Bad request: Required header x-axahk-msgid not specified"} |

  Scenario: EB XP API Retrieve Account Details - 03 - Unsuccessful retrieval of records when mandatory header x-axahk-msgId is null
    Given the following headers are set
      | x-axahk-msgid |
      |               |

    And the following GET input parameters are set for Retrieve Account Details
      | affiliateNo | policyHolderNo |
      | 345         | 0523456789     |

    When a GET api call has been made to the RetrieveAccountDetails API

    Then an error must be encountered with the following reasons
      | ERROR_CODE | ERROR_PHRASE | ERROR_BODY                                                                                     |
      | 400        | Bad Request  | {  "responseCode": "400",  "reason": "Bad request: Invalid value '' for header x-axahk-msgid"} |