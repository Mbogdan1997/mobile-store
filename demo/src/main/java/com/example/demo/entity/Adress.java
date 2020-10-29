package com.example.demo.entity;

import com.example.demo.dto.AdressDTO;
import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cityName;
    private String streetName;
    private int number;
    //@OneToOne(mappedBy = "adress")
    //private OrderEntity order;



    public Adress(){

    }
    public Adress(int id, String cityName, String streetName, int number) {
        this.id = id;
        this.cityName = cityName;
        this.streetName = streetName;
        this.number = number;
    }

    public Adress(AdressDTO adressDTO) {
        this.id=adressDTO.getId();
        this.cityName=adressDTO.getCityName();
        this.number=adressDTO.getNumber();
        this.streetName=adressDTO.getStreetName();
    }

   /* public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }
    */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", streetName='" + streetName + '\'' +
                ", number=" + number +
                //", order=" + order +
                '}';
    }
}
