package tests;

import helpers.DataHelper;
import helpers.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.RegisterPage;

public class TestRegister extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "Register with valid credentials")
    public void TC01() {
        Log.startTestCase("TC01 - User can register with valid credentials.");

        Log.info("-> Generate data for Registration.");
        String email = DataHelper.getRandomEmail();
        String password = DataHelper.getRandomPassword();
        String pidNumber = DataHelper.getRandomPID();

        Log.info("-> Go to Registration page.");
        homePage.goToRegisterPage();

        Log.info("-> Enter necessary info into Registration form then submit.");
        registerPage.register(email, password, password, pidNumber);

        Log.info("-> Verify the Successful Message.");
        Assert.assertEquals(registerPage.getSuccessfulMessage(), "You're here");
    }

    @Test
    public void TC02() {
        Log.startTestCase("TC02 - Error messages display when user tries to register without data");

        Log.info("-> Go to Registration page.");
        homePage.goToRegisterPage();

        Log.info("-> Enter necessary info into Registration form then submit.");
        registerPage.register("", "", "", "");
        Assert.assertEquals(registerPage.getFinalErrorMessage(), "There're errors in the form. Please correct the errors and try again.");
        Assert.assertEquals(registerPage.getEmailErrorMessage(), "Invalid email length");
        Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Invalid password length");
        Assert.assertEquals(registerPage.getPIDErrorMessage(), "Invalid ID length");
    }
}