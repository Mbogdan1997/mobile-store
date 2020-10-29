package com.example.demo.service;

import com.example.demo.dto.OrderDTO;
import com.example.demo.entity.OrderEntity;

import java.util.List;

public interface OrderService {

    OrderDTO saveOrder(OrderDTO orderDTO);

    OrderDTO processOrder(OrderDTO orderDTO);

    List<OrderDTO> viewAll();
}
