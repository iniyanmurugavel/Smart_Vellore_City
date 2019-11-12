package com.smart_vellore_city.SchoolColleges.beans;

public class SchoolCollegeBean {
    String mUrl;
    String mName;
    String mAddress;
    String mMobileNo;

    public SchoolCollegeBean(String mUrl, String mName, String mAddress, String mMobileNo) {
        this.mUrl = mUrl;
        this.mName = mName;
        this.mAddress = mAddress;
        this.mMobileNo = mMobileNo;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getmMobileNo() {
        return mMobileNo;
    }

    public void setmMobileNo(String mMobileNo) {
        this.mMobileNo = mMobileNo;
    }
}
