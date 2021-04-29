package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import helpers.Constant;
import common.Log;
import models.Account;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestLogin extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "Login with valid username and password")
    public void TC01() {
        Log.startTestCase("[LOGIN]TC01 - User can log into Railway with valid username and password");

        Log.info("> Go to Login Page.");
        homePage.gotoLoginPage();

        Log.info("> Enter email and password then submit.");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        Log.info("> Get the Welcome Message.");
        String actualMessage = homePage.getWelcomeMessage();

        Log.info("> Verify the Welcome Message.");
        Assert.assertEquals(actualMessage, "Welcome " + Constant.USERNAME, "User cannot login!!!");
    }

    @Test(dataProvider = "invalidLoginDataProvider", description = "Login with invalid username and password")
    public void TC02(Account account) {
        Log.startTestCase("[LOGIN]TC02 - An error message displays when user tries to login with invalid credentials");

        Log.info("> Go to Login Page.");
        homePage.gotoLoginPage();

        Log.info("> Enter email and password then submit.");
        loginPage.login(account.getEmail(), account.getPassword());

        Log.info("> Get the Actual and Expected error messages.");
        String actualErrorMsg = loginPage.getErrorMsg();
        String expectedErrorMsg = Constant.LOGIN_ERROR_MESSAGE;

        Log.info("> Verify the Error Message.");
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }

    @Test(description = "Login without password")
    public void TC03() {
        Log.startTestCase("[LOGIN]TC03 - An error message displays when user tries to login without password");

        Log.info("> Go to Login Page.");
        homePage.gotoLoginPage();

        Log.info("> Enter email and password then submit.");
        loginPage.login(Constant.USERNAME, "");

        Log.info("> Get the Actual and Expected error messages.");
        String actualErrorMsg = loginPage.getPasswordErrorMsg();
        String expectedErrorMsg = Constant.PASSWORD_ERROR_MESSAGE;

        Log.info("> Verify the Error Message.");
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }

    @DataProvider(name = "invalidLoginDataProvider")
    public Object[] getInvalidLoginJSONData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Account> accounts = objectMapper.readValue(new File(Constant.INVALID_LOGIN_JSON_DATA_FILE_PATH)
                , new TypeReference<List<Account>>() {
                });
        return accounts.toArray();
    }
}