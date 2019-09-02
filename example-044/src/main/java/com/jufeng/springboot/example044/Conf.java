package com.jufeng.springboot.example044;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-09-02 14:17
 **/
@Slf4j
@Configuration
public class Conf {

    @Bean
    @ConfigurationProperties("one.datasource")
    public DataSourceProperties oneDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
   // @Primary
    public DataSource oneDataSource(){
        DataSourceProperties properties = oneDataSourceProperties();
        log.info("url: {}" , properties.getUrl());
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean
    @Resource
    public PlatformTransactionManager oneransactionManager(DataSource oneDataSource){
        return new DataSourceTransactionManager(oneDataSource);
    }


    @Bean
    @ConfigurationProperties("two.datasource")
    public DataSourceProperties twoDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    public DataSource twoDataSource(){
        DataSourceProperties properties = twoDataSourceProperties();
        log.info("url: {}" , properties.getUrl());
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean
    @Resource
    public PlatformTransactionManager tworansactionManager(DataSource twoDataSource){
        return new DataSourceTransactionManager(twoDataSource);
    }


    //JdbcTemplate主数据源
   // @Primary
    @Bean(name = "oneJdbcTemplate")
    public JdbcTemplate oneJdbcTemplate(@Qualifier("oneDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    //JdbcTemplate第二个数据源
    @Bean(name = "twoJdbcTemplate")
    public JdbcTemplate twoJdbcTemplate(@Qualifier("twoDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
