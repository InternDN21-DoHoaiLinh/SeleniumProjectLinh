package page_objects;

import elements.Dropdown;
import elements.Label;
import elements.Table;
import helpers.ElementHelper;
import models.Ticket;
import org.openqa.selenium.By;

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
    public String getCellValueByHeader(String headerName) {
        return new Label(By.xpath(String.format(xpathForTableCell, headerName))).getText();
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

        newTicket.setDepartFrom(getCellValueByHeader("Depart Station"));
        newTicket.setArriveAt(getCellValueByHeader("Arrive Station"));
        newTicket.setSeatType(getCellValueByHeader("Seat Type"));
        newTicket.setDepartDate(getCellValueByHeader("Depart Date"));
        newTicket.setBookingDate(getCellValueByHeader("Book Date"));
        newTicket.setExpiredDate(getCellValueByHeader("Expired Date"));
        newTicket.setTicketAmount(Long.valueOf(getCellValueByHeader("Amount")));
        newTicket.setTotalPrice(Long.valueOf(getCellValueByHeader("Total Price")));

        return newTicket;
    }

    public String getSuccessfulBookingTitle() {
        return lblSuccessfulBookingTitle.getText();
    }
}