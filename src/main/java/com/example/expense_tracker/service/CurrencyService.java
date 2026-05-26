package com.example.expense_tracker.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;;

@Service
public class CurrencyService {

    private final WebClient webClient;

    public CurrencyService() {

        this.webClient = WebClient.create();
    }

    public String getExchangeRates() {

        return webClient
            .get()
            .uri("https://api.exchangerate-api.com/v4/latest/USD")
            .retrieve()
            .bodyToMono(String.class)
            .block();
    }

}
