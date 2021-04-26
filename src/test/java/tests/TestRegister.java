package tests;

import helpers.FakingDataHelper;
import helpers.providers.DataProviderClass_Account;
import models.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.RegisterPage;
import page_objects.SuccessfulRegisterPage;

public class TestRegister extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    SuccessfulRegisterPage successfulRegisterPage = new SuccessfulRegisterPage();

    @Test(dataProvider = "validRegisterDataProvider", dataProviderClass = DataProviderClass_Account.class, description = "Register with valid credentials")
    public void TC01(Account account) {
        String email = FakingDataHelper.randomEmail();
        String password = account.getPassword();
        String pidNumber = account.getPid();

        System.out.println("TC01 - User can register with valid credentials");
        System.out.println(email);
        System.out.println(password);
        System.out.println(pidNumber);

        homePage.goToRegisterPage();
        registerPage.register(email, password, password, pidNumber);

        Assert.assertEquals(successfulRegisterPage.getSuccessfulMessage(), "Registration Confirmed! You can now log in to the site.");
    }
}
