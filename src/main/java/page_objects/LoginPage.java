package page_objects;

import elements.Button;
import elements.Label;
import elements.TextBox;
import helpers.ElementHelper;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final TextBox txtEmail = new TextBox(By.id("username"));
    private final TextBox txtPassword = new TextBox(By.id("password"));
    private final Button btnLogin = new Button(By.cssSelector(".form-actions>input[title='Login']"));
    private final Label msgFinalErrorMsg = new Label(By.cssSelector("p.message"));
    private final Label msgEmailErrorMsg = new Label(By.cssSelector(".username>.validation-error"));
    private final Label msgPasswordErrorMsg = new Label(By.cssSelector(".password>.validation-error"));
    private final Label lblLoginTitle = new Label(By.cssSelector("#content>h1"));

    public void login(String email, String password) {
        ElementHelper.scrollToView(txtEmail.findElement());
        txtEmail.enterText(email);
        txtPassword.enterText(password);
        btnLogin.click();
    }

    public String getFinalErrorMsg() {
        return msgFinalErrorMsg.getText();
    }

    public String getLoginTitle() {
        return lblLoginTitle.getText();
    }
}
