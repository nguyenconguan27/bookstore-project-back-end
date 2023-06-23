package com.shop.bookstore.controller.web;

import com.shop.bookstore.convert.CategoryConvert;
import com.shop.bookstore.dto.CategoryDto;
import com.shop.bookstore.entity.CategoryEntity;
import com.shop.bookstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public List<CategoryDto> getAll() {
        List<CategoryEntity> categories = categoryService.getAllAtegory();
        return categories.stream().map(category -> CategoryConvert.toDto(category)).collect(Collectors.toList());
    }

    @GetMapping("/id/{id}")
    public CategoryDto getById(@PathVariable String id) {
        CategoryEntity category = categoryService.getById(Integer.valueOf(id)).get();
        return CategoryConvert.toDto(category);
    }

    @GetMapping("/name/{name}")
    public CategoryDto getByName(@PathVariable String name) {
        CategoryEntity category = categoryService.getByName(name);
        return CategoryConvert.toDto(category);
    }
}
