Feature: REGIONAL Retrieve Customer (joshua.celestial.ext)
  Records retrieved will depend on the parameters set on the GET request.

  Scenario Outline: <entity> Retrieve Customer List - <msgId> - Successful retrieval of records

    Given the following http headers are set Retrieve Customer List
      | X-Axa-Entity | X-Axa-LOB | X-Axa-MsgId | X-Axa-InitialMsgId | X-Axa-Env | X-Axa-ContextHeader-CustomData-TargetSystem | X-Axa-ContextHeader-CustomData-SourceSystem | Accept   |
      | <entity>     | <lob>     | <msgId>     | <initialMsgId>     | <env>     | <targetSystem>                              | <sourceSystem>                              | <accept> |

    And the following GET input parameters are set for Retrieve Customer List
      | idDocumentTypeCode   | idDocumentNumber   | order   |
      | <idDocumentTypeCode> | <idDocumentNumber> | <order> |

    When the api call has been made for Retrieve Customer List

    When the Stored Procedure is called for Retrieve Customer List

    Then verify that API and DB responses matched for Retrieve Customer List

  @HK
    Examples:
      | entity | lob | msgId           | initialMsgId    | env  | targetSystem | sourceSystem | accept           | idDocumentTypeCode | idDocumentNumber | order |
      | HK     |     | HK_SCRM_LIFE_01 | HK_SCRM_LIFE_01 | NFT1 | COREDB       | SCRM         | application/json | SECURITYNO         | N005236          | DESC  |
      | HK     |     | HK_SCRM_LIFE_02 | HK_SCRM_LIFE_02 | NFT1 | COREDB       | SCRM         | application/json | SECURITYNO         | R156233(5)(5)(5) | DESC  |
      | HK     |     | HK_SCRM_PSEA_01 | HK_SCRM_PSEA_01 | NFT1 | COREDB       | SCRM         | application/json | SECURITYNO         | A879363(0)       | DESC  |
      | HK     |     | HK_SCRM_PSEA_02 | HK_SCRM_PSEA_02 | NFT1 | COREDB       | SCRM         | application/json | SECURITYNO         | U221843(4)       | DESC  |
      | HK     |     | HK_NBPT_LIFE_01 | HK_NBPT_LIFE_01 | NFT1 | COREDB       | NBPT         | application/json | SECURITYNO         | 005236           | DESC  |
      | HK     |     | HK_NBPT_LIFE_02 | HK_NBPT_LIFE_02 | NFT1 | COREDB       | NBPT         | application/json | SECURITYNO         | P338200563       | DESC  |
      | HK     |     | HK_SCRM_PSEA_01 | HK_SCRM_PSEA_01 | NFT1 | COREDB       | SCRM         | application/json | SECURITYNO         | 79363(0)         | DESC  |
      | HK     |     | HK_SCRM_PSEA_02 | HK_SCRM_PSEA_02 | NFT1 | COREDB       | SCRM         | application/json | SECURITYNO         | I398629(7)       | DESC  |

  @MY
    Examples:
      | entity | lob | msgId      | initialMsgId | env  | targetSystem | sourceSystem | accept           | idDocumentTypeCode | idDocumentNumber | order |
      | MY     |     | MY_SCRM_01 | MY_SCRM_01   | NFT1 | COREDB       | SCRM         | application/json | SECURITYNO         | 89879661-3388    | DESC  |
      | MY     |     | MY_SCRM_02 | MY_SCRM_02   | NFT1 | COREDB       | SCRM         | application/json | SECURITYNO         | 758397-85-1002   | DESC  |

  @PH
    Examples:
      | entity | lob | msgId       | initialMsgId | env  | targetSystem | sourceSystem | accept           | idDocumentTypeCode | idDocumentNumber  | order |
      | PH     |     | PH_SCRM_01  | PH_SCRM_01   | NFT1 | COREDB       | SCRM         | application/json | SECURITYNO         | RJP43695605R558() | DESC  |
      | PH     |     | PH_SCRM_02  | PH_SCRM_02   | NFT1 | COREDB       | SCRM         | application/json | SECURITYNO         | HZI43155442R554() | DESC  |
      | PH     |     | PH_EFUSE_01 | PH_EFUSE_01  | NFT1 | COREDB       | EFUSE        | application/json | SECURITYNO         | TXT43765752N554() | DESC  |
      | PH     |     | PH_EFUSE_02 | PH_EFUSE_02  | NFT1 | COREDB       | EFUSE        | application/json | SECURITYNO         | ZKB43675344N554() | DESC  |

  @SG
    Examples:
      | entity | lob  | msgId             | initialMsgId      | env  | targetSystem | sourceSystem | accept           | idDocumentTypeCode | idDocumentNumber | order |
      | SG     |      | SG_SCRM_01        | SG_SCRM_01        | NFT1 | COREDB       | SCRM         | application/json | SECURITYNO         | L0955740P        | DESC  |
      | SG     |      | SG_SCRM_02        | SG_SCRM_02        | NFT1 | COREDB       | SCRM         | application/json | SECURITYNO         | 709998-98-126    | DESC  |
      | SG     | Life | SG_SCRM_LIFE_01   | SG_SCRM_LIFE_01   | NFT1 | COREDB       | SCRM         | application/json | SECURITYNO         | 844866387        | DESC  |
      | SG     | Life | SG_SCRM_LIFE_02   | SG_SCRM_LIFE_02   | NFT1 | COREDB       | SCRM         | application/json | SECURITYNO         | 298993945490987  | DESC  |
      | SG     |      | SG_SCRM_HEALTH_01 | SG_SCRM_HEALTH_01 | NFT1 | COREDB       | SCRM         | application/json | SECURITYNO         | 872810821        | DESC  |
      | SG     |      | SG_SCRM_HEALTH_02 | SG_SCRM_HEALTH_02 | NFT1 | COREDB       | SCRM         | application/json | SECURITYNO         | 944685717K       | DESC  |
      | SG     |      | SG_MYAXA_01       | SG_MYAXA_01       | NFT1 | COREDB       | MYAXA        | application/json | SECURITYNO         | 27875953         | DESC  |
      | SG     |      | SG_MYAXA_02       | SG_MYAXA_02       | NFT1 | COREDB       | MYAXA        | application/json | SECURITYNO         | 380123463        | DESC  |
      | SG     |      | SG_IAAS_01        | SG_IAAS_01        | NFT1 | COREDB       | IAAS         | application/json | SECURITYNO         | U04393301        | DESC  |
      | SG     |      | SG_IAAS_02        | SG_IAAS_02        | NFT1 | COREDB       | IAAS         | application/json | SECURITYNO         | Q91392140        | DESC  |

  @TH
    Examples:
      | entity | lob  | msgId      | initialMsgId | env  | targetSystem | sourceSystem | accept           | idDocumentTypeCode | idDocumentNumber | order |
      | TH     | Life | TH_SCRM_01 | TH_SCRM_01   | NFT1 | COREDB       | SCRM         | application/json | SECURITYNO         | 2284489786699    | DESC  |
      | TH     | Life | TH_SCRM_02 | TH_SCRM_01   | NFT1 | COREDB       | SCRM         | application/json | SECURITYNO         | 1234567891291    | DESC  |
      