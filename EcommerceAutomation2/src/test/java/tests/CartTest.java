package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import pages.CartPage;

public class CartTest extends BaseClass {

    @Test
    public void addProductToCartTest() {

        logger.info("Cart test started");

        CartPage cartPage =
                new CartPage(driver);

        logger.info("CartPage object created");


        // Step 1 - Open Products
        cartPage.clickProducts();

        logger.info("Products page opened");


        // Step 2 - Add Product
        cartPage.addProductToCart();

        logger.info("Product added to cart");


        // Step 3 - Open Cart
        cartPage.clickViewCart();

        logger.info("Cart page opened");


        // Step 4 - Verify Product
        Assert.assertTrue(
                cartPage.isProductDisplayedInCart(),
                "Product is not displayed in cart"
        );

        logger.info("Product verified successfully in cart");

        logger.info("Cart test passed successfully");

        System.out.println(
                "Product successfully verified in cart"
        );
    }
}