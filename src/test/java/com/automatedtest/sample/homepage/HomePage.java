package com.automatedtest.sample.homepage;

import com.automatedtest.sample.basepage.BasePage;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.$;


public class HomePage extends BasePage {

    private static final String HOME_PAGE_URL = "https://www.amazon.com";

    @FindBy(css = "#nav-logo")
    WebElement logo;

    @FindBy(css = "#twotabsearchtextbox")
    WebElement searchInput;

    HomePage() {
        PageFactory.initElements(driver, this);
    }

    void goToHomePage() {
        driver.get(HOME_PAGE_URL);
    }

    void checkLogoDisplay() {
        $(logo).waitUntil(Condition.visible, 5000);
    }

    String getTitle() {
        return driver.getTitle();
    }

    void searchFor(String searchValue) {
        this.searchInput.sendKeys(searchValue);
        this.searchInput.sendKeys(Keys.ENTER);
    }
}
