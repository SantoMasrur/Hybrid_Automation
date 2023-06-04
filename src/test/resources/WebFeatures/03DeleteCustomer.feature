Feature: Delete an account

  @smoke

  Scenario: Delete account
    Given user in customers page
    When user search names
    And delete the account
    Then successfully account will be deleted