Feature: REGIONAL Retrieve Claim List
  Records retrieved will depend on the parameters set on the GET request.

  Scenario Outline: [<entity>] Retrieve Claim List - <msgId> - Successful retrieval of records

    Given the following http headers are set Retrieve Claim List
      | X-Axa-Entity | X-Axa-LOB | X-Axa-MsgId | X-Axa-InitialMsgId | X-Axa-Env | X-Axa-ContextHeader-CustomData-TargetSystem | X-Axa-ContextHeader-CustomData-SourceSystem | Accept   |
      | <entity>     | <lob>     | <msgId>     | <initialMsgId>     | <env>     | <targetSystem>                              | <sourceSystem>                              | <accept> |

    And the following GET input parameters are set for Retrieve Claim List
      | nationalId   | policyNumber   |
      | <nationalId> | <policyNumber> |

    When the api call has been made for Retrieve Claim List

    When the Stored Procedure is called for Retrieve Claim List

    Then verify that API and DB responses matched for Retrieve Claim List

  @HK
    Examples:
      | entity | lob  | msgId           | initialMsgId    | env | targetSystem | sourceSystem | accept           | policyNumber | nationalId |
      | HK     | Life | HK_SCRM_LIFE_01 | HK_SCRM_LIFE_01 |     | COREDB       | SCRM         | application/json | A2395153-01  |            |
      | HK     | Life | HK_SCRM_LIFE_02 | HK_SCRM_LIFE_02 |     | COREDB       | SCRM         | application/json | 302-5493028  |            |
      | HK     | Life | HK_HCT_LIFE_01  | HK_HCT_LIFE_01  |     | COREDB       | HCT          | application/json | A2395153-01  |            |
      | HK     | Life | HK_HCT_LIFE_02  | HK_HCT_LIFE_02  |     | COREDB       | HCT          | application/json | 302-5493028  |            |
      | HK     | Life | HK_NBPT_LIFE_01 | HK_NBPT_LIFE_01 |     | COREDB       | NBPT         | application/json | A2395153-01  |            |
      | HK     | Life | HK_NBPT_LIFE_02 | HK_NBPT_LIFE_02 |     | COREDB       | NBPT         | application/json | 302-5493028  |            |
      | HK     | GI   | HK_SCRM_P&C_01  | HK_SCRM_P&C_01  |     | COREDB       | SCRM         | application/json | 05000138     |            |
      | HK     | GI   | HK_SCRM_P&C_02  | HK_SCRM_P&C_02  |     | COREDB       | SCRM         | application/json | 11001250     |            |
      | HK     | GI   | HK_MYAXA_P&C_01 | HK_MYAXA_P&C_01 |     | COREDB       | MYAXA        | application/json | 05000138     |            |
      | HK     | GI   | HK_MYAXA_P&C_02 | HK_MYAXA_P&C_02 |     | COREDB       | MYAXA        | application/json | 11001250     |            |
      | HK     | Health | HK_SCRM_HEALTH_01 | HK_SCRM_HEALTH_01 |     | COREDB       | MYAXA        | application/json | Z0043481     |            |
      | HK     | Health | HK_SCRM_HEALTH_02 | HK_SCRM_HEALTH_02 |     | COREDB       | MYAXA        | application/json | Z0043480     |            |
      
#  @MY
#    Examples:
#      | entity | lob | msgId      | initialMsgId | env | targetSystem | sourceSystem | accept           | policyNumber | nationalId |
#      | MY     |     | MY_SCRM_01 | MY_SCRM_01   |     | COREDB       | SCRM         | application/json | UB066737     |            |

