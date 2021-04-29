package page_objects;

import elements.Button;
import elements.Label;
import org.openqa.selenium.By;

public class GeneralPage {
    //Locators
    private final Button tabLogin = new Button(By.cssSelector("a[href='/Account/Login.cshtml']"));
    private final Button tabLogout = new Button(By.cssSelector("a[href='/Account/Logout']"));
    private final Label lblWelcomeMessage = new Label(By.cssSelector("div[class='account']>strong"));
    private final Button tabRegister = new Button(By.cssSelector("a[href^='/Account/Register']"));
    private final Button tabBookTicket = new Button(By.cssSelector("a[href^='/Page/BookTicketPage']"));
    private final Button tabMyTicket = new Button(By.cssSelector("a[href^='/Page/ManageTicket']"));

    //Methods
    public String getWelcomeMessage() {
        return lblWelcomeMessage.getText();
    }

    public void logOut() {
        tabLogout.click();
    }

    public void gotoLoginPage() {
        tabLogin.click();
    }

    public void goToRegisterPage() {
        tabRegister.click();
    }

    public void goToBookTicketPage() {
        tabBookTicket.click();
    }

    public void goToMyTicketPage() {
        tabMyTicket.click();
    }
}