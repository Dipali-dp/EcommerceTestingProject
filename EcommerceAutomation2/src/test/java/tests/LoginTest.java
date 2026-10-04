package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import pages.LoginPage;
import utilities.ConfigReader;

public class LoginTest extends BaseClass {

    @Test
    public void loginTest() {

        logger.info("Login test started");

        LoginPage loginPage =
                new LoginPage(driver);

        logger.info("LoginPage object created");


        // Open Login Page
        loginPage.clickLoginSignup();

        logger.info("Clicked Signup / Login");


        // Get Login Credentials
        String email =
                ConfigReader.getProperty("email");

        String password =
                ConfigReader.getProperty("password");

        logger.info("Login credentials loaded from configuration");


        // Enter Credentials
        loginPage.enterEmail(email);

        loginPage.enterPassword(password);

        logger.info("Login credentials entered");


        // Login
        loginPage.clickLogin();

        logger.info("Login button clicked");


        // Verify Login
        Assert.assertTrue(
                loginPage.isLoggedIn(),
                "Login was not successful"
        );

        logger.info("Login verified successfully");

        logger.info("Login test passed successfully");

        System.out.println(
                "Login test passed successfully"
        );
    }
}