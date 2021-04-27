package page_objects;

import helpers.BrowserHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SuccessfulBookTicketPage {
    private final By _titleSuccessfulBooking = By.cssSelector("#content>h1");
    private final By _tdTicketInfo = By.cssSelector(".OddRow>td");

    //Elements
    private WebElement getTitleSuccessfulBookingTitle() {
        return BrowserHelpers.getWebDriver().findElement(_titleSuccessfulBooking);
    }

    private List<WebElement> getTDTicketInfoAsList() {
        return BrowserHelpers.getWebDriver().findElements(_tdTicketInfo);
    }

    public String getSuccessfulBookingTitle() {
        return getTitleSuccessfulBookingTitle().getText();
    }

    public List<String> getTicketInfoAsList() {
        List<String> result = new ArrayList<>();
        for(WebElement item : getTDTicketInfoAsList()){
            result.add(item.getText());
        }
        return result;
    }
}
