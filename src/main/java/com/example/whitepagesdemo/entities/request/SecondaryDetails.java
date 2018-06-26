package com.example.whitepagesdemo.entities.request;

public class SecondaryDetails {

    private String name;
    private String phone;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SecondaryDetails{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                '}';
    }
}
