package com.smart_vellore_city.parking.Pojo;

public class ParkingAvailable {


    private  String name;
    private String kms ;
    private String parkingtype;
    private String amount ;
    private  String book;

    public ParkingAvailable(String name, String kms, String parkingtype, String amount, String book) {
        this.name = name;
        this.kms = kms;
        this.parkingtype = parkingtype;
        this.amount = amount;
        this.book = book;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKms() {
        return kms;
    }

    public void setKms(String kms) {
        this.kms = kms;
    }

    public String getParkingtype() {
        return parkingtype;
    }

    public void setParkingtype(String parkingtype) {
        this.parkingtype = parkingtype;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }
}
