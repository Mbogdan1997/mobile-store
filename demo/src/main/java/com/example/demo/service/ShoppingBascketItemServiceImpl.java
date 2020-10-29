package com.example.demo.service;

import com.example.demo.dto.IdDTO;
import com.example.demo.dto.ShoppingBascketItemDTO;
import com.example.demo.entity.Item;
import com.example.demo.entity.ShoppingBascket;
import com.example.demo.entity.ShoppingBascketItem;
import com.example.demo.mapper.ShoppingBascketItemMapperAbstr;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.ShoppingBascketItemRepository;
import com.example.demo.repository.ShoppingBascketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Optional;

@Service
public class ShoppingBascketItemServiceImpl implements ShoppingBascketItemService {

    private ShoppingBascketItemRepository shoppingBascketRepository;
    private ShoppingBascketItemMapperAbstr shoppingBascketItemMapperAbstr;
    private ShoppingBascketItemRepository shoppingBascketItemRepository;
    private ItemRepository itemRepository;

    @Autowired
    public  ShoppingBascketItemServiceImpl(ItemRepository itemRepository,ShoppingBascketItemRepository shoppingBascketItemRepository,ShoppingBascketItemMapperAbstr shoppingBascketItemMapperAbstr,ShoppingBascketItemRepository shoppingBascketRepository){
        this.shoppingBascketRepository=shoppingBascketRepository;
        this.shoppingBascketItemMapperAbstr=shoppingBascketItemMapperAbstr;
        this.shoppingBascketItemRepository=shoppingBascketItemRepository;
        this.itemRepository=itemRepository;
    }

    @Override
    public ShoppingBascketItemDTO addToCart(ShoppingBascketItemDTO shoppingBascketItemDTO) {

            ShoppingBascketItem shoppingBascketItem = shoppingBascketItemMapperAbstr.toEntity(shoppingBascketItemDTO);
            Item item=itemRepository.findById(shoppingBascketItemDTO.getItem().getId());
            if(item.getQuantity()>=shoppingBascketItem.getQuantity()){
                item.setQuantity(item.getQuantity()-shoppingBascketItem.getQuantity());
                itemRepository.save(item);
                return shoppingBascketItemMapperAbstr.toDTO(shoppingBascketRepository.save(shoppingBascketItem));
            }
            return null;


    }

    @Override
    public void removeFromCart(Integer id) {
        ShoppingBascketItem shoppingBascketItemDTO = shoppingBascketItemRepository.findById(id).get();
        System.out.println(shoppingBascketItemDTO.getId());
        //System.out.println(shoppingBascketItemDTO.getItem().getId());
        ShoppingBascketItem item=shoppingBascketRepository.findById(shoppingBascketItemDTO.getId());
        item.getItem().setQuantity(item.getQuantity()+shoppingBascketItemDTO.getQuantity());
        shoppingBascketRepository.save(item);
         shoppingBascketRepository.deleteById(shoppingBascketItemDTO.getId());
    }

    @Override
    public ShoppingBascketItemDTO updateQuantity(ShoppingBascketItemDTO shoppingBascketItemDTO) {
        ShoppingBascketItem shoppingBascketItem=shoppingBascketItemMapperAbstr.toEntityUpdate(shoppingBascketItemDTO.getId());
        shoppingBascketItem.setQuantity(shoppingBascketItemDTO.getQuantity());
        shoppingBascketItemRepository.save(shoppingBascketItem);
        return shoppingBascketItemMapperAbstr.toDTO(shoppingBascketItem);
    }


}
