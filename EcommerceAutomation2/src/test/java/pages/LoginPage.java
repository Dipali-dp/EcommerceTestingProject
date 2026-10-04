package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Login / Signup link
    private By loginSignupLink =
            By.xpath("//a[contains(text(),'Signup / Login')]");

    // Login fields
    private By emailField =
            By.xpath("//input[@data-qa='login-email']");

    private By passwordField =
            By.xpath("//input[@data-qa='login-password']");

    // Login button
    private By loginButton =
            By.xpath("//button[@data-qa='login-button']");

    // Logout link - used to verify successful login
    private By logoutLink =
            By.xpath("//a[contains(text(),'Logout')]");


    public LoginPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );
    }


    // Click Signup / Login
    public void clickLoginSignup() {

        WebElement element =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                loginSignupLink
                        )
                );

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        element
                );
    }


    // Enter email
    public void enterEmail(String email) {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                emailField
                        )
                );

        element.clear();
        element.sendKeys(email);
    }


    // Enter password
    public void enterPassword(String password) {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                passwordField
                        )
                );

        element.clear();
        element.sendKeys(password);
    }


    // Click Login
    public void clickLogin() {

        WebElement element =
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(
                                loginButton
                        )
                );

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        element
                );

        wait.until(
                ExpectedConditions.visibilityOf(element)
        );

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        element
                );
    }


    // Verify successful login
    public boolean isLoggedIn() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            logoutLink
                    )
            ).isDisplayed();

        } catch (Exception e) {

            System.out.println(
                    "Logout link was not displayed after login."
            );

            System.out.println(
                    "Current URL: " + driver.getCurrentUrl()
            );

            return false;
        }
    }
}