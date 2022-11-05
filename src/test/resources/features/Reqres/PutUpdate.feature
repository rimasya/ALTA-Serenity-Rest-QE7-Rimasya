Feature: Reqres feature tugas

  Scenario Outline: Put update body user with valid json
    Given Put update body user with valid json with id <id>
    When Send put update body user request
    Then Status code update should be 200 OK
    And Response body should contain name "Rimasya Update" ,job "QA Update" and age "23 Update"
    And Validate put update user json schema
    Examples:
      | id |
      | 1  |
      | 2  |