package com.example.ma_orderfoodapp_n1;

import com.google.gson.annotations.SerializedName;

public class ResponseFoodClass {

    @SerializedName("imageId")
    private int imageId;

    @SerializedName("foodName")
    private String foodName;

    @SerializedName("description")
    private String description;

    @SerializedName("foodPrice")
    private double foodPrice;

    @SerializedName("foodSale")
    private int foodSale;

    public int getImageId() {
        return imageId;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getDescription() {
        return description;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public int getFoodSale() {
        return foodSale;
    }
}
