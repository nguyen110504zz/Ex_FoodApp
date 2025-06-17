package com.buidangnguyen.model;

import java.io.Serializable;

public class Food implements Serializable {
    int imageResId;
    String name;
    String description;
    float rating;
    String review;
    String address;
    boolean promo;

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isPromo() {
        return promo;
    }

    public void setPromo(boolean promo) {
        this.promo = promo;
    }

    public Food(int imageResId, String name, String description, float rating, String review, String address, boolean promo) {
        this.imageResId = imageResId;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.review = review;
        this.address = address;
        this.promo = promo;
    }

}
