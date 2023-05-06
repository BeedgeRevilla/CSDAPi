Feature: A-Lake Retrieve Policy List
  Records retrieved will depend on the parameters set on the GET request.

  @init
  Scenario: Successful retrieve of records when all paramters are populated

    Given the following http headers are set for Retrieve Policy List
      | x-axahk-channelcode | x-axahk-msgid | x-axahk-lob | x-axahk-sourcesystem | content-type      | Accept           |
      | EB-PORTAL           | RPIL_00       | HEALTH      | EB                   | application/json  | application/json |

    And the following GET input parameters are set for Retrieve Policy List
      | policyHolderNo | affiliateNo | pageNo | mdmId   | recordsPerPage | fromDate | toDate   | orderBy | sortKey       |
      | 049685         |             | 2      | 8555845 | 4              | 20160101 | 20180101 | DESC	 | BILL_ISSUE_DT |

    When the XPAPI call has been made for Retrieve Policy List

    #When the BAPI call has been made for Retrieve Policy List


