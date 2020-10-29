package com.example.demo.mapper;

import com.example.demo.dto.AdressDTO;
import com.example.demo.entity.Adress;
import com.example.demo.repository.AdressRepository;
import org.springframework.stereotype.Component;

@Component
public class AdressMapper implements AdressMapperAbstr {

    private AdressRepository adressRepository;
    @Override
    public Adress toEntityUpdate(AdressDTO adressDTO) {
        return adressRepository.findById(adressDTO.getId());
    }



    @Override
    public AdressDTO toDTO(Adress adress) {
        return new AdressDTO(adress);
    }

    @Override
    public Adress toEntity(AdressDTO adressDTO) {
        return new Adress(adressDTO);
    }
}
