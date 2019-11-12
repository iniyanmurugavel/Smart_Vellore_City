package com.smart_vellore_city.Movie_Booking.Bean;

/**
 * Created by admin on 10-06-2017.
 */

public class EnglishMovieBean {
    private String title,url;
    public EnglishMovieBean(String title, String url){
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
