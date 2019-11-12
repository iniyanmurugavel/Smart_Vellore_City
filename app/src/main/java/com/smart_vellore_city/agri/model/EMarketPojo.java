package com.smart_vellore_city.agri.model;

/**
 * Created by Priyadharshini on 17-11-2018.
 */

public class EMarketPojo {

    private String name, address, mobile,rating;

    public EMarketPojo(String name, String address, String mobile,String rating) {
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
