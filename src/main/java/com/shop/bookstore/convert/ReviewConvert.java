package com.shop.bookstore.convert;

import com.shop.bookstore.dto.ReviewDto;
import com.shop.bookstore.entity.BookEntity;
import com.shop.bookstore.entity.ReviewEntity;
import com.shop.bookstore.entity.UserEntity;

public class ReviewConvert {

    public static ReviewDto toDto(ReviewEntity reviewEntity) {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setId(reviewEntity.getId());
        reviewDto.setDate(reviewEntity.getDate());
        reviewDto.setRate(reviewEntity.getRate());
        reviewDto.setComment(reviewEntity.getComment());
        reviewDto.setUser(reviewEntity.getUser().getUsername());
        return reviewDto;
    }

    public static ReviewEntity toEntity(ReviewDto reviewDto, UserEntity userEntity, BookEntity bookEntity) {
        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setUser(userEntity);
        reviewEntity.setBook(bookEntity);
        reviewEntity.setRate(reviewDto.getRate());
        reviewEntity.setDate(reviewDto.getDate());
        reviewEntity.setComment(reviewDto.getComment());
        return reviewEntity;
    }
}
