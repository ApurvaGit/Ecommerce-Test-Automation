package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShipmentPage extends BrowserUtility {

    private static final By TERMS_OF_SERVICE_CHECKBOX_LOCATOR = By.xpath("//*[@id='uniform-cgv']");//*[@id="cgv"]
    private static final By SHIPPING_CHECKOUT_LOCATOR = By.name("processCarrier");

    public ShipmentPage(WebDriver driver){
        super(driver);
    }

    public PaymentPage goToPaymentPage(){

        clickOn(TERMS_OF_SERVICE_CHECKBOX_LOCATOR);
        clickOn(SHIPPING_CHECKOUT_LOCATOR);
        return new PaymentPage(getDriver());
    }


}
