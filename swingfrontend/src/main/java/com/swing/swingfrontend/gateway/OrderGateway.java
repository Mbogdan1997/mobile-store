package com.swing.swingfrontend.gateway;

import java.util.List;
import com.swing.swingfrontend.dto.OrderDTO;

public interface OrderGateway {

    OrderDTO save(OrderDTO orderDTO);

    List<OrderDTO> viewAllOrders();

    OrderDTO process(OrderDTO orderDTO);
}
