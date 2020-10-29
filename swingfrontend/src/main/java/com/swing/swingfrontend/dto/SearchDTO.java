package com.swing.swingfrontend.dto;

public class SearchDTO {

    private String name;
    private String brand;
    private String color;
    private String description;

    public SearchDTO(String name, String brand, String color, String description) {
        this.name=name;
        this.brand=brand;
        this.color=color;
        this.description=description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
