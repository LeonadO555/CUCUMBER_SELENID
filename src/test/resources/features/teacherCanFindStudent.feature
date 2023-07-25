Feature: Teacher can find student

  @teacherCanFindStudent
  Scenario: Teacher can find a student
    Given Open main page "https://erich416.softr.app/"
    When Click on signInButton
    And Fill authorization fields
    And Go to student directory
    And Fill input
    And Select student
    And Click on view profile
    Then Information about student is available