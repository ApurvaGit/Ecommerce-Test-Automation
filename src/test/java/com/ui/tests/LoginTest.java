package com.ui.tests;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import static com.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

@Listeners({com.ui.listeners.TestListner.class})
public class LoginTest extends TestBase{
    /*About test methods
    test script small
    can not have conditional statements
    reduce use of local variables
    at least one assertion*/

  //  HomePage homePage;
    Logger logger = LoggerUtility.getLogger(this.getClass());

/*    @BeforeMethod
    public void setUp() {
        logger.info("Load Home Page");
        homePage = new HomePage(CHROME);
    }*/

/*    @Test(description = "Verify valid user is login into the application", groups = {"regression","sanity"},
    dataProviderClass = com.ui.dataprovider.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
     public void loginTest(User user){
        //assertEquals(homePage.goToLoginPage().doLoginWith("tiyil70845@cpaurl.com", "testapp").getUserName(),"Test App");
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),"Test App");
        }*/

    @Test(description = "Verify valid user is login into the application", groups = {"regression", "sanity"},
            dataProviderClass = com.ui.dataprovider.LoginDataProvider.class, dataProvider = "loginTestCSVDataProvider")
    public void loginCSVTest(User user) {
        //Read Data from CSV file
       /* homePage.goToLoginPage()
                .doLoginWith(user.getEmailAddress(), user.getPassword())
                .getUserName();*/
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Test App");
        }

   /* @Test(description = "Verify valid user is login into the application", groups = {"regression", "sanity"},
            dataProviderClass = com.ui.dataprovider.LoginDataProvider.class, dataProvider = "loginTestExcelDataProvider",
            retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
    public void loginExcelTest(User user) {
        //Read Data from Excel file
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Test App");
        }*/

}