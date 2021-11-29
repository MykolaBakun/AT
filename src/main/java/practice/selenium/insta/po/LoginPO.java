package practice.selenium.insta.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPO {
    WebDriver driver;
    public LoginPO(WebDriver driver) {
       this.driver=driver;
    }

    public void inputLogin(String login) {

        WebElement usernameInput=driver.findElement(By.xpath("//*[@name='username']"));

        WebElement waiterResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(usernameInput));

        waiterResult.sendKeys(login);
    }

    public void inputPassword(String pass) {
        //TODO
    }

    public void submit() {
        //TODO
    }
}
