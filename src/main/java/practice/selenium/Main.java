package practice.selenium;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        ChromeDriverManager.getInstance().setup();

        WebDriver driver= new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://stackoverflow.com/");

       // WebElement fakeElement=driver.findElement(By.xpath("//*[@id=\"qwe\"]"));


        WebElement searchInput=driver.findElement(By.xpath("//*[@id=\"search\"]/div/input"));
        WebElement searchInputParent=driver.findElement(By.id("search"));


        System.out.println(searchInput.getAttribute("placeholder"));
        System.out.println(searchInputParent.getRect().x+" "+searchInputParent.getRect().y);
        searchInput.sendKeys("some text");
        searchInput.clear();
        searchInput.sendKeys("new search text");
        System.out.println(searchInput.getText());

        WebElement loginButton=driver.findElement(By.linkText("Log in"));

        WebDriverWait waiter= new WebDriverWait(driver,10);
        WebElement loginButtonClickable = waiter.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Log in")));

        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                //.ignoring(Exception.class)
        ;

        WebElement loginButtonPoll = (WebElement) wait.until((Function<WebDriver, WebElement>) driver1
                -> driver1.findElement(By.linkText("Log in")));

        loginButtonPoll.click();

        ////*[text()="Log in"]
       // searchInput.sendKeys(Keys.ENTER);
        driver.quit();
    }
}
