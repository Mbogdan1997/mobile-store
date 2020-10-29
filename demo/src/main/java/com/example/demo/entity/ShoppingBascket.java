package com.example.demo.entity;

import com.example.demo.dto.ShoppingBascketDTO;

import javax.persistence.*;
import java.util.List;

@Entity
public class ShoppingBascket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean active;

    @OneToOne
    @JoinColumn(name="user_id",referencedColumnName = "id",nullable = false)
    private User user;

    @OneToMany(mappedBy = "shoppingBascket")
    List<ShoppingBascketItem> shoppingBascketItems;

    public ShoppingBascket(ShoppingBascketDTO shoppingBascketDTO,User user,List<ShoppingBascketItem> shoppingBascketItems) {
        this.id=shoppingBascketDTO.getId();
        this.user=user;
        this.shoppingBascketItems=shoppingBascketItems;

    }

    public ShoppingBascket(User user) {
        this.user=user;

    }

    public ShoppingBascket() {

    }

    /*@OneToOne(mappedBy = "shoppingBascket")
    private OrderEntity orderEntity;
    */






    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ShoppingBascketItem> getShoppingBascketItems() {
        return shoppingBascketItems;
    }

    public void setShoppingBascketItems(List<ShoppingBascketItem> shoppingBascketItems) {
        this.shoppingBascketItems = shoppingBascketItems;
    }

   /* public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }
    */
}
