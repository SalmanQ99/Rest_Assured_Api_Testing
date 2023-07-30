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

public class BookAuthorStepDefinitions {
    private BookPostDTO bookPostRequestDTO;
    private PostAuthorDTO postAuthorRequestDTO;
    private int postAuthorResponseAuthorId;

    private int postAuthorResponseBookId;

    @Given("User provides book title {string}, description {string}, page count {int}, excerpt {string}, and publish date {string}")
    public void setBookData(String title, String description, int pageCount, String excerpt, String publishDate) {
        bookPostRequestDTO = new BookPostDTO(title, description, pageCount, excerpt, publishDate);
    }

    @Given("User provides an author firstname {string} lastname {string}")
    public void setAuthorData(String firstName, String lastName) {
        int bookId = CommonStepDefinitions.response.body().jsonPath().getInt("id");
        postAuthorRequestDTO = new PostAuthorDTO(bookId, firstName, lastName);
    }

    @When("User sends a POST request to create a book")
    public void callCreateBookAPI() {
        CommonStepDefinitions.response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(bookPostRequestDTO)
                .when().config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames().relaxedHTTPSValidation()))
                .post(Endpoints.postBookApi);
        System.out.println(CommonStepDefinitions.response.asString());
    }

    @When("User sends a POST request to create an author")
    public void callCreateAuthorAPI() {
        CommonStepDefinitions.response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(postAuthorRequestDTO)
                .when().config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames().relaxedHTTPSValidation()))
                .post(Endpoints.postAuthorApi);
        int bookId = CommonStepDefinitions.response.body().jsonPath().getInt("idBook");
        System.out.println(bookId);
        System.out.println(CommonStepDefinitions.response.asString());
        postAuthorResponseAuthorId = CommonStepDefinitions.response.body().jsonPath().getInt("id");
    }

    @And("User gets author by bookId")
    public void callAuthorByBookIdAPI() {
        postAuthorResponseBookId = CommonStepDefinitions.response.body().jsonPath().getInt("idBook");
        CommonStepDefinitions.response = RestAssured.given().config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames().relaxedHTTPSValidation()))
                .get(Endpoints.getAuthorByBookId + "/" + postAuthorResponseBookId);
    }

    @Then("User verifies authorId in get author by bookId response")
    public void userVerifiesAuthorIdInGetAuthorByBookIdResponse() {
        System.out.println("getAuthorByBookId " + CommonStepDefinitions.response.asString());
        int authorId = CommonStepDefinitions.response.body().jsonPath().getInt("id");
        assertEquals(postAuthorResponseAuthorId, authorId);
        int postAuthorResponseBookId = CommonStepDefinitions.response.body().jsonPath().getInt("idBook");
        assertEquals(postAuthorResponseBookId, postAuthorResponseBookId);
    }
}
