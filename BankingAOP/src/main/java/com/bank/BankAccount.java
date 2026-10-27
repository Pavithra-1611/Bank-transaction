package com.bank;

import org.springframework.stereotype.Component;

@Component
public class BankAccount {

    private double balance = 1000.0;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Deposit amount must be greater than zero."
            );
        }

        balance += amount;
        System.out.println("Deposited: Rs." + amount);
        System.out.println("Current Balance: Rs." + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Withdrawal amount must be greater than zero."
            );
        }

        if (amount > balance) {
            throw new IllegalArgumentException(
                "Insufficient balance! Available balance: Rs."
                + balance
            );
        }

        balance -= amount;
        System.out.println("Withdrawn: Rs." + amount);
        System.out.println("Current Balance: Rs." + balance);
    }
}