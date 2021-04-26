package helpers;

import org.openqa.selenium.WebDriver;

public class Constant {
    public static WebDriver WEBDRIVER;

    public static final String RAILWAY_URL = "http://www.railwayqa.somee.com";
    public static final String LOGIN_ERROR_MESSAGE = "Invalid username or password. Please try again.";
    public static final String PASSWORD_ERROR_MESSAGE = "You must specify a password.";
    public static final String USERNAME_ERROR_MESSAGE = "You must specify a username.";
    public static final long DEFAULT_TIME_WAIT = 10;

    public static final String VALID_LOGIN_JSON_DATA_FILE_PATH = "src/test/resources/testing_data/login/validLoginData.json";
    public static final String INVALID_LOGIN_JSON_DATA_FILE_PATH = "src/test/resources/testing_data/login/invalidLoginData.json";
    public static final String VALID_REGISTER_JSON_DATA_FILE_PATH = "src/test/resources/testing_data/register/validRegisterData.json";
}
