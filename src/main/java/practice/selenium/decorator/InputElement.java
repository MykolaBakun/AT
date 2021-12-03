package practice.selenium.decorator;

import org.openqa.selenium.WebElement;

public class InputElement extends CustomElement{

    public InputElement(WebElement webElement) {
        super(webElement);
    }

    public void sendKeys(String login) {
        System.out.println("input");
        getWebElement().sendKeys(login);
    }
}
