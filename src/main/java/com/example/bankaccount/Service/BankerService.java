package com.example.bankaccount.Service;

import java.util.List;

public interface BankerService {
    Boolean matchAdmin(String inputId, String inputPw);

    List getClientInfo(String inputId, String inputPw, String inputUserName, String inputUserId);

}
