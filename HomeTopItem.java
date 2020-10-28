package com.example.miapplication;

import android.widget.ImageView;

public class HomeTopItem {
    private int image;
    private String name;

    public HomeTopItem() {
    }

    public HomeTopItem(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HomeTopItem{" +
                "image=" + image +
                ", name='" + name + '\'' +
                '}';
    }
}
