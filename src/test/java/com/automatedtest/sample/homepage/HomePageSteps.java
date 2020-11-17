package com.automatedtest.sample.homepage;

import com.automatedtest.sample.infrastructure.driver.Setup;
import com.automatedtest.sample.infrastructure.driver.TearDown;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.qameta.allure.Step;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class HomePageSteps {


    private HomePage homePage;

    public HomePageSteps() {
        this.homePage = new HomePage();
    }


    @Step("Navitation to Amazon page")
    @Given("A user navigates to Amazon web page")
    public void aUserNavigatesToHomePage() {
        this.homePage.goToHomePage();
    }

    @Step("Check Amazon Logo")
    @Then("Amazon Logo is displayed")
    public void amazonLogoIsDisplayed() {
        this.homePage.checkLogoDisplay();
    }

    @Step("Check page title")
    @Then("page title contains {string}")
    public void pageTitleIs(String title) {
        String displayedTitle = this.homePage.getTitle();
        /*Assert.assertTrue("Displayed title is " + displayedTitle + " instead of " + title,
                title.contains(displayedTitle));*/
        Assert.assertThat(displayedTitle, CoreMatchers.containsString(title));

    }

    @Step("Search for a item")
    @When("a user searches for {string}")
    public void aUserSearchesFor(String searchValue) {
        this.homePage.searchFor(searchValue);
    }

}
