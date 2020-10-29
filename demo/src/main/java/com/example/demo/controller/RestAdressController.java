package com.example.demo.controller;

import com.example.demo.dto.AdressDTO;
import com.example.demo.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAdressController implements AdressRestApi {

    private AdressService adressService;
    @Autowired
    public RestAdressController(AdressService adressService){
        this.adressService=adressService;
    }
    @Override
    public AdressDTO save(AdressDTO adressDto) {
        return adressService.saveAdress(adressDto);
    }

}
