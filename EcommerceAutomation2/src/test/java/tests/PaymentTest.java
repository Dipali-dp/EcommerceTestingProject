package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import pages.LoginPage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.PaymentPage;
import utilities.ConfigReader;

public class PaymentTest extends BaseClass {

    @Test
    public void paymentTest() {

        logger.info("Payment test started");

        // =========================
        // LOGIN
        // =========================

        LoginPage loginPage =
                new LoginPage(driver);

        logger.info("LoginPage object created");

        loginPage.clickLoginSignup();

        logger.info("Clicked Signup / Login");

        String email =
                ConfigReader.getProperty("email");

        String password =
                ConfigReader.getProperty("password");

        loginPage.enterEmail(email);
        loginPage.enterPassword(password);

        logger.info("Login credentials entered");

        loginPage.clickLogin();

        logger.info("Login successful");

        System.out.println("Login successful");


        // =========================
        // ADD PRODUCT TO CART
        // =========================

        CartPage cartPage =
                new CartPage(driver);

        logger.info("CartPage object created");

        cartPage.clickProducts();

        logger.info("Products page opened");

        cartPage.addProductToCart();

        logger.info("Product added to cart");

        System.out.println(
                "Product added to cart"
        );


        // =========================
        // OPEN CART
        // =========================

        cartPage.clickViewCart();

        logger.info("Cart page opened");

        Assert.assertTrue(
                cartPage.isProductDisplayedInCart(),
                "Product was not displayed in cart"
        );

        logger.info("Product verified successfully in cart");

        System.out.println(
                "Product verified in cart"
        );


        // =========================
        // PROCEED TO CHECKOUT
        // =========================

        boolean checkoutSuccess =
                cartPage.proceedToCheckout();

        logger.info("Clicked Proceed to Checkout");

        Assert.assertTrue(
                checkoutSuccess,
                "Checkout page was not displayed"
        );

        logger.info("Checkout page opened successfully");

        System.out.println(
                "Checkout page opened successfully"
        );


        // =========================
        // PLACE ORDER
        // =========================

        CheckoutPage checkoutPage =
                new CheckoutPage(driver);

        logger.info("CheckoutPage object created");

        checkoutPage.clickPlaceOrder();

        logger.info("Place Order clicked");

        Assert.assertTrue(
                checkoutPage.isPaymentPageDisplayed(),
                "Payment page was not displayed"
        );

        logger.info("Payment page opened successfully");

        System.out.println(
                "Payment page opened successfully"
        );


        // =========================
        // PAYMENT
        // =========================

        PaymentPage paymentPage =
                new PaymentPage(driver);

        logger.info("PaymentPage object created");

        paymentPage.enterNameOnCard("Dipali");

        paymentPage.enterCardNumber(
                "4111111111111111"
        );

        paymentPage.enterCVC("123");

        paymentPage.enterExpiryMonth("12");

        paymentPage.enterExpiryYear("2028");

        logger.info("Payment details entered successfully");

        System.out.println(
                "Payment details entered successfully"
        );


        // =========================
        // PAY AND CONFIRM ORDER
        // =========================

        paymentPage.clickPayAndConfirmOrder();

        logger.info("Pay and Confirm Order clicked");

        logger.info("Payment test completed successfully");

        System.out.println(
                "Payment test completed successfully"
        );
    }
}