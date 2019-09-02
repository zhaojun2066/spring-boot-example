package com.jufeng.springboot.example044;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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

}
