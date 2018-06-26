package com.example.whitepagesdemo.entities.request;

public class PrimaryDetails {

    private String name;
    private String ipAddress;
    private String emailAddress;
    private String phone;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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
        return "PrimaryDetails{" +
                "name='" + name + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                '}';
    }
}
