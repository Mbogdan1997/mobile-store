package com.example.demo.dto;

import com.example.demo.entity.User;
import com.example.demo.enumeration.Role;
import org.hibernate.validator.constraints.Length;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class UserDTO extends IdDTO{

    @Length(min = 7,message = "Username-ul trebuie sa aibe minim 7 caractere")
    private String username;
    @Length(min = 7,message = "Parola trebuie sa aibe minim 7 caractere")
    private String password;
    private Role role;

    public UserDTO(){

    }

    public UserDTO(User user) {
        super(user.getId());
        this.username=user.getUsername();
        this.password=user.getPassword();
        this.role=user.getRole();
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
