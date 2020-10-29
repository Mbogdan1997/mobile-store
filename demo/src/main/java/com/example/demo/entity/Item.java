package com.example.demo.entity;

import com.example.demo.dto.ItemDTO;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private float price;
    private int quantity;
    private String name;
    private String image;
    private String brand;
    private String color;
    private boolean isActive;


    public Item(ItemDTO itemDTO) {

        this.id=itemDTO.getId();
        this.description=itemDTO.getDescription();
        this.price=itemDTO.getPrice();
        this.quantity=itemDTO.getQuantity();
        this.name=itemDTO.getName();
        this.image=itemDTO.getImage();
        this.color=itemDTO.getColor();
        this.brand=itemDTO.getBrand();
        isActive=itemDTO.isActive();
    }

    public Item(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void update(ItemDTO itemDTO) {
        this.description=itemDTO.getDescription();
        this.price=itemDTO.getPrice();
        this.quantity=itemDTO.getQuantity();
        this.name=itemDTO.getName();
        this.image=itemDTO.getImage();
        this.color=itemDTO.getColor();
        this.brand=itemDTO.getBrand();
        isActive=itemDTO.isActive();
    }
}
