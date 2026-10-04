package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Payment page locators
    private By nameOnCard =
            By.xpath("//input[@data-qa='name-on-card']");

    private By cardNumber =
            By.xpath("//input[@data-qa='card-number']");

    private By cvc =
            By.xpath("//input[@data-qa='cvc']");

    private By expiryMonth =
            By.xpath("//input[@data-qa='expiry-month']");

    private By expiryYear =
            By.xpath("//input[@data-qa='expiry-year']");

    private By payAndConfirmOrder =
            By.xpath("//button[@data-qa='pay-button']");

    // Constructor
    public PaymentPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );
    }

    // Enter name
    public void enterNameOnCard(String name) {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                nameOnCard
                        )
                );

        element.clear();
        element.sendKeys(name);
    }

    // Enter card number
    public void enterCardNumber(String cardNumberValue) {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                cardNumber
                        )
                );

        element.clear();
        element.sendKeys(cardNumberValue);
    }

    // Enter CVC
    public void enterCVC(String cvcValue) {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                cvc
                        )
                );

        element.clear();
        element.sendKeys(cvcValue);
    }

    // Enter expiry month
    public void enterExpiryMonth(String month) {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                expiryMonth
                        )
                );

        element.clear();
        element.sendKeys(month);
    }

    // Enter expiry year
    public void enterExpiryYear(String year) {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                expiryYear
                        )
                );

        element.clear();
        element.sendKeys(year);
    }

    // Click Pay and Confirm Order
    public void clickPayAndConfirmOrder() {

        WebElement element =
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(
                                payAndConfirmOrder
                        )
                );

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        element
                );

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        element
                );
    }
}