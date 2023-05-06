Feature: REGIONAL Retrieve Claim Details
  Records retrieved will depend on the parameters set on the GET request.

	@HK
    Scenario Outline: Retrieve Claim Details <entity> - <msgId> - Successful retrieval of records

    Given the following http headers are set Retrieve Claim Details
      | X-Axa-Entity  | X-Axa-LOB   | X-Axa-MsgId   | X-Axa-InitialMsgId   | X-Axa-Env   | X-Axa-ContextHeader-CustomData-TargetSystem   | X-Axa-ContextHeader-CustomData-SourceSystem   | Accept   |
      | <entity>      | <lob>       | <msgId>       | <initialMsgId>       | <env>       | <targetSystem>                                | <sourceSystem>                                | <accept> |

    And the following GET input parameters are set for Retrieve Claim Details
      | claimNumber   | policyNumber   |
      | <claimNumber> | <policyNumber> |

    When the api call has been made for Retrieve Claim Details

    When the Stored Procedure is called for Retrieve Claim Details

    Then verify that API and DB responses matched for Retrieve Claim Details

    Examples:
      | entity| lob   | msgId            | initialMsgId     | env | targetSystem | sourceSystem  | accept           | policyNumber | claimNumber |
      | HK    | Life  | HK_LIFE_SCRM_01  | HK_LIFE_SCRM_01  |     | RLS          | SCRM          | application/json | A2395153-01  | 1637941     |
      | HK    | Life  | HK_LIFE_SCRM_02  | HK_LIFE_SCRM_02  |     | RLS          | SCRM          | application/json | 302-4623187  | 1393599     |
      | HK    | Life  | HK_LIFE_HCT_01   | HK_LIFE_HCT_01   |     | RLS          | HCT           | application/json | A2531006-01  | 905066      |
      | HK    | Life  | HK_LIFE_HCT_02   | HK_LIFE_HCT_02   |     | RLS          | HCT           | application/json | 300-1018781  | 1405531     |
      | HK    | Life  | HK_LIFE_NBPT_01  | HK_LIFE_NBPT_01  |     | RLS          | NBPT          | application/json | A2602868-01  | 1585610     |
      | HK    | Life  | HK_LIFE_NBPT_02  | HK_LIFE_NBPT_02  |     | RLS          | NBPT          | application/json | 302-5493028  | 1526654     |
      
      
	@PH
    Scenario Outline: Retrieve Claim Details <entity> - <msgId> - Successful retrieval of records

    Given the following http headers are set Retrieve Claim Details
      | X-Axa-Entity  | X-Axa-LOB   | X-Axa-MsgId   | X-Axa-InitialMsgId   | X-Axa-Env   | X-Axa-ContextHeader-CustomData-TargetSystem   | X-Axa-ContextHeader-CustomData-SourceSystem   | Accept   |
      | <entity>      | <lob>       | <msgId>       | <initialMsgId>       | <env>       | <targetSystem>                                | <sourceSystem>                                | <accept> |

    And the following GET input parameters are set for Retrieve Claim Details
      | claimNumber   | policyNumber   |
      | <claimNumber> | <policyNumber> |

    When the api call has been made for Retrieve Claim Details

    When the Stored Procedure is called for Retrieve Claim Details

    Then verify that API and DB responses matched for Retrieve Claim Details

    Examples:
      | entity| lob   | msgId            | initialMsgId     | env | targetSystem | sourceSystem  | accept           | policyNumber | claimNumber |
      | PH    | Life  | PH_LIFE_SCRM_01  | PH_LIFE_SCRM_01  |     | RLS          | SCRM          | application/json | 301-1168428  | 2565        |
      | PH    | Life  | PH_LIFE_SCRM_02  | PH_LIFE_SCRM_02  |     | RLS          | SCRM          | application/json | 310-0168529  | 19885       |


	@SG
    Scenario Outline: Retrieve Claim Details <entity> - <msgId> - Successful retrieval of records

    Given the following http headers are set Retrieve Claim Details
      | X-Axa-Entity  | X-Axa-LOB   | X-Axa-MsgId   | X-Axa-InitialMsgId   | X-Axa-Env   | X-Axa-ContextHeader-CustomData-TargetSystem   | X-Axa-ContextHeader-CustomData-SourceSystem   | Accept   |
      | <entity>      | <lob>       | <msgId>       | <initialMsgId>       | <env>       | <targetSystem>                                | <sourceSystem>                                | <accept> |

    And the following GET input parameters are set for Retrieve Claim Details
      | claimNumber   | policyNumber   |
      | <claimNumber> | <policyNumber> |

    When the api call has been made for Retrieve Claim Details

    When the Stored Procedure is called for Retrieve Claim Details

    Then verify that API and DB responses matched for Retrieve Claim Details

    Examples:
      | entity| lob   | msgId            | initialMsgId     | env | targetSystem | sourceSystem  | accept           | policyNumber | claimNumber |
      | SG    | Life  | SG_LIFE_SCRM_01  | SG_LIFE_SCRM_01  |     | RLS          | SCRM          | application/json | 301-8032767  | 17437       |
      | SG    | Life  | SG_LIFE_SCRM_02  | SG_LIFE_SCRM_02  |     | RLS          | SCRM          | application/json | 501-7559203  | 2003230     |


	@TH
    Scenario Outline: Retrieve Claim Details <entity> - <msgId> - Successful retrieval of records

    Given the following http headers are set Retrieve Claim Details
      | X-Axa-Entity  | X-Axa-LOB   | X-Axa-MsgId   | X-Axa-InitialMsgId   | X-Axa-Env   | X-Axa-ContextHeader-CustomData-TargetSystem   | X-Axa-ContextHeader-CustomData-SourceSystem   | Accept   |
      | <entity>      | <lob>       | <msgId>       | <initialMsgId>       | <env>       | <targetSystem>                                | <sourceSystem>                                | <accept> |

    And the following GET input parameters are set for Retrieve Claim Details
      | claimNumber   | policyNumber   |
      | <claimNumber> | <policyNumber> |

    When the api call has been made for Retrieve Claim Details

    When the Stored Procedure is called for Retrieve Claim Details

    Then verify that API and DB responses matched for Retrieve Claim Details

    Examples:
      | entity| lob   | msgId            | initialMsgId     | env | targetSystem | sourceSystem  | accept           | policyNumber | claimNumber |
      | TH    | Life  | TH_LIFE_SCRM_01  | TH_LIFE_SCRM_01  |     | RLS          | SCRM          | application/json | 501-1094751  | 1479629     |
      | TH    | Life  | TH_LIFE_SCRM_02  | TH_LIFE_SCRM_02  |     | RLS          | SCRM          | application/json | 501-1111910  | 368902      |

