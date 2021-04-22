package page_objects;

import helpers.BrowserHelpers;
import helpers.constants.Constant;

public class HomePage extends GeneralPage {
    public void open() {
        BrowserHelpers.getWebDriver().get(Constant.RAILWAY_URL);
    }
}
