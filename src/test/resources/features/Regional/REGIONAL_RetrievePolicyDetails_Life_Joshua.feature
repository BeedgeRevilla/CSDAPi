Feature: REGIONAL Retrieve Policy Details Life (joshua.celestial.ext)
  Records retrieved will depend on the parameters set on the GET request.

  Scenario Outline: Retrieve Policy Details Life - <env> - <msgId> - Successful retrieval of records

    Given the following http headers are set Retrieve Policy Details Life
      | X-Axa-Entity | X-Axa-LOB | X-Axa-MsgId | X-Axa-InitialMsgId | X-Axa-Env | X-Axa-ContextHeader-CustomData-TargetSystem | X-Axa-ContextHeader-CustomData-SourceSystem | Accept   |
      | <entity>     | <lob>     | <msgId>     | <initialMsgId>     | <env>     | <targetSystem>                              | <sourceSystem>                              | <accept> |

    And the following GET input parameters are set for Retrieve Policy Details Life
      | policyNumber   |
      | <policyNumber> |

    When the api call has been made for Retrieve Policy Details Life

    When the Stored Procedure is called for Retrieve Policy Details Life

    Then verify that API and DB responses matched for Retrieve Policy Details Life

  @SG
    Examples:
      | entity | lob  | msgId            | initialMsgId     | env | targetSystem | sourceSystem | accept           | policyNumber |
      #| SG     | Life | SG_LIFE_SCRM_01  | SG_LIFE_SCRM_01  |     | RLS          | SCRM         | application/json | 502-4733767  |
      #| SG     | Life | SG_LIFE_SCRM_02  | SG_LIFE_SCRM_02  |     | RLS          | SCRM         | application/json | 102-2257545  |
      #| SG     | Life | SG_LIFE_MYAXA_01 | SG_LIFE_MYAXA_01 |     | RLS          | MYAXA        | application/json | 501-5903361  |
      #| SG     | Life | SG_LIFE_MYAXA_02 | SG_LIFE_MYAXA_02 |     | RLS          | MYAXA        | application/json | 102-2258410  |
      #| SG     | Life | SG_LIFE_IAAS_01  | SG_LIFE_IAAS_01  |     | RLS          | IAAS         | application/json | 501-5903239  |
      #| SG     | Life | SG_LIFE_IAAS_02  | SG_LIFE_IAAS_02  |     | RLS          | IAAS         | application/json | 102-2261018  |

      | SG     | Life | SG_LIFE_SCRM_01  | SG_LIFE_SCRM_01  |     | RLS          | SCRM         | application/json | 102-2247116  |
      | SG     | Life | SG_LIFE_SCRM_02  | SG_LIFE_SCRM_02  |     | RLS          | SCRM         | application/json | 102-2127714  |
      | SG     | Life | SG_LIFE_MYAXA_01 | SG_LIFE_MYAXA_01 |     | RLS          | MYAXA        | application/json | 102-2252504  |
      | SG     | Life | SG_LIFE_MYAXA_02 | SG_LIFE_MYAXA_02 |     | RLS          | MYAXA        | application/json | 102-2257750  |
      #| SG     | Life | SG_LIFE_IAAS_01  | SG_LIFE_IAAS_01  |     | RLS          | IAAS         | application/json | 302-5945779  |
      #| SG     | Life | SG_LIFE_IAAS_02  | SG_LIFE_IAAS_02  |     | RLS          | IAAS         | application/json | 102-2261018  |
      | SG     | Life | SG_LIFE_IAAS_01  | SG_LIFE_IAAS_01  |     | RLS          | IAAS         | application/json | 501-9331908  |
      | SG     | Life | SG_LIFE_IAAS_02  | SG_LIFE_IAAS_02  |     | RLS          | IAAS         | application/json | 102-2261018  |

  @TH
    Examples:
      | entity | lob  | msgId           | initialMsgId    | env | targetSystem | sourceSystem | accept           | policyNumber |
      | TH     | Life | TH_LIFE_SCRM_01 | TH_LIFE_SCRM_01 |     | RLS          | SCRM         | application/json | 508-2860064  |
      | TH     | Life | TH_LIFE_SCRM_02 | TH_LIFE_SCRM_02 |     | RLS          | SCRM         | application/json | 508-5685047  |

  @HK
    Examples:
      | entity | lob  | msgId           | initialMsgId    | env | targetSystem | sourceSystem | accept           | policyNumber |
      #| HK     | Life | HK_LIFE_SCRM_01 | HK_LIFE_SCRM_01 |     | RLS          | SCRM         | application/json | 504-8247521  |
      #| HK     | Life | HK_LIFE_SCRM_02 | HK_LIFE_SCRM_02 |     | RLS          | SCRM         | application/json | 502-8540804  |
      #| HK     | Life | HK_LIFE_NBPT_01 | HK_LIFE_NBPT_01 |     | RLS          | NBPT         | application/json | 504-8247521  |
      #| HK     | Life | HK_LIFE_NBPT_02 | HK_LIFE_NBPT_02 |     | RLS          | NBPT         | application/json | 502-8540804  |
      #| HK     | Life | HK_LIFE_HCT_01  | HK_LIFE_HCT_01  |     | RLS          | HCT          | application/json | 503-6393972  |
      #| HK     | Life | HK_LIFE_HCT_02  | HK_LIFE_HCT_02  |     | RLS          | HCT          | application/json | 503-6457504  |

      | HK     | Life | HK_LIFE_SCRM_01 | HK_LIFE_SCRM_01 |     | RLS          | SCRM         | application/json | 502-3973760  |
      | HK     | Life | HK_LIFE_SCRM_02 | HK_LIFE_SCRM_02 |     | RLS          | SCRM         | application/json | 502-8168820  |
      | HK     | Life | HK_LIFE_NBPT_01 | HK_LIFE_NBPT_01 |     | RLS          | NBPT         | application/json | 505-1347523  |
      | HK     | Life | HK_LIFE_NBPT_02 | HK_LIFE_NBPT_02 |     | RLS          | NBPT         | application/json | 503-7561866  |
