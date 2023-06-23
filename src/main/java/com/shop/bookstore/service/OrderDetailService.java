package com.shop.bookstore.service;

import com.shop.bookstore.dto.OrderDetailDto;
import com.shop.bookstore.entity.OrderDetailEntity;
import com.shop.bookstore.service.impl.OrderDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.*;

public interface OrderDetailService {
    OrderDetailDto updateOrAdd(OrderDetailDto orderDetail, int cartId, int bookId);
    List<OrderDetailEntity> getByUser(Integer cartId);

    ResponseEntity<String> delete(int id);


}
