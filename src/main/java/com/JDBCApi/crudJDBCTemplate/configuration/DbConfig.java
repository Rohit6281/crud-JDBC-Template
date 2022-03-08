package com.JDBCApi.crudJDBCTemplate.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    @Bean
    public DataSource dataSource(){

        var data = new DriverManagerDataSource();
        data.setDriverClassName("com.mysql.cj.jdbc.Driver");
        data.setUrl("jdbc:mysql://localhost:3306/jdbc_template");
        data.setUsername("root");
        data.setPassword("password");
        return data;
    }
}
