@Login
Feature: Login page feature

   @Smoke
  Scenario: Login page title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "Login - My Shop"

  @Regression
  Scenario: Forgot Password Link
    Given user is on login page
    Then forgot password link should be displayed

    @Smoke @skip_scenario
  Scenario: Login with correct credentials
    Given user is on login page
    When user enters username "test1@ccc.com"
    And user enters password "123456"
    And user clicks on Login button
    Then user gets the title of the page
    And page title should be "My account - My Shop"