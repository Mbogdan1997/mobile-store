package com.example.demo.controller;

import com.example.demo.dto.ShoppingBascketDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.ShoppingBascketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestShoppingBascket implements ShoppingBascketApi {

    private ShoppingBascketService shoppingBascketService;

    @Autowired
    public RestShoppingBascket(ShoppingBascketService shoppingBascketService){
        this.shoppingBascketService=shoppingBascketService;
    }

    @Override
    public ShoppingBascketDTO process(ShoppingBascketDTO shoppingBascketDTO) {
        return shoppingBascketService.process(shoppingBascketDTO);
    }

    @Override
    public ShoppingBascketDTO getActiveShoppingCartForUser(UserDTO userDTO) {
        return shoppingBascketService.getActiveShoppingCartForUser(userDTO);
    }
}
