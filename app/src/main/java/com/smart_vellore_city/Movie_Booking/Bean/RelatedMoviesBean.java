package com.smart_vellore_city.Movie_Booking.Bean;

/**
 * Created by admin on 12-06-2017.
 */

public class RelatedMoviesBean {
    private String title,url,category;

    public RelatedMoviesBean(String title, String url, String category){
        this.title = title;
        this.url = url;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
