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
public class reserveserviceimpl implements reserveservice {

    private reserverepo userRepository;

    @Override
    public reservedto createUser(reservedto userDto) {

        reserveentity user = reservemapper.mapToUser(userDto);
        reserveentity savedUser = userRepository.save(user);
        return reservemapper.mapToUserDto(savedUser);
    }
    
    @Override
    public reservedto getUserById(Long userId) {
        reserveentity user = userRepository.findById(userId)
                .orElseThrow(() ->
                new ResourceNotFoundException("User not exists with given id : " + userId));

        return reservemapper.mapToUserDto(user);
    }

    @Override
    public List<reservedto> getAllUsers() {
        List<reserveentity> users = userRepository.findAll();
        return users.stream().map((user) -> reservemapper.mapToUserDto(user))
                .collect(Collectors.toList());
    }
    
    
    @Override
    public void deleteUser(Long userId) {

        reserveentity user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User is not exists with given id: " + userId)
        );

        userRepository.delete(user);
    }
}