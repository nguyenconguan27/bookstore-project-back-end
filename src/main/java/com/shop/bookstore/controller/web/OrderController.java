package com.shop.bookstore.controller.web;

import com.shop.bookstore.convert.OrderConvert;
import com.shop.bookstore.dto.OrderDto;
import com.shop.bookstore.entity.OrderEntity;
import com.shop.bookstore.service.OrderService;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/{userId}")
    public List<OrderDto> getByUser(@PathVariable String userId){
        List<OrderEntity> list = orderService.getOrderByUser(Integer.parseInt(userId));
        return list.stream().map(order -> OrderConvert.toDTO(order)).collect(Collectors.toList());
    }

    @PostMapping("/add/{userId}")
    public OrderDto addOrder(@PathVariable String userId, @RequestBody OrderDto orderDto) {
        return OrderConvert.toDTO(orderService.addOrder(Integer.valueOf(userId), orderDto));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/")
    public List<OrderDto> getAll() {
        List<OrderEntity> orderEntities = orderService.getAll();
        return orderEntities.stream().map(order -> OrderConvert.toDTO(order)).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/confirm/{id}")
    public OrderDto confirmOrder(@PathVariable String id) {
        return OrderConvert.toDTO(orderService.confirmOrder(Integer.valueOf(id)));
    }
}
