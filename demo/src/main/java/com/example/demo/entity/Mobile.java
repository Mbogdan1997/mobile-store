package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Mobile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(columnDefinition = "item_id",referencedColumnName = "id",nullable = false)
    private Item item;

    public Mobile(int id, Item item) {
        this.id=id;
        this.item=item;
    }

    public Mobile() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
