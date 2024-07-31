package com;

public class Account {
    private int accountId;
    private int userId;
    private double balance;

    public Account(int accountId, int userId, double initialDeposit) {
        this.accountId = accountId;
        this.userId = userId;
        this.balance = initialDeposit;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getUserId() {
        return userId;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
            return true;
        } else {
            System.out.println("Insufficient funds or invalid amount.");
            return false;
        }
    }

    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}
