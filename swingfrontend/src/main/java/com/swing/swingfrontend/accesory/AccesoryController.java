package com.swing.swingfrontend.accesory;

import java.awt.event.*;
import java.io.File;
import java.util.List;

import com.swing.swingfrontend.dto.ItemDTO;
import com.swing.swingfrontend.dto.MobileAccesoryDTO;
import com.swing.swingfrontend.gateway.AccesoryGateway;
import com.swing.swingfrontend.gateway.ItemGateway;
import com.swing.swingfrontend.service.DataConverter;

import javax.swing.*;

public class AccesoryController {
    private AccesoryView accesoryView;

    private DataConverter dataConverter;
    private AccesoryGateway accesoryGateway;
    private  final String[] columns={"Id","Item Id","Name","Description","Price",
            "Quantity","Image","Brand","Color","Active","Category","Mobile"};
    private TableActionListener tableActionListener;
    private ItemGateway itemGateway;
    private FrameListener frameListener;
    private ExecuteActionListener executeActionListener;

    public AccesoryController(ItemGateway itemGateway,DataConverter dataConverter, AccesoryGateway accesoryGateway){
        tableActionListener=new TableActionListener();
        this.dataConverter=dataConverter;
        this.accesoryGateway=accesoryGateway;
        this.accesoryView=new AccesoryView();
        this.itemGateway=itemGateway;

        tableActionListener=new TableActionListener();
        this.frameListener=new FrameListener();
        this.executeActionListener=new ExecuteActionListener();

        addActionListener();

    }

    private void addActionListener(){
        accesoryView.getTable().addMouseListener(tableActionListener);
        accesoryView.getFrame().addWindowListener(frameListener);
        accesoryView.getExecute().addActionListener(executeActionListener);
        accesoryView.getChooseImage().addActionListener(executeActionListener);

    }

    public void setFrameVisible(boolean active){
        updateTable();
        accesoryView.getFrame().setVisible(active);
    }

    private void updateTable(){
        List<MobileAccesoryDTO> mobileAccesoryDTOList=accesoryGateway.viewAll();
        Object[][] accesoryData=dataConverter.getAccesoryData(mobileAccesoryDTOList);
        accesoryView.refreshTable(accesoryData,columns);
    }

    private class ExecuteActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==accesoryView.getExecute()) {
                MobileAccesoryDTO mobileDTO = new MobileAccesoryDTO();
                ItemDTO itemDTO = new ItemDTO();
                if (accesoryView.getOperationBox().equals("Edit")) {
                    int id = Integer.parseInt(accesoryView.getId());
                    mobileDTO.setId(id);
                    int itemId = Integer.parseInt(accesoryView.getItemId());
                    itemDTO.setId(itemId);
                }
                createItem(itemDTO);
                ItemDTO mobileItemDto = itemGateway.saveItem(itemDTO);
                String category=accesoryView.getCategory();
                String mobile=accesoryView.getMobile();
                mobileDTO.setCategory(category);
                mobileDTO.setMobile(mobile);
                mobileDTO.setItemDTO(mobileItemDto);
                accesoryGateway.save(mobileDTO);
                updateTable();
            }
            else {
                JFileChooser fc=new JFileChooser();
                int i=fc.showOpenDialog(accesoryView.getFrame());
                if(i==JFileChooser.APPROVE_OPTION){
                    File file=fc.getSelectedFile();
                    String newFilePath=file.getName();
                    File newFile=new File(newFilePath);
                    if(newFile.exists()){
                        newFile.delete();
                    }
                    accesoryView.setImage(newFilePath);
                    file.renameTo(new File(newFilePath));
                    ImageIcon imageIcon=new ImageIcon(newFilePath);
                    accesoryView.getImageIcon().setIcon(imageIcon);
                }

            }
        }
    }

    private void createItem(ItemDTO itemDTO){
        itemDTO.setName(accesoryView.getName());
        itemDTO.setPrice(Float.parseFloat(accesoryView.getPrice()));
        itemDTO.setQuantity(Integer.parseInt(accesoryView.getQuantity()));
        itemDTO.setDescription(accesoryView.getDescription());
        itemDTO.setBrand(accesoryView.getBrand());
        itemDTO.setColor(accesoryView.getColor());
        itemDTO.setImage(accesoryView.getImage());
        itemDTO.setActiveAfterString(accesoryView.getActiveBox());
    }



    private class FrameListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            accesoryView.getFrame().setVisible(false);
        }
    }


    private class TableActionListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int x=accesoryView.getTable().rowAtPoint(e.getPoint());;
            String id=String.valueOf(accesoryView.getTable().getValueAt(x,0));
            String itemId=String.valueOf(accesoryView.getTable().getValueAt(x,1));
            String name=String.valueOf(accesoryView.getTable().getValueAt(x,2));
            String description=String.valueOf(accesoryView.getTable().getValueAt(x,3));
            String price=String.valueOf(accesoryView.getTable().getValueAt(x,4));
            String quantity=String.valueOf(accesoryView.getTable().getValueAt(x,5));
            String image=String.valueOf(accesoryView.getTable().getValueAt(x,6));
            String brand=String.valueOf(accesoryView.getTable().getValueAt(x,7));
            String color=String.valueOf(accesoryView.getTable().getValueAt(x,8));
            String category=String.valueOf(accesoryView.getTable().getValueAt(x,10));
            String mobile=String.valueOf(accesoryView.getTable().getValueAt(x,11));
            accesoryView.setId(id);
            accesoryView.setItemId(itemId);
            accesoryView.setName(name);
            accesoryView.setDescription(description);
            accesoryView.setPrice(price);
            accesoryView.setQuantity(quantity);
            accesoryView.setBrand(brand);
            accesoryView.setColor(color);
            accesoryView.setImage(image);
            accesoryView.setMobile(mobile);
            accesoryView.setCategory(category);
            ImageIcon imageIcon=new ImageIcon(image);
            accesoryView.getImageIcon().setIcon(imageIcon);
        }
    }
}
