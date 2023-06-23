package com.shop.bookstore.service.impl;

import com.shop.bookstore.convert.OrderDetailConvert;
import com.shop.bookstore.dto.OrderDetailDto;
import com.shop.bookstore.entity.BookEntity;
import com.shop.bookstore.entity.CartEntity;
import com.shop.bookstore.entity.OrderDetailEntity;
import com.shop.bookstore.reponsitory.BookRepository;
import com.shop.bookstore.reponsitory.CartRepository;
import com.shop.bookstore.reponsitory.OrderDetailRepository;
import com.shop.bookstore.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CartRepository cartRepository;


    @Override
    public OrderDetailDto updateOrAdd(OrderDetailDto dto, int cartId, int bookId) {
        OrderDetailEntity orderDetail = orderDetailRepository.findById(dto.getId()).orElse(null);
        if(orderDetail == null) {
            orderDetail = new OrderDetailEntity();
            BookEntity book = bookRepository.findById(bookId).get();
            CartEntity cart = cartRepository.findById(cartId).get();
            orderDetail.setCart(cart);
            orderDetail.setBook(book);
        }
        orderDetail.setQuantity(dto.getQuantity());
        orderDetailRepository.save(orderDetail);
        return OrderDetailConvert.toDto(orderDetail);
    }

    @Override
    public List<OrderDetailEntity> getByUser(Integer cartId) {
        CartEntity cart = cartRepository.findById(cartId).get();
        return orderDetailRepository.getAllByCartAndStatus(cart, 0);
    }

    @Override
    public ResponseEntity delete(int id) {
        orderDetailRepository.deleteById(id);
        return ResponseEntity.ok("Xóa thành công");
    }


}
