package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementHelper {
    public static void scrollToView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) BrowserHelpers.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void waitForElementExist(WebElement element, long timeToWait) {
        WebDriverWait webDriverWait = new WebDriverWait(BrowserHelpers.getWebDriver(), timeToWait);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
}
