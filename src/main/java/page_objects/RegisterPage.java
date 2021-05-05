package page_objects;

import elements.Button;
import elements.Label;
import elements.TextBox;
import helpers.ElementHelper;
import org.openqa.selenium.By;

public class RegisterPage extends BasePage {
    private final TextBox txtEmail = new TextBox(By.id("email"));
    private final TextBox txtPassword = new TextBox(By.id("password"));
    private final TextBox txtConfirmPassword = new TextBox(By.id("confirmPassword"));
    private final TextBox txtPID = new TextBox(By.id("pid"));
    private final Button btnRegister = new Button(By.cssSelector(".form-actions>input[value='Register']"));
    private final Label lblSuccessMsg = new Label(By.cssSelector("#content>p"));

    public void register(String email, String password, String confirmPassword, String pid) {
        ElementHelper.scrollToView(txtEmail.findElement());
        txtEmail.enterText(email);
        txtPassword.enterText(password);
        txtConfirmPassword.enterText(confirmPassword);
        txtPID.enterText(pid);
        btnRegister.click();
    }

    public String getSuccessMsg() {
        return lblSuccessMsg.getText();
    }
}
