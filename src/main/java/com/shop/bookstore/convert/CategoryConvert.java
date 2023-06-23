package com.shop.bookstore.convert;

import com.shop.bookstore.dto.CategoryDto;
import com.shop.bookstore.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryConvert {

    public static CategoryEntity toEntity(CategoryDto categoryDto) {
        CategoryEntity category = new CategoryEntity();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        return category;
    }

    public static CategoryDto toDto(CategoryEntity category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        return categoryDto;
    }

}
