package ui.insta;

import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import practice.selenium.insta.page_factory.bo.LoginBO;
import practice.selenium.parallel_run.BrowserFactory;
import practice.test_helper.BaseTest;

@Test
public class LoginInstaThreadSafeTest extends BaseTest {
    @DataProvider(parallel = true)
    public static Object[][] browserDataProvider() {
        return new Object[][]{
                {"chrome"}
        };
    }

    //@Video
    @Issue("432")
    @Test(dataProvider = "browserDataProvider")
    @Severity(SeverityLevel.CRITICAL)
    public void loginTest(String browserName) {
        BrowserFactory.initDriver(browserName);
        LoginBO loginBO = new LoginBO();

        //Step1
        Assert.assertTrue(loginBO.login(),"login Failed!");

    }
}
