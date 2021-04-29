package tests;

import helpers.Constant;
import common.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.MyTicketPage;

public class TestMyTicket extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    MyTicketPage myTicketPage = new MyTicketPage();

    @Test(description = "User can cancel or deleted all tickets in My Ticket table.")
    public void TC01() {
        Log.startTestCase("[MY TICKET]TC01 - User can cancel or deleted all tickets in My Ticket table.");

        Log.info("> Go to My Ticket Page.");
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        homePage.goToMyTicketPage();

        Log.info("> Delete all tickets in My Ticket table.");
        myTicketPage.cancelAllTicket();

        Log.info("> Reload My Ticket page.");
        homePage.goToMyTicketPage();

        Log.info("> Verify the inform message.");
        Assert.assertEquals(myTicketPage.getNoTicketsMessage(), "You haven't booked any tickets yet.", "Message not match!");
    }
}