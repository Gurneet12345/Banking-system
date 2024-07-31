package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Banking System");

        System.out.println("Create a new user");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        User newUser = bankingSystem.createUser(username, password, email);
        System.out.println("User created successfully!");

        System.out.println("Create a new account");
        System.out.print("Enter initial deposit: ");
        double initialDeposit = scanner.nextDouble();

        Account newAccount = bankingSystem.createAccount(newUser.getUserId(), initialDeposit);
        System.out.println("Account created successfully!");

        boolean exit = false;
        while (!exit) {
            System.out.println("\nBanking System Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    bankingSystem.deposit(newAccount.getAccountId(), depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    bankingSystem.withdraw(newAccount.getAccountId(), withdrawAmount);
                    break;
                case 3:
                    bankingSystem.displayAccountBalance(newAccount.getAccountId());
                    break;
                case 4:
                    bankingSystem.displayTransactionHistory(newAccount.getAccountId());
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
        System.out.println("Thank you for using the Banking System!");
    }
}
