package com.swing.swingfrontend.dto;

import com.swing.swingfrontend.enumeration.Role;

public class UserDTO extends IdDTO{

    private String username;

    private String password;
    private Role role;

    public UserDTO(){

    }

    public UserDTO(int id, String username, String password, Role role) {
        super(id);
        this.username=username;
        this.password=password;
        this.role=role;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getStringRepresentationOfRole(){
        if(this.role==Role.USER){
            return "User";
        }
        else if(this.role==Role.ADMIN){
            return "Admin";

        }
        return null;
    }

    public static Role getRoleFromString(String role){
        if(role.equals("Admin")){
            return Role.ADMIN;
        }
        else if(role.equals("User")){
            return Role.USER;
        }
        return null;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + super.getId() +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
