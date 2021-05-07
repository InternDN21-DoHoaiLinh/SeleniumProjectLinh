package page_objects;

import elements.Label;
import elements.Link;
import org.openqa.selenium.By;

public class BasePage {
    private final Link tabLogin = new Link(By.cssSelector("#menu a[href='/Account/Login.cshtml']"));
    private final Link tabRegister = new Link(By.cssSelector("#menu a[href='/Account/Register.cshtml']"));
    private final Link tabBookTicket = new Link(By.cssSelector("#menu a[href='/Page/BookTicketPage.cshtml']"));
    private final Link tabMyTicket = new Link(By.cssSelector("#menu a[href='/Page/ManageTicket.cshtml']"));
    private final Link tabLogout = new Link(By.cssSelector("#menu a[href='/Account/Logout']"));
    private final Link tabChangePassword = new Link(By.cssSelector("#menu a[href='/Account/ChangePassword.cshtml']"));
    private final Link tabTimetable = new Link(By.cssSelector("#menu a[href='TrainTimeListPage.cshtml']"));
    private final Label lblWelcomeMsg = new Label(By.cssSelector(".account"));
    private final Label lblLoginTitle = new Label(By.cssSelector("#content>h1"));

    public void goToLogin() {
        tabLogin.click();
    }

    public void goToRegister() {
        tabRegister.click();
    }

    public void goToBookTicket() {
        tabBookTicket.click();
    }

    public void goToMyTicket() {
        tabMyTicket.click();
    }

    public void logOut() {
        tabLogout.click();
    }

    public void goToChangePassword() {
        tabChangePassword.click();
    }

    public void goToTimetable() {
        tabTimetable.click();
    }

    public String getWelcomeMsg() {
        return lblWelcomeMsg.getText();
    }

    public boolean isMyTicketTabDisplayed() {
        return tabMyTicket.isDisplayed();
    }

    public boolean isChangePasswordTabDisplayed() {
        return tabChangePassword.isDisplayed();
    }

    public boolean isLogOutTabDisplayed() {
        return tabLogout.isDisplayed();
    }

    public String getTitle() {
        return lblLoginTitle.getText();
    }
}
