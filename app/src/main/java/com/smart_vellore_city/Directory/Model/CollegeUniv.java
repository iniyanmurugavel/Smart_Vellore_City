package com.smart_vellore_city.Directory.Model;

public class CollegeUniv {

    private String name,number,email,pincode,address,type;

    public CollegeUniv(String name, String number, String emails, String pincode, String address, String type) {

        this.name=name;
        this.number=number;
        this.email=email;
        this.pincode=pincode;
        this.address=address;
        this.type=type;
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

    public void setEmail(String emails) {
        this.email = emails;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
