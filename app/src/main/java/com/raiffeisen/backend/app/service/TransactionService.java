package com.raiffeisen.backend.app.service;

import com.raiffeisen.backend.app.repository.AccountRepository;
import com.raiffeisen.backend.app.repository.TransactionRepository;
import com.raiffeisen.backend.app.repository.UserRepository;
import com.raiffeisen.backend.app.repository.model.Account;
import com.raiffeisen.backend.app.repository.model.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;


    public List<Transaction> getAllTransactions(Long userId) {

        Account accountsForSelf = accountRepository.getAccountsForSelfByUserId(userId);

        List<Transaction> allTransactions = transactionRepository.getAllTransactions(accountsForSelf.getAccountId());

        return allTransactions.stream()
                .peek(transaction -> transaction.setFromName(userRepository.getFullNameByUserId(userId)))
                .collect(Collectors.toList());
    }

}
