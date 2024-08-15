package com.example.demo.service.impl;

import lombok.AllArgsConstructor;
import com.example.demo.dto.*;
import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import com.example.demo.mapper.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class signupserviceimpl implements signupservice {

    private signuprepo userRepository;

    @Override
    public signupdto createUser(signupdto userDto) {

        signupentity user = signupmapper.mapToUser(userDto);
        signupentity savedUser = userRepository.save(user);
        return signupmapper.mapToUserDto(savedUser);
    }
    
    @Override
    public signupdto getUserById(Long userId) {
        signupentity user = userRepository.findById(userId)
                .orElseThrow(() ->
                new ResourceNotFoundException("User not exists with given id : " + userId));

        return signupmapper.mapToUserDto(user);
    }

    @Override
    public List<signupdto> getAllUsers() {
        List<signupentity> users = userRepository.findAll();
        return users.stream().map((user) -> signupmapper.mapToUserDto(user))
                .collect(Collectors.toList());
    }
    
    @Override
    public signupdto updateUser(Long userId, signupdto updatedUser) {

        signupentity user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User not exists with given id: " + userId)
        );

        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());

        signupentity updatedUserObj = userRepository.save(user);

        return signupmapper.mapToUserDto(updatedUserObj);
    }
    
    @Override
    public void deleteUser(Long userId) {

        signupentity user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User is not exists with given id: " + userId)
        );

        userRepository.delete(user);
    }
   
}
