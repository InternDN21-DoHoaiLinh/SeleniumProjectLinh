package tests;


import helpers.Log;
import models.Account;
import helpers.Constant;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;
import helpers.providers.DataProviderClass_Account;

public class TestLogin extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(dataProvider = "validLoginDataProvider", dataProviderClass = DataProviderClass_Account.class, description = "Login with valid username and password")
    public void TC01(Account account) {
        Log.startTestCase("TC01 - User can log into Railway with valid username and password");

        Log.info("[STEP 1]: Go to Login Page.");
        homePage.gotoLoginPage();

        Log.info("[STEP 2]: Enter email and password then submit.");
        loginPage.login(account.getEmail(), account.getPassword());

        Log.info("[STEP 3]: Get the Welcome Message.");
        String actualMessage = homePage.getWelcomeMessage();

        Log.info("[STEP 4]: Verify the Welcome Message.");
        Assert.assertEquals(actualMessage, "Welcome " + account.getEmail(), "User cannot login!!!");
    }

    @Test(dataProvider = "invalidLoginDataProvider", dataProviderClass = DataProviderClass_Account.class, description = "Login with invalid username and password")
    public void TC02(Account account) {
        System.out.println("TC02 - An error message displays when user tries to login with invalid credentials");

        homePage.gotoLoginPage();

        loginPage.login(account.getEmail(), account.getPassword());
        String actualErrorMsg = loginPage.getErrorMsg();
        String expectedErrorMsg = Constant.LOGIN_ERROR_MESSAGE;

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }

    @Test(description = "Login without password")
    public void TC03() {
        System.out.println("TC03 - An error message displays when user tries to login without password");
        if(true){
            throw new SkipException("Skip this test case");
        }


        homePage.gotoLoginPage();

        loginPage.login("", "");

        String actualErrorMsg = loginPage.getPasswordErrorMsg();
        String expectedErrorMsg = Constant.PASSWORD_ERROR_MESSAGE;

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }
}