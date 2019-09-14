package com.raiffeisen.backend.app.repository.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    private Long accountId;
    private Long userId;
    private BigDecimal balance;
    private boolean isForSelf;
    private String cardName;
}
