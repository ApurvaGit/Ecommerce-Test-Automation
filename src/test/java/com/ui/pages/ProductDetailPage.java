package com.ui.pages;

import com.constants.DressSize;
import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BrowserUtility {

    private static final By SIZE_DROPDOWN_LOCATOR = By.id("group_1");
    private static final By DRESS_COLOR_LOCATOR = By.id("color_16");
    private static final By ADD_TO_CART_BUTTON_LOCATOR = By.xpath("//button[@name='Submit']");
    private static final By PRODUCT_CHECKOUT_LOCATOR = By.xpath("//a[@class='btn btn-default button button-medium']");



    public ProductDetailPage(WebDriver driver){
        super(driver);
    }

    public ProductDetailPage selectSize(DressSize size){
        selectFromDropdown(SIZE_DROPDOWN_LOCATOR,size.toString());
        return new ProductDetailPage(getDriver());
    }

    public ProductDetailPage addProductToCart(){
        clickOn(DRESS_COLOR_LOCATOR);
        clickOn(ADD_TO_CART_BUTTON_LOCATOR);
        return new ProductDetailPage(getDriver());
    }

    public ShoppingCartPage proceedToCheckout(){
        clickOn(PRODUCT_CHECKOUT_LOCATOR);
        return new ShoppingCartPage(getDriver());
    }
}
