package com.shop.bookstore.controller.web;

import com.shop.bookstore.convert.ReviewConvert;
import com.shop.bookstore.dto.ReviewDto;
import com.shop.bookstore.entity.BookEntity;
import com.shop.bookstore.entity.ReviewEntity;
import com.shop.bookstore.entity.UserEntity;
import com.shop.bookstore.service.BookService;
import com.shop.bookstore.service.ReviewService;
import com.shop.bookstore.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.sql.Date;

@RestController
@RequestMapping("/review")
@CrossOrigin
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private UserSevice userSevice;
    @Autowired
    private BookService bookService;

    @GetMapping("/{bookId}")
    public List<ReviewDto> getReviewByBook(@PathVariable String bookId) {
        return reviewService.getReviewByBook(Integer.valueOf(bookId)).stream().
                map(review -> ReviewConvert.toDto(review)).collect(Collectors.toList());
    }

    @PostMapping("/add/{userId}/{bookId}")
    public ReviewDto addReview(@PathVariable("userId") String userId, @PathVariable("bookId") String bookId,
                          @RequestBody ReviewDto reviewDto) {
        UserEntity userEntity =  userSevice.getUserById(Integer.parseInt(userId)).get();
        BookEntity bookEntity = bookService.getBookById(Integer.parseInt(bookId));
        LocalDate today = LocalDate.now();
        Date sqlDate = Date.valueOf(today);
        reviewDto.setDate(sqlDate);
        ReviewEntity reviewEntity = ReviewConvert.toEntity(reviewDto, userEntity, bookEntity);
        return ReviewConvert.toDto(reviewService.addReivew(reviewEntity));
    }
}
