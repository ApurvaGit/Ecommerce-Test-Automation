package com.utility;


import com.github.javafaker.Faker;
import com.ui.pojo.Address;

import java.util.Locale;

public class FakeAddressUtility {

    public static void main(String[] args){
    getFakeAddress();
    }
    public static Address getFakeAddress(){
        Faker faker = new Faker(Locale.US);

        Address address = new Address(faker.company().name(),
                faker.address().buildingNumber(),faker.address().streetAddress(),
                faker.address().city(), faker.address().zipCode().substring(0,5),
                 faker.phoneNumber().cellPhone(),faker.phoneNumber().cellPhone(),"other","Home address","Hawaii");
        return address;
    }
}
