package com.Oneflow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserFactory;

/**
 * Created by shweta on 21/01/2018.
 */
public class BasePage extends BrowserFactory {
    WebDriver driver = BrowserFactory.getDriver();
    BasePage() {
        PageFactory.initElements(driver, this);
    }
}
