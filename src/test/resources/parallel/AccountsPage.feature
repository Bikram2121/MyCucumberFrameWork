Feature: Account Page Feature

  Background:
    Given user has already logged into the application
      | username      | password |
      | test1@ccc.com | 123456   |

  Scenario: Accounts page title
    Given user is on Accounts page
    When user gets the title of the page
    Then page title should be "My account - My Shop"

  Scenario: Accounts section count
    Given user is on Accounts page
    Then user gets account section
      | ADD MY FIRST ADDRESS      |
      | ORDER HISTORY AND DETAILS |
      | MY CREDIT SLIPS           |
      | MY ADDRESSES              |
      | MY PERSONAL INFORMATION   |

    And Account section count is 5

