package com.shop.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Integer id;
    private Date date;
    private String address;
    private String number;
    private String fullname;
    private int isConfirmed;
    private int price;
    private List<OrderDetailDto> orderDetailList;
}
