package com.example.demo.service;

import com.example.demo.dto.ShoppingBascketDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.ShoppingBascket;

public interface ShoppingBascketService {


    ShoppingBascketDTO getActiveShoppingCartForUser(UserDTO userDTO);

    ShoppingBascketDTO process(ShoppingBascketDTO shoppingBascketDTO);


}
