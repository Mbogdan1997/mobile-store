package com.example.demo.mapper;

import com.example.demo.dto.MobileAccesoryDTO;
import com.example.demo.entity.MobileAccesory;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.MobileAccesoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class MobileAccesoryMapper implements MobileAccesoryMapperAbstr {

    private MobileAccesoryRepository mobileAccesoryRepository;
    private MobileMapperAbstr mobileMapperAbstr;

    public MobileAccesoryMapper(){

    }

    @Autowired
    public MobileAccesoryMapper(MobileAccesoryRepository mobileAccesoryRepository,MobileMapperAbstr mobileMapperAbstr){
        this.mobileAccesoryRepository=mobileAccesoryRepository;
        this.mobileMapperAbstr=mobileMapperAbstr;
    }
    @Override
    public MobileAccesoryDTO toDTO(MobileAccesory mobileAccesory) {
        return new MobileAccesoryDTO(mobileAccesory);
    }

    @Override
    public MobileAccesory toEntity(MobileAccesoryDTO mobileAccesoryDTO) {
        return new MobileAccesory(mobileAccesoryDTO);
    }

    @Override
    public MobileAccesory toEntityUpdate(int id) {
        return mobileAccesoryRepository.findById(id);
    }

    @Override
    public List<MobileAccesoryDTO> toDTOList(List<MobileAccesory> mobileAccesories) {
        List<MobileAccesoryDTO> mobileAccesoryDTOS=new ArrayList<>();

        for(MobileAccesory mobileAccesory:mobileAccesories){
            mobileAccesoryDTOS.add(new MobileAccesoryDTO(mobileAccesory));
        }
        return mobileAccesoryDTOS;
    }
}
