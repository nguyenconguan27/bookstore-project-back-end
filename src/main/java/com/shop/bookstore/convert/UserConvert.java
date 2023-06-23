package com.shop.bookstore.convert;

import com.shop.bookstore.dto.UserDto;
import com.shop.bookstore.entity.UserEntity;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class UserConvert {

    public static UserDto toDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setFullname(userEntity.getFullName());
        userDto.setUsername(userEntity.getUsername());
        userDto.setNumber(userEntity.getNumber());
        userDto.setAddress((userEntity.getAddress()));

        return userDto;
    }


}
