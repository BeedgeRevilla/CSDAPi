Feature: REGIONAL Retrieve Policy List
  Records retrieved will depend on the parameters set on the GET request.

  @HK
  Scenario Outline: Retrieve Policy List - <msgId> - Successful retrieval of records

    Given the following http headers are set Retrieve Policy List
      | X-Axa-Entity | X-Axa-LOB | X-Axa-MsgId | X-Axa-InitialMsgId | X-Axa-Env | X-Axa-ContextHeader-CustomData-TargetSystem | X-Axa-ContextHeader-CustomData-SourceSystem | Accept   |
      | <entity>     | <lob>     | <msgId>     | <initialMsgId>     | <env>     | <targetSystem>                              | <sourceSystem>                              | <accept> |

    And the following GET input parameters are set for Retrieve Policy List
      | idDocumentNumber   | masterIndividualPartyId   |
      | <idDocumentNumber> | <masterIndividualPartyId> |

    When the api call has been made for Retrieve Policy List

    When the Stored Procedure is called for Retrieve Policy List

    Then verify that API and DB responses matched for Retrieve Policy List

    Examples:
      | entity | lob    | msgId              | initialMsgId       | env | targetSystem | sourceSystem | accept           | idDocumentNumber   | masterIndividualPartyId |
      | HK     | Life   | HK_LIFE_SCRM_01    | HK_LIFE_SCRM_01    |     | COREDB       | SCRM         | application/json | 308683945389891785 |                         |
      | HK     | Life   | HK_LIFE_SCRM_02    | HK_LIFE_SCRM_02    |     | COREDB       | SCRM         | application/json | 21898094629991159B |                         |
      | HK     | Life   | HK_LIFE_HCT_01     | HK_LIFE_HCT_01     |     | COREDB       | HCT          | application/json | 228280946982851    |                         |
      | HK     | Life   | HK_LIFE_HCT_02     | HK_LIFE_HCT_02     |     | COREDB       | HCT          | application/json | I307989            |                         |
      | HK     | GI     | HK_GI_SCRM_01      | HK_GI_SCRM_01      |     | COREDB       | SCRM         | application/json | T442711(Q)         |                         |
      | HK     | GI     | HK_GI_SCRM_02      | HK_GI_SCRM_02      |     | COREDB       | SCRM         | application/json | 83567600           |                         |
      | HK     | Health | HK_Health_MYAXA_01 | HK_Health_MYAXA_01 |     | COREDB       | MYAXA        | application/json | 9869621            |                         |

  @SG
  Scenario Outline: Retrieve Policy List - <msgId> - Successful retrieval of records

    Given the following http headers are set Retrieve Policy List
      | X-Axa-Entity | X-Axa-LOB | X-Axa-MsgId | X-Axa-InitialMsgId | X-Axa-Env | X-Axa-ContextHeader-CustomData-TargetSystem | X-Axa-ContextHeader-CustomData-SourceSystem | Accept   |
      | <entity>     | <lob>     | <msgId>     | <initialMsgId>     | <env>     | <targetSystem>                              | <sourceSystem>                              | <accept> |

    And the following GET input parameters are set for Retrieve Policy List
      | idDocumentNumber   | masterIndividualPartyId   |
      | <idDocumentNumber> | <masterIndividualPartyId> |

    When the api call has been made for Retrieve Policy List

    When the Stored Procedure is called for Retrieve Policy List

    Then verify that API and DB responses matched for Retrieve Policy List

    Examples:
      | entity | lob | msgId       | initialMsgId | env | targetSystem | sourceSystem | accept           | idDocumentNumber | masterIndividualPartyId |
      | SG     |     | SG_SCRM_01  | SG_SCRM_01   |     | COREDB       | SCRM         | application/json | 088383396T       |                         |
      | SG     |     | SG_SCRM_02  | SG_SCRM_02   |     | COREDB       | SCRM         | application/json | L0148834O        |                         |
      | SG     |     | SG_SCRM_03  | SG_SCRM_03   |     | COREDB       | SCRM         | application/json |                  | 7924800                 |
      | SG     |     | SG_SCRM_04  | SG_SCRM_04   |     | COREDB       | SCRM         | application/json | L6199039Y        |                         |
      | SG     |     | SG_SCRM_05  | SG_SCRM_05   |     | COREDB       | SCRM         | application/json |                  | 8330601                 |
      | SG     |     | SG_SCRM_06  | SG_SCRM_06   |     | COREDB       | SCRM         | application/json | 374007717        |                         |
      | SG     |     | SG_SCRM_07  | SG_SCRM_07   |     | COREDB       | SCRM         | application/json |                  | 7282969                 |
      | SG     |     | SG_MYAXA_01 | SG_MYAXA_01  |     | COREDB       | MYAXA        | application/json | 088383396T       |                         |
      | SG     |     | SG_MYAXA_02 | SG_MYAXA_02  |     | COREDB       | MYAXA        | application/json | L0148834O        |                         |
      | SG     |     | SG_IAAS_01  | SG_IAAS_01   |     | COREDB       | IAAS         | application/json | 088383396T       |                         |
      | SG     |     | SG_IAAS_02  | SG_IAAS_02   |     | COREDB       | IAAS         | application/json | L0148834O        |                         |

  @TH
  Scenario Outline: Retrieve Policy List - <msgId> - Successful retrieval of records

    Given the following http headers are set Retrieve Policy List
      | X-Axa-Entity | X-Axa-LOB | X-Axa-MsgId | X-Axa-InitialMsgId | X-Axa-Env | X-Axa-ContextHeader-CustomData-TargetSystem | X-Axa-ContextHeader-CustomData-SourceSystem | Accept   |
      | <entity>     | <lob>     | <msgId>     | <initialMsgId>     | <env>     | <targetSystem>                              | <sourceSystem>                              | <accept> |

    And the following GET input parameters are set for Retrieve Policy List
      | idDocumentNumber   | masterIndividualPartyId   | LOBTypeCode   |
      | <idDocumentNumber> | <masterIndividualPartyId> | <LOBTypeCode> |

    When the api call has been made for Retrieve Policy List

    When the Stored Procedure is called for Retrieve Policy List

    Then verify that API and DB responses matched for Retrieve Policy List

    Examples:
      | entity | lob  | msgId      | initialMsgId | env | targetSystem | sourceSystem | accept           | idDocumentNumber | masterIndividualPartyId | LOBTypeCode |
      | TH     | Life | TH_SCRM_01 | TH_SCRM_01   |     | COREDB       | SCRM         | application/json | 2489988804534    |                         | Life        |
      | TH     | Life | TH_SCRM_02 | TH_SCRM_02   |     | COREDB       | SCRM         | application/json | 2988489006278    |                         | Life        |

