package com.swing.swingfrontend.noadmin;

import java.awt.event.*;
import java.util.List;
import com.swing.swingfrontend.dto.ShoppingBascketItemDTO;
import com.swing.swingfrontend.gateway.ShoppingBascketGateway;
import com.swing.swingfrontend.gateway.ShoppingBascketItemGateway;
import com.swing.swingfrontend.service.DataConverter;
import com.swing.swingfrontend.session.CurrentSession;

public class ShoppingBascketController {

    private DataConverter dataConverter;
    private CurrentSession currentSession;
    private ShoppingBascketItemGateway shoppingBascketItemGateway;
    private ShoppingBascket shoppingBascket;
    private String[] columns={"Id","Name","Quantity","Total"};
    private FrameListener frameListener;
    private ShoppingBascketGateway shoppingBascketGateway;
    private TableActionListener tableActionListener;
    private ButtonActionListener buttonActionListener;
    private OrderController orderController;

    public ShoppingBascketController(OrderController orderController,ShoppingBascketGateway shoppingBascketGateway,DataConverter dataConverter, CurrentSession currentSession, ShoppingBascketItemGateway shoppingBascketItemGateway){
        this.dataConverter=dataConverter;
        this.currentSession=currentSession;
        this.shoppingBascketItemGateway=shoppingBascketItemGateway;
        this.shoppingBascket=new ShoppingBascket();
        this.shoppingBascketGateway=shoppingBascketGateway;
        frameListener=new FrameListener();
        tableActionListener=new TableActionListener();
        buttonActionListener=new ButtonActionListener();
        this.orderController=orderController;
        addActionListener();
    }

    public void addActionListener(){
        shoppingBascket.getFrame().addWindowListener(frameListener);
        shoppingBascket.getTable().addMouseListener(tableActionListener);
        shoppingBascket.getRemove().addActionListener(buttonActionListener);
        shoppingBascket.getOrder().addActionListener(buttonActionListener);
    }

    public  void setFrameVisible(boolean visible){
        List<ShoppingBascketItemDTO> shoppingBascketItemDTOS=shoppingBascketGateway.getActiveBascketForUser(currentSession.getCurrentUser()).getShoppingBascketItemDTOList();
        updateTable();
        shoppingBascket.getFrame().setVisible(true);
    }

    private void updateTable(){
        List<ShoppingBascketItemDTO> shoppingBascketItemDTOS=shoppingBascketGateway.getActiveBascketForUser(currentSession.getCurrentUser()).getShoppingBascketItemDTOList();
        //shoppingBascket.getTotal().setText("Total: "+String.valueOf(currentSession.getCurrentShoppingBascket().getTotal()));
        Object[][] data=dataConverter.getShoppingBascketItemData(shoppingBascketItemDTOS);
        shoppingBascket.refreshTable(data,columns);

    }

    private class FrameListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            shoppingBascket.getFrame().setVisible(false);
        }
    }

    private class TableActionListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int x=shoppingBascket.getTable().rowAtPoint(e.getPoint());
            String itemId= String.valueOf( shoppingBascket.getTable().getValueAt(x,0));
            shoppingBascket.getId().setText(itemId);

        }
    }

    private class ButtonActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==shoppingBascket.getRemove()) {
                ShoppingBascketItemDTO shoppingBascketItemDTO = new ShoppingBascketItemDTO();
                shoppingBascketItemDTO.setId(Integer.parseInt(shoppingBascket.getId().getText()));
                shoppingBascketItemGateway.removeFromCart(shoppingBascketItemDTO);
                updateTable();
            }
            else{
                orderController.setFrameVisible(true);
            }
        }
    }
}
