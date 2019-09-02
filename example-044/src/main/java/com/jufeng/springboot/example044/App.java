package com.jufeng.springboot.example044;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


@SpringBootApplication(
        exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class
        , JdbcTemplateAutoConfiguration.class}
)
public class App implements CommandLineRunner {


    @Autowired
    @Qualifier("oneJdbcTemplate")
    private JdbcTemplate oneJdbcTemplate;


    @Autowired
    @Qualifier("twoJdbcTemplate")
    private JdbcTemplate twoJdbcTemplate;


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      List list =  oneJdbcTemplate.queryForList("select * from litemall_ad");
        System.out.println(list);
        List list2 =  twoJdbcTemplate.queryForList("select * from litemall_ad");
        System.out.println(list2);
        twoJdbcTemplate.queryForList("select * from litemall_ad");
        twoJdbcTemplate.queryForList("select * from litemall_ad");
        twoJdbcTemplate.queryForList("select * from litemall_ad");
        twoJdbcTemplate.queryForList("select * from litemall_ad");
        twoJdbcTemplate.queryForList("select * from litemall_ad");
        twoJdbcTemplate.queryForList("select * from litemall_ad");
        twoJdbcTemplate.queryForList("select * from litemall_ad");
        twoJdbcTemplate.queryForList("select * from litemall_ad");
        twoJdbcTemplate.queryForList("select * from litemall_ad");
        twoJdbcTemplate.queryForList("select * from litemall_ad");
        twoJdbcTemplate.queryForList("select * from litemall_ad");
        twoJdbcTemplate.queryForList("select * from litemall_ad");
        twoJdbcTemplate.queryForList("select * from litemall_ad");
        twoJdbcTemplate.queryForList("select * from litemall_ad");
        twoJdbcTemplate.queryForList("select * from litemall_ad");
        twoJdbcTemplate.queryForList("select * from litemall_ad");
    }
}