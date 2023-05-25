package listener;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Log4j
public class TestListener implements ITestListener {


    @Override
    public void onTestFailure(ITestResult result) {
        log.info("---------------------------------------------------------------");
        log.info("Failed because of - " + result.getThrowable());
        log.info("---------------------------------------------------------------");
        captureScreen(WebDriverRunner.getWebDriver());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("---------------------------------------------------------------");
        log.info("Skipped because of - " + result.getThrowable());
        log.info("---------------------------------------------------------------");
        captureScreen(WebDriverRunner.getWebDriver());

    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info("---------------------------------------------------------------");
        log.info(result.getMethod().getMethodName() + " Started");
        log.info("---------------------------------------------------------------");
        log.info(result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("---------------------------------------------------------------");
        log.info(result.getMethod().getMethodName() + " Passed");
        log.info("---------------------------------------------------------------");
    }

    @Override
    public void onStart(ITestContext context) {
        log.info("===============================================================");
        log.info("     On Start :-" + context.getName() + "                      ");
        log.info("===============================================================");
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("===============================================================");
        log.info("     On Finish :-" + context.getName() + "                     ");
        log.info("===============================================================");
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] captureScreen(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
