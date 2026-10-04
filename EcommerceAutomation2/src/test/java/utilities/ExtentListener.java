package utilities;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Base.BaseClass;

public class ExtentListener implements ITestListener {

    private static ExtentReports extent =
            ExtentManager.getInstance();

    private static ExtentTest test;

    
    public void onTestStart(ITestResult result) {

        test = extent.createTest(
                result.getMethod().getMethodName()
        );

        test.info("Test Started");
    }

    
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed Successfully");
    }

    
    public void onTestFailure(ITestResult result) {

        test.fail("Test Failed");

        if (result.getThrowable() != null) {
            test.fail(result.getThrowable());
        }

        try {

            // Get current test class instance
            BaseClass baseClass =
                    (BaseClass) result.getInstance();

            // Get WebDriver
            WebDriver driver =
                    baseClass.getDriver();

            // Screenshot folder
            String folderPath =
                    System.getProperty("user.dir")
                    + "/test-output/screenshots/";

            File folder = new File(folderPath);

            if (!folder.exists()) {
                folder.mkdirs();
            }

            // Screenshot file path
            String screenshotPath =
                    folderPath
                    + result.getMethod().getMethodName()
                    + ".png";

            // Take screenshot
            File source =
                    ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            // Save screenshot
            Files.copy(
                    source.toPath(),
                    new File(screenshotPath).toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );

            // Attach screenshot to Extent Report
            test.addScreenCaptureFromPath(
                    screenshotPath
            );

        } catch (Exception e) {

            test.info(
                    "Screenshot could not be captured: "
                    + e.getMessage()
            );
        }
    }

    
    public void onTestSkipped(ITestResult result) {

        test.skip("Test Skipped");
    }

    
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}