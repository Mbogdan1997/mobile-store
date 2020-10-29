package com.example.demo.dto;

import com.example.demo.entity.Adress;
import com.example.demo.entity.OrderEntity;
import com.example.demo.entity.ShoppingBascketItem;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

public class OrderDTO extends IdDTO{

    @Size(min = 10,max = 20,message = "Numele contine intre 10 si 20 de caractere")
    private String customerName;
    @NotEmpty(message = "Completati numarul de telefon")
    @Pattern(regexp="(^$|[0-9]{10})",message = "Numarul de telefon contine 10 cifre")
    private String telephoneNumber;
    private int shoppingBascket;
    private float total;
    private boolean processed;
    private AdressDTO adress;
    private Date orderStartDate;
    private Date orderFinishDate;

    public OrderDTO(){

    }

    public OrderDTO(OrderEntity orderEntity,AdressDTO adressDTO){
       super(orderEntity.getId());
        this.customerName=orderEntity.getCustomerName();
        this.telephoneNumber=orderEntity.getTelephoneNumber();
        this.processed=orderEntity.isProcessed();
        this.adress=adressDTO;
        this.orderStartDate=orderEntity.getOrderStartDate();
        this.orderFinishDate=orderEntity.getOrderFinishDate();
        this.shoppingBascket=orderEntity.getShoppingBascket().getId();
        this.total=0.0f;
        if(orderEntity.getShoppingBascket()!=null){
            List<ShoppingBascketItem> shoppingBascketItems=orderEntity.getShoppingBascket().getShoppingBascketItems();
            for(ShoppingBascketItem shoppingBascketItem:shoppingBascketItems){
                this.total+=shoppingBascketItem.getQuantity()*shoppingBascketItem.getItem().getPrice();
            }
        }

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
