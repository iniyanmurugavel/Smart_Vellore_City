package com.smart_vellore_city.MarriageHall.beans;

import java.io.Serializable;
@SuppressWarnings("serial")
public class MhallBean implements Serializable {
    private String mItemName;
    private String mItemRating;
    private String mItemDistance;
    private String mItemAttendees;
    private String mItemSpaces;
    private String mItemRooms;
    private String mItemBaseRate;
    private double mLatitude;
    private double mLongitude;
    private String mAddress;
    private String mImgUrl;

    public MhallBean(String mItemName, String mItemRating, String mItemDistance, String mItemAttendees,
                     String mItemSpaces, String mItemRooms,String mItemBaseRate, double mLatitude,
                     double mLongitude, String mAddress, String mImgUrl) {
        this.mItemName = mItemName;
        this.mItemRating = mItemRating;
        this.mItemDistance = mItemDistance;
        this.mItemAttendees = mItemAttendees;
        this.mItemSpaces = mItemSpaces;
        this.mItemRooms = mItemRooms;
        this.mItemBaseRate = mItemBaseRate;
        this.mLatitude = mLatitude;
        this.mLongitude = mLongitude;
        this.mAddress = mAddress;
        this.mImgUrl = mImgUrl;
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

    public String getmItemDistance() {
        return mItemDistance;
    }

    public void setmItemDistance(String mItemDistance) {
        this.mItemDistance = mItemDistance;
    }

    public String getmItemAttendees() {
        return mItemAttendees;
    }

    public void setmItemAttendees(String mItemAttendees) {
        this.mItemAttendees = mItemAttendees;
    }

    public String getmItemSpaces() {
        return mItemSpaces;
    }

    public void setmItemSpaces(String mItemSpaces) {
        this.mItemSpaces = mItemSpaces;
    }

    public String getmItemRooms() {
        return mItemRooms;
    }

    public void setmItemRooms(String mItemRooms) {
        this.mItemRooms = mItemRooms;
    }

    public String getmItemBaseRate() {
        return mItemBaseRate;
    }

    public void setmItemBaseRate(String mItemBaseRate) {
        this.mItemBaseRate = mItemBaseRate;
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

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getmImgUrl() {
        return mImgUrl;
    }

    public void setmImgUrl(String mImgUrl) {
        this.mImgUrl = mImgUrl;
    }
}
