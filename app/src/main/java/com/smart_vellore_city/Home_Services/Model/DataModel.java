package com.smart_vellore_city.Home_Services.Model;

public class DataModel {

    public String text;
    public int drawable;
    public String color;

    public DataModel(String t, int d, String c )
    {
        text=t;
        drawable=d;
        color=c;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}