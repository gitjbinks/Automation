package com.automatedtest.sample.cartPage;

import com.automatedtest.sample.basepage.BasePage;
import com.automatedtest.sample.infrastructure.driver.Setup;
import com.automatedtest.sample.productPage.ProductPage;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.automatedtest.sample.infrastructure.driver.Setup.browser;
import static com.automatedtest.sample.productPage.ProductPage.firstItemUnitPrice;
import static com.automatedtest.sample.productPage.ProductPage.secondItemUnitPrice;
import static com.codeborne.selenide.Selenide.$;


public class CartPage extends BasePage {

    private static Double priceUpdated = 0.0;

    @FindBy(id = "hlb-view-cart-announce")
    WebElement cartButton;
    @FindBy(id = "sc-subtotal-label-activecart")
    WebElement quantityItemNumber;
    @FindBy(id = "sc-subtotal-amount-activecart")
    WebElement SubtotalCart;
    @FindBy(id = "sc-subtotal-amount-buybox")
    WebElement BuyBoxSubtotal;
    @FindBy(id = "sc-subtotal-label-buybox")
    WebElement BuyBoxItemNumber;
    @FindBy(css = "[data-item-count='2'] [name=quantity]")
    WebElement DropdownFirstItemAdded;

    CartPage() {
        PageFactory.initElements(driver, this);
    }

    void goToCartPageButton() {
        $(cartButton).waitUntil(Condition.visible, 5000).click();
    }

    String checkItemQuantity(String point) {
        $(quantityItemNumber).waitUntil(Condition.visible, 5000);
        String value;
        switch (point) {
            case "footer":
                value = quantityItemNumber.getText();
                break;
            case "buyBox":
                value = BuyBoxItemNumber.getText();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + point);
        }
        return value;
    }

    Double checkPrice(String point) {
        String price = checkerPoints(point);
        double valueToReturn;
        if (Setup.lang.equals("es-SP")) {
            String[] currencyAdnPrice = price.split(" ");
            valueToReturn = Double.parseDouble(currencyAdnPrice[1]);
            } else {
            valueToReturn = Double.parseDouble(price.substring(1));
           }
            return valueToReturn;
        }

        Double priceForUnits ( int number){
            return ProductPage.unitPrice * number;
        }

        String checkerPoints (String point){
            String value;
            switch (point) {
                case "footer":
                    value = SubtotalCart.getText();
                    break;
                case "buyBox":
                    value = BuyBoxSubtotal.getText();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + point);
            }
            return value;
        }

        void updateCartPrice (Double update){
            priceUpdated = priceUpdated + update;
        }

        Double getPriceUpdated () {
            return priceUpdated = Math.round(priceUpdated * 100.0) / 100.0;
        }

        public void changeItemNumber ( int number) throws InterruptedException {
            if (browser.equals("chrome")) {
                $(DropdownFirstItemAdded).waitUntil(Condition.visible, 5000);
                $(DropdownFirstItemAdded).selectOption(number);
            } else {
                String optionNumber = Integer.toString(number);
                $(DropdownFirstItemAdded).waitUntil(Condition.visible, 5000);
                Actions actions = new Actions(driver);
                actions.moveToElement(DropdownFirstItemAdded).click().build().perform();
                Thread.sleep(2000);
                WebElement amount = driver.findElement(By.cssSelector("#dropdown1_" + optionNumber));
                $(amount).click();
            }
            Thread.sleep(1000);
        }

        void updatedCartPrice ( int hatMen, int hatWomen){
            priceUpdated = (hatMen * firstItemUnitPrice) + (hatWomen * secondItemUnitPrice);
        }

        public String languageText () {
            //return "productos";
            return (Setup.lang.equals("es-SP")) ? "productos" : "items";
        }
    }
