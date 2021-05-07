package page_objects;

import elements.Button;
import elements.Table;
import helpers.BrowserHelpers;
import helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyTicketPage extends BasePage {
    private final Table tblMyTable = new Table(By.className("MyTable"));
    private final Button btnCancelButton = new Button(By.cssSelector(".MyTable input[value='Cancel']"));

    public int getAmountOfRows() {
        if (!tblMyTable.isDisplayed())
            return 0;
        List<WebElement> rowNumber = tblMyTable.findElement().findElements(By.cssSelector(".OddRow, .EvenRow"));
        return rowNumber.size();
    }

    public void cancelTicket() {
        ElementHelper.scrollToView(btnCancelButton.findElement());
        btnCancelButton.click();
        BrowserHelpers.acceptAlert();
    }
}
