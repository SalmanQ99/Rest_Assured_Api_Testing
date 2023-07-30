Feature: Testing put API

  Scenario Outline: Update Activity title By Put Api

    When User makes a request to get activity with id <id>
    Then The response code should be <expectedStatusCode>
    When User updates the Activity with id <id> with a new title <title>
    Then The response code should be <expectedStatusCode>
    And The put activity response body should have the updated title <title>
    Examples:
      | id | expectedStatusCode | title     |
      | 1  | 200                | "My Test" |

  Scenario Outline: Update an existing activity with invalid id
    When User updates the Activity with id <id> with a new title <title>
    Then The response code should be <expectedStatusCode>
    Examples:
      | id | expectedStatusCode | title     |
      | -1 | 404                | "My Test" |
