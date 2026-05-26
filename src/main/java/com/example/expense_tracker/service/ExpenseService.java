package com.example.expense_tracker.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expense_tracker.entity.Expense;
import com.example.expense_tracker.repository.ExpenseRepository;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository repository;

    public Expense addExpense(Expense expense){

        if (expense.getDate() == null) {

            expense.setDate(LocalDate.now());
        }

        return repository.save(expense);
    }

    public List<Expense> getAllExpenses() {

        return repository.findAll();
    }

    public Optional<Expense> getExpenseById(Long id) {

        return repository.findById(id);
    }

    public Expense updateExpense(Long id, Expense updatedExpense) {

        Expense existingExpense = repository.findById(id).orElseThrow(() -> new RuntimeException("Expense Not Found"));

        existingExpense.setTitle(updatedExpense.getTitle());
        existingExpense.setAmount(updatedExpense.getAmount());
        existingExpense.setCategory(updatedExpense.getCategory());
        existingExpense.setDate(updatedExpense.getDate());

        return repository.save(updatedExpense);
    }

    public void deleteExpense(Long id) {

        repository.deleteById(id);
    }

    public List<Expense> getExpenseByCategory(String category) {

        return repository.findByCategory(category);
    }

    public Double getTotalExpense() {

        return repository.findAll()
            .stream()
            .mapToDouble(Expense::getAmount)
            .sum();
    }
}
