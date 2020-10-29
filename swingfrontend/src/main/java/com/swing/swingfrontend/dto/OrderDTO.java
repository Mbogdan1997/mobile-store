package com.swing.swingfrontend.dto;


import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

public class OrderDTO extends IdDTO{

    private String customerName;

    private String telephoneNumber;
    private int shoppingBascket;
    private float total;
    private boolean processed;
    private AdressDTO adress;
    private Date orderStartDate;
    private Date orderFinishDate;

    public OrderDTO(){

    }


    public OrderDTO(int id, String customerName, String telephoneNumber, boolean processed, AdressDTO adress, Date orderStartDate, Date orderFinishDate) {
        super(id);
        this.customerName = customerName;
        this.telephoneNumber = telephoneNumber;
        this.processed = processed;
        this.adress = adress;
        this.orderStartDate = orderStartDate;
        this.orderFinishDate = orderFinishDate;
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

    public AdressDTO getAdress() {
        return adress;
    }

    public void setAdress(AdressDTO adress) {
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

    public int getShoppingBascket() {
        return shoppingBascket;
    }

    public void setShoppingBascket(int shoppingBascket) {
        this.shoppingBascket = shoppingBascket;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + super.getId() +
                ", customerName='" + customerName + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", processed=" + processed +
                // ", adress=" + adress +
                ", orderStartDate=" + orderStartDate +
                ", orderFinishDate=" + orderFinishDate +
                '}';
    }
}