#  @PH
#    Examples:
#      | entity | lob | msgId      | initialMsgId | env | targetSystem | sourceSystem | accept           | policyNumber | nationalId |
#      | PH     |     | PH_SCRM_01 | PH_SCRM_01   |     | COREDB       | SCRM         | application/json | 304-2143812  |            |


  @SG
    Examples:
      | entity | lob    | msgId                    | initialMsgId             | env | targetSystem | sourceSystem | accept           | policyNumber | nationalId |
      | SG     | Health | SG_G400_SCRM_HEALTH_01   | SG_G400_SCRM_HEALTH_01   |     | COREDB       | SCRM         | application/json | Q0008955     |            |
      | SG     | Health | SG_G400_SCRM_HEALTH_02   | SG_G400_SCRM_HEALTH_02   |     | COREDB       | SCRM         | application/json |              | E3F0BIH3A  |
      | SG     | Health | SG_GASIA_SCRM_HEALTH_01  | SG_GASIA_SCRM_HEALTH_01  |     | COREDB       | SCRM         | application/json | 80021802     |            |
      | SG     | Health | SG_GASIA_SCRM_HEALTH_02  | SG_GASIA_SCRM_HEALTH_02  |     | COREDB       | SCRM         | application/json |              | Z8397223W  |
      | SG     | Health | SG_PSEA_SCRM_GI_01       | SG_PSEA_SCRM_GI_01       |     | COREDB       | SCRM         | application/json | 01260002     |            |
      | SG     | GI     | SG_PSEA_SCRM_GI_02       | SG_PSEA_SCRM_GI_02       |     | COREDB       | SCRM         | application/json | 05810001     |            |
      | SG     | Life   | SG_RLS_SCRM_LIFE_01      | SG_RLS_SCRM_LIFE_01      |     | COREDB       | SCRM         | application/json | 00140614     |            |
      | SG     | Life   | SG_RLS_SCRM_LIFE_02      | SG_RLS_SCRM_LIFE_02      |     | COREDB       | SCRM         | application/json | 00140945     |            |
      | SG     | Health | SG_G400_MYAXA_HEALTH_01  | SG_G400_MYAXA_HEALTH_01  |     | COREDB       | MYAXA        | application/json | Q0008955     |            |
      | SG     | Health | SG_G400_MYAXA_HEALTH_02  | SG_G400_MYAXA_HEALTH_02  |     | COREDB       | MYAXA        | application/json |              | E3F0BIH3A  |
      | SG     | Health | SG_GASIA_MYAXA_HEALTH_01 | SG_GASIA_MYAXA_HEALTH_01 |     | COREDB       | MYAXA        | application/json | 80021802     |            |
      | SG     | Health | SG_GASIA_MYAXA_HEALTH_02 | SG_GASIA_MYAXA_HEALTH_02 |     | COREDB       | MYAXA        | application/json |              | Z8397223W  |
      | SG     | GI     | SG_PSEA_MYAXA_GI_01      | SG_PSEA_MYAXA_GI_01      |     | COREDB       | MYAXA        | application/json | 01260002     |            |
      | SG     | GI     | SG_PSEA_MYAXA_GI_02      | SG_PSEA_MYAXA_GI_02      |     | COREDB       | MYAXA        | application/json | 05810001     |            |
      | SG     | Life   | SG_RLS_MYAXA_LIFE_01     | SG_RLS_MYAXA_LIFE_01     |     | COREDB       | MYAXA        | application/json | 00140614     |            |
      | SG     | Life   | SG_RLS_MYAXA_LIFE_02     | SG_RLS_MYAXA_LIFE_02     |     | COREDB       | MYAXA        | application/json | 00140945     |            |
      | SG     | Health | SG_G400_IAAS_HEALTH_01   | SG_G400_IAAS_HEALTH_01   |     | COREDB       | IAAS         | application/json | Q0008955     |            |
      | SG     | Health | SG_G400_IAAS_HEALTH_02   | SG_G400_IAAS_HEALTH_02   |     | COREDB       | IAAS         | application/json |              | E3F0BIH3A  |
      | SG     | Health | SG_GASIA_IAAS_HEALTH_01  | SG_GASIA_IAAS_HEALTH_01  |     | COREDB       | IAAS         | application/json | 80021802     |            |
      | SG     | Health | SG_GASIA_IAAS_HEALTH_02  | SG_GASIA_IAAS_HEALTH_02  |     | COREDB       | IAAS         | application/json |              | Z8397223W  |
      | SG     | GI     | SG_PSEA_IAAS_GI_01       | SG_PSEA_IAAS_GI_01       |     | COREDB       | IAAS         | application/json | 01260002     |            |
      | SG     | GI     | SG_PSEA_IAAS_GI_02       | SG_PSEA_IAAS_GI_02       |     | COREDB       | IAAS         | application/json | 05810001     |            |
      | SG     | Life   | SG_RLS_IAAS_LIFE_01      | SG_RLS_IAAS_LIFE_01      |     | COREDB       | IAAS         | application/json | 00140614     |            |
      | SG     | Life   | SG_RLS_IAAS_LIFE_02      | SG_RLS_IAAS_LIFE_02      |     | COREDB       | IAAS         | application/json | 00140945     |            |

      | SG     | Life   | SG_RLS_SCRM_LIFE_03      | SG_RLS_SCRM_LIFE_03      |     | COREDB       | SCRM         | application/json | 60001886     |            |
      | SG     | Life   | SG_RLS_SCRM_LIFE_04      | SG_RLS_SCRM_LIFE_04      |     | COREDB       | SCRM         | application/json | 60001901     |            |
      | SG     | Life   | SG_RLS_SCRM_LIFE_05      | SG_RLS_SCRM_LIFE_05      |     | COREDB       | SCRM         | application/json | 60002837     |            |
      | SG     | Life   | SG_RLS_SCRM_LIFE_06      | SG_RLS_SCRM_LIFE_06      |     | COREDB       | SCRM         | application/json | 60003154     |            |
      | SG     | Life   | SG_RLS_SCRM_LIFE_07      | SG_RLS_SCRM_LIFE_07      |     | COREDB       | SCRM         | application/json | 60003216     |            |
      | SG     | Life   | SG_RLS_SCRM_LIFE_08      | SG_RLS_SCRM_LIFE_08      |     | COREDB       | SCRM         | application/json | 60004938     |            |

      | SG     | Life   | SG_RLS_MYAXA_LIFE_03     | SG_RLS_MYAXA_LIFE_03     |     | COREDB       | MYAXA        | application/json | 60001886     |            |
      | SG     | Life   | SG_RLS_MYAXA_LIFE_04     | SG_RLS_MYAXA_LIFE_04     |     | COREDB       | MYAXA        | application/json | 60001901     |            |
      | SG     | Life   | SG_RLS_MYAXA_LIFE_05     | SG_RLS_MYAXA_LIFE_05     |     | COREDB       | MYAXA        | application/json | 60002837     |            |
      | SG     | Life   | SG_RLS_MYAXA_LIFE_06     | SG_RLS_MYAXA_LIFE_06     |     | COREDB       | MYAXA        | application/json | 60003154     |            |
      | SG     | Life   | SG_RLS_MYAXA_LIFE_07     | SG_RLS_MYAXA_LIFE_07     |     | COREDB       | MYAXA        | application/json | 60003216     |            |
      | SG     | Life   | SG_RLS_MYAXA_LIFE_08     | SG_RLS_MYAXA_LIFE_08     |     | COREDB       | MYAXA        | application/json | 60004938     |            |

      | SG     | Life   | SG_RLS_IAAS_LIFE_03      | SG_RLS_IAAS_LIFE_03      |     | COREDB       | IAAS         | application/json | 60001886     |            |
      | SG     | Life   | SG_RLS_IAAS_LIFE_04      | SG_RLS_IAAS_LIFE_04      |     | COREDB       | IAAS         | application/json | 60001901     |            |
      | SG     | Life   | SG_RLS_IAAS_LIFE_05      | SG_RLS_IAAS_LIFE_05      |     | COREDB       | IAAS         | application/json | 60002837     |            |
      | SG     | Life   | SG_RLS_IAAS_LIFE_06      | SG_RLS_IAAS_LIFE_06      |     | COREDB       | IAAS         | application/json | 60003154     |            |
      | SG     | Life   | SG_RLS_IAAS_LIFE_07      | SG_RLS_IAAS_LIFE_07      |     | COREDB       | IAAS         | application/json | 60003216     |            |
      | SG     | Life   | SG_RLS_IAAS_LIFE_08      | SG_RLS_IAAS_LIFE_08      |     | COREDB       | IAAS         | application/json | 60004938     |            |

  @TH
  Scenario Outline: [<entity>] Retrieve Claim List - <msgId> - Successful retrieval of records

    Given the following http headers are set Retrieve Claim List
      | X-Axa-Entity | X-Axa-LOB | X-Axa-MsgId | X-Axa-InitialMsgId | X-Axa-Env | X-Axa-ContextHeader-CustomData-TargetSystem | X-Axa-ContextHeader-CustomData-SourceSystem | Accept   |
      | <entity>     | <lob>     | <msgId>     | <initialMsgId>     | <env>     | <targetSystem>                              | <sourceSystem>                              | <accept> |

    And the following GET input parameters are set for Retrieve Claim List
      | nationalId   | policyNumber   | LOBTypeCode   |
      | <nationalId> | <policyNumber> | <LOBTypeCode> |

    When the api call has been made for Retrieve Claim List

    When the Stored Procedure is called for Retrieve Claim List

    Then verify that API and DB responses matched for Retrieve Claim List

    Examples:
      | entity | lob | msgId           | initialMsgId    | env | targetSystem | sourceSystem | accept           | policyNumber | nationalId | LOBTypeCode |
      | TH     |     | TH_SCRM_LIFE_01 | TH_SCRM_LIFE_01 |     | COREDB       | SCRM         | application/json | 502-9083044  |            | Life        |
      | TH     |     | TH_SCRM_LIFE_02 | TH_SCRM_LIFE_02 |     | COREDB       | SCRM         | application/json | 502-9050530  |            | Life        |
