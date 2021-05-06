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
        String password = "12345678";

        Log.info("> Register a new account with valid credentials");
        registerPage.register(email, password, password, Constant.DEFAULT_PID);

        Log.info("> Verify the successful message.");
        String successMsg = "You're here";
        Assert.assertEquals(registerPage.getSuccessMsg(), successMsg, "Success message does not match!");
    }

    @Test(description = "User can't create account with 'Confirm password' is not the same with 'Password'")
    public void TC10() {
        Log.startTestCase("TC10");
        Log.info("> Go to Register page");
        homePage.goToRegister();

        Log.info("> Register with 'Confirm password' is not the same with 'Password'");
        String password = "12345678";
        String confirmPassword = "23456789";

        registerPage.register(Constant.NOT_REGISTERED_EMAIL, password, confirmPassword, Constant.DEFAULT_PID);

        Log.info("> Verify error message");
        Assert.assertEquals(registerPage.getErrorMsg(), Constant.REGISTER_ERROR_MESSAGE, "Error message does not match");
    }

    @Test(description = "User can't create account while password and PID fields are empty")
    public void TC11() {
        Log.startTestCase("TC11");

        Log.info("> Go to Register page");
        homePage.goToRegister();

        Log.info("> Register without password and PID number");
        registerPage.register(Constant.NOT_REGISTERED_EMAIL, "", "", "");

        Log.info("> Verify error messages");
        String passwordErrorMsg = "Invalid password length";
        String pidErrorMsg = "Invalid ID length";
        Assert.assertEquals(registerPage.getErrorMsg(), Constant.REGISTER_ERROR_MESSAGE, "Error message does not match!");
        Assert.assertEquals(registerPage.getPasswordErrorMsg(), passwordErrorMsg, "Password Error message does not match!");
        Assert.assertEquals(registerPage.getPIDErrorMsg(), pidErrorMsg, "PID Error message does not match!");
    }
}
