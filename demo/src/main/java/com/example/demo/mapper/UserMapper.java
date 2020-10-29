package com.example.demo.mapper;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Mapper
@Component
public class UserMapper implements UserMapperAbstr {



    private UserRepository userService;
    @Autowired
    public UserMapper(UserRepository userService){
        this.userService=userService;
    }
    @Override
    public List<UserDTO> listToDTO(List<User> users) {
        List<UserDTO> userDTOS=new ArrayList<>();
        for(User user:users){
            userDTOS.add(toDTO(user));
        }
        return userDTOS;
    }

    @Override
    public UserDTO toDTO(User user) {
        return new UserDTO(user);
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        return new User(userDTO);
    }

    @Override
    public User toEntityUpdate(int userDTO) {


        User user=userService.findById(userDTO);

        return user;
    }


}
