package com.example.demo.mapper;

import com.example.demo.dto.ItemDTO;
import com.example.demo.entity.Item;

import java.util.List;

public interface ItemMapperAbstr {

    Item toEntityUpdate(ItemDTO itemDTO);
    Item toEntity(ItemDTO itemDTO);
    ItemDTO toDTO(Item item);
    List<ItemDTO> toDTOList(List<Item> items);
}
