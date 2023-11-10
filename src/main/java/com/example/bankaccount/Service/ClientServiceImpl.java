package com.example.bankaccount.Service;

import com.example.bankaccount.Model.Account;
import com.example.bankaccount.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ClientServiceImpl implements ClientService {

    private List<User> userList = new ArrayList<>();

    public ClientServiceImpl() {
        initializeList();
    }

    private void initializeList() {
        User newUser = User.of("seo", "01034340000", "seodong1", "seodong1");
        Account newAccount = Account.of(newUser, "quf", createAccountNumber(), 1203124.00);
        newUser.addAccount(newAccount);
        userList.add(newUser);
    }

    private String createAccountNumber() {
        return String.valueOf(ThreadLocalRandom.current().nextLong(10000000000000L, 100000000000000L));
    }

    @Override
    public Account createBalance(String name, String phone, String userId, String Pw, String accountName, double firstDeposit) {
        User newUser = User.of(name, phone, userId, Pw);
        String accountNumber = createAccountNumber();
        Account newAccount = Account.of(newUser, accountName, accountNumber, firstDeposit);
        newUser.addAccount(newAccount);
        return newAccount;
    }

    @Override
    public List<Account> getAllAccountsForUser(String userId, String Pw) {
        for (User user : userList) {
            if (user.getUserId().equals(userId) && Helper.idAndPwCheckForClient(userId, Pw, userList)) {
                return user.getAccounts();
            }
        }
        return null;
    }


    @Override
    public Account deposit(String userId, String pw, String accountNumber, double depositAmount) {
        Account accountToDeposit = findAccountIfUser(userId, pw, accountNumber);
        if (accountToDeposit != null) {
            accountToDeposit.deposit(depositAmount);
            return accountToDeposit;
        }
        return null;
    }

    @Override
    public Account withdraw(String userId, String pw, String accountNumber, double withdrawAmount) {
        Account accountToWithdraw = findAccountIfUser(userId, pw, accountNumber);
        if (accountToWithdraw != null) {
            boolean success = accountToWithdraw.withdraw(withdrawAmount);
            if (success) {
                return accountToWithdraw;
            }

        }
        return null;
    }

    private Account findAccountIfUser(String userId, String pw, String accountNumber) {
        if (Helper.idAndPwCheckForClient(userId, pw, userList)) {
            for (User user : userList) {
                List<Account> accounts = user.getAccounts();
                Account account = Helper.isFindAccountByNumber(accountNumber, accounts);
                if (account != null) {
                    return account;
                }
            }
        }
        return null;
    }


}