#      | HK     | Life | HK_LIFE_NBPT_01 | HK_LIFE_NBPT_01 |     | RLS          | NBPT         | application/json | 502-8301678  |
#      | HK     | Life | HK_LIFE_NBPT_02 | HK_LIFE_NBPT_02 |     | RLS          | NBPT         | application/json | 502-4090465  |
      | HK     | Life | HK_LIFE_HCT_01  | HK_LIFE_HCT_01  |     | RLS          | HCT          | application/json | 502-8301678  |
      | HK     | Life | HK_LIFE_HCT_02  | HK_LIFE_HCT_02  |     | RLS          | HCT          | application/json | 502-4090465  |

  @PH
    Examples:
      | entity | lob  | msgId            | initialMsgId     | env | targetSystem | sourceSystem | accept           | policyNumber |
      #| PH     | Life | PH_LIFE_SCRM_01  | PH_LIFE_SCRM_01  |     | RLS          | SCRM         | application/json | 510-0626919  |
      #| PH     | Life | PH_LIFE_SCRM_02  | PH_LIFE_SCRM_02  |     | RLS          | SCRM         | application/json | 310-3115691  |
      #| PH     | Life | PH_LIFE_EFUSE_01 | PH_LIFE_EFUSE_01 |     | RLS          | EFUSE        | application/json | 510-0114015  |
      #| PH     | Life | PH_LIFE_EFUSE_02 | PH_LIFE_EFUSE_02 |     | RLS          | EFUSE        | application/json | 310-5746519  |

#MichelPablo
      | PH     | Life | PH_LIFE_SCRM_01  | PH_LIFE_SCRM_01  |     | RLS          | SCRM         | application/json | 310-5816775  |
      | PH     | Life | PH_LIFE_SCRM_02  | PH_LIFE_SCRM_02  |     | RLS          | SCRM         | application/json | 510-0114098  |
      | PH     | Life | PH_LIFE_EFUSE_01 | PH_LIFE_EFUSE_01 |     | RLS          | EFUSE        | application/json | 301-1001868  |
      | PH     | Life | PH_LIFE_EFUSE_02 | PH_LIFE_EFUSE_02 |     | RLS          | EFUSE        | application/json | 303-1910841  |

