package com.swing.swingfrontend.dto;


import com.swing.swingfrontend.gateway.AccesoryGateway;
import com.swing.swingfrontend.service.DataConverter;

public class MobileAccesoryDTO extends IdDTO {

    private ItemDTO itemDTO;
    private String mobile;
    private String category;







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
