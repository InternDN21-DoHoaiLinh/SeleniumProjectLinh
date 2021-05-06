package tests;

import common.Log;
import helpers.BrowserHelpers;
import helpers.Constant;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {
    @BeforeMethod
    @Parameters("browser")
    public void setupTestMethod(@Optional("CHROME") String browser) {
        BrowserHelpers.startBrowser(BrowserHelpers.DriverType.valueOf(browser.toUpperCase()));
        BrowserHelpers.navigate(Constant.RAILWAY_URL);

        //In case your screen is too big or small, some elements not display then, thus we set the window size for stable purpose
        //BrowserHelpers.getWebDriver().manage().window().setSize(new Dimension(1024, 768));
    }

    @AfterMethod
    public void cleanUp() {
        Log.endTestCase();
        BrowserHelpers.quitBrowser();
    }
}
