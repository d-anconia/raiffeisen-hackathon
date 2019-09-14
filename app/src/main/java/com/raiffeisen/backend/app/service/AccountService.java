package com.raiffeisen.backend.app.service;

import com.raiffeisen.backend.app.repository.AccountRepository;
import com.raiffeisen.backend.app.repository.model.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;


    public Account getAccountInfo(Long userId) {
        return accountRepository.getAccountsForSelfByUserId(userId);
    }
}
