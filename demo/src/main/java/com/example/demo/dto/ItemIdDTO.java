package com.example.demo.dto;

import com.example.demo.entity.Item;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

public class ItemIdDTO extends IdDTO {
    private ItemDTO itemDTO;

    public  ItemIdDTO(){

    }

    public ItemIdDTO(int id, Item item){
        super(id);
        itemDTO=new ItemDTO(item);
    }

    public ItemIdDTO(ItemDTO itemDTO) {
        this.itemDTO = itemDTO;
    }

    public ItemIdDTO(int id, ItemDTO itemDTO) {
        super(id);
        this.itemDTO = itemDTO;
    }

    public ItemDTO getItemDTO() {
        return itemDTO;
    }

    public void setItemDTO(ItemDTO itemDTO) {
        this.itemDTO = itemDTO;
    }
}
