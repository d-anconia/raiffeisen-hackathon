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
public class Transaction {

    private Long accountFrom;
    private Long accountTo;
    private BigDecimal volume;
    private String fromName;
    private Long date;
    private boolean iscash;

}
