Feature: Reqres feature tugas

  @Tugas
  Scenario Outline: Delete user with invalid id
    Given Delete user with invalid id <id>
    When Send delete user with invalid request
    Then Status code should with invalid be 204 No Content
    Examples:
      | id |
      | 44 |