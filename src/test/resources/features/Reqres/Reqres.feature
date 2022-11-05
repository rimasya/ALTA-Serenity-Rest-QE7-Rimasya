Feature: Reqres Feature test

  @Latihan
  Scenario Outline: Get list user with valid parameter pages
    Given Get list user with parameter page <page>
    When Send get list user request
    Then Status code should be 200 OK
    And Response body page should be <page>
    And Validate get list user json schema
  Examples:
  |page|
  |1   |
  |2   |

  @Latihan
  Scenario: Post create new user with valid json
  Given Post create user with valid json
  When Send post create user request
  Then Status code should be 201 Created
  And Response body should contain name "Rimasya Ayu J" and job "QA"
    And Validate create user json schema
  @Latihan
Scenario Outline: Put update user with valid json
  Given Put update user with valid json with id <id>
  When Send put update user request
  Then Status code should be 200 OK
  And Response body should contain name "Rimasya Update" and job "QA Update"
    And Validate put user json schema
  Examples:
    | id |
    | 1  |
    | 2  |

  @Latihan
  Scenario Outline: Delete user with valid id
    Given Delete user with id <id>
    When Send delete user request
    Then Status code should be 204 No Content
    Examples:
    | id |
    | 1  |

#    @Tugas
#    Scenario Outline: Get single user with valid parameter pages
#      Given Get single user with parameter page <page>
#      When Send get single user request
#      Then Status code single user should be 200 OK
#      And Response body page single user should be <page>
#      And Validate get single user json schema
#      Examples:
#        |page|
#        |1   |
#        |2   |

#      @Tugas
#      Scenario Outline: Get single user not found
#        Given Get single user with parameter invalid page <page>
#        When Send get single user invalid request
#        Then Status code invalid user should be 404 NOT FOUND
#        And Response body invalid user should be <page>


