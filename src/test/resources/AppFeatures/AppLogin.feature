Feature: eriBank login
  @smoke
  Scenario Outline: login with valid credentials

    Given User in the login page
    And User fill '<userName>' and '<password>'
    And press login button
    Then user will be logged in

    Examples:
      |userName|password|
      |company |company |