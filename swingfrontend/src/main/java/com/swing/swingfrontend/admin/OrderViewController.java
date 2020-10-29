package com.swing.swingfrontend.admin;

import java.awt.event.*;
import java.util.List;
import com.swing.swingfrontend.dto.OrderDTO;
import com.swing.swingfrontend.gateway.OrderGateway;
import com.swing.swingfrontend.service.DataConverter;

import javax.swing.plaf.basic.BasicOptionPaneUI;
import javax.xml.crypto.Data;

public class OrderViewController {

    private OrdersView ordersView;
    private DataConverter dataConverter;
    private OrderGateway orderGateway;
    private String columns[]={"id","Customer Name","City","Total","Start Date"};
    private FrameListener frameListener;
    private TableActionListener tableActionListener;
    private ButtonActionListener buttonActionListener;
    public  OrderViewController(OrderGateway orderGateway,DataConverter dataConverter){
        ordersView=new OrdersView();
        this.dataConverter=dataConverter;
        this.orderGateway=orderGateway;
        frameListener=new FrameListener();
        tableActionListener=new TableActionListener();
        buttonActionListener=new ButtonActionListener();
        addActionListener();


    }

    private void addActionListener(){
        ordersView.getTable().addMouseListener(tableActionListener);
        ordersView.getFrame().addWindowListener(frameListener);
        ordersView.getProcess().addActionListener(buttonActionListener);

    }


    public void updateTable(){
        List<OrderDTO> orderDTOList=orderGateway.viewAllOrders();
        Object[][] data=dataConverter.getOrderData(orderDTOList);
        ordersView.refreshTable(data,columns);

    }

    public void setFrameVisible(boolean active){
        updateTable();
        ordersView.getFrame().setVisible(active);
    }

    private class FrameListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            ordersView.getFrame().setVisible(false);
        }
    }

    private class TableActionListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int x=ordersView.getTable().rowAtPoint(e.getPoint());;
            String id=String.valueOf(ordersView.getTable().getValueAt(x,0));
            ordersView.getId().setText(id);
        }
    }

    private class ButtonActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            OrderDTO orderDTO=new OrderDTO();
            orderDTO.setId(Integer.parseInt(ordersView.getId().getText()));
            orderGateway.process(orderDTO);
            updateTable();
        }
    }


}
