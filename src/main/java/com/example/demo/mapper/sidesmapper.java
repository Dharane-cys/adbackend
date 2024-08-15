package com.example.demo.mapper;

import com.example.demo.entity.*;
import com.example.demo.dto.*;
public class sidesmapper {

    public static sidesdto mapToItemDto(sidesentity item){
        return new sidesdto(
                item.getId(),
                item.getDishName(),
                item.getDescription(),
                item.getDishPrice()
                
        );
    }

    public static sidesentity mapToItem(sidesdto itemDto){
        return new sidesentity(
                itemDto.getId(),
                itemDto.getDishName(),
                itemDto.getDescription(),
                itemDto.getDishPrice()
        );
    }
}