package com.example.expense_tracker.controller;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.expense_tracker.entity.Expense;
import com.example.expense_tracker.service.ExpenseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService service;

    @PostMapping
    public ResponseEntity<Expense> addExpense(@Valid @RequestBody Expense expense) {

        return new ResponseEntity<>(service.addExpense(expense),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {

        return ResponseEntity.ok(service.getAllExpenses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {

        Optional<Expense> expense = service.getExpenseById(id);

        return expense.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(
        @PathVariable Long id,
        @RequestBody Expense expense
    ) {

        return ResponseEntity.ok(service.updateExpense(id, expense));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpenseById(@PathVariable Long id) {
        
        service.deleteExpense(id);
        return ResponseEntity.ok("Expense deleted successfully");
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Expense>> getCategory(@PathVariable String category) {

        return ResponseEntity.ok(service.getExpenseByCategory(category));
    }

    @GetMapping("/total")
    public ResponseEntity<Double> getTotalExpense() {

        return ResponseEntity.ok(service.getTotalExpense());
    }

}
