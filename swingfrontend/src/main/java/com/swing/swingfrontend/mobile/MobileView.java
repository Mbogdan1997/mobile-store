package com.swing.swingfrontend.mobile;

import javax.swing.*;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

public class MobileView {

    private JFrame frame;
    private JTable table;
    private JTextField id;
    private JTextField itemId;
    private JTextField name;
    private JTextField description;
    private JTextField price;
    private JTextField quantity;
    private JTextField brand;
    private JTextField color;
    private JTextField image;
    private JComboBox operationBox;
    private JButton chooseImage;
    private JComboBox activeBox;
    private JButton execute;
    private JLabel imageIcon;

    public JLabel getImageIcon() {
        return imageIcon;
    }

    public JTable getTable() {
        return table;
    }

    public String getId() {
        return id.getText();
    }

    public String getItemId() {
        return itemId.getText();
    }

    public String getName() {
        return name.getText();
    }

    public String getDescription() {
        return description.getText();
    }

    public String getPrice() {
        return price.getText();
    }

    public String getQuantity() {
        return quantity.getText();
    }

    public String getBrand() {
        return brand.getText();
    }

    public String getColor() {
        return color.getText();
    }

    public String getImage() {
        return image.getText();
    }

    public void setId(String string) {
        id.setText(string);
    }

    public void setItemId(String string) {
        itemId.setText(string);
    }

    public void setName(String string) {
        name.setText(string);
    }

    public void setDescription(String string) {
        description.setText(string);
    }

    public void setPrice(String string) {
        price.setText(string);
    }

    public void setQuantity(String string) {
        quantity.setText(string);
    }

    public void setBrand(String string) {
        brand.setText(string);
    }

    public void setColor(String string) {
        color.setText(string);
    }

    public void setImage(String string) {
        image.setText(string);
    }

    public String  getOperationBox() {
        return operationBox.getItemAt(operationBox.getSelectedIndex()).toString();
    }

    public JButton getChooseImage() {
        return chooseImage;
    }

    public String getActiveBox() {
        return activeBox.getItemAt(activeBox.getSelectedIndex()).toString();
    }

    public JButton getExecute() {
        return execute;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public MobileView() {
        initialize();
    }


    private void initialize() {

         JLabel lblPrice;
        JLabel lblQuantity;
        JLabel lblBrand;
         JLabel lblColor;
        JLabel lblActive;
        JLabel lblItemId;
        JLabel lblName;
        JLabel lblDescription;
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

        lblItemId = new JLabel("Item Id:");
        lblItemId.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
        lblItemId.setBounds(200, 366, 79, 19);
        frame.getContentPane().add(lblItemId);

        itemId = new JTextField();
        itemId.setColumns(10);
        itemId.setBounds(313, 359, 192, 26);
        frame.getContentPane().add(itemId);

        lblName = new JLabel("Name:");
        lblName.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
        lblName.setBounds(200, 406, 79, 16);
        frame.getContentPane().add(lblName);

        name = new JTextField();
        name.setColumns(10);
        name.setBounds(313, 396, 192, 26);
        frame.getContentPane().add(name);

        description = new JTextField();
        description.setColumns(10);
        description.setBounds(313, 433, 192, 26);
        frame.getContentPane().add(description);

        price = new JTextField();
        price.setColumns(10);
        price.setBounds(313, 470, 192, 26);
        frame.getContentPane().add(price);

        lblDescription = new JLabel("Description:");
        lblDescription.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
        lblDescription.setBounds(200, 439, 103, 20);
        frame.getContentPane().add(lblDescription);

        quantity = new JTextField();
        quantity.setColumns(10);
        quantity.setBounds(313, 507, 192, 26);
        frame.getContentPane().add(quantity);

        brand = new JTextField();
        brand.setColumns(10);
        brand.setBounds(313, 544, 192, 26);
        frame.getContentPane().add(brand);

        color = new JTextField();
        color.setColumns(10);
        color.setBounds(313, 584, 192, 26);
        frame.getContentPane().add(color);

        lblPrice = new JLabel("Price:");
        lblPrice.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
        lblPrice.setBounds(200, 476, 103, 20);
        frame.getContentPane().add(lblPrice);

        lblQuantity = new JLabel("Quantity:");
        lblQuantity.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
        lblQuantity.setBounds(200, 508, 103, 20);
        frame.getContentPane().add(lblQuantity);

        lblBrand = new JLabel("Brand:");
        lblBrand.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
        lblBrand.setBounds(200, 545, 103, 20);
        frame.getContentPane().add(lblBrand);

        lblColor = new JLabel("Color:");
        lblColor.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
        lblColor.setBounds(200, 585, 103, 20);
        frame.getContentPane().add(lblColor);

        lblActive = new JLabel("Active:");
        lblActive.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
        lblActive.setBounds(200, 623, 103, 20);
        frame.getContentPane().add(lblActive);

        String active[]={"Active","Inactive"};
        activeBox = new JComboBox(active);
        activeBox.setBounds(313, 621, 192, 26);
        frame.getContentPane().add(activeBox);

        JLabel lblOperation = new JLabel("Operation:");
        lblOperation.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
        lblOperation.setBounds(200, 662, 103, 20);
        frame.getContentPane().add(lblOperation);

        String[] operation={"Add","Edit"};
        operationBox = new JComboBox(operation);
        operationBox.setBounds(313, 663, 192, 26);
        frame.getContentPane().add(operationBox);

        execute = new JButton("Executa");
        execute.setBounds(313, 700, 192, 38);
        frame.getContentPane().add(execute);

        JLabel lblImage = new JLabel("Image:");
        lblImage.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
        lblImage.setBounds(613, 331, 79, 19);
        frame.getContentPane().add(lblImage);

        chooseImage = new JButton("Choose Image");
        chooseImage.setBounds(678, 327, 177, 23);
        frame.getContentPane().add(chooseImage);

        JLabel lblImageName = new JLabel("Image Name:");
        lblImageName.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
        lblImageName.setBounds(613, 370, 103, 19);
        frame.getContentPane().add(lblImageName);

        image = new JTextField();
        image.setColumns(10);
        image.setBounds(714, 367, 192, 26);
        frame.getContentPane().add(image);

        table.setEnabled(false);
        id.setEditable(false);
        itemId.setEditable(false);

        imageIcon = new JLabel("imageIcon");
        imageIcon.setBounds(977, 348, 370, 390);
        frame.getContentPane().add(imageIcon);
    }

    public void refreshTable(Object[][] data, String[] columnNames) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setDataVector(data, columnNames);
        tableModel.setColumnIdentifiers(columnNames);
        tableModel.fireTableDataChanged();
    }
}