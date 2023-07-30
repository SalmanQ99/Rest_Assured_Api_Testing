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

public class GetActivityStepDefinitions {

    /**
     * This method to get activity details
     */

    @Given("User requests activity details")
    public void requestActivityDetails() {
        CommonStepDefinitions.response = RestAssured.given().config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames().relaxedHTTPSValidation()))
                .when().contentType(ContentType.JSON).get(Endpoints.getActivitiesURL);
    }
    /**
     * This method to get activity details
     * @param title
     */
    @Then("The title should be {string}")
    public void validateTitle(String title) {
        assertTrue(CommonStepDefinitions.response.getBody().asString().contains(title));
    }

    @When("User makes a request to get activity with id {int}")
    public void callGetActivityByIdAPI(int id) {
        CommonStepDefinitions.response = RestAssured.given().
                config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames().relaxedHTTPSValidation())).
                get(Endpoints.getActivitiesURL);
    }

    @And("The response body should contain id {int} title {string} and completed status {string}")
    public void validateGetActivityResponseBody(int id, String title, String completed) {
        assertTrue(CommonStepDefinitions.response.getBody().asString().contains(String.valueOf(id)));
        assertTrue(CommonStepDefinitions.response.getBody().asString().contains(title));
        assertTrue(CommonStepDefinitions.response.getBody().asString().contains(completed));
    }

}



