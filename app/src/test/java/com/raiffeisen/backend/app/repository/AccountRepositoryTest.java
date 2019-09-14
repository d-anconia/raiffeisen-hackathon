package com.raiffeisen.backend.app.repository;

import com.raiffeisen.backend.app.repository.model.Account;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AccountRepositoryTest {


    @Autowired
    private AccountRepository accountRepository;


    @Test
    public void test(){

        Account accountsByUserId = accountRepository.getAccountsForSelfByUserId(1L);



    }

}