package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            String reportPath = System.getProperty("user.dir")
                    + "/test-output/ExtentReport.html";

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(reportPath);

            sparkReporter.config().setReportName(
                    "E-Commerce Automation Test Report"
            );

            sparkReporter.config().setDocumentTitle(
                    "Automation Test Execution Report"
            );

            extent = new ExtentReports();

            extent.attachReporter(sparkReporter);

            extent.setSystemInfo(
                    "Project",
                    "E-Commerce Automation"
            );

            extent.setSystemInfo(
                    "Tester",
                    "Dipali"
            );

            extent.setSystemInfo(
                    "Environment",
                    "Windows 11"
            );

            extent.setSystemInfo(
                    "Browser",
                    "Chrome"
            );
        }

        return extent;
    }
}