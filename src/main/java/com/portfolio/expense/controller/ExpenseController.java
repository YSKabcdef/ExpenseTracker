package com.portfolio.expense.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.expense.dto.ExpenseDto;
import com.portfolio.expense.service.ExpenseService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/expenses")
@AllArgsConstructor
public class ExpenseController {
    private ExpenseService expenseService;
    
    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto){
        ExpenseDto expense = expenseService.createExpense(expenseDto);
        return new ResponseEntity<>(expense,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDto> findExpenseById(@PathVariable Long id){
        return ResponseEntity.ok(expenseService.findExpenseById(id));
    }

    @GetMapping
    public ResponseEntity<List<ExpenseDto>> findAllExpenses(){
        return ResponseEntity.ok(expenseService.findAllExpense());
    }
    @PutMapping("/{id}/update")
    public ResponseEntity<ExpenseDto> updateExpenses(@PathVariable("id") Long id, @RequestBody ExpenseDto expenseDto ){
        return ResponseEntity.ok(expenseService.updateExpense(id, expenseDto));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteExpense(@PathVariable("id") Long id){
        expenseService.deleteExpense(id);
        return ResponseEntity.ok("The expense is deleted");
    }

}
