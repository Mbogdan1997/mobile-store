package com.swing.swingfrontend.gateway;

import java.util.List;
import com.swing.swingfrontend.dto.OrderDTO;
import com.swing.swingfrontend.noadmin.Order;
import com.swing.swingfrontend.repository.Repository;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class OrderGatewayImpl implements OrderGateway {

    private static final String userURL="/order";
    @Override
    public OrderDTO save(OrderDTO orderDTO) {
        String urlLogin= Repository.REST_PROPERTIES.getUrl()+userURL+"/save";
        RestTemplate restTemplate=new RestTemplate();

        HttpEntity<Object> httpEntity = new HttpEntity(orderDTO);
        OrderDTO response = restTemplate.postForObject(urlLogin, httpEntity, OrderDTO.class);
        return response;
    }

    @Override
    public List<OrderDTO> viewAllOrders() {
        String urlLogin= Repository.REST_PROPERTIES.getUrl()+userURL+"/list";
        RestTemplate restTemplate=new RestTemplate();


        ResponseEntity<OrderDTO[]> forEntity = restTemplate.getForEntity(urlLogin, OrderDTO[].class);
        OrderDTO[] response = restTemplate.getForObject(urlLogin, OrderDTO[].class);
        return Arrays.asList(response);
    }

    @Override
    public OrderDTO process(OrderDTO orderDTO) {
        String urlLogin= Repository.REST_PROPERTIES.getUrl()+userURL+"/process";
        RestTemplate restTemplate=new RestTemplate();

        HttpEntity<Object> httpEntity = new HttpEntity(orderDTO);
        OrderDTO response = restTemplate.postForObject(urlLogin, httpEntity, OrderDTO.class);
        return response;
    }
}
