package com.swing.swingfrontend.noadmin;


import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;

public class User {

    private JFrame frame;
    private JMenuBar mb;
    private JMenu option;
    private JMenuItem accesory;
    private JMenuItem users;
    private JMenuItem mobile;


    public User() {
        initialize();
    }

    public JFrame getFrame() {
        return frame;
    }

    public JMenuBar getMb() {
        return mb;
    }

    public JMenuItem getAccesory() {
        return accesory;
    }

    public JMenuItem getUsers() {
        return users;
    }

    public JMenuItem getMobile() {
        return mobile;
    }



    public void addActionListenerForMenu(JMenuItem menu, ActionListener actionListener){
        menu.addActionListener(actionListener);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        mb=new JMenuBar();
        option=new JMenu("Option");
        users=new JMenuItem("Shopping Bascket");
        mobile =new JMenuItem("Mobile");
        accesory =new JMenuItem("Accesory");
        option.add(users);
        option.add(mobile);
        option.add(accesory);
        mb.add(option);

        frame = new JFrame();
        frame.setBounds(0, 0, 1800, 900);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("\t\t\t\t\t\t\t\t\tHello User!!!\r\n");
        lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 51));
        lblNewLabel.setBounds(10, 77, 610, 141);
        frame.getContentPane().add(lblNewLabel);
        frame.setJMenuBar(mb);
    }
}
