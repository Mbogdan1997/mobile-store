package com.example.demo.entity;

import com.example.demo.dto.UserDTO;
import com.example.demo.enumeration.Role;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private Role role;
    //@OneToOne(mappedBy = "user")
    //private ShoppingBascket shoppingBascket;


    public User (){

    }

    public User(UserDTO userDTO){
        this.id=userDTO.getId();
        this.username=userDTO.getUsername();
        this.password=userDTO.getPassword();
        if(userDTO.getRole()==null)
        this.role=Role.USER;
        else{
            this.role=userDTO.getRole();
        }
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setId(int id) {
        this.id=id;
    }

    /*public ShoppingBascket getShoppingBascket() {
        return shoppingBascket;
    }

    public void setShoppingBascket(ShoppingBascket shoppingBascket) {
        this.shoppingBascket = shoppingBascket;
    }
    */

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
