package com.sw.api.test.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * This class contains static variable <STRONG>response</STRONG> which is used to store response of any Rest API.
 * This class also has two methods which are used in other step definition files
 */
public class CommonStepDefinitions {
    /**
     * The Response object representing the HTTP response received from the server.
     */
    public static Response response;

    /**
     * Validates the http response code
     * @param expectedstatuscode is define in feature file
     */

    @Then("The response code should be {int}")
    public void validateResponseCode(int expectedstatuscode) {
        int actualStatusCode = response.getStatusCode();
        assertEquals(expectedstatuscode, actualStatusCode);
    }

    /**
     * Validates the http response body with json schema
     * @param fileName is defined in feature file
     */
    @And("User validates the response with json schema {string}")
    public void validateTheResponseBodyWithJsonSchema(String fileName) {
        String postActivityBody = response.getBody().asString();
        assertThat(postActivityBody, JsonSchemaValidator.matchesJsonSchema(new File(ClassLoader.getSystemResource(fileName).getPath())));
    }
}
