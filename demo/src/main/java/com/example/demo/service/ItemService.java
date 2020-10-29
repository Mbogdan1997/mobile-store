package com.example.demo.service;

import com.example.demo.dto.IdDTO;
import com.example.demo.dto.ItemDTO;
import com.example.demo.dto.NameIdDTO;
import com.example.demo.dto.SearchDTO;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface ItemService {
    //List<ItemDTO> findItemsByName(String itemName);

    //List<ItemDTO> findItemsByCategory(String itemCategory);

   // List<ItemDTO> findItemsByBrand(String brandName);

    ItemDTO save(ItemDTO itemDTO);//, BindingResult bindingResult);

    List<ItemDTO> findAllItems();
    /*List<ItemDTO> findAllActiveItems();

    List<ItemDTO> findAllItems();

    //List<ItemDTO> findAllActiveItemsByCategory(NameIdDTO category);

    List<ItemDTO> listAllActiveAfterFields(SearchDTO searchDTO);
    */

    void inactive(IdDTO idDTO);
}
