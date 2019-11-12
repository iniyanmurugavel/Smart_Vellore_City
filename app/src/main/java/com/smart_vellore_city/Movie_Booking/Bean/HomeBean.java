package com.smart_vellore_city.Movie_Booking.Bean;

/**
 * Created by admin on 10-06-2017.
 */

public class HomeBean {
    private String title,image,language;

    public HomeBean(String image, String title, String language){
        this.title = title;
        this.image = image;
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
