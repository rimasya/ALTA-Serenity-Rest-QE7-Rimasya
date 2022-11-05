Feature: Reqres Feature tugas

  @Tugas

  Scenario Outline: Get delayed response
    Given Get delayed with parameter delay <id>
    When Send delayed response request
    Then Status code delayed should be 200 OK
    And Validate delay response json schema
    Examples:
      | id |
      | 3  |