package com.swing.swingfrontend.noadmin;

import com.swing.swingfrontend.dto.ItemDTO;
import com.swing.swingfrontend.dto.MobileDTO;
import com.swing.swingfrontend.dto.SearchDTO;
import com.swing.swingfrontend.dto.ShoppingBascketItemDTO;
import com.swing.swingfrontend.gateway.MobileGateway;
import com.swing.swingfrontend.gateway.ShoppingBascketItemGateway;
import com.swing.swingfrontend.gateway.ShoppingBascketItemGatewayImpl;
import com.swing.swingfrontend.service.DataConverter;
import com.swing.swingfrontend.session.CurrentSession;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class MobileShopController {

    private MobileShop mobileShop;
    private MobileGateway mobileGateway;
    private FrameListener frameListener;
    private DataConverter dataConverter;
    private TableActionListener tableActionListener;
    private ButtonActionListener buttonActionListener;
    private ShoppingBascketItemGateway shoppingBascketItemGateway;
    private  CurrentSession currentSession;
    private  final String[] columns={"Id","Item Id","Name","Description","Price",
            "Quantity","Image","Brand","Color","Active"};

    public MobileShopController(CurrentSession currentSession,ShoppingBascketItemGateway shoppingBascketItemGateway, MobileGateway mobileGateway, DataConverter dataConverter){
        this.mobileShop=new MobileShop();
        this.mobileGateway=mobileGateway;
        this.dataConverter=dataConverter;
        frameListener=new FrameListener();
        buttonActionListener=new ButtonActionListener();
        tableActionListener=new TableActionListener();
        this.shoppingBascketItemGateway=shoppingBascketItemGateway;
        this.currentSession=currentSession;
        addActionListener();
    }

    private void addActionListener(){
        mobileShop.getFrame().addWindowListener(frameListener);
        mobileShop.getTable().addMouseListener(tableActionListener);
        mobileShop.getSearch().addActionListener(buttonActionListener);
        mobileShop.getAddToCart().addActionListener(buttonActionListener);
    }

    public void setFrameVisible(boolean visible){
        refreshTable();
        mobileShop.getFrame().setVisible(visible);
    }

    private void refreshTable(){
        List<MobileDTO> mobileDTOList=mobileGateway.viewAllActive();
        Object[][] mobileData=dataConverter.getMobileData(mobileDTOList);
        mobileShop.refreshTable(mobileData,columns);
    }

    private class FrameListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            mobileShop.getFrame().setVisible(false);
        }
    }

    private class TableActionListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int x=mobileShop.getTable().rowAtPoint(e.getPoint());
            String itemId= String.valueOf( mobileShop.getTable().getValueAt(x,1));
            mobileShop.setItemId(itemId);
            String image=String.valueOf(mobileShop.getTable().getValueAt(x,6));
            ImageIcon imageIcon=new ImageIcon(image);
            mobileShop.getImageIcon().setIcon(imageIcon);
        }
    }

    private class ButtonActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==mobileShop.getSearch()){
                String name=mobileShop.getName().getText();
                String brand=mobileShop.getBrand().getText();
                String color=mobileShop.getColor().getText();
                String description=mobileShop.getDescription().getText();
                SearchDTO searchDTO=new SearchDTO(name,brand,color,description);
                List<MobileDTO> mobileDTOS=mobileGateway.search(searchDTO);
                Object[][] mobileData=dataConverter.getMobileData(mobileDTOS);
                mobileShop.resetSearch();
                mobileShop.refreshTable(mobileData,columns);
            }
            else if(e.getSource()==mobileShop.getAddToCart()){
                ShoppingBascketItemDTO shoppingBascketItemDTO=new ShoppingBascketItemDTO();
                ItemDTO itemDTO=new ItemDTO();
                itemDTO.setId(Integer.parseInt(mobileShop.getItemId()));
                shoppingBascketItemDTO.setShoppingBascket(currentSession.getCurrentShoppingBascket());
                shoppingBascketItemDTO.setQuantity(Integer.parseInt(mobileShop.getQuantity()));
                shoppingBascketItemDTO.setItem(itemDTO);
                shoppingBascketItemGateway.addToCart(shoppingBascketItemDTO);
                refreshTable();
            }
        }
    }

}
