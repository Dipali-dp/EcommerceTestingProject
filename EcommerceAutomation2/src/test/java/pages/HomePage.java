package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // =========================
    // Locators
    // =========================

    @FindBy(xpath = "//a[@href='/']")
    private WebElement homeLink;


    // =========================
    // Constructor
    // =========================

    public HomePage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
        );

        PageFactory.initElements(driver, this);
    }


    // =========================
    // Actions
    // =========================

    public void clickHome() {

        WebElement element =
                wait.until(ExpectedConditions.elementToBeClickable(homeLink));

        element.click();
    }


    // =========================
    // Verification
    // =========================

    public boolean isHomePageDisplayed() {

        try {

            return driver.getCurrentUrl().equals(
                    "https://www.automationexercise.com/"
            );

        } catch (Exception e) {

            return false;
        }
    }
}