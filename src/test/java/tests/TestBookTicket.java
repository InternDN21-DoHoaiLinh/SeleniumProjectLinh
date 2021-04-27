package tests;

import helpers.Constant;
import helpers.Log;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.HomePage;
import page_objects.LoginPage;

public class TestBookTicket extends TestBase {
    BookTicketPage bookTicketPage = new BookTicketPage();
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void TC01() {
        Log.startTestCase("TC01 - User can book a ticket successfully.");

        Log.info("-> Login and go to Book Ticket page.");
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        homePage.goToBookTicketPage();

        Log.info("-> Book a ticket.");
        bookTicketPage.bookTicket();
    }
}
