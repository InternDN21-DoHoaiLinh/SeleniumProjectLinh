package page_objects;

import elements.Button;
import elements.TextBox;
import helpers.ElementHelper;
import org.openqa.selenium.By;

public class RegisterPage extends GeneralPage {
    private final TextBox txtEmail = new TextBox(By.cssSelector("#email"));
    private final TextBox txtPassword = new TextBox(By.cssSelector("#password"));
    private final TextBox txtConfirmPassword = new TextBox(By.cssSelector("#confirmPassword"));
    private final TextBox txtPID = new TextBox(By.cssSelector("#pid"));
    private final Button btnRegister = new Button(By.cssSelector("[type=submit]"));
    //Error messages
    private final TextBox txtFinalMessage = new TextBox(By.cssSelector("[class='message error']"));
    private final TextBox txtEmailMessage = new TextBox(By.cssSelector(".email>.validation-error"));
    private final TextBox txtPasswordMessage = new TextBox(By.cssSelector(".password>.validation-error"));
    private final TextBox txtConfirmPasswordMessage = new TextBox(By.cssSelector(".confirm-password>.validation-error"));
    private final TextBox txtPIDNumberMessage = new TextBox(By.cssSelector(".pid-number>.validation-error"));
    //Successful message
    private final TextBox txtSuccessfulMessage = new TextBox(By.cssSelector("#content p"));

    //Methods
    public void register(String email, String password, String confirmPassword, String pid) {
        ElementHelper.scrollToView(txtEmail.findElement());
        txtEmail.enterText(email);
        txtPassword.enterText(password);
        txtConfirmPassword.enterText(confirmPassword);
        txtPID.enterText(pid);
        btnRegister.submit();
    }

    public String getFinalErrorMessage() {
        return txtFinalMessage.getText();
    }

    public String getEmailErrorMessage() {
        return txtEmailMessage.getText();
    }

    public String getPasswordErrorMessage() {
        return txtPasswordMessage.getText();
    }

    public String getConfirmPasswordErrorMessage() {
        return txtConfirmPasswordMessage.getText();
    }

    public String getPIDErrorMessage() {
        return txtPIDNumberMessage.getText();
    }

    public String getSuccessfulMessage() {
        return txtSuccessfulMessage.getText();
    }
}