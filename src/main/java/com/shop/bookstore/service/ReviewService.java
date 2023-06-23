package com.shop.bookstore.service;

import com.shop.bookstore.entity.ReviewEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public interface ReviewService {
    List<ReviewEntity> getReviewByBook(int bookId);

    ReviewEntity addReivew(ReviewEntity reviewEntity);
}
