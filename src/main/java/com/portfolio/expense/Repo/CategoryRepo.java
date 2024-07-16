package com.portfolio.expense.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.expense.entity.Category;

public interface CategoryRepo extends JpaRepository<Category,Long> {
    
}
