package com.shop.bookstore.service.impl;

import com.shop.bookstore.entity.CartEntity;
import com.shop.bookstore.reponsitory.CartRepository;
import com.shop.bookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Override
    public CartEntity getById(Integer id) {
        return cartRepository.findById(id).get();
    }
}
