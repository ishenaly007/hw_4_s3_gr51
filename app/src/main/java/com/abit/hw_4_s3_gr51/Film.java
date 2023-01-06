package com.abit.hw_4_s3_gr51;

import java.io.Serializable;

public class Film implements Serializable {
    private String name;
    private String opisan;
    private String rating;
    private int img;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpisan() {
        return opisan;
    }

    public void setOpisan(String opisan) {
        this.opisan = opisan;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public Film(String name, String opisan, String rating, int img) {
        this.name = name;
        this.opisan = opisan;
        this.rating = rating;
        this.img = img;
    }
}
