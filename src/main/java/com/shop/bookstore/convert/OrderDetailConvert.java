package com.shop.bookstore.convert;

import com.shop.bookstore.dto.OrderDetailDto;
import com.shop.bookstore.entity.OrderDetailEntity;

public class OrderDetailConvert {

    public static OrderDetailEntity toEntity(OrderDetailDto dto) {
        OrderDetailEntity entity = new OrderDetailEntity();
        if(dto.getId() != null) {
            entity.setId(dto.getId());
        }
        entity.setQuantity(dto.getQuantity());
        entity.setStatus(dto.getStatus());
        return entity;
    }


    public static OrderDetailDto toDto(OrderDetailEntity entity) {
        OrderDetailDto dto = new OrderDetailDto();
        dto.setId(entity.getId());
        dto.setQuantity((entity.getQuantity()));
        dto.setStatus((entity.getStatus()));
        dto.setBookId(entity.getBook().getId());
        dto.setAuthor(entity.getBook().getAuthor());
        dto.setTitle(entity.getBook().getTitle());
        dto.setPrice(entity.getBook().getPrice() * dto.getQuantity());
        return dto;
    }
}
