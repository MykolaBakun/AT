package practice.selenium.insta.page_factory.bo;

import io.qameta.allure.Step;
import practice.PropertyUtil;
import practice.selenium.insta.page_factory.po.LoginPO;

public class LoginBO {

    @Step("isOpen")
    public boolean login() {

        LoginPO loginPO = new LoginPO()
                .goToLoginPage();

        return loginPO.isOpen()
                &&
                loginPO
                .inputLogin((String) new PropertyUtil().getProperty("login"))
                .inputPassword((String) new PropertyUtil().getProperty("pass"))
                .submit()
                .isOpen();
    }
}
