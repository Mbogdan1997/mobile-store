package com.example.demo.controller;

import com.example.demo.dto.IdDTO;
import com.example.demo.dto.ShoppingBascketItemDTO;
import com.example.demo.service.ShoppingBascketItemService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestShoppingBascketItemController implements ShoppingBascketItemApi {

    private ShoppingBascketItemService shoppingBascketItemService;

    public RestShoppingBascketItemController(ShoppingBascketItemService shoppingBascketItemService){
        this.shoppingBascketItemService=shoppingBascketItemService;
    }

    @Override
    public ShoppingBascketItemDTO addToCart(ShoppingBascketItemDTO shoppingBascketItemDTO, BindingResult bindingResult) {
       if(!bindingResult.hasErrors()) {
           return shoppingBascketItemService.addToCart(shoppingBascketItemDTO);
       }
       return null;
    }

    @Override
    public void removeFromCart(@PathVariable("id") Integer id) {
        shoppingBascketItemService.removeFromCart(id);
    }


}
