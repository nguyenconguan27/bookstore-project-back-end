package com.shop.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    private Integer id;
    private Date date;
    private int rate;
    private String comment;
    private String user;
}
