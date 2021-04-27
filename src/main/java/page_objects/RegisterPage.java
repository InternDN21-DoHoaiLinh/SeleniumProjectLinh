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
    //Error messages
    private final By _txtFinalMessage = By.cssSelector("[class='message error']");
    private final By _txtEmailMessage = By.cssSelector(".email>.validation-error");
    private final By _txtPasswordMessage = By.cssSelector(".password>.validation-error");
    private final By _txtConfirmPasswordMessage = By.cssSelector(".confirm-password>.validation-error");
    private final By _txtPIDNumberMessage = By.cssSelector(".pid-number>.validation-error");
    //Successful message
    private final By _txtSuccessfulMessage = By.cssSelector("#content p");

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

    public WebElement getTxtFinalMessage() {
        return BrowserHelpers.getWebDriver().findElement(_txtFinalMessage);
    }

    public WebElement getTxtEmailMessage() {
        return BrowserHelpers.getWebDriver().findElement(_txtEmailMessage);
    }

    public WebElement getTxtPasswordMessage() {
        return BrowserHelpers.getWebDriver().findElement(_txtPasswordMessage);
    }

    public WebElement getTxtConfirmPasswordMessage() {
        return BrowserHelpers.getWebDriver().findElement(_txtConfirmPasswordMessage);
    }

    public WebElement getTxtPIDNumberMessage() {
        return BrowserHelpers.getWebDriver().findElement(_txtPIDNumberMessage);
    }

    public WebElement getTxtSuccessfulMessage() {
        return BrowserHelpers.getWebDriver().findElement(_txtSuccessfulMessage);
    }

    //Methods
    public void register(String email, String password, String confirmPassword, String pid) {
        getTxtEmail().sendKeys(email);
        getTxtPassword().sendKeys(password);
        getTxtConfirmPassword().sendKeys(confirmPassword);
        getTxtPID().sendKeys(pid);
        getBtnRegister().submit();
    }

    public String getFinalErrorMessage() {
        return getTxtFinalMessage().getText();
    }
    public String getEmailErrorMessage() {
        return getTxtEmailMessage().getText();
    }
    public String getPasswordErrorMessage() {
        return getTxtPasswordMessage().getText();
    }
    public String getConfirmPasswordErrorMessage() {
        return getTxtConfirmPasswordMessage().getText();
    }
    public String getPIDErrorMessage() {
        return getTxtPIDNumberMessage().getText();
    }

    public String getSuccessfulMessage() {
        return getTxtSuccessfulMessage().getText();
    }
}