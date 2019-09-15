package com.raiffeisen.backend.app.service;

import com.raiffeisen.backend.app.repository.AccountRepository;
import com.raiffeisen.backend.app.repository.TransactionRepository;
import com.raiffeisen.backend.app.repository.UserRepository;
import com.raiffeisen.backend.app.repository.model.Account;
import com.raiffeisen.backend.app.repository.model.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
                .peek(transaction -> {
                    Account account = accountRepository.getAccount(transaction.getAccountFrom());
                    transaction.setFromName(userRepository.getFullNameByUserId(account.getUserId()));
                })
                .collect(Collectors.toList());
    }

    public List<Transaction> getTransactionsInPeriod(Long userId, Long dateFrom, Long dateTo) {

        Account accountsForSelf = accountRepository.getAccountsForSelfByUserId(userId);
        List<Transaction> allTransactions = transactionRepository.getAllTransactions(accountsForSelf.getAccountId());


        return allTransactions.stream()
                .peek(transaction -> {
                    Account account = accountRepository.getAccount(transaction.getAccountFrom());
                    transaction.setFromName(userRepository.getFullNameByUserId(account.getUserId()));
                })
                .filter(transaction -> transaction.getDate() > dateFrom && transaction.getDate() < dateTo)
                .collect(Collectors.toList());

    }

    @Transactional
    public void saveTransaction(Transaction transaction) {

        try {
            transactionRepository.saveTransaction(transaction);
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
        }
    }

    @Transactional
    public void countTax(Long userFromId) {


    }

}
