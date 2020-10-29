package com.swing.swingfrontend.service;

import com.swing.swingfrontend.dto.*;
import com.swing.swingfrontend.noadmin.Order;

import java.util.List;

public interface DataConverter {

    Object[][] getUserData(List<UserDTO> userDTOList);
    Object[][] getMobileData(List<MobileDTO> mobileDTOList);
    Object[][] getAccesoryData(List<MobileAccesoryDTO> mobileAccesoryDTOList);
    Object[][] getShoppingBascketItemData(List<ShoppingBascketItemDTO> shoppingBascketItemDTOS);
    Object[][] getOrderData(List<OrderDTO> orders);
}
