package com.swing.swingfrontend.dto;

public class AccesorySearchDTO extends SearchDTO {


    private String category;
    private String mobile;

    public AccesorySearchDTO(String category,String mobile,String name, String brand, String color, String description){
        super(name,brand,color,description);
        this.category=category;
        this.mobile=mobile;


    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
