package com.example.demo.service;

import com.example.demo.dto.*;

import java.util.List;

public interface beveragesservice {
    beveragesdto createItem(beveragesdto itemDto);
    
    beveragesdto getItemById(Long itemId);

    List<beveragesdto> getAllItems();
    
    beveragesdto updateItem(Long itemId, beveragesdto updatedItem);
    
    void deleteItem(Long itemId);

}
