package tests;

import common.Log;
import helpers.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

public class TestLogin extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "User can log into Railway with valid username and password")
    public void TC01() {
        Log.startTestCase("TC01");

        Log.info("> Go to Login Page");
        homePage.goToLogin();

        Log.info("> Login with valid email and password");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        Log.info("> Verify the welcome message");
        Assert.assertEquals(homePage.getWelcomeMsg(), "Welcome " + Constant.USERNAME, "Welcome message not match!");
    }
}
