package com.swing.swingfrontend.noadmin;

import com.swing.swingfrontend.bill.Bill;
import com.swing.swingfrontend.dto.AdressDTO;
import com.swing.swingfrontend.dto.OrderDTO;
import com.swing.swingfrontend.gateway.AdressGateway;
import com.swing.swingfrontend.gateway.OrderGateway;
import com.swing.swingfrontend.gateway.ShoppingBascketGateway;
import com.swing.swingfrontend.session.CurrentSession;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderController {

    private Order order;
    private AdressGateway adressGateway;
    private CurrentSession currentSession;
    private OrderGateway orderGateway;
    private OrderButtonListener orderButtonListener;
    private ShoppingBascketGateway shoppingBascketGateway;


    public OrderController(ShoppingBascketGateway shoppingBascketGateway,OrderGateway orderGateway,AdressGateway adressGateway,CurrentSession currentSession){
        order=new Order();
        this.adressGateway=adressGateway;
        this.currentSession=currentSession;
        this.orderGateway=orderGateway;
        orderButtonListener=new OrderButtonListener();
        this.shoppingBascketGateway=shoppingBascketGateway;
        order.getOrder().addActionListener(orderButtonListener);
    }

    public void setFrameVisible(boolean visible){
        order.getFrame().setVisible(visible);
    }

    private class OrderButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String cityName=order.getCityName().getText();
            String streetName=order.getStreetName().getText();
            int streetNumber=Integer.parseInt(order.getStreetNumber().getText());
            AdressDTO adressDTO=adressGateway.save(new AdressDTO(0,cityName,streetName,streetNumber));
            String customerName=order.getCustomerName().getText();
            String telephone=order.getTelephone().getText();
            OrderDTO orderDTO=new OrderDTO();
            orderDTO.setAdress(adressDTO);
            orderDTO.setCustomerName(customerName);
            orderDTO.setShoppingBascket(currentSession.getCurrentShoppingBascket().getId());
            orderDTO.setTelephoneNumber(telephone);
            OrderDTO finalOrder=orderGateway.save(orderDTO);
            if(finalOrder!=null) {

                JOptionPane.showMessageDialog(null, "Comanda in valoare de " +
                        orderGateway.save(orderDTO).getTotal() + " a fost procesata");
                Bill bill=new Bill();
                bill.writeFile(currentSession.getCurrentShoppingBascket(),finalOrder);
                currentSession.setCurrentShoppingBascket(shoppingBascketGateway.getActiveBascketForUser(currentSession.getCurrentUser()));
                shoppingBascketGateway.processShoppingBascket(currentSession.getCurrentShoppingBascket());
            }
        }
    }
}
