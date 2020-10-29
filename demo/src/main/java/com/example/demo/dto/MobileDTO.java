package com.example.demo.dto;

import com.example.demo.entity.Mobile;

public class MobileDTO extends IdDTO{

    private ItemDTO itemDTO;

    public MobileDTO(){

    }

    public MobileDTO(Mobile mobile){
        super(mobile.getId());
        this.itemDTO=new ItemDTO(mobile.getItem());
    }

    public ItemDTO getItemDTO() {
        return itemDTO;
    }

    public void setItemDTO(ItemDTO itemDTO) {
        this.itemDTO = itemDTO;
    }


}
