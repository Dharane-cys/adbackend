package com.example.demo.mapper;

import com.example.demo.entity.*;
import com.example.demo.dto.*;
public class ordermapper {

    public static orderdto mapToOrderDto(orderentity order){
        return new orderdto(
                order.getId(),
                order.getCustomerId(),
                order.getName(),
                order.getItems(),
                order.getTotal(),
                order.getStatus()
                
        );
    }

    public static orderentity mapToOrder(orderdto orderDto){
        return new orderentity(
                orderDto.getId(),
                orderDto.getCustomerId(),
                orderDto.getName(),
                orderDto.getItems(),
                orderDto.getTotal(),
                orderDto.getStatus()
        );
    }
}