package com.smart_vellore_city.Tourism.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Priyadharshini on 14-11-2018.
 */

public class TourismSitesPojo implements Parcelable {

    private String name,subTitle,description,address,ratings,review,reviewSummary;
    private String image1,image2,image3,image4;



    private TourismSitesPojo(Parcel in) {
        name = in.readString();
        subTitle = in.readString();
        description = in.readString();
        address = in.readString();
        ratings = in.readString();
        image1 = in.readString();
        image2 = in.readString();
        image3 = in.readString();
        image4 = in.readString();
        review = in.readString();
        reviewSummary = in.readString();
    }

    public static final Creator<TourismSitesPojo> CREATOR = new Creator<TourismSitesPojo>() {
        @Override
        public TourismSitesPojo createFromParcel(Parcel in) {
            return new TourismSitesPojo(in);
        }

        @Override
        public TourismSitesPojo[] newArray(int size) {
            return new TourismSitesPojo[size];
        }
    };

    public String getImage4() {
        return image4;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getReviewSummary() {
        return reviewSummary;
    }

    public void setReviewSummary(String reviewSummary) {
        this.reviewSummary = reviewSummary;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public TourismSitesPojo(String name, String subTitle, String description, String address,
                            String ratings, String image1, String image2, String image3, String image4,
                            String review,String reviewSummary) {
        this.name = name;
        this.subTitle = subTitle;
        this.description = description;
        this.address = address;
        this.ratings = ratings;

        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;

        this.review = review;
        this.reviewSummary = reviewSummary;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(subTitle);
        dest.writeString(description);
        dest.writeString(address);
        dest.writeString(ratings);
        dest.writeString(image1);
        dest.writeString(image2);
        dest.writeString(image3);
        dest.writeString(image4);
        dest.writeString(review);
        dest.writeString(reviewSummary);


    }
}
