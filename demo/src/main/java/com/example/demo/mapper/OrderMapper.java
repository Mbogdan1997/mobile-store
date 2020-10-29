package com.example.demo.mapper;

import com.example.demo.dto.AdressDTO;
import com.example.demo.dto.OrderDTO;
import com.example.demo.entity.Adress;
import com.example.demo.entity.OrderEntity;
import com.example.demo.entity.ShoppingBascket;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper implements OrderMapperAbstr {

    private AdressMapperAbstr adressMapperAbstr;
    private ShoppingBascketMapperAbstr shoppingBascketMapperAbstr;
    private OrderRepository orderRepository;


    @Autowired
    public OrderMapper(OrderRepository orderRepository,AdressMapperAbstr adressMapperAbstr,ShoppingBascketMapper shoppingBascketMapperAbstr){
        this.adressMapperAbstr=adressMapperAbstr;
        this.shoppingBascketMapperAbstr=shoppingBascketMapperAbstr;
        this.orderRepository=orderRepository;
    }

    @Override
    public OrderEntity toEntity(OrderDTO orderDTO) {
        ShoppingBascket shoppingBascket=shoppingBascketMapperAbstr.toEntityUpdate(orderDTO.getShoppingBascket());
        Adress adress=adressMapperAbstr.toEntity(orderDTO.getAdress());
        return new OrderEntity(orderDTO,adress);
    }

    @Override
    public OrderDTO toDTO(OrderEntity order) {
        AdressDTO adressDTO=adressMapperAbstr.toDTO(order.getAdress());
        return new OrderDTO(order,adressDTO);
    }

    @Override
    public OrderEntity toEntityUpdate(int id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<OrderDTO> toDTOList(List<OrderEntity> collect) {
        List<OrderDTO> orderDTOS=new ArrayList<>();
        for(OrderEntity orderEntity:collect){
            orderDTOS.add(toDTO(orderEntity));
        }
        return orderDTOS;
    }
}
