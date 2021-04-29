package tests;

import helpers.BrowserHelpers;
import helpers.Constant;
import common.Log;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    @BeforeMethod
    public void setupTestMethod() {
        BrowserHelpers.startBrowser(BrowserHelpers.DriverType.CHROME);
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
