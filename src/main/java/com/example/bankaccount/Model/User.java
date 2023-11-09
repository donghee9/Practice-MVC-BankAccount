package com.example.bankaccount.Model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class User {
    private String name;
    private String phone;
    private String userId;
    private String Pw;

    private List<Account> accounts;

    protected User(String name, String phone, String userId, String Pw) {
        this.name = name;
        this.phone = phone;
        this.userId = userId;
        this.Pw = Pw;
        this.accounts = new ArrayList<>();

    }

    public static User of(String name, String phone, String userId,String Pw) {
        return new User(name, phone, userId,Pw);
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }


}