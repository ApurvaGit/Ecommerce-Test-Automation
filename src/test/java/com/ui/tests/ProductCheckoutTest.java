package com.ui.tests;

import static com.constants.DressSize.*;
import com.ui.pages.SearchResultPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductCheckoutTest extends TestBase {
    private static final String SEARCH_TERM = "Summer Dress";


    SearchResultPage searchResultPage;

    @BeforeMethod(description = "User logs into the application and searches for the product")
    public void setup() {
        searchResultPage = homePage.goToLoginPage().doLoginWith("hornyashel27@remaild.com", "testapp")
                .productSearch(SEARCH_TERM);
    }

    @Test(description = "Verify if the loggedin user is able to buy a dress", groups = {"regression", "sanity"})
    public void checkoutTest() {
       String result = searchResultPage.clickOnTheProduct(1).selectSize(M)
                .addProductToCart()
                .proceedToCheckout()
                .goToConfirmAddressPage()
                .goToShipmentPage()
                .goToPaymentPage().makePaymentByWire();

        Assert.assertTrue(result.contains("Your order on My Shop is complete."));
    }
}
