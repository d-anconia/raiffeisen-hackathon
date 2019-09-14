package com.raiffeisen.backend.app.repository;

import com.raiffeisen.backend.app.repository.model.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TransactionRepositoryTest {


    @Autowired
    private TransactionRepository transactionRepository;


    @Test
    public void test(){

        List<Transaction> allTransactions = transactionRepository.getAllTransactions(2L);

    }
}