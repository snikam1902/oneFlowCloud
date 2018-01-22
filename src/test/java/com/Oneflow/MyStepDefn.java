package com.Oneflow;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CommonUtils;

/**
 * Created by shweta on 21/01/2018.
 */
public class MyStepDefn {

    DashboardPage dashboardPage = new DashboardPage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    @Given("^user is on the Login page$")
    public void user_is_on_the_Login_page() throws Throwable {
        //String loginPageURLText = loginPage.isLoginPage();
        // Assert.assertEquals("https://test-8c21.oneflowcloud.com/sign-in", loginPageURLText);
        Assert.assertEquals(loginPage.isLoginPage(), "Sign In");

    }

    @When("^user enter username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_enter_username_and_password(String userName, String pswd) throws Throwable {
        loginPage.provideUserNameNPassword(userName, pswd);

    }

    @Then("^user shoud be able to login$")
    public void user_shoud_be_able_to_login() throws Throwable {
        String welcomeMessage = dashboardPage.userIsInDashBoardWelcome();
        Assert.assertEquals("My Boards", welcomeMessage);
        dashboardPage.doLogOut();
    }

    @When("^user enter invalid  \"([^\"]*)\" and invalid \"([^\"]*)\"$")
    public void user_enter_invalid_and_invalid(String invalidUser, String invalidPwd) throws Throwable {
        loginPage.provideUserNameNPassword(invalidUser, invalidPwd);

    }


    @Then("^user should get error \"([^\"]*)\"$")
    public void user_should_get_error(String errorMessage) throws Throwable {
        String errorMsg = CommonUtils.getText(By.xpath("//div[@class='at-error']/p"));
        Assert.assertEquals(errorMessage, errorMsg);

    }


    @Given("^new user is on the Login page$")
    public void new_user_is_on_the_Login_page() throws Throwable {
        Assert.assertEquals("Sign In", loginPage.isLoginPage());
    }

    @When("^user click on Register link$")
    public void user_click_on_Register_link() throws Throwable {
        loginPage.gotoRegisterPage();
    }

    @When("^enter following credential$")
    public void enter_following_credential(DataTable detail) throws Throwable {
        registerPage.doRegistration(detail);
    }

    @Then("^User should able login application$")
    public void user_should_able_login_application() throws Throwable {
        String welcomeMsg = dashboardPage.userIsInDashBoardWelcome();
        Assert.assertEquals("My Boards", welcomeMsg);
        dashboardPage.doLogOut();
    }


    @When("^user click on forgot password$")
    public void user_click_on_forgot_password() throws Throwable {
        loginPage.gotoForgotPasswordPage();
    }

    @When("^enter valid \"([^\"]*)\"$")
    public void enter_valid(String valiEmail) throws Throwable {
        forgotPasswordPage.enterEmail(valiEmail);
    }

    @Then("^password is sent to email$")
    public void password_is_sent_to_email() throws Throwable {
        String messageSent = CommonUtils.getText(By.className("at-form"));
        messageSent.contains("Email sent");

    }


}
