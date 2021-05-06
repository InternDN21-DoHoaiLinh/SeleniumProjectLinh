package tests;

import common.Log;
import helpers.Constant;
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
        String welcomeMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(homePage.getWelcomeMsg(), welcomeMsg, "Welcome message does not match!");
    }

    @Test(description = "User can't login with blank 'Username' textbox")
    public void TC02() {
        Log.startTestCase("TC02");

        Log.info("> Go to Login Page");
        homePage.goToLogin();

        Log.info("> Login without username");
        loginPage.login("", Constant.PASSWORD);

        Log.info("> Verify the error message");
        String errorMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(loginPage.getFinalErrorMsg(), errorMsg, "Error message does not match!");
    }

    @Test(description = "User cannot log into Railway with invalid password")
    public void TC03() {
        Log.startTestCase("TC03");

        Log.info("> Go to Login Page");
        homePage.goToLogin();

        Log.info("> Login with valid username but invalid password");
        String invalidPassword = "123456";
        loginPage.login(Constant.USERNAME, invalidPassword);

        Log.info("> Verify the error message");
        String errorMsg = "Invalid username or password. Please try again.";
        Assert.assertEquals(loginPage.getFinalErrorMsg(), errorMsg, "Error message does not match!");
    }

    @Test(description = "Login page displays when un-logged User clicks on 'Book ticket' tab")
    public void TC04() {
        Log.startTestCase("TC04");

        Log.info("> Click on Book ticket tab");
        homePage.goToBookTicket();

        Log.info("> Verify whether the user is redirected to Login page or not");
        String title = "Login Page";
        Assert.assertEquals(loginPage.getTitle(), title, "User is not redirected to Login page!");
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
        String myTicketTitle = "Manage Tickets";
        Assert.assertEquals(myTicketPage.getTitle(), myTicketTitle, "User is not directed to My ticket page!");

        Log.info("> Click on Change password tab, then verify whether user is directed to Change password page or not");
        homePage.goToChangePassword();
        String changePasswordTitle = "Change password";
        Assert.assertEquals(changePasswordPage.getTitle(), changePasswordTitle, "User is not directed to Change password page!");
    }
}
