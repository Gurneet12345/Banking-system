package com;

import java.util.Date;

public class Transaction {
    private int transactionId;
    private int accountId;
    private String type;
    private double amount;
    private Date date;

    public Transaction(int transactionId, int accountId, String type, double amount) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
        this.date = new Date();
    }

    public int getTransactionId() {
        return transactionId;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public void displayTransaction() {
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Account ID: " + accountId);
        System.out.println("Type: " + type);
        System.out.println("Amount: " + amount);
        System.out.println("Date: " + date);
    }
}
