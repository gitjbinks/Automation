package com.automatedtest.sample.searchresultpage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.junit.Assert;

public class SearchResultPageSteps {

    private SearchResultPage searchResultPage;

    public SearchResultPageSteps() {
        this.searchResultPage = new SearchResultPage();
    }

    @Step("Check results page loaded")
    @Then("results are shown")
    public void resultsAreShown() {
        Assert.assertTrue(this.searchResultPage.isInResults());
    }

    @Step("Select the item")
    @When("the user click option in position {string}")
    public void theUserClickOptionInPosition(String position) {
        this.searchResultPage.clickOption(position);
    }
}
