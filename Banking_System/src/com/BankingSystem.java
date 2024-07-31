package com;

import java.util.ArrayList;
import java.util.List;

public class BankingSystem {
    private List<User> users;
    private List<Account> accounts;
    private List<Transaction> transactions;
    private int nextUserId;
    private int nextAccountId;
    private int nextTransactionId;

    public BankingSystem() {
        users = new ArrayList<>();
        accounts = new ArrayList<>();
        transactions = new ArrayList<>();
        nextUserId = 1;
        nextAccountId = 1;
        nextTransactionId = 1;
    }

    public User createUser(String username, String password, String email) {
        User newUser = new User(nextUserId++, username, password, email);
        users.add(newUser);
        return newUser;
    }

    public Account createAccount(int userId, double initialDeposit) {
        Account newAccount = new Account(nextAccountId++, userId, initialDeposit);
        accounts.add(newAccount);
        return newAccount;
    }

    public void deposit(int accountId, double amount) {
        for (Account account : accounts) {
            if (account.getAccountId() == accountId) {
                account.deposit(amount);
                transactions.add(new Transaction(nextTransactionId++, accountId, "Deposit", amount));
                return;
            }
        }
        System.out.println("Account not found.");
    }

    public void withdraw(int accountId, double amount) {
        for (Account account : accounts) {
            if (account.getAccountId() == accountId) {
                if (account.withdraw(amount)) {
                    Transaction transaction = new Transaction(nextTransactionId++, accountId, "Withdrawal", amount);
                    transactions.add(transaction);
                    printReceipt(transaction, account);
                }
                return;
            }
        }
        System.out.println("Account not found or insufficient funds.");
    }

    public void displayAccountBalance(int accountId) {
        for (Account account : accounts) {
            if (account.getAccountId() == accountId) {
                account.displayBalance();
                return;
            }
        }
        System.out.println("Account not found.");
    }

    public void displayTransactionHistory(int accountId) {
        System.out.println("Transaction History for Account ID: " + accountId);
        for (Transaction transaction : transactions) {
            if (transaction.getAccountId() == accountId) {
                transaction.displayTransaction();
            }
        }
    }

    private void printReceipt(Transaction transaction, Account account) {
        System.out.println("\nReceipt:");
        System.out.println("Transaction ID: " + transaction.getTransactionId());
        System.out.println("Account ID: " + transaction.getAccountId());
        System.out.println("Type: " + transaction.getType());
        System.out.println("Amount: " + transaction.getAmount());
        System.out.println("Date: " + transaction.getDate());
        System.out.println("Remaining Balance: " + account.getBalance());
        System.out.println();
    }
}
