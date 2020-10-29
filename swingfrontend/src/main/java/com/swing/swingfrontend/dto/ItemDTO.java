package com.swing.swingfrontend.dto;

public class ItemDTO extends NameIdDTO {

    private String description;
    private float price;
    private int quantity;
    private String image;
    private String brand;
    private String color;
    private boolean isActive;

    public ItemDTO(){

    }

    public ItemDTO(int id, String name, String description, float price, int quantity, String image, String brand, String color, NameIdDTO category,boolean isActive) {
        super(id, name);
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.brand = brand;
        this.color = color;
        this.isActive=isActive;
    }



    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setActiveAfterString(String active){
        if(active.equals("Active")){
            this.isActive=true;
        }
        else {
            this.isActive = false;
        }
    }
}
