Feature: REGIONAL Record Customer
  Records posted will depend on the parameters set on the PUT request.

	@SG
  	Scenario Outline: Record Customer - <entity>_<sourceSystem>_<TCNo> - Successful update of records

    Given the following http headers are set Record Customer
      | X-Axa-Entity  | X-Axa-LOB   | X-Axa-MsgId   | X-Axa-InitialMsgId   | X-Axa-Env   | X-Axa-ContextHeader-CustomData-TargetSystem   | X-Axa-ContextHeader-CustomData-SourceSystem   | Accept   | x-axa-resubmissionflag | x-axa-CallbackFlag |  
      | <entity>      | <lob>       | <msgId>       | <initialMsgId>       | <env>       | <targetSystem>                                | <sourceSystem>                                | <accept> | <resubmissionflag>		 | <CallbackFlag>			|

    And the following PAYLOAD request body is set for Record Customer
      | payload   |
      | <payload> |

    When the api call has been made for Record Customer

    Then verify that API response matches for Record Customer
    	| sourceMsgID | contextID | status   |
    	| <msgId>			| <msgId>		| <status> |

    Examples:
      | TCNo | entity| lob | msgId       | initialMsgId | env  | targetSystem | sourceSystem  | accept           | resubmissionflag | CallbackFlag | payload 											 | status    |
      | 0001 | SG    |     | SG_SCRM_01  | SG_SCRM_01   | NFT1 | COREDB       | SCRM          | application/json | Y                | Y						| recordCustomer_SG_SCRM_01.txt  | Submitted |
      | 0002 | SG    |     | [$autogen]  | [$autogen]   | NFT1 | COREDB       | SCRM          | application/json |                  | Y						| recordCustomer_SG_SCRM_01.txt  | Submitted |
