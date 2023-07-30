package com.sw.api.test.stepdefinitions;

import com.sw.api.test.dto.PostAuthorDTO;
import com.sw.api.test.utility.Endpoints;
import com.sw.api.test.dto.BookPostDTO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;

import static org.junit.Assert.assertEquals;
/**
 * This class contains the steps of integration test between book and author
 */

public class BookAuthorStepDefinitions {
    /**
     * Represents a Data Transfer Object (DTO) for creating a new book
     */
    private BookPostDTO bookPostRequestDTO;
    /**
     * Represents a Data Transfer Object (DTO) for creating a new author
     */
    private PostAuthorDTO postAuthorRequestDTO;
    /**
     * The object store post author response
     */
    private int postAuthorResponseAuthorId;
    /**
     * The object store get author by book id response
     */

    private int postAuthorResponseBookId;
    /**
     * Sets data for post book api
     * @param title title of the book
     * @param description book description
     * @param pageCount  number of pages in book
     * @param excerpt short description
     * @param publishDate book publish date and time
     */
    @Given("User provides book title {string}, description {string}, page count {int}, excerpt {string}, and publish date {string}")
    public void setBookData(String title, String description, int pageCount, String excerpt, String publishDate) {
        bookPostRequestDTO = new BookPostDTO(title,description,pageCount,excerpt,publishDate);
    }
    /**
     * Sets data for post author api
     * @param firstName author firstname
     * @param lastName author lastname
     */
    @Given("User provides an author firstname {string} lastname {string}")
    public void setAuthorData(String firstName, String lastName) {
        int bookId = CommonStepDefinitions.response.body().jsonPath().getInt("id");
        postAuthorRequestDTO = new PostAuthorDTO(bookId, firstName, lastName);
    }
    /**
     * Sends a post request to create a book
     */
    @When("User sends a POST request to create a book")
    public void callCreateBookAPI() {
        CommonStepDefinitions.response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(bookPostRequestDTO)
                .when().config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames().relaxedHTTPSValidation()))
                .post(Endpoints.postBookApi);
    }
    /**
     * Sends a post request to create an author
     */
    @When("User sends a POST request to create an author")
    public void callCreateAuthorAPI() {
        CommonStepDefinitions.response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(postAuthorRequestDTO)
                .when().config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames().relaxedHTTPSValidation()))
                .post(Endpoints.postAuthorApi);
        postAuthorResponseAuthorId = CommonStepDefinitions.response.body().jsonPath().getInt("id");
        postAuthorResponseBookId = CommonStepDefinitions.response.body().jsonPath().getInt("idBook");
    }
    /**
     * Sends a get request to get author by book id
     */
    @And("User gets author by bookId")
    public void callAuthorByBookIdAPI() {
        CommonStepDefinitions.response = RestAssured.given().config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames().relaxedHTTPSValidation()))
                .get(Endpoints.getAuthorByBookId + "/" + postAuthorResponseBookId);
    }
    /**
     * Verifies author id in the response of get author by bookId
     */
    @Then("User verifies authorId in get author by bookId response")
    public void userVerifiesAuthorIdInGetAuthorByBookIdResponse() {
        int authorId = CommonStepDefinitions.response.body().jsonPath().getInt("id");
        assertEquals(postAuthorResponseAuthorId, authorId);
        int postAuthorResponseBookId = CommonStepDefinitions.response.body().jsonPath().getInt("idBook");
        assertEquals(postAuthorResponseBookId, postAuthorResponseBookId);
    }
}
