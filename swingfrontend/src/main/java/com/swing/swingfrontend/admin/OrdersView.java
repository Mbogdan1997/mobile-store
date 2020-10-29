package com.swing.swingfrontend.admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class OrdersView {

    private JButton process;
    //private JButton order;
    private JFrame frame;
    private JTable table;
    private JTextField id;

    public JButton getProcess() {
        return process;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTable getTable() {
        return table;
    }

    public JTextField getId() {
        return id;
    }

    /*public JButton getOrder() {
        return order;
    }
    */

    /* public JLabel getTotal() {
        return total;
    }*/

    public OrdersView(){
        initialize();
    }

    private void initialize(){
        frame = new JFrame();
        frame.setBounds(0, 0, 1800, 900);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(195, 50, 949, 251);
        frame.getContentPane().add(scrollPane);



        table = new JTable();
        scrollPane.setViewportView(table);

        JLabel lblNewLabel = new JLabel("Id:");
        lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
        lblNewLabel.setBounds(200, 329, 48, 14);
        frame.getContentPane().add(lblNewLabel);

        id = new JTextField();
        id.setBounds(231, 322, 142, 26);
        frame.getContentPane().add(id);
        id.setColumns(10);

        process = new JButton("Process");
        process.setBounds(383, 322, 162, 26);
        frame.getContentPane().add(process);

        /*order = new JButton("Remove from cart");
        order.setBounds(383, 322, 210, 26);
        frame.getContentPane().add(order);
        */

       /* total = new JLabel("Item Id:");
        total.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
        total.setBounds(200, 366, 79, 19);
        frame.getContentPane().add(total);
        */

        id.setEditable(false);
        table.setEnabled(false);
    }

    public void refreshTable(Object[][] data, String[] columnNames) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setDataVector(data, columnNames);
        tableModel.setColumnIdentifiers(columnNames);
        tableModel.fireTableDataChanged();
    }
}
