package com.example.bankaccount.Controller;

import com.example.bankaccount.Service.BankerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class BankForAdminController {

    private final BankerService bankerService;

    public BankForAdminController(BankerService bankerService) {
        this.bankerService = bankerService;
    }

    @GetMapping("/info")
    public ResponseEntity<?> AdminClientInfo(
            @RequestParam String inputAdminId,
            @RequestParam String inputAdminPw,
            @RequestParam String inputUserName,
            @RequestParam String inputUserId) {


        List<Object> clientInfo = bankerService.getClientInfo(inputAdminId, inputAdminPw, inputUserName, inputUserId);
        if (clientInfo != null) {
            return ResponseEntity.ok(clientInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
