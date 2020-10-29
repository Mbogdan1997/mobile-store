package com.example.demo.dto;

import com.example.demo.entity.Adress;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class AdressDTO extends IdDTO {

    @Size(min=5,max = 25,message = "Numele orasului are intre 5 si 25 de caractere")
    private String cityName;
    @Size(min=10,max = 25,message = "Numele orasului are intre 10 si 25 de caractere")
    private String streetName;
    @Min(value = 1,message = "Numarul strazii e pozitiv")
    private int number;

    public AdressDTO(Adress adress){
        super(adress.getId());
        this.cityName=adress.getCityName();
        this.number=adress.getNumber();
        this.streetName=adress.getStreetName();
    }

    public AdressDTO(int id, String cityName, String streetName, int number) {
        super(id);
        this.cityName = cityName;
        this.streetName = streetName;
        this.number = number;
    }

    public AdressDTO(){

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
        return "AdressDTO{" +
                "id=" + super.getId() +
                ", cityName='" + cityName + '\'' +
                ", streetName='" + streetName + '\'' +
                ", number=" + number +
                '}';
    }
}
