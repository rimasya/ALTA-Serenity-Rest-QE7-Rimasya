Feature: Reqres Feature tugas

@Tugas

      Scenario Outline: Get single user not found
        Given Get single user with parameter invalid <id>
        When Send get single user invalid request
        Then Status code invalid user should be 404 NOT FOUND
  Examples:
    | id |
    | 23 |
