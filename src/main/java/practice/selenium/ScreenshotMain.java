package practice.selenium;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotMain {
    public static void main(String[] args) throws IOException {
        ChromeDriverManager.getInstance().setup();

        WebDriver driver= new ChromeDriver();

        driver.get("https://stackoverflow.com/");

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("target"+File.separator+"screenshot.png"));
                driver.quit();
    }

}
