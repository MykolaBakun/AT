package practice.selenium.insta.page_factory.bo;

import io.qameta.allure.Step;
import practice.hibernate.model.User;
import practice.selenium.insta.page_factory.po.LoginPO;

import static practice.hibernate.HibernateTest.getUser;

public class LoginBO {

    @Step("isOpen")
    public boolean login(Integer userId) {
        LoginPO loginPO = new LoginPO().goToLoginPage();
        User user = getUser(userId);
        return loginPO.isOpen()
                &&
                loginPO.inputLogin(user.getLogin())
                        .inputPassword(user.getPass())
                        .loginSubmit()
                        .loginCheck()
                        .isOpen();
    }

    @Step("isFollowToUser")
    public boolean followToUser(Integer userId) {
        LoginPO loginPO = new LoginPO().goToLoginPage();
        User user = getUser(userId);
        return loginPO.inputLogin(user.getLogin())
                        .inputPassword(user.getPass())
                        .loginSubmit()
                        .mySleep(8000)
                        .goToUserPage()
                        .followUserSubmit()
                        .followUserCheck()
                        .isFollowUser();
    }

    @Step("isFollowToGroup")
    public boolean followToGroup(Integer userId) {
        LoginPO loginPO = new LoginPO().goToLoginPage();
        System.out.println("getUser");
        User user = getUser(userId);
        System.out.println("Do");
        return loginPO.inputLogin(user.getLogin())
                        .inputPassword(user.getPass())
                        .loginSubmit()
                        .mySleep(8000)
                        .goToGroupPage()
                        .followGroupSubmit()
                        .followGroupCheck()
                        .isFollowGroup();
    }
}
