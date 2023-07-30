package api.test.stepsdefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import java.io.File;
import static api.test.service.ActivityEndPoints.getActivitiesURL;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static api.test.stepsdefinitions.CommonStepDefinition.response;

public class GetActivityStepsDefinition {

    @Given("User request Activity details")
    public void requestActivityDetails() {
        response = RestAssured.given().config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames().relaxedHTTPSValidation()))
                .when().contentType(ContentType.JSON).get(getActivitiesURL);
    }

    @And("User validates the response with JSON schema {string}")
    public void validateTheResponseWithJSONSchema(String filepath) {
        String activityBody = response.getBody().asString();
        assertThat(activityBody, JsonSchemaValidator.matchesJsonSchema(new File(ClassLoader.getSystemResource(filepath).getPath())));
    }
    @Then("The Title should be {string}")
    public void matchTitle(String title) {
        assertTrue(response.getBody().asString().contains(title));
    }

    @When("User makes a request to view Activity with id {int}")
    public void requestToGetActivityById(int id) {
        response = RestAssured.given().
                config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames().relaxedHTTPSValidation())).
                get(getActivitiesURL);
    }

    @And("The response body contain id {int} title {string} and completed status {string}")
    public void validateResponseBody(int id, String title, String completed) {
        assertTrue(response.getBody().asString().contains(String.valueOf(id)));
        assertTrue(response.getBody().asString().contains(title));
        assertTrue(response.getBody().asString().contains(completed));
    }

    @When("User sends a GET request")
    public void callGETRequest() {
        response = RestAssured.given().
                config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames().relaxedHTTPSValidation())).when().contentType(ContentType.JSON).
                get(getActivitiesURL +"/test");
    }

}



