package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface UserService {

    String testSpring();

    UserDTO save(UserDTO userDTO);


    User findUserById(int id);

    List<UserDTO> findAll();

    UserDTO login(UserDTO user);

    UserDTO signIn(UserDTO userDTO);
}
