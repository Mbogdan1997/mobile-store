package com.example.demo.controller;

import com.example.demo.dto.AdressDTO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/adress")
public interface AdressRestApi {

    @PostMapping("/save")
    public AdressDTO save(@Valid @RequestBody AdressDTO adressDto);


}
