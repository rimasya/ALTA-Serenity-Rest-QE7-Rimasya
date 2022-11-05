Feature: Reqres Feature tugas

  @Tugas

  Scenario Outline: Get list user resource
    Given Get list user with invalid parameter <param>
    When Send get list resource valid request
    Then Status code invalid user should be 200 OK
    And Validate get list user resource json schema
        Examples:
          | param |
          | 213   |