package page_objects;

import elements.Dropdown;
import elements.Label;
import elements.Table;
import helpers.ElementHelper;
import models.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookTicketPage extends GeneralPage {

    String xpathForTableCell = "//td[count(//th[text()='%s']/preceding-sibling::th)+1]";

    //Locators
    private final Dropdown selectDepartDate = new Dropdown(By.name("Date"));
    private final Dropdown selectDepartFrom = new Dropdown(By.name("DepartStation"));
    private final Dropdown selectArriveAt = new Dropdown(By.name("ArriveStation"));
    private final Dropdown selectSeatType = new Dropdown(By.name("SeatType"));
    private final Dropdown selectTicketAmount = new Dropdown(By.name("TicketAmount"));
    private final Dropdown btnBookTicket = new Dropdown(By.cssSelector("[type='submit']"));
    private final Label lblSuccessfulBookingTitle = new Label(By.cssSelector("#content>h1"));
    private final Table tblSuccessfulBookingTable = new Table(By.cssSelector(".MyTable"));

    //Methods

    public List<String> getTicketTableHeaderAsList() {
        return tblSuccessfulBookingTable.getTableHeader("th");
    }

    public String getCellValueByHeader(String headerName) {
        return new Label(By.xpath(String.format(xpathForTableCell, headerName))).getText();
    }

    public Map<String, String> getTicketInfoAsMap() {
        Map<String, String> result = new HashMap<>();
        for (String header : getTicketTableHeaderAsList()) {
            result.put(header, getCellValueByHeader(header));
        }
        return result;
    }

    public void bookTicket(Ticket ticket) {
        ElementHelper.scrollToView(selectDepartFrom.findElement());
        selectDepartFrom.selectItemByText(ticket.getDepartFrom());
        selectDepartDate.selectItemByText(ticket.getDepartDate());
        selectSeatType.selectItemByText(ticket.getSeatType());
        selectTicketAmount.selectItemByText(String.valueOf(ticket.getTicketAmount()));
        selectArriveAt.selectItemByText(ticket.getArriveAt());
        btnBookTicket.submit();
    }

    public Ticket getSuccessfulTicketInfo() {
        Ticket newTicket = new Ticket();

        Map<String, String> ticketInfo = getTicketInfoAsMap();
        newTicket.setDepartFrom(ticketInfo.get("Depart Station"));
        newTicket.setArriveAt(ticketInfo.get("Arrive Station"));
        newTicket.setSeatType(ticketInfo.get("Seat Type"));
        newTicket.setDepartDate(ticketInfo.get("Depart Date"));
        newTicket.setBookingDate(ticketInfo.get("Book Date"));
        newTicket.setExpiredDate(ticketInfo.get("Expired Date"));
        newTicket.setTicketAmount(Long.valueOf(ticketInfo.get("Amount")));
        newTicket.setTotalPrice(Long.valueOf(ticketInfo.get("Total Price")));

        return newTicket;
    }

    public String getSuccessfulBookingTitle() {
        return lblSuccessfulBookingTitle.getText();
    }
}