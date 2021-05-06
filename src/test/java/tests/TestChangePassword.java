package tests;

import common.Log;
import helpers.Constant;
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
        String password = "12345678";
        registerPage.register(email, password, password, Constant.DEFAULT_PID);

        Log.info("> Login");
        registerPage.goToLogin();
        loginPage.login(email, password);

        Log.info("> Change password");
        homePage.goToChangePassword();
        String newPassword = "dohoailinh199";
        changePasswordPage.changePassword(password, newPassword, newPassword);

        Log.info("> Verify success message");
        String successMsg = "Your password has been updated!";
        Assert.assertEquals(changePasswordPage.getSuccessMessage(), successMsg, "Success message does not match!");
    }
}
