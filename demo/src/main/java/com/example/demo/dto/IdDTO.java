package com.example.demo.dto;

import com.example.demo.entity.ShoppingBascket;

public class IdDTO {

    private int id;

    public IdDTO() {
    }

    public IdDTO(int id){
        this.id=id;
    }

    public IdDTO(ShoppingBascket shoppingBascket) {
        this.id=shoppingBascket.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
