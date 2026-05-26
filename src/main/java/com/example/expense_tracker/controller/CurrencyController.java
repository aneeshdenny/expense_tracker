package com.example.expense_tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.expense_tracker.service.CurrencyService;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping
    public ResponseEntity<String> getRates() {

        return ResponseEntity.ok(currencyService.getExchangeRates());
    }

}
