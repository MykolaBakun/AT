package ui.so;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import practice.PropertyUtil;
import practice.selenium.insta.bo.LoginBO;
import practice.test_helper.BaseTest;

import java.util.concurrent.TimeUnit;


public class GetSOTest{

    @BeforeTest
    void init(){
        ChromeDriverManager.getInstance().setup();
    }


    @Test
    public void loginTest() {

        WebDriver driver= new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.MILLISECONDS);

        driver.get("https://stackoverflow.com/");

        Assert.assertTrue(driver.findElement(By.linkText("Stack Overflow")).isDisplayed(),"site isn't loaded");
    }



}
