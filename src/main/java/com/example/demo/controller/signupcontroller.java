package com.example.demo.controller;

import lombok.AllArgsConstructor;
import com.example.demo.dto.*;
import com.example.demo.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class signupcontroller {

    private signupservice userService;

    // Build Add user REST API
    @PostMapping
    public ResponseEntity<signupdto> createUser(@RequestBody signupdto userDto){
        signupdto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

   // Build Get user REST API
    @GetMapping("{id}")
    public ResponseEntity<signupdto> getUserById(@PathVariable("id") Long userId){
        signupdto userDto = userService.getUserById(userId);
        return ResponseEntity.ok(userDto);
    }

    // Build Get All users REST API
    @GetMapping
    public ResponseEntity<List<signupdto>> getAllUsers(){
        List<signupdto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    
    // Build Update users REST API
    @PutMapping("{id}")
    public ResponseEntity<signupdto> updateUser(@PathVariable("id") Long userId,@RequestBody signupdto updatedUser){
          signupdto userDto = userService.updateUser(userId, updatedUser);
          return ResponseEntity.ok(userDto);
    }
    
    // Build Delete user REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok("Employee deleted successfully!.");
    }

}
