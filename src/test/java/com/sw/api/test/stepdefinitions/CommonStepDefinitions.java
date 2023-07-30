package com.sw.api.test.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class CommonStepDefinitions {

    public static Response response;

    @Then("The response code should be {int}")
    public void validateResponseCode(int expectedstatuscode) {
        int actualStatusCode = response.getStatusCode();
        assertEquals(expectedstatuscode, actualStatusCode);
    }

    @And("User validates the response with json schema {string}")
    public void validateTheResponseBodyWithJsonSchema(String fileName) {
        String postActivityBody = response.getBody().asString();
        assertThat(postActivityBody, JsonSchemaValidator.matchesJsonSchema(new File(ClassLoader.getSystemResource(fileName).getPath())));
    }
}
