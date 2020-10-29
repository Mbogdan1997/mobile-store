package com.swing.swingfrontend.gateway;

import com.swing.swingfrontend.dto.UserDTO;
import com.swing.swingfrontend.repository.Repository;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserGatewayImpl implements UserGateway {

    private static final String userURL="/user";
    public UserDTO login(UserDTO userDTO) {
        String urlLogin= Repository.REST_PROPERTIES.getUrl()+userURL+"/login";
        RestTemplate restTemplate=new RestTemplate();

        HttpEntity<Object> httpEntity = new HttpEntity(userDTO);
        UserDTO response = restTemplate.postForObject(urlLogin, httpEntity, UserDTO.class);
        return response;


    }

    @Override
    public UserDTO signIn(UserDTO userDTO) {
        String urlLogin= Repository.REST_PROPERTIES.getUrl()+userURL+"/signin";
        RestTemplate restTemplate=new RestTemplate();

        HttpEntity<Object> httpEntity = new HttpEntity(userDTO);
        UserDTO response = restTemplate.postForObject(urlLogin, httpEntity, UserDTO.class);
        return response;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        String urlLogin= Repository.REST_PROPERTIES.getUrl()+userURL+"/save";
        RestTemplate restTemplate=new RestTemplate();

        HttpEntity<Object> httpEntity = new HttpEntity(userDTO);
        UserDTO response = restTemplate.postForObject(urlLogin, httpEntity, UserDTO.class);
        return response;
    }

    @Override
    public List<UserDTO> viewAll() {
        String urlLogin= Repository.REST_PROPERTIES.getUrl()+userURL+"/list";
        RestTemplate restTemplate=new RestTemplate();


        ResponseEntity<UserDTO[]> forEntity = restTemplate.getForEntity(urlLogin, UserDTO[].class);
        UserDTO[] response = restTemplate.getForObject(urlLogin, UserDTO[].class);
        return Arrays.asList(response);
    }
}