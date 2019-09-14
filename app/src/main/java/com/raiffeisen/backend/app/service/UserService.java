package com.raiffeisen.backend.app.service;

import com.raiffeisen.backend.app.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class UserService {


    @Autowired
    private UserRepository userRepository;


    public Long getUser(String username, String password) {
        return userRepository.getUserId(username, password);
    }

    public BigDecimal getBalance(Long userId){
        return null;
    }

}
