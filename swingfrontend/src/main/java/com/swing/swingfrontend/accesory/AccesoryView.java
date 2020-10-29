package com.swing.swingfrontend.accesory;

import com.swing.swingfrontend.mobile.MobileView;

import javax.swing.*;
import java.awt.*;

public class AccesoryView extends MobileView {

    private JTextField category;
    private JTextField mobile;
    public AccesoryView(){

        initialize();
    }

    public String getCategory() {
        return category.getText();
    }

    public void setCategory(String category) {
        this.category.setText(category);
    }

    public String getMobile() {
        return mobile.getText();
    }

    public void setMobile(String mobile) {
        this.mobile.setText(mobile);
    }

    private void initialize(){
        JLabel lblCategory = new JLabel("Category:");
        lblCategory.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
        lblCategory.setBounds(613, 409, 103, 19);
        this.getFrame().getContentPane().add(lblCategory);

        category = new JTextField();
        category.setColumns(10);
        category.setBounds(714, 406, 192, 26);
        this.getFrame().add(category);

        JLabel lblMobile = new JLabel("Mobile:");
        lblMobile.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
        lblMobile.setBounds(613, 444, 103, 19);
        this.getFrame().getContentPane().add(lblMobile);

        mobile = new JTextField();
        mobile.setColumns(10);
        mobile.setBounds(714, 445, 192, 26);
        this.getFrame().getContentPane().add(mobile);
    }
}
