package com.example.miapplication;

import android.widget.ImageView;

public class EnjoyItem {
    private int image;
    private String content;
    private int image1;

    public EnjoyItem() {
    }

    public EnjoyItem(int image, String content, int image1) {
        this.image = image;
        this.content = content;
        this.image1 = image1;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImage1() {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    @Override
    public String toString() {
        return "EnjoyItem{" +
                "image=" + image +
                ", content='" + content + '\'' +
                ", image1=" + image1 +
                '}';
    }
}
