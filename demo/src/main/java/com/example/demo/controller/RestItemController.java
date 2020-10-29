package com.example.demo.controller;

import com.example.demo.dto.IdDTO;
import com.example.demo.dto.ItemDTO;
import com.example.demo.dto.NameIdDTO;
import com.example.demo.dto.SearchDTO;
import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestItemController implements ItemRestApi {

    private ItemService itemService;
    @Autowired
    public  RestItemController(ItemService itemService){
        this.itemService=itemService;
    }

    @Override
    public ItemDTO save(ItemDTO itemDTO) {
        return itemService.save(itemDTO);
    }

    @Override
    public void inactive(IdDTO idDTO) {
        itemService.inactive(idDTO);
    }

    @Override
    public List<ItemDTO> findAll() {
        return itemService.findAllItems();
    }

/*    @Override
    public List<ItemDTO> findAllActive() {
        return itemService.findAllActiveItems();
    }

    @Override
    public List<ItemDTO> findAll() {
        return itemService.findAllItems();
    }

    /*@Override
    public List<ItemDTO> listAllActiveByCategory(NameIdDTO nameIdDTO) {
        return itemService.findAllActiveItemsByCategory(nameIdDTO);
    }
    */
/*
    @Override
    public List<ItemDTO> listAllActiveAfterFields(SearchDTO searchDTO) {
        return itemService.listAllActiveAfterFields(searchDTO);
    }
    */

    /*@Override
    public List<ItemDTO> findItemsByCategory(String itemCategory) {
        return itemService.findItemsByCategory(itemCategory);
    }
    */

    /*@Override
    public List<ItemDTO> findItemsByBrand(String brandName) {
        return itemService.findItemsByBrand(brandName);
    }*/
}
