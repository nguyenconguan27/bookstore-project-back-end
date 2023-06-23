package com.shop.bookstore.convert;

import com.shop.bookstore.dto.OrderDto;
import com.shop.bookstore.entity.OrderDetailEntity;
import com.shop.bookstore.entity.OrderEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderConvert {


    public static OrderDto toDTO(OrderEntity orderEntity) {
            OrderDto orderDto = new OrderDto();
            orderDto.setId(orderEntity.getId());
            orderDto.setDate(orderEntity.getDate());
            orderDto.setIsConfirmed(orderEntity.getIsConfirmed());
            orderDto.setOrderDetailList(orderEntity.getOrderDetailEntityList().stream().map(orderDetail
                    -> OrderDetailConvert.toDto(orderDetail)).collect(Collectors.toList()));
            orderDto.setNumber(orderEntity.getNumber());
            orderDto.setPrice(orderEntity.getPrice());
            orderDto.setAddress(orderEntity.getAddress());
            orderDto.setFullname(orderEntity.getUsername());
            return orderDto;
    }

}
