package com.raiffeisen.backend.app.repository;

import com.raiffeisen.backend.app.repository.model.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Month;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TransactionRepositoryTest {


    @Autowired
    private TransactionRepository transactionRepository;


    @Test
    public void test(){

//        long dateFrom = new Date(2019, Month.SEPTEMBER.getValue(), 10).getTime();
//        long dateTo = new Date(2019, Month.SEPTEMBER.getValue(), 16).getTime();


        Date dateFrom = new Date(2019, Month.SEPTEMBER.getValue()-1, 10);
        Date dateTo = new Date(2019, Month.SEPTEMBER.getValue()-1, 16);

        System.out.println();

        List<Transaction> allTransactions = transactionRepository.getAllTransactions(2L);


    }
}