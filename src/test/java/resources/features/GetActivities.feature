Feature:Testing swagger Get API

  Scenario Outline: Verify get activity API with valid end_point

    Given User request Activity details
    Then  The response code for get api should be <expectedstatuscode>
    And   User validates the response with JSON schema <jsonfile>
    Then  The Title should be <title>
    Examples:
      | expectedstatuscode | title        |  jsonfile |
      | 200                | "Activity 1" |    "getActivity.json" |

    Scenario: Verify get activity API with parameter id

      Given Access to endpoint "/Activities"
      When  I makes a request to view Activity id 1
      Then  The response code for id-1 should be 200
      And   The response body contain id "1" title "Activity 1" and completed status "false"


  Scenario: Invalid Endpoint Returns 404 Not Found

    Given User has an invalid endpoint
    When  User sends a GET request
    Then  The response code for invalid end_point should be 404