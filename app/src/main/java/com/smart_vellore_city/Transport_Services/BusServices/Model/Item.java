package com.smart_vellore_city.Transport_Services.BusServices.Model;

import android.graphics.Bitmap;

public class Item {
    String select;
    Bitmap seatSelect;

    public Item(Bitmap seatSelect, String select) {
        this.seatSelect = seatSelect;
        this.select = select;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public Bitmap getSeatSelect() {
        return seatSelect;
    }

    public void setSeatSelect(Bitmap seatSelect) {
        this.seatSelect = seatSelect;
    }
}
