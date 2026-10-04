package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class productspage {

    private WebDriver driver;
    private WebDriverWait wait;

    // =========================
    // Locators
    // =========================

    @FindBy(xpath = "//a[@href='/products']")
    private WebElement productsLink;

    @FindBy(id = "search_product")
    private WebElement searchBox;

    @FindBy(id = "submit_search")
    private WebElement searchButton;

    // =========================
    // Constructor
    // =========================

    public productspage(WebDriver driver) {

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

    public void clickProducts() {

        WebElement element =
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(
                                By.xpath("//a[@href='/products']")
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
                ExpectedConditions.urlContains("/products")
        );

        System.out.println("Products page opened successfully");
    }

    public void searchProduct(String productName) {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOf(searchBox)
                );

        element.clear();

        element.sendKeys(productName);

        System.out.println(
                "Product search text entered successfully"
        );
    }

    public void clickSearch() {

        WebElement element =
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(
                                By.id("submit_search")
                        )
                );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                element
        );

        // JavaScript click is used because advertisement
        // iframe can intercept normal Selenium click.
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                element
        );

        wait.until(
                ExpectedConditions.urlContains("/products?search=")
        );

        System.out.println("Search button clicked successfully");
    }

    // =========================
    // Assertion / Verification
    // =========================

    public boolean isSearchResultDisplayed() {

        try {

            WebElement result =
                    wait.until(
                            ExpectedConditions.presenceOfElementLocated(
                                    By.xpath(
                                            "//div[@class='features_items']" +
                                            "//div[contains(@class,'product-image-wrapper')]"
                                    )
                            )
                    );

            return result.isDisplayed();

        } catch (Exception e) {

            System.out.println(
                    "No products found for searched product."
            );

            System.out.println(
                    "Current URL: " + driver.getCurrentUrl()
            );

            return false;
        }
    }
}