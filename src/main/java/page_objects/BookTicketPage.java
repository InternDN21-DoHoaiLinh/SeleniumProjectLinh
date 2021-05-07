package page_objects;

import elements.Button;
import elements.Dropdown;
import elements.Table;
import helpers.ElementHelper;
import models.Ticket;
import org.openqa.selenium.By;

public class BookTicketPage extends BasePage {

    String xpathForTableCell = "//td[count(//th[text()='%s']/preceding-sibling::th)+1]";

    private final Dropdown drnDepartDate = new Dropdown(By.cssSelector("select[name='Date']"));
    private final Dropdown drnDepartFrom = new Dropdown(By.cssSelector("select[name='DepartStation']"));
    private final Dropdown drnArriveAt = new Dropdown(By.cssSelector("select[name='ArriveStation']"));
    private final Dropdown drnSeatType = new Dropdown(By.cssSelector("select[name='SeatType']"));
    private final Dropdown drnTicketAmount = new Dropdown(By.cssSelector("select[name='TicketAmount']"));
    private final Button btnBookTicket = new Button(By.cssSelector("input[value='Book ticket']"));
    private final Table tblSuccessfulBookingTable = new Table(By.cssSelector(".MyTable"));

    public String getCellValueByHeader(String headerName) {
        return tblSuccessfulBookingTable.findElement().findElement(By.xpath(String.format(xpathForTableCell, headerName))).getText();
    }

    public void bookTicket(Ticket ticket) {
        ElementHelper.scrollToView(drnDepartDate.findElement());
        drnDepartDate.selectItemByText(ticket.getDepartDate());
        drnDepartFrom.selectItemByText(ticket.getDepartFrom());
        drnArriveAt.selectItemByText(ticket.getArriveAt());
        drnSeatType.selectItemByText(ticket.getSeatType());
        drnTicketAmount.selectItemByText(String.valueOf(ticket.getTicketAmount()));
        btnBookTicket.click();
    }

    public Ticket getSuccessfulTicket() {
        Ticket newTicket = new Ticket();

        newTicket.setDepartFrom(getCellValueByHeader("Depart Station"));
        newTicket.setArriveAt(getCellValueByHeader("Arrive Station"));
        newTicket.setSeatType(getCellValueByHeader("Seat Type"));
        newTicket.setDepartDate(getCellValueByHeader("Depart Date"));
        newTicket.setBookingDate(getCellValueByHeader("Book Date"));
        newTicket.setExpiredDate(getCellValueByHeader("Expired Date"));
        newTicket.setTicketAmount(Integer.valueOf(getCellValueByHeader("Amount")));

        return newTicket;
    }

    public boolean isDepartStationSelected(String departStation) {
        return drnDepartFrom.getSelectedOptionAsText().equals(departStation);
    }

    public boolean isArriveStationSelected(String arriveStation) {
        return drnArriveAt.getSelectedOptionAsText().equals(arriveStation);
    }
}
