package com.portfolio.expense.service;



import java.util.List;

import com.portfolio.expense.dto.ExpenseDto;


public interface ExpenseService {
    ExpenseDto createExpense(ExpenseDto expenseDto);
    ExpenseDto findExpenseById(Long id);
    List<ExpenseDto> findAllExpense();
    ExpenseDto updateExpense(Long id, ExpenseDto expenseDto);
    void deleteExpense(Long id);
}
