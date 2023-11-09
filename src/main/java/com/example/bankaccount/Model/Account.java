package com.example.bankaccount.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {

    private String accountName;
    private String accountNumber;
    private Double balance;
    private User user;


    protected Account(User user,String accountName,String accountNumber,Double balance){
        this.user=user;
        this.accountName=accountName;
        this.accountNumber=accountNumber;
        this.balance=balance;
    }
public static Account of(User user ,String hashedPw,String accountNumber,Double balance){
        return new Account(user, hashedPw, accountNumber, balance);
}


}

