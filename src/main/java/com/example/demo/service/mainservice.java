package com.example.demo.service;

import com.example.demo.dto.*;

import java.util.List;

public interface mainservice {
    maindto createItem(maindto itemDto);
    
    maindto getItemById(Long itemId);

    List<maindto> getAllItems();
    
    maindto updateItem(Long itemId, maindto updatedItem);
    
    void deleteItem(Long itemId);

}
