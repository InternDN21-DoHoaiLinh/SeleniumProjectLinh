package tests;

import common.Log;
import helpers.Constant;
import helpers.DataHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.ChangePasswordPage;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.MyTicketPage;

public class TestLogin extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    MyTicketPage myTicketPage = new MyTicketPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    @Test(description = "User can log into Railway with valid username and password")
    public void TC01() {
        Log.startTestCase("TC01");

        Log.info("> Go to Login Page");
        homePage.goToLogin();

        Log.info("> Login with valid username and password");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        Log.info("> Verify the welcome message");
        Assert.assertEquals(homePage.getWelcomeMsg(), "Welcome " + Constant.USERNAME, "Welcome message does not match!");
    }

    @Test(description = "User can't login with blank 'Username' textbox")
    public void TC02() {
        Log.startTestCase("TC02");

        Log.info("> Go to Login Page");
        homePage.goToLogin();

        Log.info("> Login without username");
        loginPage.login("", Constant.PASSWORD);

        Log.info("> Verify the error message");
        Assert.assertEquals(loginPage.getFinalErrorMsg(), "There was a problem with your login and/or errors exist in your form.", "Error message does not match!");
    }

    @Test(description = "User cannot log into Railway with invalid password")
    public void TC03() {
        Log.startTestCase("TC03");

        Log.info("> Go to Login Page");
        homePage.goToLogin();

        Log.info("> Login with valid username but invalid password");
        loginPage.login(Constant.USERNAME, DataHelper.getRandomText(6));

        Log.info("> Verify the error message");
        Assert.assertEquals(loginPage.getFinalErrorMsg(), "Invalid username or password. Please try again.", "Error message does not match!");
    }

    @Test(description = "Login page displays when un-logged User clicks on 'Book ticket' tab")
    public void TC04() {
        Log.startTestCase("TC04");

        Log.info("> Click on Book ticket tab");
        homePage.goToBookTicket();

        Log.info("> Verify whether the user is redirected to Login page or not");
        Assert.assertEquals(loginPage.getTitle(), "Login Page", "User is not redirected to Login page!");
    }

    @Test(description = "Additional pages display once user logged in")
    public void TC06() {
        Log.startTestCase("TC06");

        Log.info("> Go to Login Page");
        homePage.goToLogin();

        Log.info("> Login with valid username and password");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        Log.info("> Verify My ticket, Change password and Log out tab are displayed");
        Assert.assertTrue(homePage.isMyTicketTabDisplayed(), "My ticket tab does not display");
        Assert.assertTrue(homePage.isChangePasswordTabDisplayed(), "Change password tab does not display");
        Assert.assertTrue(homePage.isLogOutTabDisplayed(), "Logout tab does not display");

        Log.info("> Click on My ticket tab, then Verify whether user is directed to My ticket page or not");
        homePage.goToMyTicket();
        Assert.assertEquals(myTicketPage.getTitle(), "Manage Tickets", "User is not directed to My ticket page!");

        Log.info("> Click on Change password tab, then verify whether user is directed to Change password page or not");
        homePage.goToChangePassword();
        Assert.assertEquals(changePasswordPage.getTitle(), "Change password", "User is not directed to Change password page!");
    }
}
