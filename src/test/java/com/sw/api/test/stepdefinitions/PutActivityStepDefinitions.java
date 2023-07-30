package com.sw.api.test.stepdefinitions;

import com.sw.api.test.utility.Endpoints;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * This class contains the steps for update an activity by id
 */
public class PutActivityStepDefinitions {

    /**
     * Sets data for put activity api by id
     * @param id endpoint
     * @param title for update title
     */
    @When("User updates the Activity with id {int} with a new title {string}")
    public void callPutAPIToUpdateTitle(int id, String title) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("id", id);
        requestBody.put("title", title);
        CommonStepDefinitions.response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when().config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames().relaxedHTTPSValidation()))
                .put(Endpoints.putActivityURL + "/" + id);
    }
    /**
     * Validates the updated title with put api response body
     * @param title updated title
     */
    @And("The put activity response body should have the updated title {string}")
    public void verifyUpdatedTitle(String title) {
        assertTrue(CommonStepDefinitions.response.getBody().asString().contains(title));
    }


}
