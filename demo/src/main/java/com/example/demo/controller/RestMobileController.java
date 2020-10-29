package com.example.demo.controller;

import com.example.demo.dto.MobileDTO;
import com.example.demo.dto.SearchDTO;
import com.example.demo.entity.Mobile;
import com.example.demo.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RestMobileController implements MobileRestApi {

    private MobileService mobileService;

    public RestMobileController(){

    }

    @Autowired
    public  RestMobileController(MobileService mobileService){
        this.mobileService=mobileService;
    }

    @Override
    public List<MobileDTO> viewAll() {
        return mobileService.viewAll();
    }

    @Override
    public MobileDTO save(@Valid MobileDTO mobileDTO) {
        return mobileService.save(mobileDTO);
    }

    /*@Override
    public void removeMobile(MobileDTO mobileDTO) {
           mobileService.remove(mobileDTO);
    }
    */

    @Override
    public List<MobileDTO> viewAllActive() {
        return mobileService.viewAllActive();
    }

    @Override
    public List<MobileDTO> searchMobile(SearchDTO searchDTO) {
        return mobileService.searchMobile(searchDTO);
    }
}
