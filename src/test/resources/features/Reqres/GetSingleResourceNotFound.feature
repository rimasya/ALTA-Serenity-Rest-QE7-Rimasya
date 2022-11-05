Feature: Reqres Feature tugas

  @Tugas

  Scenario Outline: Get single resource not found
    Given Get single resource with parameter invalid <id>
    When Send get single resource invalid request
    Then Status code invalid single should be 404 NOT FOUND
    Examples:
      | id |
      | 23 |
