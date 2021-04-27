package page_objects;

import elements.Dropdown;
import elements.Link;
import helpers.DateFormatHelper;
import org.openqa.selenium.By;

public class BookTicketPage extends GeneralPage {
    //Locator
    private final Dropdown _selectDepartDate = new Dropdown(By.name("Date"));
    private final Dropdown _selectDepartFrom = new Dropdown(By.name("DepartStation"));
    private final Dropdown _selectArriveAt = new Dropdown(By.name("ArriveStation"));
    private final Dropdown _selectSeatType = new Dropdown(By.name("SeatType"));
    private final Dropdown _selectTicketAmount = new Dropdown(By.name("TicketAmount"));
    private final Dropdown _btnBookTicket = new Dropdown(By.cssSelector("[type='submit']"));
    //private final Link _linkNew = new Link(By.cssSelector("#ArriveStation>center>a"));

    public void bookTicket() {
        String currentDate = DateFormatHelper.getCurrentDate();
        String bookedDate = DateFormatHelper.getDateFromNowAsString(5);
        String departStation = "Huế";

        _selectDepartDate.scrollToView();
        _selectDepartDate.selectItemByText(bookedDate);
        _selectDepartFrom.selectItemByText(departStation);

        _selectArriveAt.selectItemByText("Đà Nẵng");
        _selectArriveAt.isSelected();
        _selectSeatType.selectItemByText("Soft seat");
        _selectTicketAmount.selectItemByText("2");
        _btnBookTicket.click();
    }
}
