package com.swing.swingfrontend.service;

import com.swing.swingfrontend.dto.*;
import com.swing.swingfrontend.noadmin.Order;

import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public Object[][] getUserData(List<UserDTO> userDTOList) {

        Object[][] userData=new Object[userDTOList.size()][4];
        int i=0;
        for(UserDTO userDTO:userDTOList){
            userData[i][0]=userDTO.getId();
            userData[i][1]=userDTO.getUsername();
            userData[i][2]=userDTO.getPassword();
            userData[i][3]=userDTO.getStringRepresentationOfRole();
            i++;
        }
        return userData;
    }

    @Override
    public Object[][] getMobileData(List<MobileDTO> mobileDTOList) {
        Object[][] mobileData=new Object[mobileDTOList.size()][10];
        int i=0;
        for(MobileDTO mobileDTO:mobileDTOList){
            mobileData[i][0]=mobileDTO.getId();
            mobileData[i][1]=mobileDTO.getItemDTO().getId();
            mobileData[i][2]=mobileDTO.getItemDTO().getName();
            mobileData[i][3]=mobileDTO.getItemDTO().getDescription();
            mobileData[i][4]=mobileDTO.getItemDTO().getPrice();
            mobileData[i][5]=mobileDTO.getItemDTO().getQuantity();
            mobileData[i][6]=mobileDTO.getItemDTO().getImage();
            mobileData[i][7]=mobileDTO.getItemDTO().getBrand();
            mobileData[i][8]=mobileDTO.getItemDTO().getColor();
            mobileData[i][9]=mobileDTO.getItemDTO().isActive();
            i++;
        }
        return mobileData;
    }

    @Override
    public Object[][] getAccesoryData(List<MobileAccesoryDTO> mobileAccesoryDTOList) {
        Object[][] mobileData=new Object[mobileAccesoryDTOList.size()][12];
        int i=0;
        for(MobileAccesoryDTO mobileDTO:mobileAccesoryDTOList){
            mobileData[i][0]=mobileDTO.getId();
            mobileData[i][1]=mobileDTO.getItemDTO().getId();
            mobileData[i][2]=mobileDTO.getItemDTO().getName();
            mobileData[i][3]=mobileDTO.getItemDTO().getDescription();
            mobileData[i][4]=mobileDTO.getItemDTO().getPrice();
            mobileData[i][5]=mobileDTO.getItemDTO().getQuantity();
            mobileData[i][6]=mobileDTO.getItemDTO().getImage();
            mobileData[i][7]=mobileDTO.getItemDTO().getBrand();
            mobileData[i][8]=mobileDTO.getItemDTO().getColor();
            mobileData[i][9]=mobileDTO.getItemDTO().isActive();
            mobileData[i][10]=mobileDTO.getCategory();
            mobileData[i][11]=mobileDTO.getMobile();
            i++;
        }
        return mobileData;
    }

    @Override
    public Object[][] getShoppingBascketItemData(List<ShoppingBascketItemDTO> shoppingBascketItemDTOS) {
        Object[][] userData=new Object[shoppingBascketItemDTOS.size()][4];
        int i=0;
        for(ShoppingBascketItemDTO userDTO:shoppingBascketItemDTOS){
            userData[i][0]=userDTO.getId();
            userData[i][1]=userDTO.getItem().getName();
            userData[i][2]=userDTO.getQuantity();
            userData[i][3]=userDTO.getTotal();
            i++;
        }
        return userData;
    }

    @Override
    public Object[][] getOrderData(List<OrderDTO> orders) {
        Object[][] data=new Object[orders.size()][5];
        int i=0;
        for(OrderDTO order:orders){
            data[i][0]=order.getId();
            data[i][1]=order.getCustomerName();
            data[i][2]=order.getAdress().getCityName();
            data[i][3]=order.getTotal();
            data[i][4]=order.getOrderStartDate();
        }
        return data;
    }
}
