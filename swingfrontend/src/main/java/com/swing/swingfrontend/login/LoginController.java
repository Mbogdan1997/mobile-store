package com.swing.swingfrontend.login;

import com.swing.swingfrontend.admin.AdminController;
import com.swing.swingfrontend.dto.ShoppingBascketDTO;
import com.swing.swingfrontend.dto.UserDTO;
import com.swing.swingfrontend.enumeration.Role;
import com.swing.swingfrontend.gateway.ShoppingBascketGateway;
import com.swing.swingfrontend.gateway.UserGateway;
import com.swing.swingfrontend.noadmin.UserController;
import com.swing.swingfrontend.session.CurrentSession;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {

    private Login login;
    private LoginButtonController loginButtonController;
    private CurrentSession currentSession;
    private UserGateway userGateway;
    private SignInButtonController signInButtonController;
    private AdminController adminController;
    private UserController userController;
    private ShoppingBascketGateway shoppingBascketGateway;

    public  LoginController(ShoppingBascketGateway shoppingBascketGateway,UserController userController,CurrentSession currentSession, UserGateway userGateway, AdminController adminController){
        initViews();
        initControllers();
        this.currentSession=currentSession;
        this.userGateway=userGateway;
        this.adminController=adminController;
        this.userController=userController;
        this.shoppingBascketGateway=shoppingBascketGateway;
        addActionListener();

    }

    private void initControllers(){

        loginButtonController=new LoginButtonController();
        signInButtonController=new SignInButtonController();
    }

    private void initViews(){
        login=new Login();
    }

    private void addActionListener(){
        //System.out.println("Action listener");
        login.addActionListenerOnLogin(loginButtonController);
        login.addActionListenerForSignIn(signInButtonController);

    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    private class LoginButtonController implements ActionListener{

        public void actionPerformed(ActionEvent e) {


            UserDTO userDTO=new UserDTO();
            userDTO.setRole(Role.USER);
            userDTO.setUsername(login.getUsername());
            userDTO.setPassword(login.getPassword());
            UserDTO currentUser=userGateway.login(userDTO);
            if(currentUser==null){
                JOptionPane.showMessageDialog(null,"Verificati numele si parola");
            }
            else{
                ShoppingBascketDTO shoppingBascketDTO=shoppingBascketGateway.getActiveBascketForUser(currentUser);
                    if(currentUser.getRole()==Role.ADMIN){
                        adminController.setAdminVisible(true);
                    }
                    else if(currentUser.getRole()==Role.USER){
                        userController.setAdminVisible(true);
                    }
                currentSession.setCurrentShoppingBascket(shoppingBascketDTO);
                currentSession.setCurrentUser(currentUser);
                }

            }

        }


    private class SignInButtonController implements ActionListener{

        public void actionPerformed(ActionEvent e) {


            UserDTO userDTO=new UserDTO();
            userDTO.setRole(Role.USER);
            userDTO.setUsername(login.getUsername());
            userDTO.setPassword(login.getPassword());
            UserDTO currentUser=userGateway.signIn(userDTO);
            if(currentUser==null){
                JOptionPane.showMessageDialog(null,"Verificati numele si parola");
            }


        }
    }
}
