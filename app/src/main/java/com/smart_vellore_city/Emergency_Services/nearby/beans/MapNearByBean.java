package com.smart_vellore_city.Emergency_Services.nearby.beans;

public class MapNearByBean {
    private String mItemName;
    private String mItemRating;
    private String mItemAddress;
    private int mItemType;
    private double mLatitude,mLongitude;

    public MapNearByBean(String mItemName, String mItemRating, String mItemAddress, int mItemType,
                         double mLatitude, double mLongitude) {
        this.mItemName = mItemName;
        this.mItemRating = mItemRating;
        this.mItemAddress = mItemAddress;
        this.mItemType = mItemType;
        this.mLatitude = mLatitude;
        this.mLongitude = mLongitude;
    }

    public double getmLatitude() {
        return mLatitude;
    }

    public void setmLatitude(double mLatitude) {
        this.mLatitude = mLatitude;
    }

    public double getmLongitude() {
        return mLongitude;
    }

    public void setmLongitude(double mLongitude) {
        this.mLongitude = mLongitude;
    }

    public String getmItemName() {
        return mItemName;
    }

    public void setmItemName(String mItemName) {
        this.mItemName = mItemName;
    }

    public String getmItemRating() {
        return mItemRating;
    }

    public void setmItemRating(String mItemRating) {
        this.mItemRating = mItemRating;
    }

    public String getmItemAddress() {
        return mItemAddress;
    }

    public void setmItemAddress(String mItemAddress) {
        this.mItemAddress = mItemAddress;
    }

    public int getmItemType() {
        return mItemType;
    }

    public void setmItemType(int mItemType) {
        this.mItemType = mItemType;
    }
}
