package page_objects;

import helpers.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
    //Locators
    private final By _txtUsername = By.xpath("//input[@id='username']");
    private final By _txtPassword = By.xpath("//input[@id='password']");
    private final By _btnLogin = By.xpath("//input[@value='Login']");
    private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
    private final By _lblPasswordErrorMsg = By.xpath("//label[normalize-space(text())='You must specify a password.']");
    private final By _lblUserErrorMs = By.xpath("//label[normalize-space(text())='You must specify a username.']");

    //Elements
    public WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(_txtUsername);
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }

    public WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(_btnLogin);
    }

    public WebElement getLblLoginErrorMsg() {
        return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);
    }

    public WebElement getLblPasswordErrorMsg() {
        return Constant.WEBDRIVER.findElement(_lblPasswordErrorMsg);
    }

    public WebElement getLblUserErrorMsg() {
        return Constant.WEBDRIVER.findElement(_lblUserErrorMs);
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
