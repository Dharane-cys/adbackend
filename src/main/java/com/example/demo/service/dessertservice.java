package com.example.demo.service;

import com.example.demo.dto.*;

import java.util.List;

public interface dessertservice {
    dessertdto createItem(dessertdto itemDto);
    
    dessertdto getItemById(Long itemId);

    List<dessertdto> getAllItems();
    
    dessertdto updateItem(Long itemId, dessertdto updatedItem);
    
    void deleteItem(Long itemId);

}
