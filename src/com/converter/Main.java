package com.converter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        do {
            System.out.println("\n--- Conversor de Moedas ---");
            System.out.println("1. USD para BRL");
            System.out.println("2. BRL para USD");
            System.out.println("3. EUR para BRL");
            System.out.println("4. BRL para EUR");
            System.out.println("5. GBP para BRL");
            System.out.println("6. BRL para GBP");
            System.out.println("7. Ver Histórico");
            System.out.println("8. Sair");

            try {
                System.out.print("Escolha uma opção: ");
                option = scanner.nextInt();

                if (option >= 1 && option <= 6) {

                    double amount = -1;
                    boolean validInput = false;

                    while (!validInput) {
                        try {
                            System.out.print("Digite o valor a ser convertido: ");
                            amount = scanner.nextDouble();
                            if (amount > 0) {
                                validInput = true;
                            } else {
                                System.out.println("Valor inválido. O valor deve ser maior que zero.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Por favor, insira um número válido.");
                            scanner.next(); // Limpa o buffer
                        }
                    }

                    converter.convert(option, amount);

                } else if (option == 7) {
                    converter.displayHistory();
                } else if (option != 8) {
                    System.out.println("Opção inválida. Por favor, escolha uma opção entre 1 e 8.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                scanner.next(); // Limpa o scanner
            }
        } while (option != 8);

        System.out.println("Obrigado por usar o Conversor de Moedas!");
    }
}
