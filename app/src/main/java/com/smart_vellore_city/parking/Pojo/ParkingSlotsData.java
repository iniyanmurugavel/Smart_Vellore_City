package com.smart_vellore_city.parking.Pojo;

public class ParkingSlotsData {

    String slotNumber;
    int carImage;
    boolean showcars;
    public ParkingSlotsData(String slotNumber, int carImage,boolean showcars) {
        this.slotNumber = slotNumber;
        this.carImage = carImage;
        this.showcars=showcars;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public boolean getShowcars() {
        return showcars;
    }

    public void setShowcars(boolean showcars) {
        this.showcars = showcars;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    public int getCarImage() {
        return carImage;
    }

    public void setCarImage(int carImage) {
        this.carImage = carImage;
    }
}
