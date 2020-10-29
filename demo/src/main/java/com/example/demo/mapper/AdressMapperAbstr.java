package com.example.demo.mapper;

import com.example.demo.dto.AdressDTO;
import com.example.demo.entity.Adress;

public interface AdressMapperAbstr {

    Adress toEntityUpdate(AdressDTO adressDTO);
    AdressDTO toDTO(Adress adress);
    Adress toEntity(AdressDTO adressDTO);
}
