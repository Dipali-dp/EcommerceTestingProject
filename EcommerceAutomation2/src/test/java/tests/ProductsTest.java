package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import pages.productspage;

public class ProductsTest extends BaseClass {

    @Test
    public void searchProductTest() {

        logger.info("Products test started");

        productspage productsPage =
                new productspage(driver);

        logger.info("ProductsPage object created");


        // Open Products page
        productsPage.clickProducts();

        logger.info("Products page opened");


        // Search product
        productsPage.searchProduct("Blue Top");

        logger.info("Product search text entered: Blue Top");


        // Click Search
        productsPage.clickSearch();

        logger.info("Search button clicked");


        // Verify search result
        Assert.assertTrue(
                productsPage.isSearchResultDisplayed(),
                "Search result is not displayed"
        );

        logger.info("Search result verified successfully");

        logger.info("Products test passed successfully");

        System.out.println(
                "Product search test passed successfully"
        );
    }
}