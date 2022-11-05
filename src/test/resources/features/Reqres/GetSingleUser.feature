Feature: Reqres Feature tugas
@Tugas
Scenario Outline: Get single user with valid parameter pages
Given Get single user with parameter page <id>
When Send get single user request
Then Status code single user should be 200 OK
And Validate get single user json schema
Examples:
  | id |
  | 1  |