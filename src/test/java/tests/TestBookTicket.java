package tests;

import helpers.Constant;
import helpers.DataHelper;
import helpers.Log;
import models.Ticket;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.HomePage;
import page_objects.LoginPage;

public class TestBookTicket extends TestBase {
    BookTicketPage bookTicketPage = new BookTicketPage();
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void Asda() {
        for (int i = 0; i < 10; i++) {
            homePage.gotoLoginPage();
            loginPage.login(Constant.USERNAME, Constant.PASSWORD);
            homePage.goToBookTicketPage();
            TC01();
            homePage.logOut();
        }
    }


    public void TC01() {
        Log.startTestCase("TC01 - User can book a ticket successfully.");

        Log.info("-> Generate data to book ticket.");
        String currentDate = DataHelper.getCurrentDate();
        String departDate = DataHelper.getRandomDateFromNow();
        String expiredDate = DataHelper.getExpiredDate();
        String departFrom = DataHelper.getRandomDepartStation();
        Log.info("-> Depart Station: " + departFrom);
        String arriveAt = DataHelper.getRandomArriveStation(departFrom);
        Log.info("-> Arrive Station: " + arriveAt);
        String seatType = "Soft seat";
        long ticketAmount = 3;
        Ticket ticket = new Ticket(departDate, currentDate, expiredDate, departFrom, arriveAt, seatType, ticketAmount, (ticketAmount * 135000));

        Log.info("-> Login and go to Book Ticket page.");


        Log.info("-> Book a ticket.");
        Ticket actualTicket = bookTicketPage.bookTicket(ticket);

        Log.info("-> Verify the title of Successful page.");
        Assert.assertEquals(bookTicketPage.getSuccessfulBookingTitle(), "Ticket Booked Successfully!", "Ticket booked failed or Successful message do not match.");

        Log.info("-> Verify Info Table");
        Assert.assertEquals(actualTicket.getDepartFrom(), ticket.getDepartFrom());
        Assert.assertEquals(actualTicket.getArriveAt(), ticket.getArriveAt());
        Assert.assertEquals(actualTicket.getSeatType(), ticket.getSeatType());
        Assert.assertEquals(actualTicket.getDepartDate(), ticket.getDepartDate());
        Assert.assertEquals(actualTicket.getBookingDate(), ticket.getBookingDate());
        Assert.assertEquals(actualTicket.getExpiredDate(), ticket.getExpiredDate());
        Assert.assertEquals(actualTicket.getTicketAmount(), ticket.getTicketAmount());
        //Assert.assertEquals(actualTicket.getTotalPrice(), ticket.getTotalPrice());
    }
}
