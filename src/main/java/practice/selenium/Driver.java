package practice.selenium;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Driver {

    private static final Driver DRIVER = new Driver();

    public static Driver getInstance() {
        return DRIVER;
    }


    private WebDriver webDriver;

    public WebDriver getDriver(String browser) {
        if (webDriver == null) {
            switch (browser) {
                case "chrome" -> {
                    ChromeDriverManager.getInstance().setup();
                    webDriver = new ChromeDriver();
                }
                case "edge" -> {
                    EdgeDriverManager.edgedriver().setup();
                    webDriver = new EdgeDriver();
                }
                default -> throw new RuntimeException("invalid browser " + browser);
            }
        }
        return webDriver;
    }

    public static void main(String[] args) {
        WebDriver driver = Driver.getInstance().getDriver("edge");
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        driver.get("https://stackoverflow.com/");
        System.out.println(executor.executeScript("return document.readyState"));
        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"search\"]/div/input"));
        executor.executeScript("arguments[0].click()", searchInput);
        driver.quit();
    }
}
