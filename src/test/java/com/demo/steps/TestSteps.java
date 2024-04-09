package com.demo.steps;

import com.demo.page.Search;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class TestSteps {

    @Autowired
    Search search;

    @Given("open google url: {}")
    public void openGoogleUrlHttpsWwwGoogleCom(String url) {
        search.openUrl(url);
    }

    @When("input {} on search box")
    public void inputSeleniumOnSearchBox(String keyWords) {
        search.inputText(keyWords);
    }

    @And("I click search button")
    public void clickSearchButton(){
        search.clickSearchButton();
    }


    @Then("I am on search results page")
    public void see() {
        search.verifyOnResultsPage();
    }

    @Then("I can see the {}")
    public void verifyOnResultsPage(String keyWords) {
        search.verifyOnResultsPage();
    }
}
