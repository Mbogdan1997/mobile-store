package com.swing.swingfrontend.noadmin;

import javax.swing.*;
import java.awt.*;

public class AccesoryShop extends MobileShop {
    private JTextField category;
    private JTextField mobile;

    public JTextField getCategory() {
        return category;
    }

    public JTextField getMobile() {
        return mobile;
    }

    public AccesoryShop(){
        initialize();
    }

    private void initialize(){
        getFrame().remove(getSearch());
        getSearch().setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
        getSearch().setBounds(640, 539, 192, 26);
        getFrame().getContentPane().add(getSearch());

        JLabel lblCategory = new JLabel("Category:");
        lblCategory.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
        lblCategory.setBounds(544, 480, 100, 16);
        getFrame().getContentPane().add(lblCategory);

        category = new JTextField();
        category.setColumns(10);
        category.setBounds(640, 473, 192, 26);
        getFrame().getContentPane().add(category);

        mobile = new JTextField();
        mobile.setColumns(10);
        mobile.setBounds(640, 507, 192, 26);
        getFrame().getContentPane().add(mobile);

        JLabel lblMobile = new JLabel("Mobile:");
        lblMobile.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
        lblMobile.setBounds(565, 510, 71, 16);
        getFrame().getContentPane().add(lblMobile);
    }
}
