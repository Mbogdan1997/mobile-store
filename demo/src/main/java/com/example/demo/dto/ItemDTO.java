package com.example.demo.dto;

import com.example.demo.entity.Item;

import javax.validation.constraints.Min;

public class ItemDTO extends NameIdDTO {
    private String description;
    @Min(value = 1,message = "Pretul pus este prea mic")
    private float price;
    @Min(value = 0,message = "Cantitatea este prea mica")
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

    public ItemDTO(Item item) {
        super(item.getId(),item.getName());
        this.brand=item.getBrand();
        this.description=item.getDescription();
        this.price=item.getPrice();
        this.quantity=item.getQuantity();
        this.setName(item.getName());
        this.image=item.getImage();
        this.color=item.getColor();
        this.isActive=item.isActive();
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
}
