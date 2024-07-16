package com.portfolio.expense.service;

import java.util.List;

import com.portfolio.expense.dto.CategoryDto;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto getCategoryById(Long id);
    List<CategoryDto> getAllCategories();
    CategoryDto updateCategory(Long id,CategoryDto categoryDto);
    void deleteCategory(Long id);
}
