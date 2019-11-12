package com.smart_vellore_city.agri.model;

/**
 * Created by Priyadharshini on 16-11-2018.
 */

public class AgriPojo {

    String name, quantity, price;
    String img;

    public AgriPojo(String name, String quantity, String price, String img) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