#DASI
#      | PH     | Life | PH_LIFE_SCRM_01  | PH_LIFE_SCRM_01  |     | RLS          | SCRM         | application/json | 310-2812645  |
#      | PH     | Life | PH_LIFE_SCRM_02  | PH_LIFE_SCRM_02  |     | RLS          | SCRM         | application/json | 510-0621555  |
#      | PH     | Life | PH_LIFE_EFUSE_01 | PH_LIFE_EFUSE_01 |     | RLS          | EFUSE        | application/json | 303-1008109  |
#      | PH     | Life | PH_LIFE_EFUSE_02 | PH_LIFE_EFUSE_02 |     | RLS          | EFUSE        | application/json | 303-1027042  |


  @HK_QA6
    Examples:
      | entity | lob  | msgId     | initialMsgId | env | targetSystem | sourceSystem | accept           | policyNumber |
      | HK     | Life | HK_QA6_01 | HK_QA6_01    | QA6 | RLS          | SCRM         | application/json | 504-9584260  |
      | HK     | Life | HK_QA6_01 | HK_QA6_01    | QA6 | RLS          | SCRM         | application/json | 303-5109788  |
      | HK     | Life | HK_QA6_01 | HK_QA6_01    | QA6 | RLS          | SCRM         | application/json | 503-8107008  |
      | HK     | Life | HK_QA6_01 | HK_QA6_01    | QA6 | RLS          | SCRM         | application/json | 503-8439898  |
      | HK     | Life | HK_QA6_01 | HK_QA6_01    | QA6 | RLS          | SCRM         | application/json | 303-7321878  |



  Scenario Outline: Retrieve Policy Details Life - <env> - <msgId> - Successful retrieval of records

    Given the following http headers are set Retrieve Policy Details Life
      | X-Axa-Entity | X-Axa-LOB | X-Axa-MsgId | X-Axa-InitialMsgId | X-Axa-Env | X-Axa-ContextHeader-CustomData-TargetSystem | X-Axa-ContextHeader-CustomData-SourceSystem | Accept   |
      | <entity>     | <lob>     | <msgId>     | <initialMsgId>     | <env>     | <targetSystem>                              | <sourceSystem>                              | <accept> |

    And the following GET input parameters are set for Retrieve Policy Details Life
      | policyNumber   | resourceID     | effectiveDate   | policyEffectiveToDate   |
      | <policyNumber> | <policyNumber> | <effectiveDate> | <policyEffectiveToDate> |

    When the api call has been made for Retrieve Policy Details Life

    When the Stored Procedure is called for Retrieve Policy Details Life

    Then verify that API and DB responses matched for Retrieve Policy Details Life

  @TH_SIT
    Examples:
      | entity | lob  | msgId           | initialMsgId    | env | targetSystem | sourceSystem | accept           | policyNumber | effectiveDate | policyEffectiveToDate |
      | TH     | Life | TH_LIFE_SCRM_01 | TH_LIFE_SCRM_01 | SIT | RLS          | SCRM         | application/json | 506-8661437  | 2015-04-17    | 2020-01-01            |
      | TH     | Life | TH_LIFE_SCRM_02 | TH_LIFE_SCRM_02 | SIT | RLS          | SCRM         | application/json | 504-4023843  | 2012-05-10    | 2020-01-01            |
      | TH     | Life | TH_LIFE_SCRM_03 | TH_LIFE_SCRM_03 | SIT | RLS          | SCRM         | application/json | 504-9401275  | 2013-07-08    | 2020-01-01            |
      | TH     | Life | TH_LIFE_SCRM_04 | TH_LIFE_SCRM_04 | SIT | RLS          | SCRM         | application/json | 507-1419690  | 2015-08-14    | 2020-01-01            |
      | TH     | Life | TH_LIFE_SCRM_05 | TH_LIFE_SCRM_05 | SIT | RLS          | SCRM         | application/json | 502-1990931  | 2007-06-28    | 2020-01-01            |
      | TH     | Life | TH_LIFE_SCRM_06 | TH_LIFE_SCRM_06 | SIT | RLS          | SCRM         | application/json | 502-1981732  | 2007-07-01    | 2020-01-01            |
      | TH     | Life | TH_LIFE_SCRM_07 | TH_LIFE_SCRM_07 | SIT | RLS          | SCRM         | application/json | 506-3786130  | 2019-08-05    | 2020-01-01            |
      | TH     | Life | TH_LIFE_SCRM_08 | TH_LIFE_SCRM_08 | SIT | RLS          | SCRM         | application/json | 506-3810393  | 2019-08-20    | 2020-01-01            |

  @SG_PPE3
    Examples:
      | entity | lob  | msgId            | initialMsgId     | env  | targetSystem | sourceSystem | accept           | policyNumber | effectiveDate | policyEffectiveToDate |
      | SG     | Life | SG_LIFE_SCRM_01  | SG_LIFE_SCRM_01  | PPE3 | RLS          | SCRM         | application/json | 502-4733767  | 2019-01-15    | 2020-01-01            |
      | SG     | Life | SG_LIFE_SCRM_02  | SG_LIFE_SCRM_02  | PPE3 | RLS          | SCRM         | application/json | 102-2257545  | 2019-10-10    | 2020-01-01            |
      | SG     | Life | SG_LIFE_MYAXA_01 | SG_LIFE_MYAXA_01 | PPE3 | RLS          | MYAXA        | application/json | 501-5903361  | 2019-11-26    | 2020-01-01            |
      | SG     | Life | SG_LIFE_MYAXA_02 | SG_LIFE_MYAXA_02 | PPE3 | RLS          | MYAXA        | application/json | 102-2258410  | 2019-10-09    | 2020-01-01            |
      | SG     | Life | SG_LIFE_IAAS_01  | SG_LIFE_IAAS_01  | PPE3 | RLS          | IAAS         | application/json | 501-5903239  | 2019-11-25    | 2020-01-01            |
      | SG     | Life | SG_LIFE_IAAS_02  | SG_LIFE_IAAS_02  | PPE3 | RLS          | IAAS         | application/json | 102-2261018  | 2019-10-10    | 2020-01-01            |

      #| SG     | Life | SG_LIFE_SCRM_01  | SG_LIFE_SCRM_01  | PPE3    | RLS          | SCRM         | application/json | 102-2261018  | 2019-10-10   | 2020-01-01			  |
      #| SG     | Life | SG_LIFE_SCRM_02  | SG_LIFE_SCRM_02  | PPE3    | RLS          | SCRM         | application/json | 102-2239105  | 2019-10-09   | 2020-01-01			  |
      #| SG     | Life | SG_LIFE_MYAXA_01 | SG_LIFE_MYAXA_01 | PPE3    | RLS          | MYAXA        | application/json | 501-6075672  | 2020-01-24   | 2020-01-01			  |
      #| SG     | Life | SG_LIFE_MYAXA_02 | SG_LIFE_MYAXA_02 | PPE3    | RLS          | MYAXA        | application/json | 701-7006904  | 2015-07-28   | 2020-01-01			  |
      #| SG     | Life | SG_LIFE_IAAS_01  | SG_LIFE_IAAS_01  | PPE3    | RLS          | IAAS         | application/json | 101-6059337  | 2020-01-28   | 2020-01-01			  |
      #| SG     | Life | SG_LIFE_IAAS_02  | SG_LIFE_IAAS_02  | PPE3    | RLS          | IAAS         | application/json | 101-5936337  | 2019-11-22   | 2020-01-01			  |


  @TH_PPE3
    Examples:
      | entity | lob  | msgId           | initialMsgId    | env  | targetSystem | sourceSystem | accept           | policyNumber | effectiveDate | policyEffectiveToDate |
      | TH     | Life | TH_LIFE_SCRM_01 | TH_LIFE_SCRM_01 | PPE3 | RLS          | SCRM         | application/json | 508-2860064  | 2017-12-25    | 2020-01-01            |
      | TH     | Life | TH_LIFE_SCRM_02 | TH_LIFE_SCRM_02 | PPE3 | RLS          | SCRM         | application/json | 508-5685047  | 2018-07-15    | 2020-01-01            |

	  #| TH     | Life | TH_LIFE_SCRM_01 | TH_LIFE_SCRM_01 |PPE3     | RLS          | SCRM         | application/json | 508-6102539  | 2018-10-24   | 2020-01-01			  |
      #| TH     | Life | TH_LIFE_SCRM_02 | TH_LIFE_SCRM_02 | PPE3    | RLS          | SCRM         | application/json | 507-9012570  | 2017-02-06   | 2020-01-01			  |

  @HK_PPE3
    Examples:
      | entity | lob  | msgId           | initialMsgId    | env  | targetSystem | sourceSystem | accept           | policyNumber | effectiveDate | policyEffectiveToDate |
      | HK     | Life | HK_LIFE_SCRM_01 | HK_LIFE_SCRM_01 | PPE3 | RLS          | SCRM         | application/json | 504-8247521  | 2016-05-19    | 2020-01-01            |
      | HK     | Life | HK_LIFE_SCRM_02 | HK_LIFE_SCRM_02 | PPE3 | RLS          | SCRM         | application/json | 502-8540804  | 2005-05-26    | 2020-01-01            |
      | HK     | Life | HK_LIFE_NBPT_01 | HK_LIFE_NBPT_01 | PPE3 | RLS          | NBPT         | application/json | 504-8247521  | 2016-05-19    | 2020-01-01            |
      | HK     | Life | HK_LIFE_NBPT_02 | HK_LIFE_NBPT_02 | PPE3 | RLS          | NBPT         | application/json | 502-8540804  | 2005-05-26    | 2020-01-01            |
      | HK     | Life | HK_LIFE_HCT_01  | HK_LIFE_HCT_01  | PPE3 | RLS          | HCT          | application/json | 503-6393972  | 2012-06-18    | 2020-01-01            |
      | HK     | Life | HK_LIFE_HCT_02  | HK_LIFE_HCT_02  | PPE3 | RLS          | HCT          | application/json | 503-6457504  | 2012-06-28    | 2020-01-01            |

      #| HK     | Life | HK_LIFE_SCRM_02 | HK_LIFE_SCRM_02 | PPE3    | RLS          | SCRM         | application/json | 502-8301678  | 2004-08-07		| 2020-01-01			  |
      #| HK     | Life | HK_LIFE_NBPT_01 | HK_LIFE_NBPT_01 | PPE3    | RLS          | NBPT         | application/json | 502-4090465  | 1999-11-22		| 2020-01-01			  |
      #| HK     | Life | HK_LIFE_SCRM_01 | HK_LIFE_SCRM_01 | PPE3    | RLS          | SCRM         | application/json | 303-6191769  | 2012-04-19		| 2020-01-01			  |
      #| HK     | Life | HK_LIFE_NBPT_02 | HK_LIFE_NBPT_02 | PPE3    | RLS          | NBPT         | application/json | 503-3425181  | 2009-06-19		| 2020-01-01			  |
      #| HK     | Life | HK_LIFE_HCT_01  | HK_LIFE_HCT_01  | PPE3    | RLS          | HCT          | application/json | 503-2525882  | 2018-04-01		| 2020-01-01			  |
      #| HK     | Life | HK_LIFE_HCT_02  | HK_LIFE_HCT_02  | PPE3    | RLS          | HCT          | application/json | 300-1018781  | 1984-04-28		| 2020-01-01			  |

  @PH_PPE3
    Examples:
      | entity | lob  | msgId            | initialMsgId     | env  | targetSystem | sourceSystem | accept           | policyNumber | effectiveDate | policyEffectiveToDate |
      | PH     | Life | PH_LIFE_SCRM_01  | PH_LIFE_SCRM_01  | PPE3 | RLS          | SCRM         | application/json | 510-0626919  | 2007-05-11    | 2020-01-01            |
      | PH     | Life | PH_LIFE_EFUSE_02 | PH_LIFE_EFUSE_02 | PPE3 | RLS          | EFUSE        | application/json | 310-5746519  | 2016-07-18    | 2020-01-01            |
      | PH     | Life | PH_LIFE_SCRM_02  | PH_LIFE_SCRM_02  | PPE3 | RLS          | SCRM         | application/json | 310-3115691  | 2012-12-07    | 2020-01-01            |
      | PH     | Life | PH_LIFE_EFUSE_01 | PH_LIFE_EFUSE_01 | PPE3 | RLS          | EFUSE        | application/json | 510-0114015  | 2005-03-28    | 2020-01-01            |

	  #| PH     | Life | PH_LIFE_SCRM_01  | PH_LIFE_SCRM_01  | PPE3    | RLS          | SCRM         | application/json | 310-4348531  | 2014-10-28	  | 2020-01-01			  |
      #| PH     | Life | PH_LIFE_SCRM_02  | PH_LIFE_SCRM_02  | PPE3    | RLS          | SCRM         | application/json | 310-3290361  | 2013-03-13	  | 2020-01-01			  |
      #| PH     | Life | PH_LIFE_EFUSE_01 | PH_LIFE_EFUSE_01 | PPE3    | RLS          | EFUSE        | application/json | 310-7670592  | 2018-12-17	  | 2020-01-01			  |
      #| PH     | Life | PH_LIFE_EFUSE_02 | PH_LIFE_EFUSE_02 | PPE3    | RLS          | EFUSE        | application/json | 510-0621555  | 2007-05-09	  | 2020-01-01			  |

  @HK_QA06_PPE3
    Examples:
      | entity | lob  | msgId     | initialMsgId | env  | targetSystem | sourceSystem | accept           | policyNumber | effectiveDate | policyEffectiveToDate |
      | HK     | Life | HK_QA6_01 | HK_QA6_01    | PPE3 | RLS          | SCRM         | application/json | 504-9584260  | 2016-05-19    | 2020-01-01            |
      | HK     | Life | HK_QA6_01 | HK_QA6_01    | PPE3 | RLS          | SCRM         | application/json | 303-5109788  | 2011-03-28    | 2020-01-01            |
      | HK     | Life | HK_QA6_01 | HK_QA6_01    | PPE3 | RLS          | SCRM         | application/json | 503-8107008  | 2013-09-25    | 2020-01-01            |
      | HK     | Life | HK_QA6_01 | HK_QA6_01    | PPE3 | RLS          | SCRM         | application/json | 503-8439898  | 2014-01-02    | 2020-01-01            |
      | HK     | Life | HK_QA6_01 | HK_QA6_01    | PPE3 | RLS          | SCRM         | application/json | 303-7321878  | 2013-01-01    | 2020-01-01            |
