package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Dropdown extends BaseElement {
    public Dropdown(By locator) {
        super(locator);
    }

    public void selectItemByText(String text) {
        Select dropdown = new Select(findElement());
        dropdown.selectByVisibleText(text);
    }
}
