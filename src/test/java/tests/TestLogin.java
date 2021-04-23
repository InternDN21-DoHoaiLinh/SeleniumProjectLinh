package tests;


import helpers.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

public class TestLogin extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(testName = "TC01_LOGIN", description = "Login with valid username and password")
    public void TC01() {
        System.out.println("TC01 - User can log into Railway with valid username and password");

        homePage.gotoLoginPage();

        loginPage.loginByJSON("src/test/resources/testing data/loginData.json");
    }

    @Test(testName = "TC02_LOGIN", description = "Login with invalid username and password")
    public void TC02() {
        System.out.println("TC02 - An error message displays when user tries to login with invalid credentials");

        homePage.gotoLoginPage();

        loginPage.login(Constant.W_USERNAME, Constant.W_PASSWORD);
        String actualErrorMsg = loginPage.getErrorMsg();
        String expectedErrorMsg = Constant.LOGIN_ERROR_MESSAGE;

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }

    @Test(testName = "TC03_LOGIN", description = "Login without password")
    public void TC03() {
        System.out.println("TC03 - An error message displays when user tries to login without password");

        homePage.gotoLoginPage();

        loginPage.login(Constant.W_USERNAME, "");

        String actualErrorMsg = loginPage.getPasswordErrorMsg();
        String expectedErrorMsg = Constant.PASSWORD_ERROR_MESSAGE;

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }
}