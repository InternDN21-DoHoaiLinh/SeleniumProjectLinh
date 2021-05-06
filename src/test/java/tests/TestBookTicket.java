package tests;

import common.Log;
import helpers.Constant;
import helpers.DataHelper;
import models.Ticket;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.HomePage;
import page_objects.LoginPage;

public class TestBookTicket extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @Test(description = "User can book 1 ticket at a time")
    public void TC14() {
        Log.startTestCase("TC14");

        Log.info("> Login and go to Book ticket page");
        homePage.goToLogin();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        homePage.goToBookTicket();

        Log.info("> Book a ticket");
        String departDate = DataHelper.getDepartDate();
        String bookingDate = DataHelper.getCurrentDate();
        String expiredDate = DataHelper.getExpiredDate();
        String departFrom = "Sài Gòn";
        String arriveAt = "Nha Trang";
        String seatType = "Soft bed with air conditioner";
        int ticketAmount = 1;
        Ticket expectedBookedTicket = new Ticket(departDate, bookingDate, expiredDate, departFrom, arriveAt, seatType, ticketAmount);
        bookTicketPage.bookTicket(expectedBookedTicket);

        Log.info("> Get actual Ticket");
        Ticket actualBookedTicket = bookTicketPage.getSuccessfulTicket();

        Log.info("> Verify successful ticket booking");
        String successTitle = "Ticket Booked Successfully!";
        Assert.assertEquals(bookTicketPage.getTitle(), successTitle, "Success title does not match!");
        Assert.assertEquals(actualBookedTicket.getDepartFrom(), expectedBookedTicket.getDepartFrom(), "Depart From does not match!");
        Assert.assertEquals(actualBookedTicket.getArriveAt(), expectedBookedTicket.getArriveAt(), "Arrive At does not match!");
        Assert.assertEquals(actualBookedTicket.getSeatType(), expectedBookedTicket.getSeatType(), "Seat Type does not match!");
        Assert.assertEquals(actualBookedTicket.getDepartDate(), expectedBookedTicket.getDepartDate(), "Depart Date does not match!");
        Assert.assertEquals(actualBookedTicket.getBookingDate(), expectedBookedTicket.getBookingDate(), "Booking Date does not match!");
        Assert.assertEquals(actualBookedTicket.getExpiredDate(), expectedBookedTicket.getExpiredDate(), "Expired Date does not match!");
        Assert.assertEquals(actualBookedTicket.getTicketAmount(), expectedBookedTicket.getTicketAmount(), "Ticket Amount does not match!");
    }
}
