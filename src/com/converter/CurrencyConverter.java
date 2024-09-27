package com.converter;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CurrencyConverter {
    private List<String> history = new ArrayList<>();
    private ExchangeRateApi api = new ExchangeRateApi();

    public void convert(int option, double amount) {
        String fromCurrency = "";
        String toCurrency = "";

        switch (option) {
            case 1:
                fromCurrency = "USD";
                toCurrency = "BRL";
                break;
            case 2:
                fromCurrency = "BRL";
                toCurrency = "USD";
                break;
            case 3:
                fromCurrency = "EUR";
                toCurrency = "BRL";
                break;
            case 4:
                fromCurrency = "BRL";
                toCurrency = "EUR";
                break;
            case 5:
                fromCurrency = "GBP";
                toCurrency = "BRL";
                break;
            case 6:
                fromCurrency = "BRL";
                toCurrency = "GBP";
                break;
        }

        double rate = api.getExchangeRate(fromCurrency, toCurrency);
        if (rate > 0) {
            double result = amount * rate;
            String log = String.format("Convertido %.2f %s para %.2f %s | Taxa: %.4f | %s",
                    amount, fromCurrency, result, toCurrency, rate, getCurrentTime());
            System.out.println(log);
            addHistory(log);
        } else {
            System.out.println("Falha ao obter taxa de câmbio.");
        }
    }

    private void addHistory(String log) {
        history.add(log);
        if (history.size() > 5) {
            history.remove(0);  // Mantém apenas as 5 conversões mais recentes
        }
    }

    public void displayHistory() {
        if (history.isEmpty()) {
            System.out.println("Nenhuma conversão realizada.");
        } else {
            System.out.println("\n--- Histórico de Conversões ---");
            for (String entry : history) {
                System.out.println(entry);
            }
        }
    }

    private String getCurrentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
}
