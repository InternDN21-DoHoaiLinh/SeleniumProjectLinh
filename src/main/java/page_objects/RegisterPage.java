package page_objects;

import helpers.BrowserHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {
    private final By _txtEmail = By.cssSelector("#email");
    private final By _txtPassword = By.cssSelector("#password");
    private final By _txtConfirmPassword = By.cssSelector("#confirmPassword");
    private final By _txtPID = By.cssSelector("#pid");
    private final By _btnRegister = By.cssSelector("[type=submit]");

    public WebElement getTxtEmail() {
        return BrowserHelpers.getWebDriver().findElement(_txtEmail);
    }

    public WebElement getTxtPassword() {
        return BrowserHelpers.getWebDriver().findElement(_txtPassword);
    }

    public WebElement getTxtConfirmPassword() {
        return BrowserHelpers.getWebDriver().findElement(_txtConfirmPassword);
    }

    public WebElement getTxtPID() {
        return BrowserHelpers.getWebDriver().findElement(_txtPID);
    }

    public WebElement getBtnRegister() {
        return BrowserHelpers.getWebDriver().findElement(_btnRegister);
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
