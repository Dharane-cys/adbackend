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
public class sidesserviceimpl implements sidesservice {

    // Repository for accessing sides items from the database
    private sidesrepo itemRepository;

    // Creates a new sides item from the given DTO and returns the saved item as a DTO
    @Override
    public sidesdto createItem(sidesdto itemDto) {
        sidesentity item = sidesmapper.mapToItem(itemDto); // Maps DTO to entity
        sidesentity savedItem = itemRepository.save(item); // Saves entity to database
        return sidesmapper.mapToItemDto(savedItem); // Maps saved entity back to DTO
    }
    
    // Retrieves a sides item by its ID, throws an exception if not found
    @Override
    public sidesdto getItemById(Long itemId) {
        sidesentity item = itemRepository.findById(itemId)
                .orElseThrow(() ->
                new ResourceNotFoundException("Item not exists with given id : " + itemId));
        return sidesmapper.mapToItemDto(item); // Maps found entity to DTO
    }

    // Retrieves all sides items and returns them as a list of DTOs
    @Override
    public List<sidesdto> getAllItems() {
        List<sidesentity> items = itemRepository.findAll(); // Finds all items
        return items.stream().map((item) -> sidesmapper.mapToItemDto(item))
                .collect(Collectors.toList()); // Maps each entity to DTO
    }
    
    // Updates an existing sides item with new data and returns the updated item as a DTO
    @Override
    public sidesdto updateItem(Long itemId, sidesdto updatedItem) {
        // Finds existing item by ID or throws an exception if not found
        sidesentity item = itemRepository.findById(itemId).orElseThrow(
                () -> new ResourceNotFoundException("Item not exists with given id: " + itemId)
        );

        // Updates item fields with new data
        item.setDishName(updatedItem.getDishName());
        item.setDescription(updatedItem.getDescription());
        item.setDishPrice(updatedItem.getDishPrice());
        
        // Saves updated item to database
        sidesentity updatedItemObj = itemRepository.save(item);
        return sidesmapper.mapToItemDto(updatedItemObj); // Maps updated entity to DTO
    }
    
    // Deletes a sides item by its ID, throws an exception if not found
    @Override
    public void deleteItem(Long itemId) {
        // Finds existing item by ID or throws an exception if not found
        sidesentity item = itemRepository.findById(itemId).orElseThrow(
                () -> new ResourceNotFoundException("Item is not exists with given id: " + itemId)
        );

        // Deletes the found item
        itemRepository.delete(item);
    }
}
