package com.bank;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

        BankAccount account = context.getBean(BankAccount.class);

        System.out.println("===== BANKING APPLICATION =====");
        System.out.println("Initial Balance: Rs." + account.getBalance());

        try {
            System.out.println("\n--- Deposit Test ---");
            account.deposit(500);

            System.out.println("\n--- Withdrawal Test ---");
            account.withdraw(200);

            System.out.println("\n--- Insufficient Balance Test ---");
            account.withdraw(2000);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("\n--- Invalid Deposit Test ---");
            account.deposit(-100);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println(
            "\nFinal Balance: Rs." + account.getBalance()
        );

        context.close();
    }
}