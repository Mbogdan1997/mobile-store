package com.swing.swingfrontend.gateway;

import com.swing.swingfrontend.dto.ShoppingBascketDTO;
import com.swing.swingfrontend.dto.UserDTO;
import com.swing.swingfrontend.repository.Repository;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public class ShoppingBascketGatewayImpl implements ShoppingBascketGateway {

    private static final String userURL="/shoppingbascket";
    @Override
    public ShoppingBascketDTO getActiveBascketForUser(UserDTO currentUser) {
        String urlLogin= Repository.REST_PROPERTIES.getUrl()+userURL+"/active";
        RestTemplate restTemplate=new RestTemplate();

        HttpEntity<Object> httpEntity = new HttpEntity(currentUser);
        ShoppingBascketDTO response = restTemplate.postForObject(urlLogin, httpEntity, ShoppingBascketDTO.class);
        return response;
    }

    @Override
    public ShoppingBascketDTO processShoppingBascket(ShoppingBascketDTO shoppingBascketDTO) {
        String urlLogin= Repository.REST_PROPERTIES.getUrl()+userURL+"/process";
        RestTemplate restTemplate=new RestTemplate();

        HttpEntity<Object> httpEntity = new HttpEntity(shoppingBascketDTO);
        ShoppingBascketDTO response = restTemplate.postForObject(urlLogin, httpEntity, ShoppingBascketDTO.class);
        return response;
    }
}
