Feature: Login

  @login
  Scenario: Login with valid data
    When Fill fields valid data
    And Click on Login button
    Then Check displayed Home page
