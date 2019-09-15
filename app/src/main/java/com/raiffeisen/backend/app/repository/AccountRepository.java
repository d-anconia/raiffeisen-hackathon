package com.raiffeisen.backend.app.repository;

import com.raiffeisen.backend.app.repository.model.Account;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.RoundingMode;

@Repository
@Slf4j
public class AccountRepository {


    private final String GET_ACCOUNTS_OF_USER = "select * from account where user_id = ? and isforself = true";

    private final String GET_ACCOUNT = "select * from account where user_id = ?";

    private final JdbcTemplate jdbcTemplate;

    public AccountRepository(@Qualifier("postgre-db") final HikariDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public Account getAccountsForSelfByUserId(Long userId) {
        return jdbcTemplate.queryForObject(GET_ACCOUNTS_OF_USER, new Object[]{userId}, getAccountRowMapper());
    }

    public Account getAccount(Long userId) {
        return jdbcTemplate.queryForObject(GET_ACCOUNT, new Object[]{userId}, getAccountRowMapper());
    }

    private RowMapper<Account> getAccountRowMapper() {
        return (rs, rowNum) -> Account.builder()
                .accountId(rs.getLong("account_id"))
                .userId(rs.getLong("user_id"))
                .balance(rs.getBigDecimal("balance").setScale(2, RoundingMode.HALF_EVEN))
                .isForSelf(rs.getBoolean("isforself"))
                .cardName(rs.getString("cardname"))
                .build();
    }
}
