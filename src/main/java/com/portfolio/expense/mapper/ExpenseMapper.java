package com.portfolio.expense.mapper;

import com.portfolio.expense.dto.CategoryDto;
import com.portfolio.expense.dto.ExpenseDto;
import com.portfolio.expense.entity.Category;
import com.portfolio.expense.entity.Expense;

public class ExpenseMapper {
    public static ExpenseDto mapToExpenseDto(Expense expense){
        return new ExpenseDto(expense.getId(),expense.getAmount(),expense.getExpenseDate(),new CategoryDto(expense.getCategory().getId(),expense.getCategory().getName()));
    }

    public static Expense mapToExpense(ExpenseDto expenseDto){
        Category category = new Category();
        category.setId(expenseDto.categoryDto().id());
        return new Expense(expenseDto.id(),expenseDto.amount(),expenseDto.expenseDate(),category);
    }
}
