package com.example.bankaccount.Service;

import com.example.bankaccount.Model.Admin;
import com.example.bankaccount.Model.User;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.util.ArrayList;
import java.util.List;

public class BankerServiceImpl implements BankerService {

    List<Admin> adminList = new ArrayList<>();
    List<User> userList = new ArrayList<>();

    public BankerServiceImpl() {
        initializeList();
    }

    private void initializeList() {
        adminList.add(Admin.of("zheldwkfgkwk12", "xheldwkfgkwk12"));
    }


    @Override
    public List getClientInfo(String inputId, String inputPw, Admin admin, String inputUserName, String inputUserId, User user) {
        if (matchAdmin(inputId, inputPw, admin)) {
            for (User currentUser : userList) {
                if (Helper.idAndNameCheck(inputUserName, inputUserId, user)) {
                    List<Object> clientInfo = new ArrayList<>();
                    clientInfo.add(currentUser.getName());
                    clientInfo.add(currentUser.getPhone());
                    clientInfo.add(currentUser.getAccounts());
                    return clientInfo;

                }
                ;
            }
            return null;
        } else {
            throw new SecurityException("관리자 인증에 실패했습니다.");
        }
    }


    @Override
    public Boolean matchAdmin(String inputId, String inputPw, Admin admin) {
        for (Admin adminList : adminList)
            if (Helper.idAndPwCheck(inputId, inputPw, admin)) {
                return true;
            } else {
                return false;
            }
        return null;
    }
}


