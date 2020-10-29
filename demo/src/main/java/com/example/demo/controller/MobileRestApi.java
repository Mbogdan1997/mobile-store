package com.example.demo.controller;

import com.example.demo.dto.MobileDTO;
import com.example.demo.dto.SearchDTO;
import com.example.demo.entity.Mobile;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/mobile")
public interface MobileRestApi {

    @GetMapping("/list")
    List<MobileDTO> viewAll();

    @PostMapping("/save")
    MobileDTO save(@Valid @RequestBody MobileDTO mobileDTO);

    /*@PostMapping("/remove")
    void removeMobile(MobileDTO mobileDTO);
    */

    @GetMapping("/list/active")
    List<MobileDTO> viewAllActive();

    @PostMapping("/search")
    List<MobileDTO> searchMobile(@RequestBody  SearchDTO searchDTO);

}
