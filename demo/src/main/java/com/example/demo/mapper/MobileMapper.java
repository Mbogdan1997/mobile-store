package com.example.demo.mapper;

import com.example.demo.dto.MobileDTO;
import com.example.demo.entity.Item;
import com.example.demo.entity.Mobile;
import com.example.demo.repository.MobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class MobileMapper implements MobileMapperAbstr {

    private MobileRepository mobileRepository;
    private ItemMapperAbstr itemMapperAbstr;

    @Autowired
    public MobileMapper(MobileRepository mobileRepository,ItemMapperAbstr itemMapperAbstr){
        this.itemMapperAbstr=itemMapperAbstr;
        this.mobileRepository=mobileRepository;

    }

    @Override
    public MobileDTO toDTO(Mobile mobile) {
        return new MobileDTO(mobile);
    }

    @Override
    public Mobile toEntityUpdate(int mobileDTO) {
        return mobileRepository.findById(mobileDTO);
    }

    @Override
    public Mobile toEntity(MobileDTO mobileDTO) {
        Item item=itemMapperAbstr.toEntity(mobileDTO.getItemDTO());
        return new Mobile(mobileDTO.getId(),item);
    }

    @Override
    public List<MobileDTO> toDTOList(List<Mobile> mobileList) {
        List<MobileDTO> mobileDTOS=new ArrayList<>();

        for(Mobile mobile:mobileList){
            mobileDTOS.add(toDTO(mobile));
        }

        return mobileDTOS;
    }
}
