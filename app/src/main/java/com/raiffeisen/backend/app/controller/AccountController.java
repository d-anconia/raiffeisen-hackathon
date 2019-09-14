package com.raiffeisen.backend.app.controller;

import com.raiffeisen.backend.app.repository.model.Account;
import com.raiffeisen.backend.app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;


    @GetMapping("/account")
    public Map<String, Object> getAccount(@RequestParam("user_id") Long user_id) {

        Account accountInfo = accountService.getAccountInfo(user_id);

        Map<String, Object> map = new HashMap<>();

        map.put("balance", accountInfo.getBalance());
        map.put("cardname", accountInfo.getCardName());

        return map;
    }


}
