package com.example.whitepagesdemo.entities.request;

public class Address {

    private String streetAddressLine1;
    private String streetAddressLine2;
    private String city;
    private String stateCode;
    private String postalCode;
    private String countryCode;

    public String getStreetAddressLine1() {
        return streetAddressLine1;
    }

    public void setStreetAddressLine1(String streetAddressLine1) {
        this.streetAddressLine1 = streetAddressLine1;
    }

    public String getStreetAddressLine2() {
        return streetAddressLine2;
    }

    public void setStreetAddressLine2(String streetAddressLine2) {
        this.streetAddressLine2 = streetAddressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetAddressLine1='" + streetAddressLine1 + '\'' +
                ", streetAddressLine2='" + streetAddressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", stateCode='" + stateCode + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
