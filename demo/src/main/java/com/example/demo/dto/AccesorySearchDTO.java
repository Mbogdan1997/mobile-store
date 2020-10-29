package com.example.demo.dto;

public class AccesorySearchDTO extends SearchDTO {


    private String category;
    private String mobile;

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
