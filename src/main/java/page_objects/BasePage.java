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
    private final Label lblWelcomeMsg = new Label(By.cssSelector(".account"));

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

    public String getWelcomeMsg() {
        return lblWelcomeMsg.getText();
    }
}
