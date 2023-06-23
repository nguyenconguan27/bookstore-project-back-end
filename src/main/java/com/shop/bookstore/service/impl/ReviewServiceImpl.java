package com.shop.bookstore.service.impl;

import com.shop.bookstore.entity.ReviewEntity;
import com.shop.bookstore.reponsitory.ReviewRepository;
import com.shop.bookstore.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<ReviewEntity> getReviewByBook(int bookId) {
        return this.reviewRepository.findAllByBook_id(bookId);
    }

    @Override
    public ReviewEntity addReivew(ReviewEntity reviewEntity) {
        return reviewRepository.save(reviewEntity);
    }
}
