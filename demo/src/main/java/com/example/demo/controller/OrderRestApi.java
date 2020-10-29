package com.example.demo.controller;


import com.example.demo.dto.OrderDTO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/order")
public interface OrderRestApi {

    @PostMapping("/save")
    OrderDTO save(@Valid  @RequestBody OrderDTO orderDTO);

    @PostMapping("/process")
    OrderDTO process(@RequestBody OrderDTO orderDTO);

    @GetMapping("/list")
    List<OrderDTO> viewAllActiveOrders();

}
