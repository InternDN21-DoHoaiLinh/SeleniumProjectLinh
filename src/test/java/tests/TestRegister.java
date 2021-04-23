package tests;

import helpers.FakingDataHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.RegisterPage;
import page_objects.SuccessfulRegisterPage;

public class TestRegister extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    SuccessfulRegisterPage successfulRegisterPage = new SuccessfulRegisterPage();
    FakingDataHelper faker = new FakingDataHelper();

    @Test(testName = "TC01_REGISTER", description = "Register with valid credentials")
    public void TC01() {
        String email = faker.randomEmail();
        String password = faker.randomText();
        String confirmPassword = password;
        String pidNumber = faker.randomNumber();

        System.out.println("TC01 - User can register with valid credentials");

        homePage.goToRegisterPage();
        registerPage.register(email, password, confirmPassword, pidNumber);

        Assert.assertEquals(successfulRegisterPage.getSuccessfulMessage(), "Registration Confirmed! You can now log in to the site.");
    }
}
