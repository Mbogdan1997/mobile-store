package com.swing.swingfrontend.gateway;

import com.swing.swingfrontend.dto.ShoppingBascketDTO;
import com.swing.swingfrontend.dto.UserDTO;

public interface ShoppingBascketGateway {

    ShoppingBascketDTO getActiveBascketForUser(UserDTO currentUser);
    ShoppingBascketDTO processShoppingBascket(ShoppingBascketDTO shoppingBascketDTO);

}
