package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class LogInPage extends BrowserUtility {
    private static final By EMAIL_LOCATOR = By.id("email");
    private static final By PASSWORD_LOCATOR= By.id("passwd");
    private static final By SUBLIT_LOGIN_BUTTON_LOCATOR = By.id("SubmitLogin");

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage doLoginWith(String emailAddress, String password){
        enterText(EMAIL_LOCATOR,emailAddress);
        enterText(PASSWORD_LOCATOR,password);
        clickOn(SUBLIT_LOGIN_BUTTON_LOCATOR);
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        return myAccountPage;
    }
}