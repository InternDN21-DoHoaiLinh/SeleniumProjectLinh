package page_objects;

import elements.Button;
import elements.Label;
import elements.Table;
import helpers.BrowserHelpers;
import helpers.ElementHelper;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTicketPage extends GeneralPage {
    private String xpathForTableCell = "//tr//td[count(//tr[@class='TableSmallHeader']//th[text()='%s']//preceding-sibling::th)+1]";

    private final Button btnCancelButton = new Button(By.xpath(String.format(xpathForTableCell + "/input", "Operation")));
    private final Label lblNoTicketsMessage = new Label(By.xpath("//div[@id='content']"));
    private final Table tblSuccessfulBookingTable = new Table(By.cssSelector(".MyTable"));

    public String getNoTicketsMessage() {
        return lblNoTicketsMessage.getText().trim().substring(15);
    }

    private List<String> getTicketTableHeaderAsList() {
        return tblSuccessfulBookingTable.getTableHeader("th");
    }

    private String getMyTicketInfoByHeader(String header) {
        return new Label(By.xpath(String.format(xpathForTableCell, header))).getText();
    }

    public Map<String, String> getFirstRowAsMap() {
        Map<String, String> result = new HashMap<>();
        for (String header : getTicketTableHeaderAsList()) {
            result.put(header, getMyTicketInfoByHeader(header));
        }
        return result;
    }

    //Cancel tickets
    public void cancelTicket() {
        ElementHelper.scrollToView(btnCancelButton.findElement());
        ElementHelper.scrollToView(btnCancelButton.findElement());
        btnCancelButton.click();
        BrowserHelpers.handleConfirmationAlert(true);
    }

    public void cancelAllTicket() {
        while (btnCancelButton.isDisplayed()) {
            cancelTicket();
        }
    }
}