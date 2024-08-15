package com.example.demo.service;

import com.example.demo.dto.reservedto;

import java.util.List;
public interface reserveservice {


     reservedto createUser(reservedto userDto);
     
     reservedto getUserById(Long userId);

     List<reservedto> getAllUsers();
     
     void deleteUser(Long userId);
}