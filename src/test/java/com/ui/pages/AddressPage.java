package com.ui.pages;

import com.ui.pojo.Address;
import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressPage extends BrowserUtility {
    private static final By COMPANY_TEXTBOX_LOCATOR = By.id("company");
    private static final By ADDRESS_TEXTBOX1_LOCATOR = By.id("address1");
    private static final By ADDRESS_TEXTBOX2_LOCATOR = By.id("address2");
    private static final By CITY_TEXTBOX_LOCATOR = By.id("city");
    private static final By POST_CODE_TEXTBOX_LOCATOR = By.id("postcode");
    private static final By HOME_PHONE_TEXTBOX_LOCATOR = By.id("phone");
    private static final By PHONE_MOBILE_TEXTBOX_LOCATOR = By.id("phone_mobile");
    private static final By OTHER_INFO_TEXTAREA_LOCATOR = By.id("other");
    private static final By ADDRESS_ALIAS_TEXTBOX_LOCATOR = By.id("alias");
    private static final By STATE_DROPDOWN_LOCATOR = By.id("id_state");
    private static final By SAVE_ADDRESS_BUTTON_LOCATOR = By.id("submitAddress");
    private static final By ADDRESS_HEADING = By.xpath("//h3[@class='page-subheading']");
    public AddressPage(WebDriver driver){
        super(driver);
    }

    public String createAddress(Address address){
       /* enterText(COMPANY_TEXTBOX_LOCATOR,"XYZ");
        enterText(ADDRESS_TEXTBOX1_LOCATOR,"Address 1");
        enterText(ADDRESS_TEXTBOX2_LOCATOR,"Address 2");
        enterText(CITY_TEXTBOX_LOCATOR,"City");
        selectFromDropdown(STATE_DROPDOWN_LOCATOR,"Hawaii");
        enterText(POST_CODE_TEXTBOX_LOCATOR,"12345");
        enterText(HOME_PHONE_TEXTBOX_LOCATOR,"2222222222");
        enterText(PHONE_MOBILE_TEXTBOX_LOCATOR,"343434343");
        enterText(OTHER_INFO_TEXTAREA_LOCATOR,"more info");
        clearText(ADDRESS_ALIAS_TEXTBOX_LOCATOR);
        enterText(ADDRESS_ALIAS_TEXTBOX_LOCATOR,"Home address");
        //clickOn(SAVE_ADDRESS_SUBMIT_LOCATOR);*/

        //Using Address POJO instead off hardcoding or passing parameters into the methods)
        enterText(COMPANY_TEXTBOX_LOCATOR,address.getCompany());
        enterText(ADDRESS_TEXTBOX1_LOCATOR,address.getAddress1());
        enterText(ADDRESS_TEXTBOX2_LOCATOR,address.getAddress2());
        enterText(CITY_TEXTBOX_LOCATOR,address.getCity());
        selectFromDropdown(STATE_DROPDOWN_LOCATOR,address.getState());
        enterText(POST_CODE_TEXTBOX_LOCATOR,address.getPostcode());
        enterText(HOME_PHONE_TEXTBOX_LOCATOR,address.getHomePhoneNumber());
        enterText(PHONE_MOBILE_TEXTBOX_LOCATOR,address.getMobileNumber());
        enterText(OTHER_INFO_TEXTAREA_LOCATOR,address.getOtherInfo());
        clearText(ADDRESS_ALIAS_TEXTBOX_LOCATOR);
        enterText(ADDRESS_ALIAS_TEXTBOX_LOCATOR,address.getAddressAlias());
        clickOn(SAVE_ADDRESS_BUTTON_LOCATOR);
        String newAddress = getVisibleText(ADDRESS_HEADING);
        return newAddress;
    }
}
