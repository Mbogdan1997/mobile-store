package com.swing.swingfrontend.dto;



public class AdressDTO extends IdDTO {


    private String cityName;
    private String streetName;

    private int number;



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

