package elements;

import org.openqa.selenium.By;

public class TextBox extends BaseElement {
    public TextBox(By locator) {
        super(locator);
    }

    public void enterText(CharSequence text) {
        findElement().sendKeys(text);
    }
}
