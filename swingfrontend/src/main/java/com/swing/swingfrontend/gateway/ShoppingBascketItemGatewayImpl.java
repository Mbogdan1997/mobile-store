package com.swing.swingfrontend.gateway;

import com.swing.swingfrontend.dto.ShoppingBascketDTO;
import com.swing.swingfrontend.dto.ShoppingBascketItemDTO;
import com.swing.swingfrontend.dto.UserDTO;
import com.swing.swingfrontend.repository.Repository;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public class ShoppingBascketItemGatewayImpl implements ShoppingBascketItemGateway {
    private static final String userURL="/shoppingBascketItem";

    @Override
    public ShoppingBascketItemDTO addToCart(ShoppingBascketItemDTO shoppingBascketItemDTO) {
        String urlLogin= Repository.REST_PROPERTIES.getUrl()+userURL+"/save";
        RestTemplate restTemplate=new RestTemplate();

        HttpEntity<Object> httpEntity = new HttpEntity(shoppingBascketItemDTO);
        ShoppingBascketItemDTO response = restTemplate.postForObject(urlLogin, httpEntity, ShoppingBascketItemDTO.class);
        return response;
    }

    @Override
    public void removeFromCart(ShoppingBascketItemDTO shoppingBascketItemDTO) {
        String urlLogin= Repository.REST_PROPERTIES.getUrl()+userURL+ "/" + shoppingBascketItemDTO.getId()+ "/delete";
        RestTemplate restTemplate=new RestTemplate();

        HttpEntity<Object> httpEntity = new HttpEntity(shoppingBascketItemDTO);
         restTemplate.delete(urlLogin);

    }
}
