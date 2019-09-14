package com.raiffeisen.backend.app.service;

import com.raiffeisen.backend.app.repository.model.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TransactionServiceTest {


    @Autowired
    private TransactionService transactionService;


    @Test
    public void test() {

        long date = new Date().getTime();
        System.out.println();

        List<Transaction> allTransactions = transactionService.getAllTransactions(1L);

        Transaction transaction = Transaction.builder()
                .accountFrom(3L)
                .accountTo(2L)
                .volume(new BigDecimal(100))
                .date(new Date().getTime())
                .build();
        transactionService.saveTransaction(transaction);


    }
}