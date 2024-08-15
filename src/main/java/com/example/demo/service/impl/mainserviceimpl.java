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
public class mainserviceimpl implements mainservice {

    // Repository for accessing main items from the database
    private mainrepo itemRepository;

    // Creates a new main item from the given DTO and returns the saved item as a DTO
    @Override
    public maindto createItem(maindto itemDto) {
        mainentity item = mainmapper.mapToItem(itemDto); // Maps DTO to entity
        mainentity savedItem = itemRepository.save(item); // Saves entity to database
        return mainmapper.mapToItemDto(savedItem); // Maps saved entity back to DTO
    }
    
    // Retrieves a main item by its ID, throws an exception if not found
    @Override
    public maindto getItemById(Long itemId) {
        mainentity item = itemRepository.findById(itemId)
                .orElseThrow(() ->
                new ResourceNotFoundException("Item not exists with given id : " + itemId));
        return mainmapper.mapToItemDto(item); // Maps found entity to DTO
    }

    // Retrieves all main items and returns them as a list of DTOs
    @Override
    public List<maindto> getAllItems() {
        List<mainentity> items = itemRepository.findAll(); // Finds all items
        return items.stream().map((item) -> mainmapper.mapToItemDto(item))
                .collect(Collectors.toList()); // Maps each entity to DTO
    }
    
    // Updates an existing main item with new data and returns the updated item as a DTO
    @Override
    public maindto updateItem(Long itemId, maindto updatedItem) {
        // Finds existing item by ID or throws an exception if not found
        mainentity item = itemRepository.findById(itemId).orElseThrow(
                () -> new ResourceNotFoundException("Item not exists with given id: " + itemId)
        );

        // Updates item fields with new data
        item.setDishName(updatedItem.getDishName());
        item.setDescription(updatedItem.getDescription());
        item.setDishPrice(updatedItem.getDishPrice());
        
        // Saves updated item to database
        mainentity updatedItemObj = itemRepository.save(item);
        return mainmapper.mapToItemDto(updatedItemObj); // Maps updated entity to DTO
    }
    
    // Deletes a main item by its ID, throws an exception if not found
    @Override
    public void deleteItem(Long itemId) {
        // Finds existing item by ID or throws an exception if not found
        mainentity item = itemRepository.findById(itemId).orElseThrow(
                () -> new ResourceNotFoundException("Item is not exists with given id: " + itemId)
        );

        // Deletes the found item
        itemRepository.delete(item);
    }
}
