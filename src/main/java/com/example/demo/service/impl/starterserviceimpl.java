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

// Marks the class as a service component and generates a constructor with all required arguments
@Service
@AllArgsConstructor
public class starterserviceimpl implements starterservice {

    // Repository for accessing starter items from the database
    private starterrepo itemRepository;

    // Creates a new starter item from the given DTO and returns the saved item as a DTO
    @Override
    public starterdto createItem(starterdto itemDto) {
        starterentity item = startermapper.mapToItem(itemDto); // Maps DTO to entity
        starterentity savedItem = itemRepository.save(item); // Saves entity to database
        return startermapper.mapToItemDto(savedItem); // Maps saved entity back to DTO
    }
    
    // Retrieves a starter item by its ID, throws an exception if not found
    @Override
    public starterdto getItemById(Long itemId) {
        starterentity item = itemRepository.findById(itemId)
                .orElseThrow(() ->
                new ResourceNotFoundException("Item not exists with given id : " + itemId));
        return startermapper.mapToItemDto(item); // Maps found entity to DTO
    }

    // Retrieves all starter items and returns them as a list of DTOs
    @Override
    public List<starterdto> getAllItems() {
        List<starterentity> items = itemRepository.findAll(); // Finds all items
        return items.stream().map((item) -> startermapper.mapToItemDto(item))
                .collect(Collectors.toList()); // Maps each entity to DTO
    }
    
    // Updates an existing starter item with new data and returns the updated item as a DTO
    @Override
    public starterdto updateItem(Long itemId, starterdto updatedItem) {
        // Finds existing item by ID or throws an exception if not found
        starterentity item = itemRepository.findById(itemId).orElseThrow(
                () -> new ResourceNotFoundException("Item not exists with given id: " + itemId)
        );

        // Updates item fields with new data
        item.setDishName(updatedItem.getDishName());
        item.setDescription(updatedItem.getDescription());
        item.setDishPrice(updatedItem.getDishPrice());
        
        // Saves updated item to database
        starterentity updatedItemObj = itemRepository.save(item);
        return startermapper.mapToItemDto(updatedItemObj); // Maps updated entity to DTO
    }
    
    // Deletes a starter item by its ID, throws an exception if not found
    @Override
    public void deleteItem(Long itemId) {
        // Finds existing item by ID or throws an exception if not found
        starterentity item = itemRepository.findById(itemId).orElseThrow(
                () -> new ResourceNotFoundException("Item is not exists with given id: " + itemId)
        );

        // Deletes the found item
        itemRepository.delete(item);
    }
}
