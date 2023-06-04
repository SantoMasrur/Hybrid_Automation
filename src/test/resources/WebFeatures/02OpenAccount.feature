Feature: Open New Account

  @smoke

  Scenario: Open new account
    Given User in open account page
    When user select name from dropdown menu
    And select currency from dropdown menu
    And click process button
    Then user successfully navigate the popup