package com.smart_vellore_city.Auto_taxi.Model;

public class Auto_TaxiModel {
    private String name;
    private String source;
    private String destination;
    private String fare;
    private String imageId;
    private String mobile;

    public Auto_TaxiModel(String name, String source, String destination, String fare,
                          String imageId,String mobile) {
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.fare = fare;
        this.imageId = imageId;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
