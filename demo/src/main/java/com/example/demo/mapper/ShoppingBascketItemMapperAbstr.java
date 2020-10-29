package com.example.demo.mapper;

import com.example.demo.dto.ShoppingBascketItemDTO;
import com.example.demo.entity.ShoppingBascket;
import com.example.demo.entity.ShoppingBascketItem;

import java.util.List;

public interface ShoppingBascketItemMapperAbstr {

    ShoppingBascketItem toEntityUpdate(int id);
    ShoppingBascketItemDTO toDTO(ShoppingBascketItem item);
    ShoppingBascketItem toEntity(ShoppingBascketItemDTO item);
    List<ShoppingBascketItem> toEntityList(List<ShoppingBascketItemDTO> shoppingBascketItemDTOS);
}
