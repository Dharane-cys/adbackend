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
@RequestMapping("/api/dessert")
public class dessertcontroller {

    private dessertservice itemService;

    // Build Add item REST API
    @PostMapping
    public ResponseEntity<dessertdto> createItem(@RequestBody dessertdto itemDto){
        dessertdto savedItem = itemService.createItem(itemDto);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

   // Build Get item REST API
    @GetMapping("{id}")
    public ResponseEntity<dessertdto> getItemById(@PathVariable("id") Long itemId){
        dessertdto itemDto = itemService.getItemById(itemId);
        return ResponseEntity.ok(itemDto);
    }

    // Build Get All items REST API
    @GetMapping
    public ResponseEntity<List<dessertdto>> getAllItems(){
        List<dessertdto> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }
    
    // Build Update items REST API
    @PutMapping("{id}")
    public ResponseEntity<dessertdto> updateItem(@PathVariable("id") Long itemId,@RequestBody dessertdto updatedItem){
          dessertdto itemDto = itemService.updateItem(itemId, updatedItem);
          return ResponseEntity.ok(itemDto);
    }
    
    // Build Delete item REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteItem(@PathVariable("id") Long itemId){
        itemService.deleteItem(itemId);
        return ResponseEntity.ok("Employee deleted successfully!.");
    }

}
