package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/user")
public interface UserRestApi {

    @GetMapping("/test")
    String testUser();



    @GetMapping("/list")
    List<UserDTO> findAllUsers();


    @PostMapping("/save")
    UserDTO saveUser(@Valid @RequestBody UserDTO userDTO);

    @PostMapping("/login")
    UserDTO login(@Valid @RequestBody UserDTO user);

    @PostMapping("signin")
    UserDTO signIn(@Valid @RequestBody UserDTO userDTO);

}
