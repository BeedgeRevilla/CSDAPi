Feature: REGIONAL Retrieve Document Details
  Records retrieved will depend on the parameters set on the GET request.


  Scenario Outline: Retrieve Document Details <entity>_<lob>_<sourceSystem>_<msgId> - Successful retrieval of records

    Given the following http headers are set Retrieve Document Details
      | X-Axa-Entity | X-Axa-LOB | X-Axa-MsgId | X-Axa-InitialMsgId | X-Axa-Env | X-Axa-ContextHeader-CustomData-TargetSystem | X-Axa-ContextHeader-CustomData-SourceSystem | Accept   |
      | <entity>     | <lob>     | <msgId>     | <initialMsgId>     | <env>     | <targetSystem>                              | <sourceSystem>                              | <accept> |

    And the following GET input parameters are set for Retrieve Document Details
      | policyNumber   | documentClass   | documentID   |
      | <policyNumber> | <documentClass> | <documentID> |

    When the call to the API Retrieve Document Details is made

  @HK
    Examples:
      | entity | lob  | msgId     | initialMsgId | env  | targetSystem | sourceSystem | accept           | policyNumber | documentID                           | documentClass |
      | HK     | Life | 0001      | 0001         | PPE1 | FILENET      | MYAXA        | application/json | 303-4516132  | D0990000-9485-48E1-B2E9-B548CF9B3573 | All           |
      | HK     | Life | 0002      | 0002         | PPE1 | FILENET      | MYAXA        | application/json | 302-8135626  | C3790000-24BB-44B5-99E8-795B20DEB4B4 | All           |
      | HK     | Life | 0003      | 0003         | PPE1 | FILENET      | SCRM         | application/json | 303-4516132  | D0990000-9485-48E1-B2E9-B548CF9B3573 | All           |
      | HK     | Life | 0004      | 0004         | PPE1 | FILENET      | SCRM         | application/json | 302-8135626  | C3790000-24BB-44B5-99E8-795B20DEB4B4 | All           |

      | HK     | Life | HK_NBU_05 | HK_NBU_05    | PPE1 | FILENET      | MYAXA        | application/json |              | 06C45C00-0ADD-42F2-BE5F-45B39F01D940 | All           |

#      | HK     | GI  | HK_NBU_03 | HK_NBU_03    | PPE1 | FILENET      | SCRM         | application/json | HF120005             | 11E2F329-5518-47A2-AAE7-70F43BE0CD12   | All           |

#  @TH
#    Examples:
#      | entity | lob  | msgId | initialMsgId | env  | targetSystem | sourceSystem | accept           | policyNumber | documentID                           | documentClass |
#      | TH     | Life | 0001  | 0001         | PPE1 | FILENET      | SCRM         | application/json | 504-9229502  | 19650500-8835-4CE1-8B5F-4C9589EC368B | All           |

  @PH
    Examples:
      | entity | lob  | msgId | initialMsgId | env  | targetSystem | sourceSystem | accept           | policyNumber | documentID                           | documentClass |
      | PH     | Life | 0001  | 0001         | PPE1 | FILENET      | MYAXA        | application/json | 515-0000018  | 2F5E08F0-4C42-4D34-98C7-9969ABC18345 | All           |
      | PH     | Life | 0002  | 0002         | PPE1 | FILENET      | MYAXA        | application/json | 510-4140552  | 24D4944B-8F21-4F02-91A9-03F2BBC652DC | All           |

  @MY
    Examples:
      | entity | lob  | msgId | initialMsgId | env  | targetSystem | sourceSystem | accept           | policyNumber | documentID                           | documentClass |
      | MY     | Life | 0001  | 0001         | PPE1 | FILENET      | SCRM         | application/json |   | 574AAA8E-33A4-4394-BC3A-C198046A36BE | All           |
      | MY     | Life | 0002  | 0002         | PPE1 | FILENET      | SCRM         | application/json |   | 425C42A9-B275-489A-A32C-C2AEAE940D3C | All           |