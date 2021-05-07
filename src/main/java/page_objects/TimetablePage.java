package page_objects;

import elements.Link;
import helpers.ElementHelper;
import org.openqa.selenium.By;

public class TimetablePage extends BasePage {
    private String xpathForBookTicket = " //td[count(//th[text()='Depart Station']/preceding-sibling::th)+1][text()='%s']"
            + "//parent::tr//td[count(//th[text()='Arrive Station']/preceding-sibling::th)+1][text()='%s']"
            + "//parent::tr//a[text()='book ticket']";

    private Link lnkBookTicket;

    public void goToBookTicket(String departStation, String arriveStation) {
        lnkBookTicket = new Link(By.xpath(String.format(xpathForBookTicket, departStation, arriveStation)));
        ElementHelper.scrollToView(lnkBookTicket.findElement());
        lnkBookTicket.click();
    }
}
