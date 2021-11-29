package practice.test_helper.listener;

import io.qameta.allure.Attachment;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import practice.selenium.parallel_run.BrowserFactory;

public class CustomAllureListener implements ITestListener {
    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        LOGGER.info("screenshot");
        return ((TakesScreenshot)  BrowserFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "TestInfo", type = "text/html", fileExtension = "html")
    public String htmlSource() {
        LOGGER.info("htmlSource");
        return BrowserFactory.getDriver().getPageSource();
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        screenshot();
        htmlSource();
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        screenshot();
        htmlSource();
        ITestListener.super.onTestFailure(result);
    }
}
