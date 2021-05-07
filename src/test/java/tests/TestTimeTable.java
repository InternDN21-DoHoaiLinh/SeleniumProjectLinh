package tests;

import common.Log;
import helpers.Constant;
import helpers.DataHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.*;

public class TestTimeTable extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    TimetablePage timetablePage = new TimetablePage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "User can open 'Book ticket' page by clicking on 'Book ticket' link in 'Train timetable' page")
    public void TC15() {
        Log.startTestCase("TC15");

        Log.info("> Create a new account for password changing purpose");
        homePage.goToRegister();
        String email = DataHelper.getRandomEmail();
        String password = "12345678";
        registerPage.register(email, password, password, Constant.DEFAULT_PID);

        Log.info("> Login and go to Timetable page");
        homePage.goToLogin();
        loginPage.login(email, password);
        homePage.goToTimetable();

        Log.info("> Click on book ticket link on Train Timetable");
        String departStation = "Huế";
        String arriveStation = "Sài Gòn";
        timetablePage.goToBookTicket(departStation, arriveStation);

        Log.info("> Verify Book ticket page is loaded. Depart Station and Arrive Station is correct");
        String bookTicketTitle = "Book ticket";
        Assert.assertEquals(bookTicketPage.getTitle(), bookTicketTitle, "Book ticket page is loaded!");
        Assert.assertTrue(bookTicketPage.isDepartStationSelected(departStation), "Depart Station is not correct!");
        Assert.assertTrue(bookTicketPage.isArriveStationSelected(arriveStation), "Arrive Station is not correct!");
    }
}
