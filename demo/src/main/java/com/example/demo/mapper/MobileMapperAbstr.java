package com.example.demo.mapper;

import com.example.demo.dto.MobileDTO;
import com.example.demo.entity.Mobile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MobileMapperAbstr {

    MobileDTO toDTO(Mobile mobile);
    Mobile toEntityUpdate(int mobileDTO);
    Mobile toEntity(MobileDTO mobileDTO);
    List<MobileDTO> toDTOList(List<Mobile> mobileList);
}
