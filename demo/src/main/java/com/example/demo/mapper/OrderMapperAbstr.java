package com.example.demo.mapper;

import com.example.demo.dto.OrderDTO;
import com.example.demo.entity.OrderEntity;

import java.util.List;

public interface OrderMapperAbstr {
    OrderEntity toEntity(OrderDTO orderDTO);
    OrderDTO toDTO(OrderEntity order);

    OrderEntity toEntityUpdate(int id);

    List<OrderDTO> toDTOList(List<OrderEntity> collect);
}
