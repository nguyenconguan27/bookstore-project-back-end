package com.shop.bookstore.service.impl;

import com.shop.bookstore.convert.OrderDetailConvert;
import com.shop.bookstore.dto.OrderDto;
import com.shop.bookstore.entity.BookEntity;
import com.shop.bookstore.entity.OrderDetailEntity;
import com.shop.bookstore.entity.UserEntity;
import com.shop.bookstore.reponsitory.BookRepository;
import com.shop.bookstore.reponsitory.OrderDetailRepository;
import com.shop.bookstore.reponsitory.OrderRepository;
import com.shop.bookstore.entity.OrderEntity;
import com.shop.bookstore.reponsitory.UserRepository;
import com.shop.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<OrderEntity> getOrderByUser(int userId) {
        return orderRepository.findAllByUser(userId);
    }

    @Override
    public OrderEntity addOrder(int userId, OrderDto orderDto) {
        OrderEntity order = new OrderEntity();
        LocalDate today = LocalDate.now();
        Date sqlDate = Date.valueOf(today);
        order.setDate(sqlDate);
        UserEntity user = userRepository.findById(userId).get();
        List<OrderDetailEntity> orderDetailEntities = orderDetailRepository.findAllByCart_IdAndStatus(user.getCartEntity().getId(), 0);
        int price = 0;
        for(OrderDetailEntity orderDetail : orderDetailEntities) {
            price += OrderDetailConvert.toDto(orderDetail).getPrice();
        }
        order.setPrice(price);
        order.setUser(user);
        order.setIsConfirmed(0);
        order.setNumber(orderDto.getNumber());
        order.setAddress(orderDto.getAddress());
        order.setUsername(orderDto.getFullname());
        order =  orderRepository.save(order);
        for(OrderDetailEntity orderDetail: orderDetailEntities) {
            BookEntity book = orderDetail.getBook();
            book.setSold(book.getSold() + orderDetail.getQuantity());
            bookRepository.save(book);
            orderDetail.setOrder(order);
            orderDetail.setStatus(1);
            orderDetailRepository.save(orderDetail);
        }
        return order;
    }

    @Override
    public List<OrderEntity> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public OrderEntity confirmOrder(int id) {
        OrderEntity order = orderRepository.findById(id).get();
        order.setIsConfirmed(1);
        return orderRepository.save(order);
    }
}
