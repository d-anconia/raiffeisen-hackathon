package com.raiffeisen.backend.app.repository;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {


    private final String GET_USER_ID = "select id from user where username = ? and password = ?";

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(@Qualifier("postgre-db") final HikariDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public Long getUserId(String username, String password) {
        return jdbcTemplate.queryForObject(GET_USER_ID, new Object[]{username, password}, (rs, rowNum) -> rs.getLong("ID"));
    }
}
