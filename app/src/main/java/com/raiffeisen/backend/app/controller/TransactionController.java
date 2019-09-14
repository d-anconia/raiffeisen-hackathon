package com.raiffeisen.backend.app.controller;

import com.raiffeisen.backend.app.repository.model.Transaction;
import com.raiffeisen.backend.app.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;


    @GetMapping("/transaction")
    public List<Transaction> getTransactions(@RequestParam("user_id") Long userid) {
        return transactionService.getAllTransactions(userid);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(value = "/saveTransaction")
    public @ResponseBody
    void saveTransaction(@RequestBody Transaction transaction) {
        transactionService.saveTransaction(transaction);
    }
}
