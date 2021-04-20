package page_objects;

import helpers.constants.Constant;

public class HomePage extends GeneralPage {
    public void open() {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
    }

    public void logOut() {
        this.getTabLogout().click();
    }
}
