package com.sparta.serenity.steps;

import com.sparta.serenity.pojos.VideoGameResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.rest.SerenityRest.*;
import static net.serenitybdd.rest.SerenityRest.then;
import static net.thucydides.core.environment.SystemEnvironmentVariables.createEnvironmentVariables;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetSingleVideoGameSteps {
    @Given("I am using the VideoGame API")
    public void iAmUsingTheVideoGameAPI() {
        given().baseUri(createEnvironmentVariables().getProperty("videogamedb.api.url"));
    }

    @When("I look up the ID {string}")
    public void iLookUpTheID(String ID) {
        when().get(createEnvironmentVariables().getProperty("videogamedb.api.basepath")+ ID);
    }

    @Then("I should get a {int} response code")
    public void iShouldGetAResponseCode(int expected) {
        then().statusCode(expected);
    }

    @And("the returned name should be {string}")
    public void theReturnedNameShouldBe(String expected) {
//VideoGameResponse response = lastResponse().as( VideoGameResponse.class);
   // assertThat(response.getName(),equalTo(expected));
    then().body("name",equalTo(expected));
    }

    @And("the rating should be {string}")
    public void theRatingShouldBe(String expected) {
        then().body("rating", equalTo(expected));
    }

    @And("the reviewScore should be {int}")
    public void theReviewScoreShouldBe(int  expected) {
        then().body("reviewScore", equalTo(expected));
    }
}
