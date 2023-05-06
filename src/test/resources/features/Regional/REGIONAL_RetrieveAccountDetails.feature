Feature: REGIONAL Retrieve Account Details
  Records retrieved will depend on the parameters set on the GET request.

  Scenario Outline: Retrieve Account Details <entity> - <lob> - <sourceSystem> - <TCNo> - <msgId> - Successful retrieval of records

    Given the following http headers are set Retrieve Account Details
      | X-Axa-Entity | X-Axa-LOB | X-Axa-MsgId | X-Axa-InitialMsgId | X-Axa-Env | X-Axa-ContextHeader-CustomData-TargetSystem | X-Axa-ContextHeader-CustomData-SourceSystem | Accept   |
      | <entity>     | <lob>     | <msgId>     | <initialMsgId>     | <env>     | <targetSystem>                              | <sourceSystem>                              | <accept> |

    And the following GET input parameters are set for Retrieve Account Details
      | policyNumber   |
      | <policyNumber> |

    When the api call has been made for Retrieve Account Details

    When the Stored Procedure is called for Retrieve Account Details

    Then verify that API and DB responses matched for Retrieve Account Details

  @SG
    Examples:
      | TCNo | entity | lob  | msgId            | initialMsgId     | env | targetSystem | sourceSystem | accept           | policyNumber |
      | 0001 | SG     | GI  | SG_GI_SCRM_01  | SG_GI_SCRM_01  |     | PSEA         | SCRM         | application/json | P1953372     |
      | 0002 | SG     | GI  | SG_GI_SCRM_02  | SG_GI_SCRM_02  |     | PSEA         | SCRM         | application/json | P1276283     |
      | 0003 | SG     | GI  | SG_GI_MYAXA_01 | SG_GI_MYAXA_01 |     | PSEA         | MYAXA        | application/json | P1301476     |
      | 0004 | SG     | GI  | SG_GI_MYAXA_02 | SG_GI_MYAXA_02 |     | PSEA         | MYAXA        | application/json | P1280248     |
      | 0005 | SG     | GI  | SG_GI_IAAS_01  | SG_GI_IAAS_01  |     | PSEA         | IAAS         | application/json | P1286482     |
      | 0006 | SG     | GI  | SG_GI_IAAS_02  | SG_GI_IAAS_02  |     | PSEA         | IAAS         | application/json | P1286222     |

      | 0007 | SG     | Life | SG_LIFE_SCRM_01  | SG_LIFE_SCRM_01  |     | RLS          | SCRM         | application/json | 302-1284074  |
      | 0008 | SG     | Life | SG_LIFE_SCRM_02  | SG_LIFE_SCRM_02  |     | RLS          | SCRM         | application/json | 501-7634964  |
      | 0007 | SG     | Life | SG_LIFE_MYAXA_01 | SG_LIFE_MYAXA_01 |     | RLS          | MYAXA        | application/json | 302-1292853  |
      | 0008 | SG     | Life | SG_LIFE_MYAXA_02 | SG_LIFE_MYAXA_02 |     | RLS          | MYAXA        | application/json | 302-1292978  |
      | 0007 | SG     | Life | SG_LIFE_IAAS_01  | SG_LIFE_IAAS_01  |     | RLS          | IAAS         | application/json | 501-7250688  |
      | 0008 | SG     | Life | SG_LIFE_IAAS02   | SG_LIFE_IAAS02   |     | RLS          | IAAS         | application/json | 501-7318881  |

  @HK
    Examples:
      | TCNo | entity | lob  | msgId           | initialMsgId    | env | targetSystem | sourceSystem | accept           | policyNumber |
      | 0001 | HK     | Life | HK_LIFE_SCRM_01 | HK_LIFE_SCRM_01 |     | RLS          | SCRM         | application/json | 300-1023294  |
      | 0002 | HK     | Life | HK_LIFE_SCRM_02 | HK_LIFE_SCRM_02 |     | RLS          | SCRM         | application/json | 300-1018781  |

  @PH
    Examples:
      | TCNo | entity | lob  | msgId            | initialMsgId     | env | targetSystem | sourceSystem | accept           | policyNumber |
      | 0001 | PH     | Life | PH_LIFE_SCRM_01  | PH_LIFE_SCRM_01  |     | RLS          | SCRM         | application/json | 310-0166200  |
      | 0002 | PH     | Life | PH_LIFE_SCRM_02  | PH_LIFE_SCRM_02  |     | RLS          | SCRM         | application/json | 301-1023714  |
      | 0003 | PH     | Life | PH_LIFE_EFUSE_01 | PH_LIFE_EFUSE_01 |     | RLS          | EFUSE        | application/json | 303-2355269  |
      | 0004 | PH     | Life | PH_LIFE_EFUSE_02 | PH_LIFE_EFUSE_02 |     | RLS          | EFUSE        | application/json | 304-1047683  |

  @TH
    Examples:
      | TCNo | entity | lob  | msgId           | initialMsgId    | env | targetSystem | sourceSystem | accept           | policyNumber |
      | 0001 | TH     | Life | TH_LIFE_SCRM_01 | TH_LIFE_SCRM_01 |     | RLS          | SCRM         | application/json | 502-2916521  |
      | 0002 | TH     | Life | TH_LIFE_SCRM_02 | TH_LIFE_SCRM_02 |     | RLS          | SCRM         | application/json | 502-2927262  |

