package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public final class MyAccountPage extends BrowserUtility {
    private static final By USER_NAME_LOCATOR = By.xpath("//a[@title=\"View my customer account\"]/span");
    private static final By SEARCH_BOX_LOCATOR = By.id("search_query_top");
    private static final By SUBMIT_SEARCH_LOCATOR = By.name("submit_search");
    private static final By USER_ADDRESS_LOCATOR = By.xpath("//a[@title=\"Add my first address\"]");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getUserName(){
        return getText(USER_NAME_LOCATOR);
    }

    public SearchResultPage productSearch(String productName){
        enterText(SEARCH_BOX_LOCATOR,productName);
        enterSpecialKey(SEARCH_BOX_LOCATOR, Keys.ENTER);
        SearchResultPage searchResultPage = new SearchResultPage(getDriver());
        return searchResultPage;
    }
    public AddressPage goToAddAddressPage(){
        clickOn(USER_ADDRESS_LOCATOR);
        AddressPage addressPage = new AddressPage(getDriver());
        return addressPage;
    }
}
