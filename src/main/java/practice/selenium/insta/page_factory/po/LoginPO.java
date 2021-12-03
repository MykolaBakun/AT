package practice.selenium.insta.page_factory.po;

import io.qameta.allure.Link;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import practice.selenium.decorator.ButtonElement;
import practice.selenium.decorator.InputElement;
import practice.selenium.parallel_run.BrowserFactory;


public class LoginPO extends BasicPO{

    @FindBy(xpath = "//*[@name='username']")
    private InputElement loginInput;
    @FindBy(xpath = "//*[@name='password']")
    private InputElement passInput;
    @FindBy(xpath = "//*[@type='submit']")
    private ButtonElement loginSubmitButton;

    @FindBy(xpath = "//*[@class=\'sqdOP  L3NKy   y3zKF     \']")
    private ButtonElement followUserSubmitButton;

    @FindBy(xpath = "//*[@class=\'_5f5mN       jIbKX  _6VtSN     yZn4P   \']")
    private ButtonElement followGroupSubmitButton;


    @FindBy(xpath = "//*[@class=\'             qF0y9          Igw0E   rBNOH          YBx95       _4EzTm                                                                                                              \']")
    private ButtonElement followGroup;

    @Override
    @Step("isOpen")
    public boolean isOpen() {
        System.out.println("isOpen");
        return loginInput.waitForMeVisible(8000);
    }

    @Override
    @Step("isFollowGroup")
    public boolean isFollowGroup() {
        System.out.println("isFollowGroup");
        return followGroup.waitForMeVisible(80);
    }

    @Step("inputLogin")
    public LoginPO inputLogin(String login) {
        System.out.println("inputLogin");
        loginInput.sendKeys(login);
        return this;
    }
    @Step("inputPassword")
    public LoginPO inputPassword(String pass) {
        System.out.println("inputPassword");
        passInput.sendKeys(pass);
       return this;
    }
    @Step("loginSubmit")
    public LoginPO loginSubmit() {
        System.out.println("loginSubmit");
        loginSubmitButton.click();
        return this;
    }
    @Step("loginCheck")
    public HomePO loginCheck() {
        System.out.println("loginCheck");
        return new HomePO();
    }
    @Step("followUserSubmit")
    public LoginPO followUserSubmit() {
        System.out.println("followUserSubmit");
        followUserSubmitButton.click();
        return this;
    }
    @Step("followUserCheck")
    public HomePO followUserCheck() {
        System.out.println("followUserCheck");
        return new HomePO();
    }
    @Step("followGroupSubmit")
    public LoginPO followGroupSubmit() {
        System.out.println("followGroupSubmit");
        followGroupSubmitButton.click();
        return this;
    }
    @Step("followGroupCheck")
    public HomePO followGroupCheck() { return new HomePO();  }

    public LoginPO mySleep(long time){
        System.out.println("sleep on: "+time+" millis.");
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("goToLoginPage")
    @Link("https://www.instagram.com/")
    public LoginPO goToLoginPage() {
        BrowserFactory.getDriver().get("https://www.instagram.com/");
        return this;
    }
    @Step("goToUserPage")
    @Link("https://www.instagram.com/mykola.bakun/")
    public LoginPO goToUserPage() {
        System.out.println("goToUserPage");
        BrowserFactory.getDriver().navigate().to("https://www.instagram.com/mykola.bakun/");
        return this;
    }
    @Step("goToGroupPage")
    @Link("https://www.instagram.com/it_university/")
    public LoginPO goToGroupPage() {
        System.out.println("goToGroupPage");
        BrowserFactory.getDriver().navigate().to("https://www.instagram.com/it_university/");
        return this;
    }

}
