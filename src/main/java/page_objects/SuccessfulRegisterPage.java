package page_objects;

import helpers.BrowserHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SuccessfulRegisterPage extends GeneralPage {
    private final By _txtSuccessfulMessage = By.cssSelector("#content p");

    public WebElement getTxtSuccessfulMessage() {
        return BrowserHelpers.getWebDriver().findElement(_txtSuccessfulMessage);
    }

    public String getSuccessfulMessage() {
        return getTxtSuccessfulMessage().getText();
    }
}
