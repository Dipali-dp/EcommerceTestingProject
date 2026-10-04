package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import pages.CartPage;
import pages.LoginPage;

public class CheckoutTest extends BaseClass {

    @Test
    public void checkoutTest() {

        logger.info("Checkout test started");

        // ==============================
        // CREATE OBJECTS
        // ==============================

        LoginPage loginPage =
                new LoginPage(driver);

        CartPage cartPage =
                new CartPage(driver);

        logger.info("LoginPage and CartPage objects created");


        // ==============================
        // 1. LOGIN
        // ==============================

        loginPage.clickLoginSignup();

        logger.info("Clicked Signup / Login");

        loginPage.enterEmail(
                "dipalipawar07119@gmail.com"
        );

        loginPage.enterPassword(
                "Dipali@07"
        );

        logger.info("Login credentials entered");

        loginPage.clickLogin();

        logger.info("Login successful");

        System.out.println(
                "Login successful"
        );


        // ==============================
        // 2. OPEN PRODUCTS
        // ==============================

        cartPage.clickProducts();

        logger.info("Products page opened");


        // ==============================
        // 3. ADD PRODUCT
        // ==============================

        cartPage.addProductToCart();

        logger.info("Product added to cart");


        // ==============================
        // 4. OPEN CART
        // ==============================

        cartPage.clickViewCart();

        logger.info("Cart page opened");


        // ==============================
        // 5. VERIFY PRODUCT
        // ==============================

        boolean productDisplayed =
                cartPage.isProductDisplayedInCart();

        Assert.assertTrue(
                productDisplayed,
                "Product is not displayed in cart"
        );

        logger.info("Product verified successfully in cart");


        // ==============================
        // 6. PROCEED TO CHECKOUT
        // ==============================

        boolean checkoutOpened =
                cartPage.proceedToCheckout();

        logger.info("Clicked Proceed to Checkout");


        // ==============================
        // 7. VERIFY CHECKOUT
        // ==============================

        Assert.assertTrue(
                checkoutOpened,
                "Checkout page is not opened"
        );

        logger.info("Checkout page verified successfully");

        logger.info("Checkout test passed successfully");

        System.out.println(
                "Checkout test completed successfully"
        );
    }
}