Feature: Test for Post Activity API


  Scenario Outline: Create a new Activity
    Given User provides an activity title <title>, due date <dueDate>, and completed status <completedStatus>
    When User sends a POST request to create an activity
    Then  The response code should be <expectedStatusCode>
    And User validates the response with json schema <schemaFileName>
    Examples:
      | title         | dueDate      | completedStatus | expectedStatusCode | schemaFileName           |
      | "Sample Task" | "2023-07-31" | "false"         | 200                | "PostActivitySchema.json"|

  Scenario Outline: Create a new activity with invalid data (title is empty)
    Given User provides an activity title <title>, due date <dueDate>, and completed status <completedStatus>
    When  User sends a POST request to create an activity
    Then  The response code should be <expectedStatusCode>
    Examples:
      | title         | dueDate      | completedStatus | expectedStatusCode |
      | ""            | "2023-07-31" | "false"         | 400                |