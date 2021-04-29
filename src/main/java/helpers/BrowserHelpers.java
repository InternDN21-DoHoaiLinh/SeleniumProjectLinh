package helpers;

import common.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserHelpers {
    private static WebDriver driver;

    public enum DriverType {CHROME, FIREFOX, EDGE}

    public static void startBrowser(DriverType type) {
        switch (type) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constant.DEFAULT_TIME_WAIT, TimeUnit.SECONDS);
    }

    public static void quitBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getWebDriver() {
        return driver;
    }

    public static void navigate(String url) {
        driver.get(url);
    }

    //Alert
    public static void handleConfirmationAlert(boolean action) {
        Alert alert = BrowserHelpers.getWebDriver().switchTo().alert();
        Log.info("-> Alert Message " + alert.getText());
        if(action)
            alert.accept();
        else alert.dismiss();
    }
}