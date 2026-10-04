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

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//a[@href='/products']")
    private WebElement productsLink;

    @FindBy(xpath = "(//a[contains(@class,'add-to-cart')])[1]")
    private WebElement firstAddToCart;

    @FindBy(xpath = "//div[contains(@class,'modal-content')]//a[@href='/view_cart']")
    private WebElement popupViewCart;

    @FindBy(xpath = "//table[@id='cart_info_table']//tbody/tr")
    private WebElement cartProduct;

    @FindBy(xpath = "//a[contains(@class,'check_out')]")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
        );

        PageFactory.initElements(driver, this);
    }

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
    }

    public void openProductsPage() {
        clickProducts();
    }

    public void addProductToCart() {

        WebElement element =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                firstAddToCart
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
                ExpectedConditions.visibilityOf(popupViewCart)
        );
    }

    public void clickViewCart() {

        WebElement element =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                popupViewCart
                        )
                );

        element.click();

        wait.until(
                ExpectedConditions.urlContains("/view_cart")
        );

        wait.until(
                ExpectedConditions.visibilityOf(cartProduct)
        );
    }

    public boolean isProductDisplayedInCart() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOf(cartProduct)
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    public boolean proceedToCheckout() {

        try {

            WebElement element =
                    wait.until(
                            ExpectedConditions.elementToBeClickable(
                                    checkoutButton
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
                    ExpectedConditions.urlContains("/checkout")
            );

            return true;

        } catch (Exception e) {

            return false;
        }
    }
}