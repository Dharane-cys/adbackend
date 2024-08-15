package com.example.demo.mapper;

import com.example.demo.entity.*;
import com.example.demo.dto.*;
public class startermapper {

    public static starterdto mapToItemDto(starterentity item){
        return new starterdto(
                item.getId(),
                item.getDishName(),
                item.getDescription(),
                item.getDishPrice()
                
        );
    }

    public static starterentity mapToItem(starterdto itemDto){
        return new starterentity(
                itemDto.getId(),
                itemDto.getDishName(),
                itemDto.getDescription(),
                itemDto.getDishPrice()
        );
    }
}