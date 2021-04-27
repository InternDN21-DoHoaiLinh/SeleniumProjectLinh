package page_objects;

import elements.Label;
import elements.Tab;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    //Locators
    private final Tab tabLogin = new Tab(By.cssSelector("a[href='/Account/Login.cshtml']"));
    private final Tab tabLogout = new Tab(By.cssSelector("a[href='/Account/Logout']"));
    private final Label lblWelcomeMessage = new Label(By.cssSelector("div[class='account']>strong"));
    private final Tab tabRegister = new Tab(By.cssSelector("a[href^='/Account/Register']"));
    private final Tab tabBookTicket = new Tab(By.cssSelector("a[href^='/Page/BookTicketPage']"));

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

    public void goToBookTicketPage() { tabBookTicket.click();}
}
