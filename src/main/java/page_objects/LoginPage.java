package page_objects;

import elements.Button;
import elements.Label;
import elements.TextBox;
import helpers.ElementHelper;
import org.openqa.selenium.By;

public class LoginPage extends GeneralPage {
    //Locators
    private final TextBox txtUsername = new TextBox(By.id("username"));
    private final TextBox txtPassword = new TextBox(By.id("password"));
    private final Button btnLogin = new Button(By.cssSelector("input[value='Login']"));
    private final Label lblLoginErrorMsg = new Label(By.cssSelector("p[class='message error LoginForm']"));
    private final Label lblPasswordErrorMsg = new Label(By.xpath("//input[@id='password']//following-sibling::label"));
    private final Label lblEmailErrorMs = new Label(By.xpath("//input[@id='username']//following-sibling::label"));

    //Methods
    public void login(String email, String password) {
        ElementHelper.scrollToView(txtPassword.findElement());
        txtUsername.enterText(email);
        txtPassword.enterText(password);
        btnLogin.submit();
    }

    public String getErrorMsg() {
        return lblLoginErrorMsg.getText();
    }

    public String getEmailErrorMsg() {
        return lblEmailErrorMs.getText();
    }

    public String getPasswordErrorMsg() {
        return lblPasswordErrorMsg.getText();
    }
}
