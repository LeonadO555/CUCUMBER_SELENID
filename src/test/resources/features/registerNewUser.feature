Feature: Registration New User

  @validRegistration
  Scenario: User click on signUp button and fill registration fields
    Given Go to main page "https://jere237.softr.app/"
    When Go to registration form
    And Select role
    And Fill Registration fields
    And Click on checkbox: I agree to the Terms and Privacy Policy
    And Click on signUp button
    And Sign Out
    Then User logged out