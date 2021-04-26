package page_objects;

import helpers.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    //Locators
    private final By tabLogin = By.xpath("//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//a[@href='/Account/Logout']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By tabRegister = By.cssSelector("a[href^='/Account/Register']");
    private final By tabBookTicket = By.cssSelector("a[href^='/Page/BookTicketPage']");

    //Elements
    protected WebElement getTabLogin() {

        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected WebElement getLblWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }

    protected WebElement getTabRegister() {
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    //Methods
    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }

    public void logOut() {
        this.getTabLogout().click();
    }

    public void gotoLoginPage() {
        this.getTabLogin().click();
    }

    public void goToRegisterPage() {
        this.getTabRegister().click();

    }
}
