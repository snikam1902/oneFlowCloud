package com.Oneflow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utils.CommonUtils;

import java.io.IOException;

/**
 * Created by shweta on 21/01/2018.
 */
public class DashboardPage extends BasePage {

    @FindBy(xpath = "//div[@id='header-main-bar']/h1")
    WebElement welcomeText;

    @FindBy(id = "header-user-bar")
    WebElement headerBar;

    @FindBy(className = "js-logout")
    WebElement logOut;

    //This methos is to get welcome text on Dashboard page
    public String userIsInDashBoardWelcome()  {
        String dashBoardWelcomeText = welcomeText.getText();
        return dashBoardWelcomeText;
    }

    //This method is to do logout
    public void doLogOut() throws IOException {
       try {
           headerBar.click();
           logOut.click();
       }catch (Exception e)
       {
           CommonUtils.captureScreenshot("unableToDoLogout");
       }
    }
}
