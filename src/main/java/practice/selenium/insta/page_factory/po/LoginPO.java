package practice.selenium.insta.page_factory.po;

import io.qameta.allure.Link;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import practice.selenium.decorator.ButtonElement;
import practice.selenium.decorator.InputElement;
import practice.selenium.parallel_run.BrowserFactory;


public class LoginPO extends BasicPO{

    @FindBy(xpath = "//*[@name='username']")
    private InputElement loginInput;
    @FindBy(xpath = "//*[@name='password']")
    private InputElement passInput;
    private InputElement textInput;


    private ButtonElement SubmitButton;

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
        return (new ButtonElement(BrowserFactory.getDriver().findElement( By.xpath("//button[normalize-space()=\'Message\']")))).waitForMeVisible(80);
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
        SubmitButton = new ButtonElement(BrowserFactory.getDriver().findElement( By.xpath("//button[normalize-space()=\'Log In\']")));
        SubmitButton.click();
        return this;
    }
    @Step("loginCheck")
    public HomePO loginCheck() {
        System.out.println("loginCheck");
        return new HomePO();
    }
    @Step("followSubmit")
    public LoginPO followSubmit() {
        System.out.println("followSubmit");
        SubmitButton = new ButtonElement(BrowserFactory.getDriver().findElement( By.xpath("//button[normalize-space()=\'Follow\']")));
        SubmitButton.click();
        return this;
    }

    @Step("followUserCheck")
    public HomePO followUserCheck() {
        System.out.println("followUserCheck");
        return new HomePO();
    }
    @Step("followGroupCheck")
    public HomePO followGroupCheck() {
        System.out.println("followGroupCheck");
        return new HomePO();
    }

    @Step("massageSubmit")
    public LoginPO massageSubmit() {
        System.out.println("massageSubmit");
        SubmitButton = new ButtonElement(BrowserFactory.getDriver().findElement( By.xpath("//button[normalize-space()=\'Message\']")));
        SubmitButton.click();
        return this;
    }
    @Step("inputMassage")
    public LoginPO inputMassage(String massage) {
        System.out.println("inputMassage");
        textInput = new InputElement(BrowserFactory.getDriver().findElement(By.xpath("//textarea[@placeholder='Message...']")));
        textInput.sendKeys(massage);
        return this;
    }
    @Step("massageSend")
    public LoginPO massageSend() {
        System.out.println("massageSend");
        SubmitButton = new ButtonElement(BrowserFactory.getDriver().findElement( By.xpath("//div/div/div/div/button[normalize-space()=\'Send\']")));
        SubmitButton.click();
        return this;
    }
    @Step("massageSendCheck")
    public HomePO massageSendCheck() { return new HomePO();  }

    @Step("postSubmit")
    public LoginPO postSubmit() {
        System.out.println("postSubmit");
        SubmitButton = new ButtonElement(BrowserFactory.getDriver().findElement( By.xpath("//div/section/span[@class=\'_15y0l\']/button[@class=\'wpO6b  \']")));
        SubmitButton.click();
        return this;
    }
    @Step("inputComment")
    public LoginPO inputComment(String comment) {
        System.out.println("inputComment");
        textInput = new InputElement(BrowserFactory.getDriver().findElement(By.xpath("//section/div[@class='RxpZH']/form/textarea")));
        textInput.sendKeys(comment);
        return this;
    }
    @Step("postSubmit")
    public LoginPO commentSubmit() {
        System.out.println("postSubmit");
        SubmitButton = new ButtonElement(BrowserFactory.getDriver().findElement( By.xpath("//button[normalize-space()=\'Post\']")));
        SubmitButton.click();
        return this;
    }
    @Step("likeSubmit")
    public LoginPO likeSubmit() {
        System.out.println("likeSubmit");
        SubmitButton = new ButtonElement(BrowserFactory.getDriver().findElement( By.xpath("//div/section/span/button[@class=\'wpO6b  \']")));
        SubmitButton.click();
        return this;
    }
    @Step("likeCheck")
    public HomePO likeCheck() {
        System.out.println("likeCheck");
        return new HomePO();
    }

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
    @Step("goToPostPage")
    public LoginPO goToPostPage(String post) {
        System.out.println("goToPostPage");
        BrowserFactory.getDriver().navigate().to("https://www.instagram.com/p/" + post);
        return this;
    }

}
