package page_objects;

import elements.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyTicketPage extends BasePage {
    private final Table tblMyTable = new Table(By.className("MyTable"));

    public int getAmountOfRows() {
        List<WebElement> rowNumber = tblMyTable.findElement().findElements(By.cssSelector(".OddRow, .EvenRow"));
        return rowNumber.size() + 1;
    }
}
