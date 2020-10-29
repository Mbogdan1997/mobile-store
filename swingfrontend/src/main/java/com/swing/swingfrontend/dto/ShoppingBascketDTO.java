package com.swing.swingfrontend.dto;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBascketDTO extends IdDTO {

    List<ShoppingBascketItemDTO> shoppingBascketItemDTOList;
    int user;
    boolean active;
    float total;

    public ShoppingBascketDTO(){

    }


    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<ShoppingBascketItemDTO> getShoppingBascketItemDTOList() {
        return shoppingBascketItemDTOList;
    }

    public void setShoppingBascketItemDTOList(List<ShoppingBascketItemDTO> shoppingBascketItemDTOList) {
        this.shoppingBascketItemDTOList = shoppingBascketItemDTOList;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
