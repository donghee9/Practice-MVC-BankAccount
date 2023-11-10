package com.example.bankaccount.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.bankaccount.Model.Account;
import com.example.bankaccount.Model.Admin;
import com.example.bankaccount.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BankerServiceImpl implements BankerService {

    List<Admin> adminList = new ArrayList<>();
    List<Account> accountList = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(BankerServiceImpl.class);


    public BankerServiceImpl() {
        initializeList();
    }

    private void initializeList() {
        adminList.add(Admin.of("123", "123"));
    }


    @Override
    public List<Object> getClientInfo(String inputAdminId, String inputAdminPw, String inputUserName, String inputUserId) {
        if (matchAdmin(inputAdminId, inputAdminPw)) {
            for (Account account : accountList) {
                User accountUser = account.getUser();
                if (Helper.idAndNameCheck(inputUserName, inputUserId, accountUser)) {
                    return Arrays.asList(accountUser.getName(), accountUser.getPhone(), account.getAccountName(), account.getAccountNumber(), account.getBalance());
                }
            }
            return null;
        } else {
            throw new SecurityException("관리자 인증에 실패했습니다.");
        }
    }

    @Override
    public Boolean matchAdmin(String inputId, String inputPw) {
        boolean matched = Helper.idAndPwCheck(inputId, inputPw, adminList);
        return matched;
    }
}


