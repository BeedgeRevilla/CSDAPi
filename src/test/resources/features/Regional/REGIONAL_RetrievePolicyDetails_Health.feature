Feature: REGIONAL Retrieve Policy Details Health
  Records retrieved will depend on the parameters set on the GET request.

	@SG
    Scenario Outline: Retrieve Policy Details - <msgId> - Successful retrieval of records

    Given the following http headers are set Retrieve Policy Details
      | X-Axa-Entity | X-Axa-LOB | X-Axa-MsgId | X-Axa-InitialMsgId | X-Axa-Env | X-Axa-ContextHeader-CustomData-TargetSystem | X-Axa-ContextHeader-CustomData-SourceSystem | Accept   |
      | <entity>     | <lob>     | <msgId>     | <initialMsgId>     | <env>     | <targetSystem>                              | <sourceSystem>                              | <accept> |

    And the following GET input parameters are set for Retrieve Policy Details
      | sourceSystemCode   | policyNumber   | certificateNumber   |
      | <sourceSystemCode> | <policyNumber> | <certificateNumber> |

    When the api call has been made for Retrieve Policy Details

    When the Stored Procedure is called for Retrieve Policy Details

    Then verify that API and DB responses matched for Retrieve Policy Details

    Examples:
      | entity | lob    | msgId              | initialMsgId       | env | targetSystem | sourceSystem | accept           | sourceSystemCode | policyNumber | certificateNumber |
      | SG     | Health | SG_HEALTH_SCRM_01  | SG_HEALTH_SCRM_01  |     | G400         | SCRM         | application/json | G400             | Q0008955     | 00018             |
      | SG     | Health | SG_HEALTH_SCRM_02  | SG_HEALTH_SCRM_02  |     | G400         | SCRM         | application/json | G400             | HA003648     | 00001             |
 #     #| SG     | Health | SG_HEALTH_SCRM_03  | SG_HEALTH_SCRM_03  |     | GASIA        | SCRM         | application/json | GASIA            | 80010705     | 00036             |
      | SG     | Health | SG_HEALTH_SCRM_04  | SG_HEALTH_SCRM_04  |     | GASIA        | SCRM         | application/json | GASIA            | 80025586     | 00001             |
#      #| SG     | Health | SG_HEALTH_SCRM_05  | SG_HEALTH_SCRM_05  |     | GASIA        | SCRM         | application/json | GASIA            | 80025568     | 00007             |
      | SG     | Health | SG_HEALTH_SCRM_06  | SG_HEALTH_SCRM_06  |     | G400         | SCRM         | application/json | G400             | HB000442     | 00001             |
      | SG     | Health | SG_HEALTH_MYAXA_01 | SG_HEALTH_MYAXA_01 |     | G400         | MYAXA        | application/json | G400             | Q0008955     | 00018             |
      | SG     | Health | SG_HEALTH_MYAXA_02 | SG_HEALTH_MYAXA_02 |     | G400         | MYAXA        | application/json | G400             | HA003648     | 00001             |
#      #| SG     | Health | SG_HEALTH_MYAXA_03 | SG_HEALTH_MYAXA_03 |     | GASIA        | MYAXA        | application/json | GASIA            | 80010705     | 00036             |
      | SG     | Health | SG_HEALTH_MYAXA_04 | SG_HEALTH_MYAXA_04 |     | GASIA        | MYAXA        | application/json | GASIA            | 80025586     | 00001             |
#      #| SG     | Health | SG_HEALTH_MYAXA_05 | SG_HEALTH_MYAXA_05 |     | GASIA        | MYAXA        | application/json | GASIA            | 80025568     | 00007             |
      | SG     | Health | SG_HEALTH_MYAXA_06 | SG_HEALTH_MYAXA_06 |     | G400         | MYAXA        | application/json | G400             | HB000442     | 00001             |
      | SG     | Health | SG_HEALTH_IAAS_01  | SG_HEALTH_IAAS_01  |     | G400         | IAAS         | application/json | G400             | Q0008955     | 00018             |
      | SG     | Health | SG_HEALTH_IAAS_02  | SG_HEALTH_IAAS_02  |     | G400         | IAAS         | application/json | G400             | HA003648     | 00001             |
#      #| SG     | Health | SG_HEALTH_IAAS_03  | SG_HEALTH_IAAS_03  |     | GASIA        | IAAS         | application/json | GASIA            | 80010705     | 00036             |
      | SG     | Health | SG_HEALTH_IAAS_04  | SG_HEALTH_IAAS_04  |     | GASIA        | IAAS         | application/json | GASIA            | 80025586     | 00001             |
#      #| SG     | Health | SG_HEALTH_IAAS_05  | SG_HEALTH_IAAS_05  |     | GASIA        | IAAS         | application/json | GASIA            | 80025568     | 00007             |
      | SG     | Health | SG_HEALTH_IAAS_06  | SG_HEALTH_IAAS_06  |     | G400         | IAAS         | application/json | G400             | HB000442     | 00001             |
