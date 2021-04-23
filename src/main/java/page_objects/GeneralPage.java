package page_objects;

import helpers.BrowserHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GeneralPage {
    //Locators
    private final By tabLogin = By.xpath("//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//a[@href='/Account/Logout']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");

    //Elements
    protected WebElement getTabLogin() {

        return BrowserHelpers.getWebDriver().findElement(tabLogin);
    }

    protected WebElement getTabLogout() {
        return BrowserHelpers.getWebDriver().findElement(tabLogout);
    }

    protected WebElement getLblWelcomeMessage() {
        return BrowserHelpers.getWebDriver().findElement(lblWelcomeMessage);
    }

    //Methods
    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }

    public void logOut() {
        this.getTabLogout().click();
    }

    public void gotoLoginPage() {
        try {
            BrowserHelpers.myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(tabLogin));
            if (this.getTabLogin().isDisplayed()) {
                this.getTabLogin().click();
            }
        } catch (TimeoutException nsee) {
            System.out.println(nsee.toString());
        }
    }
}
