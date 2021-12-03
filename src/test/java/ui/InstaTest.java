package ui;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import practice.selenium.insta.page_factory.bo.LoginBO;
import practice.selenium.parallel_run.BrowserFactory;
//import practice.test_helper.BaseTest;

@Test
public class InstaTest {
    @DataProvider(parallel = true)
    public static Object[][] browserDataProvider() {
        return new Object[][]{
                {"chrome"},
//                {"chrome"},
                {"edge"}
        };
    }


    @Test(dataProvider = "browserDataProvider")
    @Severity(SeverityLevel.CRITICAL)
    public void loginTest(String browserName) {
        BrowserFactory.initDriver(browserName);
        LoginBO loginBO = new LoginBO();
        Assert.assertTrue(loginBO.login(2),"login Failed!");

    }
    @Severity(SeverityLevel.CRITICAL)
    public void followToUserTest() {
        BrowserFactory.initDriver("edge");
        LoginBO loginBO = new LoginBO();
        Assert.assertTrue(loginBO.followToUser(5),"Follow Failed!");

    }
    @Severity(SeverityLevel.CRITICAL)
    public void followToGroupTest() {
        BrowserFactory.initDriver("chrome");
        LoginBO loginBO = new LoginBO();
        Assert.assertTrue(loginBO.followToGroup(5),"Follow Failed!");

    }
}
