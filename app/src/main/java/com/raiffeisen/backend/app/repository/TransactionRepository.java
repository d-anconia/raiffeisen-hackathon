package com.raiffeisen.backend.app.repository;

import com.raiffeisen.backend.app.repository.model.Transaction;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
@Slf4j
public class TransactionRepository {


    private final String GET_TRANSACTIONS = "select * from transactions where account_to = ?";

    private final String SAVE_TRANSACTION_ISCASH = "insert into transactions(account_from, account_to, volume, time_of_transaction,iscash) values (?,?,?,?,?) ";

    private final JdbcTemplate jdbcTemplate;

    public TransactionRepository(@Qualifier("postgre-db") final HikariDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Transactional
    public void saveTransaction(Transaction transaction) {
        jdbcTemplate.update(SAVE_TRANSACTION_ISCASH, getParams(transaction));
    }

    @Transactional
    public List<Transaction> getAllTransactions(Long account_to) {

        return jdbcTemplate.query(GET_TRANSACTIONS, new Object[]{account_to}, getTransactionRowMapper());

    }

    private RowMapper<Transaction> getTransactionRowMapper() {
        return (rs, rowNum) -> Transaction.builder()
                .accountFrom(rs.getLong("account_from"))
                .accountTo(rs.getLong("account_to"))
                .volume(rs.getBigDecimal("volume"))
                .date(rs.getDate("time_of_transaction").getTime())
                .iscash(rs.getBoolean("iscash"))
                .build();
    }


    private Object[] getParams(final Transaction transaction) {
        final Object[] params = new Object[5];

        params[0] = transaction.getAccountFrom();
        params[1] = transaction.getAccountTo();
        params[2] = transaction.getVolume();
        params[3] = new Date(transaction.getDate());
        params[4] = true;

        return params;
    }

}
