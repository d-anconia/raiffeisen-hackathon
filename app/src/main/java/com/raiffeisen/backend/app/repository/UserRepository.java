package com.raiffeisen.backend.app.repository;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class UserRepository {


    private final String GET_USER_ID = "select user_id from users where username = ? and pass = ?";


    private final String GET_USER_NAME = "select client from users where user_id = ?";

    private final String GET_BALANCE_BY_ACCOUNT_ID = "select balance from account where user_id = ?";


    private final JdbcTemplate jdbcTemplate;

    public UserRepository(@Qualifier("postgre-db") final HikariDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public Long getUserId(String username, String password) {
        try {
            return jdbcTemplate.queryForObject(GET_USER_ID, new Object[]{username, password}, (rs, rowNum) -> rs.getLong("user_id"));
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return null;
        }
    }

    public String getFullNameByUserId(Long userId) {
        return jdbcTemplate.queryForObject(GET_USER_NAME, new Object[]{userId}, (rs, rowNum) -> rs.getString("client"));
    }

}
