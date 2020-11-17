package com.automatedtest.sample.searchresultpage;

import com.automatedtest.sample.basepage.BasePage;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage extends BasePage {

    private static final String firstResult = "[data-index='2']";
    public static String productTitle;

    @FindBy(css = firstResult)
    WebElement result1;

    SearchResultPage() {
        PageFactory.initElements(driver, this);
    }

    boolean isInResults() {
        $(result1).waitUntil(Condition.visible, 5000);
        return result1.isDisplayed();
    }

    void clickOption(String option) {
        String modifiedCss = itemSelector(option);
        getProductTitle(modifiedCss + " h2");
        WebElement selected = driver.findElement(By.cssSelector(modifiedCss));
        $(selected).click();
    }

    void getProductTitle(String selectedOption) {
        productTitle = driver.findElement(By.cssSelector(selectedOption)).getText();
    }

    String itemSelector(String option) {
        String optionModified = String.valueOf(Integer.parseInt(option) + 1);
        return firstResult.replace("2", optionModified);
    }
}

