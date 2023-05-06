Feature: REGIONAL Retrieve Fund List
  Records retrieved will depend on the parameters set on the GET request.

  	Scenario Outline: Retrieve Fund List - <entity>_<lob>_<msgId> - Successful retrieval of records

    Given the following http headers are set Retrieve Fund List
      | X-Axa-Entity  | X-Axa-LOB   | X-Axa-MsgId   | X-Axa-InitialMsgId   | X-Axa-Env   | X-Axa-ContextHeader-CustomData-TargetSystem   | X-Axa-ContextHeader-CustomData-SourceSystem   | Accept   |
      | <entity>      | <lob>       | <msgId>       | <initialMsgId>       | <env>       | <targetSystem>                                | <sourceSystem>                                | <accept> |

    And the following GET input parameters are set for Retrieve Fund List
      | policyNumber   |
      | <policyNumber> |

    When the api call has been made for Retrieve Fund List

    When the Stored Procedure is called for Retrieve Fund List

    Then verify that API and DB responses matched for Retrieve Fund List

    @SG
    Examples:
      | entity| lob | msgId          | initialMsgId   | env | targetSystem | sourceSystem  | accept           | policyNumber |
      | SG    | Life| SG_RLS_SCRM_01 | SG_RLS_SCRM_01 | PPE3| RLS          | SCRM          | application/json | 101-7808955  |
      | SG    | Life| SG_RLS_SCRM_02 | SG_RLS_SCRM_02 | PPE3| RLS          | SCRM          | application/json | 701-6338720  |

      | SG    | Life| SG_RLS_SCRM_03 | SG_RLS_SCRM_03 | PPE3| RLS          | SCRM          | application/json | 102-2153611  |
      | SG    | Life| SG_RLS_SCRM_04 | SG_RLS_SCRM_04 | PPE3| RLS          | SCRM          | application/json | 102-2166019  |
      | SG    | Life| SG_RLS_SCRM_05 | SG_RLS_SCRM_05 | PPE3| RLS          | SCRM          | application/json | 102-2215519  |
      | SG    | Life| SG_RLS_SCRM_06 | SG_RLS_SCRM_06 | PPE3| RLS          | SCRM          | application/json | 102-2215642  |
      | SG    | Life| SG_RLS_SCRM_07 | SG_RLS_SCRM_07 | PPE3| RLS          | SCRM          | application/json | 102-2258485  |
      | SG    | Life| SG_RLS_SCRM_08 | SG_RLS_SCRM_08 | PPE3| RLS          | SCRM          | application/json | 102-2259285  |
      | SG    | Life| SG_RLS_SCRM_09 | SG_RLS_SCRM_09 | PPE3| RLS          | SCRM          | application/json | 502-5877258  |
      | SG    | Life| SG_RLS_SCRM_10 | SG_RLS_SCRM_10 | PPE3| RLS          | SCRM          | application/json | 502-5884601  |

    @TH
    Examples:
      | entity| lob | msgId          | initialMsgId   | env | targetSystem | sourceSystem  | accept           | policyNumber |
      | TH    | Life| TH_RLS_SCRM_01 | TH_RLS_SCRM_01 | PPE3| RLS          | SCRM          | application/json | 507-9037627  |
      | TH    | Life| TH_RLS_SCRM_02 | TH_RLS_SCRM_02 | PPE3| RLS          | SCRM          | application/json | 507-9037635  |

    @PH
    Examples:
      | entity| lob | msgId          | initialMsgId   | env | targetSystem | sourceSystem  | accept           | policyNumber |
      | PH    | Life| PH_RLS_SCRM_01 | PH_RLS_SCRM_01 | PPE3| RLS          | SCRM          | application/json | 510-0104172  |
      | PH    | Life| PH_RLS_SCRM_02 | PH_RLS_SCRM_02 | PPE3| RLS          | SCRM          | application/json | 510-0103893  |

    @HK
    Examples:
      | entity| lob | msgId          | initialMsgId   | env | targetSystem | sourceSystem  | accept           | policyNumber |
      | HK    | Life| HK_RLS_SCRM_01 | HK_RLS_SCRM_01 | PPE3| RLS          | SCRM          | application/json | 502-5474726  |
      | HK    | Life| HK_RLS_SCRM_02 | HK_RLS_SCRM_02 | PPE3| RLS          | SCRM          | application/json | 502-5307421  |
      