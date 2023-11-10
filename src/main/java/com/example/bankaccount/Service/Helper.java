package com.example.bankaccount.Service;

import com.example.bankaccount.Model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.bankaccount.Model.Admin;
import com.example.bankaccount.Model.User;

import java.util.List;

public class Helper {
    private static final Logger logger = LoggerFactory.getLogger(Helper.class);

    public static boolean idAndPwCheck(String inputId, String inputPw, List<Admin> adminList) {
        for (Admin admin : adminList) {
            if (admin.getAdminId().equals(inputId) && admin.getAdminPw().equals(inputPw)) {
                return true;
            }
        }
        return false;
    }


    public static boolean idAndNameCheck(String inputUserName, String inputUserId, User user) {
        boolean nameMatches = user.getName().equals(inputUserName);
        boolean idMatches = user.getUserId().equals(inputUserId);
        logger.info("Checking user: nameMatches={}, idMatches={}, user={}, inputUserName={}, inputUserId={}",
                nameMatches, idMatches, user, inputUserName, inputUserId);
        return nameMatches && idMatches;
    }

    public static boolean idAndPwCheckForClient(String userId, String userPw, List<User> userList) {
        for (User user : userList) {
            if (user.getUserId().equals(userId) && user.getPw().equals(userPw)) {
                return true;
            }
        }
        return false;
    }


    public static Account isFindAccountByNumber(String accountNumber, List<Account> accounts) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}


