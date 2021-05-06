package tests;

import common.Log;
import helpers.DataHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.ChangePasswordPage;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.RegisterPage;

public class TestChangePassword extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    @Test(description = "User can change password")
    public void TC09() {
        Log.startTestCase("TC09");

        Log.info("> Create a new account for password changing purpose");
        homePage.goToRegister();
        String email = DataHelper.getRandomEmail();
        String password = DataHelper.getRandomPassword();
        registerPage.register(email, password, password, DataHelper.getRandomPIDNumber());

        Log.info("> Login");
        registerPage.goToLogin();
        loginPage.login(email, password);

        Log.info("> Change password");
        homePage.goToChangePassword();
        changePasswordPage.changePassword(password, "dohoailinh199", "dohoailinh199");

        Log.info("> Verify success message");
        Assert.assertEquals(changePasswordPage.getSuccessMessage(), "Your password has been updated!", "Success message does not match!");
    }
}
