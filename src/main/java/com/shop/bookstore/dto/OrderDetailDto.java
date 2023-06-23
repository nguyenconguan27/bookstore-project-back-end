package com.shop.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDto {
    private Integer id;
    private int quantity;
    private int status;
    private String title;
    private String author;
    private int price;
    private Integer bookId;
}
