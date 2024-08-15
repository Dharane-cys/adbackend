package com.example.demo.mapper;

import com.example.demo.entity.reserveentity;
import com.example.demo.dto.reservedto;
public class reservemapper {

    public static reservedto mapToUserDto(reserveentity user){
        return new reservedto(
        		user.getId(),
                user.getName(),
                user.getEmail(),
                user.getDate(),
                user.getTime(),
                user.getNoofpeople(),
                user.getTableno(),
                user.getMessage()
        );
    }

    public static reserveentity mapToUser(reservedto userDto){
        return new reserveentity(
        		userDto.getId(),
                userDto.getName(),
                userDto.getEmail(),
                userDto.getDate(),
                userDto.getTime(),
                userDto.getNoofpeople(),
                userDto.getTableno(),
                userDto.getMessage()
        );
    }
}
