package com.smart_vellore_city.Rental.model;

/**
 * Created by Priyadharshini on 19-11-2018.
 */

public class RentalPojo {

    String name, type, rent, extraCharge, seats, gearType, mileage, diesalOrPetrol;

    String img;

    public RentalPojo(String name, String type, String rent, String extraCharge,
                      String seats, String gearType, String mileage, String diesalOrPetrol, String img) {
        this.name = name;
        this.type = type;
        this.rent = rent;
        this.extraCharge = extraCharge;
        this.seats = seats;
        this.gearType = gearType;
        this.mileage = mileage;
        this.diesalOrPetrol = diesalOrPetrol;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public String getExtraCharge() {
        return extraCharge;
    }

    public void setExtraCharge(String extraCharge) {
        this.extraCharge = extraCharge;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getDiesalOrPetrol() {
        return diesalOrPetrol;
    }

    public void setDiesalOrPetrol(String diesalOrPetrol) {
        this.diesalOrPetrol = diesalOrPetrol;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
