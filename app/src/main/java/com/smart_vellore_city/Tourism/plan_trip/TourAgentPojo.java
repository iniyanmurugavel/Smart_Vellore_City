package com.smart_vellore_city.Tourism.plan_trip;

/**
 * Created by Priyadharshini on 20-11-2018.
 */

public class TourAgentPojo {

    String name,booking_num,desc,language_known,rating,licensedOrNot,img,mobileNo;


    public TourAgentPojo(String name, String booking_num, String desc,
                         String language_known, String rating,
                         String licensedOrNot, String img, String mobileNo) {
        this.name = name;
        this.booking_num = booking_num;
        this.desc = desc;
        this.language_known = language_known;
        this.rating = rating;
        this.licensedOrNot = licensedOrNot;
        this.img = img;
        this.mobileNo = mobileNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBooking_num() {
        return booking_num;
    }

    public void setBooking_num(String booking_num) {
        this.booking_num = booking_num;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLanguage_known() {
        return language_known;
    }

    public void setLanguage_known(String language_known) {
        this.language_known = language_known;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getLicensedOrNot() {
        return licensedOrNot;
    }

    public void setLicensedOrNot(String licensedOrNot) {
        this.licensedOrNot = licensedOrNot;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
