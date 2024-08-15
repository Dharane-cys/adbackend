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
@RequestMapping("/api/main")
public class maincontroller {

    private mainservice itemService;

    // Build Add item REST API
    @PostMapping
    public ResponseEntity<maindto> createItem(@RequestBody maindto itemDto){
        maindto savedItem = itemService.createItem(itemDto);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

   // Build Get item REST API
    @GetMapping("{id}")
    public ResponseEntity<maindto> getItemById(@PathVariable("id") Long itemId){
        maindto itemDto = itemService.getItemById(itemId);
        return ResponseEntity.ok(itemDto);
    }

    // Build Get All items REST API
    @GetMapping
    public ResponseEntity<List<maindto>> getAllItems(){
        List<maindto> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }
    
    // Build Update items REST API
    @PutMapping("{id}")
    public ResponseEntity<maindto> updateItem(@PathVariable("id") Long itemId,@RequestBody maindto updatedItem){
          maindto itemDto = itemService.updateItem(itemId, updatedItem);
          return ResponseEntity.ok(itemDto);
    }
    
    // Build Delete item REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteItem(@PathVariable("id") Long itemId){
        itemService.deleteItem(itemId);
        return ResponseEntity.ok("Employee deleted successfully!.");
    }

}
