package com.automatedtest.sample.cartPage;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.junit.Assert;

public class cartPageSteps {

    private CartPage cartPage;

    public cartPageSteps() {
        this.cartPage = new CartPage();
    }

    @Step("Open cart page")
    @And("user navigates to cart page")
    public void userNavigatesToCartPage() {
        this.cartPage.goToCartPageButton();
    }

    @Step("Check quantity of items")
    @Then("user check quantity of items is {string}")
    public void userCheckQuantityOfItemsIs(String items) {
        String products = this.cartPage.languageText();
        Assert.assertEquals("Subtotal (" + items + " " + products +"):", this.cartPage.checkItemQuantity("footer"));
        Assert.assertEquals("Subtotal (" + items + " " + products +"):", this.cartPage.checkItemQuantity("buyBox"));
    }

    @Step("Check the price for items added in footer and buy box")
    @And("user checks the price is correct for {int} items added")
    public void userChecksThePriceIsCorrectForItems(int items) {
        Double price = this.cartPage.priceForUnits(items);
        this.cartPage.updateCartPrice(price);
        Assert.assertEquals(this.cartPage.checkPrice("footer"), this.cartPage.getPriceUpdated());
        Assert.assertEquals(this.cartPage.checkPrice("buyBox"), this.cartPage.getPriceUpdated());
    }

    @Step("Check total of items in footer adn buy box")
    @When("user change total items from first item added to {int}")
    public void userChangeTotalItemsFromFirstItemAddedTo(int number) throws InterruptedException {
        this.cartPage.changeItemNumber(number);
    }

    @Step("Check price updated after changed quantity of items")
    @And("total price is updated for {int} hat for men and {int} hat for women")
    public void totalPriceIsUpdatedWithOneUnitByItem(int hatMen, int hatWomen) {
        this.cartPage.updatedCartPrice(hatMen, hatWomen);
        Assert.assertEquals(this.cartPage.checkPrice("footer"), this.cartPage.getPriceUpdated());
        Assert.assertEquals(this.cartPage.checkPrice("buyBox"), this.cartPage.getPriceUpdated());
    }
}
