package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import static com.constants.Browser.CHROME;

public class TestBase {
    protected HomePage homePage;
    Logger logger = LoggerUtility.getLogger(this.getClass());
    String browser;
   // private boolean isHeadless = true;

    @Parameters({"browser"})    //
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {     //, (@Optional(false) boolean isHeadless
        logger.info("Load Home Page");
        //homePage = new HomePage(Browser.valueOf(browser.toUpperCase()),isHeadless);
        homePage = new HomePage(Browser.valueOf(browser.toUpperCase()));
    }

    public BrowserUtility getInstance(){
        return homePage;
    }

    @AfterMethod
    public void tearDown(){
        homePage.tearDown();
    }
}
