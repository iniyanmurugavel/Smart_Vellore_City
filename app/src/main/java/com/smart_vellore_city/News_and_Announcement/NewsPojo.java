package com.smart_vellore_city.News_and_Announcement;

/**
 * Created by Priyadharshini on 16-11-2018.
 */

public class NewsPojo {

    String title,description,time,date;
    String image;

    public NewsPojo(String title, String description, String time, String image,String date) {
        this.title = title;
        this.description = description;
        this.time = time;
        this.image = image;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
