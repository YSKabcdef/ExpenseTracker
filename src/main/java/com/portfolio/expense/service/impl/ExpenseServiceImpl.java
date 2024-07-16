package com.portfolio.expense.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.portfolio.expense.Repo.ExpenseRepo;
import com.portfolio.expense.dto.ExpenseDto;
import com.portfolio.expense.entity.Category;
import com.portfolio.expense.entity.Expense;
import com.portfolio.expense.exception.ResourceNotFoundException;
import com.portfolio.expense.mapper.ExpenseMapper;
import com.portfolio.expense.service.ExpenseService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {
    
    private ExpenseRepo expenseRepo;

    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {
        Expense expense = ExpenseMapper.mapToExpense(expenseDto);
        Expense savedExpense = expenseRepo.save(expense);
        return ExpenseMapper.mapToExpenseDto(savedExpense);
    }

    @Override
    public ExpenseDto findExpenseById(Long id) {
        Expense expense = expenseRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Expense Not Found with id: "+id));
        return ExpenseMapper.mapToExpenseDto(expense);
    }

    @Override
    public List<ExpenseDto> findAllExpense() {
        List<Expense> expenses = expenseRepo.findAll();
        return expenses.stream().map((expense) -> ExpenseMapper.mapToExpenseDto(expense)).collect(Collectors.toList());
    }

    @Override
    public ExpenseDto updateExpense(Long id, ExpenseDto expenseDto) {
        Expense expense = expenseRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Expense Not Found with id: "+ id));
        expense.setAmount(expenseDto.amount());
        expense.setCategory(new Category(expenseDto.categoryDto().id(),expenseDto.categoryDto().name()));
        expense.setExpenseDate(expenseDto.expenseDate());
        Expense updatedExpense = expenseRepo.save(expense);
        return ExpenseMapper.mapToExpenseDto(updatedExpense);
    }

    @Override
    public void deleteExpense(Long id) {
        Expense expense = expenseRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Expense Not Found with id: "+ id));
        expenseRepo.delete(expense);;
    }

}
