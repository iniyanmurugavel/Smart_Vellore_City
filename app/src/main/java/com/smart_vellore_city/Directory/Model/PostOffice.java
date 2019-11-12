package com.smart_vellore_city.Directory.Model;

public class PostOffice {

    private String name,address,pincode,number;

    public PostOffice(String name, String address, String pincode, String number) {
        this.name=name;
        this.address=address;
        this.pincode=pincode;
        this.number=number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
