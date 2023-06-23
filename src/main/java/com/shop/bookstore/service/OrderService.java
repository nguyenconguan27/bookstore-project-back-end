package com.shop.bookstore.service;

import com.shop.bookstore.dto.OrderDto;
import com.shop.bookstore.dto.UserDto;
import com.shop.bookstore.entity.OrderEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    List<OrderEntity> getOrderByUser(int userId);

    OrderEntity addOrder(int userId, OrderDto userDto);

    List<OrderEntity> getAll();

    OrderEntity confirmOrder(int id);
}
