package com.swing.swingfrontend.dto;

import com.swing.swingfrontend.dto.IdDTO;

public class NameIdDTO extends IdDTO {
    private String name;


    public NameIdDTO(int id, String name) {
        super(id);
        this.name = name;
    }

    public NameIdDTO(){

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
