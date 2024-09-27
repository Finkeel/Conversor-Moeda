package com.converter;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateApi {
    private static final String API_KEY = "API_KEY"; // Seu código API
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";

    private final HttpClient client;

    public ExchangeRateApi() {
        this.client = HttpClient.newHttpClient();
    }

    public double getExchangeRate(String fromCurrency, String toCurrency) {
        try {
            URI uri = URI.create(API_URL + fromCurrency + "/" + toCurrency);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();

            if (json.get("result").getAsString().equals("success")) {
                return json.get("conversion_rate").getAsDouble();
            } else {
                System.out.println("Erro: " + json.get("error-type").getAsString());
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao conectar com a API: " + e.getMessage());
        }
        return -1;
    }
}
