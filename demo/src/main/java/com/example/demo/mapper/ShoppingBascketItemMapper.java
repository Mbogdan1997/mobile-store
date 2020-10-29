package com.example.demo.mapper;

import com.example.demo.dto.ShoppingBascketItemDTO;
import com.example.demo.entity.Item;
import com.example.demo.entity.ShoppingBascket;
import com.example.demo.entity.ShoppingBascketItem;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.ShoppingBascketItemRepository;
import com.example.demo.repository.ShoppingBascketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShoppingBascketItemMapper implements ShoppingBascketItemMapperAbstr {

    private ShoppingBascketItemRepository shoppingBascketItemRepository;
    private ShoppingBascketRepository shoppingBascketRepository;
    private ItemRepository itemRepository;

    @Autowired
    public ShoppingBascketItemMapper(ItemRepository itemRepository,ShoppingBascketRepository shoppingBascketRepository, ShoppingBascketItemRepository shoppingBascketItemRepository){
        this.shoppingBascketItemRepository=shoppingBascketItemRepository;
        this.shoppingBascketRepository=shoppingBascketRepository;
        this.itemRepository=itemRepository;

    }

    @Override
    public ShoppingBascketItem toEntityUpdate(int id) {
        return shoppingBascketItemRepository.findById(id);
    }

    @Override
    public ShoppingBascketItemDTO toDTO(ShoppingBascketItem item) {
        return new ShoppingBascketItemDTO(item);
    }

    @Override
    public ShoppingBascketItem toEntity(ShoppingBascketItemDTO item) {
        ShoppingBascketItem shoppingBascketItem=new ShoppingBascketItem();
        Item item1=itemRepository.findById(item.getItem().getId());
        ShoppingBascket shoppingBascket=shoppingBascketRepository.findById(item.getShoppingBascket().getId());
        shoppingBascketItem.setShoppingBascket(shoppingBascket);
        shoppingBascketItem.setQuantity(item.getQuantity());
        shoppingBascketItem.setItem(item1);
        return shoppingBascketItem;

    }

    @Override
    public List<ShoppingBascketItem> toEntityList(List<ShoppingBascketItemDTO> shoppingBascketItemDTOS) {
        List<ShoppingBascketItem> shoppingBascketItems=new ArrayList<>();
        for(ShoppingBascketItemDTO shoppingBascketItemDTO:shoppingBascketItemDTOS){
            shoppingBascketItems.add(toEntityUpdate(shoppingBascketItemDTO.getId()));
        }
        return shoppingBascketItems;
    }
}
