package tests;

import common.Log;
import helpers.Constant;
import helpers.DataHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.RegisterPage;

public class TestRegister extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "User can create new account")
    public void TC07() {
        Log.startTestCase("TC07");

        Log.info("> Go to Register page");
        homePage.goToRegister();

        Log.info("> Create fake credentials");
        String email = DataHelper.getRandomEmail();
        String password = DataHelper.getRandomPassword();

        Log.info("> Register a new account with valid credentials");
        registerPage.register(email, password, password, Constant.DEFAULT_PID);

        Log.info("> Verify the successful message.");
        Assert.assertEquals(registerPage.getSuccessMsg(), "You're here", "Success message does not match!");
    }

    @Test(description = "User can't create account with 'Confirm password' is not the same with 'Password'")
    public void TC10() {
        Log.startTestCase("TC10");
        Log.info("> Go to Register page");
        homePage.goToRegister();

        Log.info("> Register with 'Confirm password' is not the same with 'Password'");
        registerPage.register(Constant.NOT_REGISTERED_EMAIL, "12345678", "23456789", Constant.DEFAULT_PID);

        Log.info("> Verify error message");
        Assert.assertEquals(registerPage.getErrorMsg(), "There're errors in the form. Please correct the errors and try again.", "Error message does not match");
    }
}
