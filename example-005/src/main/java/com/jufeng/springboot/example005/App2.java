package com.jufeng.springboot.example005;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App2 implements ApplicationRunner {
    public static void main(String[] args) {
        System.out.println("开始");
        SpringApplication.run(App2.class, args);
        System.out.println("结束");
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("SpringApplication.run(.) 完成之前调用，此时bean 已经初始化完成了");
    }
}