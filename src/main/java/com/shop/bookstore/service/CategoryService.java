package com.shop.bookstore.service;

import com.shop.bookstore.entity.CategoryEntity;

import java.util.*;

public interface CategoryService {
    List<CategoryEntity> getAllAtegory();
    Optional<CategoryEntity> getById(int id);
    CategoryEntity getByName(String name);
}
