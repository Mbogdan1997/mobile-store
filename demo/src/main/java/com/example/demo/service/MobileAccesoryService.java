package com.example.demo.service;

import com.example.demo.dto.AccesorySearchDTO;
import com.example.demo.dto.IdDTO;
import com.example.demo.dto.MobileAccesoryDTO;
import com.example.demo.entity.MobileAccesory;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface MobileAccesoryService {

    List<MobileAccesoryDTO> viewAll();

    MobileAccesoryDTO save(MobileAccesoryDTO mobileDTO);

    List<MobileAccesoryDTO> viewAllActive();

    void remove(IdDTO mobileAccesoryDTO);

    List<MobileAccesoryDTO> searchMobile(AccesorySearchDTO searchDTO);
}
