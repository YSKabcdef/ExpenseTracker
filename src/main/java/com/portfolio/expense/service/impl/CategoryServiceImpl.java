package com.portfolio.expense.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.portfolio.expense.Repo.CategoryRepo;

import com.portfolio.expense.dto.CategoryDto;
import com.portfolio.expense.entity.Category;
import com.portfolio.expense.exception.ResourceNotFoundException;
import com.portfolio.expense.mapper.CategoryMapper;
import com.portfolio.expense.service.CategoryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepo categoryRepo;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.mapToCategory(categoryDto);
        categoryRepo.save(category);
        return CategoryMapper.mapToCategoryDto(category);
    }


    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category Not Found with id: "+id));

        return CategoryMapper.mapToCategoryDto(category);
    }


    @Override
    public List<CategoryDto> getAllCategories() {

        List<CategoryDto> categoryDtos = categoryRepo.findAll().stream().map((category)->CategoryMapper.mapToCategoryDto(category)).collect(Collectors.toList());
        return categoryDtos;
    }


    @Override
    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
        Category category = categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category Not Found with id: "+id));
        category.setName(categoryDto.name());
        Category updateCategory = categoryRepo.save(category);
        return CategoryMapper.mapToCategoryDto(updateCategory);
    }


    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category Not Found with id: "+id));
        categoryRepo.delete(category);;
    }

}
