package com.swing.swingfrontend.noadmin;

import javax.swing.*;

public class Order {

    private JFrame frame;
    private JTextField cityName;
    private JTextField streetName;
    private JTextField streetNumber;
    private JTextField customerName;
    private JTextField telephone;
    private JButton order;

    public JFrame getFrame() {
        return frame;
    }

    public JTextField getCityName() {
        return cityName;
    }

    public JTextField getStreetName() {
        return streetName;
    }

    public JTextField getStreetNumber() {
        return streetNumber;
    }

    public JTextField getCustomerName() {
        return customerName;
    }

    public JTextField getTelephone() {
        return telephone;
    }

    public JButton getOrder() {
        return order;
    }

    /**
     * Launch the application.
     */


    /**
     * Create the application.
     */
    public Order() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 360, 397);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("City Name:");
        lblNewLabel.setBounds(27, 27, 70, 14);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Street Name:");
        lblNewLabel_1.setBounds(17, 73, 80, 14);
        frame.getContentPane().add(lblNewLabel_1);

        cityName = new JTextField();
        cityName.setBounds(107, 21, 190, 26);
        frame.getContentPane().add(cityName);
        cityName.setColumns(10);

        streetName = new JTextField();
        streetName.setColumns(10);
        streetName.setBounds(108, 67, 190, 26);
        frame.getContentPane().add(streetName);

        JLabel lblNewLabel_2 = new JLabel("Street Number:");
        lblNewLabel_2.setBounds(17, 124, 80, 14);
        frame.getContentPane().add(lblNewLabel_2);

        streetNumber = new JTextField();
        streetNumber.setColumns(10);
        streetNumber.setBounds(108, 118, 190, 26);
        frame.getContentPane().add(streetNumber);

        JLabel lblCustomerName = new JLabel("Customer Name:");
        lblCustomerName.setBounds(17, 175, 91, 14);
        frame.getContentPane().add(lblCustomerName);

        customerName = new JTextField();
        customerName.setColumns(10);
        customerName.setBounds(107, 169, 190, 26);
        frame.getContentPane().add(customerName);

        JLabel lblTelephoneNr = new JLabel("Telephone Nr:");
        lblTelephoneNr.setBounds(17, 218, 91, 14);
        frame.getContentPane().add(lblTelephoneNr);

        telephone = new JTextField();
        telephone.setColumns(10);
        telephone.setBounds(107, 215, 190, 26);
        frame.getContentPane().add(telephone);

         order = new JButton("Order");
        order.setBounds(110, 303, 187, 23);
        frame.getContentPane().add(order);
    }

}
