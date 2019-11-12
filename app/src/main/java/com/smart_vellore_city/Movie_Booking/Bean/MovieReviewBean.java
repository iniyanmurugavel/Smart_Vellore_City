package com.smart_vellore_city.Movie_Booking.Bean;

/**
 * Created by admin on 12-06-2017.
 */

public class MovieReviewBean {
    String name,review;

    public MovieReviewBean(String name, String review){
        this.name = name;
        this.review = review;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
