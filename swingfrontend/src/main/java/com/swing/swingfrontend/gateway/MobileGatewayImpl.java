package com.swing.swingfrontend.gateway;

import com.swing.swingfrontend.dto.MobileDTO;
import com.swing.swingfrontend.dto.SearchDTO;
import com.swing.swingfrontend.repository.Repository;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class MobileGatewayImpl implements MobileGateway {

    private static final String userURL="/mobile";
    @Override
    public List<MobileDTO> viewAll() {
        String urlLogin= Repository.REST_PROPERTIES.getUrl()+userURL+"/list";
        RestTemplate restTemplate=new RestTemplate();


        ResponseEntity<MobileDTO[]> forEntity = restTemplate.getForEntity(urlLogin, MobileDTO[].class);
        MobileDTO[] response = restTemplate.getForObject(urlLogin, MobileDTO[].class);
        return Arrays.asList(response);
    }

    @Override
    public List<MobileDTO> viewAllActive() {
        String urlLogin= Repository.REST_PROPERTIES.getUrl()+userURL+"/list/active";
        RestTemplate restTemplate=new RestTemplate();


        ResponseEntity<MobileDTO[]> forEntity = restTemplate.getForEntity(urlLogin, MobileDTO[].class);
        MobileDTO[] response = restTemplate.getForObject(urlLogin, MobileDTO[].class);
        return Arrays.asList(response);
    }

    @Override
    public MobileDTO save(MobileDTO mobileDTO) {
        String urlLogin= Repository.REST_PROPERTIES.getUrl()+userURL+"/save";
        RestTemplate restTemplate=new RestTemplate();

        HttpEntity<Object> httpEntity = new HttpEntity(mobileDTO);
        MobileDTO response = restTemplate.postForObject(urlLogin, httpEntity, MobileDTO.class);
        return response;
    }

    @Override
    public List<MobileDTO> search(SearchDTO searchDTO) {
        String urlLogin= Repository.REST_PROPERTIES.getUrl()+userURL+"/search";
        RestTemplate restTemplate=new RestTemplate();

        HttpEntity<Object> httpEntity = new HttpEntity(searchDTO);
        MobileDTO[] response = restTemplate.postForObject(urlLogin, httpEntity, MobileDTO[].class);
        return Arrays.asList(response);
    }
}
