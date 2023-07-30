package com.sw.api.test.stepdefinitions;

import com.sw.api.test.utility.Endpoints;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;

import static org.junit.Assert.assertTrue;

/**
 * This class contains the steps for get all activities and get activity by id
 */
public class GetActivityStepDefinitions {

    /**
     * Gets details of all activities
     */
    @Given("User requests activity details")
    public void requestActivityDetails() {
        CommonStepDefinitions.response = RestAssured.given().config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames().relaxedHTTPSValidation()))
                .when().contentType(ContentType.JSON).get(Endpoints.getActivitiesURL);
    }
    /**
     * Validates the title
     * @param title activity title
     */
    @Then("The title should be {string}")
    public void validateTitle(String title) {
        assertTrue(CommonStepDefinitions.response.getBody().asString().contains(title));
    }

    /**
     * Gets activity by id
     * @param id get activity parameter
     */
    @When("User makes a request to get activity with id {int}")
    public void callGetActivityByIdAPI(int id) {
        CommonStepDefinitions.response = RestAssured.given().
                config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames().relaxedHTTPSValidation())).
                get(Endpoints.getActivitiesURL);
    }

    /**
     * Validates get activity by id response body
     * @param id response id
     * @param title response title
     * @param completed response completed
     */
    @And("The response body should contain id {int} title {string} and completed status {string}")
    public void validateGetActivityResponseBody(int id, String title, String completed) {
        assertTrue(CommonStepDefinitions.response.getBody().asString().contains(String.valueOf(id)));
        assertTrue(CommonStepDefinitions.response.getBody().asString().contains(title));
        assertTrue(CommonStepDefinitions.response.getBody().asString().contains(completed));
    }

}



