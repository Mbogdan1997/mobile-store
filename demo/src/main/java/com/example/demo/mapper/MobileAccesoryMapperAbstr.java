package com.example.demo.mapper;

import com.example.demo.dto.MobileAccesoryDTO;
import com.example.demo.entity.MobileAccesory;

import java.util.List;

public interface MobileAccesoryMapperAbstr {

    MobileAccesoryDTO toDTO(MobileAccesory mobileAccesory);
    MobileAccesory toEntity(MobileAccesoryDTO mobileAccesoryDTO);
    MobileAccesory toEntityUpdate(int id);
    List<MobileAccesoryDTO> toDTOList(List<MobileAccesory> mobileAccesories);
}
