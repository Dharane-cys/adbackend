package com.example.demo.mapper;

import com.example.demo.entity.*;
import com.example.demo.dto.*;
public class mainmapper {

    public static maindto mapToItemDto(mainentity item){
        return new maindto(
                item.getId(),
                item.getDishName(),
                item.getDescription(),
                item.getDishPrice()
                
        );
    }

    public static mainentity mapToItem(maindto itemDto){
        return new mainentity(
                itemDto.getId(),
                itemDto.getDishName(),
                itemDto.getDescription(),
                itemDto.getDishPrice()
        );
    }
}