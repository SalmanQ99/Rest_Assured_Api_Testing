Feature: Integration Test Between Book and Author

  Scenario Outline: User creates book and creates author and validates data
    Given User provides book title <title>, description <description>, page count <pageCount>, excerpt <excerpt>, and publish date <publishDate>
    When  User sends a POST request to create a book
    Then  The response code should be <expectedStatusCode>
    Given User provides an author firstname <firstName> lastname <lastName>
    When  User sends a POST request to create an author
    Then  The response code should be <expectedStatusCode>
    And   User gets author by bookId
    Then  The response code should be <expectedStatusCode>
    And   User validates the response with json schema <schemaFileName>
    Then  User verifies authorId in get author by bookId response
    Examples:
      | title   | description| pageCount  | excerpt  | publishDate  | expectedStatusCode | schemaFileName         | firstName| lastName|
      | "title" | "Testing"  | 100        | "Sample" | "2023-07-25" | 200                | "PostAuthorSchema.json"| "Salman" | "Anwar" |

