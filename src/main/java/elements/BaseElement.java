package elements;

import helpers.BrowserHelpers;
import helpers.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseElement {
    private final By locator;

    public BaseElement(By locator) {
        this.locator = locator;
    }

    public WebElement findElement() {
        return BrowserHelpers.getWebDriver().findElement(locator);
    }

    public List<WebElement> findElements() {
        return BrowserHelpers.getWebDriver().findElements(locator);
    }

    public void click() {
        findElement().click();
    }

    public String getText() {
        if (isExisted()) {
            return findElement().getText();
        }
        return "";
    }

    public boolean isDisplayed() {
        return findElement().isDisplayed();
    }

    public boolean isExisted() {
        return !findElements().isEmpty();
    }

    public boolean isEnabled() {
        return findElement().isEnabled();
    }

    public boolean isSelected() {
        return findElement().isDisplayed();
    }

    public void disableElement() {
        JavascriptExecutor js = (JavascriptExecutor) BrowserHelpers.getWebDriver();
        js.executeScript("arguments[0].setAttribute('style', 'display:none')", findElement());
    }

    public void scrollToView() {
        JavascriptExecutor js = (JavascriptExecutor) BrowserHelpers.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", findElement());
    }

    public void waitForElementExist() {
        WebDriverWait webDriverWait = new WebDriverWait(BrowserHelpers.getWebDriver(), Constant.DEFAULT_TIME_WAIT);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
