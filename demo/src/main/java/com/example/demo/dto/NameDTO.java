package com.example.demo.dto;

public class NameDTO {
    private String name;
    NameDTO(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
