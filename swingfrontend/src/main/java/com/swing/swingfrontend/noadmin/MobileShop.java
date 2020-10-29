package com.swing.swingfrontend.noadmin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MobileShop {

    private JFrame frame;
    private JTable table;
    private JTextField itemId;
    private JTextField quantity;
    private JLabel imageIcon;
    private JButton addToCart;
    private JTextField name;
    private JTextField brand;
    private JTextField color;
    private JTextField description;
    private JButton search;

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public void setItemId(JTextField itemId) {
        this.itemId = itemId;
    }

    public void setQuantity(JTextField quantity) {
        this.quantity = quantity;
    }

    public void setImageIcon(JLabel imageIcon) {
        this.imageIcon = imageIcon;
    }

    public JButton getAddToCart() {
        return addToCart;
    }

    public void setAddToCart(JButton addToCart) {
        this.addToCart = addToCart;
    }

    public JTextField getName() {
        return name;
    }

    public void setName(JTextField name) {
        this.name = name;
    }

    public JTextField getBrand() {
        return brand;
    }

    public void setBrand(JTextField brand) {
        this.brand = brand;
    }

    public JTextField getColor() {
        return color;
    }

    public void setColor(JTextField color) {
        this.color = color;
    }

    public JTextField getDescription() {
        return description;
    }

    public void setDescription(JTextField description) {
        this.description = description;
    }

    public JButton getSearch() {
        return search;
    }

    public void setSearch(JButton search) {
        this.search = search;
    }

    public void resetSearch(){
        name.setText("");
        brand.setText("");
        color.setText("");
        description.setText("");
    }

    public JFrame getFrame() {
        return frame;
    }

    public JLabel getImageIcon() {
        return imageIcon;
    }

    public  JTable getTable(){
        return table;
    }


    public String getItemId() {
        return itemId.getText();
    }
    public String getQuantity() {
        return quantity.getText();
    }
    public void setItemId(String string) {
        itemId.setText(string);
    }
    public void setQuantity(String string) {
        quantity.setText(string);
    }

    public MobileShop(){
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

        JLabel lblNewLabel = new JLabel("Item Id:");
        lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
        lblNewLabel.setBounds(200, 329, 80, 14);
        frame.getContentPane().add(lblNewLabel);

        itemId = new JTextField();
        itemId.setBounds(290, 322, 142, 26);
        frame.getContentPane().add(itemId);
        itemId.setColumns(10);

        JLabel lblItemId = new JLabel("Quantity:");
        lblItemId.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
        lblItemId.setBounds(200, 366, 79, 19);
        frame.getContentPane().add(lblItemId);

        quantity = new JTextField();
        quantity.setColumns(10);
        quantity.setBounds(313, 359, 192, 26);
        frame.getContentPane().add(quantity);
        table.setEnabled(false);

        imageIcon = new JLabel("imageIcon");
        imageIcon.setBounds(977, 348, 370, 390);
        frame.getContentPane().add(imageIcon);

        addToCart = new JButton("Add to Cart");
        addToCart.setBounds(313, 400, 192, 38);
        itemId.setEditable(false);
        frame.getContentPane().add(addToCart);

        JLabel lblName_1 = new JLabel("Name:");
        lblName_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
        lblName_1.setBounds(565, 327, 79, 19);
        frame.getContentPane().add(lblName_1);

        name = new JTextField();
        name.setColumns(10);
        name.setBounds(640, 325, 192, 26);
        frame.getContentPane().add(name);

        JLabel lblBrand_1 = new JLabel("Brand:");
        lblBrand_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
        lblBrand_1.setBounds(565, 367, 79, 16);
        frame.getContentPane().add(lblBrand_1);

        brand = new JTextField();
        brand.setColumns(10);
        brand.setBounds(640, 364, 192, 26);
        frame.getContentPane().add(brand);

        color = new JTextField();
        color.setColumns(10);
        color.setBounds(640, 403, 192, 26);
        frame.getContentPane().add(color);

        JLabel lblColor_1 = new JLabel("Color:");
        lblColor_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
        lblColor_1.setBounds(574, 406, 56, 16);
        frame.getContentPane().add(lblColor_1);

        JLabel lblDescription_1 = new JLabel("Description:");
        lblDescription_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
        lblDescription_1.setBounds(530, 443, 100, 16);
        frame.getContentPane().add(lblDescription_1);

        description = new JTextField();
        description.setColumns(10);
        description.setBounds(640, 438, 192, 26);
        frame.getContentPane().add(description);

        search = new JButton("Search");
        search.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
        search.setBounds(640, 489, 192, 26);
        frame.getContentPane().add(search);



    }

    public void refreshTable(Object[][] data, String[] columnNames) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setDataVector(data, columnNames);
        tableModel.setColumnIdentifiers(columnNames);
        tableModel.fireTableDataChanged();
    }
}
