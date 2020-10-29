package com.swing.swingfrontend.gateway;

import com.swing.swingfrontend.dto.MobileDTO;
import com.swing.swingfrontend.dto.SearchDTO;

import java.util.List;

public interface MobileGateway {

    List<MobileDTO> viewAll();
    List<MobileDTO> viewAllActive();
    MobileDTO save(MobileDTO mobileDTO);
    List<MobileDTO> search(SearchDTO searchDTO);
}
