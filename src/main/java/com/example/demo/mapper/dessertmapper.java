package com.example.demo.mapper;

import com.example.demo.entity.*;
import com.example.demo.dto.*;
public class dessertmapper {

    public static dessertdto mapToItemDto(dessertentity item){
        return new dessertdto(
                item.getId(),
                item.getDishName(),
                item.getDescription(),
                item.getDishPrice()
                
        );
    }

    public static dessertentity mapToItem(dessertdto itemDto){
        return new dessertentity(
                itemDto.getId(),
                itemDto.getDishName(),
                itemDto.getDescription(),
                itemDto.getDishPrice()
        );
    }
}