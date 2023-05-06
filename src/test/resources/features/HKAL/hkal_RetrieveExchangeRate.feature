Feature: HKAL Retrieve Exchange Rate
  Records retrieved will depend on the parameters set on the GET request.

  Scenario: HKAL Retrieve Exchange Rate - 01 - Successful retrieve Reference Details with Currency Code USD / Base Currency Code HKD

    Given the following http headers are set for HKAL Retrieve Exchange Rate
      | x-axahk-channelcode | x-axahk-msgid | x-axahk-lob | x-axahk-sourcesystem | Accept           |
      | MyAXA               | getRef01      | Life        | RLS                  | application/json |

    And the following GET input parameters are set for HKAL Retrieve Exchange Rate
      | currencyCode | baseCurrencyCode | effectiveDate |
      | USD          | HKD              | 20190101      |

    When the api call has been made for HKAL Retrieve Exchange Rate

    When the Stored Procedure is called for HKAL Retrieve Exchange Rate

    Then verify that API and DB responses matched for HKAL Retrieve Exchange Rate

  Scenario: HKAL Retrieve Exchange Rate - 02 - Successful retrieve Reference Details with Currency Code RMB / Base Currency Code HKD

    Given the following http headers are set for HKAL Retrieve Exchange Rate
      | x-axahk-channelcode | x-axahk-msgid | x-axahk-lob | x-axahk-sourcesystem | Accept           |
      | MyAXA               | getRef02      | Life        | RLS                  | application/json |

    And the following GET input parameters are set for HKAL Retrieve Exchange Rate
      | currencyCode | baseCurrencyCode | effectiveDate |
      | RMB          | HKD              | 20190101      |

    When the api call has been made for HKAL Retrieve Exchange Rate

    When the Stored Procedure is called for HKAL Retrieve Exchange Rate

    Then verify that API and DB responses matched for HKAL Retrieve Exchange Rate

  Scenario: HKAL Retrieve Exchange Rate - 03 - Successful retrieve Reference Details with Currency Code JPY / Base Currency Code HKD

    Given the following http headers are set for HKAL Retrieve Exchange Rate
      | x-axahk-channelcode | x-axahk-msgid | x-axahk-lob | x-axahk-sourcesystem | Accept           |
      | MyAXA               | getRef03      | Life        | RLS                  | application/json |

    And the following GET input parameters are set for HKAL Retrieve Exchange Rate
      | currencyCode | baseCurrencyCode | effectiveDate |
      | JPY          | HKD              | 20190101      |

    When the api call has been made for HKAL Retrieve Exchange Rate

    When the Stored Procedure is called for HKAL Retrieve Exchange Rate

    Then verify that API and DB responses matched for HKAL Retrieve Exchange Rate

  Scenario: HKAL Retrieve Exchange Rate - 04 - Successful retrieve Reference Details with Currency Code AUD / Base Currency Code HKD

    Given the following http headers are set for HKAL Retrieve Exchange Rate
      | x-axahk-channelcode | x-axahk-msgid | x-axahk-lob | x-axahk-sourcesystem | Accept           |
      | MyAXA               | getRef04      | Life        | RLS                  | application/json |

    And the following GET input parameters are set for HKAL Retrieve Exchange Rate
      | currencyCode | baseCurrencyCode | effectiveDate |
      | AUD          | HKD              | 20190101      |

    When the api call has been made for HKAL Retrieve Exchange Rate

    When the Stored Procedure is called for HKAL Retrieve Exchange Rate

    Then verify that API and DB responses matched for HKAL Retrieve Exchange Rate

  Scenario: HKAL Retrieve Exchange Rate - 05 - Successful retrieve Reference Details with Currency Code EUR / Base Currency Code HKD

    Given the following http headers are set for HKAL Retrieve Exchange Rate
      | x-axahk-channelcode | x-axahk-msgid | x-axahk-lob | x-axahk-sourcesystem | Accept           |
      | MyAXA               | getRef05      | Life        | RLS                  | application/json |

    And the following GET input parameters are set for HKAL Retrieve Exchange Rate
      | currencyCode | baseCurrencyCode | effectiveDate |
      | EUR          | HKD              | 20190101      |

    When the api call has been made for HKAL Retrieve Exchange Rate

    When the Stored Procedure is called for HKAL Retrieve Exchange Rate

    Then verify that API and DB responses matched for HKAL Retrieve Exchange Rate

  Scenario: HKAL Retrieve Exchange Rate - 06 - Successful retrieve Reference Details with Currency Code USD / Base Currency Code MOP

    Given the following http headers are set for HKAL Retrieve Exchange Rate
      | x-axahk-channelcode | x-axahk-msgid | x-axahk-lob | x-axahk-sourcesystem | Accept           |
      | MyAXA               | getRef06      | Life        | RLS                  | application/json |

    And the following GET input parameters are set for HKAL Retrieve Exchange Rate
      | currencyCode | baseCurrencyCode | effectiveDate |
      | USD          | MOP              | 20190101      |

    When the api call has been made for HKAL Retrieve Exchange Rate

    When the Stored Procedure is called for HKAL Retrieve Exchange Rate

    Then verify that API and DB responses matched for HKAL Retrieve Exchange Rate

  Scenario: HKAL Retrieve Exchange Rate - 07 - Successful retrieve Reference Details with Currency Code AUD / Base Currency Code MOP

    Given the following http headers are set for HKAL Retrieve Exchange Rate
      | x-axahk-channelcode | x-axahk-msgid | x-axahk-lob | x-axahk-sourcesystem | Accept           |
      | MyAXA               | getRef07      | Life        | RLS                  | application/json |

    And the following GET input parameters are set for HKAL Retrieve Exchange Rate
      | currencyCode | baseCurrencyCode | effectiveDate |
      | AUD          | MOP              | 20190101      |

    When the api call has been made for HKAL Retrieve Exchange Rate

    When the Stored Procedure is called for HKAL Retrieve Exchange Rate

    Then verify that API and DB responses matched for HKAL Retrieve Exchange Rate

  Scenario: HKAL Retrieve Exchange Rate - 08 - Successful retrieve Reference Details with Currency Code EUR / Base Currency Code MOP

    Given the following http headers are set for HKAL Retrieve Exchange Rate
      | x-axahk-channelcode | x-axahk-msgid | x-axahk-lob | x-axahk-sourcesystem | Accept           |
      | MyAXA               | getRef08      | Life        | RLS                  | application/json |

    And the following GET input parameters are set for HKAL Retrieve Exchange Rate
      | currencyCode | baseCurrencyCode | effectiveDate |
      | EUR          | MOP              | 20190101      |

    When the api call has been made for HKAL Retrieve Exchange Rate

    When the Stored Procedure is called for HKAL Retrieve Exchange Rate

    Then verify that API and DB responses matched for HKAL Retrieve Exchange Rate

  Scenario: HKAL Retrieve Exchange Rate - 09 - Successful retrieve Reference Details with Currency Code USD / Base Currency Code HKD

    Given the following http headers are set for HKAL Retrieve Exchange Rate
      | x-axahk-channelcode | x-axahk-msgid | x-axahk-lob | x-axahk-sourcesystem | Accept           |
      | HKPO                | getRef01      | Life        | RLS                  | application/json |

    And the following GET input parameters are set for HKAL Retrieve Exchange Rate
      | currencyCode | baseCurrencyCode | effectiveDate |
      | USD          | HKD              | 20190101      |

    When the api call has been made for HKAL Retrieve Exchange Rate

    When the Stored Procedure is called for HKAL Retrieve Exchange Rate

    Then verify that API and DB responses matched for HKAL Retrieve Exchange Rate

  Scenario: HKAL Retrieve Exchange Rate - 10 - Successful retrieve Reference Details with Currency Code RMB / Base Currency Code HKD

    Given the following http headers are set for HKAL Retrieve Exchange Rate
      | x-axahk-channelcode | x-axahk-msgid | x-axahk-lob | x-axahk-sourcesystem | Accept           |
      | HKPO                | getRef02      | Life        | RLS                  | application/json |

    And the following GET input parameters are set for HKAL Retrieve Exchange Rate
      | currencyCode | baseCurrencyCode | effectiveDate |
      | RMB          | HKD              | 20190101      |

    When the api call has been made for HKAL Retrieve Exchange Rate

    When the Stored Procedure is called for HKAL Retrieve Exchange Rate

    Then verify that API and DB responses matched for HKAL Retrieve Exchange Rate

  Scenario: HKAL Retrieve Exchange Rate - 11 - Successful retrieve Reference Details with Currency Code JPY / Base Currency Code HKD

    Given the following http headers are set for HKAL Retrieve Exchange Rate
      | x-axahk-channelcode | x-axahk-msgid | x-axahk-lob | x-axahk-sourcesystem | Accept           |
      | HKPO                | getRef03      | Life        | RLS                  | application/json |

    And the following GET input parameters are set for HKAL Retrieve Exchange Rate
      | currencyCode | baseCurrencyCode | effectiveDate |
      | JPY          | HKD              | 20190101      |

    When the api call has been made for HKAL Retrieve Exchange Rate

    When the Stored Procedure is called for HKAL Retrieve Exchange Rate

    Then verify that API and DB responses matched for HKAL Retrieve Exchange Rate

  Scenario: HKAL Retrieve Exchange Rate - 12 - Successful retrieve Reference Details with Currency Code AUD / Base Currency Code HKD

    Given the following http headers are set for HKAL Retrieve Exchange Rate
      | x-axahk-channelcode | x-axahk-msgid | x-axahk-lob | x-axahk-sourcesystem | Accept           |
      | HKPO                | getRef04      | Life        | RLS                  | application/json |

    And the following GET input parameters are set for HKAL Retrieve Exchange Rate
      | currencyCode | baseCurrencyCode | effectiveDate |
      | AUD          | HKD              | 20190101      |

    When the api call has been made for HKAL Retrieve Exchange Rate

    When the Stored Procedure is called for HKAL Retrieve Exchange Rate

    Then verify that API and DB responses matched for HKAL Retrieve Exchange Rate

  Scenario: HKAL Retrieve Exchange Rate - 13 - Successful retrieve Reference Details with Currency Code EUR / Base Currency Code HKD

    Given the following http headers are set for HKAL Retrieve Exchange Rate
      | x-axahk-channelcode | x-axahk-msgid | x-axahk-lob | x-axahk-sourcesystem | Accept           |
      | HKPO                | getRef05      | Life        | RLS                  | application/json |

    And the following GET input parameters are set for HKAL Retrieve Exchange Rate
      | currencyCode | baseCurrencyCode | effectiveDate |
      | EUR          | HKD              | 20190101      |

    When the api call has been made for HKAL Retrieve Exchange Rate

    When the Stored Procedure is called for HKAL Retrieve Exchange Rate

    Then verify that API and DB responses matched for HKAL Retrieve Exchange Rate

  Scenario: HKAL Retrieve Exchange Rate - 14 - Successful retrieve Reference Details with Currency Code USD / Base Currency Code MOP

    Given the following http headers are set for HKAL Retrieve Exchange Rate
      | x-axahk-channelcode | x-axahk-msgid | x-axahk-lob | x-axahk-sourcesystem | Accept           |
      | HKPO                | getRef06      | Life        | RLS                  | application/json |

    And the following GET input parameters are set for HKAL Retrieve Exchange Rate
      | currencyCode | baseCurrencyCode | effectiveDate |
      | USD          | MOP              | 20190101      |

    When the api call has been made for HKAL Retrieve Exchange Rate

    When the Stored Procedure is called for HKAL Retrieve Exchange Rate

    Then verify that API and DB responses matched for HKAL Retrieve Exchange Rate

  Scenario: HKAL Retrieve Exchange Rate - 15 - Successful retrieve Reference Details with Currency Code AUD / Base Currency Code MOP

    Given the following http headers are set for HKAL Retrieve Exchange Rate
      | x-axahk-channelcode | x-axahk-msgid | x-axahk-lob | x-axahk-sourcesystem | Accept           |
      | HKPO                | getRef07      | Life        | RLS                  | application/json |

    And the following GET input parameters are set for HKAL Retrieve Exchange Rate
      | currencyCode | baseCurrencyCode | effectiveDate |
      | AUD          | MOP              | 20190101      |

    When the api call has been made for HKAL Retrieve Exchange Rate

    When the Stored Procedure is called for HKAL Retrieve Exchange Rate

    Then verify that API and DB responses matched for HKAL Retrieve Exchange Rate

  Scenario: HKAL Retrieve Exchange Rate - 16 - Successful retrieve Reference Details with Currency Code EUR / Base Currency Code MOP

    Given the following http headers are set for HKAL Retrieve Exchange Rate
      | x-axahk-channelcode | x-axahk-msgid | x-axahk-lob | x-axahk-sourcesystem | Accept           |
      | HKPO                | getRef08      | Life        | RLS                  | application/json |

    And the following GET input parameters are set for HKAL Retrieve Exchange Rate
      | currencyCode | baseCurrencyCode | effectiveDate |
      | EUR          | MOP              | 20190101      |

    When the api call has been made for HKAL Retrieve Exchange Rate

    When the Stored Procedure is called for HKAL Retrieve Exchange Rate

    Then verify that API and DB responses matched for HKAL Retrieve Exchange Rate

  Scenario: HKAL Retrieve Exchange Rate - 17 - Successful retrieve Reference Details with Currency Code USD / Base Currency Code HKD

    Given the following http headers are set for HKAL Retrieve Exchange Rate
      | x-axahk-channelcode | x-axahk-msgid | x-axahk-lob | x-axahk-sourcesystem | Accept           |
      | IPRO-SVC            | getRef01      | Life        | RLS                  | application/json |

    And the following GET input parameters are set for HKAL Retrieve Exchange Rate
      | currencyCode | baseCurrencyCode | effectiveDate |
      | USD          | HKD              | 20190101      |

    When the api call has been made for HKAL Retrieve Exchange Rate

    When the Stored Procedure is called for HKAL Retrieve Exchange Rate

    Then verify that API and DB responses matched for HKAL Retrieve Exchange Rate

  Scenario: HKAL Retrieve Exchange Rate - 18 - Successful retrieve Reference Details with Currency Code RMB / Base Currency Code HKD

    Given the following http headers are set for HKAL Retrieve Exchange Rate
      | x-axahk-channelcode | x-axahk-msgid | x-axahk-lob | x-axahk-sourcesystem | Accept           |
      | IPRO-SVC            | getRef01      | Life        | RLS                  | application/json |

    And the following GET input parameters are set for HKAL Retrieve Exchange Rate
      | currencyCode | baseCurrencyCode | effectiveDate |
      | RMB          | HKD              | 20190101      |

    When the api call has been made for HKAL Retrieve Exchange Rate

    When the Stored Procedure is called for HKAL Retrieve Exchange Rate

    Then verify that API and DB responses matched for HKAL Retrieve Exchange Rate

  Scenario: HKAL Retrieve Exchange Rate - 19 - Successful retrieve Reference Details with Currency Code JPY / Base Currency Code HKD

    Given the following http headers are set for HKAL Retrieve Exchange Rate
      | x-axahk-channelcode | x-axahk-msgid | x-axahk-lob | x-axahk-sourcesystem | Accept           |
      | IPRO-SVC            | getRef01      | Life        | RLS                  | application/json |

    And the following GET input parameters are set for HKAL Retrieve Exchange Rate
      | currencyCode | baseCurrencyCode | effectiveDate |
      | JPY          | HKD              | 20190101      |

    When the api call has been made for HKAL Retrieve Exchange Rate

    When the Stored Procedure is called for HKAL Retrieve Exchange Rate

    Then verify that API and DB responses matched for HKAL Retrieve Exchange Rate

  Scenario: HKAL Retrieve Exchange Rate - 20 - Successful retrieve Reference Details with Currency Code AUD / Base Currency Code HKD

    Given the following http headers are set for HKAL Retrieve Exchange Rate
      | x-axahk-channelcode | x-axahk-msgid | x-axahk-lob | x-axahk-sourcesystem | Accept           |
      | IPRO-SVC            | getRef01      | Life        | RLS                  | application/json |

    And the following GET input parameters are set for HKAL Retrieve Exchange Rate
      | currencyCode | baseCurrencyCode | effectiveDate |
      | AUD          | HKD              | 20190101      |

    When the api call has been made for HKAL Retrieve Exchange Rate

    When the Stored Procedure is called for HKAL Retrieve Exchange Rate

    Then verify that API and DB responses matched for HKAL Retrieve Exchange Rate

  Scenario: HKAL Retrieve Exchange Rate - 21 - Successful retrieve Reference Details with Currency Code EUR / Base Currency Code HKD

    Given the following http headers are set for HKAL Retrieve Exchange Rate
      | x-axahk-channelcode | x-axahk-msgid | x-axahk-lob | x-axahk-sourcesystem | Accept           |
      | IPRO-SVC            | getRef01      | Life        | RLS                  | application/json |

    And the following GET input parameters are set for HKAL Retrieve Exchange Rate
      | currencyCode | baseCurrencyCode | effectiveDate |
      | EUR          | HKD              | 20190101      |

    When the api call has been made for HKAL Retrieve Exchange Rate

    When the Stored Procedure is called for HKAL Retrieve Exchange Rate

    Then verify that API and DB responses matched for HKAL Retrieve Exchange Rate

  Scenario: HKAL Retrieve Exchange Rate - 22 - Successful retrieve Reference Details with Currency Code USD / Base Currency Code MOP

    Given the following http headers are set for HKAL Retrieve Exchange Rate
      | x-axahk-channelcode | x-axahk-msgid | x-axahk-lob | x-axahk-sourcesystem | Accept           |
      | IPRO-SVC            | getRef01      | Life        | RLS                  | application/json |

    And the following GET input parameters are set for HKAL Retrieve Exchange Rate
      | currencyCode | baseCurrencyCode | effectiveDate |
      | USD          | MOP              | 20190101      |

    When the api call has been made for HKAL Retrieve Exchange Rate

    When the Stored Procedure is called for HKAL Retrieve Exchange Rate

    Then verify that API and DB responses matched for HKAL Retrieve Exchange Rate

  Scenario: HKAL Retrieve Exchange Rate - 23 - Successful retrieve Reference Details with Currency Code AUD / Base Currency Code MOP

    Given the following http headers are set for HKAL Retrieve Exchange Rate
      | x-axahk-channelcode | x-axahk-msgid | x-axahk-lob | x-axahk-sourcesystem | Accept           |
      | IPRO-SVC            | getRef01      | Life        | RLS                  | application/json |

    And the following GET input parameters are set for HKAL Retrieve Exchange Rate
      | currencyCode | baseCurrencyCode | effectiveDate |
      | AUD          | MOP              | 20190101      |

    When the api call has been made for HKAL Retrieve Exchange Rate

    When the Stored Procedure is called for HKAL Retrieve Exchange Rate

    Then verify that API and DB responses matched for HKAL Retrieve Exchange Rate

  Scenario: HKAL Retrieve Exchange Rate - 24 - Successful retrieve Reference Details with Currency Code EUR / Base Currency Code MOP

    Given the following http headers are set for HKAL Retrieve Exchange Rate
      | x-axahk-channelcode | x-axahk-msgid | x-axahk-lob | x-axahk-sourcesystem | Accept           |
      | IPRO-SVC            | getRef01      | Life        | RLS                  | application/json |

    And the following GET input parameters are set for HKAL Retrieve Exchange Rate
      | currencyCode | baseCurrencyCode | effectiveDate |
      | EUR          | MOP              | 20190101      |

    When the api call has been made for HKAL Retrieve Exchange Rate

    When the Stored Procedure is called for HKAL Retrieve Exchange Rate

    Then verify that API and DB responses matched for HKAL Retrieve Exchange Rate