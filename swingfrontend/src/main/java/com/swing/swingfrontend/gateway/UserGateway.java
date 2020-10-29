package com.swing.swingfrontend.gateway;

import com.swing.swingfrontend.dto.UserDTO;

import java.util.List;

public interface UserGateway {

    UserDTO login(UserDTO userDTO);
    UserDTO signIn(UserDTO userDTO);
    UserDTO save(UserDTO userDTO);
    List<UserDTO> viewAll();
}