package com.keysolbo.coreservice.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class Database {
    @Bean(name = "coreDb")
    @ConfigurationProperties(prefix = "spring.datasource.core")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "coreTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("coreDb") DataSource ds) {
        return new JdbcTemplate(ds);
    }
}
