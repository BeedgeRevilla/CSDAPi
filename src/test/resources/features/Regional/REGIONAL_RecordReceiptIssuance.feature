Feature: REGIONAL Record Receipt Issuance
  Records posted will depend on the parameters set on the POST request.


  Scenario Outline: Record Receipt Issuance - <entity>_<sourceSystem>_<TCNo> - Successful post of records

    Given the following http headers are set Record Receipt Issuance
      | X-Axa-Entity | X-Axa-LOB | X-Axa-MsgId | X-Axa-InitialMsgId | X-Axa-Env | X-Axa-ContextHeader-CustomData-TargetSystem | X-Axa-ContextHeader-CustomData-SourceSystem | Accept   | X-Axa-CallbackFlag | X-Axa-RequestingChannel |
      | <entity>     | <lob>     | <msgId>     | <initialMsgId>     | <env>     | <targetSystem>                              | <sourceSystem>                              | <accept> | <CallbackFlag>     | <requestingChannel>     |

    And the following PAYLOAD request body is set for Record Receipt Issuance
      | payload   | bankCode   | currency   | branchCode   | partyId   | policyNumber   |
      | <payload> | <bankCode> | <currency> | <branchCode> | <partyId> | <policyNumber> |

    When the api call has been made for Record Receipt Issuance

    Then verify that API response matches for Record Receipt Issuance
      | sourceMsgID | contextID | status   |
      | <msgId>     | <msgId>   | <status> |

    And verify that the records are matching in PSEA for Record Receipt Issuance

  @MY
    Examples:
      | TCNo | entity | lob  | msgId      | initialMsgId | env | targetSystem | sourceSystem | requestingChannel | accept           | CallbackFlag | payload | bankCode | branchCode | currency | partyId | policyNumber | status    |
      | 0001 | MY     | Life | [$autogen] | [$autogen]   |     | PSEA         | ILINK        | IAAS              | application/json | Y            |         | P3       | 99         | RM       | 22182   | K0027218     | Submitted |
      | 0002 | MY     | Life | [$autogen] | [$autogen]   |     | PSEA         | ILINK        | IAAS              | application/json | Y            |         | P2       | 50         | RM       | 32379   | K0027249     | Submitted |

  @SG
    Examples:
      | TCNo | entity | lob  | msgId      | initialMsgId | env | targetSystem | sourceSystem | requestingChannel | accept           | CallbackFlag | payload | bankCode | branchCode | currency | partyId | policyNumber | status    |
      | 0001 | SG     | Life | [$autogen] | [$autogen]   |     | PSEA         | MYAXA        | SFDC              | application/json | Y            |         | IA       | 10         | SGD      | 14302   | E4002524     | Submitted |
      | 0002 | SG     | Life | [$autogen] | [$autogen]   |     | PSEA         | SCRM         | SFDC              | application/json | Y            |         | 49       | 10         | SGD      | 14302   | E4002533     | Submitted |
      | 0003 | SG     | Life | [$autogen] | [$autogen]   |     | PSEA         | IAAS         | SFDC              | application/json | Y            |         | IA       | 10         | SGD      | 15023   | E5671105     | Submitted |
      | 0004 | SG     | Life | [$autogen] | [$autogen]   |     | PSEA         | MYAXA        | SFDC              | application/json | Y            |         | 49       | 10         | SGD      | 14302   | E4002534     | Submitted |
      | 0005 | SG     | Life | [$autogen] | [$autogen]   |     | PSEA         | SCRM         | SFDC              | application/json | Y            |         | IA       | 10         | SGD      | 15023   | E5671106     | Submitted |
      | 0006 | SG     | Life | [$autogen] | [$autogen]   |     | PSEA         | IAAS         | SFDC              | application/json | Y            |         | 49       | 10         | SGD      | 05433   | P2164422     | Submitted |
