package com.example.bankaccount.Service;

import com.example.bankaccount.Model.Admin;
import com.example.bankaccount.Model.User;

public class Helper {

    public static boolean idAndPwCheck( String inputId, String inputPw,Admin admin) {
        return admin.getAdminId().equals(inputId) && checkPassword(admin, inputPw);
    }

    private static boolean checkPassword(Admin admin, String inputPw) {
        return admin.getAdminPw().equals(inputPw);
    }


    public static boolean idAndNameCheck(String inputUserName, String inputUserId, User user){
        return user.getName().equals(inputUserName) && user.getUserId().equals(inputUserId);
    }
    }
