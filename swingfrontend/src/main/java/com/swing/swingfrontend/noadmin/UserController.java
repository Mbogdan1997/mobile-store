package com.swing.swingfrontend.noadmin;

import com.swing.swingfrontend.accesory.AccesoryController;
import com.swing.swingfrontend.mobile.MobileController;
import com.swing.swingfrontend.user.UserViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UserController {

    private final User admin;
    private ShoppingBascketController shoppingBascketController;
    private JMenuController jMenuController;
    private FrameListener frameListener;
    private MobileShopController mobileController;
    private AccesoryShopController accesoryController;


    public UserController(ShoppingBascketController shoppingBascketController, MobileShopController mobileController, AccesoryShopController accesoryController){
        admin=new User();
        jMenuController=new JMenuController();
        this.frameListener=new FrameListener();
        this.shoppingBascketController= shoppingBascketController;
        this.mobileController=mobileController;
        this.accesoryController=accesoryController;
        addActionListener();
    }

    public void setAdminVisible(boolean visible){
        this.admin.getFrame().setVisible(visible);
    }



    private void addActionListener(){
        this.admin.addActionListenerForMenu(admin.getAccesory(),jMenuController);
        this.admin.addActionListenerForMenu(admin.getMobile(),jMenuController);
        this.admin.addActionListenerForMenu(admin.getUsers(),jMenuController);
        //this.admin.addActionListenerForMenu(admin.getOrders(),jMenuController);
        this.admin.getFrame().addWindowListener(frameListener);
    }

    private class JMenuController implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==admin.getAccesory()){
                accesoryController.setFrameVisible(true);
            }
            if(e.getSource()==admin.getUsers()){
                shoppingBascketController.setFrameVisible(true);
            }
            if(e.getSource()==admin.getMobile()){
                mobileController.setFrameVisible(true);
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
