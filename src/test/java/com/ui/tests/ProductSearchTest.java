package com.ui.tests;

import com.ui.pages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class ProductSearchTest extends TestBase{

    private MyAccountPage myAccountPage;
    private static final String SEARCH_TERM = "Summer Dresses";

    @BeforeMethod(description = "Valid user logs into the application")
    public void setup(){
       myAccountPage = homePage.goToLoginPage().doLoginWith("hornyashel27@remaild.com","testapp");
    }

    @Test(description="Verify product search into the application and correct products are displayed", groups = {"regression","sanity"})
    public void verifyProductSearchTest(){
       boolean actualResult = myAccountPage.productSearch(SEARCH_TERM).isSearchTermExistInProductList(SEARCH_TERM);
        Assert.assertEquals(actualResult,true);
    }
}