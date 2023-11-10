package com.example.bankaccount.Service;

import com.example.bankaccount.Model.Account;
import com.example.bankaccount.Model.User;

import java.util.List;

public interface ClientService {
    Account createBalance(String name, String phone, String userId, String Pw, String accountName, double firstDeposit);

    List getAllAccountsForUser(String userId, String Pw);

    Account deposit(String userId, String pw, String accountNumber, double depositAmount);

    Account withdraw(String userId, String pw, String accountNumber, double withdrawAmount);

}
