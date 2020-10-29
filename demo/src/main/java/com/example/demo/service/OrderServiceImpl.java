package com.example.demo.service;

import com.example.demo.dto.OrderDTO;
import com.example.demo.entity.Adress;
import com.example.demo.entity.OrderEntity;
import com.example.demo.entity.ShoppingBascket;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.mapper.OrderMapperAbstr;
import com.example.demo.repository.AdressRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ShoppingBascketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private OrderMapperAbstr orderMapper;
    private ShoppingBascketRepository shoppingBascketRepository;
    private AdressRepository adressRepository;

    @Autowired
    public OrderServiceImpl(AdressRepository adressRepository,ShoppingBascketRepository shoppingBascketRepository,OrderRepository orderRepository,OrderMapperAbstr orderMapper){
        this.orderRepository=orderRepository;
        this.orderMapper=orderMapper;
        this.adressRepository=adressRepository;
        this.shoppingBascketRepository=shoppingBascketRepository;
    }
    @Override
    public OrderDTO saveOrder(OrderDTO orderDTO) {
        OrderEntity orderEntity=orderMapper.toEntity(orderDTO);
        Date date=new Date();
        ShoppingBascket shoppingBascket=shoppingBascketRepository.findById(orderDTO.getShoppingBascket());
        Adress adress=adressRepository.findById(orderDTO.getAdress().getId());
        orderEntity.setAdress(adress);
        orderEntity.setShoppingBascket(shoppingBascket);
        orderEntity.setOrderStartDate(date);
        return orderMapper.toDTO(orderRepository.save(orderEntity));
    }

    @Override
    public OrderDTO processOrder(OrderDTO orderDTO) {
        OrderEntity order=orderMapper.toEntityUpdate(orderDTO.getId());
        if(!order.isProcessed()) {
            Date date = new Date();
            order.setOrderFinishDate(date);
            order.setProcessed(true);
            order.getShoppingBascket().setActive(false);
        }
        return orderMapper.toDTO(orderRepository.save(order));
    }

    @Override
    public List<OrderDTO> viewAll() {
        return orderMapper.toDTOList(orderRepository.findAll().stream().filter(x->!x.isProcessed()).collect(Collectors.toList()));
    }
}
