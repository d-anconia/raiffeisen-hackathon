package com.raiffeisen.backend.app.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class Config {


    @Bean(name = "postgre-db")
    @ConfigurationProperties("database.hikari")
    public HikariDataSource getPostgreSqlDb() {
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean(name = "postgre-tx")
    @Autowired
    public DataSourceTransactionManager transactionManagerSpectr(@Qualifier("postgre-db") DataSource datasource) {
        return new DataSourceTransactionManager(datasource);
    }
}
