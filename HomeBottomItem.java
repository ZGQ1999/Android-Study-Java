package com.example.miapplication;

public class HomeBottomItem {
    private int image;
    private String content;
    private String price;

    public HomeBottomItem() {
    }

    public HomeBottomItem(int image, String content, String price) {
        this.image = image;
        this.content = content;
        this.price = price;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "HomeBottomItem{" +
                "image=" + image +
                ", content='" + content + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
