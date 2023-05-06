Feature: REGIONAL Notify Document
  Records retrieved will depend on the parameters set on the SOAP request.

  Scenario Outline: Notify Document <entityCD>_<lobCD>_<targetSystem>_<msgId> - Successful response from API

    Given the following parameters on the payload that are set Notify Document
      | countryCD   | entityCD   | lobCD   | targetSystem   |
      | <countryCD> | <entityCD> | <lobCD> | <targetSystem> |

    When the api call has been made for Notify Document

  @SG
    Examples:
      | countryCD | entityCD | lobCD | targetSystem |
      | SG        | SG       | Life  | DLFE         |
      | SG        | SG       | Life  | SCRM         |
      | SG        | SG       | Life  | MYAXA        |
      | SG        | SG       | Life  | IAAS         |

  @HK
    Examples:
      | countryCD | entityCD | lobCD | targetSystem |
      | HK        | HK       | Life  | DLFE         |

  @TH
    Examples:
      | countryCD | entityCD | lobCD | targetSystem |
      | TH        | TH       | Life  | SCRM         |

  @PH
    Examples:
      | countryCD | entityCD | lobCD | targetSystem |
      | PH        | PH       | Life  | DLFE         |
