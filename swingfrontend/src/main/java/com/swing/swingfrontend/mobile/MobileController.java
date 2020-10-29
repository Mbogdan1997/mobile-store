package com.swing.swingfrontend.mobile;

import com.swing.swingfrontend.dto.ItemDTO;
import com.swing.swingfrontend.dto.MobileDTO;
import com.swing.swingfrontend.dto.UserDTO;
import com.swing.swingfrontend.gateway.ItemGateway;
import com.swing.swingfrontend.gateway.MobileGateway;
import com.swing.swingfrontend.service.DataConverter;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.util.List;

public class MobileController {

    private  MobileView mobileView;
    private DataConverter dataConverter;
    private MobileGateway mobileGateway;
    private ItemGateway itemGateway;

    private FrameListener frameListener;
    private TableActionListener tableActionListener;
    private ExecuteActionListener executeActionListener;
    private  final String[] columns={"Id","Item Id","Name","Description","Price",
    "Quantity","Image","Brand","Color","Active"};

    public MobileController(DataConverter dataConverter, MobileGateway mobileGateway, ItemGateway itemGateway){
        this.dataConverter=dataConverter;
        this.mobileGateway=mobileGateway;
        this.itemGateway=itemGateway;
        this.mobileView=new MobileView();
        frameListener=new FrameListener();
        tableActionListener=new TableActionListener();
        executeActionListener=new ExecuteActionListener();
        addActionListener();

    }

    private void addActionListener(){
        this.mobileView.getFrame().addWindowListener(frameListener);
        this.mobileView.getTable().addMouseListener(tableActionListener);
        this.mobileView.getExecute().addActionListener(executeActionListener);
        this.mobileView.getChooseImage().addActionListener(executeActionListener);
    }

    public void setFrameVisible(boolean visible){
        refreshTable();
        mobileView.getFrame().setVisible(visible);
    }

    private void refreshTable(){
        List<MobileDTO> mobileDTOList=mobileGateway.viewAll();
        Object[][] mobileData=dataConverter.getMobileData(mobileDTOList);
        mobileView.refreshTable(mobileData,columns);
    }

    private class ExecuteActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==mobileView.getExecute()) {
                MobileDTO mobileDTO = new MobileDTO();
                ItemDTO itemDTO = new ItemDTO();
                if (mobileView.getOperationBox().equals("Edit")) {
                    int id = Integer.parseInt(mobileView.getId());
                    mobileDTO.setId(id);
                    int itemId = Integer.parseInt(mobileView.getItemId());
                    itemDTO.setId(itemId);
                }
                createItem(itemDTO);
                ItemDTO mobileItemDto = itemGateway.saveItem(itemDTO);
                mobileDTO.setItemDTO(mobileItemDto);
                mobileGateway.save(mobileDTO);
                refreshTable();
            }
            else {
                JFileChooser fc=new JFileChooser();
                int i=fc.showOpenDialog(mobileView.getFrame());
                if(i==JFileChooser.APPROVE_OPTION){
                    File file=fc.getSelectedFile();
                    String newFilePath=file.getName();
                    File newFile=new File(newFilePath);
                    if(newFile.exists()){
                        newFile.delete();
                    }
                    mobileView.setImage(newFilePath);
                    file.renameTo(new File(newFilePath));
                    ImageIcon imageIcon=new ImageIcon(newFilePath);
                    mobileView.getImageIcon().setIcon(imageIcon);
                }

                }
        }
    }

    private void createItem(ItemDTO itemDTO){
       itemDTO.setName(mobileView.getName());
        itemDTO.setPrice(Float.parseFloat(mobileView.getPrice()));
        itemDTO.setQuantity(Integer.parseInt(mobileView.getQuantity()));
        itemDTO.setDescription(mobileView.getDescription());
        itemDTO.setBrand(mobileView.getBrand());
        itemDTO.setColor(mobileView.getColor());
        itemDTO.setImage(mobileView.getImage());
        itemDTO.setActiveAfterString(mobileView.getActiveBox());
    }



    private class FrameListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            mobileView.getFrame().setVisible(false);
        }
    }

    private class TableActionListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int x=mobileView.getTable().rowAtPoint(e.getPoint());;
            String id=String.valueOf(mobileView.getTable().getValueAt(x,0));
            String itemId=String.valueOf(mobileView.getTable().getValueAt(x,1));
            String name=String.valueOf(mobileView.getTable().getValueAt(x,2));
            String description=String.valueOf(mobileView.getTable().getValueAt(x,3));
            String price=String.valueOf(mobileView.getTable().getValueAt(x,4));
            String quantity=String.valueOf(mobileView.getTable().getValueAt(x,5));
            String image=String.valueOf(mobileView.getTable().getValueAt(x,6));
            String brand=String.valueOf(mobileView.getTable().getValueAt(x,7));
            String color=String.valueOf(mobileView.getTable().getValueAt(x,8));
            mobileView.setId(id);
            mobileView.setItemId(itemId);
            mobileView.setName(name);
            mobileView.setDescription(description);
            mobileView.setPrice(price);
            mobileView.setQuantity(quantity);
            mobileView.setBrand(brand);
            mobileView.setColor(color);
            mobileView.setImage(image);
            ImageIcon imageIcon=new ImageIcon(image);
            mobileView.getImageIcon().setIcon(imageIcon);
        }
    }
}
