package com.jufeng.springboot.example007;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
public class App  implements CommandLineRunner {

    @Autowired
    private Test test;

    @Autowired
    private JufengPropterties jufengPropterties;

    @Autowired
    private  MyPropterties myPropterties;
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(test.getName());
        System.out.println(test.getSecret());
        System.out.println(test.getBignumber());
        System.out.println(test.getNumberInt());
        System.out.println(test.getUuid());
        System.out.println("====================");
        System.out.println(jufengPropterties.getGender());
        System.out.println(jufengPropterties.getName());
        System.out.println("====================");
        System.out.println(myPropterties.getNumber());
    }
}