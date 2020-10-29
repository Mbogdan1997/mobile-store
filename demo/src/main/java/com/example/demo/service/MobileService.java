package com.example.demo.service;

import com.example.demo.dto.IdDTO;
import com.example.demo.dto.MobileDTO;
import com.example.demo.dto.SearchDTO;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface MobileService {
    List<MobileDTO> viewAll();

    MobileDTO save(MobileDTO mobileDTO);

    List<MobileDTO> viewAllActive();

    void remove(IdDTO mobileDTO);

    List<MobileDTO> searchMobile(SearchDTO searchDTO);
}
