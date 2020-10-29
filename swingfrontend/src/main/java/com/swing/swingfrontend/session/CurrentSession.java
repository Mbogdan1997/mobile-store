package com.swing.swingfrontend.session;

import com.swing.swingfrontend.dto.ShoppingBascketDTO;
import com.swing.swingfrontend.dto.UserDTO;

public class CurrentSession {

    private UserDTO currentUser;
    private ShoppingBascketDTO currentShoppingBascket;

    public UserDTO getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserDTO currentUser) {
        this.currentUser = currentUser;
    }

    public ShoppingBascketDTO getCurrentShoppingBascket() {
        return currentShoppingBascket;
    }

    public void setCurrentShoppingBascket(ShoppingBascketDTO currentShoppingBascket) {
        this.currentShoppingBascket = currentShoppingBascket;
    }
}