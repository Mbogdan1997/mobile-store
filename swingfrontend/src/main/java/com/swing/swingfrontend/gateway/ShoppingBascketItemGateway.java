package com.swing.swingfrontend.gateway;

import com.swing.swingfrontend.dto.ShoppingBascketItemDTO;

public interface ShoppingBascketItemGateway {

    ShoppingBascketItemDTO addToCart(ShoppingBascketItemDTO shoppingBascketItemDTO);
    void removeFromCart(ShoppingBascketItemDTO shoppingBascketItemDTO);
}
