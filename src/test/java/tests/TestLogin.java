package tests;


import helpers.constants.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

public class TestLogin extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void TC01() {
        System.out.println("TC01 - User can log into Railway with valid username and password");

        homePage.open();
        homePage.gotoLoginPage();

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        String actualMsg = homePage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
        homePage.logOut();
    }

    @Test
    public void TC02() {
        System.out.println("TC02 - An error message displays when user tries to login with invalid credentials");

        homePage.open();
        homePage.gotoLoginPage();

        loginPage.login(Constant.W_USERNAME, Constant.W_PASSWORD);
        String actualErrorMsg = loginPage.getErrorMsg();
        String expectedErrorMsg = Constant.LOGIN_ERROR_MESSAGE;

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }

    @Test
    public void TC03() {
        System.out.println("TC02 - An error message displays when user tries to login without password");

        homePage.open();
        homePage.gotoLoginPage();

        loginPage.login(Constant.W_USERNAME, "");

        String actualErrorMsg = loginPage.getPasswordErrorMsg();
        String expectedErrorMsg = Constant.PASSWORD_ERROR_MESSAGE;

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }
}
