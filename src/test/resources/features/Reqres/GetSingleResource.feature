Feature: Reqres Feature tugas

  @Tugas

  Scenario Outline: Get single user resource
    Given Get single user with invalid parameter <param>
    When Send get single resource valid request
    Then Status code invalid single user should be 200 OK
    And Validate get single user resource json schema
    Examples:
      | param |
      | 1     |