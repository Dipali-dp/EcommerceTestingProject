package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//a[contains(normalize-space(),'Place Order')]")
    private WebElement placeOrderButton;

    public CheckoutPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
        );

        PageFactory.initElements(driver, this);
    }

    public void clickPlaceOrder() {

        WebElement element =
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(
                                org.openqa.selenium.By.xpath(
                                        "//a[contains(normalize-space(),'Place Order')]"
                                )
                        )
                );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                element
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                element
        );

        wait.until(
                ExpectedConditions.urlContains("/payment")
        );
    }

    public boolean isPaymentPageDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.urlContains("/payment")
            );

        } catch (Exception e) {

            System.out.println(
                    "Payment page was not displayed."
            );

            System.out.println(
                    "Current URL: " + driver.getCurrentUrl()
            );

            return false;
        }
    }
}