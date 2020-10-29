package com.example.demo.controller;

import com.example.demo.dto.AccesorySearchDTO;
import com.example.demo.dto.MobileAccesoryDTO;
import com.example.demo.service.MobileAccesoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
@RestController
public class RestMobileAccesoryController implements MobileAccesoryRestApi {

    private MobileAccesoryService mobileAccesoryService;

    public RestMobileAccesoryController(){

    }

    @Autowired
    public RestMobileAccesoryController(MobileAccesoryService mobileAccesoryService){

        this.mobileAccesoryService=mobileAccesoryService;
    }

    @Override
    public List<MobileAccesoryDTO> viewAll() {
        return mobileAccesoryService.viewAll();
    }

    @Override
    public MobileAccesoryDTO save(@Valid MobileAccesoryDTO mobileDTO) {
        return mobileAccesoryService.save(mobileDTO);
    }

    /*@Override
    public void removeMobile(MobileAccesoryDTO mobileDTO) {

    }
    */

    @Override
    public List<MobileAccesoryDTO> viewAllActive() {
        return mobileAccesoryService.viewAllActive();
    }

    @Override
    public List<MobileAccesoryDTO> searchMobile(AccesorySearchDTO searchDTO) {
        return mobileAccesoryService.searchMobile(searchDTO);
    }
}
