package com.Oneflow;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CommonUtils;

import java.io.IOException;

/**
 * Created by shweta on 21/01/2018.
 */
public class ForgotPasswordPage extends BasePage {

    @FindBy(id = "at-field-email")
    WebElement emailField;

    @FindBy(id = "at-btn")
    WebElement sentBtn;

    //This method is to enter email id for forgot password
    public void enterEmail(String emails) throws InterruptedException, IOException {
     try {
         emailField.sendKeys(emails);
         sentBtn.click();
         CommonUtils.sleep(2);
     }catch (Exception e)
     {
         CommonUtils.captureScreenshot("unable to do ForgetPasswordLink");
     }
    }


}
