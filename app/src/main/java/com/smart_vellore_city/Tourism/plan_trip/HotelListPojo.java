package com.smart_vellore_city.Tourism.plan_trip;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Priyadharshini on 17-11-2018.
 */

public class HotelListPojo implements Parcelable {

    private String name, address, desc, mobile, rating, star, roomService,
            restaurant, parking, swimming, ac, image, hotelDesc,roomImage;


    public HotelListPojo(String name, String address, String desc, String hotelDesc, String mobile, String rating,
                         String star, String roomService, String restaurant, String parking,
                         String swimming, String ac, String image ,String roomImage) {
        this.name = name;
        this.address = address;
        this.desc = desc;
        this.hotelDesc = hotelDesc;

        this.mobile = mobile;

        this.rating = rating;
        this.star = star;
        this.roomService = roomService;
        this.restaurant = restaurant;
        this.parking = parking;

        this.swimming = swimming;
        this.ac = ac;
        this.image = image;
        this.roomImage = roomImage;
    }


    protected HotelListPojo(Parcel in) {
        name = in.readString();
        address = in.readString();
        desc = in.readString();
        hotelDesc = in.readString();
        mobile = in.readString();
        rating = in.readString();
        star = in.readString();
        roomService = in.readString();
        restaurant = in.readString();
        parking = in.readString();
        swimming = in.readString();
        ac = in.readString();
        image = in.readString();

        roomImage = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(address);
        dest.writeString(desc);
        dest.writeString(hotelDesc);
        dest.writeString(mobile);
        dest.writeString(rating);
        dest.writeString(star);
        dest.writeString(roomService);
        dest.writeString(restaurant);
        dest.writeString(parking);
        dest.writeString(swimming);
        dest.writeString(ac);
        dest.writeString(image);

        dest.writeString(roomImage);
    }

    public static final Creator<HotelListPojo> CREATOR = new Creator<HotelListPojo>() {
        @Override
        public HotelListPojo createFromParcel(Parcel in) {
            return new HotelListPojo(in);
        }

        @Override
        public HotelListPojo[] newArray(int size) {
            return new HotelListPojo[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getAddress() {
        return address;
    }

    public String getDesc() {
        return desc;
    }

    public String getRoomImage() {
        return roomImage;
    }

    public void setRoomImage(String roomImage) {
        this.roomImage = roomImage;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public String getRoomService() {
        return roomService;
    }

    public void setRoomService(String roomService) {
        this.roomService = roomService;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getSwimming() {
        return swimming;
    }

    public void setSwimming(String swimming) {
        this.swimming = swimming;
    }

    public String getAc() {
        return ac;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHotelDesc() {
        return hotelDesc;
    }

    public void setHotelDesc(String hotelDesc) {
        this.hotelDesc = hotelDesc;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }


}
