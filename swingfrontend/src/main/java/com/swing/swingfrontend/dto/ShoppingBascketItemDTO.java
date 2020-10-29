package com.swing.swingfrontend.dto;





import javax.validation.constraints.Min;

public class ShoppingBascketItemDTO extends IdDTO {



    private IdDTO shoppingBascket;
    private ItemDTO item;
    private int quantity;
    private float total;

    public ShoppingBascketItemDTO(){

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

    @Override
    public String toString() {
        return
                "Item Name:" + item +" "+
                ",Quantity:" + quantity +" "+
                        "Price:" + item.getPrice() +" "+
                 "Total:"+item.getPrice()*quantity+"\n";

    }
}
