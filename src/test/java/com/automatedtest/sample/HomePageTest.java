package com.automatedtest.sample;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/com/automatedtest/sample/Home_page.feature"},
        strict = true, plugin = {"pretty",
        "json:target/cucumber_json_reports/home-page.json",
        "html:target/home-page-html"},
        glue = {"com.automatedtest.sample.infrastructure.driver",
                "com.automatedtest.sample.homepage",
                "com.automatedtest.sample.searchresultpage",
                "com.automatedtest.sample.productPage",
                "com.automatedtest.sample.cartPage",

        })
public class HomePageTest {
}
