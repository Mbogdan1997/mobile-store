package com.example.demo.controller;

import com.example.demo.dto.IdDTO;
import com.example.demo.dto.ShoppingBascketItemDTO;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/shoppingBascketItem")
public interface ShoppingBascketItemApi {

    @PostMapping("/save")
    ShoppingBascketItemDTO addToCart(@Valid @RequestBody ShoppingBascketItemDTO shoppingBascketItemDTO, BindingResult bindingResult);

    @DeleteMapping("/{id}/delete")
    void removeFromCart(@PathVariable("id") Integer id);



}
