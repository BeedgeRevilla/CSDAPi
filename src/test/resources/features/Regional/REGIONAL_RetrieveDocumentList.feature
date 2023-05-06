Feature: REGIONAL Retrieve Document List
  Records retrieved will depend on the parameters set on the GET request.


    Scenario Outline: Retrieve Document List <entity>_<lob>_<sourceSystem>_<msgId> - Successful retrieval of records

    Given the following http headers are set Retrieve Document List
      | X-Axa-Entity | X-Axa-LOB | X-Axa-MsgId | X-Axa-InitialMsgId | X-Axa-Env | X-Axa-ContextHeader-CustomData-TargetSystem | X-Axa-ContextHeader-CustomData-SourceSystem | Accept   |
      | <entity>     | <lob>     | <msgId>     | <initialMsgId>     | <env>     | <targetSystem>                              | <sourceSystem>                              | <accept> |

    And the following GET input parameters are set for Retrieve Document List
      | policyNumber   | claimNumber   | documentClass   |
      | <policyNumber> | <claimNumber> | <documentClass> |

    When the api call has been made for Retrieve Document List

    Then the call to FILENET has been made for Retrieve Document List

    Then verify that API and FILENET responses matched for Retrieve Document List

    @HK
    Examples:
      | entity | lob  | msgId       | initialMsgId | env | targetSystem | sourceSystem | accept           | policyNumber | claimNumber | documentClass |
      | HK     | Life | HK_NBU_01   | HK_NBU_01    |     | Filenet      | SCRM         | application/json | 510-8574657  |             | NewBusiness   |
      | HK     | Life | HK_NBU_02   | HK_NBU_02    |     | Filenet      | SCRM         | application/json | 510-8575290  |             | NewBusiness   |
      | HK     | Life | HK_POS_01   | HK_POS_01    |     | Filenet      | SCRM         | application/json | 510-8555854  |             | Policy        |
      | HK     | Life | HK_POS_02   | HK_POS_02    |     | Filenet      | SCRM         | application/json | 504-8268188  |             | Policy        |
      | HK     | Life | HK_CLAIM_01 | HK_CLAIM_01  |     | Filenet      | SCRM         | application/json |              | PA000899    | Claim         |
      | HK     | Life | HK_CLAIM_02 | HK_CLAIM_02  |     | Filenet      | SCRM         | application/json |              | PA001459    | Claim         |

#      | HK     | GI | HK_GI_0001 | HK_GI_0001  |     | Filenet      | SCRM         | application/json | HF120005      | PA001100    | All         |

	@MY
    Examples:
      | entity | lob  | msgId       | initialMsgId | env | targetSystem | sourceSystem | accept           | policyNumber | claimNumber | documentClass |
      | MY     | Life | MY_CLAIM_01 | MY_CLAIM_01  |     | Filenet      | SCRM         | application/json | 600-0000005  | 1001569     | Claim         |
      | MY     | Life | MY_NBU_01   | MY_NBU_01    |     | Filenet      | SCRM         | application/json | 502-1945828  |             | NewBusiness   |
      | MY     | Life | MY_POS_01   | MY_POS_01    |     | Filenet      | SCRM         | application/json | 601-7654321  |             | Policy        |
    
    @PH
    Examples:
      | entity | lob  | msgId       | initialMsgId | env | targetSystem | sourceSystem | accept           | policyNumber | claimNumber | documentClass |
      | PH     | Life | PH_NBU_01   | PH_NBU_01    |     | Filenet      | MYAXA        | application/json | 515-0000018  |             | NewBusiness   |
      | PH     | Life | PH_POS_01   | PH_POS_01    |     | Filenet      | MYAXA        | application/json | 510-4140552  |             | Policy        |

	@SG
    Examples:
      | entity | lob  | msgId       | initialMsgId | env | targetSystem | sourceSystem | accept           | policyNumber | claimNumber | documentClass |
      | SG     | Life | SG_CLAIM_01 | SG_CLAIM_01  |     | Filenet      | SCRM         | application/json | 588-0224067  | PA001386    | HClaimExt     |
      | SG     | Life | SG_CLAIM_02 | SG_CLAIM_02  |     | Filenet      | SCRM         | application/json | 588-0224023  | PA001377    | HClaimInt     |
      | SG     | Life | SG_NBU_01   | SG_NBU_01    |     | Filenet      | SCRM         | application/json | 103-2529149  |             | NewBusiness   |
      | SG     | Life | SG_NBU_02   | SG_NBU_02    |     | Filenet      | SCRM         | application/json | 102-7719549  |             | NewBusiness   |
      | SG     | Life | SG_POS_01   | SG_POS_01    |     | Filenet      | SCRM         | application/json | 501-4601909  |             | Policy        |
      
	@TH
    Examples:
      | entity | lob  | msgId       | initialMsgId | env | targetSystem | sourceSystem | accept           | policyNumber | claimNumber | documentClass |
      | TH     | Life | TH_NBU_01   | TH_NBU_01    |     | Filenet      | SCRM         | application/json | 502-5882712  |             | NewBusiness   |
      | TH     | Life | TH_POS_01   | TH_POS_01    |     | Filenet      | SCRM         | application/json | 501-1231240  |             | Policy        |
	