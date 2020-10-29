package com.example.demo.service;

import com.example.demo.dto.IdDTO;
import com.example.demo.dto.MobileDTO;
import com.example.demo.dto.SearchDTO;
import com.example.demo.entity.Item;
import com.example.demo.entity.Mobile;
import com.example.demo.mapper.MobileMapperAbstr;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.MobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MobileServiceImpl implements MobileService {

    private MobileRepository mobileRepository;
    private MobileMapperAbstr mobileMapperAbstr;
    private ItemRepository itemRepository;

    public MobileServiceImpl(){

    }

    @Autowired
    public MobileServiceImpl(ItemRepository itemRepository,MobileMapperAbstr mobileMapperAbstr,MobileRepository mobileRepository){
        this.mobileRepository=mobileRepository;
        this.mobileMapperAbstr=mobileMapperAbstr;
        this.itemRepository=itemRepository;
    }
    @Override
    public List<MobileDTO> viewAll() {
        return mobileMapperAbstr.toDTOList(mobileRepository.findAll());
    }

    @Override
    public MobileDTO save(MobileDTO mobileDTO) {
        //if(!bindingResult.hasErrors()){
            if(mobileRepository==null) {
                System.out.println("E null " +mobileDTO.getId());
            }

            Mobile mobile=mobileRepository.findById(mobileDTO.getId());
            Item item=itemRepository.findById(mobileDTO.getItemDTO().getId());
            if(mobile==null){
                mobile=new Mobile();
                mobile.setItem(item);
                mobileRepository.save(mobile);
            }
            else{
                mobile.setItem(item);
                //mobile.getItem().update(mobileDTO.getItemDTO());
                mobileRepository.save(mobile);
            }
            return mobileMapperAbstr.toDTO(mobile);
        //}
        //return null;
    }

    @Override
    public List<MobileDTO> viewAllActive() {
        return viewAll().stream().filter(mobileDTO -> mobileDTO.getItemDTO().isActive()).collect(Collectors.toList());
    }

    @Override
    public void remove(IdDTO mobileDTO) {
        Mobile mobile=mobileMapperAbstr.toEntityUpdate(mobileDTO.getId());
        mobile.getItem().setActive(false);
        mobileRepository.save(mobile);

    }

    @Override
    public List<MobileDTO> searchMobile(SearchDTO searchDTO) {
        return viewAllActive().stream()
                .filter(x->searchDTO.getName()==null || searchDTO.getName()=="" || x.getItemDTO().getName().contains(searchDTO.getName()))
                .filter(x->searchDTO.getBrand()==null||searchDTO.getBrand()==""|| x.getItemDTO().getBrand().contains(searchDTO.getBrand()))
                .filter(x->searchDTO.getColor()==null||searchDTO.getColor()==""||x.getItemDTO().getColor().contains(searchDTO.getColor()))
                .filter(x->searchDTO.getDescription()==null||searchDTO.getDescription()==""||x.getItemDTO().getDescription().contains(searchDTO.getDescription()))
                .collect(Collectors.toList());
    }
}
