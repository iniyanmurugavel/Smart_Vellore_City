package com.smart_vellore_city.Directory.Model;

public class BloodBanks {

    private String name,number,email,pincode,address;

    public BloodBanks(String name, String number, String email, String pincode, String address) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.pincode = pincode;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
