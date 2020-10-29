package com.swing.swingfrontend.gateway;

import com.swing.swingfrontend.dto.ItemDTO;

public interface ItemGateway {

    ItemDTO saveItem(ItemDTO itemDTO);
}
