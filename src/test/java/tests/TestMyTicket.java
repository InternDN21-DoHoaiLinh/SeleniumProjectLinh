package tests;

import common.Log;
import helpers.Constant;
import helpers.DataHelper;
import models.Ticket;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.*;

public class TestMyTicket extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    MyTicketPage myTicketPage = new MyTicketPage();

    @Test(description = "User can cancel a ticket")
    public void TC16() {
        Log.startTestCase("TC16");

        Log.info("> Create a new account");
        homePage.goToRegister();
        String email = DataHelper.getRandomEmail();
        String password = "12345678";
        registerPage.register(email, password, password, Constant.DEFAULT_PID);

        Log.info("> Login and go to Book ticket page");
        homePage.goToLogin();
        loginPage.login(email, password);
        homePage.goToBookTicket();

        Log.info("> Book a ticket");
        String departDate = DataHelper.getDateFromNow(Constant.DAYS_FROM_CURRENT_DATE);
        String bookingDate = DataHelper.getCurrentDate();
        String expiredDate = DataHelper.getDateFromNow(Constant.EXPIRED_DAYS_NUMBER);
        String departFrom = "Sài Gòn";
        String arriveAt = "Nha Trang";
        String seatType = "Soft bed with air conditioner";
        int ticketAmount = 1;
        Ticket expectedBookedTicket = new Ticket(departDate, bookingDate, expiredDate, departFrom, arriveAt, seatType, ticketAmount);
        bookTicketPage.bookTicket(expectedBookedTicket);

        Log.info("> Verify successful ticket booking");
        String successTitle = "Ticket Booked Successfully!";
        Assert.assertEquals(bookTicketPage.getTitle(), successTitle, "Success title does not match!");

        Log.info("> Go to My ticket page");
        bookTicketPage.goToMyTicket();

        Log.info("> Cancel a ticket");
        int expectedRowAmount = myTicketPage.getAmountOfRows() - 1;
        myTicketPage.cancelTicket();
        int actualRowAmount = myTicketPage.getAmountOfRows();

        Log.info("> Verify canceled ticket");
        Assert.assertEquals(actualRowAmount, expectedRowAmount, "Failed to cancel ticket!");
    }
}
