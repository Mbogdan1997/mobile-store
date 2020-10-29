package com.example.demo.service;

import com.example.demo.dto.AccesorySearchDTO;
import com.example.demo.dto.IdDTO;
import com.example.demo.dto.MobileAccesoryDTO;
import com.example.demo.entity.Item;
import com.example.demo.entity.MobileAccesory;
import com.example.demo.mapper.ItemMapperAbstr;
import com.example.demo.mapper.MobileAccesoryMapperAbstr;
import com.example.demo.repository.MobileAccesoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MobileAccesoryServiceImpl implements MobileAccesoryService {

    private MobileAccesoryRepository mobileAccesoryRepository;
    private MobileAccesoryMapperAbstr mobileAccesoryMapperAbstr;
    private ItemMapperAbstr  itemMapperAbstr;

    public MobileAccesoryServiceImpl(){

    }

    @Autowired
    public MobileAccesoryServiceImpl(ItemMapperAbstr itemMapperAbstr,MobileAccesoryRepository mobileAccesoryRepository,MobileAccesoryMapperAbstr mobileAccesoryMapperAbstr){
        this.mobileAccesoryMapperAbstr=mobileAccesoryMapperAbstr;
        this.mobileAccesoryMapperAbstr=mobileAccesoryMapperAbstr;
        this.itemMapperAbstr=itemMapperAbstr;
        this.mobileAccesoryRepository=mobileAccesoryRepository;

    }
    @Override
    public List<MobileAccesoryDTO> viewAll() {
        return mobileAccesoryMapperAbstr.toDTOList(mobileAccesoryRepository.findAll());
    }

    @Override
    public MobileAccesoryDTO save(MobileAccesoryDTO mobileDTO)
    {
        //if(!bindingResult.hasErrors()){
        MobileAccesory accesory=mobileAccesoryRepository.findById(mobileDTO.getId());
            if(accesory==null){
                Item item=itemMapperAbstr.toEntityUpdate(mobileDTO.getItemDTO());
                MobileAccesory mobileAccesory=new MobileAccesory(mobileDTO.getId(),item,mobileDTO.getCategory(),mobileDTO.getMobile());
                return mobileAccesoryMapperAbstr.toDTO(mobileAccesoryRepository.save(mobileAccesory));
            }
            else{
                accesory.getItem().update(mobileDTO.getItemDTO());
                accesory.update(mobileDTO);
            }
       // }
        return null;
    }

    @Override
    public List<MobileAccesoryDTO> viewAllActive() {
        return viewAll().stream().filter(x->x.getItemDTO().isActive()).collect(Collectors.toList());
    }

    @Override
    public void remove(IdDTO mobileAccesoryDTO) {

        MobileAccesory mobileAccesory=mobileAccesoryMapperAbstr.toEntityUpdate(mobileAccesoryDTO.getId());
        mobileAccesory.getItem().setActive(false);
        mobileAccesoryRepository.save(mobileAccesory);

    }

    @Override
    public List<MobileAccesoryDTO> searchMobile(AccesorySearchDTO searchDTO) {
        return viewAllActive().stream().filter(x->searchDTO.getName()==null || searchDTO.getName()=="" || x.getItemDTO().getName().contains(searchDTO.getName()))
                .filter(x->searchDTO.getBrand()==null||searchDTO.getBrand()==""|| x.getItemDTO().getBrand().contains(searchDTO.getBrand()))
                .filter(x->searchDTO.getColor()==null||searchDTO.getColor()==""||x.getItemDTO().getColor().contains(searchDTO.getColor()))
                .filter(x->searchDTO.getDescription()==null||searchDTO.getDescription()==""||x.getItemDTO().getDescription().contains(searchDTO.getDescription()))
                .filter(x->searchDTO.getMobile()==null||searchDTO.getMobile()==""||x.getMobile().contains(searchDTO.getMobile()))
                .filter(x->searchDTO.getCategory()==null||searchDTO.getCategory()==""||x.getCategory().contains(searchDTO.getCategory()))
                .collect(Collectors.toList());
    }
}