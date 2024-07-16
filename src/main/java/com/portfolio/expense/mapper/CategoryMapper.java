package com.portfolio.expense.mapper;

import com.portfolio.expense.dto.CategoryDto;
import com.portfolio.expense.entity.Category;

public class CategoryMapper {
    public static Category mapToCategory(CategoryDto categoryDto){
        return new Category(categoryDto.id(),
                            categoryDto.name());
    }
    public static CategoryDto mapToCategoryDto(Category category){
        return new CategoryDto(category.getId(),
                                category.getName());
    }
}

