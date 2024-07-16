package com.portfolio.expense.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.expense.entity.Expense;

public interface ExpenseRepo extends JpaRepository<Expense,Long> {
}
