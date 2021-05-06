package tests;

import common.Log;
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
        String pid = DataHelper.getRandomPIDNumber();

        Log.info("> Register a new account with valid credentials");
        registerPage.register(email, password, password, pid);

        Log.info("> Verify the successful message.");
        Assert.assertEquals(registerPage.getSuccessMsg(), "You're here", "Success message does not match!");
    }
}
