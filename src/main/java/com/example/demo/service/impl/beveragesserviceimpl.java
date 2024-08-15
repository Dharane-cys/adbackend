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
public class beveragesserviceimpl implements beveragesservice {

    // Repository for accessing beverages items from the database
    private beveragesrepo itemRepository;

    // Creates a new beverages item from the given DTO and returns the saved item as a DTO
    @Override
    public beveragesdto createItem(beveragesdto itemDto) {
        beveragesentity item = beveragesmapper.mapToItem(itemDto); // Maps DTO to entity
        beveragesentity savedItem = itemRepository.save(item); // Saves entity to database
        return beveragesmapper.mapToItemDto(savedItem); // Maps saved entity back to DTO
    }
    
    // Retrieves a beverages item by its ID, throws an exception if not found
    @Override
    public beveragesdto getItemById(Long itemId) {
        beveragesentity item = itemRepository.findById(itemId)
                .orElseThrow(() ->
                new ResourceNotFoundException("Item not exists with given id : " + itemId));
        return beveragesmapper.mapToItemDto(item); // Maps found entity to DTO
    }

    // Retrieves all beverages items and returns them as a list of DTOs
    @Override
    public List<beveragesdto> getAllItems() {
        List<beveragesentity> items = itemRepository.findAll(); // Finds all items
        return items.stream().map((item) -> beveragesmapper.mapToItemDto(item))
                .collect(Collectors.toList()); // Maps each entity to DTO
    }
    
    // Updates an existing beverages item with new data and returns the updated item as a DTO
    @Override
    public beveragesdto updateItem(Long itemId, beveragesdto updatedItem) {
        // Finds existing item by ID or throws an exception if not found
        beveragesentity item = itemRepository.findById(itemId).orElseThrow(
                () -> new ResourceNotFoundException("Item not exists with given id: " + itemId)
        );

        // Updates item fields with new data
        item.setDishName(updatedItem.getDishName());
        item.setDescription(updatedItem.getDescription());
        item.setDishPrice(updatedItem.getDishPrice());
        
        // Saves updated item to database
        beveragesentity updatedItemObj = itemRepository.save(item);
        return beveragesmapper.mapToItemDto(updatedItemObj); // Maps updated entity to DTO
    }
    
    // Deletes a beverages item by its ID, throws an exception if not found
    @Override
    public void deleteItem(Long itemId) {
        // Finds existing item by ID or throws an exception if not found
        beveragesentity item = itemRepository.findById(itemId).orElseThrow(
                () -> new ResourceNotFoundException("Item is not exists with given id: " + itemId)
        );

        // Deletes the found item
        itemRepository.delete(item);
    }
}
