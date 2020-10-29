package com.swing.swingfrontend.gateway;

import com.swing.swingfrontend.dto.ItemDTO;
import com.swing.swingfrontend.repository.Repository;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public class ItemGatewayImpl implements ItemGateway {

    private static final String userURL="/item";
    @Override
    public ItemDTO saveItem(ItemDTO itemDTO) {
        String urlLogin= Repository.REST_PROPERTIES.getUrl()+userURL+"/save";
        RestTemplate restTemplate=new RestTemplate();

        HttpEntity<Object> httpEntity = new HttpEntity(itemDTO);
        ItemDTO response = restTemplate.postForObject(urlLogin, httpEntity, ItemDTO.class);
        return response;
    }
}
