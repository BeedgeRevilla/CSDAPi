Feature: EB XP API Retrieve Account Details
  Records retrieved will depend on the parameters set on the GET request.

  Scenario Outline: Retrieve Account Details - Successful retrieval of records when <scenarioName>

    Given the following http headers are set for XP Retrieve Account Details
      | x-axahk-msgid   |
      | <x-axahk-msgid> |

    And the following GET input parameters are set for XP Retrieve Account Details
      | affiliateNo   | policyHolderNo   |
      | <affiliateNo> | <policyHolderNo> |

    When a GET XP API call has been made to the Retrieve Account Details

    #When the BAPI call has been made for Retrieve Account Details

    #SThen verify that XP API and BAPI responses matched for Retrieve Account Details

    Examples:
      | scenarioName                         | x-axahk-msgid                        | affiliateNo | policyHolderNo |
      | all required paramters are populated | 155470ed-21ad-4c16-a58c-e2deabfa7b81 | 345         | 0523456789     |
      #| all required paramters are populated | 155470ed-21ad-4c16-a58c-e2deabfa7b81 |             | 10000101GH     |


