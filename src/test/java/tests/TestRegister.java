package tests;

import helpers.DataHelper;
import common.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.RegisterPage;

public class TestRegister extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "Register with valid credentials")
    public void TC01() {
        Log.startTestCase("[REGISTER]TC01 - User can register with valid credentials.");

        Log.info("> Generate data for Registration.");
        String email = DataHelper.getRandomEmail();
        String password = DataHelper.getRandomText(8);
        String pidNumber = DataHelper.getRandomPID(9);

        Log.info("> Go to Registration page.");
        homePage.goToRegisterPage();

        Log.info("> Enter necessary info into Registration form then submit.");
        registerPage.register(email, password, password, pidNumber);

        Log.info("> Verify the Successful Message.");
        Assert.assertEquals(registerPage.getSuccessfulMessage(), "You're here");
    }

    @Test(description = "Error messages display when user tries to register without data")
    public void TC02() {
        Log.startTestCase("[REGISTER]TC02 - Error messages display when user tries to register without data");

        Log.info("> Go to Registration page.");
        homePage.goToRegisterPage();

        Log.info("> Enter necessary info into Registration form then submit.");
        registerPage.register("", "", "", "");

        Log.info("> Verify error messages.");
        Assert.assertEquals(registerPage.getFinalErrorMessage(), "There're errors in the form. Please correct the errors and try again.");
        Assert.assertEquals(registerPage.getEmailErrorMessage(), "Invalid email length");
        Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Invalid password length");
        Assert.assertEquals(registerPage.getPIDErrorMessage(), "Invalid ID length");
    }
}