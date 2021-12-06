Feature: Create New Plan on mahara website

  @ahmed
  @lougoutAndCloseWebDriver
  Scenario: Create New Plan
    Given Open chrome and prepare to login
    When Insert username in the username field
    Then Insert Password in the password field

    When click sign-in button
    Then Verify login

    When Click on main menu
    Then Click on "Create"

    When Click on "Plans"
    Then Click the "New plan" button

    When Enter the title of the new plan
    And Enter the description
    And Select "Yes" on the drop-down list
    And Enter tags
    Then Click on the "Save Plan" button
    Then Verify The Plan saved successfully


