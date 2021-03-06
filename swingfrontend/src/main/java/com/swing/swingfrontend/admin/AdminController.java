package com.swing.swingfrontend.admin;

import com.swing.swingfrontend.accesory.AccesoryController;
import com.swing.swingfrontend.mobile.MobileController;
import com.swing.swingfrontend.user.UserViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdminController {

    private final Admin admin;
    private UserViewController userViewController;
    private JMenuController jMenuController;
    private FrameListener frameListener;
    private MobileController mobileController;
    private AccesoryController accesoryController;
    private OrderViewController orderViewController;

    public AdminController(OrderViewController orderViewController,UserViewController userViewController, MobileController mobileController, AccesoryController accesoryController){
        admin=new Admin();
        jMenuController=new JMenuController();
        this.frameListener=new FrameListener();
        this.userViewController=userViewController;
        this.mobileController=mobileController;
        this.accesoryController=accesoryController;
        this.orderViewController=orderViewController;
        addActionListener();
    }

    public void setAdminVisible(boolean visible){
        this.admin.getFrame().setVisible(visible);
    }



    private void addActionListener(){
        this.admin.addActionListenerForMenu(admin.getAccesory(),jMenuController);
        this.admin.addActionListenerForMenu(admin.getMobile(),jMenuController);
        this.admin.addActionListenerForMenu(admin.getUsers(),jMenuController);
        this.admin.addActionListenerForMenu(admin.getOrders(),jMenuController);
        this.admin.getFrame().addWindowListener(frameListener);
    }

    private class JMenuController implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==admin.getAccesory()){
                accesoryController.setFrameVisible(true);
            }
            if(e.getSource()==admin.getUsers()){
                userViewController.setUserViewVisible(true);
            }
            if(e.getSource()==admin.getMobile()){
                mobileController.setFrameVisible(true);
            }
            if(e.getSource()==admin.getOrders()){
                orderViewController.setFrameVisible(true);
            }
        }
    }

    private class FrameListener extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e) {
            admin.getFrame().setVisible(false);
        }
    }


}
