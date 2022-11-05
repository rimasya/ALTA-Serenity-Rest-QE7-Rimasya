Feature: Reqres Feature tugas

  @Tugas
  Scenario: Post register unsuccessful with valid json
    Given Post register unsuccessful with valid json
    When Send post register unsuccessful request
    Then Status code register unsuccessful should be 400
    And Response body should contain error "Missing password"
    And Validate register unsuccessful json schema