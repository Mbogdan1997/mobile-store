package com.example.demo.dto;

import com.example.demo.entity.MobileAccesory;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MobileAccesoryDTO extends IdDTO {

    private ItemDTO itemDTO;
    private String mobile;
    @NotEmpty(message = "Completati numele categoriei")
    private String category;

    public MobileAccesoryDTO(){

    }

    public MobileAccesoryDTO(MobileAccesory mobileAccesory){
        super(mobileAccesory.getId());
        this.itemDTO=new ItemDTO(mobileAccesory.getItem());
        this.mobile=mobileAccesory.getMobile();
        this.category=mobileAccesory.getCategory();
    }





    public ItemDTO getItemDTO() {
        return itemDTO;
    }

    public void setItemDTO(ItemDTO itemDTO) {
        this.itemDTO = itemDTO;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
