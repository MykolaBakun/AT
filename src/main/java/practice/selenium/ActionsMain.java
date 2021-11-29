package practice.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsMain {
    public static void main(String[] args) {
        WebDriver driver= Driver.getInstance().getDriver();
        driver.get("https://stackoverflow.com/");
        WebElement searchInput=driver.findElement(By.xpath("//*[@id=\"search\"]/div/input"));

        Actions actions = new Actions(driver);

        Action clickAction=actions.moveToElement(searchInput).keyDown(Keys.ENTER).keyUp(Keys.ENTER).build();

        clickAction.perform();

        driver.quit();

    }
}
