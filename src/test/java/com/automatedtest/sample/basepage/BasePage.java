package com.automatedtest.sample.basepage;

import com.automatedtest.sample.infrastructure.driver.Setup;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        this.driver = Setup.driver;
    }
}
