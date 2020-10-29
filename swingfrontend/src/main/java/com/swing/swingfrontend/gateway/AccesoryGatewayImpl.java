package com.swing.swingfrontend.gateway;

import com.swing.swingfrontend.dto.AccesorySearchDTO;
import com.swing.swingfrontend.dto.MobileAccesoryDTO;
import com.swing.swingfrontend.repository.Repository;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class AccesoryGatewayImpl implements AccesoryGateway {

    private static final String userURL="/accesory";
    @Override
    public List<MobileAccesoryDTO> viewAll() {
        String urlLogin= Repository.REST_PROPERTIES.getUrl()+userURL+"/list";
        RestTemplate restTemplate=new RestTemplate();


        ResponseEntity<MobileAccesoryDTO[]> forEntity = restTemplate.getForEntity(urlLogin, MobileAccesoryDTO[].class);
        MobileAccesoryDTO[] response = restTemplate.getForObject(urlLogin,MobileAccesoryDTO[].class);
        return Arrays.asList(response);
    }

    @Override
    public List<MobileAccesoryDTO> viewAllActive() {
        String urlLogin= Repository.REST_PROPERTIES.getUrl()+userURL+"/list"+"/active";
        RestTemplate restTemplate=new RestTemplate();


        ResponseEntity<MobileAccesoryDTO[]> forEntity = restTemplate.getForEntity(urlLogin, MobileAccesoryDTO[].class);
        MobileAccesoryDTO[] response = restTemplate.getForObject(urlLogin,MobileAccesoryDTO[].class);
        return Arrays.asList(response);
    }

    @Override
    public MobileAccesoryDTO save(MobileAccesoryDTO mobileAccesoryDTO) {
        String urlLogin= Repository.REST_PROPERTIES.getUrl()+userURL+"/save";
        RestTemplate restTemplate=new RestTemplate();

        HttpEntity<Object> httpEntity = new HttpEntity(mobileAccesoryDTO);
        MobileAccesoryDTO response = restTemplate.postForObject(urlLogin, httpEntity, MobileAccesoryDTO.class);
        return response;
    }

    @Override
    public List<MobileAccesoryDTO> search(AccesorySearchDTO accesorySearchDTO) {
        String urlLogin= Repository.REST_PROPERTIES.getUrl()+userURL+"/search";
        RestTemplate restTemplate=new RestTemplate();

        HttpEntity<Object> httpEntity = new HttpEntity(accesorySearchDTO);
        MobileAccesoryDTO[] response = restTemplate.postForObject(urlLogin, httpEntity, MobileAccesoryDTO[].class);
        return Arrays.asList(response);
    }
}
