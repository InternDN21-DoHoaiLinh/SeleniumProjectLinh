package page_objects;

import helpers.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {
    private final By _txtEmail = By.cssSelector("#email");
    private final By _txtPassword = By.cssSelector("#password");
    private final By _txtConfirmPassword = By.cssSelector("#confirmPassword");
    private final By _txtPID = By.cssSelector("#pid");
    private final By _btnRegister = By.cssSelector("[type=submit]");

    public WebElement getTxtEmail() {
        return Constant.WEBDRIVER.findElement(_txtEmail);
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }

    public WebElement getTxtConfirmPassword() {
        return Constant.WEBDRIVER.findElement(_txtConfirmPassword);
    }

    public WebElement getTxtPID() {
        return Constant.WEBDRIVER.findElement(_txtPID);
    }

    public WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(_btnRegister);
    }

    //Methods
    public void register(String email, String password, String confirmPassword, String pid) {
        getTxtEmail().sendKeys(email);
        getTxtPassword().sendKeys(password);
        getTxtConfirmPassword().sendKeys(confirmPassword);
        getTxtPID().sendKeys(pid);
        getBtnRegister().submit();
    }

}
