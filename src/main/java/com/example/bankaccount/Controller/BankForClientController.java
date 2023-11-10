package com.example.bankaccount.Controller;

import com.example.bankaccount.Model.Account;
import com.example.bankaccount.Service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankForClientController {
    private final ClientService clientService;

    public BankForClientController(ClientService clientService) {
        this.clientService = clientService;
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


    @GetMapping("/accounts")
    public ResponseEntity<?> getAllAccountsForUser(
            @RequestParam String userId,
            @RequestParam String Pw) {
        List<Account> accounts = clientService.getAllAccountsForUser(userId, Pw);
        if (accounts != null) {
            if (accounts.isEmpty()) {
                return ResponseEntity.ok("계좌가 없습니다.");
            }
            return ResponseEntity.ok(accounts);
        } else {
            return ResponseEntity.status(403).body("사용자 인증에 실패했습니다. 사용자 ID나 비밀번호를 확인해 주세요.");
        }
    }

    @PostMapping("/deposit")
    public ResponseEntity<String> deposit(
            @RequestParam String userId,
            @RequestParam String pw,
            @RequestParam String accountNumber,
            @RequestParam double depositAmount) {

        Account account = clientService.deposit(userId, pw, accountNumber, depositAmount);
        if (account != null) {
            String message = String.format(
                    "입금이 완료되었습니다.\n계좌번호: %s\n입금액: %.2f원\n현재 잔액: %.2f원",
                    account.getAccountNumber(),
                    depositAmount,
                    account.getBalance()
            );
            return ResponseEntity.ok(message);
        } else {
            String message = "입금에 실패했습니다. 사용자 ID, 비밀번호 또는 계좌번호를 확인해 주세요.";
            return ResponseEntity.badRequest().body(message);
        }
    }

    @PostMapping("/withdraw")
    public ResponseEntity<String> withdraw(
            @RequestParam String userId,
            @RequestParam String pw,
            @RequestParam String accountNumber,
            @RequestParam double withdrawAmount) {

        Account account = clientService.withdraw(userId, pw, accountNumber, withdrawAmount);
        if (account != null) {
            String message = String.format(
                    "출금이 완료되었습니다.\n계좌번호: %s\n출금액: %.2f원\n현재 잔액: %.2f원",
                    account.getAccountNumber(),
                    withdrawAmount,
                    account.getBalance()
            );
            return ResponseEntity.ok(message);
        } else {
            String message = "출금에 실패했습니다. 사용자 ID, 비밀번호, 계좌번호를 확인하거나 출금액이 잔액을 초과하지 않는지 확인해 주세요.";
            return ResponseEntity.badRequest().body(message);
        }
    }


}
