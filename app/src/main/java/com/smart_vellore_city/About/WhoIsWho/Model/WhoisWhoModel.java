package com.smart_vellore_city.About.WhoIsWho.Model;

public class WhoisWhoModel {
    private String name;
    private String designation;
    private String phone;
    private String email;

    public WhoisWhoModel(String name, String designation, String phone, String email) {
        this.name = name;
        this.designation = designation;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
