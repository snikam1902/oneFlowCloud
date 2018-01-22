package com.Oneflow;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CommonUtils;

import java.io.IOException;

/**
 * Created by shweta on 21/01/2018.
 */
public class LoginPage extends BasePage {

    @FindBy(xpath = "//div[@class='at-title']/h3")
    WebElement signInText;
    @FindBy(id = "at-field-username_and_email")
    WebElement userName;
    @FindBy(id = "at-field-password")
    WebElement password;
    @FindBy(id = "at-btn")
    WebElement submitBtn;
    @FindBy(id= "at-signUp")
    WebElement registerLink;
    @FindBy(id="at-forgotPwd")
    WebElement forgetPwdLink;

    public String isLoginPage() {
        String signIn = signInText.getText();
        return signIn;
    }

    //This method is to enter username and password to login
    public void provideUserNameNPassword(String usrNmae, String pwd) throws IOException {
      try {
          userName.clear();
          userName.sendKeys(usrNmae);
          password.clear();
          password.sendKeys(pwd);
          submitBtn.click();
      }catch (Exception e)
      {
          CommonUtils.captureScreenshot("unable to enter login Details");
      }
    }

    public void gotoRegisterPage() throws IOException {
        try {
            registerLink.click();
        }catch (Exception e)
        {
            CommonUtils.captureScreenshot("unable to goto Registration page");
        }
    }

    public void gotoForgotPasswordPage() throws IOException {
        try {
            forgetPwdLink.click();
        }catch (Exception e)
        {
            CommonUtils.captureScreenshot("unable to goto forget password page");
        }
    }
}
