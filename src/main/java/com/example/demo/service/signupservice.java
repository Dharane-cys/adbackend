package com.example.demo.service;

import com.example.demo.dto.signupdto;

import java.util.List;

public interface signupservice {
    signupdto createUser(signupdto userDto);
    
    signupdto getUserById(Long userId);

    List<signupdto> getAllUsers();
    
    signupdto updateUser(Long userId, signupdto updatedUser);
    
    void deleteUser(Long userId);

}
