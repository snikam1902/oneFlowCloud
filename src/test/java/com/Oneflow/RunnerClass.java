package com.Oneflow;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

/**
 * Created by shweta on 21/01/2018.
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/",
        format = "html:target/CucumberReports",
        tags = "@test1,@test5")

public class RunnerClass {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        BrowserFactory.openBrowser();
        driver = BrowserFactory.getDriver();
    }

    @AfterClass

    public static void tearDown() {
        BrowserFactory.stopBrowser();
    }
}
