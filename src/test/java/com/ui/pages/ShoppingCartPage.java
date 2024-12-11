package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BrowserUtility {
    private static final By SHOPPING_CART_CHECKOUT_LOCATOR = By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    public ConfirmAddressPage goToConfirmAddressPage(){
        clickOn(SHOPPING_CART_CHECKOUT_LOCATOR);
        return new ConfirmAddressPage(getDriver());
    }
}

