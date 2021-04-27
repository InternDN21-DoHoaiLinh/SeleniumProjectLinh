package page_objects;

import helpers.BrowserHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
    //Locators
    private final By _txtUsername = By.id("username");
    private final By _txtPassword = By.id("password");
    private final By _btnLogin = By.cssSelector("input[value='Login']");
    private final By _lblLoginErrorMsg = By.cssSelector("p[class='message error LoginForm']");
    private final By _lblPasswordErrorMsg = By.xpath("//input[@id='password']//following-sibling::label");
    private final By _lblUserErrorMs = By.xpath("//input[@id='username']//following-sibling::label");

    //Elements
    public WebElement getTxtUsername() {
        return BrowserHelpers.getWebDriver().findElement(_txtUsername);
    }

    public WebElement getTxtPassword() {
        return BrowserHelpers.getWebDriver().findElement(_txtPassword);
    }

    public WebElement getBtnLogin() {
        return BrowserHelpers.getWebDriver().findElement(_btnLogin);
    }

    public WebElement getLblLoginErrorMsg() {
        return BrowserHelpers.getWebDriver().findElement(_lblLoginErrorMsg);
    }

    public WebElement getLblPasswordErrorMsg() {
        return BrowserHelpers.getWebDriver().findElement(_lblPasswordErrorMsg);
    }

    public WebElement getLblUserErrorMsg() {
        return BrowserHelpers.getWebDriver().findElement(_lblUserErrorMs);
    }

    //Methods
    public void login(String username, String password) {
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
    }

    public String getErrorMsg() {
        return this.getLblLoginErrorMsg().getText();
    }

    public String getPasswordErrorMsg() {
        return this.getLblPasswordErrorMsg().getText();
    }

    public String getUserErrorMsg() {
        return this.getLblUserErrorMsg().getText();
    }
}
