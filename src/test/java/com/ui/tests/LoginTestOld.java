package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestOld {

    public static void main (String [] args){
     /*   WebDriver wd = new ChromeDriver();      //open browser window , session is created
        HomePage homePage = new HomePage(Browser.valueOf(browser.));
       // HomePage homePage = new HomePage(Browser.CHROME,false);
        LogInPage logInPage = homePage.goToLoginPage();
        logInPage.doLoginWith("tiyil70845@cpaurl.com","testapp");

*/
        //CODE BEFORE POM
      /*  BrowserUtility browserUtility = new BrowserUtility(wd);
        browserUtility.goTOWebsite("http://www.automationpractice.pl/index.php?");


        //wd.manage().window().maximize();
        browserUtility.maximiseWindow();

        By signInLocator = By.xpath("//a[contains(text(),'Sign in')]");
      *//*  WebElement signInWebElement = wd.findElement(signInLocator);      //wd need By type of variable which we got from By class using By.xpath
        //wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
        signInWebElement.click();*//*
        browserUtility.clickOn(signInLocator);

        By emailLocator = By.id("email");
        browserUtility.enterText(emailLocator,"tiyil70845@cpaurl.com");

        By passwordLocator= By.id("passwd");
        browserUtility.enterText(passwordLocator,"testapp");

        By submitLoginButtonLocator = By.id("SubmitLogin");
        browserUtility.clickOn(submitLoginButtonLocator);


        System.out.println("success");*/
        //wd.close();
    }
}
