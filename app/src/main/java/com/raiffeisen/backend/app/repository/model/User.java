package com.raiffeisen.backend.app.repository.model;

import lombok.Data;

@Data
public class User {

    private Long id;
    private String username;
    private String password;

}
