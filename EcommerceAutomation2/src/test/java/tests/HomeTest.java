package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;

public class HomeTest extends BaseClass {

    @Test
    public void homeTest() {

        logger.info("Home test started");

        String currentUrl = driver.getCurrentUrl();

        logger.info("Current URL: " + currentUrl);

        Assert.assertTrue(
                currentUrl.equals("https://www.automationexercise.com/"),
                "Home page is not displayed"
        );

        logger.info("Home page verified successfully");

        logger.info("Home test passed successfully");

        System.out.println(
                "Home page verified successfully"
        );
    }
}