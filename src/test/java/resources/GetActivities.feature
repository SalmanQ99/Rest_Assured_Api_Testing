Feature:Testing swagger Get API

  Scenario Outline: Verify get all activities API

    Given User request Activity details
    Then  The response code should be <expectedStatusCode>
    And   User validates the response with JSON schema <jsonFile>
    Then  The Title should be <title>
    Examples:
      | expectedStatusCode | title        |  jsonFile |
      | 200                | "Activity 1" |    "GetActivitiesSchema.json" |

  Scenario Outline: Verify get activity API with id as a parameter
    When  User makes a request to view Activity with id <id>
    Then  The response code should be <expectedStatusCode>
    And The response body contain id <id> title <title> and completed status <completed>
    Examples:
      | expectedStatusCode| id  | title        | completed |
      |   200             |  1 | "Activity 1" | "false"   |


  Scenario Outline: Verify get request with invalid end point
    When User sends a GET request
    Then  The response code should be <expectedStatusCode>
    Examples:
      | expectedStatusCode |
      | 400                |