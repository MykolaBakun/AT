package practice.test_helper;

import com.automation.remarks.testng.UniversalVideoListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import practice.selenium.parallel_run.BrowserFactory;
import practice.test_helper.listener.BaseTestListener;
import practice.test_helper.listener.CustomAllureListener;

@Listeners({
       // BaseTestListener.class,
        UniversalVideoListener.class,
        CustomAllureListener.class
})
public class BaseTest {

    @AfterTest
    void quitBrowser(){
        BrowserFactory.getDriver().quit();
        BrowserFactory.getDriver().close();
    }
}
