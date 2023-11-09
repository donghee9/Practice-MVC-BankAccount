package com.example.bankaccount.Service;

import com.example.bankaccount.Model.Account;
import com.example.bankaccount.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ClientServiceImpl implements ClientService {

    List<User> userList=new ArrayList<>();

    public ClientServiceImpl(){
        initializeList();
    }
    private void initializeList(){
        userList.add(User.of("서동희","01034340000","seodong","seodong1"));
    }
    private String createAccountNumber(){
        return String.valueOf(ThreadLocalRandom.current().nextLong(10000000000000L, 100000000000000L));
    }
    @Override
    public Account createBalance(String name, String phone, String userId, String Pw, String accountName, double firstDeposit) {
        User newUser=User.of(name,phone,userId,Pw);
        String accountNumber=createAccountNumber();
        Account newAccount=Account.of(newUser,accountName,accountNumber,firstDeposit);
        newUser.addAccount(newAccount);
        return newAccount;
    }

    @Override
    public void getOneBalance() {

    }

    @Override
    public void getAllBalance() {

    }

    @Override
    public void getAccountInfo() {

    }

    @Override
    public void deposit() {

    }

    @Override
    public void withdraw() {

    }
}
