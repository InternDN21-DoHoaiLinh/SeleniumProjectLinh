package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table extends BaseElement {
    public Table(By locator) {
        super(locator);
    }

    public List<String> getTableCellsByHeaderAsText(String xpathForTableCell, String headerName) {
        List<String> cellValues = new ArrayList<>();
        List<WebElement> cells = findElement().findElements(By.xpath(String.format(xpathForTableCell, headerName)));
        for (WebElement cell : cells) {
            cellValues.add(cell.getText());
        }
        return cellValues;
    }

    public List<String> getTableHeader(String locatorPath) {
        List<String> headerNames = new ArrayList<>();
        List<WebElement> headers = findElement().findElements(By.cssSelector(locatorPath));
        for (WebElement header : headers) {
            headerNames.add(header.getText());
        }
        return headerNames;
    }

    public Map<String, List<String>> getAllTableCellsAsMap(String xpathForTableCell, String headerLocatorPath) {
        Map<String, List<String>> result = new HashMap<>();
        for (String header : getTableHeader(headerLocatorPath)) {
            result.put(header, getTableCellsByHeaderAsText(xpathForTableCell, header));
        }
        return result;
    }
}