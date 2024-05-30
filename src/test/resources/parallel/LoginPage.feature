Feature: Login page feature

  Scenario: Login page title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "Login - My Shop"

  Scenario: Forgot Password Link
    Given user is on login page
    Then forgot password link should be displayed

  Scenario: Login with correct credentials
    Given user is on login page
    When user enters username "test1@ccc.com"
    And user enters password "123456"
    And user clicks on Login button
    Then user gets the title of the page
    And page title should be "My account - My Shop"