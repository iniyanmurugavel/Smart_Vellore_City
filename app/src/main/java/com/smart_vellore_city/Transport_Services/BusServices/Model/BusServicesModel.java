package com.smart_vellore_city.Transport_Services.BusServices.Model;

public class BusServicesModel {
    private String source;
    private String destination;
    private String time;
    private String duration;
    private String fare;
    private String imageId;

    public BusServicesModel(String source,String destination, String time, String duration, String fare, String imageId) {
        this.source = source;
        this.destination = destination;
        this.time = time;
        this.duration = duration;
        this.fare = fare;
        this.imageId = imageId;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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
}
