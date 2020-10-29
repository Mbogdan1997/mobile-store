package com.example.demo.dto;

import com.example.demo.entity.ShoppingBascket;
import com.example.demo.entity.ShoppingBascketItem;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBascketDTO extends IdDTO {

    List<ShoppingBascketItemDTO> shoppingBascketItemDTOList;
    int user;
    boolean active;
    float total;

    public ShoppingBascketDTO(){

    }

    public ShoppingBascketDTO(ShoppingBascket shoppingBascket){
        super(shoppingBascket.getId());
        user=shoppingBascket.getUser().getId();
        shoppingBascketItemDTOList=new ArrayList<>();

        total=0;
        this.active=shoppingBascket.isActive();
        if(shoppingBascket.getShoppingBascketItems()!=null) {
            for (ShoppingBascketItem shoppingBascketItem : shoppingBascket.getShoppingBascketItems()) {
                ShoppingBascketItemDTO shoppingBascketItemDTO=new ShoppingBascketItemDTO(shoppingBascketItem);
                shoppingBascketItemDTOList.add(shoppingBascketItemDTO);
                total+=shoppingBascketItemDTO.getTotal();
            }
        }

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
