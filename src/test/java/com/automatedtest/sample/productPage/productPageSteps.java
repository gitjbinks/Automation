package com.automatedtest.sample.productPage;

import com.automatedtest.sample.searchresultpage.SearchResultPage;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.junit.Assert;

public class productPageSteps {

    private ProductPage ProductPage;

    public productPageSteps() {
        this.ProductPage = new ProductPage();
    }

    @Step("Check is the correct product page")
    @Then("user is in product page")
    public void userIsInProductPage() {
        Assert.assertEquals("The product expected is " + this.ProductPage.productPage() + " and the product found is " + SearchResultPage.productTitle, this.ProductPage.productPage(), SearchResultPage.productTitle);
        this.ProductPage.saveUnitPrice();
    }

    @Step("Add the item to the cart")
    @Then("user add {string} units to cart")
    public void userAddUnitsToCart(String quantity) throws InterruptedException {
        this.ProductPage.addUnits(quantity);
        this.ProductPage.addToCart();
    }
}
