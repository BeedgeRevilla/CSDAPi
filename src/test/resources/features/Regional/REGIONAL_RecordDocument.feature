Feature: REGIONAL Record Document
  Records posted will depend on the parameters set on the POST request.


  Scenario Outline: Record Document - <entity>_<sourceSystem>_<TCNo> - Successful post of records

    Given the following http headers are set Record Document
      | X-Axa-Entity | X-Axa-LOB | X-Axa-MsgId | X-Axa-InitialMsgId | X-Axa-Env | X-Axa-ContextHeader-CustomData-TargetSystem | X-Axa-ContextHeader-CustomData-SourceSystem | Accept   |
      | <entity>     | <lob>     | <msgId>     | <initialMsgId>     | <env>     | <targetSystem>                              | <sourceSystem>                              | <accept> |

    And the following PAYLOAD request body is set for Record Document
      | payload   | documentTitle   | documentType   | lineOfBusiness | policyNumber   | country  | entityCode   | channelCode   |
      | <payload> | <documentTitle> | <documentType> | <lob>          | <policyNumber> | <entity> | <entityCode> | <channelCode> |

    When the api call has been made for Record Document

    Then verify that API response matches for Record Document
      | responseFlag   |
      | <responseFlag> |

  @HK
    Examples:
      | TCNo | entity | lob | msgId      | initialMsgId | env  | targetSystem | sourceSystem | accept           | payload                    | responseFlag | documentTitle   | documentType  | policyNumber | entityCode | channelCode |
      | 0001 | HK     | GI  | [$autogen] | [$autogen]   | NFT6 | WFI          | SCRM         | application/json | recordDocument_HK_0001.txt | Success      | HK-SCRM-RD-GI-1 | NWBSHK0IDENPF | 20852158     | AG         | AG          |
      | 0002 | HK     | GI  | [$autogen] | [$autogen]   | NFT6 | WFI          | SCRM         | application/json |                            | Success      | HK-SCRM-RD-GI-1 | NWBSHK0IDENPF | 20852158     | AG         | AG          |

  @TH
    Examples:
      | TCNo | entity | lob  | msgId      | initialMsgId | env  | targetSystem | sourceSystem | accept           | payload                    | responseFlag | documentTitle    | documentType  | policyNumber | entityCode | channelCode |
      | 0001 | TH     | Life | [$autogen] | [$autogen]   | NFT6 | WFI          | SCRM         | application/json | recordDocument_TH_0001.txt | Success      | TH-SCRM-RD-GI-01 | NWBSTH1SUPPRT | 502-7950780  | BA         | BA          |
      | 0002 | TH     | Life | [$autogen] | [$autogen]   | NFT6 | WFI          | SCRM         | application/json |                            | Success      | TH-SCRM-RD-GI-01 | NWBSTH1SUPPRT | 502-7950780  | BA         | BA          |

  @PH
    Examples:
      | TCNo | entity | lob  | msgId      | initialMsgId | env  | targetSystem | sourceSystem | accept           | payload                    | responseFlag | documentTitle | documentType  | policyNumber | entityCode | channelCode |
      | 0001 | PH     | Life | [$autogen] | [$autogen]   | NFT6 | WFI          | SCRM         | application/json | recordDocument_PH_0001.txt | Success      | PH-DLFE-RD-02 | NWBSPH1CYPRPT | 301-1016031  | PH         | AG          |
      | 0002 | PH     | Life | [$autogen] | [$autogen]   | NFT6 | WFI          | SCRM         | application/json |                            | Success      | PH-DLFE-RD-02 | NWBSPH1CYPRPT | 301-1016031  | PH         | AG          |

  @SG
    Examples:
      | TCNo | entity | lob  | msgId      | initialMsgId | env  | targetSystem | sourceSystem | accept           | payload                    | responseFlag | documentTitle  | documentType | policyNumber | entityCode | channelCode |
      | 0001 | SG     | Life | [$autogen] | [$autogen]   | NFT6 | WFI          | SCRM         | application/json | recordDocument_SG_0001.txt | Success      | SG-SCRM-RD-02  | NWBSG1PROP   | 102-1859630  | SG         | AG          |
      | 0002 | SG     | Life | [$autogen] | [$autogen]   | NFT6 | WFI          | SCRM         | application/json |                            | Success      | SG-SCRM-RD-02  | NWBSG1PROP   | 102-1859630  | SG         | AG          |
      | 0003 | SG     | Life | [$autogen] | [$autogen]   | NFT6 | WFI          | MYAXA        | application/json |                            | Success      | SG-MYAXA-RD-02 | NWBSG1PROP   | 102-1859630  | SG         | AG          |
      | 0004 | SG     | GI   | [$autogen] | [$autogen]   | NFT6 | WFI          | MYAXA        | application/json |                            | Success      | SG-MYAXA-RD-02 | NWBSG1PROP   | 102-1859630  | SG         | AG          |