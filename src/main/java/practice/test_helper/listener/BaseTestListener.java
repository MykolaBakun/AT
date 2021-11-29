package practice.test_helper.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.log4j.Logger;
public class BaseTestListener implements ITestListener {

    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.info("onTestStart");
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("onTestSuccess");
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.info("onTestFailure");
        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        LOGGER.info("onStart");
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        LOGGER.info("onFinish");
        ITestListener.super.onFinish(context);
    }
}
