Feature: Login

  @login
  Scenario: Login with valid data
    When Click on signInButton
    And Fill email input
    And Fill password input
    And Click on Sign In button
    Then Check displayed Home page