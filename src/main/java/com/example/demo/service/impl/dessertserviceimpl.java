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
public class dessertserviceimpl implements dessertservice {

    // Repository for accessing dessert items from the database
    private dessertrepo itemRepository;

    // Creates a new dessert item from the given DTO and returns the saved item as a DTO
    @Override
    public dessertdto createItem(dessertdto itemDto) {
        dessertentity item = dessertmapper.mapToItem(itemDto); // Maps DTO to entity
        dessertentity savedItem = itemRepository.save(item); // Saves entity to database
        return dessertmapper.mapToItemDto(savedItem); // Maps saved entity back to DTO
    }
    
    // Retrieves a dessert item by its ID, throws an exception if not found
    @Override
    public dessertdto getItemById(Long itemId) {
        dessertentity item = itemRepository.findById(itemId)
                .orElseThrow(() ->
                new ResourceNotFoundException("Item not exists with given id : " + itemId));
        return dessertmapper.mapToItemDto(item); // Maps found entity to DTO
    }

    // Retrieves all dessert items and returns them as a list of DTOs
    @Override
    public List<dessertdto> getAllItems() {
        List<dessertentity> items = itemRepository.findAll(); // Finds all items
        return items.stream().map((item) -> dessertmapper.mapToItemDto(item))
                .collect(Collectors.toList()); // Maps each entity to DTO
    }
    
    // Updates an existing dessert item with new data and returns the updated item as a DTO
    @Override
    public dessertdto updateItem(Long itemId, dessertdto updatedItem) {
        // Finds existing item by ID or throws an exception if not found
        dessertentity item = itemRepository.findById(itemId).orElseThrow(
                () -> new ResourceNotFoundException("Item not exists with given id: " + itemId)
        );

        // Updates item fields with new data
        item.setDishName(updatedItem.getDishName());
        item.setDescription(updatedItem.getDescription());
        item.setDishPrice(updatedItem.getDishPrice());
        
        // Saves updated item to database
        dessertentity updatedItemObj = itemRepository.save(item);
        return dessertmapper.mapToItemDto(updatedItemObj); // Maps updated entity to DTO
    }
    
    // Deletes a dessert item by its ID, throws an exception if not found
    @Override
    public void deleteItem(Long itemId) {
        // Finds existing item by ID or throws an exception if not found
        dessertentity item = itemRepository.findById(itemId).orElseThrow(
                () -> new ResourceNotFoundException("Item is not exists with given id: " + itemId)
        );

        // Deletes the found item
        itemRepository.delete(item);
    }
}
