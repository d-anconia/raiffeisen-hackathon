package com.raiffeisen.backend.app.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;


@org.springframework.web.bind.annotation.RestController
@Slf4j
public class RestController {


    @GetMapping("/hello")

    public String hello() {

        return "Hello world";
    }


    @GetMapping("/login")
    public Long loging(){


        return 0L;
    }




}
