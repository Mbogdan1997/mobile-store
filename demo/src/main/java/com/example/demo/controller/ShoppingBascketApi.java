package com.example.demo.controller;

import com.example.demo.dto.ShoppingBascketDTO;
import com.example.demo.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/shoppingbascket")
public interface ShoppingBascketApi {

    @PostMapping("/process")
    ShoppingBascketDTO process(@RequestBody ShoppingBascketDTO shoppingBascketDTO);

    @PostMapping("/active")
    ShoppingBascketDTO getActiveShoppingCartForUser(@RequestBody UserDTO userDTO);

}
