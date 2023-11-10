package com.example.bankaccount.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Account {

    private String accountName;
    private String accountNumber;
    private double balance;
    private User user;

    public Account(User user, String accountName, String accountNumber, Double balance) {
        this.user = user;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public static Account of(User user, String accountName, String accountNumber, double initialBalance) {
        return new Account(user, accountName, accountNumber, initialBalance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            return true;
        } else {
            return false;
        }
    }

}
