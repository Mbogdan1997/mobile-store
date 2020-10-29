package com.example.demo.mapper;

import com.example.demo.dto.ItemDTO;
import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemMapper implements ItemMapperAbstr {

    private ItemRepository itemRepository;

    @Autowired
    public ItemMapper(ItemRepository itemRepository){
        this.itemRepository=itemRepository;
    }
    @Override
    public Item toEntityUpdate(ItemDTO itemDTO) {
        Item item=itemRepository.findById(itemDTO.getId());

        return item;
    }

    @Override
    public Item toEntity(ItemDTO itemDTO) {
        return new Item(itemDTO);
    }

    @Override
    public ItemDTO toDTO(Item item) {
        return new ItemDTO(item);
    }

    @Override
    public List<ItemDTO> toDTOList(List<Item> items) {
        List<ItemDTO> itemDTOS=new ArrayList<>();
        for(Item item:items){
            itemDTOS.add(toDTO(item));
        }
        return itemDTOS;
    }
}
