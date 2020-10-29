package com.swing.swingfrontend.gateway;

import com.swing.swingfrontend.dto.AdressDTO;
import com.swing.swingfrontend.repository.Repository;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public class AdressGatewayImpl implements AdressGateway {

    private static final String userURL="/adress";
    @Override
    public AdressDTO save(AdressDTO adressDTO) {
        String urlLogin= Repository.REST_PROPERTIES.getUrl()+userURL+"/save";
        RestTemplate restTemplate=new RestTemplate();

        HttpEntity<Object> httpEntity = new HttpEntity(adressDTO);
        AdressDTO response = restTemplate.postForObject(urlLogin, httpEntity, AdressDTO.class);
        return response;
    }
}
