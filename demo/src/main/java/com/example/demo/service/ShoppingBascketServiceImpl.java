package com.example.demo.service;

import com.example.demo.dto.ShoppingBascketDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.ShoppingBascket;
import com.example.demo.entity.User;
import com.example.demo.mapper.ShoppingBascketMapper;
import com.example.demo.mapper.ShoppingBascketMapperAbstr;
import com.example.demo.mapper.UserMapperAbstr;
import com.example.demo.repository.ShoppingBascketRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingBascketServiceImpl implements ShoppingBascketService{

    private ShoppingBascketRepository shoppingBascketRepository;
    private ShoppingBascketMapperAbstr shoppingBascketMapperAbstr;
    private UserRepository userRepository;
    private UserMapperAbstr userMapperAbstr;

    @Autowired
    private ShoppingBascketServiceImpl(ShoppingBascketMapperAbstr shoppingBascketMapperAbstr,UserMapperAbstr userMapperAbstr,UserRepository userRepository,ShoppingBascketRepository shoppingBascketRepository){
        this.shoppingBascketRepository=shoppingBascketRepository;
        this.userRepository=userRepository;
        this.userMapperAbstr=userMapperAbstr;
        this.shoppingBascketMapperAbstr=shoppingBascketMapperAbstr;
    }

    @Override
    public ShoppingBascketDTO getActiveShoppingCartForUser(UserDTO userDTO) {
        List<ShoppingBascket> shoppingBascketList=shoppingBascketRepository.findAll().stream().
                filter(x->x.getUser().getId()==userDTO.getId() && x.isActive()).collect(Collectors.toList());
        if(shoppingBascketList.isEmpty()){
            User user=userMapperAbstr.toEntityUpdate(userDTO.getId());
            ShoppingBascket shoppingBascket=new ShoppingBascket(user);
            shoppingBascket.setActive(true);
            shoppingBascket.setId(shoppingBascketRepository.save(shoppingBascket).getId());
            return shoppingBascketMapperAbstr.toDTO(shoppingBascket);
        }
        return shoppingBascketMapperAbstr.toDTO(shoppingBascketList.get(0));
    }

    @Override
    public ShoppingBascketDTO process(ShoppingBascketDTO shoppingBascketDTO) {
        ShoppingBascket shoppingBascket=shoppingBascketMapperAbstr.toEntityUpdate(shoppingBascketDTO.getId());
        shoppingBascket.setActive(false);
        return shoppingBascketMapperAbstr.toDTO(shoppingBascketRepository.save(shoppingBascket));
    }


}
