package com.swing.swingfrontend.user;

import com.swing.swingfrontend.dto.UserDTO;
import com.swing.swingfrontend.enumeration.Role;
import com.swing.swingfrontend.gateway.UserGateway;
import com.swing.swingfrontend.service.DataConverter;

import javax.xml.crypto.Data;
import java.awt.event.*;
import java.util.List;

public class UserViewController {

    private UserView userView;
    private UserGateway userGateway;
    private final String[] columns={"Id","Username","Password","Role"};
    private DataConverter dataConverter;
    private ExecuteActionListener executeActionListener;
    private TableActionListener tableActionListener;
    private FrameListener frameListener;

    public UserViewController(UserGateway userGateway, DataConverter dataConverter){
        this.userGateway=userGateway;
        this.userView=new UserView();
        this.dataConverter=dataConverter;
        executeActionListener=new ExecuteActionListener();
        this.tableActionListener=new TableActionListener();
        frameListener=new FrameListener();
        addActionListener();
    }

    private void addActionListener(){
        userView.getExecute().addActionListener(executeActionListener);
        userView.getTable().addMouseListener(tableActionListener);
        userView.getFrame().addWindowListener(frameListener);
    }

    public void setUserViewVisible(boolean visible){
        refreshUserTable();
        this.userView.getFrame().setVisible(visible);
    }

    public void refreshUserTable(){
        List<UserDTO> userDTOS=userGateway.viewAll();
        Object[][] userData=dataConverter.getUserData(userDTOS);
        userView.refreshTable(userData,columns);
    }

    private class ExecuteActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            UserDTO userDTO=new UserDTO();
            if(userView.getOperationBox().equals("Edit")){
                int id=Integer.parseInt(userView.getId());
                userDTO.setId(id);
            }
            createUser(userDTO);
            userGateway.save(userDTO);
            refreshUserTable();
        }
    }

    private void createUser(UserDTO userDTO){

        String username=userView.getUsername();
        String password=userView.getPassword();
        Role role=UserDTO.getRoleFromString(userView.getRoleBox());
        userDTO.setPassword(password);
        userDTO.setUsername(username);
        userDTO.setRole(role);

    }

    private class TableActionListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            int x=userView.getTable().rowAtPoint(e.getPoint());;
            String id=String.valueOf(userView.getTable().getValueAt(x,0));
            String username=String.valueOf(userView.getTable().getValueAt(x,1));
            String password=String.valueOf(userView.getTable().getValueAt(x,2));
            userView.setId(id);
            userView.setUsername(username);
            userView.setPassword(password);
        }
    }

    private class FrameListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            userView.getFrame().setVisible(false);
        }
    }
}
