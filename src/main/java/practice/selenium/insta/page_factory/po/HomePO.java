package practice.selenium.insta.page_factory.po;

import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import practice.selenium.decorator.ButtonElement;

public class HomePO extends BasicPO{

    @FindBy(xpath = "//*[@data-testid=\"user-avatar\"]")
    private ButtonElement userLogo;

    @FindBy(xpath = "//*[@class=\'sqdOP  L3NKy    _8A5w5    \']")
    private ButtonElement profilePhoto;

    @Override
    @Step("isOpen")
    public boolean isOpen() {
        return userLogo.waitForMeVisible(10000);
    }
    @Override
    @Step("isFollowUser")
    public boolean isFollowUser() {
        return profilePhoto.waitForMeVisible(10000);
    }
    @Override
    @Step("isFollowGroup")
    public boolean isFollowGroup() {
        return profilePhoto.waitForMeVisible(10000);
    }
}
