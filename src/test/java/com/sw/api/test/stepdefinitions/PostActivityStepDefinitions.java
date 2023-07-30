package com.sw.api.test.stepdefinitions;

import com.sw.api.test.dto.PostActivityDTO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;

import static com.sw.api.test.utility.Endpoints.postActivityURL;

public class PostActivityStepDefinitions {
    private PostActivityDTO postactivitydto;

    @Given("User provides an activity title {string}, due date {string}, and completed status {string}")
    public void setData(String title, String dueDate, String completedStatus) {
        boolean completed = Boolean.parseBoolean(completedStatus);
        postactivitydto = new PostActivityDTO(title, dueDate, completed);
    }

    @When("User sends a POST request to create an activity")
    public void callCreateActivityAPI() {
        CommonStepDefinitions.response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(postactivitydto)
                .when().config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames().relaxedHTTPSValidation())).when().contentType(ContentType.JSON)
                .post(postActivityURL);
    }
}




