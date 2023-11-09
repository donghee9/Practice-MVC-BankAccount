package com.example.bankaccount.Service;

import com.example.bankaccount.Model.Admin;
import com.example.bankaccount.Model.User;

import java.util.List;

public interface BankerService {
    Boolean matchAdmin(String inputId,String inputPw ,Admin admin);
    List getClientInfo(String inputId, String inputPw, Admin admin ,String inputUserName,String inputUserId, User user );

}
