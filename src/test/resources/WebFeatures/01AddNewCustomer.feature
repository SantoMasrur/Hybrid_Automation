Feature: Add New Customer
  @smoke
  Scenario Outline: Add new customer
    Given user has base url
    When click bank manager login button
    And click add account button
    And user enter '<firstName>' and '<lastName>' and '<postCode>'
    And click addCustomer button
    Then click ok

    Examples:
      |firstName|lastName|postCode|
      |Santo    |Masrur  |1216    |