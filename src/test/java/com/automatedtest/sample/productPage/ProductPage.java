package com.automatedtest.sample.productPage;

import com.automatedtest.sample.basepage.BasePage;
import com.automatedtest.sample.infrastructure.driver.Setup;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.automatedtest.sample.infrastructure.driver.Setup.browser;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage extends BasePage {

    public static Double unitPrice = 0.0;
    public static Double firstItemUnitPrice = 0.0;
    public static Double secondItemUnitPrice = 0.0;

    @FindBy(css = "#productTitle")
    WebElement productTitle;
    @FindBy(id = "price_inside_buybox")
    WebElement price;
    @FindBy(id = "quantity")
    WebElement quantityDropDown;
    @FindBy(id = "add-to-cart-button")
    WebElement addToCart;
    @FindBy(css = ".a-active")
    public static WebElement option;


    ProductPage() {
        PageFactory.initElements(driver, this);
    }

    String productPage() {
        $(productTitle).waitUntil(Condition.visible, 5000);
        return productTitle.getText();
    }

    void saveUnitPrice() {
        $(price).waitUntil(Condition.visible, 5000);
        String uPrice = price.getText();
        String currency_Price;
        if(Setup.lang.equals("es-SP")) {
            String[] split = uPrice.split(" ");
            currency_Price = split[1];
        } else {
            currency_Price = uPrice.substring(1);
        }

        if (firstItemUnitPrice.equals(0.0))
            firstItemUnitPrice = Double.parseDouble(currency_Price);
        else
            secondItemUnitPrice = Double.parseDouble(currency_Price);
        unitPrice = Double.parseDouble(currency_Price);
    }

    void addUnits(String quantity) throws InterruptedException {
        if (!quantity.equals("1")) {
            if (browser.equals("chrome")) {
                $(quantityDropDown).selectOption(quantity);
                $(option).click();
            } else {
                $(quantityDropDown).waitUntil(Condition.visible,5000);
                Actions actions = new Actions(driver);
                actions.moveToElement(quantityDropDown).click().build().perform();
                int restOne = Integer.parseInt(quantity) - 1;
                String elementToClick = "#quantity_" + restOne;
                Thread.sleep(2000);
                driver.findElement(By.cssSelector(elementToClick)).click();
            }
        }
    }

    public void addToCart() {
        addToCart.click();
    }
}
