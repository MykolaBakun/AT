package practice.selenium.decorator;

import org.openqa.selenium.WebElement;

import java.util.Date;

public abstract class CustomElement {
    private WebElement webElement;

    public CustomElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public WebElement getWebElement() {
        return webElement;
    }

    public void setWebElement(WebElement webElement) {
        this.webElement = webElement;
    }


    public boolean waitForMeVisible(int timeout_ms){
        long start=new Date().getTime();
        long ping_time=100;
        while (new Date().getTime()<(start+timeout_ms)){
            try{
            return webElement.isDisplayed();}
            catch (Exception ignored){
                System.out.println("ping element");
            }
            try {
                Thread.sleep(ping_time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
