package com.smart_vellore_city.Event_Booking.Model;

public class EventListModel {
    private String eventName;
    private String eventLocation;
    private String eventDate;
    private String eventComments;
    private String eventPartcicipants;
    private Integer imageId;

    public EventListModel(String eventName, String eventLocation, String eventDate,
                          String eventComments, String eventPartcicipants,Integer imageId) {
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
        this.eventComments = eventComments;
        this.eventPartcicipants = eventPartcicipants;
        this.imageId = imageId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventComments() {
        return eventComments;
    }

    public void setEventComments(String eventComments) {
        this.eventComments = eventComments;
    }

    public String getEventPartcicipants() {
        return eventPartcicipants;
    }

    public void setEventPartcicipants(String eventPartcicipants) {
        this.eventPartcicipants = eventPartcicipants;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }
}
