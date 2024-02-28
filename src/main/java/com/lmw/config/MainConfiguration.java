package com.lmw.config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.lmw.mapper")
@ComponentScans({
        @ComponentScan("com.lmw.entity"),
        @ComponentScan("com.lmw.service"),
        @ComponentScan("com.lmw.controller")
})
public class MainConfiguration {

    @Bean
    public DataSource dataSource() {
        return new PooledDataSource(
                "com.mysql.jdbc.Driver",
                "jdbc:mysql://localhost:3306/book_manage",
                "root", "123456");
    }

    @Bean
    public SqlSessionFactoryBean factoryBean(DataSource dataSource) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean;
    }
}
