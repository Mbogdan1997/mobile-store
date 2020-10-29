package com.example.demo.mapper;

import com.example.demo.dto.ShoppingBascketDTO;
import com.example.demo.entity.ShoppingBascket;

public interface ShoppingBascketMapperAbstr {

    ShoppingBascketDTO toDTO(ShoppingBascket shoppingBascket);
    ShoppingBascket toEntity(ShoppingBascketDTO shoppingBascketDTO);
    ShoppingBascket toEntityUpdate(int id);

}
