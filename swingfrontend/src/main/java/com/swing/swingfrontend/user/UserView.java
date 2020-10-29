package com.swing.swingfrontend.user;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class UserView {

    private JFrame frame;
    private JTable table;
    private JTextField id;
    private JTextField username;
    private JTextField password;
    private JComboBox operationBox;
    private JComboBox roleBox;
    private JButton execute;

    public JButton getExecute() {
        return execute;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTable getTable() {
        return table;
    }

    public String getId() {
        return id.getText();
    }

    public String getUsername() {
        return username.getText();
    }

    public String getPassword() {
        return password.getText();
    }

    public void setId(String id) {
         this.id.setText(id);
    }

    public void setUsername(String username) {
        this.username.setText(username);
    }

    public void setPassword(String password) {
        this.password.setText(password);
    }

    public String getOperationBox() {
        return operationBox.getItemAt(operationBox.getSelectedIndex()).toString();
    }

    public String getRoleBox() {
        return roleBox.getItemAt(roleBox.getSelectedIndex()).toString();
    }

    public void refreshTable(Object[][] data, String[] columnNames) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setDataVector(data, columnNames);
        tableModel.setColumnIdentifiers(columnNames);
        tableModel.fireTableDataChanged();
    }

    /**
     * Launch the application.
     */


    /**
     * Create the application.
     */
    public UserView() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(0, 0, 1800, 900);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(291, 56, 816, 138);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JLabel lblNewLabel = new JLabel("Id:");
        lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblNewLabel.setBounds(366, 235, 35, 14);
        frame.getContentPane().add(lblNewLabel);

        id = new JTextField();
        id.setBounds(461, 234, 47, 20);
        frame.getContentPane().add(id);
        id.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Username:");
        lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblNewLabel_1.setBounds(366, 267, 86, 14);
        frame.getContentPane().add(lblNewLabel_1);

        username = new JTextField();
        username.setBounds(461, 266, 149, 20);
        frame.getContentPane().add(username);
        username.setColumns(10);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblPassword.setBounds(366, 298, 86, 14);
        frame.getContentPane().add(lblPassword);

        password = new JTextField();
        password.setColumns(10);
        password.setBounds(461, 297, 149, 20);
        frame.getContentPane().add(password);

        JLabel lblRole = new JLabel("Role:");
        lblRole.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblRole.setBounds(366, 335, 86, 14);
        frame.getContentPane().add(lblRole);

        String[] role={"User","Admin"};
        roleBox = new JComboBox(role);
        roleBox.setBounds(461, 334, 149, 20);
        frame.getContentPane().add(roleBox);

        execute = new JButton("Execute");
        execute.setBounds(461, 396, 149, 30);
        frame.getContentPane().add(execute);


        String[] operation={"Edit","Add"};
        operationBox = new JComboBox(operation);
        operationBox.setBounds(461, 365, 149, 20);
        frame.getContentPane().add(operationBox);

        JLabel lblOperation = new JLabel("Operation:");
        lblOperation.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblOperation.setBounds(364, 363, 72, 20);
        frame.getContentPane().add(lblOperation);
        table.setEnabled(false);
        id.setEditable(false);
    }

}
