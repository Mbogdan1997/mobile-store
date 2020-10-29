package com.example.demo.mapper;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;

import java.util.List;

public interface UserMapperAbstr {

    List<UserDTO> listToDTO(List<User> users);

    UserDTO toDTO(User user);

    User toEntity(UserDTO userDTO);

    User toEntityUpdate(int userDTO);
}
