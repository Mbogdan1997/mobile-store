package com.example.demo.service;

import com.example.demo.dto.AdressDTO;
import com.example.demo.entity.Adress;
import com.example.demo.entity.User;
import com.example.demo.mapper.AdressMapper;
import com.example.demo.mapper.AdressMapperAbstr;
import com.example.demo.repository.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdressServiceImpl implements AdressService {

    private AdressRepository adressRepository;
    private AdressMapperAbstr adressMapperAbstr;
    @Autowired
    public AdressServiceImpl(AdressRepository adressRepository,AdressMapperAbstr adressMapperAbstr){
        this.adressRepository=adressRepository;
        this.adressMapperAbstr=adressMapperAbstr;


    }
    @Override
    public AdressDTO saveAdress(AdressDTO adressDTO) {
        Adress adress=adressMapperAbstr.toEntity(adressDTO);
        adressDTO.setId(adressRepository.save(adress).getId());
    return adressDTO;
    }

}
