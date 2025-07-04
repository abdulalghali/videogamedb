package com.sparta.serenity.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.*;
import static net.thucydides.core.environment.SystemEnvironmentVariables.createEnvironmentVariables;

public class CreateVideoGameSteps {

    private RequestSpecification request;
//    private RequestSpecification request1;
    private Response response;

    @Given("I am using the VideoGamedb API")
    public void iAmUsingTheVideoGamedbAPI() {
//        Map<String, Object> body = new HashMap<>();
//
//        body.put("password", "admin");
//        body.put("username", "admin");

//        request1 = given().baseUri(createEnvironmentVariables().getProperty("videogamedb.api.url"))
//                .basePath(createEnvironmentVariables().getProperty("videogamedb.api.token"))
//                .contentType(ContentType.JSON)

        request = given()
                .baseUri(createEnvironmentVariables().getProperty("videogamedb.api.url"))
                .basePath(createEnvironmentVariables().getProperty("videogamedb.api.basepath"))
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTc1MTYzNzQ0OCwiZXhwIjoxNzUxNjQxMDQ4fQ.irqEj7pJ7uHxrRMVDxAJN8xhoX5Br6SuvK-RTRa0sM8");
    }

    @And("I have a valid video game request body")
    public void iHaveAValidVideoGameRequestBody() {
        Map<String, Object> body = new HashMap<>();

        body.put("name", "GTA 7");
        body.put("releaseDate", "2040-05-04");
        body.put("reviewScore", 14);
        body.put("category", "Platform");
        body.put("rating", "Mature");

        request.body(body);
    }

    @When("I Create a video game")
    public void iCreateAVideoGame() {
        response = request.post();
        response.then().log().all();

    }

    @Then("I should get a {int} response code")
    public void iShouldGetAResponseCode(int code) {
        then().statusCode(code);
    }
}
