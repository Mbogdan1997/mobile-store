package com.example.demo.controller;

import com.example.demo.dto.OrderDTO;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestOrderController implements OrderRestApi {

    private OrderService orderService;

    @Autowired
    public RestOrderController(OrderService orderService){
        this.orderService=orderService;
    }
    @Override
    public OrderDTO save(@RequestBody OrderDTO orderDTO) {
        return orderService.saveOrder(orderDTO);
    }

    @Override
    public OrderDTO process(OrderDTO orderDTO) {
        return orderService.processOrder(orderDTO);
    }

    @Override
    public List<OrderDTO> viewAllActiveOrders() {
        return orderService.viewAll();
    }


}
