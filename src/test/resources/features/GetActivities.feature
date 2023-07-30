Feature:Testing Get Activities API

  Scenario Outline: Verify get all activities API

    Given User requests activity details
    Then  The response code should be <expectedStatusCode>
    And   User validates the response with json schema <schemaFileName>
    Then  The title should be <title>
    Examples:
      | expectedStatusCode | title        |  schemaFileName               |
      | 200                | "Activity 1" |    "GetActivitiesSchema.json" |

  Scenario Outline: Verify get activity API with valid id
    When  User makes a request to get activity with id <id>
    Then  The response code should be <expectedStatusCode>
    And The response body should contain id <id> title <title> and completed status <completed>
    Examples:
      | expectedStatusCode| id  | title        | completed |
      |   200             |  1  | "Activity 1" | "false"   |


  Scenario Outline: Verify get activity API with invalid id
    When  User makes a request to get activity with id <id>
    Then  The response code should be <expectedStatusCode>
    Examples:
      | expectedStatusCode | id |
      | 404                | -1 |