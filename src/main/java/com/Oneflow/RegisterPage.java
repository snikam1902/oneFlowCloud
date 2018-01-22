package com.Oneflow;

import cucumber.api.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CommonUtils;

import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * Created by shweta on 21/01/2018.
 */
public class RegisterPage extends BasePage {

    @FindBy(id = "at-field-username")
    WebElement userNameTextField;
    @FindBy(id = "at-field-email")
    WebElement emailTextField;
    @FindBy(id = "at-field-password")
    WebElement passwordTextField;
    @FindBy(css = ".select-lang.js-userform-set-language")
    WebElement languageSelect;
    @FindBy(id = "at-btn")
    WebElement registerBtn;

    public void doRegistration(DataTable deatail) throws IOException {
      try {
          List<List<String>> registerDetail = deatail.raw();
          userNameTextField.sendKeys(new Random().nextInt() + registerDetail.get(1).get(0));
          emailTextField.sendKeys(new Random().nextInt() + registerDetail.get(1).get(1));
          passwordTextField.sendKeys(registerDetail.get(1).get(2));
          CommonUtils.selectByText(languageSelect, registerDetail.get(1).get(3));
          registerBtn.submit();
      }catch (Exception e)
      {
          CommonUtils.captureScreenshot("unable to do Regidtration");
      }
    }
}