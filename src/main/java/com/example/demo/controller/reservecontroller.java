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
@RequestMapping("/api/reserve")
public class reservecontroller {

    private reserveservice userService;

    // Build Add user REST API
    @PostMapping
    public ResponseEntity<reservedto> createUser(@RequestBody reservedto userDto){
        reservedto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<reservedto> getUserById(@PathVariable("id") Long userId){
        reservedto userDto = userService.getUserById(userId);
        return ResponseEntity.ok(userDto);
    }

    // Build Get All users REST API
    @GetMapping
    public ResponseEntity<List<reservedto>> getAllUsers(){
        List<reservedto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    // Build Delete user REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok("Employee deleted successfully!.");
    }
}