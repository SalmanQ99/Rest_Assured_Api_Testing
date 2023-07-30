package com.sw.api.test.stepdefinitions;

import com.sw.api.test.utility.Endpoints;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;

public class DeleteActivityStepDefinitions {

    @When("User hits the delete com.sw.api with id {int}")
    public void callDeleteAPI(int id) {
        CommonStepDefinitions.response = RestAssured.given().when().config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames().relaxedHTTPSValidation()))
                .delete(Endpoints.deleteActivityURL + "/" + id);
    }


}
