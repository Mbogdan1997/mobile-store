package com.example.demo.dto;

import com.example.demo.entity.ShoppingBascketItem;

import javax.validation.constraints.Min;

public class ShoppingBascketItemDTO extends IdDTO {



        private IdDTO shoppingBascket;
        private ItemDTO item;
        @Min(value = 1,message = "Cantitatea comandata este prea mica")
        private int quantity;
        private float total;

        public ShoppingBascketItemDTO(){

        }

        public  ShoppingBascketItemDTO(ShoppingBascketItem shoppingBascketItem){

            super(shoppingBascketItem.getId());
            shoppingBascket=new IdDTO(shoppingBascketItem.getShoppingBascket());
            item=new ItemDTO(shoppingBascketItem.getItem());
            quantity=shoppingBascketItem.getQuantity();
            total=quantity*item.getPrice();

        }

    public IdDTO getShoppingBascket() {
        return shoppingBascket;
    }

    public void setShoppingBascket(IdDTO shoppingBascket) {
        this.shoppingBascket = shoppingBascket;
    }

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
