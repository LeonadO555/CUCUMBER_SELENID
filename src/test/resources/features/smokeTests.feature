Feature: SmokeTests

  Scenario: Login with valid data
    Given Navigate to SingIn Page
    When Fill fields valid data for sing In
    And Click on Sing In button
    Then Check displayed Add Course Text

  Scenario: Invalid login
    Given Navigate to SingIn Page
    When User enters invalid username and password for sing In
    And Click on Sing In button
    Then Check Displayed Error Message password or login

    Scenario: SingUp with valid data
      Given Navigate to SingUp Page
      When Sing Up valid data
      And Click on Sing Up button
      Then Check displayed Add Course Text

  Scenario: SingUp with exist user
    Given Navigate to SingUp Page
    When Sing Up exist User
    And Click on Sing Up button
    Then Check Displayed Error Message User Exist