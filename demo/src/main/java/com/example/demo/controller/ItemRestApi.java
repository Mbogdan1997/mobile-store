package com.example.demo.controller;

import com.example.demo.dto.IdDTO;
import com.example.demo.dto.ItemDTO;
import com.example.demo.dto.NameIdDTO;
import com.example.demo.dto.SearchDTO;
import com.example.demo.entity.Item;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.BindException;
import java.util.List;

@RequestMapping("/item")
public interface ItemRestApi {


    @PostMapping("/save")
    ItemDTO save(@Valid @RequestBody ItemDTO itemDTO);

    @PostMapping("/inactive")
    void inactive(@RequestBody IdDTO idDTO);

    @GetMapping("/list")
    List<ItemDTO> findAll()

    /*@GetMapping("/list/active")
    List<ItemDTO> findAllActive();

    @GetMapping("/list")
    List<ItemDTO> findAll();

    /*@GetMapping("/list/category")
    List<ItemDTO> listAllActiveByCategory(NameIdDTO nameIdDTO);
    */
    /*
    @GetMapping("/search")
    List<ItemDTO> listAllActiveAfterFields(SearchDTO searchDTO);
    */



    //@GetMapping("/category/{itemCategory}")
    //List<ItemDTO> findItemsByCategory(@PathVariable("itemCategory") String itemCategory);

    /*@GetMapping("/brand/{brandName}")
    List<ItemDTO> findItemsByBrand(@PathVariable("brandName") String brandName);
    */





}
