package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BrowserUtility {
    private static final By PAY_BY_BANK_WIRE_LOCATOR = By.xpath("//a[@title='Pay by bank wire']");
    private static final By CONFIM_PAYMENT_BUTTON_LOCATOR = By.xpath("//button[@class='button btn btn-default button-medium']");
    private static final By ALERT_SUCCESS_MASSAGE_LOCATOR = By.xpath("//p[@class='alert alert-success']");

    public PaymentPage(WebDriver driver){
        super(driver);
    }
    public String makePaymentByWire(){
        clickOn(PAY_BY_BANK_WIRE_LOCATOR);
        clickOn(CONFIM_PAYMENT_BUTTON_LOCATOR);
        return getVisibleText(ALERT_SUCCESS_MASSAGE_LOCATOR);
    }
}
