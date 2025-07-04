package com.sparta.serenity.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.rest.RestRequests.given;
import static net.serenitybdd.rest.RestRequests.when;
import static net.serenitybdd.rest.SerenityRest.then;
import static net.thucydides.core.environment.SystemEnvironmentVariables.createEnvironmentVariables;

public class GetAllGamesSteps {
    @Given("I am using the video game API")
    public void iAmUsingTheVideoGameAPI() {
        given().baseUri(createEnvironmentVariables().getProperty("videogamedb.api.url"));
    }

    @When("I look up the all video games")
    public void iLookUpTheAllVideoGames() {
        when().get(createEnvironmentVariables().getProperty("videogamedb.api.basepath"));
    }



}