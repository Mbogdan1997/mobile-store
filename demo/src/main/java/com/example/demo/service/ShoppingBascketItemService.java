package com.example.demo.service;

import com.example.demo.dto.IdDTO;
import com.example.demo.dto.ShoppingBascketItemDTO;
import org.springframework.validation.BindingResult;

public interface ShoppingBascketItemService {
    ShoppingBascketItemDTO addToCart(ShoppingBascketItemDTO shoppingBascketItemDTO);

    void removeFromCart(Integer id);

    ShoppingBascketItemDTO updateQuantity(ShoppingBascketItemDTO shoppingBascketItemDTO);


}
