package com.example.bankaccount.Service;

import com.example.bankaccount.Model.Account;

public interface ClientService {
    Account createBalance(String name, String phone, String userId, String Pw, String accountName, double firstDeposit);
    void getOneBalance();
    void getAllBalance();
    void getAccountInfo();
    void deposit();
    void withdraw();

}
