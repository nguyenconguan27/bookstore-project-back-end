package com.shop.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Integer id;
    private String title;
    private String author;
    private Date releaseDate;
    private String des;
    private int pages;
    private String image;
    private int price;
    private int idCategory;
    private int sold;
    private String nameCategory;
}
