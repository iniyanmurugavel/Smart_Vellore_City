package com.smart_vellore_city.Directory.Model;

public class ContactsModel {

    private String designation,mobile,landline,email;

    public ContactsModel(String designation, String mobile, String landline, String email) {
        this.designation=designation;
        this.mobile=mobile;
        this.landline=landline;
        this.email=email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
