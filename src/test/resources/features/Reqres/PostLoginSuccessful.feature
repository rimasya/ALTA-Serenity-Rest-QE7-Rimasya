Feature: Reqres Feature tugas

  @Tugas
  Scenario: Post login successful with valid json
    Given Post login successful with valid json
    When Send post login successful request
    Then Status code login successful should be 200 OK
    And Response body should contain token "QpwL5tke4Pnpja7X4"
    And Validate login successful json schema