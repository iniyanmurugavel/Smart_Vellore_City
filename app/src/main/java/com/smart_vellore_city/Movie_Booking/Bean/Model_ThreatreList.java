package com.smart_vellore_city.Movie_Booking.Bean;

public class Model_ThreatreList {
    private String theatreName;
    private String threatreAddress;
    private String rating;
    private Integer imageId;
    private  Double lat;
    private  Double lng;

    public Model_ThreatreList(String theatreName, String threatreAddress, String rating, Integer imageId, Double lat, Double lng) {
        this.theatreName = theatreName;
        this.threatreAddress = threatreAddress;
        this.rating = rating;
        this.imageId = imageId;
        this.lat = lat;
        this.lng = lng;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getThreatreAddress() {
        return threatreAddress;
    }

    public void setThreatreAddress(String threatreAddress) {
        this.threatreAddress = threatreAddress;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
