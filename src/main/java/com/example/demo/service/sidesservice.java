package com.example.demo.service;

import com.example.demo.dto.*;

import java.util.List;

public interface sidesservice {
    sidesdto createItem(sidesdto itemDto);
    
    sidesdto getItemById(Long itemId);

    List<sidesdto> getAllItems();
    
    sidesdto updateItem(Long itemId, sidesdto updatedItem);
    
    void deleteItem(Long itemId);

}
