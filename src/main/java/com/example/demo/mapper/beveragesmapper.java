package com.example.demo.mapper;

import com.example.demo.entity.*;
import com.example.demo.dto.*;
public class beveragesmapper {

    public static beveragesdto mapToItemDto(beveragesentity item){
        return new beveragesdto(
                item.getId(),
                item.getDishName(),
                item.getDescription(),
                item.getDishPrice()
                
        );
    }

    public static beveragesentity mapToItem(beveragesdto itemDto){
        return new beveragesentity(
                itemDto.getId(),
                itemDto.getDishName(),
                itemDto.getDescription(),
                itemDto.getDishPrice()
        );
    }
}