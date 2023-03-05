@smokeTest31
Feature: Verify login function in New Tours web application
  Scenario: Successfully login to new tours web application
    Given User go to New Tours home page
    And User click on the user name field
    When User type test username in username field
    And User click on the password field
    And User type test password in password field
    Then User click on the loging button
    And User verify the text "Login Successfully"