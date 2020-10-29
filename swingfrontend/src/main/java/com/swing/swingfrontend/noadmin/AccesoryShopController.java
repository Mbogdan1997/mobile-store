package com.swing.swingfrontend.noadmin;

import java.awt.event.*;
import java.util.List;

import com.swing.swingfrontend.dto.*;
import com.swing.swingfrontend.gateway.AccesoryGateway;
import com.swing.swingfrontend.gateway.ShoppingBascketItemGateway;
import com.swing.swingfrontend.service.DataConverter;
import com.swing.swingfrontend.session.CurrentSession;

import javax.swing.*;

public class AccesoryShopController {

    private AccesoryShop accesoryShop;
    private AccesoryGateway accesoryGateway;
    private  final String[] columns={"Id","Item Id","Name","Description","Price",
            "Quantity","Image","Brand","Color","Active","Category","Mobile"};
    private FrameListener frameListener;
    private DataConverter data;
    private ShoppingBascketItemGateway shoppingBascketItemGateway;
    private CurrentSession currentSession;
    private TableActionListener tableActionListener;
    private ButtonActionListener buttonActionListener;

    public AccesoryShopController(ShoppingBascketItemGateway shoppingBascketItemGateway,AccesoryGateway accesoryGateway, DataConverter dataConverter, CurrentSession currentSession){
        accesoryShop=new AccesoryShop();
        this.accesoryGateway=accesoryGateway;
        this.frameListener=new FrameListener();
        this.currentSession=currentSession;
        this.data=dataConverter;
        this.currentSession=currentSession;
        tableActionListener=new TableActionListener();
        buttonActionListener=new ButtonActionListener();
        this.shoppingBascketItemGateway=shoppingBascketItemGateway;
        addActionListener();
    }

    public void updateTable(List<MobileAccesoryDTO> mobileAccesoryDTOList){
        Object[][] mobileAccesory=data.getAccesoryData(mobileAccesoryDTOList);
        accesoryShop.refreshTable(mobileAccesory,columns);
    }

    private void addActionListener(){
        accesoryShop.getAddToCart().addActionListener(buttonActionListener);
        accesoryShop.getSearch().addActionListener(buttonActionListener);
        accesoryShop.getFrame().addWindowListener(frameListener);
        accesoryShop.getTable().addMouseListener(tableActionListener);
    }

    public void setFrameVisible(boolean visible){
        List<MobileAccesoryDTO> mobileAccesoryDTOS=accesoryGateway.viewAllActive();
        updateTable(mobileAccesoryDTOS);
        accesoryShop.getFrame().setVisible(visible);
    }

    private class FrameListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            accesoryShop.getFrame().setVisible(false);
        }
    }

    private class TableActionListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int x=accesoryShop.getTable().rowAtPoint(e.getPoint());
            String itemId= String.valueOf( accesoryShop.getTable().getValueAt(x,1));
            accesoryShop.setItemId(itemId);
            String image=String.valueOf(accesoryShop.getTable().getValueAt(x,6));
            ImageIcon imageIcon=new ImageIcon(image);
            accesoryShop.getImageIcon().setIcon(imageIcon);
        }
    }

    private class ButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==accesoryShop.getSearch()){
                String name=accesoryShop.getName().getText();
                String brand=accesoryShop.getBrand().getText();
                String color=accesoryShop.getColor().getText();
                String description=accesoryShop.getDescription().getText();
                String category=accesoryShop.getCategory().getText();
                String mobile=accesoryShop.getMobile().getText();
                AccesorySearchDTO searchDTO=new AccesorySearchDTO(category,mobile,name,brand,color,description);
                List<MobileAccesoryDTO> mobileDTOS=accesoryGateway.search(searchDTO);
                Object[][] mobileData=data.getAccesoryData(mobileDTOS);
                accesoryShop.resetSearch();
                accesoryShop.refreshTable(mobileData,columns);
            }
            else if(e.getSource()==accesoryShop.getAddToCart()){
                ShoppingBascketItemDTO shoppingBascketItemDTO=new ShoppingBascketItemDTO();
                ItemDTO itemDTO=new ItemDTO();
                itemDTO.setId(Integer.parseInt(accesoryShop.getItemId()));
                shoppingBascketItemDTO.setShoppingBascket(currentSession.getCurrentShoppingBascket());
                shoppingBascketItemDTO.setQuantity(Integer.parseInt(accesoryShop.getQuantity()));
                shoppingBascketItemDTO.setItem(itemDTO);
                shoppingBascketItemGateway.addToCart(shoppingBascketItemDTO);
                List<MobileAccesoryDTO> mobileAccesoryDTOS=accesoryGateway.viewAllActive();
                updateTable(mobileAccesoryDTOS);
            }
        }
    }






}
