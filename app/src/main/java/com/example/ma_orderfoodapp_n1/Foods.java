package com.example.ma_orderfoodapp_n1;

public class Foods {
    private int imageId;
    private String foodName;
    private String description;
    private double foodPrice;
    private int foodSale;

    public Foods() {
    }

    public Foods(int imageId, String foodName, String description, double foodPrice, int foodSale) {
        this.imageId = imageId;
        this.foodName = foodName;
        this.description = description;
        this.foodPrice = foodPrice;
        this.foodSale = foodSale;
    }

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

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public void setFoodSale(int foodSale) {
        this.foodSale = foodSale;
    }

    @Override
    public String toString() {
        return "Foods{" +
                "imageId=" + imageId +
                ", foodName='" + foodName + '\'' +
                ", description='" + description + '\'' +
                ", foodPrice=" + foodPrice +
                ", foodSale=" + foodSale +
                '}';
    }
}
