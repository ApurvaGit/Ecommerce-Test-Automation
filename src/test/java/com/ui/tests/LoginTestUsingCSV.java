package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.pojo.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

public class LoginTestUsingCSV extends TestBase{
    /*About test methods
    test script small
    can not have conditional statements
    reduce use of local variables
    at least one assertion
    * */

    HomePage homePage;
    String browser;

    @Parameters({"browser","isHeadless"})
    @BeforeMethod
    public void setUp(String browser) {     //, boolean isHeadless
       // homePage = new HomePage(Browser.valueOf(browser.toUpperCase()),isHeadless);
        homePage = new HomePage(Browser.valueOf(browser.toUpperCase()));
    }

   /*Read Data from Json file
   @Test(description = "Verify valid user is login into the application", groups = {"regression","sanity"},
    dataProviderClass = com.ui.dataprovider.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
     public void loginTest(User user){
          //Passing hard code data
         //assertEquals(homePage.goToLoginPage().doLoginWith("tiyil70845@cpaurl.com", "testapp").getUserName(),"Test App");

        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),"Test App");

    }*/

    @Test(description = "Verify valid user is login into the application", groups = {"regression", "sanity"},
            dataProviderClass = com.ui.dataprovider.LoginDataProvider.class, dataProvider = "loginTestCSVDataProvider")
    public void loginCSVTest(User user) {

        //assertEquals(homePage.goToLoginPage().doLoginWith("tiyil70845@cpaurl.com", "testapp").getUserName(),"Test App");

        //Read Data from CSV file
        homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName();
        //assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Test App");
    }


/*    @Test(description = "Verify valid user is login into the application", groups = {"regression", "sanity"},
            dataProviderClass = com.ui.dataprovider.LoginDataProvider.class, dataProvider = "loginTestExcelDataProvider")
    public void loginExcelTest(User user) {
        //Read Data from Excel file
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Test App");
    }*/
}