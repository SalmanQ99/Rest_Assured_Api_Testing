Feature: Testing Delete Activity Api

  Scenario Outline: To delete an activity
    When User hits the delete api with id <id>
    Then  The response code should be <expectedStatusCode>
    Examples:
      | expectedStatusCode| id |
      |   200             |  1 |

  Scenario Outline: Negative Test case to delete an activity
    When User hits the delete api with id <id>
    Then  The response code should be <expectedStatusCode>
    Examples:
      | expectedStatusCode| id |
      |   404             |  -1 |