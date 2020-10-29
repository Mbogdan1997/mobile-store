package com.example.demo.entity;


import com.example.demo.dto.OrderDTO;

import javax.persistence.*;
import java.util.Date;

@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String customerName;
    private String telephoneNumber;
    private boolean processed;

    @OneToOne
    @JoinColumn(name = "adress_id", referencedColumnName = "id",nullable = false)
    private Adress adress;

    @OneToOne
    @JoinColumn(name="shopping_bascket_id",referencedColumnName = "id",nullable = false)
    private ShoppingBascket shoppingBascket;




    private Date orderStartDate;
    private Date orderFinishDate;






    public OrderEntity(){



    }

    public OrderEntity(int id, String customerName, String telephoneNumber, boolean processed, Adress adress, Date orderStartDate, Date orderFinishDate) {
        this.id = id;
        this.customerName = customerName;
        this.telephoneNumber = telephoneNumber;
        this.processed = processed;
        this.adress = adress;
        this.orderStartDate = orderStartDate;
        this.orderFinishDate = orderFinishDate;
    }

    public OrderEntity(OrderDTO orderDTO,Adress adress) {
        this.id=orderDTO.getId();
        this.customerName=orderDTO.getCustomerName();
        this.telephoneNumber=orderDTO.getTelephoneNumber();
        this.processed=orderDTO.isProcessed();
        this.adress=adress;
        this.orderStartDate=orderDTO.getOrderStartDate();
        this.orderFinishDate=orderDTO.getOrderFinishDate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }


    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public Date getOrderStartDate() {
        return orderStartDate;
    }

    public void setOrderStartDate(Date orderStartDate) {
        this.orderStartDate = orderStartDate;
    }

    public Date getOrderFinishDate() {
        return orderFinishDate;
    }

    public void setOrderFinishDate(Date orderFinishDate) {
        this.orderFinishDate = orderFinishDate;
    }

    public ShoppingBascket getShoppingBascket() {
        return shoppingBascket;
    }

    public void setShoppingBascket(ShoppingBascket shoppingBascket) {
        this.shoppingBascket = shoppingBascket;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", processed=" + processed +
                //", adress=" + adress +
                ", orderStartDate=" + orderStartDate +
                ", orderFinishDate=" + orderFinishDate +
                '}';
    }
}
