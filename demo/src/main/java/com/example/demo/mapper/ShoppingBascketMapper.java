package com.example.demo.mapper;

import com.example.demo.dto.ShoppingBascketDTO;
import com.example.demo.entity.ShoppingBascket;
import com.example.demo.entity.ShoppingBascketItem;
import com.example.demo.entity.User;
import com.example.demo.repository.ShoppingBascketRepository;
import com.example.demo.service.ShoppingBascketService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShoppingBascketMapper implements ShoppingBascketMapperAbstr {

    private ShoppingBascketRepository shoppingBascketService;
    private UserMapperAbstr userMapperAbstr;
    private ShoppingBascketItemMapperAbstr shoppingBascketItemMapperAbstr;
    @Autowired
    public ShoppingBascketMapper(ShoppingBascketItemMapperAbstr shoppingBascketItemMapperAbstr,UserMapperAbstr userMapperAbstr,ShoppingBascketRepository shoppingBascketService){
        this.shoppingBascketService=shoppingBascketService;
       this.userMapperAbstr=userMapperAbstr;
       this.shoppingBascketItemMapperAbstr=shoppingBascketItemMapperAbstr;

    }

    @Override
    public ShoppingBascketDTO toDTO(ShoppingBascket shoppingBascket) {
        return new ShoppingBascketDTO(shoppingBascket);
    }

    @Override
    public ShoppingBascket toEntity(ShoppingBascketDTO shoppingBascketDTO) {
        User user=userMapperAbstr.toEntityUpdate(shoppingBascketDTO.getUser());
        List<ShoppingBascketItem> shoppingBascketItemList=shoppingBascketItemMapperAbstr.toEntityList(shoppingBascketDTO.getShoppingBascketItemDTOList());
        return new ShoppingBascket(shoppingBascketDTO,user,shoppingBascketItemList);
    }


    @Override
    public ShoppingBascket toEntityUpdate(int id) {
        return shoppingBascketService.findById(id);
    }


}
