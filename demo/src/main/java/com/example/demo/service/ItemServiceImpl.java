package com.example.demo.service;

import antlr.StringUtils;
import com.example.demo.dto.IdDTO;
import com.example.demo.dto.ItemDTO;
import com.example.demo.dto.NameIdDTO;
import com.example.demo.dto.SearchDTO;
import com.example.demo.entity.Item;
import com.example.demo.mapper.ItemMapperAbstr;
import com.example.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;
    private ItemMapperAbstr itemMapperAbstr;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository,ItemMapperAbstr itemMapperAbstr){
        this.itemRepository=itemRepository;
        this.itemMapperAbstr=itemMapperAbstr;
    }

   /* @Override
    public List<ItemDTO> findItemsByName(String itemName) {
        return itemMapperAbstr.toDTOList(itemRepository.findByName(itemName));
    }

    /*@Override
    public List<ItemDTO> findItemsByCategory(String itemCategory) {
        List<Item> items=itemRepository.findAll().stream().filter((x)->x.getCategory().equals(itemCategory)).collect(Collectors.toList());
        return itemMapperAbstr.toDTOList(items);
    }
    */

   /* @Override
    public List<ItemDTO> findItemsByBrand(String brandName) {
        List<Item> items=itemRepository.findAll().stream().filter((x)->x.getBrand().equals(brandName)).collect(Collectors.toList());
        return itemMapperAbstr.toDTOList(items);
    }
    */

    @Override
    public ItemDTO save(ItemDTO itemDTO) {
        //if(!bindingResult.hasErrors()) {
            Item item=itemRepository.findById(itemDTO.getId());
            if(item!=null){
                item.setActive(itemDTO.isActive());
                item.setBrand(itemDTO.getBrand());
                item.setColor(itemDTO.getColor());
                item.setDescription(itemDTO.getDescription());
                item.setImage(itemDTO.getImage());
                item.setName(itemDTO.getName());
                item.setPrice(itemDTO.getPrice());
                item.setQuantity(itemDTO.getQuantity());
                return itemMapperAbstr.toDTO(itemRepository.save(item));
            }
            else {
                item=itemMapperAbstr.toEntity(itemDTO);
                return itemMapperAbstr.toDTO(itemRepository.save(item));
            }

       // }
        //return null;
    }

    @Override
    public void inactive(IdDTO idDTO) {
        Item item=itemRepository.findById(idDTO.getId());
        item.setActive(false);
        itemRepository.save(item);
    }

    @Override
    public List<ItemDTO> findAllItems() {
        return itemMapperAbstr.toDTOList(itemRepository.findAll());
    }

    /*@Override
    public List<ItemDTO> findAllActiveItems() {
        return itemMapperAbstr.toDTOList(itemRepository.findByIsActive(true));
    }

    @Override
    public List<ItemDTO> findAllItems() {
        return itemMapperAbstr.toDTOList(itemRepository.findAll());
    }

    /*@Override
    public List<ItemDTO> findAllActiveItemsByCategory(NameIdDTO category) {
        return findAllActiveItems().stream().filter(itemDTO -> itemDTO.getCategory().equals(category.getName())).collect(Collectors.toList());
    }
    */

    /*@Override
    public List<ItemDTO> listAllActiveAfterFields(SearchDTO searchDTO) {
        return findAllActiveItems().stream()
                .filter(x->searchDTO.getName()==null || searchDTO.getName()=="" || x.getName().equals(searchDTO.getName()))
                .filter(x->searchDTO.getBrand()==null||searchDTO.getBrand()==""|| x.getBrand().equals(searchDTO.getBrand()))
                .filter(x->searchDTO.getColor()==null||searchDTO.getColor()==""||x.getColor().equals(searchDTO.getColor()))
                .collect(Collectors.toList());
    }
    */
}
