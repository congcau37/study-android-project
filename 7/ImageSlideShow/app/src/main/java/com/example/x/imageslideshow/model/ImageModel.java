package com.example.x.imageslideshow.model;

/* Created by X on 11/28/2017.
* */

public class ImageModel {
    private int idImage;
    private String description;

    public ImageModel(int idImage, String description) {
        this.idImage = idImage;
        this.description = description;
    }

    public int getIdImage() {
        return idImage;
    }

    public String getDescription() {
        return description;
    }
}
