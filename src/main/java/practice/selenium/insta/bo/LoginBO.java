package practice.selenium.insta.bo;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import practice.selenium.Driver;
import practice.selenium.insta.po.LoginPO;

public class LoginBO {

    @Step
    public boolean login(String login, String pass) {
        WebDriver driver = Driver.getInstance().getDriver();
        driver.get("https://www.instagram.com/");
        LoginPO loginPO= new LoginPO(driver);
        loginPO.inputLogin(login);
        loginPO.inputPassword(pass);
        loginPO.submit();
        return true;
    }
}
