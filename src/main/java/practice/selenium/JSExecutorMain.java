package practice.selenium;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class JSExecutorMain {
    public static void main(String[] args) throws IOException {
        ChromeDriverManager.getInstance().setup();

        WebDriver driver= new ChromeDriver();
        JavascriptExecutor executor= (JavascriptExecutor) driver;

        driver.get("https://stackoverflow.com/");

        System.out.println(executor.executeScript("return document.readyState"));

        WebElement loginButton=driver.findElement(By.linkText("Log in"));

        executor.executeScript("arguments[0].click()",loginButton);

        driver.quit();
    }

}
