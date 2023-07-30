package com.sw.api.test.stepdefinitions;

import com.sw.api.test.utility.Endpoints;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;

/**
 * This class contains the step to delete an activity by id
 */
public class DeleteActivityStepDefinitions {
    /**
     * Sends a deletes request activities api with id
     * @param id is set to delete specific record
     */
    @When("User hits the delete com.sw.api with id {int}")
    public void callDeleteAPI(int id) {
        CommonStepDefinitions.response = RestAssured.given().when().config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames().relaxedHTTPSValidation()))
                .delete(Endpoints.deleteActivityURL + "/" + id);
    }


}
