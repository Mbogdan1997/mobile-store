package com.swing.swingfrontend.noadmin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ShoppingBascket {

    private JButton remove;
    private JButton order;
    private JFrame frame;
    private JTable table;
    private JTextField id;
   // private JLabel total;

    public JButton getRemove() {
        return remove;
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

    public JButton getOrder() {
        return order;
    }

    /* public JLabel getTotal() {
        return total;
    }*/

    public ShoppingBascket(){
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

        remove = new JButton("Remove from cart");
        remove.setBounds(383, 322, 162, 26);
        frame.getContentPane().add(remove);

        order = new JButton("Remove from cart");
        order.setBounds(383, 322, 210, 26);
        frame.getContentPane().add(order);

       /* total = new JLabel("Item Id:");
        total.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
        total.setBounds(200, 366, 79, 19);
        frame.getContentPane().add(total);
        */

        id.setEditable(false);
    }

    public void refreshTable(Object[][] data, String[] columnNames) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setDataVector(data, columnNames);
        tableModel.setColumnIdentifiers(columnNames);
        tableModel.fireTableDataChanged();
    }
}
