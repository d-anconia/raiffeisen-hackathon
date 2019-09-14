package com.raiffeisen.backend.app.controller;


import com.raiffeisen.backend.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


@RestController
@Slf4j
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public Map<String, Long> loging(@RequestParam("username") String username, @RequestParam("password") String password) {

        Map<String, Long> map = new HashMap<>();
        Long user_id = userService.getUser(username, password);
        map.put("user_id", user_id);
        return map;
    }

    @GetMapping("user/getBalance")
    public Map<String, BigDecimal> getBalance(@RequestParam("user_id") Long userId) {
        Map<String, BigDecimal> map = new HashMap<>();


        return map;
    }

}
