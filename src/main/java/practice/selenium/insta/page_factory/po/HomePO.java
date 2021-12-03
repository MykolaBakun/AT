package practice.selenium.insta.page_factory.po;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import practice.selenium.decorator.ButtonElement;
import practice.selenium.parallel_run.BrowserFactory;

public class HomePO extends BasicPO{

    @FindBy(xpath = "//*[@data-testid=\"user-avatar\"]")
    private ButtonElement userLogo;

    @FindBy(xpath = "//*[@class=\'sqdOP  L3NKy    _8A5w5    \']")
    private ButtonElement profilePhoto;
    @FindBy(xpath = "//*[@class=\'wpO6b  \']")
    private ButtonElement like;

    @Override
    @Step("isOpen")
    public boolean isOpen() {
        return userLogo.waitForMeVisible(10000);
    }
    @Override
    @Step("isFollowUser")
    public boolean isFollowUser() {
        return new ButtonElement(BrowserFactory.getDriver().findElement(By.xpath("//button[normalize-space()=\'Requested\']"))).waitForMeVisible(10000);
    }
    @Override
    @Step("isFollowGroup")
    public boolean isFollowGroup() { return profilePhoto.waitForMeVisible(10000); }
    @Override
    @Step("isFollowGroup")
    public boolean isMassageSend() {
        return like.waitForMeVisible(10000);
    }
    @Override
    @Step("isLike")
    public boolean isLike() {
        return like.waitForMeVisible(10000);
    }
}
