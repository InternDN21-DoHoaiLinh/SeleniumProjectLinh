package page_objects;

import helpers.BrowserHelpers;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileReader;
import java.io.IOException;

public class LoginPage extends GeneralPage {
    //Locators
    private final By _txtUsername = By.xpath("//input[@id='username']");
    private final By _txtPassword = By.xpath("//input[@id='password']");
    private final By _btnLogin = By.xpath("//input[@value='Login']");
    private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
    private final By _lblPasswordErrorMsg = By.xpath("//label[normalize-space(text())='You must specify a password.']");
    private final By _lblUserErrorMs = By.xpath("//label[normalize-space(text())='You must specify a username.']");

    //Elements
    public WebElement getTxtUsername() {
        return BrowserHelpers.getWebDriver().findElement(_txtUsername);
    }

    public WebElement getTxtPassword() {
        return BrowserHelpers.getWebDriver().findElement(_txtPassword);
    }

    public WebElement getBtnLogin() {
        return BrowserHelpers.getWebDriver().findElement(_btnLogin);
    }

    public WebElement getLblLoginErrorMsg() {
        return BrowserHelpers.getWebDriver().findElement(_lblLoginErrorMsg);
    }

    public WebElement getLblPasswordErrorMsg() {
        return BrowserHelpers.getWebDriver().findElement(_lblPasswordErrorMsg);
    }

    public WebElement getLblUserErrorMsg() {
        return BrowserHelpers.getWebDriver().findElement(_lblUserErrorMs);
    }

    //Methods
    public void login(String username, String password) {
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
    }

    public void loginByJSON(String jsonFilePath) {

        try {
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader(jsonFilePath);
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray usersList = (JSONArray) obj;
            for (int i = 0; i < usersList.size(); i++) {
                JSONObject user = (JSONObject) usersList.get(i);
                String email = (String) user.get("email");
                String password = (String) user.get("password");
                System.out.println("The email in JSON is: " + email);
                System.out.println("The password in JSON is: " + password);
                this.login(email, password);
                if (this.getWelcomeMessage().equals("Welcome guest!")) {
                    this.getTxtUsername().clear();
                    this.getTxtPassword().clear();
                } else {
                    this.getTabLogout().click();
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public String getErrorMsg() {
        return this.getLblLoginErrorMsg().getText();
    }

    public String getPasswordErrorMsg() {
        return this.getLblPasswordErrorMsg().getText();
    }

    public String getUserErrorMsg() {
        return this.getLblUserErrorMsg().getText();
    }
}
