package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RestUserController implements UserRestApi {
    private final UserService userService;

    public RestUserController(UserService userService) {
        this.userService = userService;
    }



    @Override
    public String testUser() {
        return userService.testSpring();
    }


    @Override
    public List<UserDTO> findAllUsers() {
        return userService.findAll();
    }


    @Override
    public UserDTO saveUser(@Valid @RequestBody UserDTO userDTO) {
       return userService.save(userDTO);
    }

    @Override
    public UserDTO login(UserDTO user) {
        return userService.login(user);
    }

    @Override
    public UserDTO signIn(@Valid UserDTO userDTO) {
        return userService.signIn(userDTO);
    }


}
