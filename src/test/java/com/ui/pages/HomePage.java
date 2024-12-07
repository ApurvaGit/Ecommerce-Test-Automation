package com.ui.pages;

import com.constants.Browser;
import static com.constants.Env.*;

import com.constants.Env;
import com.utility.BrowserUtility;
import static com.utility.PropertiesUtil.*;

import com.utility.JSONUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public final class HomePage extends BrowserUtility {
    Logger logger = LoggerUtility.getLogger(this.getClass());

    private static final By signInLocator = By.xpath("//a[contains(text(),'Sign in')]");
    //By signInLocator;
    public HomePage(Browser browserName) {
        // public HomePage(Browser browserName,boolean isHeadless) {
        super(browserName);
       //super(browserName,isHeadless);
        //logger.info("Launching the Home Page");     //Logger is added to the browser utility class and can be used for all the classes
        //U can leave it like this or for better readability u can make static import of PropertiesUtil and Env and remove them from the following line as below
        //goToWebsite(PropertiesUtil.readProperty(Env.QA, "URL"));
        //goToWebsite(readProperty(QA, "URL"));
      // By signInLocator = By.xpath("//a[contains(text(),'Sign in')]");
        goToWebsite(JSONUtility.readJSON(QA).getUrl());
    }

    public LoginPage goToLoginPage(){
        logger.info("Performing Login on Login Page");
        clickOn(signInLocator);
        LoginPage logInPage = new LoginPage(getDriver());
        return logInPage;
    }
}
