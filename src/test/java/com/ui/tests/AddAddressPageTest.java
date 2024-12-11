package com.ui.tests;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.Address;
import com.utility.FakeAddressUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddAddressPageTest extends TestBase{

    private MyAccountPage myAccountPage;
    private AddressPage addressPage;
    private Address address;

    @BeforeMethod(description = "Valid First time user logs into the application and adds valid address")
    public void setUp(){
        myAccountPage = homePage.goToLoginPage().doLoginWith("hornyashel27@remaild.com", "testapp");

       /* address = new Address("Infosys","address1","address2","Apexas","12345","2222222222",
                "343434343","more info","Home address","Hawaii");*/

        address = FakeAddressUtility.getFakeAddress();
    }

    @Test
    public void addNewAddress(){
        String newAddress = myAccountPage.goToAddAddressPage().createAddress(address);
        Assert.assertEquals(newAddress,address.getAddressAlias().toUpperCase());
    }
}