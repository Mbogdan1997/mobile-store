package com.example.demo.entity;

import com.example.demo.dto.ShoppingBascketItemDTO;

import javax.persistence.*;

@Entity
public class ShoppingBascketItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    int quantity;

    @ManyToOne
    @JoinColumn(name = "shopping_bascket_id",nullable = false)
    private ShoppingBascket shoppingBascket;

    @OneToOne
    @JoinColumn(name="item_id",referencedColumnName = "id",nullable = false)
    private Item item;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ShoppingBascket getShoppingBascket() {
        return shoppingBascket;
    }

    public void setShoppingBascket(ShoppingBascket shoppingBascket) {
        this.shoppingBascket = shoppingBascket;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
