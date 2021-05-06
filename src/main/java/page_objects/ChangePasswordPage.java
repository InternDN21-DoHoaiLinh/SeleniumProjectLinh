package page_objects;

import elements.Button;
import elements.Label;
import elements.TextBox;
import helpers.ElementHelper;
import org.openqa.selenium.By;

public class ChangePasswordPage extends BasePage {
    private final TextBox txtCurrentPassword = new TextBox(By.id("currentPassword"));
    private final TextBox txtNewPassword = new TextBox(By.id("newPassword"));
    private final TextBox txtConfirmPassword = new TextBox(By.id("confirmPassword"));
    private final Button btnChangePassword = new Button(By.cssSelector(".form-actions>input[value='Change Password']"));
    private final Label lblSuccessMessage = new Label(By.cssSelector("p[class='message success']"));

    public void changePassword(String currentPassword, String newPassword, String confirmPassword) {
        ElementHelper.scrollToView(txtCurrentPassword.findElement());
        txtCurrentPassword.enterText(currentPassword);
        txtNewPassword.enterText(newPassword);
        txtConfirmPassword.enterText(confirmPassword);
        btnChangePassword.click();
    }

    public String getSuccessMessage() {
        return lblSuccessMessage.getText();
    }
}
