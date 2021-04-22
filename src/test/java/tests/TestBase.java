package tests;

import helpers.BrowserHelpers;
import helpers.constants.Constant;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestBase {
    @BeforeMethod()
    public void setupTestMethod() {
        BrowserHelpers.startBrowser(BrowserHelpers.DriverType.CHROME);
    }

    @AfterMethod
    public void closePage() {
        BrowserHelpers.quitBrowser();
    }
}
