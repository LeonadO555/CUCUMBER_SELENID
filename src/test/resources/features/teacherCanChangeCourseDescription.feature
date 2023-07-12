Feature: Teacher can change course description

  @changeCourseDescription
  Scenario: Teacher can change course description
    Given Open the main page "https://jere237.softr.app/"
    When Go the to authorisation form
    And Register as existing teacher
    And Go to courses page
    And Select course
    And Edit course description
    Then Description changed