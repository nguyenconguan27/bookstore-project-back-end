package com.shop.bookstore.controller.web;

import com.shop.bookstore.convert.OrderDetailConvert;
import com.shop.bookstore.dto.OrderDetailDto;
import com.shop.bookstore.entity.OrderDetailEntity;
import com.shop.bookstore.service.BookService;
import com.shop.bookstore.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/cart")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private BookService bookService;

    @PostMapping("/add/{cartId}/{bookId}")
    public OrderDetailDto addToCart(@RequestBody OrderDetailDto orderDetail, @PathVariable(name = "cartId") String cartId,
                                            @PathVariable(name = "bookId") String bookId) {
        return orderDetailService.updateOrAdd(orderDetail, Integer.valueOf(cartId), Integer.valueOf(bookId));
    }

    @GetMapping("/{cartId}")
    public List<OrderDetailDto> getOrderDetailByUser(@PathVariable String cartId) {
        List<OrderDetailEntity> orderDetailEntities = orderDetailService.getByUser(Integer.valueOf(cartId));
        return orderDetailEntities.stream().map(entity -> OrderDetailConvert.toDto(entity)).collect(Collectors.toList());
    }

    @PutMapping("/update/{cartId}")
    public OrderDetailDto update(@PathVariable String cartId,
                                         @RequestBody OrderDetailDto orderDetail) {
        return orderDetailService.updateOrAdd(orderDetail, Integer.valueOf(cartId), orderDetail.getBookId());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        return orderDetailService.delete(Integer.valueOf(id));
    }


}
