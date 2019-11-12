package com.smart_vellore_city.Movie_Booking.Bean;

/**
 * Created by admin on 06-06-2017.
 */

public class MovieBean {
    private String title,url;
    public MovieBean(String url, String title){
        this.url = url;
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
