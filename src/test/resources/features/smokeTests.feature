Feature: SmokeTests

  Scenario: Login with valid data
    Given Navigate to SingIn Page
    When Fill fields valid data for Sing In with email "roxanne@example.com" and password "123456"
    And Click on Sing In button
    Then Check displayed Add Course Text

  Scenario: Invalid data Sign In
    Given Navigate to SingIn Page
    When Fill fields valid data for Sing In with email "example@example.com" and password "123456"
    And Click on Sing In button
    Then Check Displayed Error Message password or login

  Scenario: SignUp with valid data
    Given Navigate to SignUp Page
    When Sign Up valid data with fullName "John Doe", email "john@gmail.com", and password "password123"
    And Click on Sign Up button
    Then Check displayed Add Course Text


  Scenario: SignUp with valid data
    Given Navigate to SignUp Page
    When Sign Up valid data with fullName "John Doe", email "john@example.com", and password "password123"
    And Click on Sign Up button
    Then Check displayed Add Course Text
