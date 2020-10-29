package com.swing.swingfrontend.bill;

import com.swing.swingfrontend.dto.OrderDTO;
import com.swing.swingfrontend.dto.ShoppingBascketDTO;
import com.swing.swingfrontend.dto.ShoppingBascketItemDTO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Bill {

    private static int nr=0;
    private static final String bill="bill";
    private static final String suffix=".txt";
    private final String fileName=bill+nr+suffix;

    public Bill(){
        nr++;

    }

    public void writeFile(ShoppingBascketDTO shoppingBascketDTO, OrderDTO orderDTO){

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.append(' ');
            writer.append("Contact Details:"+"\n");
            writer.append("Customer Name:"+orderDTO.getCustomerName()+"\n");
            writer.append("Customer Number:"+orderDTO.getTelephoneNumber()+"\n");
            writer.append("Order details:"+"\n");
            for(ShoppingBascketItemDTO shoppingBascketDTO1:shoppingBascketDTO.getShoppingBascketItemDTOList()){
                writer.append(shoppingBascketDTO1.toString());
            }
            writer.append(String.valueOf(orderDTO.getTotal()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
