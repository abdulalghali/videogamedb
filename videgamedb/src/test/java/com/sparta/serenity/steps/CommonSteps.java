package com.sparta.serenity.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.rest.SerenityRest.*;
import static net.thucydides.core.environment.SystemEnvironmentVariables.createEnvironmentVariables;
import static org.hamcrest.Matchers.equalTo;

public class CommonSteps {
    @Then("I should get a {int} response code")
    public void iShouldGetAResponseCode(int expected) {
        then().statusCode(expected);
    }
}
