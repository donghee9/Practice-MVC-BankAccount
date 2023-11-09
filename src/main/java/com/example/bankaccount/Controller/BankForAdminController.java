package com.example.bankaccount.Controller;

import com.example.bankaccount.Model.Account;
import com.example.bankaccount.Service.BankerService;
import com.example.bankaccount.Service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class BankForAdminController {
    private  final BankerService bankerService;
    public BankForAdminController(BankerService bankerService) {
        this.bankerService=bankerService;
    }




}
