Feature: Reqres Feature tugas

  @Tugas
  Scenario: Post login unsuccessful with valid json
    Given Post login unsuccessful with valid json
    When Send post login unsuccessful request
    Then Status code login unsuccessful should be 400
    And Response body login unsuccessful should contain error "Missing password"
    And Validate login unsuccessful json schema