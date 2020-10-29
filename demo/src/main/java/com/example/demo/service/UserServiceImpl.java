package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapperAbstr;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.validation.Valid;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final UserMapperAbstr userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,UserMapperAbstr userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public String testSpring() {
        return "Spring works";
    }

    @Override
    public UserDTO save(UserDTO userDTO) {

        //if(!bindingResult.hasErrors()) {
            User user = userMapper.toEntityUpdate(userDTO.getId());
            if (user != null) {
                user.setRole(userDTO.getRole());
                user.setUsername(userDTO.getUsername());
                user.setPassword(userDTO.getPassword());
                userRepository.save(user);

            } else {
                user = userMapper.toEntity(userDTO);
                userDTO.setId(userRepository.save(user).getId());
            }
            //}
            return userDTO;



    }

    @Override
    public User findUserById(int id) {

        User user=userRepository.findById(id);
        return user;
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> users=userRepository.findAll();
        return userMapper.listToDTO(users);
    }

    @Override
    public UserDTO login(UserDTO user) {
        User user1=userRepository.findByUsername(user.getUsername());
        if(user1==null){
            return null;
        }
        else if(user1.getPassword().equals(user.getPassword())){
            user.setId(user1.getId());
            user.setRole(user1.getRole());
            return user;
        }

        return null;
    }

    @Override
    public UserDTO signIn(UserDTO userDTO) {

            /*if (userRepository.findByUsername(userDTO.getUsername()) != null) {
                ObjectError objectError;
                objectError = new ObjectError("Username Existent", "Exista un alt user cu acest nume");
                bindingResult.addError(objectError);
            }
            */
        //if(!bindingResult.hasErrors()) {
        if(userRepository.findByUsername(userDTO.getUsername())==null) {
            User user = userMapper.toEntity(userDTO);

            //if (!bindingResult.hasErrors()) {
            userRepository.save(user);
            return userMapper.toDTO(user);
        }
           // }
       //}

        return null;

    }


}
