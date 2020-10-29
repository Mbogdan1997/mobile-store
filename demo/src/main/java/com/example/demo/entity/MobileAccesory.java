package com.example.demo.entity;

import com.example.demo.dto.MobileAccesoryDTO;

import javax.persistence.*;

@Entity
public class MobileAccesory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(columnDefinition = "item_id",referencedColumnName = "id",nullable = false)
    private Item item;
    private String mobile;
    private String category;

    public MobileAccesory(){

    }

    public MobileAccesory(MobileAccesoryDTO mobileAccesoryDTO) {
        this.item=new Item(mobileAccesoryDTO.getItemDTO());
        this.mobile=mobileAccesoryDTO.getMobile();
        this.category=mobileAccesoryDTO.getCategory();
    }

    public MobileAccesory(int id, Item item, String category, String mobile) {
        this.id=id;
        this.item=item;
        this.category=category;
        this.mobile=mobile;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }


    public void update(MobileAccesoryDTO mobileDTO) {
        this.mobile=mobileDTO.getMobile();
        this.category=mobileDTO.getCategory();
    }
}
