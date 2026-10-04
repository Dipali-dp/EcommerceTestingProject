package Base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

    protected WebDriver driver;

    protected static final Logger logger =
            LogManager.getLogger(BaseClass.class);

    @BeforeMethod
    public void setup() {

        logger.info("Test execution started");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);

        logger.info("Chrome browser launched successfully");

        driver.manage().window().maximize();

        logger.info("Browser window maximized");

        driver.get("https://www.automationexercise.com/");

        logger.info("Automation Exercise website opened");

        System.out.println(
                "Browser opened successfully"
        );

        System.out.println(
                "Current URL: " + driver.getCurrentUrl()
        );
    }

    @AfterMethod
    public void teardown() {

        if (driver != null) {

            driver.quit();

            logger.info("Browser closed successfully");

            System.out.println(
                    "Browser closed successfully"
            );
        }
    }

    public WebDriver getDriver() {

        return driver;
    }
}