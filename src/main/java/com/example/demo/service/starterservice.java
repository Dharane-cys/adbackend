package com.example.demo.service;

import com.example.demo.dto.*;

import java.util.List;

public interface starterservice {
    starterdto createItem(starterdto itemDto);
    
    starterdto getItemById(Long itemId);

    List<starterdto> getAllItems();
    
    starterdto updateItem(Long itemId, starterdto updatedItem);
    
    void deleteItem(Long itemId);

}
