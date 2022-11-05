Feature: Reqres Feature tugas

  @Tugas
    Scenario: Post register successful with valid json
    Given Post register successful with valid json
    When Send post register request
    Then Status code register successful should be 200 OK
    And Response body should contain id 4 and token "QpwL5tke4Pnpja7X4"
    And Validate register successful json schema