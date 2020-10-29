package com.example.demo.controller;

import com.example.demo.dto.AccesorySearchDTO;
import com.example.demo.dto.MobileAccesoryDTO;
import com.example.demo.entity.MobileAccesory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/accesory")
public interface MobileAccesoryRestApi {

    @GetMapping("/list")
    List<MobileAccesoryDTO> viewAll();

    @PostMapping("/save")
    MobileAccesoryDTO save(@Valid @RequestBody MobileAccesoryDTO mobileDTO);

    /*@PostMapping("/remove")
    void removeMobile(MobileAccesoryDTO mobileDTO);
    */

    @GetMapping("/list/active")
    List<MobileAccesoryDTO> viewAllActive();

    @PostMapping("/search")
    List<MobileAccesoryDTO> searchMobile(@RequestBody AccesorySearchDTO searchDTO);
}
