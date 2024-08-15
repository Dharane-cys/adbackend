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
@RequestMapping("/api/starter")
public class startercontroller {

    private starterservice itemService;

    // Build Add item REST API
    @PostMapping
    public ResponseEntity<starterdto> createItem(@RequestBody starterdto itemDto){
        starterdto savedItem = itemService.createItem(itemDto);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

   // Build Get item REST API
    @GetMapping("{id}")
    public ResponseEntity<starterdto> getItemById(@PathVariable("id") Long itemId){
        starterdto itemDto = itemService.getItemById(itemId);
        return ResponseEntity.ok(itemDto);
    }

    // Build Get All items REST API
    @GetMapping
    public ResponseEntity<List<starterdto>> getAllItems(){
        List<starterdto> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }
    
    // Build Update items REST API
    @PutMapping("{id}")
    public ResponseEntity<starterdto> updateItem(@PathVariable("id") Long itemId,@RequestBody starterdto updatedItem){
          starterdto itemDto = itemService.updateItem(itemId, updatedItem);
          return ResponseEntity.ok(itemDto);
    }
    
    // Build Delete item REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteItem(@PathVariable("id") Long itemId){
        itemService.deleteItem(itemId);
        return ResponseEntity.ok("Employee deleted successfully!.");
    }

}
