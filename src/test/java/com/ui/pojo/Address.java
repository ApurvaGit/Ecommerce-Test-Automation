package com.ui.pojo;

public class Address {
    private String company;
    private String address1;
    private String address2;
    private String city;

    private String postcode;
    private String homePhoneNumber;
    private String mobileNumber;
    private String otherInfo;
    private String addressAlias;
    private String state;

    public Address(String company, String address1, String address2, String city, String postcode, String homePhoneNumber, String mobileNumber, String otherInfo, String addressAlias, String state) {
        this.company = company;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.postcode = postcode;
        this.homePhoneNumber = homePhoneNumber;
        this.mobileNumber = mobileNumber;
        this.otherInfo = otherInfo;
        this.addressAlias = addressAlias;
        this.state = state;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public String getAddressAlias() {
        return addressAlias;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "company='" + company + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", postcode='" + postcode + '\'' +
                ", homePhoneNumber='" + homePhoneNumber + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", otherInfo='" + otherInfo + '\'' +
                ", addressAlias='" + addressAlias + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
