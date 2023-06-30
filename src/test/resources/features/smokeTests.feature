Feature: SmokeTests

  Scenario: Login with valid data
    Given Navigate to SingIn Page
    When Fill fields valid data for Sing In
    And Click on Sing In button
    Then Check displayed Add Course Text

  Scenario: Invalid data Sign In
    Given Navigate to SingIn Page
    When User enters invalid username and password for Sing In
    And Click on Sing In button
    Then Check Displayed Error Message password or login

  Scenario: SingUp with valid data
    Given Navigate to SignUp Page
    When Sign Up valid data
    And Click on Sign Up button
    Then Check displayed Add Course Text

  Scenario: SingUp with exist user
    Given Navigate to SignUp Page
    When Sign Up exist User
    And Click on Sign Up button
    Then Check Displayed Error Message User Exist