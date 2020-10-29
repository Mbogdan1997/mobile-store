package com.swing.swingfrontend.gateway;

import com.swing.swingfrontend.dto.AccesorySearchDTO;
import com.swing.swingfrontend.dto.MobileAccesoryDTO;

import java.util.List;

public interface AccesoryGateway {

    List<MobileAccesoryDTO> viewAll();
    List<MobileAccesoryDTO> viewAllActive();
    MobileAccesoryDTO save(MobileAccesoryDTO mobileAccesoryDTO);
    List<MobileAccesoryDTO> search(AccesorySearchDTO accesorySearchDTO);
}
