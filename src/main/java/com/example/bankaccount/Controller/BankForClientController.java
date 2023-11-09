package com.example.bankaccount.Controller;

import com.example.bankaccount.Model.Account;
import com.example.bankaccount.Service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class BankForClientController {
   private  final ClientService clientService;
   public BankForClientController(ClientService clientService){
      this.clientService=clientService;
   }

   @PostMapping("/createAccount")
   public ResponseEntity<String> makeFirstAccount(
           @RequestParam String name,
           @RequestParam String phone,
           @RequestParam String userId,
           @RequestParam String Pw,
           @RequestParam String accountName,
           @RequestParam double firstDeposit) {

      Account account = clientService.createBalance(name, phone, userId, Pw, accountName, firstDeposit);
      String message = String.format(
              "계좌가 생성되었습니다. 축하드립니다, 고객님.\n계좌명: %s\n계좌번호: %s\n현재 잔액: %.2f원",
              account.getAccountName(),
              account.getAccountNumber(),
              account.getBalance()
      );
      return ResponseEntity.ok(message);
   }



}
