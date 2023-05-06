Feature: REGIONAL Retrieve Agent Details
  Records retrieved will depend on the parameters set on the GET request.

	@SG
  	Scenario Outline: Retrieve Agent Details - <msgId> - Successful retrieval of records

    Given the following http headers are set Retrieve Agent Details
      | X-Axa-Entity  | X-Axa-LOB   | X-Axa-MsgId   | X-Axa-InitialMsgId   | X-Axa-Env   | X-Axa-ContextHeader-CustomData-TargetSystem   | X-Axa-ContextHeader-CustomData-SourceSystem   | Accept   |
      | <entity>      | <lob>       | <msgId>       | <initialMsgId>       | <env>       | <targetSystem>                                | <sourceSystem>                                | <accept> |

    And the following GET input parameters are set for Retrieve Agent Details
      | agentCode   |
      | <agentCode> |

    When the api call has been made for Retrieve Agent Details

    When the Stored Procedure is called for Retrieve Agent Details

    Then verify that API and DB responses matched for Retrieve Agent Details

    Examples:
      | entity| lob | msgId          | initialMsgId   | env | targetSystem | sourceSystem  | accept           | agentCode |
      | SG    | GI  | SG_GI_SCRM_01  | SG_GI_SCRM_01  |     | PSEA         | SCRM          | application/json | 00577     |
      