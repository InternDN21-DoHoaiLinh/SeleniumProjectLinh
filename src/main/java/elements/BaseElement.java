package elements;

import common.Log;
import helpers.BrowserHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseElement {
    private final By locator;

    public BaseElement(By locator) {
        this.locator = locator;
    }

    public String getAttribute(String attribute) {
        return findElement().getAttribute(attribute);
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

    public void submit() {
        findElement().submit();
    }

    public String getText() {
        return findElement().getText();
    }

    public boolean isDisplayed() {
        try {
            return findElement().isDisplayed();
        } catch (NoSuchElementException e) {
            Log.error("> Element is not displayed! More info: " + e.getMessage());
            return false;
        }
    }

    public boolean isEmpty() {
        return !findElements().isEmpty();
    }

    public boolean isEnabled() {
        return findElement().isEnabled();
    }

    public boolean isSelected() {
        return findElement().isSelected();
    }
}
