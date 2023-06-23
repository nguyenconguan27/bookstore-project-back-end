package com.shop.bookstore.service.impl;

import com.shop.bookstore.entity.CategoryEntity;
import com.shop.bookstore.reponsitory.CategoryRepository;
import com.shop.bookstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<CategoryEntity> getAllAtegory() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<CategoryEntity> getById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public CategoryEntity getByName(String name) {
        return categoryRepository.findByName(name);
    }
}
